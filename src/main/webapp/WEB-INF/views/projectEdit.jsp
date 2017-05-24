<%@ page import="com.SoftwareFactoryAdmin.constant.ProjectEnum" %>
<%@ page import="com.SoftwareFactoryAdmin.model.*" %>
<%@ page import="com.SoftwareFactoryAdmin.constant.StatusEnum" %>
<%@ page import="java.text.SimpleDateFormat" %>
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

    <title>Project edit :: 소프트웨어팩토리</title>

    <%@ include file="headerStyles.jsp" %>

</head>
<body>
<!-- Wrapper -->
<div id="wrapper">

    <%Project project = (Project) request.getAttribute("project");%>
    <%User customerUser = (User) request.getAttribute("customerUser");%>
    <%boolean isNew = (boolean) request.getAttribute("isNew");%>
    <%SimpleDateFormat dateFormatShow = new SimpleDateFormat("yyyy-MM-dd HH:mm");%>
    <%String formAction = "/project-mm/save-new-project/";
        if(!isNew) formAction = "/project-mm/update-project";
    %>

    <!-- Sidebar -->
    <div id="sidebar-wrapper">

        <%@ include file="leftCategoriesMenu.jsp" %>

    </div>
    <!-- #End Sidebar -->

    <!-- Page Content -->
    <div id="page-content-wrapper">

        <%@ include file="topLine.jsp" %>

        <!-- Content section -->
        <section class="container-fluid content">
            <%String projectName = ""; if (!isNew && !"".equals(project.getProjectName())) projectName = project.getProjectName();%>
            <%String projectDisabled = "required";%>
            <% if (projectName.equals(ProjectEnum.projectNameNormal.getDbValue())) {
                projectName = ProjectEnum.projectNameNormal.getValue();
                projectDisabled = "disabled";
            }else if (projectName.equals(ProjectEnum.projectNameEstimate.getDbValue())) {
                projectName = ProjectEnum.projectNameEstimate.getValue();
                projectDisabled = "disabled";
            }%>

            <%
                String headTitle = "Create new project";
                if (!isNew) headTitle = projectName;
            %>

            <h3><i class="fa fa-user"></i><%out.print(headTitle);%></h3>

            <div class="mb20">
                <a href="<%out.print("/project-mm/");%>" class="btn btn-primary">Back</a>
            </div>

            <form action="<%out.print(formAction);%>?${_csrf.parameterName}=${_csrf.token}" method="POST" id="projectEditForm">
                <div class="row">
                    <div class="col-md-6">

                        <input type="hidden" name="idProject" value="<%if (!isNew)out.print(project.getId());%>">

                        <div class="form-group">
                            <label class="control-label">Id customer</label>
                            <%if (!isNew && !"".equals(project.getCustomerInfo().getId())){%>
                               <input type="text" class="form-control" value="<%out.print(customerUser.getSsoId());%>" disabled/>
                                <input type="hidden" name="customerSOOID"  value="<%out.print(customerUser.getSsoId());%>">
                            <%} else {%>
                                <input type="text" id="customerSOOID" name="customerSOOID" class="form-control" placeholder="Write customer id" required/>
                            <%}%>
                        </div>


                        <div class="form-group">
                            <label class="control-label">Project name</label>
                            <input type="hidden" name="projectName" value="<%out.print(project.getProjectName());%>">
                            <input type="text" class="form-control" placeholder="Project name" value="<%out.print(projectName);%>" <%out.print(projectDisabled);%>/>
                        </div>

                        <div class="form-group">
                            <label for="selectStatus">Select status</label>
                            <%String open="";%>
                            <%String start="";%>
                            <%String considered="";%>
                            <%String end="";%>
                            <%String close="";%>
                            <%if (!isNew && !"".equals(project.getStatus())){%>
                                <%if (project.getStatus().equals(StatusEnum.OPEN.toString())){open = "selected";}%>
                                <%if (project.getStatus().equals(StatusEnum.START.toString())){start = "selected";}%>
                                <%if (project.getStatus().equals(StatusEnum.CONSIDERED.toString())){considered = "selected";}%>
                                <%if (project.getStatus().equals(StatusEnum.END.toString())){end = "selected";}%>
                                <%if (project.getStatus().equals(StatusEnum.CLOSE.toString()))close = "selected";%>
                            <%}%>
                            <select id="selectStatus" name="selectStatus" class="form-control">
                                <option value="OPEN" <%out.print(open);%>>OPEN</option>
                                <option value="START" <%out.print(start);%>>START</option>
                                <option value="CONSIDERED" <%out.print(considered);%>>CONSIDERED</option>
                                <option value="END" <%out.print(end);%>>END</option>
                                <option value="CLOSE" <%out.print(close);%>>CLOSE</option>
                            </select>
                        </div>

                        <div class="form-group">
                            <!-- Appointment time -->
                            <%String dateStart = "";%>
                            <%if (!isNew && project.getStartDate() != null) dateStart = dateFormatShow.format(project.getStartDate());%>
                            <label for="selectStatus">Start date</label>
                            <div class="form-group">
                                <div class="input-group date" id="datetimepicker">
                                    <input type="text" name="dateStart" class="form-control" value="<%out.print(dateStart);%>"/>
                                    <span class="input-group-addon">
                                    <span class="glyphicon glyphicon-calendar"></span>
                                </span>
                                </div>
                            </div>
                            <!-- #End Appointment time -->
                        </div>

                        <div class="form-group">
                            <!-- Appointment time -->
                            <%String dateEnd = "";%>
                            <%if (!isNew && project.getEndDate() != null) dateEnd = dateFormatShow.format(project.getEndDate());%>
                            <label for="selectStatus">End date</label>
                            <div class="form-group">
                                <div class="input-group date" id="datetimepicker1">
                                    <input type="text" name="dateEnd" class="form-control" value="<%out.print(dateEnd);%>"/>
                                    <span class="input-group-addon">
                                    <span class="glyphicon glyphicon-calendar"></span>
                                </span>
                                </div>
                            </div>
                            <!-- #End Appointment time -->
                        </div>

                        <!-- Description -->
                        <div class="form-group">
                            <label for="selectStatus">Project description</label>
                            <div class="form-group">
                                <textarea id="editor" name="description" rows="3">
                                    <%if (!isNew && !"".equals(project.getDescription())) out.print(project.getDescription());%>
                                </textarea>
                            </div>
                        </div>
                        <!-- #End Description -->

                        <div class="form-group text-right">
                            <button type="submit" name="save" class="btn btn-primary"><i class="fa fa-check pr10"></i>Save</button>
                        </div>
                    </div>
                </div>
            </form>
        </section>
        <!-- Content section -->

    </div>
    <!-- #End Page-content -->

</div>
<!-- #End Wrapper -->

<%@ include file="footerJavaScript.jsp" %>


</body>
</html>
