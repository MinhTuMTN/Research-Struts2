package com.example.basic.action;

import com.example.basic.entity.Account;
import com.example.basic.model.AccountModel;
import com.example.basic.service.IAccountService;
import com.example.basic.service.impl.AccountServiceImpl;
import com.opensymphony.xwork2.ActionSupport;
import lombok.Getter;
import lombok.Setter;
import org.apache.struts2.action.SessionAware;

import java.util.Map;
import java.util.Objects;

public class LoginAction extends BaseAction implements SessionAware {
    @Getter
    @Setter
    private AccountModel accountModel;

    private Map<String, Object> session;
    private final IAccountService accountService;

    public LoginAction() {
        this.accountService = new AccountServiceImpl();
    }

    public String execute() {
        String actionError = getActionErrorFromSession();
        addActionError(actionError);
        return INPUT;
    }

    public String doLogin() {
        String username = accountModel.getUsername();
        String password = accountModel.getPassword();
        Account account = accountService.isPasswordMatch(username, password);

        if (account != null && !account.isDeleted()) {
            // Set session with username and role for further use
            session.put("userId", account.getUserId());
            session.put("username", accountModel.getUsername());
            session.put("role", Objects.equals(username, "admin") ? "admin" : "user");
            session.put("isLoggedIn", true);

            return SUCCESS;
        } else if (account != null) {
            addActionErrorToSession("Account is deleted. Please contact the administrator");
            return ERROR;
        } else {
            addActionError("Invalid username or password");
            return ERROR;
        }
    }

    public String doLogout() {
        session.clear();
        return SUCCESS;
    }

    @Override
    public void withSession(Map<String, Object> map) {
        this.session = map;
    }
}
