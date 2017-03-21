<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page session="false" %>
<!DOCTYPE html>
<html lang="kr">
<head>

    <%@ include file="siteHeaderMeta.jsp" %>

    <title>공지 사항 :: Software Factory</title>

    <%@ include file="siteHeaderStyle.jsp" %>

</head>
<body>

<%@ include file="siteHeader.jsp" %>

<!-- Content -->
<section class="container content mb40">
    <div class="row pt40">
        <div class="col-md-8">

            <div>

                <h3>공지 사항</h3>

                <!-- Notice box -->
                <div class="notice-box">
                    <a href="javascript:void(0);" id="notice_1" class="clearfix">
                        <span class="pull-left">카카오 위치기반서비스 이용약관 변경 안내 1</span>
                        <span class="pull-right">2017-10-16
                        <i class="fa fa-chevron-down pl20"></i>
                    </span>
                    </a>
                </div>
                <div class="notice-box-information" id="box_notice_1" style="display: none;">
                    <p>카카오 위치기반서비스 이용약관 변경 안내<br />
                        안녕하세요. 카카오 입니다.<br />
                        카카오의 위치기반서비스 이용약관 변경에 대한 안내 말씀 드립니다.</p>


                    <p>1. 변경 사항<br />
                        신규 위치기반서비스 추가: 카카오톡 주문하기<br /><br />

                        2. 변경 시기<br />
                        변경된 위치기반서비스 이용약관은 2017년 03월 21일자로 효력이 발생됩니다.<br /><br />
                        3. 문의 및 동의 철회<br />
                        변경된 위치기반서비스 이용약관 내용에 동의하지 않으시는 경우, 각 서비스 내에서 “탈퇴”를 신청하여 회원 탈퇴를 하실 수 있습니다.<br />
                        위치기반서비스 이용약관 내용에 대한 문의는 개인정보보호 담당부서(고객센터, 1577-3754)로 접수해 주시면, 친절히 안내해 드리겠습니다.<br />
                        카카오는 이용자 여러분의 위치정보 및 개인정보 보호를 최우선 하는 것을 약속드리며, 신뢰받는 서비스로 보답하겠습니다.<br />

                        감사합니다.
                    </p>
                </div>
                <!-- #End Notice box -->

                <!-- Notice box -->
                <div class="notice-box">
                    <a href="javascript:void(0);" id="notice_2" class="clearfix">
                        <span class="pull-left">카카오 위치기반서비스 이용약관 변경 안내 2</span>
                        <span class="pull-right">2017-10-16
                        <i class="fa fa-chevron-down pl20"></i>
                    </span>
                    </a>
                </div>
                <div class="notice-box-information" id="box_notice_2" style="display: none;">
                    <p>카카오 위치기반서비스 이용약관 변경 안내<br />
                        안녕하세요. 카카오 입니다.<br />
                        카카오의 위치기반서비스 이용약관 변경에 대한 안내 말씀 드립니다.</p>


                    <p>1. 변경 사항<br />
                        신규 위치기반서비스 추가: 카카오톡 주문하기<br /><br />

                        2. 변경 시기<br />
                        변경된 위치기반서비스 이용약관은 2017년 03월 21일자로 효력이 발생됩니다.<br /><br />
                        3. 문의 및 동의 철회<br />
                        변경된 위치기반서비스 이용약관 내용에 동의하지 않으시는 경우, 각 서비스 내에서 “탈퇴”를 신청하여 회원 탈퇴를 하실 수 있습니다.<br />
                        위치기반서비스 이용약관 내용에 대한 문의는 개인정보보호 담당부서(고객센터, 1577-3754)로 접수해 주시면, 친절히 안내해 드리겠습니다.<br />
                        카카오는 이용자 여러분의 위치정보 및 개인정보 보호를 최우선 하는 것을 약속드리며, 신뢰받는 서비스로 보답하겠습니다.<br />

                        감사합니다.
                    </p>
                </div>
                <!-- #End Notice box -->

                <!-- Notice box -->
                <div class="notice-box">
                    <a href="javascript:void(0);" id="notice_3" class="clearfix">
                        <span class="pull-left">카카오 위치기반서비스 이용약관 변경 안내 3</span>
                        <span class="pull-right">2017-10-16
                        <i class="fa fa-chevron-down pl20"></i>
                    </span>
                    </a>
                </div>
                <div class="notice-box-information" id="box_notice_3" style="display: none;">
                    <p>카카오 위치기반서비스 이용약관 변경 안내<br />
                        안녕하세요. 카카오 입니다.<br />
                        카카오의 위치기반서비스 이용약관 변경에 대한 안내 말씀 드립니다.</p>


                    <p>1. 변경 사항<br />
                        신규 위치기반서비스 추가: 카카오톡 주문하기<br /><br />

                        2. 변경 시기<br />
                        변경된 위치기반서비스 이용약관은 2017년 03월 21일자로 효력이 발생됩니다.<br /><br />
                        3. 문의 및 동의 철회<br />
                        변경된 위치기반서비스 이용약관 내용에 동의하지 않으시는 경우, 각 서비스 내에서 “탈퇴”를 신청하여 회원 탈퇴를 하실 수 있습니다.<br />
                        위치기반서비스 이용약관 내용에 대한 문의는 개인정보보호 담당부서(고객센터, 1577-3754)로 접수해 주시면, 친절히 안내해 드리겠습니다.<br />
                        카카오는 이용자 여러분의 위치정보 및 개인정보 보호를 최우선 하는 것을 약속드리며, 신뢰받는 서비스로 보답하겠습니다.<br />

                        감사합니다.
                    </p>
                </div>
                <!-- #End Notice box -->

            </div>
        </div>
    </div>
</section>
<!-- #End Content -->

<%@ include file="siteFooter.jsp" %>

<%@ include file="siteAuthorizationModal.jsp" %>

<%@ include file="siteFooterJavaScript.jsp" %>

</body>
</html>