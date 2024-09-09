package org.example.dao;

import org.example.model.Wallet;

import java.util.Optional;

public interface WalletDao {
    Wallet createWallet(Wallet wallet);
    Optional<Wallet> findWalletById(String id);
}
