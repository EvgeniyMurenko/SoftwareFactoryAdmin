<%@ page import="java.util.Locale" %>
<%@ page import="org.springframework.web.servlet.support.RequestContextUtils" %><%--<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>--%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page session="false" %>

<html lang="ru">
<head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1, user-scalable=no, minimal-ui" />
    <meta name="format-detection" content="telephone=no" />
    <meta name="format-detection" content="address=no" />

    <meta name="description" content="" />
    <meta name="keywords" content="" />

    <title>SoFAC의 특징 :: Software Factory</title>

    <link href="resources/newIndexPage/css/bootstrap.min.css" rel="stylesheet" />
    <link href="resources/newIndexPage/css/bootstrap-select.min.css" rel="stylesheet" />
    <link href="resources/newIndexPage/css/jquery.fancybox.min.css" rel="stylesheet" />
    <link href="resources/newIndexPage/css/jquery.sweet-alert.min.css" rel="stylesheet" />
    <link href="resources/newIndexPage/css/font-awesome.min.css" rel="stylesheet" />
    <link href="resources/newIndexPage/css/awesome-bootstrap-checkbox.min.css" rel="stylesheet" />
    <link href="resources/newIndexPage/css/style.css" rel="stylesheet" />
    <link href="resources/newIndexPage/css/responsive.css" rel="stylesheet" />

    <!--[if lt IE 9]>
    <script src="resources/newIndexPage/js/html5shiv.js"></script>
    <script src="resources/newIndexPage/js/respond.min.js"></script>
    <![endif]-->
</head>
<body>

<!-- Header -->
<header class="container header">
    <div class="row">
        <div class="col-lg-6 col-md-6 col-sm-6 logo">
            <div class="orange-button"><a href="./"><img src="resources/newIndexPage/images/home-button.png" alt="" /></a></div>
            <a href="./">소프트웨어<span>팩토리</span></a>
            <div class="small-logo">SoFAC : <i>Software Factory</i></div>
        </div>
        <div class="col-lg-6 col-md-6 col-sm-6 text-right login"><a href="javascript:void(0);">이미 회원입니까? 로그인하십시오!</a></div>
    </div>
</header>
<!-- #End Header -->

<!-- Content -->
<section class="container content mb40">

    <div class="row pt40">
        <div class="col-md-8">

            <span>SoFAC의 특징</span>
            <h3 class="mt0">다국적 작업 방법 안내</h3>

            <p>소프트웨어개발은 개발 자체로 끝나지 않습니다.<br />한번 개발된 앱이나 어플리케이션 소프트웨어는 지속적인 관리가 필요합니다.</p>
            <p>SoFAC은 다양한 고객의 서로 다른 소프트웨어를 체계적이고 지속적으로 개발하고 업데이트하고 유지보수 할 수 있도록 하기 위하여 GXM기법의 관리 시스템으로 수 많은 다국적 개발자들이 유기적으로 작업을 할 수 있도록 하는 개발 방법으로 운영 되고 있습니다.</p>
            <p>모든 작업의 시작은 CASE에 접수된 내용을 기준으로 실시간 분류되고 관련 부서에서 작업내용과 처리 방법을 먼저 고객에게 알려드리고 다음 지시사항을 기다리게 되며 이러한 상호 작용에 의해서 고객이 원하는 목적을 가장 효율적이고 빠르게 달성할 수 있도록 하고 있습니다.</p>

            <div class="row mb30">
                <div class="col-md-12"><a data-fancybox="gallery" href="resources/newIndexPage/images/sfema2.png"><img src="resources/newIndexPage/images/sfema2.png" alt="" class="img-responsive" /></a></div>
            </div>

            <p>SoFAC 의 메인 엔지니어들은 작업을 분류하고 작업내용의 규모를 정리하여 고객에게 알리고 승인을 받은 수 작업을 분산하여 수행하므로서 빠르게 작업이 가능하며 특정 엔지니어 한두이 모든 책임과 스트레를 받지 않도록 하고 있습니다.</p>
            <p>위의 도표와 같이 모든 처리 프로세서는 CASE로 부터 시작되며 내부적인 처리 과정은 직원과, 다국적 멤버쉽 개발자들이 소통할 수 있는 GXM 작업 통제 어플을 통하여 자동화된 업무 분산 및 조립 과정을 거치게 되며 협력 교육기관의 학생들이 집단적인 테스트 과정을 거쳐서 빠른 시간내에 버그패치가 가능한 WIKI방식의 작업 구조를 운영합니다.</p>

        </div>

    </div>
</section>
<!-- #End Content -->

<!-- Footer -->
<footer class="container footer mb20">
    <div class="row">
        <div class="col-md-6 col-sm-6 bottom-informer">
            Do you have any questions or suggestions?<br />
            Let us know at <a href="javascript:void(0);">info@sofac.com</a>!
        </div>
        <div class="col-md-6 col-sm-6 text-right bottom-menu"><a href="javascript:void(0);">Contact & Credits</a> | <a href="javascript:void(0);">Terms of Service</a> | <a href="javascript:void(0);">Privacy Policy</a></div>

    </div>
    <div class="mt20 text-center">Copyright &copy; 2017. All rights reserved.</div>
</footer>
<!-- #End Footer -->

<script src="resources/newIndexPage/js/jquery.min.js"></script>
<script src="resources/newIndexPage/js/jquery-ui.min.js"></script>
<script src="resources/newIndexPage/js/jquery.mousewheel.min.js"></script>
<script src="resources/newIndexPage/js/jquery.fancybox.min.js"></script>
<script src="resources/newIndexPage/js/jquery.sweet-alert.min.js"></script>
<script src="resources/newIndexPage/js/bootstrap.min.js"></script>
<script src="resources/newIndexPage/js/bootstrap-select.min.js"></script>
<script src="resources/newIndexPage/js/bootstrap.validator.min.js"></script>
<script src="resources/newIndexPage/js/main.js"></script>
</body>
</html>