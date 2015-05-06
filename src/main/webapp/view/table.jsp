<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Table</title>
    <link rel="stylesheet" type="text/css" href="http://netdna.bootstrapcdn.com/bootstrap/3.1.0/css/bootstrap.min.css">
</head>
<body>
<div align="center">
    <table class="table table-striped table-responsive">
        <caption><h3>Deposits parsed by <b><c:out value="${parser}"/></b> parser</h3></caption>
        <tr>
            <th>Deposit ID</th>
            <th>Bank name</th>
            <th>Deposit type</th>
            <th>Depositor</th>
            <th>Account ID</th>
            <th>Amount of deposit</th>
            <th>Profitability</th>
            <th>Deposit time constraints</th>
        </tr>
        <c:forEach var="deposit" items="${deposits}">
            <tr>
                <td><c:out value="${deposit.depositId}" /></td>
                <td><c:out value="${deposit.bankName}" /></td>
                <td><c:out value="${deposit.depositType}" /></td>
                <td><c:out value="${deposit.depositor}" /></td>
                <td><c:out value="${deposit.accountId}" /></td>
                <td><c:out value="${deposit.amountOfDeposit}" /></td>
                <td><c:out value="${deposit.profitability}" /></td>
                <td><c:out value="${deposit.timeConstraints}" /></td>
            </tr>
        </c:forEach>
    </table>
    <a href="/">back</a>
</div>

</body>
</html>