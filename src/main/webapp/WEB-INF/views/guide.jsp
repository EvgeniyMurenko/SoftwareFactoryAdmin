<%@ page import="java.util.Locale" %>
<%@ page import="org.springframework.web.servlet.support.RequestContextUtils" %><%--<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>--%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page session="false" %>

<!DOCTYPE html>
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

            <h3 class="mb0">What is FXM ?</h3>
            <span>(Factory Membership & parallel scenario codnig system)</span>

            <p class="mt30">소프웨어 제작 기법에 혁신을 이룩한 방법으로서 프로젝트를 논리적 스토리화 하여<br />
                그것을 시나리오로 분산한 후 SOFAC의 멤버쉽 개발자들에 전문화된 분야별로 분산하여<br />
                개발하고 수집하여 조립하는 기법을 말합니다.</p>

            <p>이 개발 방법은 분산 개발이 가능하게 하는 베이스 링크 기술과 멤버 관리 시스템이<br />
                유기적으로 공정 관리시스템의 통제의 의해서 작동 되며<br />
                원가 절감 및 효율성 증대, 개발 기간의 단축에 매우 큰 효과가 있습니다.<br />
                <i>(모든 시나리오는 코드화 관리 되므로 차후 유지보수 또는 수정 작업시 효과적인 대응이 가능합니다)</i></p>

            <div class="row mb30">
                <div class="col-md-10"><a data-fancybox="gallery" href="resources/newIndexPage/images/shema4.png"><img src="resources/newIndexPage/images/shema4.png" alt="" class="img-responsive" /></a></div>
            </div>

            <h3 style="margin-top: 100px;">WIKI 방식의 다국적 Membership 개발</h3>

            <p>스마트시대의 개발은 단순한 개발이 아니라 수 많은 라이브러리와 표준들의 집합이며<br />
                그런 리소스들을 활용하여 고객이 목적하는 스토리와 디자인을 조합하여  목적물이 만들어 집니다.</p>

            <p>소프트웨어팩토리는 강력한 기술교육과 업무에 대한 의지가 있는 나라의 명문 대학과 제휴하여<br />
                SOFAC 학과를 개설하여 본사에서 필요한 인력들을 양성하고 라이선스를 발급하여<br />
                작업이 가능한 학생들을 수년간 양성해 오고 있으며  집단지성에 의한 논리 구성능력과<br />
                여러 사람이 동시 작업하는 병렬 작업은 고객과 엔지니어들에게 모두 도움이 되며 정확한 작업과<br />
                다양한 분야의 작업이 가능하게 하는 수년간 개발 되어온 본사의 개발 방법 입니다.</p>

            <div class="row mb30">
                <div class="col-md-10"><a data-fancybox="gallery" href="resources/newIndexPage/images/shema5.jpg"><img src="resources/newIndexPage/images/shema5.jpg" alt="" class="img-responsive" /></a></div>
            </div>

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