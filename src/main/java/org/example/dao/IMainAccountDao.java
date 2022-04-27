package org.example.dao;

import org.example.entity.MainAccount;

import java.sql.ResultSet;
import java.util.List;

public interface IMainAccountDao {

    public List<MainAccount> getAllMainAccounts();
    public MainAccount getMainAccountById(int id);
    public MainAccount getMainAccountByAcc(long id);
    public void insert(MainAccount mainAccount);
    public void update(MainAccount mainAccount);
    public void delete(int id);
    public MainAccount getMainAccount(ResultSet resultSet);
    public void insertStoredProcedure();
}
