<%@ page import="java.util.Locale" %>
<%@ page import="org.springframework.web.servlet.support.RequestContextUtils" %>
<%@ page import="com.SoftwareFactory.model.Estimate" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Iterator" %>
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
    <meta property="og:site_name" content="software factory" />
    <meta property="og:title" content="소팩소개" />
    <meta property="og:image" content="http://www.sofac.kr/resources/newIndexPage/images/web-logo1.jpg" />
    <meta property="og:image:type" content="image/jpeg" />
    <meta property="og:image:width" content="259" />
    <meta property="og:image:height" content="110" />
    <meta property="og:url" content="http://sofac.kr/" />
    <meta property="og:description" content="" />

    <meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1, user-scalable=no, minimal-ui" />
    <meta name="format-detection" content="telephone=no" />
    <meta name="format-detection" content="address=no" />

    <meta name="description" content="" />
    <meta name="keywords" content="" />

    <title>소팩소개 :: Software Factory</title>

    <link href="resources/newIndexPage/css/bootstrap.min.css" rel="stylesheet" />
    <link href="resources/newIndexPage/css/bootstrap-select.min.css" rel="stylesheet" />
    <link href="resources/newIndexPage/css/jquery.fancybox.min.css" rel="stylesheet" />
    <link href="resources/newIndexPage/css/jquery.sweet-alert.min.css" rel="stylesheet" />
    <link href="resources/newIndexPage/css/font-awesome.min.css" rel="stylesheet" />
    <link href="resources/newIndexPage/css/awesome-bootstrap-checkbox.min.css" rel="stylesheet" />
    <link href="resources/newIndexPage/css/fileinput.min.css" rel="stylesheet" />
    <link href="resources/newIndexPage/css/admin.css" rel="stylesheet" />

    <link rel="apple-touch-icon" sizes="57x57" href="resources/newIndexPage/images/apple-icon-57x57.png" />
    <link rel="apple-touch-icon" sizes="60x60" href="resources/newIndexPage/images/apple-icon-60x60.png" />
    <link rel="apple-touch-icon" sizes="72x72" href="resources/newIndexPage/images/apple-icon-72x72.png" />
    <link rel="apple-touch-icon" sizes="76x76" href="resources/newIndexPage/images/apple-icon-76x76.png" />
    <link rel="apple-touch-icon" sizes="114x114" href="resources/newIndexPage/images/apple-icon-114x114.png" />
    <link rel="apple-touch-icon" sizes="120x120" href="resources/newIndexPage/images/apple-icon-120x120.png" />
    <link rel="apple-touch-icon" sizes="144x144" href="resources/newIndexPage/images/apple-icon-144x144.png" />
    <link rel="apple-touch-icon" sizes="152x152" href="resources/newIndexPage/images/apple-icon-152x152.png" />
    <link rel="apple-touch-icon" sizes="180x180" href="resources/newIndexPage/images/apple-icon-180x180.png" />
    <link rel="icon" type="image/png" sizes="192x192"  href="resources/newIndexPage/images/android-icon-192x192.png" />
    <link rel="icon" type="image/png" sizes="32x32" href="resources/newIndexPage/images/favicon-32x32.png" />
    <link rel="icon" type="image/png" sizes="96x96" href="resources/newIndexPage/images/favicon-96x96.png" />
    <link rel="icon" type="image/png" sizes="16x16" href="resources/newIndexPage/images/favicon-16x16.png" />
    <link rel="manifest" href="resources/newIndexPage/images/manifest.json" />
    <meta name="msapplication-TileColor" content="#ffffff" />
    <meta name="msapplication-TileImage" content="resources/newIndexPage/images/ms-icon-144x144.png" />
    <meta name="theme-color" content="#ffffff" />

    <!--[if lt IE 9]>
    <script src="resources/newIndexPage/js/html5shiv.js"></script>
    <script src="resources/newIndexPage/js/respond.min.js"></script>
    <![endif]-->
</head>
<body>

<div id="wrapper">

    <!-- Sidebar -->
    <div id="sidebar-wrapper">

        <aside class="sidebar-nav">
            <div class="left-top-line">
                <div class="clearfix logo"><a href="./">소프트웨어<span>팩토리</span></a></div>
            </div>
            <ul>
                <li class="active"><a href="estimate.html"><i class="fa fa-angle-double-right" aria-hidden="true"></i> Estimate</a></li>
                <li><a href="case.html"><i class="fa fa-angle-double-right" aria-hidden="true"></i> Case</a></li>
                <li><a href="javascript:void(0);"><i class="fa fa-angle-double-right" aria-hidden="true"></i> Settings</a></li>
            </ul>

        </aside>
    </div>
    <!-- #End Sidebar -->

    <!-- Page Content -->
    <div id="page-content-wrapper">

        <!-- Top line -->
        <header class="container-fluid top-line">
            <div class="text-left top-switcher">
                <a href="#menu-toggle" class="btn btn-toggle" id="menu-toggle"><i class="fa fa-bars" aria-hidden="true"></i></a>
            </div>
            <div class="text-right">
                <ul class="nav navbar-nav navbar-right">
                    <li class="dropdown">
                        <a href="javascript:void(0);" class="dropdown-toggle avatar" data-toggle="dropdown"><i class="fa fa-user"></i></a>
                        <ul class="dropdown-menu">
                            <li class="dropdown-menu-header text-center">설정</li>
                            <li><a href="javascript:void(0);"><i class="fa fa-user"></i> 윤곽</a></li>
                            <li><a href="javascript:void(0);"><i class="fa fa-lock"></i> 로그 아웃</a></li>
                        </ul>
                    </li>
                </ul>
            </div>
        </header>
        <!-- #End Top line -->

        <div class="container-fluid content">

            <h3 class="mb20">Estimate</h3>

            <table class="table table-striped">
                <thead>
                <tr>
                    <th class="hidden-xs text-center">Status</th>
                    <th class="hidden-xs text-center">날짜</th>
                    <th class="text-center">프로젝트</th>
                    <th class="text-center">CASE 제목</th>
                    <th class="text-center">Appointment time</th>
                    <th class="hidden-xs text-center">Check</th>
                </tr>
                </thead>
                <tbody>
                <tr class="unread checked">
                    <td class="hidden-xs text-center">Open</td>
                    <td class="hidden-xs text-center">10/01/2017</td>
                    <td><a href="managerEstimate.html">Come On Baby</a></td>
                    <td><a href="managerEstimate.html">Nullam quis risus eget urna mollis ornare vel eu leo</a></td>
                    <td class="text-center">48시간 남음</td>
                    <td class="hidden-xs text-center">3</td>
                </tr>
                <tr class="unread checked">
                    <td class="hidden-xs text-center">Open</td>
                    <td class="hidden-xs text-center">10/01/2017</td>
                    <td><a href="managerEstimate.html">Come On Baby</a></td>
                    <td><a href="managerEstimate.html">Nullam quis risus eget urna mollis ornare vel eu leo</a></td>
                    <td class="text-center">48시간 남음</td>
                    <td class="hidden-xs text-center">3</td>
                </tr>
                <tr class="unread checked">
                    <td class="hidden-xs text-center">Open</td>
                    <td class="hidden-xs text-center">10/01/2017</td>
                    <td><a href="managerEstimate.html">Come On Baby</a></td>
                    <td><a href="managerEstimate.html">Nullam quis risus eget urna mollis ornare vel eu leo</a></td>
                    <td class="text-center">48시간 남음</td>
                    <td class="hidden-xs text-center">3</td>
                </tr>
                <tr class="unread checked">
                    <td class="hidden-xs text-center">Open</td>
                    <td class="hidden-xs text-center">10/01/2017</td>
                    <td><a href="managerEstimate.html">Come On Baby</a></td>
                    <td><a href="managerEstimate.html">Nullam quis risus eget urna mollis ornare vel eu leo</a></td>
                    <td class="text-center">48시간 남음</td>
                    <td class="hidden-xs text-center">3</td>
                </tr>
                <tr class="unread checked">
                    <td class="hidden-xs text-center">Open</td>
                    <td class="hidden-xs text-center">10/01/2017</td>
                    <td><a href="managerEstimate.html">Come On Baby</a></td>
                    <td><a href="managerEstimate.html">Nullam quis risus eget urna mollis ornare vel eu leo</a></td>
                    <td class="text-center">48시간 남음</td>
                    <td class="hidden-xs text-center">3</td>
                </tr>
                <tr class="unread checked">
                    <td class="hidden-xs text-center">Open</td>
                    <td class="hidden-xs text-center">10/01/2017</td>
                    <td><a href="managerEstimate.html">Come On Baby</a></td>
                    <td><a href="managerEstimate.html">Nullam quis risus eget urna mollis ornare vel eu leo</a></td>
                    <td class="text-center">48시간 남음</td>
                    <td class="hidden-xs text-center">3</td>
                </tr>
                </tbody>
            </table>


        </div>

    </div>
    <!-- #End Ppage-content -->

</div>
<!-- #End Wrapper -->

<script src="resources/newIndexPage/js/jquery.min.js"></script>
<script src="resources/newIndexPage/js/jquery-ui.min.js"></script>
<script src="resources/newIndexPage/js/jquery.mousewheel.min.js"></script>
<script src="resources/newIndexPage/js/jquery.fancybox.min.js"></script>
<script src="resources/newIndexPage/js/jquery.sweet-alert.min.js"></script>
<script src="resources/newIndexPage/js/jquery.timeago.js"></script>
<script src="resources/newIndexPage/js/jquery.timeago.ko.js"></script>
<script src="resources/newIndexPage/js/bootstrap.min.js"></script>
<script src="resources/newIndexPage/js/bootstrap-form-helpers.min.js"></script>
<script src="resources/newIndexPage/js/bootstrap-select.min.js"></script>
<script src="resources/newIndexPage/js/bootstrap.validator.min.js"></script>
<script src="resources/newIndexPage/js/fileinput.min.js"></script>
<script src="resources/newIndexPage/js/sortable.min.js"></script>
<script src="resources/newIndexPage/js/form-validation.min.js"></script>
<script src="resources/newIndexPage/js/pagination.min.js"></script>
<script src="resources/newIndexPage/js/main.js"></script>
<script>
    $("#menu-toggle").click(function(e) {
        e.preventDefault();
        $("#wrapper").toggleClass("toggled");
    });
</script>
</body>
</html>