package com.example.demo.repositories;

import com.example.demo.DButil;
import com.example.demo.models.Meal;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Repository
public class MealRepository {

    //GET ALL
    public List<Meal> getAllMeals(){
        Connection conn = null;
        ArrayList<Meal> result = null;
        PreparedStatement ps = null;

        try{
            conn = DButil.getConnection();
            String commandText = "SELECT * FROM obrok";
            result = new ArrayList<>();
            ps = conn.prepareStatement(commandText);
            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                Meal m = new Meal(
                        rs.getInt("id"),
                        rs.getDate("datum"),
                        rs.getInt("hrana_id"),
                        rs.getInt("korisnik_id")
                );
                result.add(m);
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
    public Meal getMealById(int id){
        Connection conn = null;
        Meal result = null;
        PreparedStatement ps = null;

        try{
            conn = DButil.getConnection();
            String commandText = "SELECT * FROM obrok WHERE id = ?";
            ps = conn.prepareStatement(commandText);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if(!rs.next()){
                throw new Exception("Non existing meal");
            }

            result = new Meal(
                    rs.getInt("id"),
                    rs.getDate("datum"),
                    rs.getInt("hrana_id"),
                    rs.getInt("korisnik_id")
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
    public int insertMeal(Meal meal){
        Connection conn = null;
        int result = 0;
        PreparedStatement ps = null;

        try{
            conn = DButil.getConnection();
            String commandText = "INSERT INTO obrok(datum, hrana_id, korisnik_id) VALUES(?, ?, ?)";
            ps = conn.prepareStatement(commandText);
            ps.setDate(1, meal.getDatum());
            ps.setInt(2, meal.getHrana_id());
            ps.setInt(3, meal.getKorisnik_id());

            int affectedRows = ps.executeUpdate();
            if(affectedRows == 0){
                throw new Exception("Error while inserting meal");
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
    public int updateMeal(int id, Meal meal){
        Connection conn = null;
        int result = 0;
        PreparedStatement ps = null;

        try{
            conn = DButil.getConnection();
            String commandText = "UPDATE obrok SET datum = ?, hrana_id = ?, korisnik_id = ?" + " WHERE id = ?";
            ps = conn.prepareStatement(commandText);
            ps.setDate(1, meal.getDatum());
            ps.setInt(2, meal.getHrana_id());
            ps.setInt(3, meal.getKorisnik_id());
            ps.setInt(4, id);

            int affectedRows = ps.executeUpdate();
            if(affectedRows == 0){
                throw new Exception("Error while updating meal");
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
    public int deleteMeal(int id){
        Connection conn = null;
        int result = 0;
        PreparedStatement ps = null;

        try {
            conn = DButil.getConnection();
            String commandText = "DELETE FROM obrok WHERE id = ?";
            ps = conn.prepareStatement(commandText);
            ps.setInt(1, id);

            int affectedRows = ps.executeUpdate();
            if(affectedRows == 0){
                throw new Exception("Error while deleting meal");
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
