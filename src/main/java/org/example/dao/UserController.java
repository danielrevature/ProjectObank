package org.example.dao;

import org.example.entity.Transactions;
import org.example.entity.User;
import org.example.services.AccountMaintenance;
import org.example.services.CustomerService;
import org.example.services.NewRegistration;

import java.sql.*;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

public class UserController implements IUserDao{

    private ZonedDateTime now = ZonedDateTime.now();
    private Timestamp date = Timestamp.valueOf(now.toLocalDateTime());
    Connection connection;
    public UserController(){
        connection = ConnectionFactory.getConnection();
    }

    @Override
    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        String query = "Select * from users;";
       try{
           PreparedStatement preparedStatement = connection.prepareStatement(query);
           ResultSet resultSet = preparedStatement.executeQuery();
           while(resultSet.next()){
               resultSet.next();
               User user = getUser(resultSet);
               users.add(user);
           }
       }
       catch(SQLException ex){
           ex.printStackTrace();
       }
        return users;
    }

    @Override
    public User getUser(ResultSet resultSet) {
        try {
            int userid = resultSet.getInt("userId");
            String firstname = resultSet.getString("firstName");
            String lastname = resultSet.getString("lastName");
            String username = resultSet.getString("userName");
            String password = resultSet.getString("password");
            String usertype = resultSet.getString("userType");
            Timestamp createdon = resultSet.getTimestamp("createdon");
            User user = new User(userid, firstname, lastname, username, password, usertype, createdon);
            return user;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public User getUserById(int id) {
        String query = "Select * from users where userid = ?;";
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                resultSet.next();
                User user = getUser(resultSet);
                return user;
            }
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public void insert(User user) {
        String query = "Insert into users(userid,firstname,lastname,username,password,usertype,createdOn) values(default,?,?,?,?,?,?);";
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

            preparedStatement.setString(1,user.getFirstName());
            preparedStatement.setString(2, user.getLastName());
            preparedStatement.setString(3,user.getUserName());
            preparedStatement.setString(4, user.getPassword());
            preparedStatement.setString(5, user.getUserType());
            preparedStatement.setTimestamp(6, date);

            int count = preparedStatement.executeUpdate();
            if(count == 1){
                System.out.println("Record added successfully!!");
                ResultSet resultSet = preparedStatement.getGeneratedKeys();

                resultSet.next();
                int id = resultSet.getInt("userid");
                user.setUserId(id);
                System.out.println("Added new ID:" + id);
                NewRegistration.tranUserId(id);
            }
            else {
                System.out.println("!!! Insert not successful !!!");
            }


        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
    }

    @Override
    public void update(User user) {
        String query = "Update Users set firstName = ?, lastName = ?, userName = ?, password = ?, userType = ?;";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, user.getFirstName());
            preparedStatement.setString(2, user.getLastName());
            preparedStatement.setString(3, user.getUserName());
            preparedStatement.setString(4, user.getPassword());
            preparedStatement.setString(5, user.getUserType());

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
        String query = "Delete from Users where Userid = ?;";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
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

    public User loginCheck(ResultSet resultSet) {
        try {
            String username = resultSet.getString("userName");
            String password = resultSet.getString("password");
            return new User(username,password);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }


    @Override
    public boolean getCredentials(String username, String password, boolean found) {
        String query = "Select username, password from users where username = ? and password= ?;";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString( 1, username);
            preparedStatement.setString(2, password);

            ResultSet resultSet = preparedStatement.executeQuery();

            if(resultSet.next()) {
                resultSet.next();
                User user = loginCheck(resultSet);
                found = true;
            }
            else {

                found = false;
            }

        }
        catch(SQLException ex) {
            ex.printStackTrace();
        }
        return found;
    }

}
