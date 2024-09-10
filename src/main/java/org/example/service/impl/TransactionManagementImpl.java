package org.example.service.impl;

import org.example.dao.TransactionDao;
import org.example.dao.WalletDao;
import org.example.exception.WalletNotFoundException;
import org.example.model.Cryptocurrency;
import org.example.model.Transaction;
import org.example.model.Wallet;
import org.example.service.TransactionManagement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

//@Component
public class TransactionManagementImpl implements TransactionManagement {
    private WalletDao walletDao;
    private TransactionDao transactionDao;

    @Autowired
    public TransactionManagementImpl(WalletDao walletDao, TransactionDao transactionDao) {
        this.walletDao = walletDao;
        this.transactionDao = transactionDao;
    }

    public TransactionManagementImpl(WalletDao walletDao) {
        this.walletDao = walletDao;
    }

    @Override
    public Transaction createDepositTransaction(String walletId, Cryptocurrency cryptocurrency, BigDecimal amount, String description) {
        //1. Validate parameters
        //2. Check if the wallet ID exists
        //3. yes -> continue no -> throw exception
        //4. Create a transaction
        //5. return the transaction
        if (walletId == null || cryptocurrency == null || amount == null)
            throw new IllegalArgumentException("Invalid parameter");
        Optional<Wallet> optionalWallet = walletDao.findWalletById(walletId);
        if(optionalWallet.isEmpty()) throw new WalletNotFoundException("Wallet not found");
        Wallet wallet = optionalWallet.get();
        wallet.deposit(cryptocurrency, amount);
        Transaction transaction = new Transaction("DEPOSIT", amount, walletId, cryptocurrency.getName());
        transaction.setDescription(description);
        Transaction createdTransaction = transactionDao.createTransaction(transaction);
        return createdTransaction;
    }

    @Override
    public Transaction creadeWithdrawTransaction(String walletId, Cryptocurrency cryptocurrency, BigDecimal amount, String description) {

        return null;
    }

    @Override
    public List<Transaction> getTransactionsByWalletId(String walletId) {
        return List.of();
    }
}
