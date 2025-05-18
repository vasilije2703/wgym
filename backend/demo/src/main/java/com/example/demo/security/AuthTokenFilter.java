package com.example.demo.security;

import com.example.demo.services.CustomUserDetailsService;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.UnsupportedJwtException;
import io.jsonwebtoken.security.SecurityException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils; // Za proveru da li je string prazan
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
// import java.util.List; // Ako preferirate List umesto Collection za authorities

@Component
public class AuthTokenFilter extends OncePerRequestFilter {

    private static final Logger logger = LoggerFactory.getLogger(AuthTokenFilter.class);

    @Autowired
    private JwtUtil jwtUtils;

    @Autowired
    private CustomUserDetailsService userDetailsService;

    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain
    ) throws ServletException, IOException {
        try {
            String jwt = parseJwt(request);
            if (jwt != null && jwtUtils.validateJwtToken(jwt)) {
                String email = jwtUtils.getEmailFromToken(jwt);

                UserDetails userDetails = userDetailsService.loadUserByUsername(email);
                Integer ulogaIdFromToken = jwtUtils.getUlogaIdFromToken(jwt);

                // Kreiramo listu autoriteta (rola) na osnovu uloga_id iz tokena
                Collection<? extends GrantedAuthority> authorities = Collections.emptyList();
                if (ulogaIdFromToken != null) {
                    String roleName = mapUlogaIdToRoleName(ulogaIdFromToken);
                    if (StringUtils.hasText(roleName)) {
                        authorities = Collections.singletonList(new SimpleGrantedAuthority(roleName));
                        logger.debug("Korisnik {} ima rolu {} iz tokena.", email, roleName);
                    } else {
                        logger.warn("Nije moguće mapirati uloga_id {} na naziv role za korisnika {}. Korisnik neće imati role iz tokena.", ulogaIdFromToken, email);
                    }
                } else {
                    logger.warn("uloga_id nije pronađen u JWT tokenu za korisnika: {}. Korisnik neće imati role iz tokena.", email);
                }

                UsernamePasswordAuthenticationToken authentication =
                        new UsernamePasswordAuthenticationToken(
                                userDetails,
                                null,
                                authorities
                        );

                authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));


                SecurityContextHolder.getContext().setAuthentication(authentication);
                logger.debug("Autentifikacija uspešno postavljena za korisnika: {}", email);
            }
        } catch (ExpiredJwtException e) {
            logger.error("JWT token je istekao: {}", e.getMessage());
        } catch (UnsupportedJwtException e) {
            logger.error("JWT token nije podržan: {}", e.getMessage());
        } catch (MalformedJwtException e) {
            logger.error("Neispravan JWT token: {}", e.getMessage());
        } catch (SecurityException e) { // Ovo je preimenovano iz io.jsonwebtoken.security.SecurityException
            logger.error("Neispravan JWT potpis: {}", e.getMessage());
        } catch (IllegalArgumentException e) {
            logger.error("JWT claims string je prazan: {}", e.getMessage());
        } catch (Exception e) {
            logger.error("Neuspešno postavljanje korisničke autentifikacije: {}", e.getMessage(), e);
        }

        filterChain.doFilter(request, response);
    }

    private String parseJwt(HttpServletRequest request) {
        String headerAuth = request.getHeader("Authorization");

        if (StringUtils.hasText(headerAuth) && headerAuth.startsWith("Bearer ")) {
            return headerAuth.substring(7);
        }
        return null;
    }


    private String mapUlogaIdToRoleName(int ulogaId) {
        switch (ulogaId) {
            case 1:
                return "ROLE_ADMIN";
            case 2:
                return "ROLE_VLASNIK";
            case 3:
                return "ROLE_CLAN";
            default:
                logger.warn("Nepoznat uloga_id za mapiranje: {}", ulogaId);
                return null;
        }
    }
}