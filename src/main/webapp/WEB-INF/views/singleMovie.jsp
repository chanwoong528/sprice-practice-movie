<%--
  Created by IntelliJ IDEA.
  User: USER_20221021
  Date: 2023-07-02
  Time: 오전 4:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Single Movie ${targetMovie.title }</title>
</head>
<body>
이름 : ${targetMovie.title }<br>
이름 : ${targetMovie.imdbId }<br>
이름 : ${targetMovie.imdbId }<br>
<img src=${targetMovie.poster}/>
<ul>
    <c:forEach var="genre" items="${targetMovie.genres}">
        <li>${genre}</li>
    </c:forEach>
</ul>
</body>
</html>
