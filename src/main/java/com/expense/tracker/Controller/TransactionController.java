package com.expense.tracker.Controller;

import com.expense.tracker.DTO.TransactionDTO;
import com.expense.tracker.Service.Interfaces.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/Transaction")
public class TransactionController {

    @Autowired
    public TransactionService transactionService;

     @PostMapping("/addTransaction")
   //Add or create employee REST API
    public ResponseEntity<TransactionDTO> createTransaction(@RequestBody TransactionDTO transactionDTO) {
        System.out.println(transactionDTO.getCreated_date());
        System.out.println(transactionDTO.getTransaction_date());
        System.out.println(transactionDTO.getDescription());
        System.out.println(transactionDTO.getAmount());
        System.out.println(transactionDTO.getPaidby());
        System.out.println(transactionDTO.getMaincategory());
        System.out.println(transactionDTO.getSubcategory());
        TransactionDTO savedTransaction = transactionService.createTransaction(transactionDTO);
        return new ResponseEntity<TransactionDTO>(savedTransaction, HttpStatus.CREATED);
    }


    @GetMapping("/TransactionByID/{id}")
    public ResponseEntity<TransactionDTO> getTransactionById(@PathVariable("id") Long id){
        TransactionDTO transactionDTO = transactionService.getTransactionById(id);
        return ResponseEntity.ok(transactionDTO);
    }

    //Build All Transaction REST API
    @GetMapping("/AllTransaction")

    public ResponseEntity<List<TransactionDTO>> getAlltheTransaction(){
        List<TransactionDTO> transactionDTO=transactionService.getAlltheTransaction();
        return ResponseEntity.ok(transactionDTO);
    }

    //Buidl update Transaction REST API
    @PutMapping("{id}")
    public ResponseEntity<TransactionDTO> updateTransaction(@PathVariable("id") Long id, @RequestBody TransactionDTO transactionDTO){
        TransactionDTO updatedTransaction = transactionService.updateTransaction(id,transactionDTO);
        return ResponseEntity.ok(updatedTransaction);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteTransaction(@PathVariable("id") Long id){
        transactionService.deleteTransaction(id);
        return ResponseEntity.ok("Successfully deleted the Transaction");
    }



}
