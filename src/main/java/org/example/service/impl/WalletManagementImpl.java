package org.example.service.impl;

import org.example.dao.WalletDao;
import org.example.exception.WalletNotFoundException;
import org.example.exception.WalletValidationException;
import org.example.model.Wallet;
import org.example.service.WalletManagement;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class WalletManagementImpl implements WalletManagement {

    private WalletDao walletDao;

    public WalletManagementImpl(WalletDao walletDao) {
        this.walletDao = walletDao;
    }

    @Override
    public Wallet create(String walletName) {
        if (walletName == null) throw new WalletValidationException("Invalid parameter", "walletName");
         //todo add more logics : if the wallet name exist or....
        Wallet wallet = new Wallet(walletName);
        return walletDao.createWallet(wallet);
    }

    @Override
    public Wallet getById(String id) {
        Optional<Wallet> optionalWallet = walletDao.findWalletById(id);
        if(optionalWallet.isPresent()) {
            return optionalWallet.get();
        }
        throw new WalletNotFoundException("Wallet not found");
    }
}
