package com.example.demo.repositories;

import com.example.demo.DButil;
import com.example.demo.models.User;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.math.BigDecimal;


@Repository
public class UserRepository {

    //GET ALL
    public List<User> getAllUsers(){
        Connection conn = null;
        ArrayList<User> result = null;
        PreparedStatement ps = null;
        ResultSet rs = null; // Dodato rs ovde da bi bio dostupan u finally

        try{
            conn = DButil.getConnection();
            result = new ArrayList<>();
            String commandText = "SELECT * FROM korisnik";
            ps = conn.prepareStatement(commandText);
            rs = ps.executeQuery(); // Premesteno dodeljivanje rs

            while(rs.next()){
                User u = new User(
                        rs.getInt("id"),
                        rs.getString("ime"),
                        rs.getString("prezime"),
                        rs.getString("email"),
                        rs.getString("password_hash"),
                        rs.getObject("visina", Integer.class), // Ispravljeno čitanje Integer
                        rs.getBigDecimal("tezina"),
                        rs.getDate("datum_rodjenja"),
                        rs.getInt("uloga_id"),
                        rs.getObject("teretana_pib", Integer.class) // Ispravljeno čitanje Integer
                );
                result.add(u);
            }

            // conn.close(); // Ne zatvarati konekciju ovde, već u finally
            // ps.close(); // Ne zatvarati ps ovde, već u finally

        }
        catch (Exception e){
            result = null;
            System.out.println(e); // Vraćeno na originalni catch
        }
        finally {
            try {
                if(rs != null) rs.close(); // Dodato zatvaranje ResultSet-a
                if(ps != null) ps.close();
                if(conn != null) conn.close();
            } catch (Exception e) { // Vraćeno na originalni finally catch
                throw new RuntimeException(e);
            }
        }

        return result;
    }

    //GET BY ID
    public User getUserById(int id){
        Connection conn = null;
        User result = null;
        PreparedStatement ps = null;
        ResultSet rs = null; // Dodato rs ovde da bi bio dostupan u finally

        try {
            conn = DButil.getConnection();
            String commandText = "SELECT * FROM korisnik WHERE id = ?";
            ps = conn.prepareStatement(commandText);
            ps.setInt(1, id);
            rs = ps.executeQuery(); // Premesteno dodeljivanje rs

            // Originalna provera postojanja korisnika je bila unutar IF-a, što je ispravno
            if(rs.next()){ // Provera pre čitanja
                result = new User(
                        rs.getInt("id"),
                        rs.getString("ime"),
                        rs.getString("prezime"),
                        rs.getString("email"),
                        rs.getString("password_hash"),
                        rs.getObject("visina", Integer.class), // Ispravljeno čitanje Integer
                        rs.getBigDecimal("tezina"),
                        rs.getDate("datum_rodjenja"),
                        rs.getInt("uloga_id"),
                        rs.getObject("teretana_pib", Integer.class) // Ispravljeno čitanje Integer
                );
            } else {
                // Originalni kod nije imao else blok ovde, samo proveru if(!rs.next()) pre čitanja
                // Ako želite logiku za nepostojećeg korisnika, dodajte je ovde ili vratite null kako jeste
                System.out.println("Non existing user with id: " + id); // Primer logovanja
            }


            // conn.close(); // Ne zatvarati konekciju ovde, već u finally
            // ps.close(); // Ne zatvarati ps ovde, već u finally
        }
        catch (Exception e){
            result = null;
            System.out.println(e); // Vraćeno na originalni catch
            // Originalni kod je bacao Exception("Non existing user") ako rs.next() vrati false,
            // ali to bi trebalo da se desi pre čitanja podataka.
            // Ostavljam catch kakav ste imali.
        }
        finally {
            try {
                if(rs != null) rs.close(); // Dodato zatvaranje ResultSet-a
                if(ps != null) ps.close();
                if(conn != null) conn.close();
            } catch (Exception e) { // Vraćeno na originalni finally catch
                throw new RuntimeException(e);
            }
        }

        return result;

    }

    //INSERT
    public int insertUser(User user){
        Connection conn = null;
        int result = 0; // Originalno: 0 za neuspeh, 1 za uspeh
        PreparedStatement ps = null;

        try{
            conn = DButil.getConnection();
            String commandText = "INSERT INTO korisnik(ime, prezime, email, password_hash, visina, tezina, datum_rodjenja, uloga_id, " +
                    "teretana_pib)" + " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
            ps = conn.prepareStatement(commandText);
            ps.setString(1, user.getIme());
            ps.setString(2, user.getPrezime());
            ps.setString(3, user.getEmail());
            ps.setString(4, user.getPassword_hash());

            if (user.getVisina() != null) {
                ps.setInt(5, user.getVisina());
            } else {
                ps.setNull(5, Types.INTEGER);
            }

            if (user.getTezina() != null) {
                ps.setBigDecimal(6, user.getTezina());
            } else {
                ps.setNull(6, Types.DECIMAL);
            }

            if (user.getDatum_rodjenja() != null) {
                ps.setDate(7, user.getDatum_rodjenja());
            } else {
                ps.setNull(7, Types.DATE);
            }

            ps.setInt(8, user.getUloga_id());

            if (user.getTeretana_pib() != null) {
                ps.setInt(9, user.getTeretana_pib());
            } else {
                ps.setNull(9, Types.INTEGER);
            }


            int affectedRows = ps.executeUpdate();
            if(affectedRows == 0){
                System.out.println("Error while inserting user");
            } else {
                result = 1;
            }

            conn.close();
            ps.close();

        }
        catch (Exception e){
            result = -1;
            System.out.println(e);
        }
        finally {
            try {
                if(ps != null) ps.close();
                if(conn != null) conn.close();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        return result;
    }

    //UPDATE
    public int updateUser(int id, User user){
        Connection conn = null;
        int result = 0;
        PreparedStatement ps = null;

        try{
            conn = DButil.getConnection();
            String commandText = "UPDATE korisnik SET ime = ?, prezime = ?, email = ?, password_hash = ?, visina = ?, " +
                    "tezina = ?, datum_rodjenja = ?, uloga_id = ?, teretana_pib = ?" + " WHERE id = ?";
            ps = conn.prepareStatement(commandText);
            ps.setString(1, user.getIme());
            ps.setString(2, user.getPrezime());
            ps.setString(3, user.getEmail());
            ps.setString(4, user.getPassword_hash());

            if (user.getVisina() != null) {
                ps.setInt(5, user.getVisina());
            } else {
                ps.setNull(5, Types.INTEGER);
            }

            if (user.getTezina() != null) {
                ps.setBigDecimal(6, user.getTezina());
            } else {
                ps.setNull(6, Types.DECIMAL);
            }

            if (user.getDatum_rodjenja() != null) {
                ps.setDate(7, user.getDatum_rodjenja());
            } else {
                ps.setNull(7, Types.DATE);
            }

            ps.setInt(8, user.getUloga_id());

            if (user.getTeretana_pib() != null) {
                ps.setInt(9, user.getTeretana_pib());
            } else {
                ps.setNull(9, Types.INTEGER);
            }

            ps.setInt(10, id);

            int affectedRows = ps.executeUpdate();
            if(affectedRows == 0){
                System.out.println("Error while updating user");
            } else {
                result = 1;
            }

            conn.close();
            ps.close();
        }
        catch (Exception e){
            result = -1;
            System.out.println(e);
        }
        finally {
            try {
                if(ps != null) ps.close();
                if(conn != null) conn.close();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        return result;

    }

    //DELETE
    public int deleteUser(int id){
        Connection conn = null;
        int result = 0;
        PreparedStatement ps = null;

        try{
            conn = DButil.getConnection();
            String commandText = "DELETE FROM korisnik WHERE id = ?";
            ps = conn.prepareStatement(commandText);
            ps.setInt(1, id);

            int affectedRows = ps.executeUpdate();
            if(affectedRows == 0){
                System.out.println("Error while updating user");
            } else {
                result = 1;
            }

            conn.close();
            ps.close();

        }
        catch (Exception e){
            result = -1;
            System.out.println(e);
        }
        finally {
            try {
                if(ps != null) ps.close();
                if(conn != null) conn.close();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        return result;
    }
}