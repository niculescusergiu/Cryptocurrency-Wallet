package org.example.config;

import org.example.dao.TransactionDao;
import org.example.dao.WalletDao;
import org.example.dao.impl.TransactionDaoImpl;
import org.example.dao.impl.WalletDaoImpl;
import org.example.service.TransactionManagement;
import org.example.service.WalletManagement;
import org.example.service.impl.TransactionManagementImpl;
import org.example.service.impl.WalletManagementImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
//@ComponentScan("org.example")
public class AppConfig {
    public TransactionDao transactionDao() {
        return new TransactionDaoImpl();
    }
    @Bean
    public WalletDao walletDao() {
        return new WalletDaoImpl();
    }
    @Bean
    public TransactionManagementImpl transactionManagement() {
        return new TransactionManagementImpl(walletDao(), transactionDao());
    }
    @Bean
    public WalletManagementImpl walletManagement() {
        return new WalletManagementImpl(walletDao());
    }
}
