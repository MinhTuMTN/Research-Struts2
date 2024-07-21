package com.example.basic.action;

import com.example.basic.entity.Account;
import com.example.basic.model.AccountModel;
import com.example.basic.model.MessageStore;
import com.example.basic.service.IAccountService;
import com.example.basic.service.impl.AccountServiceImpl;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.apache.struts2.action.ParametersAware;
import org.apache.struts2.action.SessionAware;
import org.apache.struts2.dispatcher.HttpParameters;

import java.util.List;
import java.util.Map;

public class AccountAction extends BaseAction {
    @Getter
    @Setter
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
        String actionError = getActionErrorFromSession();
        addActionError(actionError);

        String username = (String) ActionContext.getContext().getSession().get("username");
        if (username == null) {
            return LOGIN;
        }
        accounts = accountService.selectAll();
        return SUCCESS;
    }

    public String addAccount() {
        accountService.insert(accountModel);
        return SUCCESS;
    }

    public String deleteAccount() {
        int sessionUserId = (int) ActionContext.getContext().getSession().get("userId");
        if (sessionUserId == userId) {
            addActionErrorToSession("You cannot delete your own account");
        } else {
            accountService.delete(userId);
        }

        return SUCCESS;
    }

    public String restoreAccount() {
        accountService.restore(userId);
        accounts = accountService.selectAll();
        return SUCCESS;
    }

    public String searchAccount() {
        accounts = accountService.search(usernameQuery);
        return SUCCESS;
    }
}
