package com.example.basic.service.impl;

import com.example.basic.config.DbConfig;
import com.example.basic.dao.AccountDAO;
import com.example.basic.dao.AccountDAOImpl;
import com.example.basic.entity.Account;
import com.example.basic.model.AccountModel;
import com.example.basic.service.IAccountService;
import org.seasar.doma.jdbc.SqlExecutionException;
import org.seasar.doma.jdbc.tx.TransactionManager;

import java.util.List;
import java.util.Optional;

public class AccountServiceImpl implements IAccountService {
    private final AccountDAO accountDAO;

    public AccountServiceImpl() {
        accountDAO = new AccountDAOImpl(DbConfig.singleton());
    }

    @Override
    public void insert(AccountModel accountModel) {
        TransactionManager tm = DbConfig.singleton().getTransactionManager();
        tm.required(() -> {
            try {
                Account account = new Account();
                account.setUsername(accountModel.getUsername());
                account.setPassword(accountModel.getPassword());
                account.setDeleted(false);

                accountDAO.insert(account);
            } catch (SqlExecutionException e) {
                e.printStackTrace();
            }

            catch (Exception e) {
                e.printStackTrace();
            }
        });

    }

    @Override
    public List<Account> selectAll() {
        TransactionManager tm = DbConfig.singleton().getTransactionManager();

        return tm.required(() -> {
            try {
                return accountDAO.selectAll();
            } catch (SqlExecutionException e) {
                e.printStackTrace();
            }

            catch (Exception e) {
                e.printStackTrace();
            }

            return null;
        });
    }

    @Override
    public List<Account> search(String username) {
        TransactionManager tm = DbConfig.singleton().getTransactionManager();

        return tm.required(() -> {
            return accountDAO.search(username);
        });
    }

    @Override
    public void delete(int userId) {
        TransactionManager tm = DbConfig.singleton().getTransactionManager();
        tm.required(() -> {
            Optional<Account> account = accountDAO.selectById(userId);
            if (account.isEmpty())
                return;

            Account acc = account.get();
            acc.setDeleted(true);
            accountDAO.update(acc);
        });
    }

    @Override
    public void restore(int userId) {
        TransactionManager tm = DbConfig.singleton().getTransactionManager();
        tm.required(() -> {
            Optional<Account> account = accountDAO.selectById(userId);
            if (account.isEmpty())
                return;

            Account acc = account.get();
            acc.setDeleted(false);
            accountDAO.update(acc);
        });
    }
}
