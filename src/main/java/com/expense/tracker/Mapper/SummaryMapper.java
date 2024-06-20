package com.expense.tracker.Mapper;

import com.expense.tracker.DTO.SummaryDTO;
import com.expense.tracker.Model.SummaryModel;

public class SummaryMapper {
    //the below function is used to change the rest api data to entity(database) for ResponseBody
    public static SummaryDTO mapToSummaryDTO(SummaryModel summaryModel){
        return new SummaryDTO(summaryModel.gettotalIncome(), summaryModel.getTotalExpense(), summaryModel.getBalance());
    }

    //the below function is used to convert the entity(database) to rest api data
    public static SummaryModel mapToSummaryModel(SummaryDTO summaryDTO){
        return new SummaryModel(summaryDTO.gettotalIncome(), summaryDTO.gettotalIncome(), summaryDTO.getBalance());
    }
}
