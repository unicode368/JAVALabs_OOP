<%@ page import="com.example.JavaLab4.model.user.Reader" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.example.JavaLab4.model.Order" %>
<%@ page import="com.example.JavaLab4.model.dao.UserDAO" %>
<%@ page import="com.example.JavaLab4.model.dao.BookDAO" %><%--
  Created by IntelliJ IDEA.
  User: Olya
  Date: 24.12.2020
  Time: 23:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" %>
<html>
<head>
    <title>Orders</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/home.css" />
</head>
<%@include file="reader-header.jsp" %>
<body>
<%
    Reader reader = (Reader) request.getSession(false).getAttribute("user");
    ArrayList<Order> orders = reader.getOrders();%>
<div style="height: 30px"></div>
<div>Мене звати... <%=reader.getLogin()%></div>
<div>Штраф: <%=reader.getFine()%></div>
<h1><%= "Мої замовлення:" %>
</h1>
<br/>
<%    if(orders != null && orders.size() > 0) {
    int j; %>
<div class="divTable" style="background-color: azure; border-radius: 25px" id="divTable">
<%    for (int i = 0; i < orders.size(); i = i + 3) {
%>
<div class="Row">
    <%    j = i;
        for (; j == i || j > 0 && j % 3 != 0; j++) {
            if (j >= orders.size()) {
                break;
            } %>

    <div class="Column" style="text-align: center; padding: 70px">
<%--        <div>Бібліотекар: <%=users.get(orders.get(j).getLibrarian() - 1).getLogin()%></div>
        <div>Книга: </div>
        <div>   Назва: <%=books.get(orders.get(j).getBook() - 1).getName()%></div>
        <div>   Автор: <%=books.get(orders.get(j).getBook() - 1).getAuthor()%></div>
        <div>   Видання: <%=books.get(orders.get(j).getBook() - 1).getEdition()%></div>
        <div>   Рік видання: <%=books.get(orders.get(j).getBook() - 1).getDate().toString()%></div>
        <div>Дата замовлення: <%=orders.get(j).getDate().toString()%></div>
        <div>Дата повернення: <%=orders.get(j).getReturnDate().toString()%></div>
    </div>--%>
    <%        } %>
</div>
<%

    }

}else{

%>
<tr>

    <td> Записів не знайдено. </td>

</tr>

<%}%>
</div>
</body>
</html>
