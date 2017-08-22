<%@ page import="com.SoftwareFactoryAdmin.model.Case" %>
<%@ page import="java.util.List" %>
<%@ page import="com.SoftwareFactoryAdmin.constant.ProjectEnum" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="com.SoftwareFactoryAdmin.model.AppVersion" %>
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

    <title>Aplication managment :: 소프트웨어팩토리</title>

    <%@ include file="styles.jsp" %>

</head>
<body>

<!-- Wrapper -->
<div id="wrapper">

    <%List<AppVersion> appVersionList =  (List<AppVersion>)request.getAttribute("appVersionList");%>
    <%SimpleDateFormat dateFormatShow = new SimpleDateFormat("yyyy-MM-dd HH:mm");%>

    <%@ include file="leftCategoriesMenu.jsp" %>

    <!-- Page Content -->
    <div id="page-content-wrapper">

        <!-- Header -->
        <header class="header line">
            <a href="javascript:void(0);" class="btn btn-toggle" id="menu-toggle"><i class="fa fa-bars" aria-hidden="true"></i></a>
            <span class="header-title clearfix">Application version</span>
        </header>
        <!-- #End Header -->

        <section class="content container-fluid">
            <div class="background-01">

                <div class="mb20">
                    <a href="/app-version/add-version" class="btn btn-primary"><i class="fa fa-plus-circle mr10"></i>Add new version</a>
                </div>

                <table id="dataTable" class="table" width="100%" cellspacing="0">
                    <thead>
                    <tr>
                        <th>ID</th>
                        <th>Version</th>
                        <th>Title</th>
                        <th>Description</th>
                        <th>Date</th>
                        <th>Important</th>

                    </tr>
                    </thead>
                    <tfoot>
                    <tr>
                        <th>ID</th>
                        <th>Version</th>
                        <th>Title</th>
                        <th>Description</th>
                        <th>Date</th>
                        <th>Important</th>
                    </tr>
                    </tfoot>

                    <!-- Items list -->
                    <tbody>

                    <%if (appVersionList.size()>0){%>
                        <%for (AppVersion appVersion : appVersionList){%>

                            <%String editAppVersionUlr = "/app-version/edit-version/" + appVersion.getId();%>

                            <tr>
                                <td align="center"><%out.print(appVersion.getId());%></td>
                                <td align="center"><a href="<%out.print(editAppVersionUlr);%>"><%out.print(appVersion.getVersionName());%></a></td>
                                <td align="center"><%out.print(appVersion.getTitle());%></td>
                                <td align="center"><%out.print(appVersion.getDescription());%></td>
                                <td align="center"><%out.print(dateFormatShow.format(appVersion.getDate()));%></td>
                                <td align="center"><i class="<%if (appVersion.getImportant())out.print("fa fa-check-square"); else out.print("fa fa-square-o");%>"></i></td>
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