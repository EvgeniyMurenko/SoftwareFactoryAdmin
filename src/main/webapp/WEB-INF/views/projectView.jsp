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

        <%Project project = (Project) request.getAttribute("project");%>
        <%ManagerInfo managerInfo = (ManagerInfo) request.getAttribute("managerInfo");%>
        <%SimpleDateFormat dateFormatStartEnd = new SimpleDateFormat("yyyy-MM-dd");%>
        <%SimpleDateFormat dateFormatShow = new SimpleDateFormat("yyyy-MM-dd HH:mm");%>

        <%String projectName = ""; if (!"".equals(project.getProjectName())) projectName = project.getProjectName();%>
        <% if (projectName.equals(ProjectEnum.projectNameNormal.getDbValue())) {
            projectName = ProjectEnum.projectNameNormal.getValue();
        }else if (projectName.equals(ProjectEnum.projectNameEstimate.getDbValue())) {
            projectName = ProjectEnum.projectNameEstimate.getValue();
        }%>


        <!-- Content section -->
        <section class="container-fluid content">
            <h3><i class="fa fa-file-text-o"></i>Project code: <%out.print(String.format("%04d", project.getCustomerInfo().getId()) + "-");%><%out.print(String.format("%05d", project.getId()));%> <%out.print(projectName);%></h3>

            <div class="mb20">
                <a href="/project-mm/" class="btn btn-primary"><i class="fa fa-times-circle pr10"></i>Back</a>
                <a href="<%out.print("/project-mm/edit-project/"+project.getId()+"/");%>" class="btn btn-primary"><i class="glyphicon glyphicon-pencil pr10"></i>Edit</a>
            </div>

            <div class="row">
                <!-- Customer info -->
                <div class="col-md-3">

                    <h4 class="mb10">Project information</h4>
                    <section class="estimate-user-info">
                        <div class="date">Date create: <%out.print(dateFormatShow.format(project.getCreateDate()));%></div>
                        <div class="date">Date start:
                            <%if (project.getStartDate() == null) { out.print("-"); } else { out.print(dateFormatStartEnd.format(project.getStartDate()));}%>
                        </div>
                        <div class="date">Date end:
                            <%if (project.getEndDate() == null) { out.print("-"); } else { out.print(dateFormatStartEnd.format(project.getEndDate()));}%>
                        </div>
                        <div class="manager">Manager: <%out.print(managerInfo.getName());%></div>
                    </section>

                    <h4 class="mb10" style="margin-top: 10px;!important;">Customer information</h4>
                    <section class="estimate-user-info">
                        <div class="name">Name: <a href=""><%out.print(project.getCustomerInfo().getName());%></a></div>
                        <div class="email">E-mail: <a href="mailto:<%out.print(project.getCustomerInfo().getEmail());%>"><%out.print(project.getCustomerInfo().getEmail());%></a></div>
                        <div class="phone">Phone: <%out.print(project.getCustomerInfo().getPhone());%></div>
                    </section>

                </div>
                <!-- End Customer info -->

                <!-- Project body -->
                <div class="col-md-9">


                    <h4 class="mb10" style="margin-left: 15px;!important;">Description</h4>
                    <div class="col-md-12" style="margin-bottom: 10px;!important;">
                        <section class="estimate-user-info">
                            <div class="description">
                                <%out.print(project.getDescription());%>
                            </div>

                        </section>
                    </div>

                    <%for (Case aCase : project.getCases()) {%>
                        <div class="col-md-12" style="margin-bottom: 10px; !important;">
                            <section class="estimate-user-info">
                                <div class="title"><%out.print(aCase.getProjectTitle());%></div>
                                <div class="date">Data creation: <%out.print(dateFormatStartEnd.format(aCase.getCreationDate()));%></div>
                                <div class="status">Status: <%out.print(aCase.getStatus());%></div>
                                <div class="info" align="right"><a href="<%out.print("/cases/" + aCase.getId()+"/");%>">Read</a></div>
                            </section>
                        </div>
                    <%}%>

                </div>
                <!-- #End Project body -->

            </div>

        </section>
        <!-- Content section -->

    </div>
    <!-- #End Page-content -->

</div>
<!-- #End Wrapper -->

<%@ include file="footerJavaScript.jsp" %>

<% String isSuccess =  request.getParameter("isSuccess"); %>
<%String link = "/project-mm/view-project/"+project.getId()+"/";%>
<% if (isSuccess != null || isSuccess.equals("true")) { %>
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
