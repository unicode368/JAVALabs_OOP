<%@ page import="java.util.ArrayList" %>
<%@ page import="com.example.JavaLab4.model.Book" %>
<%@ page import="com.example.JavaLab4.model.user.User" %>
<%@ page import="com.example.JavaLab4.model.user.UserType" %>
<%@ page import="com.example.JavaLab4.servlets.*" %><%--
  Created by IntelliJ IDEA.
  User: Olya
  Date: 06.01.2021
  Time: 1:34
  To change this template use File | Settings | File Templates.
--%>
<script>
    function getVal(param) {
        console.log(param.getAttribute("value"));
    }
</script>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%
    ArrayList<Book> booklist = (ArrayList<Book>) request.getAttribute("booklist");
    user = (User) request.getSession(false).getAttribute("user");
    if(booklist != null && booklist.size() > 0) {
%>
<%
    int j;
    for (int i = 0; i < booklist.size(); i = i + 3) {
%>
<div class="Row">
<%    j = i;
        for (; j == i || j > 0 && j % 3 != 0; j++) {
            if (j >= booklist.size()) {
                break;
            } %>

            <div class="Column" style="text-align: center; padding: 70px" >
                <param name="book" id=<%=booklist.get(j).getId()%> value=<%=booklist.get(j).getId()%> />
            <div>Назва: <%=booklist.get(j).getName()%></div>
            <div>Автор: <%=booklist.get(j).getAuthor()%></div>
            <div>Видання: <%=booklist.get(j).getEdition()%></div>
            <div>Рік видання: <%=booklist.get(j).getDate().toString()%></div>
                <%
                    if (user != null && user.getRole() == UserType.READER) {%>
                <form>
                    <button onclick="getVal(document.getElementById(<%=booklist.get(j).getId()%>))">Замовити</button>
                </form>
                <% } else if (user != null && user.getRole() == UserType.ADMIN) { %>
                <form>
                    <button>Редагувати</button>
                    <button>Видалити</button>
                </form>
                <% } %>
            </div>
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
