<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="input" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Woland
  Date: 27.02.2021
  Time: 0:42
  To change this template use File | Settings | File Templates.
--%>
<html>
<head>
    <title>Title</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie-edge">

    <style>
        <%@include file="/WEB-INF/css/style.css"%>
    </style>

    <%--    <link href="${pageContext.request.contextPath}/css/bootstrap.css">--%>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" crossorigin="anonymous">

</head>
<body style="background-color: #343a40">

<div id="header" style="margin-left: 10%;
    margin-right: 10%;">
    <div class="container">
        <h1 class="chy">EasyBooking</h1>
        <ul class="navbar">
            <li><a href="${pageContext.request.contextPath}/">Home</a></li>
            <sec:authorize access="!isAuthenticated()">
                <li><a href="${pageContext.request.contextPath}/signUp">Sign up</a></li>
            </sec:authorize>

            <li><a href="${pageContext.request.contextPath}/aboutUs">About Us</a></li>

            <sec:authorize access="isAuthenticated()">
                <li><a href="${pageContext.request.contextPath}/logout">log out</a></li>
            </sec:authorize>
        </ul>
    </div> <!--End of container-->
</div> <!--End of header-->


<div id="sbanner" style="background-image: url(https://images.creativemarket.com/0.1.0/ps/1422659/4122/2696/m1/fpnw/wm1/world-map-orange-.jpg?1467641527&s=235e067fec06b0fbd69c747d3d7236ac);">
    <div class="container">

        <div style="padding-top: 55px; ">
            <h1 style="color: white">Sign up</h1>
        </div>

        <div> <h6 style="color: black;"> It'll take just few minutes</h6></div>
<%--        <form name="signUp" action="/signUp"--%>
        <form:form action="/signUp" method="post" modelAttribute="user"
            cssStyle="width: 30%; background-color: #4e555b;opacity: 0.85;border-radius: 7px;margin:auto">

            <label for="Username">
                <span class="tfsu">Firstname</span> <br>
                <form:input type="text" path="firstName" placeholder="Username" id="Username" cssStyle="border-radius: 5px;height: 38px;"></form:input>
<%--                <input type="text" placeholder="Firstname" id="Username" name="firstName"  style="border-radius: 5px;height: 38px;">--%>
            </label>

            <br>

            <label for="Username">
                <span class="tfsu">Lastname</span> <br>
                <form:input type="text" path="lastName" placeholder="Username" id="Username" cssStyle="border-radius: 5px;height: 38px;"></form:input>
<%--                <input type="text" placeholder="Lastname"  name="lastName"  style="border-radius: 5px;height: 38px;">--%>
            </label>

            <br>

            <label for="Username">
                <span class="tfsu">Username</span> <br>
                <form:input type="text" path="userName" placeholder="Username" id="Username" cssStyle="border-radius: 5px;height: 38px;"></form:input>

<%--                <input type="text" placeholder="Username"  name="username"  style="border-radius: 5px;height: 38px;">--%>
            </label>

            <br>
            <label for="Username">
                <span class="tfsu">Mail</span> <br>
                <div>
                    <form:input type="text" path="email" placeholder="Username" id="Username" cssStyle="border-radius: 5px;height: 38px;"></form:input>
<%--                    <input type="text" placeholder="example@gmail.com" id="Username1" name="email" style="border-radius: 5px;height: 38px;"; >--%>
                </div>
            </label>
            <br>
            <label for="Username">
                <span class="tfsu">New password</span> <br>
                <form:input type="password" path="password" placeholder="Username" id="Username" cssStyle="border-radius: 5px;height: 38px;"></form:input>

<%--                <input type="password" placeholder="Password" id="passwordsiup" name="password" style="border-radius: 5px;height: 38px;">--%>
            </label>
            <br>
<%--            <label for="Username">--%>
<%--                <span class="tfsu">Confirm password</span> <br>--%>
<%--                <input type="password" placeholder="Confirm password" id="cpassword" name="cpassword" style="border-radius: 5px;height: 38px;">--%>
<%--            </label>--%>
<%--            <br>--%>

            <input  class="form-control btn" name="submit" type="submit" value="Confirm" style="background-color: coral;width:80px;margin-bottom: 8px;margin-top: 8px;">
            <br>
        </form:form>


    </div> <!-- End of container-->
</div>
<!--End of sbanner-->




</body>
</html>
