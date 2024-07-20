package com.example.basic.service;


import com.example.basic.entity.Account;
import com.example.basic.model.AccountModel;

import java.util.List;

public interface IAccountService {
    void insert(AccountModel accountModel);
    List<Account> selectAll();
    List<Account> search(String username);
    void delete(int userId);
    void restore(int userId);
}
