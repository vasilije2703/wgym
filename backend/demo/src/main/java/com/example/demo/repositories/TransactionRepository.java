package com.example.demo.repositories;

import com.example.demo.DButil;
import com.example.demo.models.Transaction;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Repository
public class TransactionRepository {
    //GET ALL
    public List<Transaction> getAllTransactions(){
        Connection conn = null;
        ArrayList<Transaction> result = null;
        PreparedStatement ps = null;

        try {
            conn = DButil.getConnection();
            result = new ArrayList<>();
            String commandText = "SELECT * FROM transakcija";
            ps = conn.prepareStatement(commandText);
            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                Transaction t = new Transaction(
                        rs.getInt("id"),
                        rs.getBigDecimal("iznos"),
                        rs.getInt("teretana_pib"),
                        rs.getInt("clan_id")
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
    public Transaction getTransactionById(int id){
        Connection conn = null;
        Transaction result = null;
        PreparedStatement ps = null;

        try{
            conn = DButil.getConnection();
            String commandText = "SELECT * FROM transakcija WHERE id = ?";
            ps = conn.prepareStatement(commandText);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if(!rs.next()){
                throw new Exception("Non existing transaction");
            }

            result = new Transaction(
                    rs.getInt("id"),
                    rs.getBigDecimal("iznos"),
                    rs.getInt("teretana_pib"),
                    rs.getInt("clan_id")
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
    public int insertTransaction(Transaction transaction){
        Connection conn = null;
        int result = 0;
        PreparedStatement ps = null;

        try{
            conn = DButil.getConnection();
            String commandText = "INSERT INTO transakcija(iznos, teretana_pib, clan_id)  VALUES(?, ?, ?)";
            ps = conn.prepareStatement(commandText);
            ps.setBigDecimal(1, transaction.getIznos());
            ps.setInt(2, transaction.getTeretana_pib());
            ps.setInt(3, transaction.getClan_id());

            int affectedRows = ps.executeUpdate();
            if(affectedRows == 0){
                throw new Exception("Error while inserting transaction");
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
    public int updateTransaction(int id, Transaction transaction){
        Connection conn = null;
        int result = 0;
        PreparedStatement ps = null;

        try{
            conn = DButil.getConnection();
            String commandText = "UPDATE transakcija SET iznos = ?, teretana_pib = ?, clan_id = ?"
                    + " WHERE id = ?";
            ps = conn.prepareStatement(commandText);
            ps.setBigDecimal(1, transaction.getIznos());
            ps.setInt(2, transaction.getTeretana_pib());
            ps.setInt(3, transaction.getClan_id());
            ps.setInt(4, id);

            int affectedRows = ps.executeUpdate();
            if(affectedRows == 0){
                throw new Exception("Error while updating transaction");
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
    public int deleteTransaction(int id){
        Connection conn = null;
        int result = 0;
        PreparedStatement ps = null;

        try{
            conn = DButil.getConnection();
            String commandText = "DELETE FROM transakcija WHERE id = ?";
            ps = conn.prepareStatement(commandText);
            ps.setInt(1, id);

            int affectedRows = ps.executeUpdate();
            if(affectedRows == 0){
                throw new Exception("Error while deleting transaction");
            }

            result = 1;
            conn.close();
            ps.close();

        }catch (Exception e){
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
