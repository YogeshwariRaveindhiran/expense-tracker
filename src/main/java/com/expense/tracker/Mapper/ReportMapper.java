package com.expense.tracker.Mapper;

import com.expense.tracker.DTO.ReportDTO;
import com.expense.tracker.Model.ReportModel;

public class ReportMapper {
    //the below function is used to change the rest api data to entity(database) for ResponseBody
    public static ReportDTO mapToReportDTO(ReportModel reportModel){
        return new ReportDTO(reportModel.getTotalIncome(), reportModel.getTotalExpense(), reportModel.getBalance(), reportModel.getCategoryBreakdown() );
    }

    //the below function is used to convert the entity(database) to rest api data
    public static ReportModel mapToReportModel(ReportDTO reportDTO){
        return new ReportModel(reportDTO.getTotalIncome(), reportDTO.getTotalExpense(), reportDTO.getBalance(), reportDTO.getCategoryBreakdown());
    }
}
