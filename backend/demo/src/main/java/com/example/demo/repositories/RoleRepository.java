package com.example.demo.repositories;

import com.example.demo.DButil;
import com.example.demo.models.Role;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Repository
public class RoleRepository {

    //GET ALL
    public List<Role> getAllRoles(){
        Connection conn = null;
        ArrayList<Role> result = null;
        PreparedStatement ps = null;

        try{
            conn = DButil.getConnection();
            result = new ArrayList<>();
            String commandText = "SELECT * FROM uloga";
            ps = conn.prepareStatement(commandText);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Role r = new Role(
                        rs.getInt("id"),
                        rs.getString("naziv")
                );
                result.add(r);
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
    public Role getRoleById(int id){
        Connection conn = null;
        Role result = null;
        PreparedStatement ps = null;

        try{
            conn = DButil.getConnection();
            String commandText = "SELECT * FROM uloga WHERE id = ?";
            ps = conn.prepareStatement(commandText);
            ps.setInt(1 , id);
            ResultSet rs = ps.executeQuery();

            if(!rs.next()){
                throw new Exception("Non existing role");
            }

            result = new Role(rs.getInt("id"), rs.getString("naziv"));
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
    public int insertRole(Role role){
        Connection conn = null;
        int result = 0;
        PreparedStatement ps = null;

        try{
            conn = DButil.getConnection();
            String commandText = "INSERT INTO uloga(naziv) VALUES(?)";
            ps = conn.prepareStatement(commandText);
            ps.setString(1, role.getNaziv());

            int affectedRows = ps.executeUpdate();
            if(affectedRows == 0){
                throw new Exception("Error while inserting role");
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
    public int updateRole(int id, Role role){
        Connection conn = null;
        int result = 0;
        PreparedStatement ps = null;

        try {
            conn = DButil.getConnection();
            String commandText = "UPDATE uloga SET naziv = ? WHERE id = ?";
            ps = conn.prepareStatement(commandText);
            ps.setString(1, role.getNaziv());
            ps.setInt(2, id);

            int affectedRows = ps.executeUpdate();
            if(affectedRows == 0){
                throw new Exception("Error while updating role");
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
    public int deleteRole(int id){
        Connection conn = null;
        int result = 0;
        PreparedStatement ps = null;

        try{
            conn = DButil.getConnection();
            String commandText = "DELETE FROM uloga WHERE id = ?";
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
