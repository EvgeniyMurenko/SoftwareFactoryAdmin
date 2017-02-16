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
        <div class="col-lg-6 col-md-6 col-sm-6 text-right login"><b>CASE OPEN</b> : <a href="javascript:void(0);" data-toggle="modal" data-target="#authorizationModal">고객 아이디로 로그인하세요</a></div>
    </div>
</header>
<!-- #End Header -->

<!-- Content -->
<section class="container content other-font2 mb40">
    <div class="row pt40">
        <div class="col-md-8">

            <h3>What is SoftwareFactory?</h3>
            <div>
                <p>소프트웨어 개발을 <b>공장 자동화의 관점에서 체계화 시킨</b> 스마트 시대형 기술 기업 입니다.</p>

                <p>공정자동화 시스템에 의하여 <b>다양한 프로젝트를 동시에 진행할 수 있으며</b><br />
                    다국적 인력운영시스템에 의하여 <b>개발 기간을 단축 시키는 병렬화 작업이 가능하고</b><br />
                    기술 및 리소스를 빅데이터화 하여 <b>중복 개발 하지 않으며</b><br />
                    전문 분야 문제해결 능력을 지원하는 <b>WIKI 방식의 개발인력 멤버쉽 제도를 운영하고</b> 있습니다.</p>


                <p>이러한 시스템은<br />
                    <b>정예화된 기술인력조직과, 생각하는 디자인 조직이</b> 중심이 되어<br />
                    <span style="color: #03a9f4;">스마트장비 앱,  IOT지원소프트웨어, 고기능성 웹</span> 등<br />
                    현존하는 대부분의 소프트웨어적인 <b>작업대행과 유지보수 를 체계적으로</b> 수행합니다.</p>

                <h3 style="color: #03a9f4;">앱개발 이제 더 이상 실패하지 마십시요.<br />
                    <span style="font-size: 12pt; line-height: 20px;">특급호텔급 개발 서비스를 누려 보세요</span></h3>

                <div class="row">
                    <div class="col-md-8"><img src="resources/newIndexPage/images/shema3.png" alt="" class="img-responsive"></div>
                </div>

                <h3 style="font-size: 12pt; font-weight: bold; margin-bottom: 5px !important;">소프트웨어팩토리의 생각 ...</h3>

                <p style="font-size: 10pt; line-height: 25px !important;">스마트폰 이전 시대까지 소프트웨어 개발 분야는 하이테크 산업이었습니다.<br />
                    스마트폰이 출현하고 SNS 시대가 되면서 모든 비즈니스는 클라우드 가상공간에서 이루어지는 시대가 되었습니다.<br />
                    그래서 많은 사람들이 새로운 사업을 시작해야 하지만 소프트웨어 지원에서 어려움을 겪었으며<br />
                    기존의 기업들도 예전 처럼 저렴한 비용으로 IT조직을 운영하기가 어려워졌습니다.</p>

                <p style="font-size: 10pt; line-height: 25px !important;">아이디어를 가진 사람들에게는 소프트웨어 기술을 제공하고<br />
                    기술에 발목잡혀 비즈니스에 영향 받지 않도록 지속적이고 안정적인 서비스를 제공하며<br />
                    고성능 저비용의 소프트웨어 개발 운영이 필요한 것이 이 시대가 필요하 하는<br />
                    소프트웨어 개발 지원 회사가 해야 할 일입니다.</p>

                <p style="font-size: 10pt; line-height: 25px !important;">소프트웨어팩토리는 공장화. 공정화, 기술빅데이터화, 다국적인력 확보, 교육을 통한 멤버쉽화<br />
                    강력한 핵심 엔지니어 조직화,  생각하는 디자인 조직화를 실현하였으며<br />
                    기술 회사이지만 이미 확보된 대부분의 기술은 고객에게 무상으로 제공하는 것을 원칙으로 하는<br />
                    박리다매형 소프트웨어 개발 공장 입니다.</p>

                <p style="font-size: 10pt; line-height: 25px !important;">소프트웨팩토리는 병렬화 작업 구조인 FXM시스템에 의해서 프로젝트가 분산되어 개발되며<br />
                    이런 구조 확보를 위해서 자연과학기술에 뛰어난 동유럽국가의 인력들과 최고 수준의 대학들이<br />
                    제휴 관계를 형성하고 있으며 소프트웨어팩토리의 대량 작업을 지원하기 위하여 학생들에게<br />
                    실질적인 개발 교육이 가능한 전공과목을 신설하여 지속적인 인력배출 및 라이선스를 발급하고 있습니다.</p>
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