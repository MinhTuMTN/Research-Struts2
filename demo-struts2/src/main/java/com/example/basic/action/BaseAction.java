package com.example.basic.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import java.util.List;
import java.util.Map;

public class BaseAction extends ActionSupport {
    protected void addActionErrorToSession(String error) {
        Map<String, Object> session = ActionContext.getContext().getSession();
        session.put("actionError", error);
    }

    protected String getActionErrorFromSession() {
        Map<String, Object> session = ActionContext.getContext().getSession();
        String actionError = (String) session.get("actionError");
        session.remove("actionError");
        return actionError;
    }
}
