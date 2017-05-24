<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="com.SoftwareFactoryAdmin.model.Project" %>
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

    <title>Projects list :: 소프트웨어팩토리</title>

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
        <%SimpleDateFormat dateFormatShow = new SimpleDateFormat("yyyy-MM-dd HH:mm");%>
        <%SimpleDateFormat dateFormatStartEnd = new SimpleDateFormat("yyyy-MM-dd");%>
        <!-- Content section -->
        <section class="container-fluid content">
            <h3><i class="fa fa-user"></i>Projects</h3>


            <div class="mb20">
                <a href="/project-mm/add-project" class="btn btn-primary"><i class="fa fa-plus-circle mr10"></i>Add new project</a>
            </div>


            <table id="dataTable" class="table table-striped table-bordered" width="100%" cellspacing="0">
                <thead>
                    <tr>
                        <th width="20">NO</th>
                        <th>Project Code</th>
                        <th>Create date</th>
                        <th>Start date</th>
                        <th>End date</th>
                        <th>Status</th>
                        <th>Project manager</th>
                        <th>Description</th>
                        <th>Customer name</th>
                        <%--<th>Email</th>
                        <th>Telephone</th>--%>
                    </tr>
                </thead>
                <tfoot>
                    <tr>
                        <th>NO</th>
                        <th>Project Code</th>
                        <th>Create date</th>
                        <th>Start date</th>
                        <th>End date</th>
                        <th>Status</th>
                        <th>Project manager</th>
                        <th>Description</th>
                        <th>Customer name</th>
                       <%-- <th>Email</th>
                        <th>Telephone</th>--%>
                    </tr>
                </tfoot>


                <!-- Items list -->
                <tbody>

                    <%
                        ArrayList<Project> projectArrayList = (ArrayList<Project>) request.getAttribute("projectsList");

                        Iterator<Project> projectIterator = projectArrayList.iterator();

                        while (projectIterator.hasNext()) {
                            Project project = projectIterator.next();
                            String customerInfoUrl = "/customer-mm/edit-customer/"+project.getCustomerInfo().getId().toString();
                            String managerInfoUrl = "/staff-mm/edit-staff/"+project.getManagerInfo().getId().toString();

                    %>
                        <tr>
                            <td align="center"><%out.print(project.getId());%></td>
                            <td><a href="<%out.print("/project-mm/view-project/"+project.getId()+"/");%>"><%out.print(String.format("%04d", project.getCustomerInfo().getId()) + "-");%><%out.print(String.format("%05d", project.getId()));%></a></td>
                           <%-- <td><%if("#$ESTIMATE".equals(project.getProjectName())){out.print("Estimate");}else if("#$GENERAL".equals(project.getProjectName())){out.print("Normal");} else {out.print(project.getProjectName());}%></td>--%>
                            <td><%out.print(dateFormatShow.format(project.getCreateDate()));%></td>
                            <td align="center">
                                <%if (project.getStartDate() == null) { out.print("-"); } else { out.print(dateFormatStartEnd.format(project.getStartDate()));}%>
                            </td>
                            <td align="center">
                                <%if (project.getEndDate()== null) {
                                    out.print("-");
                                } else {
                                    out.print(dateFormatStartEnd.format(project.getEndDate()));
                                }%>
                            </td>
                            <td align="center"><%out.print(project.getStatus());%></td>
                            <td><a href="<%out.print(managerInfoUrl);%>"><%out.print(project.getManagerInfo().getName());%></a></td>
                            <td><%out.print(project.getDescription());%></td>
                            <td><a href="<%out.print(customerInfoUrl);%>"><%out.print(project.getCustomerInfo().getName());%></a></td>
                            <%--<td><%out.print(project.getCustomerInfo().getEmail());%></td>
                            <td><%out.print(project.getCustomerInfo().getPhone());%></td>--%>
                            <%--<td align="center">
                                <a href="<%out.print(CustomerInfoUrl);%>" data-toggle="tooltip" title="Edit"><%out.print(project.getCustomerInfo().getName());%></a>
                                &lt;%&ndash;<a href="<%out.print(editCustomerInfoUrl);%>" data-toggle="tooltip" title="Edit"><i class="fa fa-edit"></i> Edit</a>&nbsp; |&nbsp;&ndash;%&gt;
                                &lt;%&ndash;<a href="<%out.print(deleteCustomerInfoUrl);%>" data-toggle="tooltip" title="Delete" class="deleteConfirm"><i class="fa fa-trash"></i> Delete</a>&ndash;%&gt;
                            </td>--%>
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