package com.example.demo.repositories;

import com.example.demo.DButil;
import com.example.demo.models.Training;
import com.example.demo.models.Transaction;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Repository
public class TrainingRepository {
    //GET ALL
    public List<Training> getAllTrainings(){
        Connection conn = null;
        ArrayList<Training> result = null;
        PreparedStatement ps = null;

        try{
            conn = DButil.getConnection();
            result = new ArrayList<>();
            String commandText = "SELECT * FROM trening";
            ps = conn.prepareStatement(commandText);
            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                Training t = new Training(
                        rs.getInt("id"),
                        rs.getDate("datum"),
                        rs.getInt("clan_id"),
                        rs.getInt("tip_treninga_id")
                );
                result.add(t);
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

    //GET BY ID
    public Training getTrainingById(int id){
        Connection conn = null;
        Training result = null;
        PreparedStatement ps = null;

        try{
            conn = DButil.getConnection();
            String commandText = "SELECT * FROM trening WHERE id = ?";
            ps = conn.prepareStatement(commandText);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if(!rs.next()){
                throw new Exception("Non existing training");
            }

            result = new Training(
                    rs.getInt("id"),
                    rs.getDate("datum"),
                    rs.getInt("clan_id"),
                    rs.getInt("tip_treninga_id")
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
    public int insertTraining(Training training){
        Connection conn = null;
        int result = 0;
        PreparedStatement ps = null;

        try{
            conn = DButil.getConnection();
            String commandText = "INSERT INTO trening(datum, clan_id, tip_treninga_id) VALUES(?, ?, ?)";
            ps = conn.prepareStatement(commandText);
            ps.setDate(1,training.getDatum());
            ps.setInt(2, training.getClan_id());
            ps.setInt(3, training.getTip_treninga_id());

            int affectedRows = ps.executeUpdate();
            if(affectedRows == 0){
                throw new Exception("Error while inserting training");
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
    public int updateTraining(int id, Training training){
        Connection conn = null;
        int result = 0;
        PreparedStatement ps = null;

        try{
            conn = DButil.getConnection();
            String commandText = "UPDATE trening SET datum = ?, clan_id = ?, tip_treninga_id = ?";
            ps = conn.prepareStatement(commandText);
            ps.setDate(1,training.getDatum());
            ps.setInt(2, training.getClan_id());
            ps.setInt(3, training.getTip_treninga_id());

            int affectedRows = ps.executeUpdate();
            if(affectedRows == 0){
                throw new Exception("Error while updating training");
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
    public int deleteTraining(int id){
        Connection conn = null;
        int result = 0;
        PreparedStatement ps = null;

        try{
            conn = DButil.getConnection();
            String commandText = "DELETE FROM trening WHERE id = ?";
            ps = conn.prepareStatement(commandText);
            ps.setInt(1, id);

            int affectedRows = ps.executeUpdate();
            if(affectedRows == 0){
                throw new Exception("Error while deleting training");
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
