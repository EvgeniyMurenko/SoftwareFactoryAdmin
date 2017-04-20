<%@ page import="com.SoftwareFactoryAdmin.model.MessageTask" %>
<%@ page import="java.util.List" %>
<%@ page import="com.SoftwareFactoryAdmin.model.StaffInfo" %>
<%@ page import="java.text.SimpleDateFormat" %>
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

    <title>Staff Tasks List :: 소프트웨어팩토리</title>

    <%@ include file="headerStyles.jsp" %>

</head>
<body>
<!-- Wrapper -->
<div id="wrapper">

    <!-- Sidebar -->
    <div id="sidebar-wrapper">

        <%@ include file="leftCategoriesMenu.jsp" %>

    </div>
    <!-- #End Sidebar -->

    <!-- Page Content -->
    <div id="page-content-wrapper">

        <%@ include file="topLine.jsp" %>

        <%StaffInfo staffInfo = (StaffInfo) request.getAttribute("staffInfo");%>
        <%List<MessageTask> messageTaskList = (List<MessageTask>) request.getAttribute("messageTaskList");%>
        <%SimpleDateFormat dateFormatShow = new SimpleDateFormat("yyyy-MM-dd HH:mm");%>

        <!-- Content section -->
        <section class="container-fluid content">
            <h3><i class="fa fa-tasks"></i>
                <%out.print(staffInfo.getName()+" :: Task list");%>
            </h3>

            <div class="mb20">
                <a href="<c:out value="/staff/"/>" class="btn btn-primary"><i class="fa fa-times-circle pr10"></i>Cancel add
                    Task</a>
            </div>

            <div class="row">
                <div class="col-md-8">
                    <section class="clearfix mb20">
                        <%int count = 1;
                        for (MessageTask messageTask : messageTaskList){%>
                            <!-- Tasks box -->
                            <div class="tasks-box">
                                <a href="javascript:void(0);" id="<%out.print("notice_"+count);%>" class="clearfix">
                                    <span class="pull-left"><%out.print(messageTask.getTitle());%></span>
                                    <span class="pull-right"><%out.print(dateFormatShow.format(messageTask.getDate()));%><i class="fa fa-chevron-down pl20"></i></span>
                                </a>
                            </div>
                            <div class="tasks-box-information" id="<%out.print("box_notice_"+count);%>" style="display: none;">
                                <%out.print(messageTask.getMessageText());%>
                            </div>
                            <!-- #End Tasks box -->
                        <%count++;}%>
                    </section>

                    <div class="border-bottom mb20"></div>
                    <%String formAction = "/staff/addTaskToStaff/"+staffInfo.getUser();%>
                    <form action="<%out.print(formAction);%>?${_csrf.parameterName}=${_csrf.token}" method="post">

                        <h4 class="mb10">Task text</h4>

                        <div class="form-group">
                            <label class="control-label">Title</label>
                            <input permission="text" name="title" class="form-control" placeholder="Title" />
                        </div>

                        <div class="form-group">
                            <textarea name="task" class="form-control" placeholder="Text task" rows="3"></textarea>
                        </div>

                        <div class="form-group text-right mt20">
                            <button permission="submit" class="btn btn-primary"><i class="fa fa-paper-plane-o pr10"></i>Send
                                task
                            </button>
                        </div>

                    </form>

                </div>

            </div>


        </section>
        <!-- Content section -->

    </div>
    <!-- #End Page-content -->

</div>
<!-- #End Wrapper -->

<%@ include file="footerJavaScript.jsp" %>

</body>
</html>