<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page session="false" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1, user-scalable=no, minimal-ui" />
    <meta name="format-detection" content="telephone=no" />
    <meta name="format-detection" content="address=no" />

    <meta name="description" content="" />
    <meta name="keywords" content="" />

    <title>Welcome to Software Factory :: 소프트웨어팩토리</title>

<%@ include file="styles.jsp" %>

</head>
<body>

<section class="sign-in">

    <div class="sign-in-logo"><a href="/">소프트웨어<span>팩토리</span></a></div>

    <c:url var="loginUrl" value="/login"/>
    <form class="form-signin" action="${loginUrl}" method="post">

        <div class="form-group">
            <div class="input-group">
                <div class="input-group-addon"><i class="fa fa-user"></i></div>
                <input type="text"  name="ssoId" id="inputId" class="form-control" placeholder="Login" required autofocus>
            </div>
        </div>

        <div class="form-group">
            <div class="input-group">
                <div class="input-group-addon"><i class="fa fa-unlock-alt"></i></div>
                <input type="password" name="password" id="inputPassword" class="form-control" placeholder="Password" required>
            </div>
        </div>

        <div class="form-group mb0 text-center">
            <button class="btn btn-default" type="submit">Login</button>
        </div>

    </form>
</section>

<div class="sign-in-copyright">&copy; 2017. All right reserved</div>

<%@ include file="javascript.jsp" %>

</body>
</html>