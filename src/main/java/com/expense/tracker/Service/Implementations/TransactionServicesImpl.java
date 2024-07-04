package com.expense.tracker.Service.Implementations;

import com.expense.tracker.DTO.ReportDTO;
import com.expense.tracker.DTO.SummaryDTO;
import com.expense.tracker.DTO.TransactionDTO;
import com.expense.tracker.Exception.ResourceNotFound;
import com.expense.tracker.Mapper.ReportMapper;
import com.expense.tracker.Mapper.SummaryMapper;
import com.expense.tracker.Mapper.TransactionMapper;

import com.expense.tracker.Model.ReportModel;
import com.expense.tracker.Model.SummaryModel;
import com.expense.tracker.Model.TransactionModel;
import com.expense.tracker.Repository.TransactionRepository;
import com.expense.tracker.Service.Interfaces.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
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

    @Override
    public SummaryDTO calculateSummary(LocalDate startDate, LocalDate endDate) {

        List<TransactionModel> transactionModel = (List<TransactionModel>) transactionRepository.findBytransactionOnBetween(startDate, endDate);
        if(transactionModel == null){
            throw new RuntimeException("check the query as the values are empty");
        }

        double totalExpenses = transactionModel.stream()
                .filter(t -> t.getMaincategory().equals("Expense"))
                .mapToDouble(TransactionModel::getAmount).sum();


        double totalIncome = transactionModel.stream()
                .filter(t -> t.getMaincategory().equals("Income"))
                .mapToDouble(TransactionModel::getAmount)
                .sum();

        double balance = totalIncome - totalExpenses;
        System.out.println("Calculating summary from the query data");
        System.out.print(totalIncome);System.out.print(totalExpenses);System.out.print(balance);

        SummaryModel summaryModel = new SummaryModel(totalIncome, totalExpenses, balance);
        summaryModel.settotalIncome(totalIncome);
        summaryModel.setTotalExpense(totalExpenses);
        summaryModel.setBalance(balance);

        return SummaryMapper.mapToSummaryDTO(summaryModel);

    }

    @Override
    public ReportDTO getMonthlyReport(int year, int month) {

        if (month < 1 || month > 12) {
            System.out.println("month is :"+month);
            throw new ResourceNotFound("Invalid month data ");
        }

        LocalDate startDate = LocalDate.of(year, month, 1);
        LocalDate endDate = startDate.withDayOfMonth(startDate.lengthOfMonth());

        List<TransactionModel> transactions = transactionRepository.findBytransactionOnBetween(startDate, endDate);

        double totalIncome = transactions.stream()
                .filter(t -> t.getMaincategory().equalsIgnoreCase("income"))
                .mapToDouble(TransactionModel::getAmount)
                .sum();

        double totalExpenses = transactions.stream()
                .filter(t -> t.getMaincategory().equalsIgnoreCase("Expense"))
                .mapToDouble(TransactionModel::getAmount)
                .sum();

        Map<String, Double> categoryBreakdown = transactions.stream()
                .filter(t -> t.getMaincategory().equalsIgnoreCase("Expense"))
                .collect(Collectors.groupingBy(TransactionModel::getSubcategory, Collectors.summingDouble(TransactionModel::getAmount)));

        double balance = totalIncome-totalExpenses;

        ReportModel reportModel = new ReportModel(totalIncome, totalExpenses, balance, categoryBreakdown);
        return ReportMapper.mapToReportDTO(reportModel);
    }

    //Transaction Report
    @Override
    public List<TransactionDTO> getTransactionsReport(LocalDate startDate, LocalDate endDate) {

        List<TransactionModel> transactionModel = transactionRepository.findBytransactionOnBetween(startDate, endDate);

        if (transactionModel == null ){
            throw new ResourceNotFound("Data is not available for the period you selected");
        }


        return transactionModel.stream()
                .filter(t -> t.getMaincategory().equalsIgnoreCase("Expense"))
                .map(TransactionMapper::mapToTransactionDTO)
                .collect(Collectors.toList());

    }


}
