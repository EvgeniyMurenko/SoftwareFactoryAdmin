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

    <title>소팩소개 :: Software Factory</title>

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

<body>

<!-- Header -->
<header class="container header">
    <div class="row">
        <div class="col-lg-6 col-md-6 col-sm-6 logo"><a href="./">소프트웨어<span>팩토리</span></a></div>
        <div class="col-lg-6 col-md-6 col-sm-6 text-right login"><a href="javascript:void(0);">이미 회원입니까? 로그인하십시오!</a></div>
    </div>
</header>
<!-- #End Header -->

<!-- Cover section -->
<div class="container-fluid cover">
    <div class="container">
        <div class="row">
            <div class="col-md-6">

                <!-- Estimation -->
                <section class="estimation">
                    <div class="row">
                        <div class="col-md-9 col-sm-9 es-title">처음 오신 고객은 견적, 작업등 모든 문의를 하실 수 있습니다</div>
                        <div class="col-md-3 col-sm-3 es-btn"><a href="javascript:void(0);" class="btn btn-primary"><i class="fa fa-paper-plane-o"></i>문의하기</a></div>
                    </div>
                    <span class="delimiter"></span>

                    <!-- Estimation list case -->
                    <div class="checkbox">
                        <input class="styled" id="checkbox1" checked="" disabled="" type="checkbox">
                        <label for="checkbox1">
                            <span class="cb-title">청산유수</span> : 견적 문의 드립니다 <span class="cb-time">17.01.25 11:28:00</span>
                        </label>
                    </div>

                    <div class="checkbox">
                        <input class="styled" id="checkbox2" checked="" disabled="" type="checkbox">
                        <label for="checkbox2">
                            <span class="cb-title">박도혁</span> : 견적 문의 드립니다 <span class="cb-time">16.01.25 15:28:00</span>
                        </label>
                    </div>

                    <div class="checkbox">
                        <input class="styled" id="checkbox3" disabled="" type="checkbox">
                        <label for="checkbox3">
                            <span class="cb-title">청산유수</span> : 견적 문의 드립니다 <span class="cb-time">15.01.25 12:28:00</span>
                        </label>
                    </div>

                    <div class="checkbox">
                        <input class="styled" id="checkbox4" disabled="" type="checkbox">
                        <label for="checkbox4">
                            <span class="cb-title">박도혁</span> : 견적 문의 드립니다 <span class="cb-time">13.01.25 15:28:00</span>
                        </label>
                    </div>

                    <div class="checkbox">
                        <input class="styled" id="checkbox5" checked="" disabled="" type="checkbox">
                        <label for="checkbox5">
                            <span class="cb-title">청산유수</span> : 견적 문의 드립니다 <span class="cb-time">12.01.25 18:28:00</span>
                        </label>
                    </div>

                    <div class="checkbox">
                        <input class="styled" id="checkbox6" checked="" disabled="" type="checkbox">
                        <label for="checkbox6">
                            <span class="cb-title">박도혁</span> : 견적 문의 드립니다 <span class="cb-time">11.01.25 15:28:00</span>
                        </label>
                    </div>

                    <div class="checkbox">
                        <input class="styled" id="checkbox7" disabled="" type="checkbox">
                        <label for="checkbox7">
                            <span class="cb-title">청산유수</span> : 견적 문의 드립니다 <span class="cb-time">10.01.25 15:28:00</span>
                        </label>
                    </div>
                    <!-- #End Estimation list case -->

                </section>
                <!-- #End Estimation -->

            </div>
            <div class="col-md-6">

                <!-- Information -->
                <section class="information">
                    <div>
                        <span class="if-title">1000명의 엔지니어와 함께 하는</span>
                        <span class="if-title2">온라인 소프트웨어 개발 서비스</span>
                    </div>
                    <div class="mt20 mb20">
                        SoFAC stays out of your way but it’s there when you need it. Get organized with ease and no nonsense.<br>
                        <b>Join our beta and be more productive than ever!</b>
                    </div>

                    <form class="form-inline">
                        <div class="form-group">
                            <label class="sr-only" for="email">Email address</label>
                            <input type="email" class="form-control" id="email" placeholder="Email">
                        </div>
                        <button type="submit" class="btn btn-primary"><i class="fa fa-check-square-o"></i>Request free beta access</button>
                    </form>

                    <div class="mt20">Do you already have an invitation? <a href="javascript:void(0);">Click here</a>.</div>

                </section>
                <!-- #End Information -->

                <!-- Video button -->
                <div class="text-center mb20"><a href="javascript:void(0);" class="btn btn-default"><i class="fa fa-video-camera"></i>SoFAC Video</a></div>
                <!-- #End Video button -->

            </div>
        </div>
    </div>
</div>
<div class="clearfix"></div>
<!-- #End Cover section -->

<!-- Advantage -->
<div class="container mt40 mb30 advantage">
    <div class="row">
        <div class="col-md-4 mb20">
            <div class="ad-icon"><i class="fa fa-clock-o"></i></div>
            <div>
                <h3 class="text-center">Keep track of your time</h3>
                <div class="text-justify">Take advantage of our Pomodoro-style time intervals or use regular time tracking.
                    Get clear reports on how you spend your time and export all data as you need it.</div>
                <div class="mt10 text-justify"><b>Straightforward time tracking, useful reporting and simple data export.</b></div>
            </div>
        </div>
        <div class="col-md-4 mb20">
            <div class="ad-icon"><i class="fa fa-envira"></i></div>
            <div>
                <h3 class="text-center">Conveniently keyboardy</h3>
                <div class="text-justify">SoFAC is being developed with keyboard affictionados in mind. Use our convenient syntax
                    to efficiently schedule to-dos, create recurring tasks or use the time tracking.</div>
                <div class="mt10 text-justify"><b>Waste less time with our keyboard-based interface. Intelligent auto-complete included.</b></div>
            </div>
        </div>
        <div class="col-md-4 mb20">
            <div class="ad-icon"><i class="fa fa-laptop"></i></div>
            <div>
                <h3 class="text-center">Powerful desktop application</h3>
                <div class="text-justify">Add new tasks and track your time directly from your desktop (think Spotlight for your organizational needs).</div>
                <div class="mt10 text-justify"><b>Our desktop client is available for Mac, Windows and Linux.</b></div>
            </div>
        </div>
    </div>
</div>
<div class="clearfix"></div>
<!-- #End Advantage -->

<!-- Tag line -->
<div class="container-fluid tag-line mt20 mb20">
    <div class="container">
        <h4>Fresh from the blog</h4>
        <div class="last-blog clearfix">
            <div class="bl-quote"><i class="fa fa-quote-right"></i></div>
            <div class="bl-article-title"><a href="javascript:void(0);">Outside the Zone: What I Do When I Don’t Feel like Working</a></div>
        </div>
        <div class="bl-body">A really simple method that has helped me so many times. <a href="javascript:void(0);">Read the full story...</a></div>
    </div>
</div>
<div class="clearfix"></div>
<!-- #End Tag line -->

<!-- Features -->
<div class="container features mt30 mb30">
    <div class="text-center mb20">
        <h3>More awesome features are already in the works</h3>
        <p>The following features are not yet available in now.do but are planned as part of our effort to make now.do the best productivity tool you will ever use.</p>
    </div>

    <!-- Features list -->
    <div class="row">
        <div class="col-md-6">
            <article class="feature clearfix">
                <div class="ft-icon"><i class="fa fa-external-link"></i></div>
                <div class="ft-content">
                    <div class="ft-title">Set weekly goals</div>
                    <div class="ft-body">Share to-dos, notes and files with other users of now.do.</div>
                </div>
            </article>
        </div>
        <div class="col-md-6">
            <article class="feature clearfix">
                <div class="ft-icon"><i class="fa fa-star"></i></div>
                <div class="ft-content">
                    <div class="ft-title">Set weekly goals</div>
                    <div class="ft-body">Setting regular goals is always a great help for becoming more productive. now.do lets you set weekly time goals for your projects and help you achieve more.</div>
                </div>
            </article>
        </div>
    </div>

    <div class="row">
        <div class="col-md-6">
            <article class="feature clearfix">
                <div class="ft-icon"><i class="fa fa-file-o"></i></div>
                <div class="ft-content">
                    <div class="ft-title">Notes & Attachments</div>
                    <div class="ft-body">Add notes and file attachments to your tasks. This is super-convenient for adding context to your tasks or for keeping notes during phone conversations and meetings.</div>
                </div>
            </article>
        </div>
        <div class="col-md-6">
            <article class="feature clearfix">
                <div class="ft-icon"><i class="fa fa-terminal"></i></div>
                <div class="ft-content">
                    <div class="ft-title">CLI interface & Open API</div>
                    <div class="ft-body">Automate workflows and task creation through our convenient command-line application and our open API.</div>
                </div>
            </article>
        </div>
    </div>

    <div class="row">
        <div class="col-md-6">
            <article class="feature clearfix">
                <div class="ft-icon"><i class="fa fa-mobile"></i></div>
                <div class="ft-content">
                    <div class="ft-title">Mobile version for iOS & Android</div>
                    <div class="ft-body">now.do’s main focus is helping you improve your productivity when you are on your laptop or desktop computer. But of course, you want to be able to also use it when you only have a mobile device with you, don’t you?</div>
                </div>
            </article>
        </div>
        <div class="col-md-6">
            <article class="feature clearfix">
                <div class="ft-icon"><i class="fa fa-flask"></i></div>
                <div class="ft-content">
                    <div class="ft-title">Whatever you need</div>
                    <div class="ft-body">now.do is developed in a very unique way: Our users get to vote and decide which new features are most important to them and should be implemented first.</div>
                </div>
            </article>
        </div>
    </div>
    <!-- #End Features list -->

</div>
<div class="clearfix"></div>
<!-- #End Features -->

<!-- Footer -->
<footer class="container footer mb20">
    <div class="row">
        <div class="col-md-6">
            Do you have any questions or suggestions?<br />
            Let us know at <a href="javascript:void(0);">info@sofac.com</a>!
        </div>
        <div class="col-md-6 text-right"><a href="javascript:void(0);">Contact & Credits</a> | <a href="javascript:void(0);">Terms of Service</a> | <a href="javascript:void(0);">Privacy Policy</a></div>

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
