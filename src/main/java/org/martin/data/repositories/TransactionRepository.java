package org.martin.data.repositories;

import org.martin.data.models.Transaction;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface TransactionRepository extends MongoRepository<Transaction, String> {
    List<Transaction> findBySourceAccount(String sourceAccount);

    List<Transaction> findBySourceAccountAndTransactionDateAfter(String sourceAccountAfter, LocalDateTime date);
}
