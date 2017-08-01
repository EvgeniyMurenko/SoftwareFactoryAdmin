<%@ page import="java.util.List" %>
<%@ page import="com.SoftwareFactoryAdmin.util.AppMethods" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="com.SoftwareFactoryAdmin.model.*" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.SoftwareFactoryAdmin.comparator.TaskMessageByDateComparator" %>
<%@ page import="com.SoftwareFactoryAdmin.comparator.TossTaskMessagesByDateComparator" %>
<%@ page import="com.SoftwareFactoryAdmin.comparator.TossTaskByDateComparator" %>
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

    <title>Toss List :: 소프트웨어팩토리</title>

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
            <a href="javascript:void(0);" class="btn btn-toggle" id="menu-toggle"><i class="fa fa-bars"
                                                                                     aria-hidden="true"></i></a>
            <span class="header-title clearfix">Toss List</span>
        </header>
        <!-- #End Header -->

        <!-- Content section -->
        <section class="container-fluid content">
            <div class="background-01">


                <div class="mb20 inline-buttons">
                    <a href="/toss/open-task" class="btn btn-primary"><i class="fa fa-rocket pr10"></i>Create Toss </a>
                </div>

                <div class="buttons-container">

                    <div class="mb20 inline-buttons">
                        <a href="/toss/select/new-request" class="btn btn-primary"><i class="fa fa-warning pr10"></i>New request</a>
                    </div>
                    <div class="mb20 inline-buttons" >
                        <a href="/toss/select/processing" class="btn btn-primary"><i class="fa fa-play pr10"></i>Processing</a>
                    </div>
                    <div class="mb20 inline-buttons" >
                        <a href="/toss/select/pause" class="btn btn-primary"><i class="fa fa-pause pr10"></i>Pause</a>
                    </div>
                    <div class="mb20 inline-buttons" >
                        <a href="/toss/select/finish" class="btn btn-primary"><i class="fa fa-stop pr10"></i>Finish</a>
                    </div>
                </div>



                <table id="dataTable" class="table" width="100%" cellspacing="0">
                    <thead>
                    <tr>
                        <th width="20">ID</th>
                        <th>From </th>
                        <th>Now </th>
                        <th>Status</th>
                        <th>Title </th>
                        <th>End date </th>
                    </tr>
                    </thead>
                    <tfoot>
                    <tr>
                        <th>ID</th>
                        <th>From </th>
                        <th>Now </th>
                        <th>Status</th>
                        <th>Title </th>
                        <th>End date </th>
                    </tr>
                    </tfoot>

                    <!-- Items list -->
                    <tbody>

                    <%
                        SimpleDateFormat dateFormatShow = new SimpleDateFormat("yyyy-MM-dd HH:mm");
                        List<Toss> tosses = (List<Toss>) request.getAttribute("toss");

                        TossTaskByDateComparator tossTaskByDateComparator = new TossTaskByDateComparator();
                        for (Toss toss : tosses) {
                            String endDate = "Now!";
                            if (!toss.isNow()) endDate = dateFormatShow.format(toss.getEndDate());

                                ArrayList<TossTask> tasks = new ArrayList<>(toss.getTossTasks());
                                tasks.sort(tossTaskByDateComparator);
                    %>

                    <tr>
                        <td align="center"><%out.print(toss.getId());%></td>
                        <td align="center"><%out.print(toss.getManagerOpenedName());%></td>
                        <td align="center"><%out.print(tasks.get(0).getManagersEngaged());%></td>
                        <td align="center"><%out.print(toss.getStatus().toLowerCase());%></td>
                        <td align="center"><a href="<%out.print("/toss/toss-conversation/" + toss.getId());%>"><%out.print(AppMethods.trimString(toss.getTitle(), 15));%></a></td>
                        <td align="center"><%out.print(endDate);%></td>
                    </tr>
                    <%}%>
                    </tbody>
                    <!-- #End Items list -->

                </table>
            </div>
        </section>
        <!-- Content section -->

    </div>
    <!-- #End Page-content -->

</div>
<!-- #End Wrapper -->

<%@ include file="javascript.jsp" %>

</body>
</html>

