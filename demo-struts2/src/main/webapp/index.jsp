<%--
  Created by IntelliJ IDEA.
  User: MinhTuNguyen
  Date: 20/07/2024
  Time: 16:00 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>Hello World</title>
</head>
<body>
    <s:set var="isLoggedIn" value="#session.isLoggedIn" />
    <s:set var="role" value="#session.role" />
    <s:set var="username" value="#session.username" />
    <h1>Hello ${isLoggedIn == "true" ? username : 'World'}!</h1>
    <p>
        <s:if test="isLoggedIn">
            <a href="<s:url action='doLogout' />">
                Logout
            </a>
        </s:if>
        <s:else>
            <a href="<s:url action='login' />">
                Hi, please log in.
            </a>
        </s:else>
    </p>
    <s:if test="#session.role == 'admin'">
        <p><a href="<s:url action='account' />">Account Management</a>. </p>
    </s:if>
    <s:if test="#session.isLoggedIn">
        <p><a href="<s:url action='profile' />">Profile</a>. </p>
    </s:if>
</body>
</html>
