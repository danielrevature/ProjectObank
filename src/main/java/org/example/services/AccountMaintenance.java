package org.example.services;

import org.example.dao.*;
import org.example.entity.MainAccount;
import org.example.entity.Transactions;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class AccountMaintenance {
    private static int curId;
    private static BigDecimal balance;
    private static BigDecimal dif;
    private static String actype;



    public AccountMaintenance(){

    }
    public static void existingAccount() {

        Scanner scanner = new Scanner(System.in);
        String transactiontype = "Deposit";

        int userid = curId;
        ZonedDateTime now = ZonedDateTime.now();
        Timestamp createdon = Timestamp.valueOf(now.toLocalDateTime());

        System.out.println("Please enter your account number");
        long accountnumber = scanner.nextLong();
       MainAccountDao mainDao = new MainAccountDao();

        mainDao.getMainAccountByAcc(accountnumber);

      IMainAccountDao imainaccountdao = DaoFactory.getMainAccountDao();
       MainAccount mainaccount =  imainaccountdao.getMainAccountByAcc(accountnumber);
        System.out.println(mainaccount.toString());
       System.out.println(mainaccount.getAccountNumber() + " , " + mainaccount.getBalance() + " ," + mainaccount.getAccountType());
       // IMainAccountDao account = new MainAccountDao();
        //account.getMainAccountByAcc(accountnumber);
        //StudentDao studentDao = new StudentDaoImpl();
        //for (MainAccount main : account.getMainAccountByAcc(accountnumber)) {
     //   System.out.println(account.getMainAccount(MainAccount account).getAccountNumber());
            //System.out.println("Student: [RollNo : " + student.getRollNo() + ", Name : " + student.getName() + " ]");...
        //MainAccount main = new MainAccount(userId, accountNumber, String accountType, BigDecimal balance, Timestamp lastUpdated);
        //System.out.println(main.getAccountNumber() + " " + main.getBalance());



      //  System.out.println(mainaccount.toString());


        System.out.println("Please select Transaction type ");
        System.out.println("1 -  Deposit\n"+
                "2 -  Withdrawal\n");
        int choice = scanner.nextInt();
        System.out.println("Enter your amount");
        BigDecimal amount = scanner.nextBigDecimal();
      //  double bl = balance.doubleValue();
       // double amt = amount.doubleValue();
        System.out.println(balance + " " + amount);
        if(choice==1) {
            dif = amount.add(balance);
            String transactionType = "Deposit";
        }
        else {
            dif = amount.subtract(balance);
            String transactionType = "Withdrawal";
            double compareResult = amount.compareTo(balance);

            if (compareResult==1) {
                System.out.println("Sorry! You don't have enough balance for your request!");
            }
        }
            System.out.println(createdon);

            System.out.println("Account number   :  " + accountnumber);
            System.out.println("Account Type     :  " + actype);

            System.out.println("Description");
            String description = scanner.next();
            now = ZonedDateTime.now();
            createdon = Timestamp.valueOf(now.toLocalDateTime());

        TransactionsDao transactionsDao = new TransactionsDao();
        Transactions transactions = new Transactions(userid,accountnumber,transactiontype,amount,description,createdon);
        ITransactionsDao itransactionsdao = DaoFactory.getTransactionsDao();
        itransactionsdao.insert(transactions);
        }



}




