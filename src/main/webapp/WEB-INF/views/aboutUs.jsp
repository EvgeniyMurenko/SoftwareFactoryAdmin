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

    <title>We Builid SoftwareFactory :: Software Factory</title>

    <link href="resources/newIndexPage/css/bootstrap.min.css" rel="stylesheet" />
    <link href="resources/newIndexPage/css/bootstrap-select.min.css" rel="stylesheet" />
    <link href="resources/newIndexPage/css/jquery.fancybox.min.css" rel="stylesheet" />
    <link href="resources/newIndexPage/css/jquery.sweet-alert.min.css" rel="stylesheet" />
    <link href="resources/newIndexPage/css/font-awesome.min.css" rel="stylesheet" />
    <link href="resources/newIndexPage/css/awesome-bootstrap-checkbox.min.css" rel="stylesheet" />
    <link href="resources/newIndexPage/css/style.css" rel="stylesheet" />
    <link href="resources/newIndexPage/css/responsive.css" rel="stylesheet" />

    <!--[if lt IE 9]>
    <script src="js/html5shiv.js"></script>
    <script src="js/respond.min.js"></script>
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
        <div class="col-md-7">

            <h3 class="mt40">스마트 시대형 국제표준화를 준수하는 소프트웨어 개발 운영 대행 전문 기업입니다.</h3>
            <p>한국의 ㈜굿앤굿 재무설계 법인이 주체가 되고 미국의 IT법인, 러시아, 우크라이나, 베트남 기업 및 대학들과 협력하고 있으며,<br />
                재무설계 법인의 특성상 자금 및 법률 행정 지원과 더불어 소프트웨어가 동시에 지원이 되어야 기업이 성장할 수 있다는 새로운 시대적 요구에 따라 좋은 아이디어와 사업의 의지가 있는 스타트업 기업의 종합 지원도 가능한 구조를 갖추고 있습니다.</p>
            <img src="resources/newIndexPage/images/circle-logo.png" alt="" />
            <h3>We Builid  SoftwareFactory</h3>

            <div class="row mt20 mb40 clearfix">
                <div class="col-md-12 mb20">
                    <div class="mb10"><h3 class="mb0 mt0">Korea</h3></div>
                    <div>㈜굿앤굿 재무설계 법인</div>
                    <div><a href="http://www.gngasset.co.kr/" target="_blank">www.gngasset.co.kr</a></div>
                </div>
                <div class="col-md-12 mb20">
                    <div class="mb10"><h3 class="mb0 mt0">USA</h3></div>
                    <div>CHON&HOUGH 세무법인</div>
                    <div><a href="http://www.chonhoughpc.com/" target="_blank">www.chonhoughpc.com</a></div>
                </div>
                <div class="col-md-12 mb20">
                    <div class="mb10"><h3 class="mb0 mt0">Ukraine</h3></div>
                    <div>Shevchenko National University</div>
                    <div><a href="http://www.fit.univ.kiev.ua/" target="_blank">www.fit.univ.kiev.ua</a></div>
                    <div class="mt10 mb10">Factory headquarter Engineer Office<br />(Kiev, ukraine)</div>
                    <div class="mt10"><a data-fancybox="gallery" href="resources/newIndexPage/images/cafe.jpg" class="position-center"><img src="resources/newIndexPage/images/cafe-small.jpg" alt=""></a></div>
                </div>
            </div>

            <div class="row mt200">
                <div class="col-md-12"><a data-fancybox="gallery" href="resources/newIndexPage/images/staff.png" class="position-center"><img src="resources/newIndexPage/images/staff-small.png" alt="" class="img-responsive staff" /></a></div>
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