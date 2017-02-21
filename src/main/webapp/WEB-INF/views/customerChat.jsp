<%@ page import="com.SoftwareFactory.model.CustomerInfo" %>
<%@ page import="com.SoftwareFactory.model.Message" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="com.SoftwareFactory.model.Project" %>
<%@ page import="java.util.List" %>
<%@ page import="com.SoftwareFactory.constant.StatusEnum" %>
<%@ page import="java.io.File" %>
<%@ page import="com.SoftwareFactory.constant.GlobalEnum" %><%--<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>--%>
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

    <meta property="og:site_name" content="software factory" />
    <meta property="og:title" content="소팩소개" />
    <meta property="og:image" content="/resources/newIndexPage/images/web-logo.jpg" />
    <meta property="og:url" content="http://www.sofac.kr/" />
    <meta property="og:description" content="" />

    <meta name="description" content="" />
    <meta name="keywords" content="" />

    <title>소팩소개 :: Software Factory</title>

    <link href="/resources/newIndexPage/css/bootstrap.min.css" rel="stylesheet" />
    <link href="/resources/newIndexPage/css/bootstrap-select.min.css" rel="stylesheet" />
    <link href="/resources/newIndexPage/css/jquery.fancybox.min.css" rel="stylesheet" />
    <link href="/resources/newIndexPage/css/jquery.sweet-alert.min.css" rel="stylesheet" />
    <link href="/resources/newIndexPage/css/font-awesome.min.css" rel="stylesheet" />
    <link href="/resources/newIndexPage/css/awesome-bootstrap-checkbox.min.css" rel="stylesheet" />
    <link href="/resources/newIndexPage/css/fileinput.min.css" rel="stylesheet" />
    <link href="/resources/newIndexPage/css/style.css" rel="stylesheet" />
    <link href="/resources/newIndexPage/css/responsive.css" rel="stylesheet" />

    <link rel="apple-touch-icon" sizes="57x57" href="/resources/newIndexPage/images/apple-icon-57x57.png" />
    <link rel="apple-touch-icon" sizes="60x60" href="/resources/newIndexPage/images/apple-icon-60x60.png" />
    <link rel="apple-touch-icon" sizes="72x72" href="/resources/newIndexPage/images/apple-icon-72x72.png" />
    <link rel="apple-touch-icon" sizes="76x76" href="/resources/newIndexPage/images/apple-icon-76x76.png" />
    <link rel="apple-touch-icon" sizes="114x114" href="/resources/newIndexPage/images/apple-icon-114x114.png" />
    <link rel="apple-touch-icon" sizes="120x120" href="/resources/newIndexPage/images/apple-icon-120x120.png" />
    <link rel="apple-touch-icon" sizes="144x144" href="/resources/newIndexPage/images/apple-icon-144x144.png" />
    <link rel="apple-touch-icon" sizes="152x152" href="/resources/newIndexPage/images/apple-icon-152x152.png" />
    <link rel="apple-touch-icon" sizes="180x180" href="/resources/newIndexPage/images/apple-icon-180x180.png" />
    <link rel="icon" type="image/png" sizes="192x192"  href="/resources/newIndexPage/images/android-icon-192x192.png" />
    <link rel="icon" type="image/png" sizes="32x32" href="/resources/newIndexPage/images/favicon-32x32.png" />
    <link rel="icon" type="image/png" sizes="96x96" href="/resources/newIndexPage/images/favicon-96x96.png" />
    <link rel="icon" type="image/png" sizes="16x16" href="/resources/newIndexPage/images/favicon-16x16.png" />
    <link rel="manifest" href="/resources/newIndexPage/images/manifest.json" />
    <meta name="msapplication-TileColor" content="#ffffff" />
    <meta name="msapplication-TileImage" content="/resources/newIndexPage/images/ms-icon-144x144.png" />
    <meta name="theme-color" content="#ffffff" />

    <!--[if lt IE 9]>
    <script src="/resources/newIndexPage/js/html5shiv.js"></script>
    <script src="/resources/newIndexPage/js/respond.min.js"></script>
    <![endif]-->
</head>
<body>
<!-- Header -->
<header class="container header">
    <div class="row">
        <div class="col-lg-6 col-md-6 col-sm-6 logo">
            <a href="<c:url value="/cabinet/"/>">소프트웨어<span>팩토리</span></a>
            <div class="small-logo">SoFAC : <i>Software Factory</i></div>
        </div>
        <div class="col-lg-6 col-md-6 col-sm-6 text-right login">
            <ul class="nav navbar-nav navbar-right">
                <li class="dropdown">
                    <span class="avatar-welcome"><%out.print((String)request.getAttribute("customerName"));%> 님 접속을 환영합니다.</span>
                    <a href="javascript:void(0);" class="dropdown-toggle avatar" data-toggle="dropdown"><i class="fa fa-user"></i></a>
                    <ul class="dropdown-menu">
                        <li class="dropdown-menu-header text-center">설정</li>
                        <li><a href="javascript:void(0);"><i class="fa fa-user"></i> 윤곽</a></li>
                        <li><a href="<c:url value="/logout" />"><i class="fa fa-lock"></i> 로그 아웃</a></li>
                    </ul>
                </li>
            </ul>
        </div>
    </div>
</header>
<div class="header-line"></div>
<!-- #End Header -->

<section class="container mb20">
    <div class="row">
        <div class="col-md-3">

            <!-- Projects -->
            <h3 class="mt0">프로젝트</h3>
            <ul class="projects-list">
                <%
                    String currentProjectId= (String) request.getAttribute("projectId");
                    List<Project> projectSet =  (List<Project>)request.getAttribute("projects");
                    Project generalDiscussionProject = projectSet.get(projectSet.size()-1);
                    for(Project project : projectSet){
                        if (!project.getProjectName().equals("#$GENERAL")){
                %>
                <%  String projectId= Long.toString(project.getId()); %>
                <li><a href="/cabinet/project/<%out.print(projectId); %>" <%if (projectId.equals(currentProjectId)) out.print("class=\"active\"");%>     ><i class="fa fa-angle-double-right"></i> <% out.println(project.getProjectName()); %></a></li>

                <%}
                }%>

            </ul>
            <!-- #End Projects -->

            <!-- Discussion room -->
            <h3 class="mt20">일반 토론</h3>
            <ul class="projects-list">
                <li><a href="/cabinet/project/<%out.print(generalDiscussionProject.getId()); %>"  <%if (Long.toString(generalDiscussionProject.getId()).equals(currentProjectId)) out.print("class=\"active\"");%>><i class="fa fa-angle-double-right"></i>Discussion room</a></li>
            </ul>
            <!-- #End Discussion room -->

        </div>
        <div class="col-md-9">
            <% Long caseId =  (Long) request.getAttribute("caseId"); %>
            <% String caseStatus = (String) request.getAttribute("caseStatus"); %>
            <%if (!caseStatus.equals(StatusEnum.CLOSE.toString())){%>
            <!-- Close button -->
            <form action="/cabinet/case/<% out.print(Long.toString(caseId)); %>/close_case?${_csrf.parameterName}=${_csrf.token}" method="POST" >
                <div class="text-right">
                    <%--<button type="submit" class="btn btn-primary btn-mobile">--%>
                    <button class="btn btn-primary btn-mobile" type="button" data-toggle="modal" data-target="#myModal">
                        <i class="fa fa-close"></i>Close case
                    </button>
                </div>
                <%--Modal window--%>
                <div id="myModal" class="modal fade">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-header"><button class="close" type="button" data-dismiss="modal">×</button>
                                <h4 class="modal-title">ATTENTION</h4>
                            </div>
                            <div class="modal-body">Are you sure to close?</div>
                            <div class="modal-footer">
                                <button type="submit" class="btn btn-primary btn-mobile">YES</button>
                                <button class="btn btn-default" type="button" data-dismiss="modal">NO</button>
                            </div>
                        </div>
                    </div>
                </div>
            </form>
            <!-- #End Close button -->
            <%}%>
            <!-- Chat messages -->
            <div class="chat-message">
                <ul class="chat">

                    <%
                        ArrayList<Message> messages =  (ArrayList<Message>)request.getAttribute("messagesSorted");
                        Iterator<Message> messageIterator = messages.iterator();
                        while (messageIterator.hasNext()) {
                            Message message = messageIterator.next();
                    %>

                    <% CustomerInfo customerInfo = message.getaCase().getProject().getCustomerInfo();%>
                    <li class="left clearfix">
                        <span><img src="http://bootdey.com/img/Content/user_3.jpg" alt="User Avatar"></span>
                        <div class="chat-body clearfix">
                            <div class="header">
                                <strong class="primary-font"><% out.print(customerInfo.getName());  %></strong>
                                <small class="text-muted padding-l-5"><i class="fa fa-clock-o"></i><time class="timeago" datetime="<%  out.print(message.getMessageTime()); %>"></time></small>
                            </div>
                            <p> <% out.print(message.getMessageText()); %>
                                <% if (message.getMessagePath()!=null) {
                                    File directory = new File(message.getMessagePath());
                                    File[] files= directory.listFiles();
                                    for (int i=0; i<files.length; i++){
                                        String fileName =files[i].getName();
                                        out.print("<br>" + "<a href="+ GlobalEnum.webRoot+"/download/"+message.getId()+"/"+fileName+"/"+">"+fileName+"</a>");
                                    }
                                } %>


                            </p>
                        </div>
                    </li>

                    <% } %>
                    <%--<li class="right clearfix">
                        <span><img src="http://bootdey.com/img/Content/user_1.jpg" alt="User Avatar"></span>
                        <div class="chat-body clearfix">
                            <div class="header text-right">
                                <strong class="primary-font">Sarah</strong>
                                <small class="text-muted padding-l-5"><i class="fa fa-clock-o"></i> 13 mins ago</small>
                            </div>
                            <p class="text-right">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Curabitur bibendum ornare dolor, quis ullamcorper ligula sodales at.</p>
                        </div>
                    </li>--%>



                </ul>
                <%if (!caseStatus.equals(StatusEnum.CLOSE.toString())){%>
                    <form action="/cabinet/case/<% out.print(Long.toString(caseId)); %>/print_message?${_csrf.parameterName}=${_csrf.token}" method="POST" enctype="multipart/form-data">
                        <div class="clearfix chat-message-section">
                            <div class="form-group">
                                <textarea class="form-control" type="text" name="message" rows="7" id="message" placeholder="Message"></textarea>
                            </div>
                            <div class="mt20">
                                <div class="row">
                                    <div class="col-md-6"><input id="chat-upload" name="file[]" multiple type="file"></div>
                                    <div class="col-md-6 text-right"><button class="btn btn-primary btn-mobile" type="submit" name="send">Send message</button></div>
                                </div>
                            </div>
                        </div>
                    </form>
                <%}%>
                </div>

            <!-- #End Chat messages -->

        </div>
    </div>
</section>



<!-- Footer -->
<footer class="container footer mb20">
    <div class="mt20 text-center">Copyright &copy; 2017. All rights reserved.</div>
</footer>
<!-- #End Footer -->


<script src="/resources/newIndexPage/js/jquery.min.js"></script>
<script src="/resources/newIndexPage/js/jquery-ui.min.js"></script>
<script src="/resources/newIndexPage/js/jquery.mousewheel.min.js"></script>
<script src="/resources/newIndexPage/js/jquery.fancybox.min.js"></script>
<script src="/resources/newIndexPage/js/jquery.sweet-alert.min.js"></script>
<script src="/resources/newIndexPage/js/jquery.timeago.js"></script>
<script src="/resources/newIndexPage/js/jquery.timeago.ko.js"></script>
<script src="/resources/newIndexPage/js/bootstrap.min.js"></script>
<script src="/resources/newIndexPage/js/bootstrap-form-helpers.min.js"></script>
<script src="/resources/newIndexPage/js/bootstrap-select.min.js"></script>
<script src="/resources/newIndexPage/js/bootstrap.validator.min.js"></script>
<script src="/resources/newIndexPage/js/fileinput.min.js"></script>
<script src="/resources/newIndexPage/js/sortable.min.js"></script>
<script src="/resources/newIndexPage/js/form-validation.min.js"></script>
<script src="/resources/newIndexPage/js/pagination.min.js"></script>
<script src="/resources/newIndexPage/js/main.js"></script>
</body>
</html>
