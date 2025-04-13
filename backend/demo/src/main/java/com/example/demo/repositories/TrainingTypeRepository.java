package com.example.demo.repositories;

import com.example.demo.DButil;
import com.example.demo.models.TrainingType;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Repository
public class TrainingTypeRepository {

    //GET ALL
    public List<TrainingType> getAllTrainingTypes(){
        Connection conn = null;
        ArrayList<TrainingType> result = null;
        PreparedStatement ps = null;

        try{
            conn = DButil.getConnection();
            result = new ArrayList<>();
            String commandText = "SELECT * FROM tip_treninga";
            ps = conn.prepareStatement(commandText);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                TrainingType t = new TrainingType(
                        rs.getInt("id"),
                        rs.getString("naziv")
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
    public TrainingType getTrainingTypeById(int id){
        Connection conn = null;
        TrainingType result = null;
        PreparedStatement ps = null;

        try{
            conn = DButil.getConnection();
            String commandText = "SELECT * FROM tip_treninga WHERE id = ?";
            ps = conn.prepareStatement(commandText);
            ps.setInt(1,id);
            ResultSet rs = ps.executeQuery();

            if(!rs.next()){
                throw new Exception("Non existing training type");
            }

            result = new TrainingType(rs.getInt("id"), rs.getString("naziv"));
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
    public int insertTrainingType(TrainingType trainingType){
        Connection conn = null;
        int result = 0;
        PreparedStatement ps = null;

        try{
            conn = DButil.getConnection();
            String commandText = "INSERT INTO tip_treninga(naziv) VALUES(?)";
            ps = conn.prepareStatement(commandText);
            ps.setString(1, trainingType.getNaziv());

            int affectedRows = ps.executeUpdate();
            if(affectedRows == 0){
                throw new Exception("Error while inserting training type");
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
    public int updateTrainingType(int id, TrainingType trainingType){
        Connection conn = null;
        int result = 0;
        PreparedStatement ps = null;

        try{
            conn = DButil.getConnection();
            String commandText = "UPDATE tip_treninga SET naziv = ? WHERE id = ?";
            ps = conn.prepareStatement(commandText);
            ps.setString(1, trainingType.getNaziv());
            ps.setInt(2, id);

            int affectedRows = ps.executeUpdate();
            if(affectedRows == 0){
                throw new Exception("Error while updating training type");
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
    public int deleteTrainingType(int id){
        Connection conn = null;
        int result = 0;
        PreparedStatement ps = null;

        try{
            conn = DButil.getConnection();
            String commandText = "DELETE FROM tip_treninga WHERE id = ?";
            ps = conn.prepareStatement(commandText);
            ps.setInt(1, id);

            int affectedRows = ps.executeUpdate();
            if(affectedRows == 0){
                throw new Exception("Error while deleting training type");
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
