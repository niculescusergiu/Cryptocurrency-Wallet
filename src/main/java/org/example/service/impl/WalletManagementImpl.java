package org.example.service.impl;

import org.example.dao.WalletDao;
import org.example.exception.WalletValidationException;
import org.example.model.Wallet;
import org.example.service.WalletManagement;

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

        return null;
    }
}
