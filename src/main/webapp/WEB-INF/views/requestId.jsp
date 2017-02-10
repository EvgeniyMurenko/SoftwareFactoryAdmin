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
    <link href="resources/newIndexPage/css/fileinput.min.css" rel="stylesheet" />
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
            <a href="./">소프트웨어<span>팩토리</span></a>
            <div class="small-logo">SoFAC : <i>Software Factory</i></div>
        </div>
    </div>
</header>
<!-- #End Header -->

<section class="container content mb40 request-id">

    <div class="row pt40 pb40">
        <div class="col-md-8">
            <h3 class="mt0">SoFAC과 지속적인 대화를 위한 ID 발급을 원하십니까 ?</h3>

            <form>
                <div class="row">
                    <div class="col-md-6">
                        <div class="form-group">
                            <input type="text" name="name" id="name" class="form-control" placeholder="이름" required />
                        </div>

                        <div class="form-group">
                            <input type="email" name="email" id="email" class="form-control form-block" placeholder="이메일" required />
                        </div>

                        <div class="form-group">
                            <input type="text" name="phone" id="phone" class="form-control bfh-phone" value="" pattern="[\+]\d{2}\s[\(]\d{2}[\)]\s\d{4}[\-]\d{4}$" placeholder="전화번호" data-format="+82 (dd) dddd-dddd" maxlength="100" required />
                        </div>

                        <div class="form-group">
                            <input type="text" name="companyName" id="company-name" class="form-control bfh-phone" value="" placeholder="회사명" required />
                        </div>

                        <div class="form-group">
                            <input type="text" name="companyName" id="company-site" class="form-control bfh-phone" value="" placeholder="회사 홈페이지" required />
                        </div>

                        <button type="submit" class="btn btn-primary">CASE ID 발급을 요청합니다</button>
                    </div>
                </div>
                <div class="clearfix"></div>
            </form>

            <div class="pt40"><small>CASE ID는 4자의 숫자로 발급됩니다.<br />
                잘 기억해 주시기 바랍니다.<br />
                CASE 로그인에 필요한 패스워드는 휴대폰 번호 입니다.<br />
                (로그인 후 패스워드 변경 가능)</small></div>

        </div>
    </div>

</section>

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
                        <div class="col-md-6"><img src="resources/newIndexPage/images/hello-womam.jpg" class="img-responsive" alt=""></div>
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
                                    <button type="submit" class="btn btn-primary">로그인</button>
                                </div>
                            </div>

                            <div class="mt10 mb10 forgot-password"><a href="javascript:void(0);">패스워드를 잊어 버리셨나요 ?</a></div>

                            <p class="mt20"><small><i>고객ID는 SoFAC 과 지속적인 대화를 원하실 경우<br />
                                임시고객ID를 발급하여 드립니다.<br />
                                발급요청은 초기 화면에서 문의하기를 통해서<br />
                                접수하실 수 있습니다.<br />
                                일회성 질문이나 견적문의는 고객ID를 발급하지<br />
                                않습니다.</i></small>
                            </p>
                        </div>
                    </div>
                </div>

                <!-- Authorization modal footer -->
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">닫기</button>
                </div>
            </form>
        </div>
    </div>
</div>
<!-- #End Authorization modal window -->

<!-- Estimate modal window -->
<div id="estimationModal" class="modal fade">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">

            <!-- Estimate modal title -->
            <form id="estimationForm" method="post" class="form-horizontal" role="form" data-toggle="validator">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                    <h4><i class="fa fa-address-card-o" aria-hidden="true"></i> 문의 해 주세요...</h4>
                    <b>견적요청 및 문의사항을 남겨 주시면 3시간 이내에 답변을 메일로 보내드립니다.</b>
                    <div class="mt10 es-form-title">
                        <p><i>이 페이지는 단 한번만의 답변을 받으실 수 있습니다.<br />견적 또는 어떠한 질문도 하실 수 있으며 한번의 질문에 한번의 답변만 받으실 수 있습니다.</i></p>
                        <p><i>따라서 협상, 업무협의등 지속성이 필요하실 경우 답변으로 받으신 이메일에 기재 되어 있는 방법대로 요청하시면 고객 ID를 발급하여 드립니다.</i></p>
                        <p><i>고객 아이디를 발급 받으신 분은 어떤 문제에 대해서도 CASE로그인을 통하여 언제든지 대화를 이어 가실 수 있습니다.</i></p>
                    </div>
                </div>

                <!-- Estimate modal -->
                <div class="modal-body">

                    <div class="row">
                        <!-- fields -->
                        <div class="col-md-4">
                            <div class="form-group">
                                <div class="col-lg-12 text-left">
                                    <input type="text" name="name" class="form-control form-block" placeholder="이름" required />
                                </div>
                            </div>

                            <div class="form-group">
                                <div class="col-lg-12 text-left">
                                    <input type="email" name="email" class="form-control form-block" placeholder="이메일" required />
                                </div>
                            </div>

                            <div class="form-group">
                                <div class="col-lg-12 text-left">
                                    <!-- <input type="text" name="phone" class="form-control form-block" pattern="[\+]\d{3}\s[\(]\d{2}[\)]\s\d{3}[\-]\d{4}$" data-format="+380 (dd) ddd-dddd" maxlength="100" placeholder="전화번호" required />-->
                                    <input type="text" name="phone" id="phone" class="form-control bfh-phone" value="" pattern="[\+]\d{2}\s[\(]\d{2}[\)]\s\d{4}[\-]\d{4}$" placeholder="전화번호" data-format="+82 (dd) dddd-dddd" maxlength="100" required />
                                </div>
                            </div>

                            <div class="checkbox">
                                <input id="request" name="request[]" class="styled" type="checkbox">
                                <label for="request">견적문의</label>
                            </div>

                            <div class="checkbox">
                                <input id="question" name="request[]" class="styled" type="checkbox">
                                <label for="question">일반문의</label>
                            </div>
                        </div>
                        <!-- message -->
                        <div class="col-md-8">
                            <div class="form-group">
                                <div class="col-lg-12 text-left">
                                    <textarea class="form-control form-block" name="message" rows="9" placeholder="문의사항을 적어 주세요" required></textarea>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="form-group mt20">
                        <div class="col-lg-12 text-left">
                            <input id="input-repl-2" name="inputrepl2[]" type="file" class="file-loading" accept="image/*" multiple>
                        </div>
                    </div>
                </div>

                <!-- Estimate modal footer -->
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">닫기</button>
                    <button type="submit" class="btn btn-primary">보내기</button>
                </div>
            </form>
        </div>
    </div>
</div>
<!-- #End Estimate modal window -->

<script src="resources/newIndexPage/js/jquery.min.js"></script>
<script src="resources/newIndexPage/js/jquery-ui.min.js"></script>
<script src="resources/newIndexPage/js/jquery.mousewheel.min.js"></script>
<script src="resources/newIndexPage/js/jquery.fancybox.min.js"></script>
<script src="resources/newIndexPage/js/jquery.sweet-alert.min.js"></script>
<script src="resources/newIndexPage/js/bootstrap.min.js"></script>
<script src="resources/newIndexPage/js/bootstrap-form-helpers.min.js"></script>
<script src="resources/newIndexPage/js/bootstrap-select.min.js"></script>
<script src="resources/newIndexPage/js/bootstrap.validator.min.js"></script>
<script src="resources/newIndexPage/js/fileinput.min.js"></script>
<script src="resources/newIndexPage/js/sortable.min.js"></script>
<script src="resources/newIndexPage/js/form-validation.min.js"></script>
<script src="resources/newIndexPage/js/main.js"></script>
</body>
</html>
