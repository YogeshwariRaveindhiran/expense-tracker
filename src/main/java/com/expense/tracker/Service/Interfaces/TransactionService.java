package com.expense.tracker.Service.Interfaces;


import com.expense.tracker.DTO.ComparisonReportDTO;
import com.expense.tracker.DTO.ReportDTO;
import com.expense.tracker.DTO.SummaryDTO;
import com.expense.tracker.DTO.TransactionDTO;
import com.expense.tracker.Model.TransactionModel;

import java.time.LocalDate;
import java.util.List;

public interface TransactionService  {


        public TransactionDTO createTransaction(TransactionDTO transactionDTO);
        public List<TransactionDTO> getAlltheTransaction();
        public TransactionDTO getTransactionById(Long id);
        public TransactionDTO updateTransaction(Long id, TransactionDTO updatedTransaction);    //update Transaction
        public void deleteTransaction(Long id);
        public SummaryDTO calculateSummary(LocalDate startDate, LocalDate endDate);
        public ReportDTO getMonthlyReport(int Year, int Month);
        public List<TransactionDTO> getTransactionsReport(LocalDate startDate, LocalDate endDate);
        public ComparisonReportDTO getComparisonReport(LocalDate month1, LocalDate month2);
}
