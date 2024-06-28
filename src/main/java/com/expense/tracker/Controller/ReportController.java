package com.expense.tracker.Controller;

import com.expense.tracker.DTO.ReportDTO;
import com.expense.tracker.Service.Interfaces.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/report")
public class ReportController {
    //Monthlyreport
    @Autowired
    public TransactionService transactionService;

    public ReportController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    //Monthly Expense
    @GetMapping("/{year}/{month}")
    public ResponseEntity<ReportDTO> getMonthlyReport(@PathVariable("year") int year, @PathVariable("month")int month){
        ReportDTO reportDTO = transactionService.getMonthlyReport(year,month);
        return ResponseEntity.ok(reportDTO);
    }
}
