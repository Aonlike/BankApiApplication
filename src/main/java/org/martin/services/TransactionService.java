package org.martin.services;

import org.martin.data.models.Account;
import org.martin.data.models.Customer;
import org.martin.data.models.Transaction;
import org.martin.data.repositories.AccountRepository;
import org.martin.data.repositories.CustomerRepository;
import org.martin.data.repositories.TransactionRepository;
import org.martin.dtos.requests.AirtimeRequest;
import org.martin.dtos.requests.TransferRequest;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.List;

public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private CustomerRepository customerRepository;

    public Transaction processTransfer(TransferRequest  request) {
        Account account = accountRepository.findByAccountNumber(request.getSourceAccount()).orElseThrow(() -> new RuntimeException("Source account not found"));
        Customer customer = customerRepository.findById(account.getCustomerId()).orElseThrow(() -> new RuntimeException("Customer not found"));

       double discountPercent = calculateDiscount(customer,request.getSourceAccount(),request.getAmount());
        double discountAmount = request.getAmount() * (discountPercent / 100);
        double finalAmount = request.getAmount() - discountAmount;

        Transaction transaction = new Transaction();
        transaction.setSourceAccount(request.getSourceAccount());
        transaction.setDestinationAccount(request.getDestinationAccount());
        transaction.setOriginalAmount(request.getAmount());
        transaction.setDiscountAmount(finalAmount);
        transaction.setTransactionType("TRANSFER");
        transaction.setTransactionDate(LocalDateTime.now());

        return transactionRepository.save(transaction);
    }

    private double calculateDiscount(Customer customer, String accountNumber, double amount) {
        int joinedOn = Period.between(customer.getJoinedDate(), LocalDate.now()).getYears();
        long transactionCount = getTransactionCount(accountNumber);

        if(joinedOn >= 4 && transactionCount < 3) {
            return 10.0;
        }

        if(transactionCount >= 3) {
            if (customer.getCustomerType().equals("BUSINESS") && amount > 150000) {
                return 27.0;
            }
            if (customer.getCustomerType().equals("RETAIL") && amount > 50000) {
                return 18.0;
            }
        }
        return 0.0;
    }
private long getTransactionCount(String accountNumber) {
        LocalDateTime startOfMonth = LocalDateTime.now().withDayOfMonth(1).withHour(0).withMinute(0);
        List<Transaction> transactions = transactionRepository.findBySourceAccountAndTransactionDateAfter(accountNumber, startOfMonth);
        return transactions.size();
    }
public List<Transaction> getHistory(String accountNumber) {
        return transactionRepository.findBySourceAccount(accountNumber);
}

public Transaction processAirtime(AirtimeRequest request){
        Transaction transaction = new Transaction();
        transaction.setSourceAccount(request.getSourceAccount());
        transaction.setOriginalAmount(request.getAmount());
        transaction.setDiscountAmount(request.getAmount());
        transaction.setTransactionType("AIRTIME");
        transaction.setTransactionDate(LocalDateTime.now());

        return transactionRepository.save(transaction);
}

}
