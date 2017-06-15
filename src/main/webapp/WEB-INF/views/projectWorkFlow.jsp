<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="com.SoftwareFactoryAdmin.model.*" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Set" %>
<%@ page import="com.SoftwareFactoryAdmin.constant.StatusEnum" %>
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

    <%@ include file="styles.jsp" %>

</head>
<body>
<!-- Wrapper -->
<div id="wrapper">

    <%Project project = (Project) request.getAttribute("project");%>
    <%SimpleDateFormat dateFormatShow = new SimpleDateFormat("yyyy-MM-dd HH:mm");%>
    <%String projectScenarioUuidName = project.getScenarioUuidName();%>

    <%@ include file="leftCategoriesMenu.jsp" %>

    <!-- Page Content -->
    <div id="page-content-wrapper">

        <!-- Header -->
        <header class="header line">
            <a href="javascript:void(0);" class="btn btn-toggle" id="menu-toggle"><i class="fa fa-bars" aria-hidden="true"></i></a>
            <span class="header-title clearfix">Project Tasks</span>
        </header>
        <!-- #End Header -->

        <section class="content container-fluid">

            <div class="mb10">
                <a href="/project-mm/" class="btn btn-primary"><i class="fa fa-times-circle pr10"></i>Back</a>
                <a data-toggle="modal" data-target="#modalAddProjectTask" class="btn btn-primary"><i class="glyphicon glyphicon-pencil pr10"></i>Add new task</a>
            </div>

            <div class="col-sm-12">

                <div class="background-01 mt30">

                    <span class="content-title mt30">DESCRIPTION</span>

                    <div class="mb10">
                        <%out.print(project.getDescription());%>
                    </div>
                </div>
            </div>


            <div class="col-sm-8 mt10">
                <div class="background-01">
                    <table id="dataTable" class="table" width="100%" cellspacing="0">
                        <thead>
                        <tr>
                            <th>ID</th>
                            <th>Title</th>
                            <th>Start Date</th>
                            <th>End date</th>
                            <th>Status</th>
                        </tr>
                        </thead>
                        <tfoot>
                        <tr>
                            <th>ID</th>
                            <th>Title</th>
                            <th>Start Date</th>
                            <th>End date</th>
                            <th>Status</th>
                        </tr>
                        </tfoot>

                        <tbody>
                            <%if (project.getProjectTasks().size()> 0){%>
                            <%for (ProjectTask projectTask : project.getProjectTasks()){
                                   String projectTaskLink = "/project-wf/select-staff-to-task/" + projectTask.getId();
                                   if (projectTask.getStatus().equals(StatusEnum.IN_WORK.toString())) projectTaskLink = "/project-wf/task-management/" +projectTask.getId();
                            %>
                        <!-- Items list -->
                        <tr>
                            <td align="center"><%out.print(projectTask.getId());%></td>
                            <td align="center"><a href="<%out.print(projectTaskLink);%>"><%out.print(projectTask.getTitle());%></a></td>
                            <td align="center"><%out.print(dateFormatShow.format(projectTask.getStartDate()));%></td>
                            <td align="center"><%out.print(dateFormatShow.format(projectTask.getEndDate()));%></td>
                            <td align="center"><%out.print(projectTask.getStatus());%></td>
                        </tr>
                            <%}%>
                            <%}%>
                    </table>
                </div>
            </div>

            <div class="col-sm-4 mt10">

                <form action="/project-wf/upload-scenario" method="post" enctype="multipart/form-data">

                    <input type="hidden" name="project_id" value="<%out.print(project.getId());%>">

                    <div class="background-01">
                        <div class="mb10">
                            <%if (projectScenarioUuidName == null) {
                                out.print("<h4>Project scenario don't exist, please upload</h4>");
                            } else {%>
                            <h4>Project scenario:</h4>
                            <a href="/get-file/general/<%out.print(projectScenarioUuidName);%>"> scenario link </a>
                            <%}%>

                        </div>
                        <br>
                        <!-- Attach files -->
                        <h4 class="mb10">Attach files</h4>
                        <div class="form-group">
                            <input id="chatUpload" name="file[]" multiple type="file">
                        </div>
                        <!-- #End Attach files -->

                        <div class="form-group text-right mt30 mb0">
                            <button type="submit" class="btn btn-primary"><i class="fa fa-paper-plane-o pr10"></i>Upload scenario</button>
                        </div>

                    </div>

                </form>

            </div>

        </section>


    </div>
    <!-- #End Page Content -->

</div>

<!-- Add project task modal -->
<div class="modal fade" id="modalAddProjectTask">
    <div class="modal-dialog modal-lg">

        <form class="form-horizontal" action="/project-wf/start-task/" method="post" enctype="multipart/form-data">

            <input type="hidden" name="project_id" value="<%out.print(project.getId());%>">

            <div class="modal-content">

                <div class="modal-header">
                    <button class="close" type="button" data-dismiss="modal">
                        <i class="fa fa-close"></i>
                    </button>
                    <h4 class="modal-title">Add task</h4>
                </div>

                <div class="modal-body">

                    <div class="form-group">
                        <label class="col-sm-3 control-label">TASK TITLE</label>
                        <div class="col-sm-9">
                            <input type="text" name="title" class="form-control" placeholder="TASK TITLE" value=""/>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-3 control-label">SHORT DESCRIPTION</label>
                        <div class="col-sm-9">
                            <input type="text" name="short_description" class="form-control" placeholder="SHORT DESCRIPTION" value=""/>
                        </div>
                    </div>

                    <!-- FULL TASK DESCRIPTION -->
                    <div class="form-group">
                        <label class="col-sm-3 control-label">FULL TASK DESCRIPTION</label>
                        <div class="col-sm-9">
                            <textarea id="editor" name="full_description" rows="3"></textarea>
                        </div>
                    </div>
                    <!-- #End FULL TASK DESCRIPTION -->

                    <div class="form-group">
                        <!-- Appointment time -->
                        <label class="col-sm-3 control-label">End date</label>
                        <div class="col-sm-9">
                            <div class='input-group date' id='datetimepicker'>
                                <input type='text' name="end_date" class="form-control" value=""/>
                                <span class="input-group-addon">
                                    <span class="glyphicon glyphicon-calendar"></span>
                                </span>
                            </div>
                        </div>
                        <!-- #End Appointment time -->
                    </div>

                    <div class="form-group">
                        <!-- Attach files -->
                        <label class="col-sm-3 control-label">Attach File</label>
                        <div class="col-sm-9">
                            <input id="uploadFile" name="file[]" multiple type="file">
                        </div>
                        <!-- #End Attach files -->
                    </div>

                </div>
                <div class="modal-footer">
                    <button type="submit" name="save" class="btn btn-primary"><i class="fa fa-check pr5"></i> Add</button>
                    <button class="btn btn-default" type="button" data-dismiss="modal"><i class="fa fa-times-circle pr5"></i> Close</button>
                </div>
            </div>
        </form>
    </div>
</div>
<!-- #End Add project task modal -->

<%@ include file="javascript.jsp" %>

<%String isScenarioUpload = request.getParameter("isScenarioUpload");%>
<%if (isScenarioUpload != null) {%>
<%String link = "/project-wf/" + project.getId();%>
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
