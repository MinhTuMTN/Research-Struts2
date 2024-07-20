package com.example.basic.action;

import com.example.basic.entity.Account;
import com.example.basic.model.AccountModel;
import com.example.basic.model.MessageStore;
import com.example.basic.service.IAccountService;
import com.example.basic.service.impl.AccountServiceImpl;
import com.opensymphony.xwork2.ActionSupport;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

public class AccountAction extends ActionSupport {
    private MessageStore messageStore;

    @Getter
    @Setter
    private AccountModel accountModel;

    @Getter
    private List<Account> accounts;

    @Getter
    @Setter
    private int userId;

    @Getter
    @Setter
    private String usernameQuery;

    private final IAccountService accountService;

    public AccountAction() {
        this.accountService = new AccountServiceImpl();
    }

    public String execute() {
        messageStore = new MessageStore();
        accounts = accountService.selectAll();
        return SUCCESS;
    }

    public String addAccount() {
        accountService.insert(accountModel);
        return SUCCESS;
    }

    public String deleteAccount() {
        accountService.delete(userId);
        return SUCCESS;
    }

    public String restoreAccount() {
        accountService.restore(userId);
        return SUCCESS;
    }

    public String searchAccount() {
        accounts = accountService.search(usernameQuery);
        return SUCCESS;
    }

    public MessageStore getMessageStore() {
        return messageStore;
    }
}
