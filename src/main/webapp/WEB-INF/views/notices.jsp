<%@ page import="com.SoftwareFactory.model.Notice" %>
<%@ page import="java.util.List" %>
<%@ page import="java.text.SimpleDateFormat" %>
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

<% List<Notice> noticeList =  (List<Notice>)request.getAttribute("noticeList");%>
<%SimpleDateFormat dateFormatShow = new SimpleDateFormat("yyyy-MM-dd HH:mm");%>

<!-- Content -->
<section class="container content mb40">
    <div class="row pt40">
        <div class="col-md-8">

            <div>

                <h3>공지 사항</h3>

                <%int count = 1;
                for (Notice notice : noticeList){%>

                    <!-- Notice box -->
                    <div class="notice-box">
                        <a href="javascript:void(0);" id="<%out.print("notice_"+count);%>" class="clearfix">
                            <span class="pull-left"><%out.print(notice.getTitle());%></span>
                            <span class="pull-right"><%out.print(dateFormatShow.format(notice.getDataCreate()));%>
                            <i class="fa fa-chevron-down pl20"></i>
                        </span>
                        </a>
                    </div>
                    <div class="notice-box-information" id="<%out.print("box_notice_"+count);%>" style="display: none;">
                        <%out.print(notice.getNoticeText());%>
                    </div>
                    <!-- #End Notice box -->
                <%  count++;
                }%>

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