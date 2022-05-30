package org.example.dao;

import org.example.entity.User;

import java.sql.ResultSet;
import java.util.List;

public interface IUserDao {
    public List<User> getAllUsers();

    User getUser(ResultSet resultSet);
    public void sp_insert(User user);
    public User getUserById(int id);
    public void insert(User user);
    public void update(User user);
    public void delete(int id);
    public boolean getCredentials(String username, String password, boolean found);


}
