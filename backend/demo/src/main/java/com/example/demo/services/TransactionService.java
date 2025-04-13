package com.example.demo.services;

import com.example.demo.models.Transaction;
import com.example.demo.repositories.TransactionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService {
    private TransactionRepository transactionRepository;

    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    //GET ALL
    public List<Transaction> getAllTransactions(){
        List<Transaction> result = this.transactionRepository.getAllTransactions();
        return result;
    }

    //GET BY ID
    public Transaction getTransactionById(int id){
        Transaction result = this.transactionRepository.getTransactionById(id);
        return result;
    }

    //INSERT
    public int insertTransaction(Transaction transaction){
        int result = this.transactionRepository.insertTransaction(transaction);
        return result;
    }

    //UPDATE
    public int updateTransaction(int id, Transaction transaction){
        int result = this.transactionRepository.updateTransaction(id, transaction);
        return result;
    }

    //DELETE
    public int deleteTransaction(int id){
        int result = this.transactionRepository.deleteTransaction(id);
        return result;
    }
}
