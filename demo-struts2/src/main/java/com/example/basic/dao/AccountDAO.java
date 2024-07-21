package com.example.basic.dao;

import com.example.basic.entity.Account;
import org.seasar.doma.Dao;
import org.seasar.doma.Insert;
import org.seasar.doma.Select;
import org.seasar.doma.Update;

import java.util.List;
import java.util.Optional;

@Dao
public interface AccountDAO {
    /**
     * Function to insert an account
     * @param account account to insert into the database
     * @return int
     */
    @Insert
    int insert(Account account);

    /**
     * Function to select all accounts
     * @return List of accounts
     */
    @Select
    List<Account> selectAll();

    /**
     * Function to update an account
     * @param account account to update
     * @return int
     */
    @Update
    int update(Account account);

    /**
     * Function to delete an account
     * @param userId userId to delete
     * @return int
     */
    @Select
    Optional<Account> selectById(int userId);

    /**
     * Function to search for an account
     * @param username username to search for
     * @return List of accounts
     */
    @Select
    List<Account> search(String username);

    /**
     * Function to get an account by username and password
     * @param username username to search for
     * @param password password to search for
     * @return int
     */
    @Select
    Optional<Account> selectByUsernameAndPassword(String username, String password);
}
