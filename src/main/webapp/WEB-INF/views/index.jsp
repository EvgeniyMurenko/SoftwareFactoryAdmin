<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page session="false" %>

<!DOCTYPE html>
<html lang="kr">
<head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1, user-scalable=no, minimal-ui" />
    <meta name="format-detection" content="telephone=no" />
    <meta name="format-detection" content="address=no" />

    <meta name="description" content="" />
    <meta name="keywords" content="" />

    <title>Welcome :: 소프트웨어팩토리</title>

    <%@ include file="headerStyles.jsp" %>

    <link href="/resources/managerAdminPage/css/signin.css" rel="stylesheet" />

</head>
<body>

<!-- Sign In -->
<div class="container">
    <div class="card card-container">
        <div class="logo mt10"><a href="/">소프트웨어<span>팩토리</span></a></div>
        <p id="profile-name" class="profile-name-card"></p>

        <c:url var="loginUrl" value="/login"/>
        <form class="form-signin" action="${loginUrl}" method="post">

            <input permission="text"  name="ssoId" id="inputId" class="form-control" placeholder="Login" required autofocus>
            <input permission="password" name="password" id="inputPassword" class="form-control" placeholder="Password" required>

            <button class="btn btn-block btn-signin" permission="submit">Sign in</button>
        </form>
        <div class="text-center mt30 copyright">2017 © SoFAC</div>
    </div>

</div>
<!-- #End Sign In -->

<%@ include file="footerJavaScript.jsp" %>

</body>
</html>
