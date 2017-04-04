<%@ page import="com.SoftwareFactory.model.Notice" %>
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
            <h3><i class="fa fa-users"></i>Notices List</h3>

            <div class="mb20">
                <a href="/notice/create" class="btn btn-primary"><i class="fa fa-plus-circle pr10"></i>Add new Notice</a>
            </div>

            <% List<Notice> noticeList =  (List<Notice>)request.getAttribute("noticeList");%>

            <table id="dataTable" class="table table-striped table-bordered" width="100%" cellspacing="0">
                <thead>
                <tr>
                    <th width="20">ID</th>
                    <th>Name</th>
                    <th width="50">Active</th>
                    <th width="150">Action</th>
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
                <% if (noticeList.size()> 0 ){
                    for (Notice notice : noticeList){%>
                        <tr>
                            <td align="center"><%out.print(notice.getId());%></td>
                            <td><a href="<%out.print("/notice/" + notice.getId()+"/edit/");%>"><%out.print(notice.getTitle());%></a></td>
                            <td align="center"><i class="<%if (notice.getActiv())out.print("fa fa-check-square"); else out.print("fa fa-square-o");%>"></i></td>
                            <td align="center">
                                <a href="<%out.print("/notice/" + notice.getId()+"/edit/");%>" data-toggle="tooltip" title="Edit"><i class="fa fa-edit"></i> Edit</a>&nbsp; |&nbsp;
                                <a href="<%out.print("/notice/noticeDelete/" + notice.getId()+"/");%>" data-toggle="tooltip" title="Delete" class="deleteConfirm"><i class="fa fa-trash"></i> Delete</a>
                            </td>
                        </tr>
                    <%}
                }%>
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
