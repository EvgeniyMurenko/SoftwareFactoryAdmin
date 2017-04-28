<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="com.SoftwareFactoryAdmin.model.Project" %>
<%@ page import="java.text.SimpleDateFormat" %>
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
        <!-- Content section -->
        <section class="container-fluid content">
            <h3><i class="fa fa-user"></i>Projects</h3>


            <div class="mb20">
                <a href="/project-mm/add-project" class="btn btn-primary"><i class="fa fa-plus-circle mr10"></i>Add new project</a>
            </div>


            <table id="dataTable" class="table table-striped table-bordered" width="100%" cellspacing="0">
                <thead>
                    <tr>
                        <th width="20">ID</th>
                        <th>Project Code (Customer ID + Project ID)</th>
                        <th>Name project</th>
                        <th>Create date</th>
                        <th width="120">Status</th>
                        <th width="150">Customer info</th>
                    </tr>
                </thead>
                <tfoot>
                    <tr>
                        <th>ID</th>
                        <th>Project Code</th>
                        <th>Name project</th>
                        <th>Create date</th>
                        <th>Status</th>
                        <th>Customer info</th>
                    </tr>
                </tfoot>


                <!-- Items list -->
                <tbody>

                    <%
                        ArrayList<Project> projectArrayList = (ArrayList<Project>) request.getAttribute("projectsList");

                        Iterator<Project> projectIterator = projectArrayList.iterator();

                        while (projectIterator.hasNext()) {
                            Project project = projectIterator.next();
                            String CustomerInfoUrl = "/customer-mm/edit-customer/"+project.getCustomerInfo().getId().toString();

                    %>
                        <tr>
                            <td align="center"><%out.print(project.getId());%></td>
                            <td><%out.print(String.format("%05d", project.getCustomerInfo().getId()) + "+");%><%out.print(String.format("%05d", project.getId()));%></td>
                            <td><%if("#$ESTIMATE".equals(project.getProjectName())){out.print("Estimate");}else if("#$GENERAL".equals(project.getProjectName())){out.print("Normal");} else {out.print(project.getProjectName());}%></td>
                            <td><%out.print(dateFormatShow.format(project.getCreateDate()));%></td>
                            <td align="center"><%out.print(project.getStatus());%></td>
                            <td align="center">
                                <a href="<%out.print(CustomerInfoUrl);%>" data-toggle="tooltip" title="Edit"><%out.print(project.getCustomerInfo().getName());%></a>
                                <%--<a href="<%out.print(editCustomerInfoUrl);%>" data-toggle="tooltip" title="Edit"><i class="fa fa-edit"></i> Edit</a>&nbsp; |&nbsp;--%>
                                <%--<a href="<%out.print(deleteCustomerInfoUrl);%>" data-toggle="tooltip" title="Delete" class="deleteConfirm"><i class="fa fa-trash"></i> Delete</a>--%>
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