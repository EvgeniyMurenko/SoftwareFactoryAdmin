<%@ page import="java.util.Locale" %>
<%@ page import="org.springframework.web.servlet.support.RequestContextUtils" %>
<%@ page import="com.SoftwareFactory.model.Project" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="com.SoftwareFactory.model.Case" %>
<%@ page import="com.SoftwareFactory.model.Message" %>
<%@ page import="com.SoftwareFactory.constant.MessageEnum" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.SoftwareFactory.constant.ProjectEnum" %><%--<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>--%>
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
                       <%-- <li><a href="javascript:void(0);"><i class="fa fa-user"></i> 윤곽</a></li>--%>
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
    <%--<div class="row">
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
                        /*    int countNewMessage = 0;
                            for(Case aCase : project.getCases()){
                                for(Message msg : aCase.getMessages()){
                                    if(msg.getIsRead().equals(MessageEnum.NOTREAD.toString())){

                                        //if(msg.getUser().getId().equals()) =====> must check current user
                                        countNewMessage++;
                                    }
                                }
                            }*/
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

        </div>--%>
        <div class="col-md-12">
            <!-- Breadcrumbs -->
            <ol class="breadcrumb">
                <li><a href="<c:url value="/cabinet/" />"><i class="fa fa-home"></i></a></li>
                <li class="active"><%out.print((String)request.getAttribute("currentProjectCasesName"));%></li>
            </ol>
            <!-- #End Breadcrumbs -->

            <!-- Warning Block -->
            <div class="row mb20">
                <div class="col-md-12">

                    <!-- Text warning -->
                    <p class="bg-warning p10">
                        CASE는 고객의 요청사항을 접수하고 처리가 완료될 때 까지 진행 상황을 주고 받는 곳입니다.<br>
                        <br>
                        고객의 요청사항은 언제든지 CASE를 오픈하여 접수하실 수 있습니다.<br>
                        그러나 한가지 프로젝트에서 같은 종류의 이슈는 한번만 만드시고 지속적으로 대화를 주고 받아야 합니다.<br>
                        <br>
                        한가지 프로젝트에서도 여러가지 이슈가 있을 경우에는 여러 개의 CASE를 만들어도 됩니다.
                    </p>
                    <!-- #End text warning -->

                </div>
            </div>
            <!-- #End Warning Block -->


            <div class="row mb20">
                <div class="col-md-6">

                    <!-- table pagination -->
                    <div class="holder"></div>
                    <!-- #End table pagination -->

                </div>
                <div class="col-md-6 text-right"><a href="<c:url value="/newCase"/>" class="btn btn-primary">새 CASE 생성</a></div>
            </div>
            <!-- Projects list table -->
            <table class="table table-striped">

                <thead>
                <tr>
                    <th>Title</th>
                    <th class="text-center">Project</th>
                    <th class="text-center">Progress</th>
                    <th class="hidden-xs text-center">Date</th>
                    <th class="hidden-xs text-center">Update</th>
                    <th class="hidden-xs text-center">Appointment time</th>
                    <th class="hidden-xs text-center">Messages</th>
                </tr>
                </thead>

                <%
                    ArrayList<Case> cases =  (ArrayList<Case>)request.getAttribute("cases");
                    Iterator<Case> caseIterator = cases.iterator();
                    while (caseIterator.hasNext()) {
                        Case aCase = caseIterator.next();
                %>

                <!--<tr class="unread checked danger" // что бы сделать красным добавить в класс danger-->
                    <tbody id="itemContainer">
                        <tr class="unread checked"   onclick="javascript:window.location.href='/cabinet/case/<%    out.print(Long.toString(aCase.getId()));   %>'; return false;">
                            <td><a href="javascript:void(0);"><%  out.print(aCase.getProjectTitle().toString());  %></a></td>
                            <%String projectName = aCase.getProject().getProjectName();  %>
                            <td class="text-center"><a href="javascript:void(0);"><% if (projectName.equals(ProjectEnum.projectNameNormal.getDbValue())) {
                                out.print(ProjectEnum.projectNameNormal.getValue());
                            }else if (projectName.equals(ProjectEnum.projectNameEstimate.getDbValue())) {
                                out.print(ProjectEnum.projectNameEstimate.getValue());
                            } else out.print(projectName); %></a></td>
                            <td class="text-center"><%  out.print(aCase.getStatus()); %></td>
                            <td class="hidden-xs text-center"><%  out.print(aCase.getCreationDate().toString().substring(0, 10));  %></td>

                            <% List<Message> messages = new ArrayList<>(aCase.getMessages());
                                Message msg = messages.get(0); %>

                            <td class="hidden-xs text-center"><time class="timeago" datetime="<%  out.print(msg.getMessageTime()); %>"></time></td>
                            <td class="hidden-xs text-center"><time class="timeago" datetime="<%  out.print(msg.getMessageTime()); %>"></time></td>
                            <td class="hidden-xs text-center"><%  out.print(aCase.getMessages().size());   %></td>
                        </tr>
                    <%}%>
                </tbody>
            </table>
            <!-- #End Projects list table -->
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
