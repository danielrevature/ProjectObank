package org.example.services;

import org.example.dao.DaoFactory;
import org.example.dao.IMainAccountDao;
import org.example.dao.MainAccountDao;
import org.example.entity.MainAccount;

import java.util.List;

public class Inquiry {
    public static void Allaccounts(){
        System.out.println("Customers account list");
        IMainAccountDao imainaccountdao = DaoFactory.getMainAccountDao();
        List<MainAccount> accounts = imainaccountdao.getAllMainAccounts();
        for(MainAccount account: accounts){
            System.out.println(account);
        }


    }
}
