package com.example.demo.repositories;

import com.example.demo.DButil;
import com.example.demo.models.Food;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Repository
public class FoodRepository {

    //GET ALL
    public List<Food> getAllFood(){
        Connection conn = null;
        ArrayList<Food> result = null;
        PreparedStatement ps = null;

        try{
            conn = DButil.getConnection();
            String commandText = "SELECT * FROM hrana";
            result = new ArrayList<>();
            ps = conn.prepareStatement(commandText);
            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                Food f = new Food(
                        rs.getInt("id"),
                        rs.getString("naziv"),
                        rs.getBigDecimal("kalorije"),
                        rs.getBigDecimal("proteini"),
                        rs.getBigDecimal("ugljeni_hidrati"),
                        rs.getBigDecimal("seceri"),
                        rs.getBigDecimal("masti"),
                        rs.getBigDecimal("vlakna"),
                        rs.getBigDecimal("kolicina_gram")
                );
                result.add(f);
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
    public Food getFoodById(int id){
        Connection conn = null;
        Food result = null;
        PreparedStatement ps = null;

        try{
            conn = DButil.getConnection();
            String commandText = "SELECT * FROM hrana WHERE id = ?";
            ps = conn.prepareStatement(commandText);
            ps.setInt(1 , id);
            ResultSet rs = ps.executeQuery();

            if(!rs.next()){
                throw new Exception("Non existing food");
            }
            result = new Food(
                    rs.getInt("id"),
                    rs.getString("naziv"),
                    rs.getBigDecimal("kalorije"),
                    rs.getBigDecimal("proteini"),
                    rs.getBigDecimal("ugljeni_hidrati"),
                    rs.getBigDecimal("seceri"),
                    rs.getBigDecimal("masti"),
                    rs.getBigDecimal("vlakna"),
                    rs.getBigDecimal("kolicina_gram")
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
    public int insertFood(Food food){
        Connection conn = null;
        int result = 0;
        PreparedStatement ps = null;

        try{
            conn = DButil.getConnection();
            String commandText = "INSERT INTO hrana(naziv, kalorije, proteini, ugljeni_hidrati, seceri, vlakna, masti, " +
                    "kolicina_gram)" + " VALUES(?, ?, ?, ?, ?, ?, ?, ?)";

            ps = conn.prepareStatement(commandText);
            ps.setString(1, food.getNaziv());
            ps.setBigDecimal(2, food.getKalorije());
            ps.setBigDecimal(3, food.getProteini());
            ps.setBigDecimal(4, food.getUgljeni_hidrati());
            ps.setBigDecimal(5, food.getSeceri());
            ps.setBigDecimal(6, food.getVlakna());
            ps.setBigDecimal(7, food.getMasti());
            ps.setBigDecimal(8, food.getKolicina_gram());

            int affectedRows = ps.executeUpdate();
            if(affectedRows == 0){
                throw new Exception("Error while inserting food");
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
    public int updateFood(int id, Food food){
        Connection conn = null;
        int result = 0;
        PreparedStatement ps = null;

        try {
            conn = DButil.getConnection();
            String commandText = "UPDATE hrana SET naziv = ?, kalorije = ?, proteini = ?, ugljeni_hidrati = ?, seceri = ?, " +
                    "vlakna = ?, masti = ?, kolicina_gram = ?" + " WHERE id = ?";
            ps = conn.prepareStatement(commandText);
            ps.setString(1, food.getNaziv());
            ps.setBigDecimal(2, food.getKalorije());
            ps.setBigDecimal(3, food.getProteini());
            ps.setBigDecimal(4, food.getUgljeni_hidrati());
            ps.setBigDecimal(5, food.getSeceri());
            ps.setBigDecimal(6, food.getVlakna());
            ps.setBigDecimal(7, food.getMasti());
            ps.setBigDecimal(8, food.getKolicina_gram());
            ps.setInt(9, id);

            int affectedRows = ps.executeUpdate();
            if(affectedRows == 0){
                throw new Exception("Error while inserting food");
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
    public int deleteFood(int id){
        Connection conn = null;
        int result = 0;
        PreparedStatement ps = null;

        try{
            conn = DButil.getConnection();
            String commandText = "DELETE FROM hrana WHERE id = ?";
            ps = conn.prepareStatement(commandText);
            ps.setInt(1, id);

            int affectedRows = ps.executeUpdate();
            if(affectedRows == 0){
                throw new Exception("Error while deleting role");
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
