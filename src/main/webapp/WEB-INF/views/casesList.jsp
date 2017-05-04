<%@ page import="com.SoftwareFactoryAdmin.model.Case" %>
<%@ page import="java.util.List" %>
<%@ page import="com.SoftwareFactoryAdmin.constant.ProjectEnum" %>
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

    <title>Cases List :: 소프트웨어팩토리</title>

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
        <section class="container-fluid content">
            <h3><i class="fa fa-pie-chart"></i>Cases List</h3>

            <table id="dataTable" class="table table-striped table-bordered" width="100%" cellspacing="0">
                <thead>
                <tr>
                    <th width="20">ID</th>
                    <th>Case issue</th>
                    <th width="150">Customer name</th>
                    <th width="150">Project</th>
                    <th width="170">Date</th>
                    <th width="50">Status</th>
                    <th width="140">Appointment time</th>
                    <th width="70">Messages</th>
                </tr>
                </thead>
                <tfoot>
                <tr>
                    <th>ID</th>
                    <th>Case issue</th>
                    <th>Customer name</th>
                    <th>Project</th>
                    <th>Date</th>
                    <th>Status</th>
                    <th>Appointment time</th>
                    <th>Messages</th>
                </tr>
                </tfoot>

                <!-- Items list -->
                <tbody>
                <%List<Case> cases =  (List<Case>)request.getAttribute("cases");%>
                <%SimpleDateFormat dateFormatShow = new SimpleDateFormat("yyyy-MM-dd HH:mm");%>
                <%for (Case aCase :cases){%>
                    <tr>
                        <td align="center"><%out.print(aCase.getId());%></td>
                        <td><a href="<%out.print("/cases/" + aCase.getId()+"/");%>"><%out.print(aCase.getProjectTitle());%></a></td>
                        <td><a href="<%out.print("/customer-mm/edit-customer/"+aCase.getProject().getCustomerInfo().getId());%>"><%out.print(aCase.getProject().getCustomerInfo().getName());%></a></td>
                        <td align="center">
                            <% if (aCase.getProject().getProjectName().equals(ProjectEnum.projectNameNormal.getDbValue())) {
                                out.print(ProjectEnum.projectNameNormal.getValue());
                            }else if (aCase.getProject().getProjectName().equals(ProjectEnum.projectNameEstimate.getDbValue())) {
                                out.print(ProjectEnum.projectNameEstimate.getValue());
                            } else out.print(aCase.getProject().getProjectName()); %>
                        </td>
                        <td align="center"><%out.print(dateFormatShow.format(aCase.getCreationDate()));%></td>
                        <td align="center"><%--<i class="fa fa-circle-o"></i>--%><%out.print(aCase.getStatus().toString());%></td>
                        <td align="center"><time class="timeago" datetime="<%out.print(aCase.getAppointmentTime());%>"></time></td>
                        <td align="center"><%out.print(aCase.getMessages().size());%></td>
                    </tr>
                <%}%>
                </tbody>
                <!-- #End Items list -->

            </table>

        </section>
        <!-- Content section -->

    </div>
    <!-- #End Page-content -->

</div>
<!-- #End Wrapper -->

<%@ include file="footerJavaScript.jsp" %>

</body>
</html>