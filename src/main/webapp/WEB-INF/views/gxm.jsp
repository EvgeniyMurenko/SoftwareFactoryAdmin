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
    <meta charset="utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta name="viewport"
          content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1, user-scalable=no, minimal-ui"/>
    <meta name="format-detection" content="telephone=no"/>
    <meta name="format-detection" content="address=no"/>

    <meta name="description" content=""/>
    <meta name="keywords" content=""/>

    <title>GXM 시스템의 특징 :: Software Factory</title>

    <link href="resources/newIndexPage/css/bootstrap.min.css" rel="stylesheet"/>
    <link href="resources/newIndexPage/css/bootstrap-select.min.css" rel="stylesheet"/>
    <link href="resources/newIndexPage/css/jquery.fancybox.min.css" rel="stylesheet"/>
    <link href="resources/newIndexPage/css/jquery.sweet-alert.min.css" rel="stylesheet"/>
    <link href="resources/newIndexPage/css/font-awesome.min.css" rel="stylesheet"/>
    <link href="resources/newIndexPage/css/awesome-bootstrap-checkbox.min.css" rel="stylesheet"/>
    <link href="resources/newIndexPage/css/style.css" rel="stylesheet"/>
    <link href="resources/newIndexPage/css/responsive.css" rel="stylesheet"/>

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
            <div class="orange-button"><a href="./"><img src="resources/newIndexPage/images/home-button.png" alt=""/></a></div>
            <a href="./">소프트웨어<span>팩토리</span></a>
            <div class="small-logo">SoFAC : <i>Software Factory</i></div>
        </div>
        <div class="col-lg-6 col-md-6 col-sm-6 text-right login"><a href="javascript:void(0);">이미 회원입니까? 로그인하십시오!</a>
        </div>
    </div>
</header>
<!-- #End Header -->

<!-- Content -->
<section class="container content mb40">

    <div class="row pt40">
        <div class="col-md-8">

            <span>SoFAC의 특징</span>
            <h3 class="mt0">GXM 시스템의 특징</h3>

            <p>대부분의 소프트웨어 개발 회사들은 많은 프로그래머들 중에 논리적인 사고와 작업 방법에 대한 안목이 있는 핵심 개발자들이 한명씩 있습니다.<br/>
                그리고 대부분의 작업은 이들의 업무 집중도에 따라 퀄리티나 작업 시간이 결정되는 경우가 대부분이며 이들이 퇴사할 경우 그들이 개발한 소프트웨어의 유지보수등에 문제가 생기는 경우가
                많습니다.</p>

            <p>GXM공법은 일부 개발자들에게 집중되어 있는 핵심역량을 모듈화 하고 분산하며 집단지성에 의해서 퀄리티를 유지하여 일부 인력에게 스트레스가 집중되는 것을 막고 시스템에 의해서 관리되게 하는
                모든 체계를 말합니다.</p>

            <p>GXM에서는 현존하는 기술들을 대부분 확보하고 있으며 그것을 분산개발이 가능하도록 하는 모듈화 개발기법과 조합기법들을 연구 개발되어 실무에 적용되어 있으며 이것은 시간과 공간 그리의
                언어소통의 문제들을 극복하여 다국적 분산 개발이 가능하게 하는 시스템 입니다.</p>

            <p>소프트웨어 팩토리는 GXM시스템에 의해서 대량 동시작업 및 분산개발이 가능하며 인력에 의존하지 않고 지속적인 유지보수가 가능한 공장형 개발 시스템을 구현한 기업입니다.<br/>
                GXM 시스템은 다년간의 연구 및 실제 현장 적용 경험과 특허받은 공법입니다.</p>

        </div>
    </div>

</section>
<!-- #End Content -->

<!-- Footer -->
<footer class="container footer mb20">
    <div class="row">
        <div class="col-md-6 col-sm-6 bottom-informer">
            Do you have any questions or suggestions?<br/>
            Let us know at <a href="javascript:void(0);">info@sofac.com</a>!
        </div>
        <div class="col-md-6 col-sm-6 text-right bottom-menu">
            <a href="javascript:void(0);">Contact & Credits</a> |
            <a href="javascript:void(0);">Terms of Service</a> |
            <a href="javascript:void(0);">Privacy Policy</a>
        </div>

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