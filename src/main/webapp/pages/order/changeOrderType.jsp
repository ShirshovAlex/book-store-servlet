<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
          integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">

    <title>Change order type</title>
</head>
<body>
<jsp:include page="../_header.jsp"/>
<div class="container">
    <div class="row mt-5">
        <div class="col">
            <form action="/order/changeOrderType" method="post">
                <div class="form-group">
                    <select name="orderId" class="form-control">
                        <c:forEach items="${requestScope.orders}" var="order">
                            <option value="${order.id}">${order.id}>>${order.delivery}</option>
                        </c:forEach>
                    </select>
                    <select name="isDelivery" class="form-control">
                            <option value="true">delivery</option>
                            <option value="false">pickUp</option>
                    </select>
                    <input type="text" name="street">
                    <select name="storeId" class="form-control">
                        <c:forEach items="${requestScope.stores}" var="store">
                            <option value="${store.id}">${store.name}>>${store.address}</option>
                        </c:forEach>
                    </select>
                </div>
                <button type="submit" class="btn btn-primary">Ok</button>
            </form>
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
