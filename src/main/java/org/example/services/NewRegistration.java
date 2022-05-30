package org.example.services;

import org.example.dao.*;
import org.example.entity.MainAccount;
import org.example.entity.Transactions;
import org.example.entity.User;


import java.sql.Timestamp;
import java.time.ZonedDateTime;
import java.util.Scanner;

public class NewRegistration {

    private static String actype=null;
    private static int curId;




    public NewRegistration(){

    }
    public static void registerNew(){

        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter your first name");
        String firstname= scanner.next();
        System.out.println("Please enter your last name");
        String lastname= scanner.next();

        System.out.println("Please enter your user name");
        String username= scanner.next();
        System.out.println("Please enter your password");
        String password= scanner.next();
        System.out.println("User type  -  Customer");
        String usertype = "Customer";

        ZonedDateTime now = ZonedDateTime.now();
        Timestamp createdon = Timestamp.valueOf(now.toLocalDateTime());
        System.out.println(createdon);

        UserController userController = new UserController();
        User user = new User(firstname,lastname,username,password,usertype,createdon);
        IUserDao iUserDao = DaoFactory.getUserDao();
        iUserDao.sp_insert(user);
       System.exit(0);
        System.out.println("Please select \n" +
                        "1 -  Savings \n"+
                        "2 -  Checking\n" +
                        "3 -  Fixed Deposits\n"+
                        "4 -       QUIT");
        int choice = scanner.nextInt();
        switch(choice){
            case 1:
                actype = "Savings";
                break;
            case 2:
                actype = "Checking";
                break;
            case 3:
                actype = "Fixed Deposit";
                break;
            case 4:
                System.exit(0);;
            default:
                System.out.println("Please enter a valid value 1, 2, or 3");
                System.exit(0);
                break;
        }
        int userid = curId;
        long accountnumber = (long) Math.floor(1000000000 + Math.random() * 900000000);
        System.out.println("Account number   :  " + accountnumber);
        System.out.println("Account Type     :  " + actype);
        System.out.println("Transaction type");
        String transactionatype = scanner.next();
        System.out.println("Enter your amount");
        float amount = scanner.nextFloat();
        System.out.println("Description    :  New account deposit");
        String description = "New account deposit";
        now = ZonedDateTime.now();
        createdon = Timestamp.valueOf(now.toLocalDateTime());

        TransactionsDao transactionsDao = new TransactionsDao();
        Transactions transactions = new Transactions(curId,  accountnumber, transactionatype, amount, description, curId, createdon);


        ITransactionsDao itransactionsdao = DaoFactory.getTransactionsDao();
        itransactionsdao.insert(transactions);


        float balance = amount;
        Timestamp lastupdated = createdon;
        MainAccountDao mainaccountdao = new MainAccountDao();
        MainAccount mainaccount = new MainAccount(curId, accountnumber,actype,balance,createdon);
        ITransactionsDao imainaccountsdao = DaoFactory.getTransactionsDao();
        itransactionsdao.insertMain(mainaccount);
    }
    public static int tranUserId(int userid) {
        curId = userid;
        return curId;
    }
}
