<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="com.SoftwareFactoryAdmin.model.*" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Set" %>
<%@ page import="java.util.List" %>
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



    <%@ include file="leftCategoriesMenu.jsp" %>


    <!-- Page Content -->
    <div id="page-content-wrapper">

        <!-- Header -->
        <header class="header line">
            <a href="javascript:void(0);" class="btn btn-toggle" id="menu-toggle"><i class="fa fa-bars" aria-hidden="true"></i></a>
            <span class="header-title clearfix">Select staff to work on this task</span>
        </header>
        <!-- #End Header -->

        <!-- Content section -->
        <section class="container-fluid content">

            <%ProjectTask projectTask = (ProjectTask) request.getAttribute("projectTask");%>
            <%String linkBack = "/project-wf/" + projectTask.getProject().getId();%>

            <div class="mb20">
                <a href="<%out.print(linkBack);%>" class="btn btn-primary"><i class="fa fa-times-circle pr10"></i>Back</a>
            </div>


            <table id="dataTable" class="table" width="100%" cellspacing="0">
                <thead>
                <tr>
                    <th width="20">ID</th>
                    <th>Name</th>
                    <th>Rating</th>
                    <th>Android</th>
                    <th>iOS</th>
                    <th>IOT</th>
                    <th>Java</th>
                    <th>PHP</th>
                    <th>Java script</th>
                    <th>C#</th>
                    <th>С++</th>
                    <th>Frontend (html+css)</th>
                    <th>Design</th>
                    <th width="150">Action</th>
                </tr>
                </thead>
                <tfoot>
                <tr>
                    <th width="20">ID</th>
                    <th>Name</th>
                    <th>Rating</th>
                    <th>Android</th>
                    <th>iOS</th>
                    <th>IOT</th>
                    <th>Java</th>
                    <th>PHP</th>
                    <th>Java script</th>
                    <th>C#</th>
                    <th>С++</th>
                    <th>Frontend (html+css)</th>
                    <th>Design</th>
                    <th width="150">Action</th>
                </tr>
                </tfoot>

                <!-- Items list -->
                <tbody>
                <% Set <StaffInfo> staffInfoList =  projectTask.getStaffInfos();%>
                <% for (StaffInfo staffInfo : staffInfoList){%>

                <tr>
                    <td align="center"><%out.print(staffInfo.getUser().getId());%></td>
                    <td align="center"><a href="<%out.print("/membership-mm/history/" + staffInfo.getId());%>"> <%out.print(staffInfo.getName());%> </a></td>
                    <td align="center"><input id="rating" name="input" value="<%out.print(staffInfo.getRating());%>" class="rating-loading"></td>
                    <td align="center"><%out.print(staffInfo.getAndroid());%></td>
                    <td align="center"><%out.print(staffInfo.getiOs());%></td>
                    <td align="center"><%out.print(staffInfo.getIot());%></td>
                    <td align="center"><%out.print(staffInfo.getJava());%></td>
                    <td align="center"><%out.print(staffInfo.getPhp());%></td>
                    <td align="center"><%out.print(staffInfo.getJavascript());%></td>
                    <td align="center"><%out.print(staffInfo.getcSharp());%></td>
                    <td align="center"><%out.print(staffInfo.getcPlusPlus());%></td>
                    <td align="center"><%out.print(staffInfo.getFrontend());%></td>
                    <td align="center"><%out.print(staffInfo.getDesign());%></td>
                    <td align="center">
                        <a href="<%out.print("/project-wf/approve/" + staffInfo.getId());%>" data-toggle="tooltip" title="Approve"><i class="fa fa-share"></i>
                            Approve</a>&nbsp; |&nbsp;
                    </td>
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

<%@ include file="javascript.jsp" %>

</body>
</html>

