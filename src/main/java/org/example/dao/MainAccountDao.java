package org.example.dao;

import org.example.entity.MainAccount;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MainAccountDao implements IMainAccountDao {
    Connection connection;
    public MainAccountDao(){
        connection = ConnectionFactory.getConnection();
    }

    @Override
    public List<MainAccount> getAllMainAccounts() {

        List<MainAccount> accounts = new ArrayList<>();
        String sql = "Select * from MainAccount;";
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                MainAccount account = getMainAccount(resultSet);
                accounts.add(account);
            }
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
        return accounts;
    }

    @Override
    public MainAccount getMainAccountById(int id) {
        String sql = "Select * from MainAccount where accountnumber = ?;";
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            preparedStatement.setLong(1, id);
            if(resultSet.next()){
               MainAccount mainaccount = getMainAccount(resultSet);
            return mainaccount;
            }
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
        return null;

    }
    @Override
    public MainAccount getMainAccountByAcc(long id) {
        String sql = "select * from mainaccount where accountnumber = ?;";
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setLong(1, id);


            ResultSet resultSet = preparedStatement.executeQuery();
            System.out.println("Result   " + resultSet.next());
            if(resultSet.next()){


                MainAccount mainaccount = getMainAccount(resultSet);


                return mainaccount;
            }
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public void insert(MainAccount mainaccount) {
        {
            String sql = "Insert into MainAccount (userid, accountNumber,accounttype,balance,lastupdated) values(?,?,?,?,?); ";
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

    @Override
    public void update(MainAccount mainaccount) {
        String sql = "Update MainAccount set accountNumber =? ,accounttype = ?,balance = ?,lastupdated =?;";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, mainaccount.getAccountNumber());
            preparedStatement.setString(2, mainaccount.getAccountType());
            preparedStatement.setBigDecimal(3, mainaccount.getBalance());
            preparedStatement.setTimestamp(4, mainaccount.getLastUpdated());
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
    public void delete(int id) {
        String sql = "Delete from MainAccount where AccountNumber = ?;";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,  id);
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


    public MainAccount getMainAccount(ResultSet resultSet) {
         try {
             resultSet.next();
            int id= resultSet.getInt("userId");
            Long accountnumber = resultSet.getLong("accountnumber" );
            String accounttype = resultSet.getString("accounttype");
            BigDecimal balance = resultSet.getBigDecimal("balance");
           Timestamp lastupdated = resultSet.getTimestamp("lastupdated");
             System.out.println("Account nr :" + accountnumber);
           return new MainAccount(id,accountnumber,accounttype,balance,lastupdated);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
    @Override
    public void insertStoredProcedure(){
      //  string sql = "call displayTrans(?::BigInteger , ?::String,?::Timestamp, ?::String,?::String,?::)"
    }
}
