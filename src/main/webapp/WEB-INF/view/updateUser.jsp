<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="input" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Woland
  Date: 05.03.2021
  Time: 3:30
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
            <sec:authorize access="hasAuthority('MANAGER')">
                <li><a href="${pageContext.request.contextPath}/user/list">Customers</a></li>
            </sec:authorize>
            <sec:authorize access="hasAuthority('MANAGER')">
                <li><a href="${pageContext.request.contextPath}/user/add">ADD HOTEL</a></li>
            </sec:authorize>
            <%--            <sec:authorize access="hasAuthority('MANAGER')">--%>
            <%--                <li><a href="${pageContext.request.contextPath}/addUser">ADD USER</a></li>--%>
            <%--            </sec:authorize>--%>
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
            <h1 style="color: white">Add User</h1>
        </div>

        <div> <h6 style="color: black;"> It'll take just few minutes</h6></div>
        <%--        <form name="signUp" action="/signUp"--%>
        <form:form action="/update" method="post" modelAttribute="userDto"
                   cssStyle="width: 30%; background-color: #4e555b;opacity: 0.85;border-radius: 7px;margin:auto; width: 30%">

            <form:hidden path="id" />

            <label for="Username">
                <span class="tfsu">Firstname</span> <br>
                <form:input type="text" path="firstName" placeholder="Username" id="Username" cssStyle="border-radius: 5px;height: 38px;"></form:input>
                <br>
                    <%--                <input type="text" placeholder="Firstname" id="Username" name="firstName"  style="border-radius: 5px;height: 38px;">--%>
                <form:errors path="firstName" cssStyle="color: darkred"/>
            </label>

            <br>

            <label for="Username">
                <span class="tfsu">Lastname</span> <br>
                <form:input type="text" path="lastName" placeholder="Username" id="Username" cssStyle="border-radius: 5px;height: 38px;"></form:input>
                <br>
                    <%--                <input type="text" placeholder="Lastname"  name="lastName"  style="border-radius: 5px;height: 38px;">--%>
                <form:errors path="lastName" cssStyle="color: darkred"/>
            </label>

            <br>

            <label for="Username">
                <span class="tfsu">Username</span> <br>
                <form:input type="text" path="userName" placeholder="Username" id="Username" cssStyle="border-radius: 5px;height: 38px;"></form:input>
                <br>
                <form:errors path="userName" cssStyle="color: darkred"/>
            </label>

            <br>
            <label for="Username">
                <span class="tfsu">Mail</span> <br>
                <div>
                    <form:input type="text" path="email" placeholder="Email" id="Username" cssStyle="border-radius: 5px;height: 38px;"></form:input>
                        <%--                    <input type="text" placeholder="example@gmail.com" id="Username1" name="email" style="border-radius: 5px;height: 38px;"; >--%>
                    <br>
                    <form:errors path="email" cssStyle="color: darkred"/>
                </div>
            </label>
            <br>
            <label for="Username">
                <span class="tfsu">Password</span> <br>
                <form:input type="password" path="password" placeholder="Password" id="Username" cssStyle="border-radius: 5px;height: 38px;"></form:input>
                <br>
                <form:errors path="password" cssStyle="color: darkred"/>

                    <%--                <input type="password" placeholder="Password" id="passwordsiup" name="password" style="border-radius: 5px;height: 38px;">--%>
            </label>

            <br>

            <label for="Username">
                <span class="tfsu">Confirm pasword</span> <br>
                <form:input type="password" path="confirmPassword" placeholder="confirm pass" id="Username" cssStyle="border-radius: 5px;height: 38px;"></form:input>
                <br>
                <form:errors path="confirmPassword" cssStyle="color: #8b0000"/>

                    <%--                <input type="password" placeholder="Password" id="passwordsiup" name="password" style="border-radius: 5px;height: 38px;">--%>
            </label>

            <br>

                <label for="Role">
                    <span class="tfsu">New password</span> <br>
                    <form:select name="roles"  path="role">
                        <form:option value="${roles}"> --Choose role--</form:option>
                        <form:options items="${roles}"></form:options>
                    </form:select>
                </label>
            <br>

            <input  class="form-control btn" name="submit" type="submit" value="Confirm" style="background-color: coral;width:80px;margin-bottom: 8px;margin-top: 8px;">
            <br>
        </form:form>


    </div> <!-- End of container-->
</div>
<!--End of sbanner-->




</body>
</html>
