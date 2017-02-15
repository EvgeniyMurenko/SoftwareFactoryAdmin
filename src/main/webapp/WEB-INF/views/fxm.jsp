<%@ page import="java.util.Locale" %>
<%@ page import="org.springframework.web.servlet.support.RequestContextUtils" %><%--<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>--%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page session="false" %>

<!DOCTYPE html>
<html lang="kr">
<head>
    <meta charset="utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1, user-scalable=no, minimal-ui"/>
    <meta name="format-detection" content="telephone=no"/>
    <meta name="format-detection" content="address=no"/>

    <meta name="description" content=""/>
    <meta name="keywords" content=""/>

    <title>FXM 시스템의 특징 :: Software Factory</title>

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
        <div class="col-lg-6 col-md-6 col-sm-6 text-right login"><b>CASE OPEN</b> : <a href="javascript:void(0);" data-toggle="modal" data-target="#authorizationModal">고객 아이디로 로그인하세요</a></div>
        </div>
    </div>
</header>
<!-- #End Header -->

<!-- Content -->
<section class="container content other-font2 mb40">

    <div class="row pt40">
        <div class="col-md-9">

            <h3 class="mb10">고객지원 조직</h3>

            <p>소프트웨어팩토리는 스마트 시대에 필요한 다양한 종류의 소프트웨어 관련 개발 모든 업무를 대행하고 있습니다.<br />
                따라서 스토리제작팀, 개발조직, 디자인조직, 유지보수팀, 모니터링팀, 고객지원팀 등이 운영되고 있습니다.<br />
                이 조직들은 특성에 맞게 여러 나라에 걸쳐서 분산되어 있으며 모든 조직은 공정관리시스템에 의해서 관리되고 실시간으로 모든 처리가 가능하도록 SoFAC  harmony  APP에 의해서 실시간 관리 되고 있습니다.</p>

            <p>언제 어디서든 고객의 질문과 질문에 대응 하며 고객의 비상상황을 가장 빨리 감지하고 긴급 대응하는 구조를 갖추고 있습니다.</p>

            <div class="row mb30">
                <div class="col-md-10"><a data-fancybox="gallery" href="resources/newIndexPage/images/shema6.png"><img src="resources/newIndexPage/images/shema6.png" alt="" class="img-responsive" /></a></div>
            </div>

            <h3 style="margin-top: 100px;">개발 지원용 기술 및 리소스 뱅크</h3>

            <p>다양한 개발 작업 과정중에 발생되는 부품과 같은 라이브러리나 리소스들은 항상 데이터베이스에<br />
                리소스 형태로 보관되어 SoFAC의 멤법쉽 개발자들이 언제든지 사용할 수 있게 되어 있으며<br />
                이것은 시간을 단축하고 제품은 수준을 높이는 매우 중요한 기술의 집합소 입니다.<br />
                SoFAC만이 보유하고 있는 리소스 축척 시스템은  좋은 제품을 위한 중요한 시스템 입니다.</p>

            <div class="row mb30">
                <div class="col-md-10"><a data-fancybox="gallery" href="resources/newIndexPage/images/shema7.png"><img src="resources/newIndexPage/images/shema7.png" alt="" class="img-responsive" /></a></div>
            </div>

            <h3 style="margin-top: 100px;">예술의 역사를 가진 디자인 조직</h3>

            <p>소프트웨어에서 디자인은 단순한 표면장식이 아닙니다.<br />
                UX,UI를 모두 이해한 가운데 감성을 표현하는 매우 중요한 조직 입니다.<br />
                소프트웨어팩토리는 핵심 코어 엔지니어팀은  바로 옆에 “생각하는디자인팀” 이라는 조직을<br />
                항상 곁에 두고 고객의 요구사항에 대해서 설명이 아닌 예제로 보여드릴 수 있는<br />
                차별화된  디자인 팀을 운영하고 있으며 디자인팀의 규모는 핵심 코어팀 보다 크고 중요한<br />
                위치를 차지하고 있습니다.</p>

            <div class="row mb30">
                <div class="col-md-5 mb10"><a data-fancybox="gallery" href="resources/newIndexPage/images/image001.png"><img src="resources/newIndexPage/images/image001.png" alt="" class="img-responsive" /></a></div>
                <div class="col-md-5 mb10"><a data-fancybox="gallery" href="resources/newIndexPage/images/image002.png"><img src="resources/newIndexPage/images/image002.png" alt="" class="img-responsive" /></a></div>
            </div>

            <h3 style="margin-top: 100px;">모니터링 시스템</h3>

            <p>예전과 달리 스마트 시대에는 전문적인 IT조직을 가지고 있지 않는 개인 또는 스타트업의 경우<br />
                전문적인 시스템의 운영에 어려움을 겪을 수 있습니다.<br />
                따라서 SoFAC은 전문 모니터링 대응팀을 운영합니다.<br />
                고객의 서버를 24시간 감시하고, 보안에 대응하며 비상 상황 발생시 자동감지하여 빠르게 복구하며<br />
                고객의 비상상황 접수시 실시간 대응하는 구조를 갖추고 있습니다.</p>

            <div class="row mb30">
                <div class="col-md-10"><a data-fancybox="gallery" href="resources/newIndexPage/images/shema8.png"><img src="resources/newIndexPage/images/shema8.png" alt="" class="img-responsive" /></a></div>
            </div>

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

<!-- Authorization modal window -->
<div id="authorizationModal" class="modal fade">
    <div class="modal-dialog">
        <div class="modal-content">

            <c:url var="loginUrl" value="/login?${_csrf.parameterName}=${_csrf.token}"/>
            <!-- Authorization modal title -->
            <form action="${loginUrl}" id="authorizationForm" method="post" class="form-horizontal">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                    <h4><i class="fa fa-user-o" aria-hidden="true"></i> 고객님 CASE 로그인에 오신 것을 환영합니다.</h4>
                    <div class="ml30">발급 받은 고객번호와 패스워드를 입력해 주세요</div>
                </div>

                <!-- Authorization modal content -->
                <div class="modal-body">
                    <div class="row">
                        <div class="col-md-6 mb10 text-center"><img src="resources/newIndexPage/images/hello-womam.jpg" class="img-responsive position-center" alt=""></div>
                        <div class="col-md-6">
                            <div class="form-group">
                                <div class="col-lg-12 text-left">
                                    <input type="text" name="ssoId" class="form-control form-block" placeholder="고객 ID" required />
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

                <%--         <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>--%>

                <!-- Authorization modal footer -->
                <div class="modal-footer">
                    <button type="button" class="btn btn-default btn-mobile" data-dismiss="modal">닫기</button>
                </div>
            </form>
        </div>
    </div>
</div>
<!-- #End Authorization modal window -->

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