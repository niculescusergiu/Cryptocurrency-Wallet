package org.example;

import org.example.config.AppConfig;
import org.example.dao.TransactionDao;
import org.example.dao.WalletDao;
import org.example.dao.impl.TransactionDaoImpl;
import org.example.dao.impl.WalletDaoImpl;
import org.example.model.Cryptocurrency;
import org.example.model.Transaction;
import org.example.model.Wallet;
import org.example.service.TransactionManagement;
import org.example.service.WalletManagement;
import org.example.service.impl.TransactionManagementImpl;
import org.example.service.impl.WalletManagementImpl;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.lang.annotation.Annotation;
import java.math.BigDecimal;

public class App {
    public static void main(String[] args) {
        //WalletDao walletDao = new WalletDaoImpl();
        //WalletManagement walletManagement = new WalletManagementImpl(walletDao);
        //Wallet wallet = walletManagement.create("My Wallet");
        //System.out.println("Wallet created: " + wallet);

        //TransactionDao transactionDao = new TransactionDaoImpl();
        //TransactionManagement transactionManagement = new TransactionManagementImpl(walletDao, transactionDao);

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        WalletManagement walletManagement = context.getBean(WalletManagement.class);
        TransactionManagement transactionManagement = context.getBean(TransactionManagement.class);
        Wallet wallet = walletManagement.create("My Wallet");


        Transaction depositTransactionForBTC = transactionManagement.createDepositTransaction(
                wallet.getId(),
                Cryptocurrency.BTC,
                new BigDecimal(1),
                "Test deposit transaction");
                System.out.println(walletManagement.getById(wallet.getId()));
        Transaction depositTransactionForETH = transactionManagement.createDepositTransaction(
                wallet.getId(),
                Cryptocurrency.ETH,
                new BigDecimal(10),
                "Test deposit transaction");
        System.out.println(walletManagement.getById(wallet.getId()));
    }
}