package org.example;

import org.example.dao.WalletDao;
import org.example.dao.impl.WalletDaoImpl;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        WalletDao walletDao = new WalletDaoImpl();
    }
}
