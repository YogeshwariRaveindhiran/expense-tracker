package com.expense.tracker.Mapper;

import com.expense.tracker.DTO.TransactionDTO;
import com.expense.tracker.Model.TransactionModel;

public class TransactionMapper {

    //the below function is used to change the rest api data to entity(database) for ResponseBody
    public static TransactionDTO mapToTransactionDTO(TransactionModel transactionModel){
       return new TransactionDTO(transactionModel.getId(), transactionModel.getCreated_date(), transactionModel.getDescription(),transactionModel.getAmount(), transactionModel.getPaidby(), transactionModel.getMaincategory(), transactionModel.getSubcategory(), transactionModel.getTransactionOn() );
    }

    //the below function is used to convert the entity(database) to rest api data
    public static TransactionModel mapToTransactionModel(TransactionDTO transactionDTO){
        return new TransactionModel(transactionDTO.getId(), transactionDTO.getCreated_date(), transactionDTO.getDescription(), transactionDTO.getAmount(), transactionDTO.getPaidby(), transactionDTO.getMaincategory(), transactionDTO.getSubcategory(), transactionDTO.getTransactionOn() );
    }
}
