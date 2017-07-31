<%@ page import="java.util.List" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Collections" %>
<%@ page import="com.SoftwareFactoryAdmin.model.*" %>
<%@ page import="java.util.Set" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.SoftwareFactoryAdmin.comparator.TossTaskMessagesByDateComparator" %>
<%@ page import="com.SoftwareFactoryAdmin.constant.StatusEnum" %>
<%@ page import="com.sun.xml.internal.ws.api.message.Packet" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page language="java" pageEncoding="UTF-8" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page session="false" %>

<!DOCTYPE html>
<html lang="kr">
<head>
    <meta charset="utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta name="viewport"
          content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1, user-scalable=no, minimal-ui"/>
    <meta name="format-detection" content="telephone=no"/>
    <meta name="format-detection" content="address=no"/>

    <meta name="description" content=""/>
    <meta name="keywords" content=""/>

    <title>Toss conversation :: 소프트웨어팩토리</title>

    <%@ include file="styles.jsp" %>

</head>
<body>
<!-- Wrapper -->
<div id="wrapper">

    <%TossTask tossTask  = (TossTask) request.getAttribute("tossTask");%>
    <%SimpleDateFormat dateFormatShow = new SimpleDateFormat("yyyy-MM-dd HH:mm");%>
    <%Set<TossTaskMessage> tossTaskMessages = tossTask.getTossTaskMessages();%>
    <%List <TossTaskMessage> taskMessages = new ArrayList<>(tossTaskMessages);%>
    <%taskMessages.sort(new TossTaskMessagesByDateComparator());%>
    <%List <ManagerInfo> managerInfos = new ArrayList<>(tossTask.getManagerInfoEngaged());%>

    <%@ include file="leftCategoriesMenu.jsp" %>

    <!-- Page Content -->
    <section id="page-content-wrapper">

        <!-- Header -->
        <header class="header line">
            <a href="javascript:void(0);" class="btn btn-toggle" id="menu-toggle"><i class="fa fa-bars" aria-hidden="true"></i></a>
            <span class="header-title clearfix"><%out.print(tossTask.getTitle());%></span>
        </header>
        <!-- #End Header -->

        <!-- Content section -->
        <section class="container-fluid content">

            <div class="mb20">
                <a href="/toss/" class="btn btn-primary"><i class="fa fa-users pr10"></i>Back to toss list</a>
            </div>

            <div class="row">

                <div class="col-md-5">
                    <h4 class="mb10">Toss Information : </h4>
                    <section class="estimate-user-info">
                        <div class="name">Manager opened : <%out.print(tossTask.getManagerInfoOpened().getName());%></div>
                        <div class="persons">Persons :
                            <%
                                for (int i = 0; i < managerInfos.size(); i++){
                                    out.print(managerInfos.get(i).getName());
                                    if(i != managerInfos.size()-1) out.print(" , ");
                                }
                            %>
                        </div>
                        <%
                            String endDate = "Now!";
                            if (!tossTask.isNow()) endDate = dateFormatShow.format(tossTask.getEndDate());
                        %>
                        <div class="end_date">END DATE : <%out.print(endDate);%></div>
                    </section>

                    <br>


                    <form action="/toss/answer-message" method="post">

                        <input type="hidden" name="id" value="<%out.print(tossTask.getId());%>">

                        <div class="form-group">
                            <label class="control-label">Status </label>
                            <select name="status" class="form-control" id="status">
                                <option value="PROCESSING"> Processing </option>
                                <option value="PAUSE"> Pause </option>
                                <option value="FINISH"> Finish </option>
                            </select>
                        </div>

                        <div class="form-group">

                            <label class="control-label">Answer </label>
                            <textarea id="editor" name="answer" rows="3"  ></textarea>

                        </div>


                        <div class="form-group text-right">
                            <button type="submit" name="save" class="btn btn-primary"><i class="fa fa-check pr10"></i>
                                Send Toss Answer
                            </button>
                        </div>
                    </form>
                </div>

                <div class="col-md-7">
                    <section class="cases-messages-section">
                        <br>


                        <%

                            for (TossTaskMessage tossTaskMessage : taskMessages) {

                                String status = "message-right-grey";  //status FINISH

                                if(tossTaskMessage.getStatus().equals(StatusEnum.PROCESSING.toString())){
                                    status = "message-right-green";
                                } else if (tossTaskMessage.getStatus().equals(StatusEnum.PAUSE.toString())) {
                                    status = "message-right-orange";
                                }
                        %>

                        <div class="message-right <%out.print(status);%>">

                            <div class="clearfix message-header">
                                <div class="title"><%out.print(tossTaskMessage.getManagerInfo().getName() + " ID - " + tossTaskMessage.getManagerInfo().getId());%></div>
                                <div class="date"><%out.print(dateFormatShow.format(tossTaskMessage.getDate()));%></div>
                            </div>

                            <% out.print(tossTaskMessage.getText());%>

                        </div>

                        <%}%>

                        <%--Toss task message--%>

                        <div class="message-right message-right-red">

                            <div class="clearfix message-header">
                                <div class="title"><%out.print(tossTask.getManagerInfoOpened().getName() + " ID - " + tossTask.getManagerInfoOpened().getId());%></div>
                                <div class="date"><%out.print(dateFormatShow.format(tossTask.getDate()));%></div>
                            </div>

                            <% out.print(tossTask.getText());%>

                        </div>


                    </section>
                </div>
            </div>
        </section>
        <!-- #End Page-content -->

</div>
<!-- #End Wrapper -->

<%@ include file="javascript.jsp" %>

<%
    String isNewTask = request.getParameter("isNewAnswer");
    if (isNewTask != null) {
        String link = "/toss/toss-conversation/" + tossTask.getId();
%>
<script>
    jQuery(document).ready(function ($) {
        swal(
            'Success!',
            'New Answer',
            'success'
        );
        history.pushState(null, null, '<%out.print(link);%>');
    });
</script>
<%}%>


</body>
</html>
