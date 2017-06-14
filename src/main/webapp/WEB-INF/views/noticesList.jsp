<%@ page import="com.SoftwareFactoryAdmin.model.Notice" %>
<%@ page import="java.util.List" %>
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

    <title>Notices List :: 소프트웨어팩토리</title>

    <%@ include file="styles.jsp" %>

</head>
<body>
<!-- Wrapper -->
<div id="wrapper">

    <% List<Notice> noticeList =  (List<Notice>)request.getAttribute("noticeList");%>

    <%@ include file="leftCategoriesMenu.jsp" %>

    <!-- Page Content -->
    <div id="page-content-wrapper">

        <!-- Header -->
        <header class="header line">
            <a href="javascript:void(0);" class="btn btn-toggle" id="menu-toggle"><i class="fa fa-list" aria-hidden="true"></i></a>
            <span class="header-title clearfix">Notices List</span>
        </header>
        <!-- #End Header -->

        <section class="content container-fluid">
            <div class="background-01">

                <div class="mb20">
                    <a href="/notice/create/" class="btn btn-primary"><i class="fa fa-plus-circle mr10"></i>Add new notice</a>
                </div>

                <table id="dataTable" class="table" width="100%" cellspacing="0">
                    <thead>
                    <tr>
                        <th>ID</th>
                        <th>Name</th>
                        <th>Active</th>
                        <th>Action</th>
                    </tr>
                    </thead>
                    <tfoot>
                    <tr>
                        <th>ID</th>
                        <th>Name</th>
                        <th>Active</th>
                        <th>Action</th>
                    </tr>
                    </tfoot>
                    <!-- Items list -->
                    <tbody>
                    <%if (noticeList.size()> 0 ){%>
                        <%for (Notice notice : noticeList){%>
                            <tr>
                                <td align="center"><%out.print(notice.getId());%></td>
                                <td><a href="<%out.print("/notice/" + notice.getId()+"/edit/");%>"><%out.print(notice.getTitle());%></a></td>
                                <td align="center"><i class="<%if (notice.getActiv())out.print("fa fa-check-square"); else out.print("fa fa-square-o");%>"></i></td>
                                <td align="center">
                                    <a href="<%out.print("/notice/" + notice.getId()+"/edit/");%>" data-toggle="tooltip" title="Edit"><i class="fa fa-edit"></i> Edit</a>&nbsp; |&nbsp;
                                    <a href="<%out.print("/notice/noticeDelete/" + notice.getId()+"/");%>" data-toggle="tooltip" title="Delete" class="deleteConfirm"><i class="fa fa-trash"></i> Delete</a>
                                </td>
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
<!-- #End Wrapper -->

<%@ include file="javascript.jsp" %>

</body>
</html>
