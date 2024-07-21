package com.example.basic.interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import lombok.Setter;

import java.util.Map;

public class AuthorizationInterceptor extends AbstractInterceptor {
    @Setter
    private String role;

    @Override
    public String intercept(ActionInvocation actionInvocation) throws Exception {
        // Get session from actionInvocation
        Map<String, Object> session = actionInvocation.getInvocationContext().getSession();

        // Check if session has role equals to role
        // If no, return "unauthorized"
        String userRole = (String) session.get("role");
        if (userRole == null || !userRole.equals(role)) {
            return "unauthorized";
        }

        // If yes, continue to next interceptor or action
        return actionInvocation.invoke();
    }
}
