<%@ page import="com.SoftwareFactoryAdmin.model.Estimate" %>
<%@ page import="com.SoftwareFactoryAdmin.model.CustomerInfo" %>
<%@ page import="java.io.File" %>
<%@ page import="com.SoftwareFactoryAdmin.constant.GlobalEnum" %>
<%@ page import="com.SoftwareFactoryAdmin.model.EstimateLink" %>
<%@ page import="java.util.Set" %>
<%@ page import="java.text.SimpleDateFormat" %>
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

    <title>Estimate: 1706060003 :: 소프트웨어팩토리</title>

    <%@ include file="styles.jsp" %>
</head>
<body>

<!-- Wrapper -->
<div id="wrapper">

    <%@ include file="leftCategoriesMenu.jsp" %>

    <% Estimate estimate =(Estimate) request.getAttribute("estimate");%>
    <% CustomerInfo customerInfo = (CustomerInfo) request.getAttribute("customerInfo"); %>
    <%SimpleDateFormat dateFormatShow = new SimpleDateFormat("yyyy-MM-dd HH:mm");%>

    <!-- Page Content -->
    <div id="page-content-wrapper">

        <!-- Header -->
        <header class="header line">
            <a href="javascript:void(0);" class="btn btn-toggle" id="menu-toggle"><i class="fa fa-bars" aria-hidden="true"></i></a>
            <span class="header-title clearfix">Estimate: <%out.print(estimate.getEstimateGeneratedId());%></span>
        </header>
        <!-- #End Header -->

        <section class="content container-fluid">

            <div class="mb20">
                <a href="<c:out value="/estimate/"/>" class="btn btn-default"><i class="fa fa-times-circle pr5"></i> Cancel & Back</a>
            </div>

            <div class="background-01">

                <table class="table table-inside" width="100%" cellspacing="0">
                    <thead>
                    <tr>
                        <th>Estimate ID</th>
                        <th>Date</th>
                        <th>Price request</th>
                        <th>Question request</th>
                        <th>Status</th>
                    </tr>
                    </thead>

                    <tbody>
                    <tr>

                        <td><%out.print(estimate.getEstimateGeneratedId());%></td>
                        <td align="center"><%out.print(dateFormatShow.format(estimate.getDateRequest()));%></td>
                        <td align="center"><i class="<%if (estimate.isPriceRequest())out.print("fa fa-check-square"); else out.print("fa fa-square-o");%>"></i></td>
                        <td align="center"><i class="<%if (estimate.isQuestionRequest())out.print("fa fa-check-square"); else out.print("fa fa-square-o");%>"></i></td>
                        <td align="center"><i class="<%if (estimate.isRespond())out.print("fa fa-check-square"); else out.print("fa fa-square-o");%>"></i></td>
                    </tr>
                    </tbody>

                </table>

                <span class="content-title mt30">Estimate body</span>

                <div class="mb20">
                    <%out.print(estimate.getEstimateRequest());%>
                </div>

                <%Set<EstimateLink> estimateLinks = estimate.getEstimateLinks();%>
                <%if (!estimateLinks.isEmpty()) {%>
                    <span class="content-title mt30">Attach file</span>
                    <div class="mb20">
                        <%for (EstimateLink estimateLink : estimateLinks){
                            out.print("<a href="+ estimateLink.getFileLink()+">"+estimateLink.getFileName()+"</a><br>");
                        }%>
                    </div>
                <%}%>


                <span class="content-title">Estimate information</span>

                <div class="row">
                    <div class="col-md-3">
                        <h4>User information</h4>
                        <%if (customerInfo != null){%>
                            <div>Name: <%out.print(customerInfo.getName());%></div>
                            <div>E-mail: <%out.print(customerInfo.getEmail());%></div>
                            <div>Phone: <%out.print(customerInfo.getPhone());%></div>
                        <%}else {%>
                            <div>USER HAVE BEEN REMOVED</div>
                        <%}%>

                    </div>
                    <div class="col-md-9">
                        <%if (!estimate.isRespond() && customerInfo != null){%>
                            <h4>Estimate answer</h4>

                            <form action="/estimate/set-respond/" method="post" enctype="multipart/form-data">
                                <textarea class="form-control" name="message" id="editor"></textarea>

                                <input type="hidden" name="estimateId" value="<%out.print(estimate.getId());%>">

                                <!-- Attach files -->
                                <div class="form-group mt20">
                                    <input id="chatUpload" name="file[]" multiple type="file">
                                </div>
                                <!-- #End Attach files -->

                                <div class="form-group text-right mt30 mb0">
                                    <button type="submit" class="btn btn-primary"><i class="fa fa-paper-plane-o pr10"></i>Send answer</button>
                                    <a href="<c:out value="/estimate/"/>" class="btn btn-default"><i class="fa fa-chevron-left pr5"></i>Back</a>
                                </div>

                            </form>
                        <%}%>
                    </div>
                </div>

            </div>

        </section>

    </div>
    <!-- #End Page Content -->

</div>

<%@ include file="javascript.jsp" %>

</body>
</html>
