<%@ page import="com.SoftwareFactoryAdmin.model.*" %>
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

    <title>Project Task start :: 소프트웨어팩토리</title>

    <%@ include file="styles.jsp" %>

</head>
<body>


<!-- Wrapper -->
<div id="wrapper">


        <%@ include file="leftCategoriesMenu.jsp" %>



    <!-- Page Content -->
    <div id="page-content-wrapper">





        <%Project project = (Project) request.getAttribute("project");%>
        <%String formAction = "/project-wf/start-task/";%>



        <!-- Content section -->
        <section class="container-fluid content">

            <h3><i class="fa fa-user"></i> Project Task </h3>

            <div class="mb20">
                <a href="<%out.print("/project-wf/"+project.getId());%>" class="btn btn-primary">Back</a>
            </div>

            <form class="form-horizontal" action="<%out.print(formAction);%>" method="post"  enctype="multipart/form-data">

                <div class="col-md-7">

                    <input type="hidden" name="project_id" value="<%out.print(project.getId());%>">


                    <h4 class="mb10 mt20">Task title</h4>
                    <input type="text" name="title"  class="form-control" placeholder="Task title" required/>


                    <h4 class="mb10 mt20">Short Description</h4>
                    <textarea class="form-control" name="short_description" id="description_editor" required></textarea>


                    <h4 class="mb10 mt20">Full Task Description</h4>
                    <textarea class="form-control" name="full_description" id="editor" required></textarea>


                    <!-- Appointment time -->
                    <h4 class="mb10 mt20">End Task Date</h4>

                    <div class='input-group date' id='datetimepicker'>
                        <input type="text" name="end_date" class="form-control" required/>
                        <span class="input-group-addon">
                            <span class="glyphicon glyphicon-calendar"></span>
                        </span>
                    </div>
                    <!-- #End Appointment time -->


                    <!-- Attach files -->
                    <h4 class="mb10 mt20">Attach Files</h4>
                    <input id="chatUpload" name="file[]" multiple type="file">
                    <!-- #End Attach files -->

                    <button type="submit" name="save" class="btn btn-primary">
                        <i class="fa fa-check pr10"></i>Start Task
                    </button>


                </div>
            </form>
        </section>
        <!-- Content section -->

    </div>
    <!-- #End Page-content -->

</div>
<!-- #End Wrapper -->

<%@ include file="javascript.jsp" %>

</body>
</html>
