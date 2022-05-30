package org.example.services;

import org.example.dao.DaoFactory;
import org.example.dao.IMainAccountDao;
import org.example.dao.IUserDao;
import org.example.dao.MainAccountDao;
import org.example.entity.MainAccount;
import org.example.entity.User;

import java.util.List;
import java.util.Scanner;

public class Inquiry {
    public static void Allaccounts() {
try{
    System.out.println("Customers account list");
    IMainAccountDao imainaccountdao = DaoFactory.getMainAccountDao();
    List<MainAccount> accounts = imainaccountdao.getAllMainAccounts();
    for (MainAccount account : accounts) {
        System.out.println(account);
    }
}
catch(Exception ex){
    ex.printStackTrace();
        }

    }

    public static void  getMainAccountByAcc() {
        try{
            System.out.println("Customers account list");

            Scanner scanner = new Scanner(System.in);
            System.out.println("Please enter account number: ");
            int id = scanner.nextInt();


            IMainAccountDao imainaccountdao = DaoFactory.getMainAccountDao();
            MainAccount accounts = imainaccountdao.getMainAccountByAcc(id);
            System.out.println(accounts.toString());


        }
        catch(Exception ex){
            ex.printStackTrace();
        }
    }
    public static void getMainAccountById() {
        try{
            System.out.println("Customers account list");
            Scanner scanner = new Scanner(System.in);
            System.out.println("Please enter user ID: ");
            int id = scanner.nextInt();


            IMainAccountDao imainaccountdao = DaoFactory.getMainAccountDao();
            MainAccount accounts = imainaccountdao.getMainAccountById(id);
            System.out.println(accounts.toString());

        }
        catch(Exception ex){
            ex.printStackTrace();
        }



    }

    public static void deleteUser() {
        try{
            Scanner scanner = new Scanner(System.in);
            System.out.println("Please enter the User ID for the user to delete: ");
            int id = scanner.nextInt();
            IUserDao userDao = DaoFactory.getUserDao();
            userDao.delete(id);
        }
        catch(Exception ex){
            ex.printStackTrace();
        }

    }




}
