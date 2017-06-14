<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="com.SoftwareFactoryAdmin.model.*" %>
<%@ page import="com.SoftwareFactoryAdmin.constant.ProjectEnum" %>
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

    <meta name="description" content="" />
    <meta name="keywords" content="" />

    <title>Project :: 소프트웨어팩토리</title>

    <%@ include file="styles.jsp" %>

</head>
<body>
<!-- Wrapper -->
<div id="wrapper">

    <%Project project = (Project) request.getAttribute("project");%>
    <%SimpleDateFormat dateFormatShow = new SimpleDateFormat("yyyy-MM-dd HH:mm");%>
    <%ManagerInfo managerInfoByProject = (ManagerInfo) request.getAttribute("managerInfoByProject");%>

    <%@ include file="leftCategoriesMenu.jsp" %>

    <!-- Page Content -->
    <div id="page-content-wrapper">

        <!-- Header -->
        <header class="header line">
            <a href="javascript:void(0);" class="btn btn-toggle" id="menu-toggle"><i class="fa fa-bars" aria-hidden="true"></i></a>
            <span class="header-title clearfix">Project: <%out.print(String.format("%04d", project.getCustomerInfo().getId()) + "-");%><%out.print(String.format("%04d", project.getId()));%> </span>
        </header>
        <!-- #End Header -->

        <section class="content container-fluid">

            <div class="mb20">
                <a href="/project-mm/" class="btn btn-primary"><i class="fa fa-times-circle pr10"></i>Back</a>
                <a href="<%out.print("/project-mm/edit-project/"+project.getId()+"/");%>" class="btn btn-primary"><i class="glyphicon glyphicon-pencil pr10"></i>Edit</a>
            </div>

            <div class="background-01">

                <span class="content-title mt30">DESCRIPTION</span>

                <div class="mb20">
                    <%out.print(project.getDescription());%>
                </div>

                <span class="content-title mt30">Project information</span>

                <div class="row">
                    <div class="col-md-3">
                        <div>
                            <h4>About Project</h4>
                            <div>Date start:
                                <%if (project.getStartDate() == null) { out.print("-"); } else { out.print(dateFormatShow.format(project.getStartDate()));}%>
                            </div>
                            <div>Date end:
                                <%if (project.getEndDate() == null) { out.print("-"); } else { out.print(dateFormatShow.format(project.getEndDate()));}%>
                            </div>
                            <div>Manager:  <%out.print(managerInfoByProject.getName());%></div>
                        </div>

                        <div class="mt20">
                            <h4>CUSTOMER INFORMATION</h4>
                            <div>Name: <%out.print(project.getCustomerInfo().getName());%></div>
                            <div>E-mail: <a href="mailto:<%out.print(project.getCustomerInfo().getEmail());%>"><%out.print(project.getCustomerInfo().getEmail());%></a></div>
                            <div>Phone: <%out.print(project.getCustomerInfo().getPhone());%></div>
                        </div>

                    </div>
                    <div class="col-md-9">
                        <%if (project.getCases().size()>0){%>
                            <%for (Case aCase : project.getCases()) {%>
                                <div class="col-md-10 mb10">
                                    <section class="estimate-user-info">
                                        <div class="title"><%out.print(aCase.getProjectTitle());%></div>
                                        <div class="date">Data creation: <%out.print(dateFormatShow.format(aCase.getCreationDate()));%></div>
                                        <div class="status">Status: <%out.print(aCase.getStatus());%></div>
                                        <div class="info" align="right"><a href="<%out.print("/cases/" + aCase.getId()+"/");%>">Read</a></div>
                                    </section>
                                    <span class="content-title mt30"></span>
                                </div>
                            <%}%>
                        <%}%>
                    </div>
                </div>
            </div>
        </section>
    </div>
    <!-- #End Page Content -->
</div>

<%@ include file="javascript.jsp" %>

<% String isSuccess =  request.getParameter("isSuccess"); %>
<%String link = "/project-mm/view-project/"+project.getId()+"/";%>
<% if (isSuccess != null && isSuccess.equals("true")) { %>
    <script>
        jQuery(document).ready(function ($) {
            swal(
                '정상적으로 접수 되었습니다!',
                '감사합니다',
                'success'
            );
            history.pushState(null, null, '<%out.print(link);%>');
        });
    </script>
<% } %>


</body>
</html>
