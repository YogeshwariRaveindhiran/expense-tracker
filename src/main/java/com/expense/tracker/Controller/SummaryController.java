package com.expense.tracker.Controller;

import com.expense.tracker.DTO.SummaryDTO;
import com.expense.tracker.Service.Interfaces.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@RequestMapping("api/Summary")
public class SummaryController {

    @Autowired
    public TransactionService transactionService;

    public SummaryController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }


    @GetMapping
    public ResponseEntity<SummaryDTO> getSummaryDateBetween(){
        SummaryDTO summaryDTO = transactionService.calculateSummary(LocalDate.now().withDayOfMonth(1), LocalDate.now());
        System.out.println("Controller once before printing");
        System.out.println(summaryDTO.totalIncome);System.out.println(summaryDTO.totalExpense);System.out.println(summaryDTO.balance);
        return ResponseEntity.ok(summaryDTO);
    }

}
