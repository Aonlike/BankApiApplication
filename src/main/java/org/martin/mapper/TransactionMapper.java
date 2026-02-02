package org.martin.mapper;

import org.martin.data.models.Transaction;
import org.martin.dtos.requests.AirtimeRequest;
import org.martin.dtos.requests.TransferRequest;
import org.martin.dtos.responses.TransactionResponse;

import java.time.LocalDateTime;

public class TransactionMapper {

    public static Transaction toEntity(TransferRequest request) {
        Transaction transaction = new Transaction();
        transaction.setSourceAccount(request.getSourceAccount());
        transaction.setDestinationAccount(request.getDestinationAccount());
        transaction.setOriginalAmount(request.getAmount());
        transaction.setTransactionDate(LocalDateTime.now());
        return transaction;
    }

    public static Transaction toEntity(AirtimeRequest request) {
        Transaction transaction = new Transaction();
        transaction.setSourceAccount(request.getSourceAccount());
        transaction.setDestinationAccount("N/A - AIRTIME");
        transaction.setOriginalAmount(request.getAmount());
        transaction.setTransactionType("AIRTIME");
        transaction.setTransactionDate(LocalDateTime.now());
        return transaction;
    }
    public static TransactionResponse mapModelToResponse(Transaction transaction, String message) {
        TransactionResponse response = new TransactionResponse();

        response.setMessage(message);
        response.setTransactionId(transaction.getId());
        response.setOriginalAmount(transaction.getOriginalAmount());
        response.setDiscountAmount(transaction.getDiscountAmount());

        return response;
    }
}
