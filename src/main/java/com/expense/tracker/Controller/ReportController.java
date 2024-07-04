package com.expense.tracker.Controller;

import com.expense.tracker.DTO.ComparisonReportDTO;
import com.expense.tracker.DTO.ReportDTO;
import com.expense.tracker.DTO.TransactionDTO;
import com.expense.tracker.Service.Interfaces.TransactionService;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

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

    //Transaction Report
    @GetMapping("/transaction-report")
    public ResponseEntity<List<TransactionDTO>> getTransactionsReport(
            @RequestParam(value = "startDate", required = false) @JsonFormat(pattern="yyyy-MM-dd") LocalDate startDate,
            @RequestParam(value = "endDate", required = false) @JsonFormat(pattern="yyyy-MM-dd") LocalDate endDate) {
        System.out.println("Inside Transaction Report fetching function");
        //http://localhost:8080/api/report/transaction-report?startDate=2024-06-01&endDate=2024-06-30

        // Set default dates if not provided
        if (startDate == null) {
            startDate = LocalDate.now().minusMonths(1); // Default to one month ago
        }
        if (endDate == null) {
            endDate = LocalDate.now(); // Default to today
        }

        List<TransactionDTO> transactionReport = transactionService.getTransactionsReport(startDate, endDate);
        return ResponseEntity.ok(transactionReport);
    }

    @GetMapping("/comparison-report")
    public ResponseEntity<ComparisonReportDTO> getComparisonReport(
            @RequestParam("month1") @DateTimeFormat(pattern="yyyy-MM") String month1,
            @RequestParam("month2") @DateTimeFormat(pattern="yyyy-MM") String month2) {

        LocalDate month1Date = LocalDate.parse(month1 + "-01");
        LocalDate month2Date = LocalDate.parse(month2 + "-01");

        ComparisonReportDTO comparisonReport = transactionService.getComparisonReport(month1Date, month2Date);
        return ResponseEntity.ok(comparisonReport);
    }

}
