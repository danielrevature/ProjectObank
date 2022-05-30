package org.example.dao;

import org.example.entity.MainAccount;
import org.example.entity.Transactions;
import org.example.entity.User;

import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.List;

public interface ITransactionsDao {
    public List<Transactions> getAllTransactions();
    public Transactions getTransactionById(int id);

    public void insert(Transactions transactions);
    public void update(Transactions transactions);
    public void delete(long id);
    public void insertMain(MainAccount mainaccount);
    public Transactions getTransaction(ResultSet resultSet);
}
