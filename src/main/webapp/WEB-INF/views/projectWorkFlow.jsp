<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="com.SoftwareFactoryAdmin.model.*" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Set" %>
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
    <meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1, user-scalable=no, minimal-ui"/>
    <meta name="format-detection" content="telephone=no"/>
    <meta name="format-detection" content="address=no"/>
    <meta name="description" content=""/>
    <meta name="keywords" content=""/>

    <title>Project workflow</title>

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

        <!-- Content section -->

        <%
            Project project = (Project) request.getAttribute("project");
            String startNewTaskLink = "/project-wf/start-new-task/"+project.getId();
            SimpleDateFormat dateFormatShow = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            String projectScenarioUuidName = project.getScenarioUuidName();
        %>

        <div class="row">

            <div class="col-md-8">

                <section class="container-fluid content">
                    <h3><i class="fa fa-user"></i>Project Tasks</h3>


                    <table id="dataTable" class="table table-striped table-bordered" width="100%" cellspacing="0">
                        <thead>
                        <tr>
                            <th width="20">ID</th>
                            <th>Title</th>
                            <th>Start date</th>
                            <th>End date</th>
                            <th>Status</th>
                        </tr>
                        </thead>
                        <tfoot>
                        <tr>
                            <th>ID</th>
                            <th>Title</th>
                            <th>Start date</th>
                            <th>End date</th>
                            <th>Status</th>
                        </tr>
                        </tfoot>


                        <!-- Items list -->
                        <tbody>
                            <%
                                Set <ProjectTask> projectTasks  =  project.getProjectTasks();
                                for (ProjectTask projectTask : projectTasks) {%>
                                    <tr>
                                        <td align="center"><%out.print(projectTask.getId());%></td>
                                        <td><%out.print(projectTask.getTitle());%></td>
                                        <td><%out.print(dateFormatShow.format(projectTask.getStartDate()));%></td>
                                        <td><%out.print(dateFormatShow.format(projectTask.getEndDate()));%></td>
                                        <td><%out.print(projectTask.getStatus());%></td>
                                    </tr>
                            <%}%>
                        </tbody>
                        <!-- #End Items list -->

                    </table>

                </section>
                <!-- Content section -->
            </div>


            <div class="col-md-4">
                <section class="container-fluid content">

                    <br><br><br>

                    <div class="mb20">
                        <a href="/project-mm/" class="btn btn-primary"><i class="fa fa-align-left mr10"></i>Back to
                            projects</a>
                        <a href="<%out.print(startNewTaskLink);%>" class="btn btn-primary"><i class="fa fa-plus-circle mr10"></i>Add
                            new task</a>
                    </div>

                    <section class="estimate-user-info">
                        <div class="scenario-link"><%if (projectScenarioUuidName == null) out.print(" Project scenario don't exist, please upload"); else { out.print(" Project scenario  -  ");%><a href="/get-file/general/<%out.print(projectScenarioUuidName);%>"> scenario link </a><%}%></div>
                    </section>

                    <br>

                    <form action="/project-wf/upload-scenario" method="post" enctype="multipart/form-data">

                        <input type="hidden" name="project_id" value="<%out.print(project.getId());%>">

                        <!-- Attach files -->
                        <h4 class="mb10">Attach scenario</h4>
                        <div class="form-group">
                            <input id="chatUpload" name="file[]"  type="file" required>
                        </div>
                        <!-- #End Attach files -->

                        <div class="form-group text-right mt20">
                            <button type="submit" class="btn btn-primary"><i class="fa fa-paper-plane-o pr10"></i>Upload
                                Scenario
                            </button>
                        </div>
                    </form>
                </section>
            </div>

        </div>


    </div>
    <!-- #End Page-content -->

</div>
<!-- #End Wrapper -->

<%@ include file="footerJavaScript.jsp" %>

<%
    String isScenarioUpload = request.getParameter("isScenarioUpload");
    if (isScenarioUpload != null) {
        String link = "/project-wf/" + project.getId();
%>
    <script>
        jQuery(document).ready(function ($) {
            swal(
                'Success!',
                'Scenario Upload',
                'success'
            );
            history.pushState(null, null, '<%out.print(link);%>');
        });
    </script>
<%}%>

</body>
</html>
