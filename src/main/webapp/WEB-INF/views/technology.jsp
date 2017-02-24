<%@ page import="com.SoftwareFactory.model.CustomerInfo" %>
<%@ page import="com.SoftwareFactory.model.Message" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="com.SoftwareFactory.model.Project" %>
<%@ page import="java.util.List" %><%--<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>--%>
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
    <meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1, user-scalable=no, minimal-ui" />
    <meta name="format-detection" content="telephone=no" />
    <meta name="format-detection" content="address=no" />

    <meta property="og:site_name" content="software factory" />
    <meta property="og:title" content="소팩소개" />
    <meta property="og:image" content="/resources/newIndexPage/images/web-logo.jpg" />
    <meta property="og:url" content="http://www.sofac.kr/" />
    <meta property="og:description" content="" />

    <meta name="description" content="" />
    <meta name="keywords" content="" />

    <title>실시간 데이터 교환 엔진 (ExD) :: Software Factory</title>

    <link href="/resources/newIndexPage/css/bootstrap.min.css" rel="stylesheet" />
    <link href="/resources/newIndexPage/css/bootstrap-select.min.css" rel="stylesheet" />
    <link href="/resources/newIndexPage/css/jquery.fancybox.min.css" rel="stylesheet" />
    <link href="/resources/newIndexPage/css/jquery.sweet-alert.min.css" rel="stylesheet" />
    <link href="/resources/newIndexPage/css/font-awesome.min.css" rel="stylesheet" />
    <link href="/resources/newIndexPage/css/awesome-bootstrap-checkbox.min.css" rel="stylesheet" />
    <link href="/resources/newIndexPage/css/fileinput.min.css" rel="stylesheet" />
    <link href="/resources/newIndexPage/css/style.css" rel="stylesheet" />
    <link href="/resources/newIndexPage/css/responsive.css" rel="stylesheet" />

    <link rel="apple-touch-icon" sizes="57x57" href="/resources/newIndexPage/images/apple-icon-57x57.png" />
    <link rel="apple-touch-icon" sizes="60x60" href="/resources/newIndexPage/images/apple-icon-60x60.png" />
    <link rel="apple-touch-icon" sizes="72x72" href="/resources/newIndexPage/images/apple-icon-72x72.png" />
    <link rel="apple-touch-icon" sizes="76x76" href="/resources/newIndexPage/images/apple-icon-76x76.png" />
    <link rel="apple-touch-icon" sizes="114x114" href="/resources/newIndexPage/images/apple-icon-114x114.png" />
    <link rel="apple-touch-icon" sizes="120x120" href="/resources/newIndexPage/images/apple-icon-120x120.png" />
    <link rel="apple-touch-icon" sizes="144x144" href="/resources/newIndexPage/images/apple-icon-144x144.png" />
    <link rel="apple-touch-icon" sizes="152x152" href="/resources/newIndexPage/images/apple-icon-152x152.png" />
    <link rel="apple-touch-icon" sizes="180x180" href="/resources/newIndexPage/images/apple-icon-180x180.png" />
    <link rel="icon" type="image/png" sizes="192x192"  href="/resources/newIndexPage/images/android-icon-192x192.png" />
    <link rel="icon" type="image/png" sizes="32x32" href="/resources/newIndexPage/images/favicon-32x32.png" />
    <link rel="icon" type="image/png" sizes="96x96" href="/resources/newIndexPage/images/favicon-96x96.png" />
    <link rel="icon" type="image/png" sizes="16x16" href="/resources/newIndexPage/images/favicon-16x16.png" />
    <link rel="manifest" href="/resources/newIndexPage/images/manifest.json" />
    <meta name="msapplication-TileColor" content="#ffffff" />
    <meta name="msapplication-TileImage" content="/resources/newIndexPage/images/ms-icon-144x144.png" />
    <meta name="theme-color" content="#ffffff" />

    <!--[if lt IE 9]>
    <script src="/resources/newIndexPage/js/html5shiv.js"></script>
    <script src="/resources/newIndexPage/js/respond.min.js"></script>
    <![endif]-->
</head>
<body>

<!-- Header -->
<header class="container header">
    <div class="row">
        <div class="col-lg-6 col-md-6 col-sm-6 logo">
            <div class="orange-button"><a href="./"><img src="/resources/newIndexPage/images/home-button.png" alt="" /></a></div>
            <a href="./">소프트웨어<span>팩토리</span></a>
            <div class="small-logo">SoFAC : <i>Software Factory</i></div>
        </div>
        <div class="col-lg-6 col-md-6 col-sm-6 text-right login"><b>CASE OPEN</b> : <a href="javascript:void(0);" data-toggle="modal" data-target="#authorizationModal">고객 아이디로 로그인하세요</a></div>
    </div>
</header>
<!-- #End Header -->

<!-- Content -->
<section class="container content other-font2 mb40">
    <div class="row pt40">
        <div class="col-md-8">

            <h3>실시간 데이터 교환 엔진 (ExD)</h3>
            <p>ExD(Engine of High speed Realtime exchange Data) 엔진은 1997에 최초로 탄생하여 실시간 데이터 통신 시대를 여는데 핵심적인 역할을 하였으며, 한국 및 일본의 실시간 주가공급 시스템 및 유명 메신저의 서버 엔진으로 활용되어 왔습니다.<br />
                이 엔진은 노하우만 살리고 기술적인 부분은 구소련의 자연과학 기술을 보유한 유능한 엔지니어들에 의해서 모바일 지원용으로 전면 교체 개발 되어 있습니다.<br />
                이것은 고객님들의 어플 개발시 막대한 비용절감 및 고성능 앱 개발에 큰 도움이 될 것입니다.</p>

            <div class="row">
                <div class="col-md-12 mt20"><a data-fancybox="gallery" href="/resources/newIndexPage/images/shema9.jpg"><img src="/resources/newIndexPage/images/shema9.jpg" alt="" class="img-responsive"></a></div>
                <div class="col-md-12 clearfix mt40"><a data-fancybox="gallery" href="/resources/newIndexPage/images/shema10.png"><img src="/resources/newIndexPage/images/shema10.png" alt="" class="img-responsive"></a></div>
            </div>

            <h3>SPRIM Socket</h3>
            <p>실시간 통신 기술에서는 Socket 통신을 사용합니다.<br />
                스마트폰 시대에도 Socket 통신을 사용하지만 스마트폰은 항상 이동하고 있으므로 통신 접속의 유지 기술이 매우 중요합니다.
            </p>
            <p><b>SPRIM(Socket protocol redefinition for intelligent mobile)</b> 소켓 전송 <b>기술은 스마트폰에서</b><br />
                <b>안정적인 통신을 보장하는 최적의 알고리즘 정리한 특허 기술 입니다.</b></p>

            <div class="row">
                <div class="col-md-12 mt20 mb40"><a data-fancybox="gallery" href="/resources/newIndexPage/images/shema11.jpg"><img src="/resources/newIndexPage/images/shema11.jpg" alt="" class="img-responsive"></a></div>
            </div>

            <div class="row">
                <div class="col-md-4 col-sm-4 col-xs-6" style="border-right: 3px dotted #aaa;"><img src="/resources/newIndexPage/images/serf7.png" alt="" class="img-responsive"></div>
                <div class="col-md-8 col-sm-12 col-xs-12">
                    <h3>SoFAC의 기술제공 정책</h3>

                    <p>소프트웨어팩토리는<br />
                        스마트 시대에 필요한 핵심 엔진을 보유하고 있으며 앱 개발시 엔진 적용 및 기술료를 받지 않는 것을 기본 정책으로 하고 있습니다.</p>

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

<!-- Authorization modal window -->
<div id="authorizationModal" class="modal fade">
    <div class="modal-dialog">
        <div class="modal-content">

            <!-- Authorization modal title -->
            <form id="authorizationForm" method="post" class="form-horizontal">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                    <h4><i class="fa fa-user-o" aria-hidden="true"></i> 고객님 CASE 로그인에 오신 것을 환영합니다.</h4>
                    <div class="ml30">발급 받은 고객번호와 패스워드를 입력해 주세요</div>
                </div>

                <!-- Authorization modal content -->
                <div class="modal-body">
                    <div class="row">
                        <div class="col-md-6 mb10 text-center"><img src="/resources/newIndexPage/images/hello-womam.jpg" class="img-responsive position-center" alt=""></div>
                        <div class="col-md-6">
                            <div class="form-group">
                                <div class="col-lg-12 text-left">
                                    <input type="email" name="email" class="form-control form-block" placeholder="고객 ID" required />
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-lg-12 text-left">
                                    <input type="password" name="password" class="form-control form-block" placeholder="패스워드" required />
                                </div>
                            </div>

                            <div class="form-group">
                                <div class="col-lg-12 text-left">
                                    <button type="submit" class="btn btn-primary btn-mobile">로그인</button>
                                </div>
                            </div>

                            <div class="mt10 mb10 forgot-password"><a href="javascript:void(0);">패스워드를 잊어 버리셨나요 ?</a></div>

                            <p class="mt20"><span style="font-size: 9pt;"><i>고객ID는 SoFAC 과 지속적인 대화를 원하실 경우<br />
                                    임시고객ID를 발급하여 드립니다.<br />
                                    발급요청은 초기 화면에서 문의하기를 통해서<br />
                                    접수하실 수 있습니다.<br />
                                    일회성 질문이나 견적문의는 고객ID를 발급하지<br />
                                    않습니다.</i></span>
                            </p>
                        </div>
                    </div>
                </div>

                <!-- Authorization modal footer -->
                <div class="modal-footer">
                    <button type="button" class="btn btn-default btn-mobile" data-dismiss="modal">닫기</button>
                </div>
            </form>
        </div>
    </div>
</div>
<!-- #End Authorization modal window -->

<script src="/resources/newIndexPage/js/jquery.min.js"></script>
<script src="/resources/newIndexPage/js/jquery-ui.min.js"></script>
<script src="/resources/newIndexPage/js/jquery.mousewheel.min.js"></script>
<script src="/resources/newIndexPage/js/jquery.fancybox.min.js"></script>
<script src="/resources/newIndexPage/js/jquery.sweet-alert.min.js"></script>
<script src="/resources/newIndexPage/js/jquery.timeago.js"></script>
<script src="/resources/newIndexPage/js/jquery.timeago.ko.js"></script>
<script src="/resources/newIndexPage/js/bootstrap.min.js"></script>
<script src="/resources/newIndexPage/js/bootstrap-form-helpers.min.js"></script>
<script src="/resources/newIndexPage/js/bootstrap-select.min.js"></script>
<script src="/resources/newIndexPage/js/bootstrap.validator.min.js"></script>
<script src="/resources/newIndexPage/js/fileinput.min.js"></script>
<script src="/resources/newIndexPage/js/sortable.min.js"></script>
<script src="/resources/newIndexPage/js/form-validation.min.js"></script>
<script src="/resources/newIndexPage/js/pagination.min.js"></script>
<script src="/resources/newIndexPage/js/main.js"></script>
</body>
</html>