<%@ page import="com.example.JavaLab4.model.user.User" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.example.JavaLab4.model.user.UserType" %><%--
  Created by IntelliJ IDEA.
  User: Olya
  Date: 17.01.2021
  Time: 19:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<html>
<head>
    <title>Користувачі</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/home.css" />
</head>
<body>
<%@include file="admin-header.jsp" %>
<div style="height: 30px"></div>
<div class="divTable" style="background-color: azure; border-radius: 25px" id="divTable">
<%
    ArrayList<User> user_list = (ArrayList<User>) request.getAttribute("userlist");
    if(user_list != null && user_list.size() > 0) {
%>
<%
    int j;
    for (int i = 0; i < user_list.size(); i = i + 3) {
%>
<div class="Row">
    <%    j = i;
        for (; j == i || j > 0 && j % 3 != 0; j++) {
            if (j >= user_list.size()) {
                break;
            }
            if (user_list.get(j).getRole() == UserType.ADMIN) {
                continue;
            }%>
    <div class="Column" style="text-align: center; padding: 70px" >
        <param name="book" id=<%=user_list.get(j).getId()%> value=<%=user_list.get(j).getId()%> />
        <%
            if (user_list.get(j).getRole() == UserType.READER) {
        %>
        <div>Читач:</div>
        <%} else if (user_list.get(j).getRole() == UserType.LIBRARIAN) {%>
        <div>Бібліотекар: </div>
        <%   } %>
        <div>   Логін: <%=user_list.get(j).getLogin()%></div>
        <div>   Пароль: <%=user_list.get(j).getPassword()%></div>
        <div>   Стан: <%=user_list.get(j).getBlocked() ? "заблоковано" : "не заблоковано"%></div>
        <form>
            <button>Заблокувати/Розблокувати</button>
        </form>
    </div>
    <%   } %>
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
