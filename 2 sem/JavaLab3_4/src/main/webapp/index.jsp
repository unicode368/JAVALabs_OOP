<%@ page import="com.example.JavaLab4.model.user.User" %>
<%@ page import="com.example.JavaLab4.model.user.UserType" %>
<%@ page import="com.example.JavaLab4.servlets.*" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/home.css" />
</head>
<%
    User user = (User) request.getSession(false).getAttribute("user");
    if (user != null && user.getRole() == UserType.READER) {%>
<%@include file="jsp/reader-header.jsp" %>
        <% } else if (user != null && user.getRole() == UserType.ADMIN) { %>
<%@include file="jsp/admin-header.jsp" %>
        <% } else if (user != null && user.getRole() == UserType.LIBRARIAN) { %>
<%@include file="jsp/librarian-header.jsp" %>
            <% } else { %>
<%@include file="jsp/header.jsp" %>
<%}%>
<jsp:include page="/bookList" />
<body>
<h1><%= "Ласкаво просимо!" %>
</h1>
<br/>
<% if (request.getAttribute("search") != null &&
         (Boolean) request.getAttribute("search")) { %>
<h2><%= "Результати пошуку: " %></h2>
<%    } %>
<form>
<div class="divTable" style="background-color: azure; border-radius: 25px" id="divTable">
    <%@include file="jsp/book-list.jsp" %>
</div>
</form>
<div style="height: 30px"></div>
<form action="${pageContext.request.contextPath}/" method="POST">
    <select name="sort" id="sort" onchange="this.form.submit()">
        <option value="" disabled selected>Сортувати за...</option>
        <option value="name">Ім'ям</option>
        <option value="author">Автором</option>
        <option value="edition">Виданням</option>
        <option value="date">Датою видання</option>
    </select>
</form>
</body>
</html>