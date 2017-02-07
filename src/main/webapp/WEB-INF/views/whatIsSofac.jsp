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

    <title>What is SoftwareFactory? :: Software Factory</title>

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

            <h3>What is SoftwareFactory?</h3>
            <div class="other-font">
                <p>소프트웨어(앱, 고급웹사이트, IOT관련 소프트웨어 등) 개발</p>
                <p>소비자가 편안하게 비즈니스 하실 수 있도록 서비스 개념이 도입된 유지보수를 제공합니다.</p>
                <p>많은 고객을 동시에 수용할 수 있는 규모를 갖춘 개발 회사 입니다.</p>
                <p>마이크로소프트, 구글, 애플 등의 정책에 따를 수 밖에 없는 상황을 실시간 체크하며 업데이트 및 고객의 상황에 맞게 정책이나 법률적인 문제를 적용 하는 표준화된 개발 대행 회사 입니다.</p>
                <p>미국의 표준과 한국의 기술력과 자연과학이 발달한 국가의 기술력 그리고 인건비 절감이 가능한 나라의 대학 또는 단체와 협력하여 라이선스 제도에 의해서 WIKI방식으로 분산 개발합니다.</p>
                <p>서비스 관련 고객 응대는  비용적 효율성이 뛰어난 나라에서 운영 되며 핵심적인 엔지니어는 최고의 실력을 갖춘 나라의 명문 기술대 출신으로 구성되어 있습니다.</p>
            </div>

            <div class="row mt40 mb30 clearfix">
                <div class="col-md-8 col-md-offset-2"><a data-fancybox="gallery" href="resources/newIndexPage/images/sfema1.png"><img src="resources/newIndexPage/images/sfema1.png" alt="" class="img-responsive" /></a></div>
            </div>

            <p style="font-size: 14pt;">소프트팩토리의 생각 …</p>
            <p style="font-size: 10pt;">스마트폰 이전 시대까지 소프트웨어 개발이라는 분야는 하이테크 산업이었습니다.<br />
                그러나 스마트폰이 출현하고 SNS 시대가 되면서 모든 비즈니스는 클라우드 가상공간에서 이루어지는 시대가 되었습니다.<br />
                따라서 많은 사람들이 새로운 사업을 시작하거나 기존의 중소기업들이 예전 방식의 IT조직을 운영하기가 어려워졌습니다.</p>
            <p style="font-size: 10pt;">기술을 모르고 아이디어만 가진 사람들에게는 편안한 기술 지원과 지속적이고 안정적인 서비스를 제공하며<br />
                IT조직의 운영이 고비용 저효율의 문제로 고민하시는 기업들의 개발 운영 서비스 대행은 이 시대가 필요로 하는 서비스 입니다.</p>
            <p style="font-size: 10pt;">소프트웨어팩토리는 이러한 문제점을 해결 하기 위하여 지금 시대에 필요한 대부분의 기술은 이미 확보하여<br />
                무상으로 제공하는 것을 원칙으로 하고 있으며, 다국적 개발자들의 활용으로 비용절감과 다양한 분야의 개발 업무를 수행 가능하게 하였습니다.</p>
            <p style="font-size: 10pt;">또한 수 많은 고객을 동시에 수용할 수 있도록 자동화된 공정과 병렬화된 개발방법을 통하여 고객별로 다른 서비스를 대량으로 동시간에 제공할 수 있는 공장형 소프트웨어 개발 대행 기업입니다.</p>
            <p style="font-size: 10pt;">소프트웨어 팩토리는 한국의 ㈜굿앤굿 재무설계 법인이 주체가 되고 미국의 IT기업가 러시아, 우크라이나, 베트남등의 기업 및 우수한 대학들과 교류하여 개발에 필요한 인재를 양성하고 저 비용, 고 퀄리티의 새로운 소프트웨어 개발 서비스 개념을 적용한 새로운 개념의 소프트웨어 회사 입니다.</p>
            <p style="font-size: 10pt;">또한 재무설계 법인의 특성상 자금 및 법률 행정 지원과 더불어 소프트웨어가 동시에 지원이 되어야 기업이 성장할 수 있다는 새로운 시대적 요구에 따라 좋은 아이디어와 사업의 의지가 있는 스타트업 사업의 종합 지원도 가능한 새로운 개념의 소프트웨어 개발 지원 기업 입니다.</p>
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