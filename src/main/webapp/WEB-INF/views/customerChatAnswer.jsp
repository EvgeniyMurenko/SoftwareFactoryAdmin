<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="java.util.List" %>
<%@ page import="com.SoftwareFactory.constant.StatusEnum" %>
<%@ page import="java.io.File" %>
<%@ page import="com.SoftwareFactory.constant.GlobalEnum" %>
<%@ page import="com.SoftwareFactory.model.*" %>
<%@ page import="com.SoftwareFactory.constant.RoleEnum" %>
<%@ page import="com.SoftwareFactory.service.ManagerInfoServiceImpl" %>
<%@ page import="com.SoftwareFactory.service.ManagerInfoService" %>
<%@ page import="com.SoftwareFactory.constant.ProjectEnum" %><%--<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>--%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page session="false" %>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1, user-scalable=no, minimal-ui" />
    <meta name="format-detection" content="telephone=no" />
    <meta name="format-detection" content="address=no" />

    <meta property="og:site_name" content="software factory" />
    <meta property="og:title" content="소팩소개" />
    <meta property="og:image" content="/resources/newIndexPage/images/web-logo.jpg" />
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

<% Long caseId =  (Long) request.getAttribute("caseId"); %>
<% Case aCase = (Case) request.getAttribute("case"); %>
<% ArrayList<Message> messages =  new ArrayList<>(aCase.getMessages()); %>

<!-- Header -->
<header class="container header">
    <div class="row">
        <div class="col-lg-6 col-md-6 col-sm-6 logo">
            <a href="/">소프트웨어<span>팩토리</span></a>
            <div class="small-logo">SoFAC : <i>Software Factory</i></div>
        </div>
        <div class="col-lg-6 col-md-6 col-sm-6 text-right login">
            <ul class="nav navbar-nav navbar-right">
                <li class="dropdown">
                    <span class="avatar-welcome"><%out.print(aCase.getProject().getCustomerInfo().getName());%> 님 접속을 환영합니다.</span>
                    <a href="javascript:void(0);" class="dropdown-toggle avatar" data-toggle="dropdown"><i class="fa fa-user"></i></a>
                    <ul class="dropdown-menu">
                        <li class="dropdown-menu-header text-center">설정</li>
                        <li><a href="/cabinet/customerSettings/"><i class="fa fa-user"></i> MY</a></li>
                        <li><a href="<c:url value="/logout" />"><i class="fa fa-lock"></i> 로그 아웃</a></li>
                    </ul>
                </li>
            </ul>
        </div>
    </div>
</header>
<div class="header-line"></div>
<!-- #End Header -->

<section class="container content mb20">

    <!-- Buttons -->
    <div class="row mb20">
        <div class="col-md-12"><a href="<c:url value="/cabinet/"/>" class="btn btn-primary btn-mobile">Back to CASE list</a></div>
    </div>
    <!-- #End Buttons -->


    <!-- Case table -->
    <table class="table table-striped">
        <tbody>

        <%String projectName = "";
            if(aCase.getProject().getProjectName().equals(ProjectEnum.projectNameNormal.getDbValue())) {
                projectName = ProjectEnum.projectNameNormal.getValue();
            } else if(aCase.getProject().getProjectName().equals(ProjectEnum.projectNameEstimate.getDbValue())){
                projectName = ProjectEnum.projectNameEstimate.getValue();
            } else {
                projectName = aCase.getProject().getProjectName();
            }
        %>
        <tr class="unread checked">
            <td><a href="javascript:void(0);"><%out.print(aCase.getProjectTitle());%></a></td>
            <td class="text-center"><a href="javascript:void(0);"><%out.print(projectName);%></a></td>
            <td class="text-center"><%out.print(aCase.getStatus());%></td>
            <td class="hidden-xs text-center"><%out.print(aCase.getProject().getCreateDate());%></td>
            <td class="hidden-xs text-center"><time class="timeago" datetime="<%  out.print(messages.get(0).getMessageTime()); %>"></time></td>
            <td class="hidden-xs text-center"><%  out.print(messages.size()); %></td>
        </tr>
        </tbody>
    </table>
    <!-- #End Case table -->

    <form action="/cabinet/case/<% out.print(Long.toString(caseId)); %>/print_message?${_csrf.parameterName}=${_csrf.token}" method="POST" enctype="multipart/form-data" >
        <div class="form-group">
            <textarea class="form-control" name="message" rows="7" id="editor" placeholder="Message"></textarea>
        </div>

        <div class="form-group">
            <div class="checkbox abc-checkbox">
                <input type="checkbox" id="emergency" name="emergency">
                <label for="emergency">Emergency</label>
            </div>
        </div>

        <div class="row">
            <div class="col-md-6 col-sm-12 col-xs-12">
                <div class="form-group">
                    <label class="control-label">Select File</label>
                    <input id="caseInput" name="file[]" type="file" multiple class="file-loading">
                </div>
            </div>
            <div class="col-md-6 col-sm-12 col-xs-12">
                <div class="form-group text-right mt25">
                    <a href="/cabinet/case/<%    out.print(Long.toString(aCase.getId()));   %>" class="btn btn-default btn-mobile">Back</a>
                    <button type="submit" class="btn btn-primary btn-mobile">Send</button>
                </div>
            </div>
        </div>
    </form>


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