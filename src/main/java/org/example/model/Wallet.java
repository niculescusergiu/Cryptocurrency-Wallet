package org.example.model;

import org.example.exception.insufficientBalanceException;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Wallet {
    private final String id;
    private final String walletName;
    private final Map<Cryptocurrency, BigDecimal> cryptocurrencies;

    public Wallet(String walletName) {
        this.id = UUID.randomUUID().toString();
        this.walletName = walletName;
        this.cryptocurrencies = new HashMap<>();
    }

    public Map<Cryptocurrency, BigDecimal> getCryptocurrencies() {
        return cryptocurrencies;
    }
    public void deposit(Cryptocurrency cryptocurrency, BigDecimal amount) {
        if (amount.compareTo(BigDecimal.ZERO) <= 0)
            throw new IllegalArgumentException("Amount must be greater than zero");
        BigDecimal currentBalance = getBalance(cryptocurrency);
        BigDecimal newBalance = currentBalance.add(amount);
        cryptocurrencies.put(cryptocurrency, newBalance);

    }

    public String getId() {
        return id;
    }

    public BigDecimal getBalance(Cryptocurrency cryptocurrency) {
        return cryptocurrencies.getOrDefault(cryptocurrency, BigDecimal.ZERO);


    }
    public void withdraw(Cryptocurrency cryptocurrency, BigDecimal amount) {
        if (amount.compareTo(BigDecimal.ZERO) <= 0)
            throw new IllegalArgumentException("Amount must be greater than zero");
        BigDecimal currentBalance = getBalance(cryptocurrency);
        if (currentBalance.compareTo(amount) < 0)
            throw new insufficientBalanceException("Insufficient balance");
        BigDecimal newBalance = currentBalance.add(amount);
        cryptocurrencies.put(cryptocurrency, newBalance);
    }

    @Override
    public String toString() {
        return "wallet{" +
                "id='" + id + '\'' +
                ", walletName='" + walletName + '\'' +
                ", cryptocurrencies=" + cryptocurrencies +
                '}';
    }
}
