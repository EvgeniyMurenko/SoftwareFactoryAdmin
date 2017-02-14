<%@ page import="java.util.Locale" %>
<%@ page import="org.springframework.web.servlet.support.RequestContextUtils" %>
<%@ page import="com.SoftwareFactory.model.Estimate" %><%--<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>--%>
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

<% Estimate estimate = (Estimate) request.getAttribute("CustomerEstimate") ;              %>


<section class="container content mb40 request-id">

    <div class="row pt40 pb40">
        <div class="col-md-8">
            <h3 class="mt0">SoFAC과 지속적인 대화를 위한 ID 발급을 원하십니까 ?</h3>

            <c:url var="generateCustomerIdUrl" value="/generateCustomerId?${_csrf.parameterName}=${_csrf.token}"/>
            <form action="${generateCustomerIdUrl}" method="post" >
                <div class="row">
                    <div class="col-md-6">
                        <input type="hidden" name="estimateId" value="<%out.print(estimate.getId());%>">

                        <div class="form-group">
                            <input type="text" name="name" id="name" class="form-control" value="<%out.print(estimate.getName());%>" placeholder="이름" required />
                        </div>

                        <div class="form-group">
                            <input type="email" name="email" id="email" class="form-control form-block" value="<%out.print(estimate.getEmail());%>" placeholder="이메일"  required />
                        </div>

                        <div class="form-group">
                            <input type="text" name="phone" id="phone" class="form-control bfh-phone" value="<%out.print(estimate.getPhone());%>" pattern="[\(]\d{3}[\)]\s\d{4}[\-]\d{4}$" placeholder="전화번호" data-format="(ddd) dddd-dddd" maxlength="100" required />
                        </div>

                        <div class="form-group">
                            <input type="text" name="companyName" id="company-name" class="form-control" value="" placeholder="회사명" required />
                        </div>

                        <div class="form-group">
                            <input type="text" name="companySite" id="company-site" class="form-control" value=""  placeholder="회사 홈페이지" required />
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