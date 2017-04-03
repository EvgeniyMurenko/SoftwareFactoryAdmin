<%@ page import="com.SoftwareFactory.model.Estimate" %>
<%@ page import="java.util.List" %>
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

    <title>Estimates List :: 소프트웨어팩토리</title>

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

        <%List<Estimate> estimateList =  (List<Estimate>)request.getAttribute("estimates");%>
        <%SimpleDateFormat dateFormatShow = new SimpleDateFormat("yyyy-MM-dd HH:mm");%>

        <!-- Content section -->
        <section class="container-fluid content">
            <h3><i class="fa fa-file-text-o"></i>Estimates List</h3>

            <table id="dataTable" class="table table-striped table-bordered" width="100%" cellspacing="0">
                <thead>
                <tr>
                    <th>Estimate ID</th>
                    <th width="170">Date</th>
                    <th width="120">Price request</th>
                    <th width="120">Question request</th>
                    <th width="50">Status</th>
                </tr>
                </thead>
                <tfoot>
                <tr>
                    <th>Estimate ID</th>
                    <th>Date</th>
                    <th>Price request</th>
                    <th>Question request</th>
                    <th>Status</th>
                </tr>
                </tfoot>

                <!-- Items list -->
                <tbody>
                <%for (Estimate estimate : estimateList){%>
                    <tr>

                        <td><a href="<%out.print("/estimate/respond/" + estimate.getId()+"/");%>"><% out.print(estimate.getEstimateGeneratedId());%></a></td>
                        <td align="center"><%out.print(dateFormatShow.format(estimate.getDateRequest()));%></td>
                        <td align="center"><i class="<%if (estimate.isPriceRequest())out.print("fa fa-check-square"); else out.print("fa fa-square-o");%>"></i></td>
                        <td align="center"><i class="<%if (estimate.isQuestionRequest())out.print("fa fa-check-square"); else out.print("fa fa-square-o");%>"></i></td>
                        <td align="center"><i class="<%if (estimate.isRespond())out.print("fa fa-check-square"); else out.print("fa fa-square-o");%>"></i></td>
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
