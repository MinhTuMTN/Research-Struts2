<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Hello World!</title>
</head>
<body>
    <section>
        <s:form action="addAccount" method="post">
            <s:textfield name="accountModel.username" label="Username" />
            <s:password name="accountModel.password" label="Password" />
            <s:submit />
        </s:form>
    </section>
    <section>
        <h2>Account List</h2>
        <div>
            <s:form action="searchAccount" method="GET">
                <s:textfield name="usernameQuery" label="Search" />
                <s:submit value="Search" />
            </s:form>
        </div>
        <table>
            <thead>
                <tr>
                    <th>UserID</th>
                    <th>Username</th>
                    <th>Password</th>
                    <th>Created At</th>
                    <th>Updated At</th>
                    <th>Status</th>
                    <th>Action</th>
                </tr>
            </thead>
            <tbody>
                <s:iterator value="accounts" var="account">
                    <tr>
                        <td>${account.userId}</td>
                        <td><s:property value="username" /></td>
                        <td><s:property value="password" /></td>
                        <td><s:property value="createdAt" /></td>
                        <td><s:property value="updatedAt" /></td>
                        <td>
                            <s:if test="#account.deleted">
                                Deleted
                            </s:if>
                            <s:else>
                                Active
                            </s:else>
                        </td>
                        <td>
                            <s:if test="#account.deleted">
                                <s:url action="restoreAccount" var="restoreUrl">
                                    <s:param name="userId" value="%{#account.userId}" />
                                </s:url>
                                <a href="<s:property value='#restoreUrl' />">Restore</a>
                            </s:if>
                            <s:else>
                                <s:url action="deleteAccount" var="deleteUrl">
                                    <s:param name="userId" value="%{#account.userId}" />
                                </s:url>
                                <a href="<s:property value='#deleteUrl' />">Delete</a>
                            </s:else>
                        </td>
                    </tr>
                </s:iterator>
            </tbody>
        </table>
    </section>
</body>
</html>