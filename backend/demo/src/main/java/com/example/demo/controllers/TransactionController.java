package com.example.demo.controllers;

import com.example.demo.models.Transaction;
import com.example.demo.services.TransactionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {
    private TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    //GET ALL
    @GetMapping
    public List<Transaction> getAllTransactions(){
        List<Transaction> result = this.transactionService.getAllTransactions();
        return result;
    }

    //GET BY ID
    @GetMapping(value = "/{id}")
    public Transaction getTransactionById(@PathVariable("id") int id){
        Transaction result = this.transactionService.getTransactionById(id);
        return result;
    }

    //INSERT
    @PostMapping
    public int insertTransaction(@RequestBody Transaction transaction){
        int result = this.transactionService.insertTransaction(transaction);
        return result;
    }

    //UPDATE
    @PutMapping(value = "/{id}")
    public int updateTransaction(@PathVariable("id") int id, @RequestBody Transaction transaction){
        int result = this.transactionService.updateTransaction(id, transaction);
        return result;
    }

    //DELETE
    @DeleteMapping(value = "/{id}")
    public int deleteTransaction(@PathVariable("id") int id){
        int result = this.transactionService.deleteTransaction(id);
        return result;
    }
}
