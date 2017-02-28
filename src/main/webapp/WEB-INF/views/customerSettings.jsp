<%@ page import="org.springframework.web.servlet.support.RequestContextUtils" %>
<%@ page import="com.SoftwareFactory.model.Project" %>
<%@ page import="java.util.*" %>
<%@ page import="com.SoftwareFactory.constant.ProjectEnum" %>
<%@ page import="com.SoftwareFactory.model.CustomerInfo" %>
<%@ page import="com.SoftwareFactory.model.User" %><%--<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>--%>
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

    <meta property="og:site_name" content="software factory" />
    <meta property="og:title" content="소팩소개" />
    <meta property="og:image" content="images/web-logo.jpg" />
    <meta property="og:url" content="http://sofac/" />
    <meta property="og:description" content="" />

    <meta name="description" content="" />
    <meta name="keywords" content="" />

    <title>소팩소개 :: Software Factory</title>

    <link href="/resources/newIndexPage/css/bootstrap.min.css" rel="stylesheet" />
    <link href="/resources/newIndexPage/css/bootstrap-select.min.css" rel="stylesheet" />
    <link href="/resources/newIndexPage/css/jquery.fancybox.min.css" rel="stylesheet" />
    <link href="/resources/newIndexPage/css/jquery.sweet-alert.min.css" rel="stylesheet" />
    <link href="/resources/newIndexPage/css/font-awesome.min.css" rel="stylesheet" />
    <link href="/resources/newIndexPage/css/awesome-bootstrap-checkbox.min.css" rel="stylesheet" />
    <link href="/resources/newIndexPage/css/fileinput.min.css" rel="stylesheet" />
    <link href="/resources/newIndexPage/css/style.css" rel="stylesheet" />
    <link href="/resources/newIndexPage/css/responsive.css" rel="stylesheet" />

    <link rel="apple-touch-icon" sizes="57x57" href="/resources/newIndexPage/images/apple-icon-57x57.png" />
    <link rel="apple-touch-icon" sizes="60x60" href="/resources/newIndexPage/images/apple-icon-60x60.png" />
    <link rel="apple-touch-icon" sizes="72x72" href="/resources/newIndexPage/images/apple-icon-72x72.png" />
    <link rel="apple-touch-icon" sizes="76x76" href="/resources/newIndexPage/images/apple-icon-76x76.png" />
    <link rel="apple-touch-icon" sizes="114x114" href="/resources/newIndexPage/images/apple-icon-114x114.png" />
    <link rel="apple-touch-icon" sizes="120x120" href="/resources/newIndexPage/images/apple-icon-120x120.png" />
    <link rel="apple-touch-icon" sizes="144x144" href="/resources/newIndexPage/images/apple-icon-144x144.png" />
    <link rel="apple-touch-icon" sizes="152x152" href="/resources/newIndexPage/images/apple-icon-152x152.png" />
    <link rel="apple-touch-icon" sizes="180x180" href="/resources/newIndexPage/images/apple-icon-180x180.png" />
    <link rel="icon" type="image/png" sizes="192x192"  href="/resources/newIndexPage/images/android-icon-192x192.png" />
    <link rel="icon" type="image/png" sizes="32x32" href="/resources/newIndexPage/images/favicon-32x32.png" />
    <link rel="icon" type="image/png" sizes="96x96" href="/resources/newIndexPage/images/favicon-96x96.png" />
    <link rel="icon" type="image/png" sizes="16x16" href="/resources/newIndexPage/images/favicon-16x16.png" />
    <link rel="manifest" href="/resources/newIndexPage/images/manifest.json" />
    <meta name="msapplication-TileColor" content="#ffffff" />
    <meta name="msapplication-TileImage" content="/resources/newIndexPage/images/ms-icon-144x144.png" />
    <meta name="theme-color" content="#ffffff" />

    <!--[if lt IE 9]>
    <script src="/resources/newIndexPage/js/html5shiv.js"></script>
    <script src="/resources/newIndexPage/js/respond.min.js"></script>
    <![endif]-->
</head>
<body>

<%CustomerInfo customerInfo =  (CustomerInfo)request.getAttribute("customerInfo");%>
<%User user =  (User)request.getAttribute("user");%>

<!-- Header -->
<header class="container header">
    <div class="row">
        <div class="col-lg-6 col-md-6 col-sm-6 logo">
            <a href="./">소프트웨어<span>팩토리</span></a>
            <div class="small-logo">SoFAC : <i>Software Factory</i></div>
        </div>
        <div class="col-lg-6 col-md-6 col-sm-6 text-right login">
            <ul class="nav navbar-nav navbar-right">
                <li class="dropdown">
                    <span class="avatar-welcome"><%out.print(customerInfo.getName());%> 님 접속을 환영합니다.</span>
                    <a href="javascript:void(0);" class="dropdown-toggle avatar" data-toggle="dropdown"><i class="fa fa-user"></i></a>
                    <ul class="dropdown-menu">
                        <li class="dropdown-menu-header text-center">설정</li>
                        <li><a href="<c:url value="/cabinet/customerSettings"/>"><i class="fa fa-user"></i> MY</a></li>
                        <li><a href="<c:url value="/logout" />"><i class="fa fa-lock"></i> 로그 아웃</a></li>
                    </ul>
                </li>
            </ul>
        </div>
    </div>
</header>
<div class="header-line"></div>
<!-- #End Header -->

<section class="container mb20">
    <h3 class="mb20">프로필 정보 변경</h3>



    <%--information form--%>
    <form id="infoSettings" action="/cabinet/infoSettings?${_csrf.parameterName}=${_csrf.token}" method="POST">
            <div class="row">
            <div class="col-md-6">
                <div class="form-group">
                    <label for="name">이름</label>
                    <input type="text" name="name" id="name" value="<%  out.print(customerInfo.getName());  %>" class="form-control" placeholder="이름" required />
                </div>
                <div class="form-group">
                    <label for="email">이메일</label>
                    <input type="email" name="email" id="email"  value="<%  out.print(customerInfo.getEmail());  %>" class="form-control form-block" placeholder="이메일" required />
                </div>
                <div class="form-group">
                    <label for="phone">전화번호</label>
                    <input type="text" name="phone" id="phone" class="form-control bfh-phone"  value="<%  out.print(customerInfo.getPhone());  %>" pattern="(]\d{3}[\)]\s\d{4}[\-]\d{4}$" placeholder="전화번호" data-format="(ddd) dddd-dddd" maxlength="100" required />
                </div>

                <div class="form-group">
                    <label for="companyName">회사명</label>
                    <input type="text" name="companyName" id="companyName" class="form-control"  value="<%  out.print(customerInfo.getCompany());  %>" placeholder="회사명" required />
                </div>

                <div class="form-group">
                    <label for="companySite">회사 홈페이지</label>
                    <input type="text" name="companySite" id="companySite" class="form-control"  value="<%  out.print(customerInfo.getWebsite());  %>" placeholder="회사 홈페이지"  />
                </div>

                <div class="form-group text-right">
                    <button type="submit" name="saveSettings" class="btn btn-primary">Save changes</button>
                </div>

                <!-- Delimiter -->
                <div class="delimiter"></div>
                <!-- #End Delimiter -->
            </div>
        </div>
    </form>
    <%-- end information form--%>

    <%--password form--%>
    <form id="passwordSettings" action="/cabinet/passwordSettings?${_csrf.parameterName}=${_csrf.token}" method="POST">
        <div class="row">
            <div class="col-md-6">

<%--                <div class="form-group mt10">
                    <label for="oldPassword">기존 비밀번호</label>
                    <input type="password" name="oldPassword" id="oldPassword" class="form-control" placeholder="기존 비밀번호" required />
                </div>--%>

                <div class="form-group">
                    <label for="newPassword">새 비밀번호</label>
                    <input type="password" name="newPassword" id="newPassword" class="form-control" placeholder="새 비밀번호" required />
                </div>

                <div class="form-group">
                    <label for="confirmNewPassword">새 암호를 확인합니다</label>
                    <input type="password" name="confirmNewPassword" id="confirmNewPassword" class="form-control" placeholder="새 암호를 확인합니다" required />
                </div>

                <div class="form-group text-right">
                    <button type="submit" name="savePassword" class="btn btn-primary">Save password</button>
                </div>
            </div>
        </div>
    </form>
    <%-- end password form--%>
</section>

<!-- Footer -->
<footer class="container footer mb20">
    <div class="mt20 text-center">Copyright &copy; 2017. All rights reserved.</div>
</footer>
<!-- #End Footer -->


<script src="/resources/newIndexPage/js/jquery.min.js"></script>
<script src="/resources/newIndexPage/js/jquery-ui.min.js"></script>
<script src="/resources/newIndexPage/js/jquery.mousewheel.min.js"></script>
<script src="/resources/newIndexPage/js/jquery.fancybox.min.js"></script>
<script src="/resources/newIndexPage/js/jquery.sweet-alert.min.js"></script>
<script src="/resources/newIndexPage/js/jquery.timeago.js"></script>
<script src="/resources/newIndexPage/js/jquery.timeago.ko.js"></script>
<script src="/resources/newIndexPage/js/bootstrap.min.js"></script>
<script src="/resources/newIndexPage/js/bootstrap-form-helpers.min.js"></script>
<script src="/resources/newIndexPage/js/bootstrap-select.min.js"></script>
<script src="/resources/newIndexPage/js/bootstrap.validator.min.js"></script>
<script src="/resources/newIndexPage/js/fileinput.min.js"></script>
<script src="/resources/newIndexPage/js/sortable.min.js"></script>
<script src="/resources/newIndexPage/js/form-validation.min.js"></script>
<script src="/resources/newIndexPage/js/pagination.min.js"></script>
<script src="/resources/newIndexPage/js/ckeditor/ckeditor.js"></script>
<script src="/resources/newIndexPage/js/main.js"></script>
</body>
</html>