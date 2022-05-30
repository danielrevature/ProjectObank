package org.example.services;

import org.example.dao.*;
import org.example.entity.MainAccount;
import org.example.entity.Transactions;



import java.sql.Timestamp;
import java.time.ZonedDateTime;

import java.util.Scanner;

public class AccountMaintenance {

    private static float dif;
    private static long trans;
    public static void existingAccount() {

         int userid;
         float balance;
         long accountnumber;

         String type;

        Scanner scanner = new Scanner(System.in);

        ZonedDateTime now = ZonedDateTime.now();
        Timestamp createdon = Timestamp.valueOf(now.toLocalDateTime());

        // Getting the account number from user(terminal)
        System.out.println("Please enter your account number");
<<<<<<< HEAD
        accountnumber = scanner.nextLong();
        System.out.println(accountnumber);
        accountnumber = accountnumber;
        // Creating a mainDao by DaoFactory
=======
        long accountnumber = scanner.nextLong();
       MainAccountDao mainDao = new MainAccountDao();

       MainAccount mainaccount = mainDao.getMainAccountByAcc(accountnumber);

        System.out.println(mainaccount.toString());
//       System.out.println(mainaccount.getAccountNumber() + " , " + mainaccount.getBalance() + " ," + mainaccount.getAccountType());
       // IMainAccountDao account = new MainAccountDao();
        //account.getMainAccountByAcc(accountnumber);
        //StudentDao studentDao = new StudentDaoImpl();
        //for (MainAccount main : account.getMainAccountByAcc(accountnumber)) {
     //   System.out.println(account.getMainAccount(MainAccount account).getAccountNumber());
            //System.out.println("Student: [RollNo : " + student.getRollNo() + ", Name : " + student.getName() + " ]");...
        //MainAccount main = new MainAccount(userId, accountNumber, String accountType, BigDecimal balance, Timestamp lastUpdated);
        //System.out.println(main.getAccountNumber() + " " + main.getBalance());
>>>>>>> d63e3df2de3bbd85c0f7047d9fd5f4d16550f656




        IMainAccountDao mainDao = DaoFactory.getMainAccountDao();

        // Getting the user bank account by account number
        MainAccount mainaccount = mainDao.getMainAccountByAcc(accountnumber);
     //   System.out.println(mainaccount.getAccountNumber());
     //   System.out.println("Entered account : ");
        // Setting the instance type to the returned account account_type
        type = mainaccount.getAccountType();
        userid = mainaccount.getUserId();
        balance = mainaccount.getBalance();

        System.out.println("Entered account : " + accountnumber);
        // Printing the user ban account (string format)
        System.out.println(mainaccount);

        // Getting transaction type form user(terminal)
        System.out.println("Please select Transaction type ");
        System.out.println("1 -  Deposit\n" +
                "2 -  Withdrawal\n " +
                "3 - Transfer");
        int choice = scanner.nextInt();

        // Getting amount from user (terminal)
        System.out.println("Enter your amount");
        float amount = scanner.nextLong();

        String transactiontype = null;
        System.out.println(balance + " " + amount);
        switch (choice) {
            case 1:
                transactiontype = "Deposit";
                dif = amount + balance;
                break;
            case 2:
                transactiontype = "Withdrawal";
              dif =  balance - amount;

                if (amount > balance) {
                    System.out.println("Sorry! You don't have enough balance for your request!");
                }
               // System.exit(1);
                break;

            case 3:
                transactiontype = "Transfer";


                dif = balance - amount;

                if (amount > balance) {
                    System.out.println("Sorry! You don't have enough balance for your transfer!");
                    System.exit(1);
                }
                else{
                    System.out.println("Enter the account number to to transfer to ");
                    trans = scanner.nextLong();
                }


                break;

            default:
                System.out.println("Please enter a valid choice!");
        }
        System.out.println(createdon);

        System.out.println("Account number   :  " + accountnumber);
        System.out.println("Transaction Type     :  " + transactiontype);

        System.out.println("Description");
        String description = scanner.next();


        now = ZonedDateTime.now();
        createdon = Timestamp.valueOf(now.toLocalDateTime());

        Transactions transactions = new Transactions(userid, accountnumber, transactiontype, amount, description, userid, createdon);
        ITransactionsDao itransactionsdao = DaoFactory.getTransactionsDao();
        itransactionsdao.insert(transactions);


        balance = amount;
        Timestamp lastupdated = createdon;
        //MainAccountDao mainaccountdao = new MainAccountDao();
        mainaccount = new MainAccount(userid, accountnumber,type,dif,lastupdated);
        IMainAccountDao imainaccountdao = DaoFactory.getMainAccountDao();
        imainaccountdao.update(mainaccount);


        transactiontype = "Deposit";
        transactions = new Transactions(userid, trans, transactiontype, amount, description, userid, createdon);
        itransactionsdao = DaoFactory.getTransactionsDao();
        itransactionsdao.insert(transactions);

        IMainAccountDao transDao = DaoFactory.getMainAccountDao();

        // Getting the user bank account by account number




        // Getting the user bank account by account number
        MainAccount transAcc = mainDao.getMainAccountByAcc(trans);

        balance = transAcc.getBalance();
        dif = balance + amount;

        transAcc = new MainAccount(userid, trans,type,dif,lastupdated);
        imainaccountdao = DaoFactory.getMainAccountDao();
        imainaccountdao.update(transAcc);

        System.out.println("Transaction completed ! Your updated balance is : " + balance);

    }
}















