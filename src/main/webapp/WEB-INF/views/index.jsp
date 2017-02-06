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
        <div class="col-lg-6 col-md-6 col-sm-6 logo">
            <a href="./">소프트웨어<span>팩토리</span></a>
            <div class="small-logo">SoFAC : <i>Software Factory</i></div>
        </div>
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
                <section class="estimation mt40 mb20">
                    <div class="row">
                        <div class="col-md-9 col-sm-9 es-title">처음 오신 고객은 견적, 작업등 모든 문의를 하실 수 있습니다</div>
                        <div class="col-md-3 col-sm-3 es-btn"><a href="javascript:void(0);" class="btn btn-primary"><i class="fa fa-paper-plane-o"></i>문의하기</a></div>
                    </div>
                </section>
                <!-- #End Estimation -->


                <!-- Estimation list case -->
                <section class="estimation-list">
                    <div class="clearfix estimate">
                        <span class="check-on"></span>
                        <a href="javascript:void(0);"><span class="cb-title">청산유수</span></a> : 견적 문의 드립니다 <span class="cb-time">17.01.25 11:28:00</span>
                    </div>

                    <div class="clearfix estimate">
                        <span class="check-off"></span>
                        <a href="javascript:void(0);"><span class="cb-title">박도혁</span></a> : 작업 방법에 대해서 <span class="cb-time">17.01.27 12:26:04</span>
                    </div>

                    <div class="clearfix estimate">
                        <span class="check-on"></span>
                        <a href="javascript:void(0);"><span class="cb-title">청산유수</span></a> : 견적 문의 드립니다 <span class="cb-time">17.01.25 11:28:00</span>
                    </div>

                    <div class="clearfix estimate">
                        <span class="check-off"></span>
                        <a href="javascript:void(0);"><span class="cb-title">박도혁</span></a> : 작업 방법에 대해서 <span class="cb-time">17.01.27 12:26:04</span>
                    </div>

                    <div class="clearfix estimate">
                        <span class="check-on"></span>
                        <a href="javascript:void(0);"><span class="cb-title">청산유수</span></a> : 견적 문의 드립니다 <span class="cb-time">17.01.25 11:28:00</span>
                    </div>

                    <div class="clearfix estimate">
                        <span class="check-off"></span>
                        <a href="javascript:void(0);"><span class="cb-title">박도혁</span></a> : 작업 방법에 대해서 <span class="cb-time">17.01.27 12:26:04</span>
                    </div>
                </section>
                <!-- #End Estimation list case -->

            </div>
            <div class="col-md-6">

                <!-- Information -->
                <section class="information">
                    <div>
                        <span class="if-title">1000명의 엔지니어와 함께 하는</span>
                        <span class="if-title2">온라인 소프트웨어 개발 서비스</span>
                    </div>
                    <div class="mt20 mb20">
                        SoFAC은 전문적인 소프트웨어 개발 지원이 가능한 규모를 갖춘 소프트웨어 개발, 및 유지 운영을 대행하는 전문 개발 기업 입니다.<br>
                        SoFAC의 모든 작업은 CASE 라는 개념을 통하여 소통과 작업이 이루어지며 지속적이고 정확한 서비스를 제공 받으실 수 있습니다. <br>
                    </div>
                    <div class="text-right">
                        <a href="<c:url value='/aboutSofac/' />" class="btn btn-primary"><i class="fa fa-link"></i>SoFAC 알아보기</a>
                    </div>
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
                <h3 class="text-center">CASE 란 무엇인가요 ?</h3>
                <div class="text-justify">스마트 시대가 되면 대부분의 개발은 국제 표준에 대한 개념을 지속적으로 적용하여야 합니다.</div>
                <div class="mt10 text-justify"><b>CASE개념은 24시간 지속적인 고객 지원이 가능한 고객과의 소통 방법이며 정확한 시간 약속과 지원에 대한 결과를 확인할 수 있는 체계 입니다.</b> <a href="javascript:void(0);">자세히  알아보기...</a></div>
            </div>
        </div>
        <div class="col-md-4 mb20">
            <div class="ad-icon"><i class="fa fa-envira"></i></div>
            <div>
                <h3 class="text-center">SoFAC의 가격 정책</h3>
                <div class="text-justify">현대 사회의 모든 사업은 소프트웨어 지원이 필수적입니다. 따라서 기존의 개발비용 개념과.</div>
                <div class="mt10 text-justify"><b>달리 다양한 방법으로 비용을 절감하거나 고객이 원하는 형태로 비용 지불 방법을 정할 수 있는 유연한 가격 정책과 기술료를 받지 않는 정책을 운영합니다.</b> <a href="javascript:void(0);">자세히  알아보기...</a></div>
            </div>
        </div>
        <div class="col-md-4 mb20">
            <div class="ad-icon"><i class="fa fa-laptop"></i></div>
            <div>
                <h3 class="text-center">SoFAC의 다국적 작업 방법</h3>
                <div class="text-justify">SoFAC은 기존의 소규모 개발 회사와 달리 저비용을 실현하면서 개발 및 지속적인 관리가 가능하게 하기 위하여.</div>
                <div class="mt10 text-justify"><b>다국적 개발 및 관리 시스템인 GXM플랫폼을 통하여 공장형 개발 기법을 실현하였습니다.</b> <a href="<c:url value='/guide/' />" >자세히  알아보기...</a></div>
            </div>
        </div>
    </div>
</div>
<div class="clearfix"></div>
<!-- #End Advantage -->

<!-- Tag line -->
<div class="container-fluid tag-line mt20 mb20">
    <div class="container">
        <img src="resources/newIndexPage/images/old-logo.png" alt="" class="img-responsive" />
        <div class="last-blog clearfix">
            <div class="bl-quote"><i class="fa fa-quote-right"></i></div>
            <div class="bl-article-title">10여년 전부터 소프트웨어 지원은 자금 지원과 함께 이루어져야 한다는 생각을 가진<br>㈜굿앤굿재무법인이  미국적 표준화와 다국적 개발 능력을 확보한 전문 개발 대행 기업 입니다.</div>
        </div>
        <div class="bl-body">소프트웨어팩토리는 수준높은 개발과 저비용을 실현한 최초의 소프트웨어 서비스 기업입니다. <a href="javascript:void(0);">자세히  알아보기...</a></div>
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
        <div class="col-md-6 bottom-informer">
            Do you have any questions or suggestions?<br />
            Let us know at <a href="javascript:void(0);">info@sofac.com</a>!
        </div>
        <div class="col-md-6 text-right bottom-menu"><a href="javascript:void(0);">Contact & Credits</a> | <a href="javascript:void(0);">Terms of Service</a> | <a href="javascript:void(0);">Privacy Policy</a></div>
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