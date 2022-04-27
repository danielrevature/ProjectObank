package org.example.dao;

import org.example.entity.MainAccount;
import org.example.entity.Transactions;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TransactionsDao implements ITransactionsDao{
    Connection connection;
    public TransactionsDao(){
        connection = ConnectionFactory.getConnection();
    }

    @Override
    public List<Transactions> getAllTransactions() {
        List<Transactions> transactions = new ArrayList<>();
        String sql = "Select u.firstname + ' ' + u.lastname as Customer, t.accountnumber , t.createdon, t.description, t.amount from Transactions t inner join users u on t.userid = u.userid;";
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                resultSet.next();
                Transactions trans = getTransaction(resultSet);
                transactions.add(trans);

            }
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }

        return transactions;
    }

    @Override
    public Transactions getTransactionById(int id) {
        String sql = "Select * from transactions where accountnumber = ?;";

        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                resultSet.next();
                Transactions transaction = getTransaction(resultSet) ;
                return transaction;
            }
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
        return null;
    }


    @Override
    public void insert(Transactions transactions) {
        String sql = "Insert into transactions (userid,accountNumber,transactionType,amount,description,createdon) values(?,?,?,?,?,?);";
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.setInt(1,transactions.getUserid());
            preparedStatement.setLong(2,transactions.getAccountNumber());
            preparedStatement.setString(3,transactions.getTransactionType());
            preparedStatement.setBigDecimal(4,transactions.getAmount());
            preparedStatement.setString(5,transactions.getDescription());
            preparedStatement.setTimestamp(6,transactions.getCreatedOn());
           int count = preparedStatement.executeUpdate();
           if(count==1){
               System.out.println("Record for added successfully!!!");

           }
           else{
               System.out.println("Operation failed!!");
           }

        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
    }

    @Override
    public void update(Transactions transactions) {
        String sql = "Update Transactions set accountNumber = ?, transactiontype = ?, amount = ?, description = ?, createdon = ?;";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(2,transactions.getAccountNumber());
            preparedStatement.setString(3,transactions.getTransactionType());
            preparedStatement.setBigDecimal(4,transactions.getAmount());
            preparedStatement.setString(5,transactions.getDescription());
            preparedStatement.setTimestamp(6,transactions.getCreatedOn());
            int count= preparedStatement.executeUpdate();
            if(count == 1) System.out.println("Record updated successfully!");
            else
                System.out.println("Record not found!!");
        }
        catch(SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void delete(long id) {

        String sql = "Delete from Transactions where accountnumber = ?;";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1,  id);
            int count = preparedStatement.executeUpdate();
            if(count == 1) {
                System.out.println("Record deleted successfully!");
            }
            else
            {
                System.out.println("Record deletion attempt failed!!!");
            }
        }
        catch(SQLException ex) {
            ex.printStackTrace();
        }

    }

    @Override
    public Transactions getTransaction(ResultSet resultSet) {
        return null;
    }



    @Override
    public void insertMain(MainAccount mainaccount)
    {
        String sql = "Insert into MainAccount (userid, accountNumber,accounttype,balance,lastupdated) values(?,?,?,?,?);";
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, mainaccount.getUserId() );
            preparedStatement.setLong(2, mainaccount.getAccountNumber());
            preparedStatement.setString(3, mainaccount.getAccountType());
            preparedStatement.setBigDecimal(4,mainaccount.getBalance());
            preparedStatement.setTimestamp(5,mainaccount.getLastUpdated());

            int count = preparedStatement.executeUpdate();
            if(count == 1){
                System.out.println("Record for " + mainaccount.getAccountNumber() + " added successfully!!");

            }
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
    }

}
