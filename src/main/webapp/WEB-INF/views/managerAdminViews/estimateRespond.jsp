<%@ page import="com.SoftwareFactory.model.Estimate" %>
<%@ page import="com.SoftwareFactory.model.CustomerInfo" %>
<%@ page import="java.io.File" %>
<%@ page import="com.SoftwareFactory.constant.GlobalEnum" %>
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

    <title>Estimate ID 1703270001 :: 소프트웨어팩토리</title>

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
            <% Estimate estimate =(Estimate) request.getAttribute("estimate");%>
            <% CustomerInfo customerInfo = (CustomerInfo) request.getAttribute("customerInfo"); %>

            <h3><i class="fa fa-file-text-o"></i>Estimate ID <%out.print(estimate.getEstimateGeneratedId());%></h3>

            <div class="mb20">
                <a href="<c:out value="/staff-cabinet/estimate"/>" class="btn btn-primary"><i class="fa fa-times-circle pr10"></i>Cancel write Estimate</a>
            </div>

            <div class="row">
                <!-- Estimate user -->
                <div class="col-md-3">

                    <h4 class="mb10">User information</h4>
                    <section class="estimate-user-info">
                        <div class="name">Name: <%out.print(customerInfo.getName());%></div>
                        <div class="email">E-mail: <a href="<%out.print(customerInfo.getEmail());%>"><%out.print(customerInfo.getEmail());%></a></div>
                        <div class="phone">Phone: <a href="<%out.print(customerInfo.getPhone());%>"><%out.print(customerInfo.getPhone());%></a></div>
                    </section>

                </div>
                <!-- #End Estimate user -->

                <!-- Estimate body -->
                <div class="col-md-9">
                    <h4 class="mb10">Estimate body</h4>
                    <section class="estimate-user-info"><%out.print(estimate.getEstimateRequest());%></section>

                    <% if (estimate.getEstimatePath()!=null) {
                        File directory = new File(estimate.getEstimatePath());
                        File[] files= directory.listFiles();
                        for (int i=0; i<files.length; i++){
                            String fileName =files[i].getName();
                            out.print("<br><a href="+ GlobalEnum.webRoot+"/download/"+estimate.getId()+"/"+fileName+"/"+">"+fileName+"</a>");
                        }
                    } %>
                    <%if (!estimate.isRespond()){%>
                        <form action="<%out.print("/staff-cabinet/set-respond/" + estimate.getId());%>?${_csrf.parameterName}=${_csrf.token}" method="post">
                            <h4 class="mb10 mt20">Estimate answer</h4>
                            <textarea class="form-control" name="message" id="editor"></textarea>

                            <div class="form-group text-right mt20">
                                <button type="submit" class="btn btn-primary"><i class="fa fa-paper-plane-o pr10"></i>Send answer</button>
                            </div>
                        </form>
                    <%}%>
                </div>
                <!-- #End Estimate body -->

            </div>

        </section>
        <!-- Content section -->

    </div>
    <!-- #End Page-content -->

</div>
<!-- #End Wrapper -->

<%@ include file="footerJavaScript.jsp" %>

</body>
</html>
