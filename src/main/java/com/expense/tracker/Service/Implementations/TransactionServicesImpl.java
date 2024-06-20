package com.expense.tracker.Service.Implementations;

import com.expense.tracker.DTO.TransactionDTO;
import com.expense.tracker.Exception.ResourceNotFound;
import com.expense.tracker.Mapper.TransactionMapper;

import com.expense.tracker.Model.TransactionModel;
import com.expense.tracker.Repository.TransactionRepository;
import com.expense.tracker.Service.Interfaces.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TransactionServicesImpl implements TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    public TransactionServicesImpl(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }


    @Override
    //create transaction data into database
    public TransactionDTO createTransaction(TransactionDTO transactionDTO) {

        TransactionModel transactionModel= TransactionMapper.mapToTransactionModel(transactionDTO);
        TransactionModel savedTransaction;
        savedTransaction = transactionRepository.save(transactionModel);
        return TransactionMapper.mapToTransactionDTO(savedTransaction);
    }

    //get all the transaction
    @Override
    public List<TransactionDTO> getAlltheTransaction(){
       List<TransactionModel> transactionModel = transactionRepository.findAll();
        return transactionModel.stream().map((transactionModels) -> TransactionMapper.mapToTransactionDTO((transactionModels)))
                .collect(Collectors.toList());
    }


    //get the Transaction by ID
    @Override
    public TransactionDTO getTransactionById(Long id) {
        TransactionModel transactionModel=transactionRepository.findById(id).orElseThrow(()-> new ResourceNotFound("Transaction is not exist by the given id"+id));
        return TransactionMapper.mapToTransactionDTO(transactionModel);
    }

    //update the Transaction
    @Override
    public TransactionDTO updateTransaction(Long id, TransactionDTO updatedTransaction) {

        TransactionModel transactionModel=transactionRepository.findById(id).orElseThrow(()-> new ResourceNotFound("The transaction is not exist"+id));

        transactionModel.setTransactionOn(updatedTransaction.getTransactionOn());
        transactionModel.setDescription(updatedTransaction.getDescription());
        transactionModel.setAmount(updatedTransaction.getAmount());
        transactionModel.setPaidby(updatedTransaction.getPaidby());
        transactionModel.setMaincategory(updatedTransaction.getMaincategory());
        transactionModel.setSubcategory(updatedTransaction.getSubcategory());
        transactionModel.setCreated_date(LocalDateTime.now());

        TransactionModel updatedTransactionObj = transactionRepository.save(transactionModel);
        return TransactionMapper.mapToTransactionDTO(updatedTransactionObj);

    }

    //Delete the Transaction
    @Override
    public void deleteTransaction(Long id) {
        //check if the transaction exisit or not
        TransactionModel transactionModel=transactionRepository.findById(id).orElseThrow(()-> new ResourceNotFound("The transaction is not exist"+id));
        transactionRepository.deleteById(id);
    }



}
