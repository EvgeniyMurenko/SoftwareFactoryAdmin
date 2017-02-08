<%@ page import="java.util.Locale" %>
<%@ page import="org.springframework.web.servlet.support.RequestContextUtils" %>
<%@ page import="com.SoftwareFactory.model.Message" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.SoftwareFactory.model.CustomerInfo" %><%--<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>--%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page session="false" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <title>Estimations list :: SoFAC CRM System</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta name="keywords" content=""/>

    <script type="application/x-javascript">
        addEventListener("load", function () {
            setTimeout(hideURLbar, 0);
        }, false);

        function hideURLbar() {
            window.scrollTo(0, 1);
        }
    </script>

    <link href='http://fonts.googleapis.com/css?family=Roboto:400,100,300,500,700,900' rel='stylesheet' type='text/css'>
    <link href="/resources/personalArea/css/bootstrap.min.css" rel='stylesheet' type='text/css'/>
    <link href="/resources/personalArea/css/languages.min.css" rel="stylesheet">
    <link href="/resources/personalArea/css/style.css" rel='stylesheet' type='text/css'/>
    <link href="/resources/personalArea/css/font-awesome.css" rel="stylesheet">
    <link href="/resources/personalArea/css/bootstrap-select.min.css" rel="stylesheet">
    <link href="/resources/personalArea/css/fileinput.min.css" rel="stylesheet">
    <link href="/resources/personalArea/css/custom.css" rel="stylesheet">
</head>
<body>
<div id="wrapper">
    <!-- Navigation -->
    <nav class="top1 navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="<c:url value='/cabinet/'/>">SoFAC CRM</a>
        </div>
        <!-- /.navbar-header -->
        <ul class="nav navbar-nav navbar-right">
            <li class="dropdown">
                <a href="javascript:void(0);" class="dropdown-toggle avatar" data-toggle="dropdown"><img
                        src="resources/personalArea/images/2.png" alt=""/></a>
                <ul class="dropdown-menu">
                    <li class="dropdown-menu-header text-center"><strong>Settings</strong></li>
                    <li class="m_2"><a href="javascript:void(0);"><i class="fa fa-user"></i> Profile</a></li>
                    <li class="m_2"><a href="javascript:void(0);"><i class="fa fa-wrench"></i> Settings</a></li>
                    <li class="m_2"><a href="javascript:void(0);"><i class="fa fa-lock"></i> Logout</a></li>
                </ul>
            </li>
        </ul>

        <form class="navbar-form navbar-right">
            <input type="text" class="form-control search-panel" value="" placeholder="Search...">
        </form>

        <div class="navbar-default sidebar" role="navigation">
            <div class="sidebar-nav navbar-collapse">
                <ul class="nav" id="side-menu">
                    <li><a href="../../../../../../../Desktop/sofac1/sofac%20—%20копия/control/index.html"><i class="fa fa-list fa-fw nav_icon"></i>Projects</a></li>
                    <li><a href="javascript:void(0);"><i class="fa fa-cogs fa-fw nav_icon"></i>Settings</a></li>
                </ul>
            </div>
        </div>
    </nav>
    <div id="page-wrapper">
        <div class="graphs">
            <div class="xs">
                <h3>Estimate Chat</h3>

                <div class="chat-message">
                    <ul class="chat">


                        <%
                            ArrayList<Message> messages =  (ArrayList<Message>)request.getAttribute("messagesSorted");
                            Iterator<Message> messageIterator = messages.iterator();
                            while (messageIterator.hasNext()) {
                                Message message = messageIterator.next();
                        %>


                        <li class="left clearfix">
                            <span><img src="http://bootdey.com/img/Content/user_3.jpg" alt="User Avatar"></span>
                            <div class="chat-body clearfix">
                                <div class="header">

                                    <% CustomerInfo customerInfo = message.getaCase().getProject().getCustomerInfo();%>
                                    <strong class="primary-font"> <% out.print(customerInfo.getFirstName() + " " + customerInfo.getLastName());    %></strong>
                                    <small class="text-muted padding-l-5"><i class="fa fa-clock-o"></i> 12 mins ago</small>
                                </div>
                                <p> <% out.print(message.getMessageText()); %></p>
                            </div>
                        </li>

                        <% } %>

                    </ul>

                    <% Long caseId =  (Long) request.getAttribute("caseId"); %>
                    <form action="/cabinet/case/<% out.print(Long.toString(caseId)); %>/print_message?${_csrf.parameterName}=${_csrf.token}" method="post" enctype="multipart/form-data">

                        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

                        <div class="clearfix chat-message-section">
                            <div><textarea id="editor" type="text" name="message" rows="3"></textarea></div>
                            <div class="margin-top">
                                <div class="row">
                                    <div class="col-md-6"><input id="chat-upload" name="file" multiple type="file"></div>
                                    <div class="col-md-6 text-right"><button class="btn btn-success"  type="submit" name="send">Send message</button></div>
                                </div>
                            </div>
                        </div>
                    </form>
                </div>



                <div class="clearfix"></div>
            </div>
            <div class="copy_layout">
                <p>Copyright &copy; 2016 SoFAC CRM. All Rights Reserved</p>
            </div>
        </div>
    </div>
    <!-- /#page-wrapper -->
</div>
<script src="/resources/personalArea/js/jquery.min.js"></script>
<script src="/resources/personalArea/js/bootstrap.min.js"></script>
<script src="/resources/personalArea/js/bootstrap-select.min.js"></script>
<script src="/resources/personalArea/js/fileinput.min.js"></script>
<script src="/resources/personalArea/js/metisMenu.min.js"></script>
<script src="/resources/personalArea/js/ckeditor/ckeditor.js"></script>
<script src="/resources/personalArea/js/custom.js"></script>
</body>
</html>
