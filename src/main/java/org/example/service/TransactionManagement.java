package org.example.service;

import org.example.model.Cryptocurrency;
import org.example.model.Transaction;

import java.math.BigDecimal;
import java.util.List;

public interface TransactionManagement {
    Transaction createDepositTransaction(String walletId, Cryptocurrency cryptocurrency, BigDecimal amount, String description);
    Transaction creadeWithdrawTransaction(String walletId, Cryptocurrency cryptocurrency, BigDecimal amount, String description);

    List<Transaction> getTransactionsByWalletId(String walletId);

}
