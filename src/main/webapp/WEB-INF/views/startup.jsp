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
        <div class="col-lg-6 col-md-6 col-sm-6 text-right login"><b>CASE OPEN</b> : <a href="javascript:void(0);" data-toggle="modal" data-target="#authorizationModal">고객 아이디로 로그인하세요</a></div>
    </div>
</header>
<!-- #End Header -->

<!-- Content -->
<section class="container content mb40">

    <div class="row pt40">

        <div class="col-md-8 other-font2">
            <h3>SoFAC은 스타트업과 함께 합니다</h3>

            <div class="row mb20">
                <div class="col-md-11"><a data-fancybox="gallery" href="resources/newIndexPage/images/image006.jpg"><img src="resources/newIndexPage/images/image006.jpg" alt="" class="img-responsive" /></a></div>
            </div>

            <p>스타트업 기업의 대부분은 아이디어와 열정을 가지고 있습니다.</p>
            <p>스타트업 기업의 대부분은 <b>자금이 없습니다.</b><br />자금만 있으면 아이디어를 성공 시킬 것이라 믿습니다.</p>
            <p>또 한가지...<br /><span style="font-size: 14pt; font-weight: bold;">스타트업이 잘 알지 못하는 실패 요인이 있습니다.<br />그것은 소프트웨어지원 입니다.<br />스타트업 기업의 대부분은 소프트웨어 개발 단계에서 창업 자금을 모두 소모하게 되며<br />결과는 얻지 못하고 시간만 낭비 하게 됩니다.</span></p>
            <p>소프트웨어는 열정만으로 해결 할 수 있는 문제가 아니기 때문입니다.</p>

            <div class="row mb20">
                <div class="col-md-12"><a data-fancybox="gallery" href="resources/newIndexPage/images/image005.jpg"><img src="resources/newIndexPage/images/image005.jpg" alt="" class="img-responsive" /></a></div>
            </div>

            <p style="font-weight: bold; color: #03a9f4;">소프트웨어팩토리는 스타트업이 필요로 하는 소프트웨어를 지속성 있게 지원하고 함께 하는 프로젝트를 운영하고 있습니다.</p>
            <p>비싼 개발비를 요구하지 않습니다.<br />항상 스타업의 IT 지원팀 처럼   저희의 홈페이지에 로그인 하셔서 CASE를 통해서 원하는 것을 말하기만 하면 됩니다.<br />지속적으로 여러분 곁에 조용히 머무르고 있습니다.<br />유지보수나 어려운 기술 문제에 대해서 아무 걱정하지 않으셔도 됩니다.<br /><span style="font-weight: bold; color: red;">당신의 아이디어를 성공 시키는 일에만 몰두 하세요</span></p>
            <p style="font-weight: bold; color: green;">한가지 더 좋은 점이 있습니다...<br />소프트웨어팩토리는 ㈜굿앤굿파이낸스의 자회사 입니다.<br />굿앤굿파이낸스는 투자자, 회계사, 변호사, 전문경영인들이 함께 하는 곳입니다.<br />여러분들의 아이디어 성장에 따른 자금의 연결이나, 법적 문제의 해결, 회계 문제등<br />성공에 따른 많은 부분을 지원해 드릴 것입니다.</p>
            <p>소프트웨어팩토리와 함께 하시면 굿앤굿과 함께 하는 것입니다.</p>
            <p style="font-size: 14pt; font-weight: bold;">소프트웨어팩토리는 스타트업의 성공을 지원 합니다.</p>

            <div class="row mb20">
                <div class="col-md-11"><a data-fancybox="gallery" href="resources/newIndexPage/images/image007.jpg"><img src="resources/newIndexPage/images/image007.jpg" alt="" class="img-responsive" /></a></div>
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