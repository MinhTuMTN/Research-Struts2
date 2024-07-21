package com.example.basic.service;


import com.example.basic.entity.Account;
import com.example.basic.model.AccountModel;

import java.util.List;

public interface IAccountService {
    /**
     * Function to insert an account
     * @param accountModel accountModel to insert into the database
     */
    void insert(AccountModel accountModel);

    /**
     * Function to select all accounts
     * @return List<Account>
     */
    List<Account> selectAll();

    /**
     * Function to search for an account
     * @param username username to search for
     * @return List<Account> list of accounts
     */
    List<Account> search(String username);

    /**
     * Function to delete an account
     * @param userId userId to delete
     */
    void delete(int userId);

    /**
     * Function to restore an account
     * @param userId userId to restore
     */
    void restore(int userId);

    /**
     * Function to check if the password matches the username
     * @param username username to check
     * @param password password to check
     * @return account object
     */
    Account isPasswordMatch(String username, String password);
}
