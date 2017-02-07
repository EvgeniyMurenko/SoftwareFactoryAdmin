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

    <title>Certification &amp; News :: Software Factory</title>

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
            <div class="orange-button"><a href="./"><img src="resources/newIndexPage/images/home-button.png" alt="" class="img-responsive position-center" /></a></div>
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
        <div class="col-md-12">

            <h3 class="text-center">Certification &amp; News</h3>

            <div class="row">
                <div class="col-md-4">
                    <div class="certificate">
                        <div class="cf-title">
                            <span class="mb10 text-center">SoFAC 개발 제품 일본에 상표등록</span>
                        </div>
                        <div class="text-center"><img src="resources/newIndexPage/images/serf4.jpg" alt="" class="img-responsive position-center"></div>
                    </div>
                </div>
                <div class="col-md-4">
                    <div class="certificate">
                        <div class="cf-title">
                            <span class="mb10 text-center">특허 제 10-2014-0034487호</span>
                        </div>
                        <div class="text-center"><img src="resources/newIndexPage/images/serf3.jpg" alt="" class="img-responsive position-center"></div>
                    </div>
                </div>
                <div class="col-md-4">
                    <div class="certificate">
                        <div class="cf-title">
                            <span class="mb10 text-center">일본에서 인정한 통신 기술 라이센스</span>
                        </div>
                        <div class="text-center"><img src="resources/newIndexPage/images/serf5.jpg" alt="" class="img-responsive position-center"></div>
                    </div>
                </div>
            </div>

            <div class="row mt20">
                <div class="col-md-4">
                    <div class="certificate">
                        <div class="cf-title">
                            <span class="mb10 text-center">ISO9001 인증</span>
                        </div>
                        <div class="text-center"><img src="resources/newIndexPage/images/serf1.jpg" alt="" class="img-responsive position-center"></div>
                    </div>
                </div>
                <div class="col-md-4">
                    <div class="certificate">
                        <div class="cf-title">
                            <span class="mb10 text-center">고객 감사 편지</span>
                        </div>
                        <div class="text-center"><img src="resources/newIndexPage/images/serf2.jpg" alt="" class="img-responsive position-center"></div>
                    </div>
                </div>
                <div class="col-md-4">
                    <div class="certificate">
                        <div class="cf-title">
                            <span class="mb10 text-center">스마트폰에서 실시간 통신 특허 획득</span>
                        </div>
                        <div class="text-center"><img src="resources/newIndexPage/images/serf6.jpg" alt="" class="img-responsive position-center"></div>
                    </div>
                </div>
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
