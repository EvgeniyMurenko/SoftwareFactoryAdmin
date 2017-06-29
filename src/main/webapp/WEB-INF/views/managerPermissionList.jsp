<%@ page import="java.util.List" %>
<%@ page import="com.SoftwareFactoryAdmin.util.AppMethods" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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

    <title>Permissions :: 소프트웨어팩토리</title>

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
            <a href="javascript:void(0);" class="btn btn-toggle" id="menu-toggle"><i class="fa fa-lock" aria-hidden="true"></i></a>
            <span class="header-title clearfix">Permissions</span>
        </header>
        <!-- #End Header -->

        <%List<ManagerInfo> managerInfoList = (List<ManagerInfo>) request.getAttribute("managersList");%>

        <section class="content container-fluid">
            <div class="background-01">

                <table id="dataTable" class="table" width="100%" cellspacing="0">
                    <thead>
                    <tr>
                        <th>Manager name</th>
                        <th>Estimate</th>
                        <th>Case</th>
                        <th>Customer</th>
                        <th>Project</th>
                        <th>Staff</th>
                        <th>Notice</th>
                        <th>Permission</th>
                        <th>Translate</th>
                        <th width="150">Action</th>
                    </tr>
                    </thead>
                    <tfoot>
                    <tr>
                        <th>Manager name</th>
                        <th>Estimate</th>
                        <th>Case</th>
                        <th>Customer</th>
                        <th>Project</th>
                        <th>Staff</th>
                        <th>Notice</th>
                        <th>Permission</th>
                        <th>Translate</th>
                        <th width="150">Action</th>
                    </tr>
                    </tfoot>

                    <tbody>

                    <!-- Items list -->
                    <%
                        for (ManagerInfo managerInfo : managerInfoList){
                            Permission permission = managerInfo.getManagerInfoPermissions();

                            if (!permission.getSuperAdminPermission() && !managerInfo.getId().equals(currentManagerInfo.getId())){
                    %>

                            <tr>
                                <form action="/permission/change-permission" method="post">
                                    <input type="hidden" name="id" value="<%out.print(managerInfo.getId());%>">
                                    <td align="center"><%out.print(managerInfo.getName());%></td>
                                    <td align="center"><input type="checkbox" name="estimate_permission" <%out.print(AppMethods.isChecked(permission.getEstimatePermission()));%>></td>
                                    <td align="center"><input type="checkbox" name="case_permission" <%out.print(AppMethods.isChecked(permission.getCasePermission()));%>></td>
                                    <td align="center"><input type="checkbox" name="customer_permission" <%out.print(AppMethods.isChecked(permission.getCustomerPermission()));%>></td>
                                    <td align="center"><input type="checkbox" name="projects_permission" <%out.print(AppMethods.isChecked(permission.getProjectsPermission()));%>></td>
                                    <td align="center"><input type="checkbox" name="staff_permission" <%out.print(AppMethods.isChecked(permission.getStaffPermission()));%>></td>
                                    <td align="center"><input type="checkbox" name="notice_permission" <%out.print(AppMethods.isChecked(permission.getNoticePermission()));%>></td>
                                    <td align="center"><input type="checkbox" name="permission_mm" <%out.print(AppMethods.isChecked(permission.getPermissionManagement()));%>></td>
                                    <td align="center"><input type="checkbox" name="translate_permission" <%out.print(AppMethods.isChecked(permission.getTranslatePermission()));%>></td>
                                    <td align="center">
                                        <button class="ghost-button" type="submit"><i class="fa fa-floppy-o" aria-hidden="true"></i> Save</button>
                                     </td>
                                 </form>
                            </tr>
                        <%}%>
                    <%}%>


                </table>
            </div>
        </section>



    </div>
    <!-- #End Page Content -->

</div>

<%@ include file="javascript.jsp" %>

<%String isSuccess = request.getParameter("isSuccess");%>
<%if (isSuccess != null) {%>
<%String link = "/permission/change-permission";%>
<script>
    jQuery(document).ready(function ($) {
        swal(
            'Success!',
            'Permission changed.',
            'success'
        );
        history.pushState(null, null, '<%out.print(link);%>');
    });
</script>
<%}%>
</body>
</html>