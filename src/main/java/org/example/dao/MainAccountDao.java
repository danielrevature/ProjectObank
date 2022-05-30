package org.example.dao;

import org.example.entity.MainAccount;
import org.example.entity.Transactions;


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
                resultSet.next();
                MainAccount account = getMainAccount(resultSet);
                accounts.add(account);
            }
        }
        catch(SQLException ex){
            System.out.println(ex.getLocalizedMessage());
        }
        return accounts;
    }

    @Override
    public MainAccount getMainAccountById(int id) {
        String sql = "Select * from MainAccount where userid = ?;";
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, id);
<<<<<<< HEAD

            ResultSet resultSet = preparedStatement.executeQuery();

=======
            ResultSet resultSet = preparedStatement.executeQuery();
>>>>>>> d63e3df2de3bbd85c0f7047d9fd5f4d16550f656
            if(resultSet.next()){
                resultSet.next();
               MainAccount mainaccount = getMainAccount(resultSet);
            return mainaccount;
            }
        }
        catch(SQLException ex){
            System.out.println(ex.getLocalizedMessage());
        }
        return null;

    }
    @Override
    public MainAccount getMainAccountByAcc(long id) {
        String sql = "select * from mainaccount where accountNumber = ?;";
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
<<<<<<< HEAD




            if(resultSet.next()){

                MainAccount mainaccount = getMainAccount(resultSet);

=======
            if(resultSet.next()){
                resultSet.next();
                MainAccount mainaccount = getMainAccount(resultSet);
>>>>>>> d63e3df2de3bbd85c0f7047d9fd5f4d16550f656
                return mainaccount;
                }


         }
        catch(SQLException ex){
            System.out.println(ex.getLocalizedMessage());
        }
        return null;
    }

    @Override
    public void insert(MainAccount mainaccount) {
        {
            String sql = "Insert into MainAccount (userid, accountNumber,accounttype,balance,lastupdated) values(?,?,?,?,?);";
            try{
                PreparedStatement preparedStatement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
                preparedStatement.setInt(1, mainaccount.getUserId() );
                preparedStatement.setLong(2, mainaccount.getAccountNumber());
                preparedStatement.setString(3, mainaccount.getAccountType());
                preparedStatement.setFloat(4,mainaccount.getBalance());
                preparedStatement.setTimestamp(5,mainaccount.getLastUpdated());

                int count = preparedStatement.executeUpdate();
                if(count == 1){
                    System.out.println("Record  " + mainaccount.getAccountNumber() + " added successfully!!");
               }
            }
            catch(SQLException ex){
                System.out.println(ex.getLocalizedMessage());
            }
        }
    }

    @Override
    public void update(MainAccount mainaccount) {
<<<<<<< HEAD
        String sql = "Update MainAccount set accounttype = ?,balance = ?,lastupdated =? where accountnumber = ?;";
=======
        String sql = "Update MainAccount set accountNumber = ?, accounttype = ?, balance = ?, lastupdated =?;";
>>>>>>> d63e3df2de3bbd85c0f7047d9fd5f4d16550f656
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, mainaccount.getAccountType());
            preparedStatement.setFloat(2, mainaccount.getBalance());
            preparedStatement.setTimestamp(3, mainaccount.getLastUpdated());
            preparedStatement.setLong(4, mainaccount.getAccountNumber());
            int count= preparedStatement.executeUpdate();
            if(count == 1) System.out.println("Record updated successfully!");
            else
                System.out.println("Record not found!!");
        }
        catch(SQLException ex) {
            System.out.println(ex.getLocalizedMessage());
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
            System.out.println(ex.getLocalizedMessage());
        }

    }




    public MainAccount getMainAccount(ResultSet resultSet) {
         try {
<<<<<<< HEAD

            int userId= resultSet.getInt("userId");
            long accountnumber = resultSet.getLong("accountnumber" );
            String accounttype = resultSet.getString("accounttype");
            float balance = resultSet.getFloat("balance");
            Timestamp lastupdated = resultSet.getTimestamp("lastupdated");

            return new MainAccount(userId,accountnumber,accounttype,balance,lastupdated);
=======
            int id= resultSet.getInt("userid");
            long accountnumber = resultSet.getLong("accountnumber" );
            String accounttype = resultSet.getString("accounttype");
            BigDecimal balance = resultSet.getBigDecimal("balance");
           Timestamp lastupdated = resultSet.getTimestamp("lastupdated");
             System.out.println("Account nr :" + accountnumber);
             MainAccount mainAccount = new MainAccount(id,accountnumber,accounttype,balance,lastupdated);
             if(mainAccount == null) System.out.println("Could not find an account");
             else return mainAccount;
>>>>>>> d63e3df2de3bbd85c0f7047d9fd5f4d16550f656
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
