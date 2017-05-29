<%@ page import="java.util.List" %>
<%@ page import="com.SoftwareFactoryAdmin.model.StaffInfo" %>
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
    <meta name="viewport"
          content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1, user-scalable=no, minimal-ui"/>
    <meta name="format-detection" content="telephone=no"/>
    <meta name="format-detection" content="address=no"/>

    <meta name="description" content=""/>
    <meta name="keywords" content=""/>

    <title>Staff List :: 소프트웨어팩토리</title>

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
            <h3><i class="fa fa-users"></i>Staff List</h3>

            <div class="mb20">
                <a href="/membership-mm/create" class="btn btn-primary"><i class="fa fa-plus-circle pr10"></i>Add new Staff</a>
            </div>


            <table id="dataTable" class="table table-striped table-bordered" width="100%" cellspacing="0">
                <thead>
                <tr>
                    <th width="20">ID</th>
                    <th>Name</th>
                <%--    <th>Creation Date</th>
                    <th>Birth Date</th>
                    <th>E-mail</th>--%>
                    <th>Rating</th>
                    <th>Android</th>
                    <th>iOS</th>
                    <th>IOT</th>
                    <th>Java</th>
                    <th>PHP</th>
                    <th>Java script</th>
                    <th>C#</th>
                    <th>С++</th>
                    <th>Frontend(html+css)</th>
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
                    <th>Frontend(html+css)</th>
                    <th>Design</th>
                    <th width="150">Action</th>
                </tr>
                </tfoot>

                <!-- Items list -->
                <tbody>
               <% List <StaffInfo> staffInfoList =  (List<StaffInfo>)request.getAttribute("staffList");%>
                        <%for (StaffInfo staffInfo : staffInfoList){%>

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
                                    <a href="<%out.print("/membership-mm/edit/" + staffInfo.getId());%>" data-toggle="tooltip" title="Edit"><i class="fa fa-tasks"></i>
                                        Edit</a>&nbsp; |&nbsp;
                                    <a href="<%out.print("/membership-mm/staffDelete/" + staffInfo.getId());%>" data-toggle="tooltip" title="Delete" class="deleteConfirm"><i
                                            class="fa fa-trash"></i> Delete</a>
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

<%@ include file="footerJavaScript.jsp" %>

</body>
</html>

