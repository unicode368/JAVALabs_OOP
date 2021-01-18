<%--
  Created by IntelliJ IDEA.
  User: Olya
  Date: 19.12.2020
  Time: 5:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<header>
    <div class="topnav">
        <a href="${pageContext.request.contextPath}/">
            <div class="topnavC">Головна</div>
        </a>
        <a href="userList">
            <div class="topnavC">Користувачі</div>
        </a>
        <div class="topnav-right">
            <a href="logout">
                <div class="topnavC">Вихід</div>
            </a>
        </div>
    </div>
</header>