<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 15.10.2020
  Time: 19:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
          integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">

    <title>View Book</title>
</head>
<body>
<jsp:include page="../_header.jsp"/>

<div class="container">

    <p>Title ${requestScope.book.title}</p>
    <p>Description ${requestScope.book.description}</p>
    <p>Price ${requestScope.book.price}</p>
    <p>Author ${requestScope.book.author.name}</p>
    <p>Category ${requestScope.book.category.name}</p>

    <c:if test="${sessionScope.isUser}">
        <form action="/book/addToBasket" method="post">
            <input type="hidden" value="${requestScope.book.id}" name="id">
            <button>Add to basket</button>
        </form>
    </c:if>
    
</div>

<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
        integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx"
        crossorigin="anonymous"></script>
</body>
</html>
