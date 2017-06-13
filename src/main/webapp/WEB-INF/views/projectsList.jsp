<%@ page import="java.util.ArrayList" %>
<%@ page import="com.SoftwareFactoryAdmin.model.Project" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="com.SoftwareFactoryAdmin.util.AppMethods" %>
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

        <!-- Content section -->
        <section class="container-fluid content">
            <h3><i class="fa fa-user"></i>Projects</h3>

            <%SimpleDateFormat dateFormatShow = new SimpleDateFormat("yyyy-MM-dd HH:mm");%>
            <%SimpleDateFormat dateFormatStartEnd = new SimpleDateFormat("yyyy-MM-dd");%>

            <%--            <div class="mb20">
                            <a href="/project-mm/add-project" class="btn btn-primary"><i class="fa fa-plus-circle mr10"></i>Add new project</a>
                        </div>--%>


            <table id="dataTable" class="table table-striped table-bordered" width="100%" cellspacing="0">
                <thead>
                <tr>
                    <th width="20">NO</th>
                    <th>Project Code</th>
                    <th>Start date</th>
                    <th>End date</th>
                    <th>Status</th>
                    <th>Project manager</th>
                    <th>Description</th>
                    <th>Customer name</th>
                    <th>WorkFlow</th>
                </tr>
                </thead>
                <tfoot>
                <tr>
                    <th>NO</th>
                    <th>Project Code</th>
                    <th>Start date</th>
                    <th>End date</th>
                    <th>Status</th>
                    <th>Project manager</th>
                    <th>Description</th>
                    <th>Customer name</th>
                    <th>WorkFlow</th>
                </tr>
                </tfoot>


                <!-- Items list -->
                <tbody>
                <%ArrayList<Project> projectArrayList = (ArrayList<Project>) request.getAttribute("projectsList");%>
                <%for (Project project : projectArrayList) {%>
                    <tr>
                        <td align="center"><%out.print(project.getId());%></td>
                        <td><a href="<%out.print("/project-mm/view-project/"+project.getId()+"/");%>">
                            <%out.print(String.format("%04d", project.getCustomerInfo().getId()) + "-");%><%
                            out.print(String.format("%04d", project.getId()));%></a></td>
                        <td align="center">
                            <%if (project.getStartDate() == null) {out.print("-");} else {out.print(dateFormatStartEnd.format(project.getStartDate()));}%>
                        </td>
                        <td align="center">
                            <%if (project.getEndDate() == null) {out.print("-");} else {out.print(dateFormatStartEnd.format(project.getEndDate()));}%>
                        </td>
                        <td align="center"><%out.print(project.getStatus());%></td>
                        <td><%out.print(project.getManagerInfo().getName());%></td>
                        <td><%out.print(project.getDescription());%></td>
                        <td>
                            <a onclick="getCustomerInfo(<%out.print(project.getCustomerInfo().getId());%>)">
                                <%out.print(project.getCustomerInfo().getName());%>
                            </a>
                        </td>
                        <td><a href="<%out.print("/project-wf/"+project.getId());%>"> X </a></td>
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

<%--Modal window--%>
<div class="modal fade" id="myModalInfo">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header">
                <button class="close" type="button" data-dismiss="modal">
                    <i class="fa fa-close"></i>
                </button>
                <h4 class="modal-title">Information</h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal">
                    <div class="form-group">
                        <label class="col-sm-2 control-label">SSO ID:</label>
                        <div class="col-sm-10">
                            <p class="form-control-static" id="customerSoid_json"></p>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">Company:</label>
                        <div class="col-sm-10">
                            <p class="form-control-static" id="customerCompany_json"></p>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">WEB site:</label>
                        <div class="col-sm-10">
                            <p class="form-control-static" id="customerWebsite_json"></p>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">Name:</label>
                        <div class="col-sm-10">
                            <p class="form-control-static" id="customerName_json"></p>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">E-mail:</label>
                        <div class="col-sm-10">
                            <p class="form-control-static" id="customerEmail_json"></p>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">Phone:</label>
                        <div class="col-sm-10">
                            <p class="form-control-static" id="customerPhone_json"></p>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">Account type:</label>
                        <div class="col-sm-10">
                            <p class="form-control-static" id="customerAccount_json"></p>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">Directors Name:</label>
                        <div class="col-sm-10">
                            <p class="form-control-static" id="customerDirectorsName_json"></p>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">Directors E-mail:</label>
                        <div class="col-sm-10">
                            <p class="form-control-static" id="customerDirectorsEmail_json"></p>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">Directors Phone:</label>
                        <div class="col-sm-10">
                            <p class="form-control-static" id="customerDirectorsPhone_json"></p>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">Company Type:</label>
                        <div class="col-sm-10">
                            <p class="form-control-static" id="customerCompanyType_json"></p>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">Address:</label>
                        <div class="col-sm-10">
                            <p class="form-control-static" id="customerAddress_json"></p>
                        </div>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button class="btn btn-primary" type="button" data-dismiss="modal">Close</button>
            </div>
        </div>
    </div>
</div>
<%--End Modal window--%>

<%@ include file="footerJavaScript.jsp" %>

</body>
</html>