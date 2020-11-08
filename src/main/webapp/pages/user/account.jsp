<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
          integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">

    <title>Save User</title>
</head>
<body>
<jsp:include page="../_header.jsp"/>
<div class="container">
    <div class="row mt-5">
        <div class="col">
            Name: ${sessionScope.user.name}
            <br>
            Address: ${sessionScope.user.address.street}
            <br>
            <div class="mt-5">
                <a href="/user/changeUserName">Change name</a>
                <br>
                <a href="/user/changeUserPassword">Change password</a>
                <br>
                <a href="/user/changeUserAddress">Change address</a>
                <br>
                <c:if test="${sessionScope.basket.countBooks() != 0}">
                    <a href="/order/save">Create order</a>
                </c:if>
            </div>
            <div class="mt-5">
                <p>Basket: </p>
                <c:forEach items="${sessionScope.basket.books}" var="book">
                    <p>Book: ${book}</p>
                </c:forEach>
            </div>
            <div class="mt-5">
                <p>Orders: </p>
                <c:forEach items="${requestScope.orders}" var="order">
                    <p>Order: ${order}</p>
                </c:forEach>
            </div>


        </div>
    </div>
</div>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
        integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx"
        crossorigin="anonymous"></script>
</body>
</html>
