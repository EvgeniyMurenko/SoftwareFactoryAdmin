<%@ page import="com.SoftwareFactoryAdmin.model.Case" %>
<%@ page import="com.SoftwareFactoryAdmin.model.ManagerInfo" %>
<%@ page import="com.SoftwareFactoryAdmin.constant.ProjectEnum" %>
<%@ page import="com.SoftwareFactoryAdmin.model.Message" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.SoftwareFactoryAdmin.comparator.MessageByDateComparator" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="com.SoftwareFactoryAdmin.constant.StatusEnum" %>
<%@ page import="com.SoftwareFactoryAdmin.model.MessageLink" %>
<%@ page import="java.util.Set" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page session="false" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1, user-scalable=no, minimal-ui" />
    <meta name="format-detection" content="telephone=no" />
    <meta name="format-detection" content="address=no" />

    <meta name="description" content="" />
    <meta name="keywords" content="" />

    <title>Case: 유지보수 :: 소프트웨어팩토리</title>

    <%@ include file="styles.jsp" %>
</head>
<body>

<!-- Wrapper -->
<div id="wrapper">

    <%Case aCase = (Case) request.getAttribute("case");%>
    <%SimpleDateFormat dateFormatShow = new SimpleDateFormat("yyyy-MM-dd HH:mm");%>

    <%@ include file="leftCategoriesMenu.jsp" %>

    <!-- Page Content -->
    <div id="page-content-wrapper">

        <!-- Header -->
        <header class="header line">
            <a href="javascript:void(0);" class="btn btn-toggle" id="menu-toggle"><i class="fa fa-bars" aria-hidden="true"></i></a>
            <span class="header-title clearfix">Case: <%out.print(aCase.getProjectTitle());%></span>
        </header>
        <!-- #End Header -->

        <section class="content container-fluid">

            <div class="mb20">
                <a href="/cases/" class="btn btn-default"><i class="fa fa-times-circle pr5"></i> Cancel & Back</a>
            </div>

            <div class="background-01">

                <table class="table table-inside" width="100%" cellspacing="0">
                    <thead>
                    <tr>
                        <th>ID</th>
                        <th>Case issue</th>
                        <th>Customer name</th>
                        <th>Project</th>
                        <th>Date</th>
                        <th>Status</th>
                        <th>Appointment time</th>
                        <th>Messages</th>
                    </tr>
                    </thead>

                    <tbody>
                    <tr>
                        <td align="center"><%out.print(aCase.getId());%></td>
                        <td><%out.print(aCase.getProjectTitle());%></td>
                        <td align="center"><%out.print(aCase.getProject().getCustomerInfo().getName());%></td>
                        <td align="center">
                            <a href="<%out.print("/project-mm/view-project/"+aCase.getProject().getId()+"/");%>">
                                <% if (aCase.getProject().getProjectName().equals(ProjectEnum.projectNameNormal.getDbValue())) {
                                    out.print(ProjectEnum.projectNameNormal.getValue());
                                }else if (aCase.getProject().getProjectName().equals(ProjectEnum.projectNameEstimate.getDbValue())) {
                                    out.print(ProjectEnum.projectNameEstimate.getValue());
                                } else out.print(aCase.getProject().getProjectName()); %>
                            </a>
                        </td>
                        <td align="center"><%out.print(dateFormatShow.format(aCase.getCreationDate()));%></td>
                        <td align="center"><%out.print(aCase.getStatus());%></td>
                        <td align="center"><time class="timeago" datetime="<%out.print(aCase.getMessages().iterator().next().getMessageTime()); %>"></time></td>
                        <td align="center"><%out.print(aCase.getMessages().size());%></td>
                    </tr>
                    </tbody>

                </table>

                <span class="content-title mt30">Case messages</span>

                <div class="mb20">

                    <%ArrayList<Message> messages = new ArrayList<Message>(aCase.getMessages());%>
                    <%messages.sort(new MessageByDateComparator());%>

                    <%for (Message message : messages){
                        Long userId =  new Long(message.getUser().getId());
                        if(aCase.getProject().getCustomerInfo().getId().equals(userId)) {%>

                            <div class="message-left">

                                <div class="clearfix message-header">
                                    <div class="title"><%out.print(aCase.getProject().getCustomerInfo().getName());%></div>
                                    <div class="date"><% out.print(dateFormatShow.format(message.getMessageTime())); %></div>
                                </div>

                                <!-- Text message-->
                                <%out.print(message.getMessageText());%>
                                <!-- Text message-->

                                <%Set<MessageLink> messageLinks = message.getMessageLinks();
                                    if (!messageLinks.isEmpty()) {
                                        for (MessageLink messageLink : messageLinks){
                                            out.print("<a href="+ messageLink.getFileLink() +" target='_blank'>"+messageLink.getFileName()+"</a><br>");
                                        }
                                    }
                                %>

                            </div>

                        <%}else {%>

                            <div class="message-right">

                                <div class="clearfix message-header">
                                    <div class="title">Software Factory Team</div>
                                    <div class="date"><% out.print(dateFormatShow.format(message.getMessageTime())); %></div>
                                </div>

                                <!-- Text message-->
                                <%out.print(message.getMessageText());%>
                                <!-- Text message-->

                                <%Set<MessageLink> messageLinks = message.getMessageLinks();
                                    if (!messageLinks.isEmpty()) {
                                        for (MessageLink messageLink : messageLinks){
                                            out.print("<a href="+ messageLink.getFileLink() +" target='_blank'>"+messageLink.getFileName()+"</a><br>");
                                        }
                                    }
                                %>
                            </div>
                        <%}%>
                    <%}%>

                </div>

                <%if (!aCase.getStatus().equals(StatusEnum.CLOSE.toString())){%>
                    <span class="content-title mt30">Case answer</span>

                    <form action="/cases/<% out.print(Long.toString(aCase.getId())); %>/print_answer?${_csrf.parameterName}=${_csrf.token}" method="post" enctype="multipart/form-data">
                        <div class="row">
                            <div class="col-md-3">

                                <!-- Appointment time -->
                                <h4 class="mb10">Appointment time</h4>
                                <div class="form-group">
                                    <div class="input-group date" id="datetimepicker">
                                        <span class="input-group-addon">
                                            <span class="glyphicon glyphicon-calendar"></span>
                                        </span>
                                        <input type="text" name="appointmentTime" class="form-control" />
                                    </div>
                                </div>
                                <!-- #End Appointment time -->

                                <!-- Attach files -->
                                <h4 class="mb10">Attach files</h4>
                                <div class="form-group">
                                    <input id="chatUpload" name="file[]" multiple type="file">
                                </div>
                                <!-- #End Attach files -->

                            </div>
                            <div class="col-md-9">
                                <h4>Message</h4>

                                <textarea class="form-control" name="message" id="editor"></textarea>
                                <input type="hidden" name="estimateId" value="">

                                <div class="form-group text-right mt30 mb0">
                                    <button type="submit" class="btn btn-primary"><i class="fa fa-paper-plane-o pr10"></i>Send message</button>
                                    <a href="/cases/" class="btn btn-default"><i class="fa fa-chevron-left pr5"></i>Back</a>
                                </div>

                            </div>
                        </div>
                    </form>
                <%}%>
            </div>

        </section>

    </div>
    <!-- #End Page Content -->

</div>

<%@ include file="javascript.jsp" %>

</body>
</html>