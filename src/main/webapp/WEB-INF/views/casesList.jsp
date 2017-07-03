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
<html lang="en">
<head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1, user-scalable=no, minimal-ui" />
    <meta name="format-detection" content="telephone=no" />
    <meta name="format-detection" content="address=no" />

    <meta name="description" content="" />
    <meta name="keywords" content="" />

    <title>Cases :: 소프트웨어팩토리</title>

    <%@ include file="styles.jsp" %>

</head>
<body>

<!-- Wrapper -->
<div id="wrapper">

    <%List<Case> caseList =  (List<Case>)request.getAttribute("cases");%>
    <%SimpleDateFormat dateFormatShow = new SimpleDateFormat("yyyy-MM-dd HH:mm");%>

    <%@ include file="leftCategoriesMenu.jsp" %>

    <!-- Page Content -->
    <div id="page-content-wrapper">

        <!-- Header -->
        <header class="header line">
            <a href="javascript:void(0);" class="btn btn-toggle" id="menu-toggle"><i class="fa fa-bars" aria-hidden="true"></i></a>
            <span class="header-title clearfix">Cases</span>
        </header>
        <!-- #End Header -->

        <section class="content container-fluid">
            <div class="background-01">

                <table id="dataTable" class="table" width="100%" cellspacing="0">
                    <thead>
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
                    <%if (caseList.size()>0){%>
                        <%for (Case aCase :caseList){%>

                                <tr>
                                    <td align="center"><%out.print(aCase.getId());%></td>
                                    <td><a href="<%out.print("/cases/" + aCase.getId()+"/");%>"><%out.print(aCase.getProjectTitle());%></a></td>
                                    <td align="center"><a href="<%out.print("/customer-mm/edit-customer/"+aCase.getProject().getCustomerInfo().getId());%>"><%out.print(aCase.getProject().getCustomerInfo().getName());%></a></td>
                                    <td align="center">
                                        <% if (aCase.getProject().getProjectName().equals(ProjectEnum.projectNameNormal.getDbValue())) {
                                            out.print(ProjectEnum.projectNameNormal.getValue());
                                        }else if (aCase.getProject().getProjectName().equals(ProjectEnum.projectNameEstimate.getDbValue())) {
                                            out.print(ProjectEnum.projectNameEstimate.getValue());
                                        } else out.print(aCase.getProject().getProjectName()); %>
                                    </td>
                                    <td align="center"><%out.print(dateFormatShow.format(aCase.getCreationDate()));%></td>
                                    <td align="center"><%out.print(aCase.getStatus().toString());%></td>
                                    <td align="center"><time class="timeago" datetime="<%out.print(aCase.getAppointmentTime());%>"></time></td>
                                    <td align="center"><%out.print(aCase.getMessages().size());%></td>
                                </tr>

                        <%}%>
                    <%}%>

                    </tbody>
                    <!-- #End Items list -->

                </table>
            </div>

        </section>

    </div>
    <!-- #End Page Content -->

</div>

<%@ include file="javascript.jsp" %>

</body>
</html>