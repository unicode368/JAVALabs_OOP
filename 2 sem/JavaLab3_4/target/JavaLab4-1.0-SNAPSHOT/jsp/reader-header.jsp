<%--
  Created by IntelliJ IDEA.
  User: Olya
  Date: 19.12.2020
  Time: 5:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8"%>
<header>
    <script type="application/javascript">
        function showSearchBar() {
            document.getElementById('search-pane').innerHTML =
                "<form action='${pageContext.request.contextPath}/' method='post'> <input type=\"text\" placeholder=\"Search..\" name=\"search\"> <input type=\"radio\" name=\"search-type\" value=\"name\"> name<br> <input type=\"radio\" name=\"search-type\" value=\"author\"> author<br> <button type=\"submit\" onclick=\"clear()\">Submit</button> </form>";
        }
    </script>
</header>
<div class="topnav">
    <a href="${pageContext.request.contextPath}/">
        <div class="topnavC">Головна</div>
    </a>
    <a href="orders">
        <div class="topnavC">Мій профіль</div>
    </a>
    <div class="topnavC" onclick="showSearchBar()">Пошук</div>
    <div class="topnav-right">
        <a href="logout">
            <div class="topnavC">Вихід</div>
        </a>
    </div>
</div>
<div id="search-pane"></div>