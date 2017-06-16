<%@ page import="java.util.List" %>
<%@ page import="com.SoftwareFactoryAdmin.constant.ProjectEnum" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="com.SoftwareFactoryAdmin.model.*" %>
<%@ page import="java.util.Set" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.SoftwareFactoryAdmin.comparator.TaskMessageByDateComparator" %>
<%@ page import="java.util.Collections" %>
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

    <title>Task Message :: 소프트웨어팩토리</title>

    <%@ include file="styles.jsp" %>

</head>
<body>

<!-- Wrapper -->
<div id="wrapper">

    <%@ include file="leftCategoriesMenu.jsp" %>

    <!-- Page Content -->
    <div id="page-content-wrapper">

        <!-- Header -->
        <header class="header line">
            <a href="javascript:void(0);" class="btn btn-toggle" id="menu-toggle"><i class="fa fa-bars"
                                                                                     aria-hidden="true"></i></a>
            <span class="header-title clearfix">Task Message</span>
        </header>
        <!-- #End Header -->

        <%ProjectTask projectTask = (ProjectTask) request.getAttribute("projectTask");%>

        <section class="content container-fluid">

            <div class="mb10">
                <a href="<%out.print("/project-wf/reopen-task/" + projectTask.getId());%>" class="btn btn-primary"><i class="fa fa-folder-open" aria-hidden="true"></i> Reopen task</a>
                <a href="<%out.print("/project-wf/done-task/" + projectTask.getId());%>" class="btn btn-primary"><i class="fa fa-check-square-o" aria-hidden="true"></i> Done task</a>
            </div>


            <div class="col-sm-7 mt10" style="padding-left: 0px; !important;">
                <div class="background-01">
                    <div class="scrollable">

                        <%

                            ArrayList<TaskMessage> taskMessages = new ArrayList<>(projectTask.getTaskMessages());
                            Collections.sort(taskMessages , new TaskMessageByDateComparator());

                            SimpleDateFormat dateFormatShow = new SimpleDateFormat("yyyy-MM-dd HH:mm");

                        %>

                        <%for (TaskMessage taskMessage : taskMessages) {%>

                        <% Set<UserProfile> userProfiles = taskMessage.getUser().getUserProfiles();
                            UserProfile userProfile = userProfiles.iterator().next();

                            List<TaskMessageLink> taskMessageLinks = taskMessage.getTaskMessageLinks();

                            String messageType = "message-right";
                            if (userProfile.getType().equals("STAFF")) messageType = "message-left";
                        %>
                            <div class="<%out.print(messageType);%>">
                                <div class="clearfix message-header">
                                    <div class="title"><%out.print(taskMessage.getSenderName());%></div>
                                    <div class="date"><%out.print(dateFormatShow.format(taskMessage.getDate()));%></div>
                                </div>
                                <p><%out.print(taskMessage.getMessageText());%></p>

                                <%for (TaskMessageLink taskMessageLink : taskMessageLinks) {%>
                                    <p><a href="<%taskMessageLink.getFileLink();%>"><%taskMessageLink.getFileName();%></a></p>
                                <%}%>
                            </div>

                        <%}%>

                    </div>
                </div>
            </div>

            <div class="col-sm-5 mt10" style="padding-left: 0px; !important;">

                <form class="form-horizontal" action="/project-wf/write-task-message" method="post" enctype="multipart/form-data">
                    <div class="background-01">
                        <h4>Write message</h4>

                        <input type="hidden" name="id" value="<%out.print(projectTask.getId());%>">
                        <!-- FULL TASK DESCRIPTION -->
                        <div class="form-group">
                            <div class="col-sm-12">
                                <textarea id="editor" name="text" rows="3" required></textarea>
                            </div>
                        </div>
                        <!-- #End FULL TASK DESCRIPTION -->

                        <div class="form-group">
                            <!-- Attach files -->
                            <label class="col-sm-3 control-label">Attach File</label>
                            <div class="col-sm-9">
                                <input id="uploadFile" name="file[]" multiple type="file">
                            </div>
                            <!-- #End Attach files -->
                        </div>

                        <div class="form-group">
                            <div class="col-sm-12" align="right">
                                <button type="submit" name="save" class="btn btn-primary right"><i
                                        class="fa fa-envelope-o" aria-hidden="true"></i> Send
                                </button>
                            </div>
                        </div>

                    </div>
                </form>

            </div>

        </section>


    </div>
    <!-- #End Page Content -->

</div>

<%@ include file="javascript.jsp" %>

</body>
</html>