<%--
 Created by IntelliJ IDEA.
  User: Woland
  Date: 26.02.2021
  Time: 22:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
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
        <sec:authorize access="isAuthenticated()">
            <h1 class="chy">
                <img style="height: 32px;width: 32px;" src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRL4gjlRnYx_Syp-ktNGolRWqP0LXuVL4ddjg&usqp=CAU">
                    ${pageContext["request"].userPrincipal.principal.username}</h1>
        </sec:authorize>

        <sec:authorize access="!isAuthenticated()">
            <h1 class="chy">EasyBooking</h1>
        </sec:authorize>

        <ul class="navbar">
            <sec:authorize access="hasAuthority('MANAGER')">
                <li><a href="${pageContext.request.contextPath}/user/list">USERS</a></li>
            </sec:authorize>
            <sec:authorize access="hasAuthority('MANAGER')">
                <li><a href="${pageContext.request.contextPath}/hotel/list">HOTELS</a></li>
            </sec:authorize>
            <sec:authorize access="!isAuthenticated()">
                <li><a href="${pageContext.request.contextPath}/">Home</a></li>
            </sec:authorize>
            <sec:authorize access="isAuthenticated()">
                <li><a href="${pageContext.request.contextPath}/order/all">Home</a></li>
            </sec:authorize>

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

<div id="banner"
     style="background-image: url(https://images.creativemarket.com/0.1.0/ps/1422659/4122/2696/m1/fpnw/wm1/world-map-orange-.jpg?1467641527&s=235e067fec06b0fbd69c747d3d7236ac);">
    <div class="container">
        <h1>FIND YOUR HOTEL</h1>

        <c:if test="${not empty errorMessage}">
            <div style="color:red; font-weight: bold; margin: 30px 0px;">${errorMessage}</div>
        </c:if>


            <form name="signIn" action="/signIn" method="post"
                  style="width: 30%; background-color: #4e555b;opacity: 0.85;border-radius: 7px;margin:auto">


                <br>
                <label for="Username">
                    Username:
                    <div>
                        <input type="text" placeholder="Username" id="Username" name="username" value=''
                               style="border-radius: 5px;height: 38px;">
                    </div>
                </label>
                <br>
                <label for="Password">
                    Password:
                    <div>
                        <input type="password" placeholder="Password" id="Password" name="password"
                               style="border-radius: 5px;height: 38px;">
                    </div>
                </label>

                <br>
                <br>
                <input name="submit" type="submit" value="Log in"
                       class="form-control btn" style="background-color: coral;width:80px;margin-bottom: 8px;">
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

                    <%--            <button  class="form-control btn" style="background-color: coral;width:80px;margin-bottom: 8px;">Log in</button>--%>
            </form>
            <%--        </c:if>--%>





        </div> <!--End of container-->
</div> <!--End of banner-->




</body>
</html>
