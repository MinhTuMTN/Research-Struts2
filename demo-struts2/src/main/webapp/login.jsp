<%--
  Created by IntelliJ IDEA.
  User: MinhTuNguyen
  Date: 21/07/2024
  Time: 10:53 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
    <s:actionerror />
    <s:form action="doLogin" method="post">
        <s:textfield name="accountModel.username" label="Username" />
        <s:password name="accountModel.password" label="Password" />
        <s:submit value="Login" />
    </s:form>
</body>
</html>
