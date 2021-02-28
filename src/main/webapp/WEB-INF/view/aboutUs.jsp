<%--
  Created by IntelliJ IDEA.
  User: Woland
  Date: 27.02.2021
  Time: 1:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie-edge">
    <title>Document</title>

    <style>
        <%@include file="/WEB-INF/css/style.css"%>
    </style>

    <%--    <link href="${pageContext.request.contextPath}/css/bootstrap.css">--%>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" crossorigin="anonymous">



</head>
<body style="background-color: #343a40">

<div id="header" style="margin-left: 10%;margin-right: 10%;">
    <div class="container">
        <h1 class="chy">EasyBooking</h1>
        <ul class="navbar">
            <li><a href="${pageContext.request.contextPath}/">Home</a></li>
            <li><a href="${pageContext.request.contextPath}/signUp">Sign up</a></li>
            <li><a href="${pageContext.request.contextPath}/aboutUs">About Us</a></li>
        </ul>
    </div> <!--End of container-->
</div> <!--End of header-->

<div id="banner" style="background-image: url(https://images.creativemarket.com/0.1.0/ps/1422659/4122/2696/m1/fpnw/wm1/world-map-orange-.jpg?1467641527&s=235e067fec06b0fbd69c747d3d7236ac);">
    <div class="container">
        <h1>FIND YOUR HOTEL</h1>


    </div> <!--End of container-->
</div> <!--End of banner-->


</body>
</html>
