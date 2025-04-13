package com.example.demo.repositories;

import com.example.demo.DButil;
import com.example.demo.models.Gym;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Repository
public class GymRepository {

    //GET ALL
    public List<Gym> getAllGyms(){
        Connection conn = null;
        ArrayList<Gym> result = null;
        PreparedStatement ps = null;

        try{
            conn = DButil.getConnection();
            result = new ArrayList<>();
            String commandText = "SELECT * FROM teretana";
            ps = conn.prepareStatement(commandText);
            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                Gym g = new Gym(
                        rs.getInt("pib"),
                        rs.getString("naziv"),
                        rs.getString("adresa"),
                        rs.getString("grad"),
                        rs.getString("drzava"),
                        rs.getInt("clanarina_eur"),
                        rs.getInt("vlasnik_id")
                );
                result.add(g);
            }

            conn.close();
            ps.close();

        }
        catch (Exception e){
            result = null;
            System.out.println(e);
        }
        finally {
            try {
                if(conn != null) conn.close();
                if(ps != null) ps.close();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        return result;
    }

    //GET BY pib
    public Gym getGymByPib(int pib){
        Connection conn = null;
        Gym result = null;
        PreparedStatement ps = null;

        try {
            conn = DButil.getConnection();
            String commandText = "SELECT * FROM teretana WHERE pib = ?";
            ps = conn.prepareStatement(commandText);
            ps.setInt(1, pib);
            ResultSet rs = ps.executeQuery();

            if(!rs.next()){
                throw new Exception("Non existing gym");
            }

            result = new Gym(
                    rs.getInt("pib"),
                    rs.getString("naziv"),
                    rs.getString("adresa"),
                    rs.getString("grad"),
                    rs.getString("drzava"),
                    rs.getInt("clanarina_eur"),
                    rs.getInt("vlasnik_id")
            );

            conn.close();
            ps.close();
        }
        catch (Exception e){
            result = null;
            System.out.println(e);
        }
        finally {
            try {
                if(conn != null) conn.close();
                if(ps != null) ps.close();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        return result;
    }

    //INSERT
    public int insertGym(Gym gym){
        Connection conn = null;
        int result = 0;
        PreparedStatement ps = null;

        try{
            conn = DButil.getConnection();
            String commandText = "INSERT INTO teretana(pib, naziv, adresa, grad, drzava, clanarina_eur, vlasnik_id)" +
                    " VALUES(?, ?, ?, ?, ?, ?, ?)";
            ps = conn.prepareStatement(commandText);
            ps.setInt(1, gym.getPib());
            ps.setString(2, gym.getNaziv());
            ps.setString(3, gym.getAdresa());
            ps.setString(4, gym.getGrad());
            ps.setString(5, gym.getDrzava());
            ps.setInt(6, gym.getClanarina_eur());
            ps.setInt(7, gym.getVlasnik_id());

            int affectedRows = ps.executeUpdate();
            if(affectedRows == 0){
                throw new Exception("Error while inserting gym");
            }

            result = 1;
            conn.close();
            ps.close();
        }
        catch (Exception e){
            result = -1;
            System.out.println(e);
        }
        finally {
            try {
                if(conn != null) conn.close();
                if(ps != null) ps.close();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        return result;
    }

    //UPDATE
    public int updateGym(int pib, Gym gym){
        Connection conn = null;
        int result = 0;
        PreparedStatement ps = null;

        try{
            conn = DButil.getConnection();
            String commandText = "UPDATE teretana SET naziv = ?, adresa = ?, grad = ?, drzava = ?, clanarina_eur = ?, vlasnik_id = ?" +
                    " WHERE pib = ?";
            ps = conn.prepareStatement(commandText);
            ps.setString(1, gym.getNaziv());
            ps.setString(2, gym.getAdresa());
            ps.setString(3, gym.getGrad());
            ps.setString(4, gym.getDrzava());
            ps.setInt(5, gym.getClanarina_eur());
            ps.setInt(6, gym.getVlasnik_id());
            ps.setInt(7, pib);

            int affectedRows = ps.executeUpdate();
            if(affectedRows == 0){
                throw new Exception("Error while updating gym");
            }

            result = 1;
            conn.close();
            ps.close();
        }
        catch (Exception e){
            result = -1;
            System.out.println(e);
        }
        finally {
            try {
                if(conn != null) conn.close();
                if(ps != null) ps.close();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        return result;
    }

    //DELETE
    public int deleteGym(int pib){
        Connection conn = null;
        int result = 0;
        PreparedStatement ps = null;

        try{
            conn = DButil.getConnection();
            String commandText = "DELETE FROM teretana WHERE pib = ?";
            ps = conn.prepareStatement(commandText);
            ps.setInt(1, pib);

            int affectedRows = ps.executeUpdate();
            if(affectedRows == 0){
                throw new Exception("Error while deleting gym");
            }

            result = 1;
            conn.close();
            ps.close();

        }
        catch (Exception e){
            result = -1;
            System.out.println(e);
        }
        finally {
            try {
                if(conn != null) conn.close();
                if(ps != null) ps.close();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        return result;
    }

}
