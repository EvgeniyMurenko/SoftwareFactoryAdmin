<%@ page import="com.SoftwareFactoryAdmin.model.Estimate" %>
<%@ page import="java.util.List" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="com.SoftwareFactoryAdmin.model.Case" %>
<%@ page import="com.SoftwareFactoryAdmin.constant.ProjectEnum" %>
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

    <title>Dashboard :: 소프트웨어팩토리</title>

    <%@ include file="styles.jsp" %>
</head>
<body>

<!-- Wrapper -->
<div id="wrapper">

    <%List<Estimate> estimateList =  (List<Estimate>)request.getAttribute("estimateList");%>
    <%List<Case> caseList =  (List<Case>)request.getAttribute("caseList");%>
    <%SimpleDateFormat dateFormatShow = new SimpleDateFormat("yyyy-MM-dd HH:mm");%>

    <%@ include file="leftCategoriesMenu.jsp" %>

    <!-- Page Content -->
    <div id="page-content-wrapper">

        <!-- Header -->
        <header class="header line">
            <a href="javascript:void(0);" class="btn btn-toggle" id="menu-toggle"><i class="fa fa-bars" aria-hidden="true"></i></a>
            <span class="header-title clearfix">Dashboard</span>
        </header>
        <!-- #End Header -->

        <section class="content container-fluid">

            <div class="row mb20">

                <div class="col-md-12">
                    <div class="background-01">
                        <h3>Welcome to Software Factory</h3>

                        <p>Having thought that software support should be done with funding more than 10 years ago.</p>
                        <p>It is a professional development agency company that has secured American standardization and multinational development capability by Good & Good</p>

                    </div>
                </div>

            </div>
            <%if (permission.getCasePermission()){%>
            <div class="row">

                <div class="col-md-6 mb20">

                    <!-- Last estimates -->
                    <div class="background-01">

                        <span class="content-title">Last estimates</span>

                        <table class="table" width="100%" cellspacing="0">

                            <thead>
                            <tr>
                                <th>Estimate ID</th>
                                <th>Date</th>
                                <th>Price</th>
                                <th>Question</th>
                                <th>Status</th>
                            </tr>
                            </thead>

                            <tbody>
                            <%int estimateSize = estimateList.size();%>
                            <%if(estimateSize>=3) estimateSize = 3;%>
                            <%for (int i = 0; i < estimateSize; i++){%>
                                <tr>
                                    <td><a href="<%out.print("/estimate/respond/" + estimateList.get(i).getId()+"/");%>"><%out.print(estimateList.get(i).getEstimateGeneratedId());%></a></td>
                                    <td align="center"><%out.print(dateFormatShow.format(estimateList.get(i).getDateRequest()));%></td>
                                    <td align="center"><i class="<%if (estimateList.get(i).isPriceRequest())out.print("fa fa-check-square"); else out.print("fa fa-square-o");%>"></i></td>
                                    <td align="center"><i class="<%if (estimateList.get(i).isQuestionRequest())out.print("fa fa-check-square"); else out.print("fa fa-square-o");%>"></i></td>
                                    <td align="center"><i class="<%if (estimateList.get(i).isRespond())out.print("fa fa-check-square"); else out.print("fa fa-square-o");%>"></i></td>
                                </tr>
                            <%}%>

                            </tbody>

                        </table>

                        <a href="/estimate/" class="btn btn-default mt10">Show all <i class="fa fa-angle-double-right pl5"></i></a>

                    </div>
                    <!-- #End Last estimates -->

                </div>
                <% } if (permission.getEstimatePermission()){%>
                <div class="col-md-6">

                    <!-- Last cases -->
                    <div class="background-01">

                        <span class="content-title">Last cases</span>

                        <table class="table" width="100%" cellspacing="0">

                            <thead>
                            <tr>
                                <th>Case ID</th>
                                <th>Project</th>
                                <th>Status</th>
                                <th>Date</th>
                                <th>Messages</th>
                            </tr>
                            </thead>

                            <tbody>
                            <%int caseSize = caseList.size();%>
                            <%if(caseSize>=3) caseSize = 3;%>
                            <%for (int i = 0; i < caseSize; i++){%>
                                <tr>
                                    <td align="center"><a href="<%out.print("/cases/" + caseList.get(i).getId()+"/");%>"><%out.print(caseList.get(i).getId());%></a></td>
                                    <td align="center">
                                        <a href="<%out.print("/project-mm/view-project/"+caseList.get(i).getProject().getId()+"/");%>">
                                            <% if (caseList.get(i).getProject().getProjectName().equals(ProjectEnum.projectNameNormal.getDbValue())) {
                                                out.print(ProjectEnum.projectNameNormal.getValue());
                                            }else if (caseList.get(i).getProject().getProjectName().equals(ProjectEnum.projectNameEstimate.getDbValue())) {
                                                out.print(ProjectEnum.projectNameEstimate.getValue());
                                            } else out.print(caseList.get(i).getProject().getProjectName()); %>
                                        </a>
                                    </td>
                                    <td align="center"><%out.print(caseList.get(i).getStatus());%></td>
                                    <td align="center"><%out.print(dateFormatShow.format(caseList.get(i).getCreationDate()));%></td>
                                    <td align="center"><%out.print(caseList.get(i).getMessages().size());%></td>
                                </tr>
                            <%}%>
                            </tbody>

                        </table>

                        <a href="/cases/" class="btn btn-default mt10">Show all <i class="fa fa-angle-double-right pl5"></i></a>

                    </div>
                    <!-- #End Last cases -->

                </div>
                <%}%>
            </div>

        </section>

    </div>
    <!-- #End Page Content -->

</div>

<%@ include file="javascript.jsp" %>

</body>
</html>
