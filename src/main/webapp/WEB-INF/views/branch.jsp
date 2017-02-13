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

            <h3>소프트웨어 팩토리 협력 업체</h3>

            <p class="mt30">소프트웨어팩토리는 소프트웨어 개발에 필요한 인프라를 갖추고 있으며<br />
                온라인을 기반으로 개발을 대행하는 전문 기업입니다.</p>

            <p>그러나 고객님의 업무 특성상 온라인 업무가 불가능할 경우 SoFAC의 지점 및 협력업체를<br />
                통하여 대면 서비스를 받으실 수 있습니다.</p>

            <p>온라인 문의를 통해서 요청하시거나 아래 리스트를 통해서 직접 개발 관련 문의 및 접촉을 하실 수 있습니다.</p>

            <div class="row mb20">
                <div class="col-md-10"><a data-fancybox="gallery" href="resources/newIndexPage/images/image003.png"><img src="resources/newIndexPage/images/image003.png" alt="" class="img-responsive" /></a></div>
            </div>

            <section style="border-bottom: 1px solid #eee; padding: 10px 0" class="clearfix">
                <div class="row mt20 mb20 clearfix">
                    <div class="col-md-3"><img src="resources/newIndexPage/images/small-logo-green.png" alt="" class="img-responsive" /></div>
                </div>

                <div>㈜세이퍼스드론<br />
                    유틸리티형 드론 제작 전문 업체<br />
                    <a href="http://www.safeusdrone.com/" target="_blank">www.safeusdrone.com</a><br />
                    000-0000-0000<br />
                </div>
            </section>

            <section style="border-bottom: 1px solid #eee; padding: 10px 0" class="clearfix">
                <div class="row mt20 mb20 clearfix">
                    <div class="col-md-3"><img src="resources/newIndexPage/images/small-logo-green.png" alt="" class="img-responsive" /></div>
                </div>

                <div>㈜세이퍼스드론<br />
                    유틸리티형 드론 제작 전문 업체<br />
                    <a href="http://www.safeusdrone.com/" target="_blank">www.safeusdrone.com</a><br />
                    000-0000-0000<br />
                </div>
            </section>




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
