<%@ page import="java.util.List" %>
<%@ page import="com.SoftwareFactoryAdmin.model.StaffInfo" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="com.SoftwareFactoryAdmin.model.StaffHistory" %>
<%@ page import="java.util.Collections" %>
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

    <title>Toss conversation :: 소프트웨어팩토리</title>

    <%@ include file="styles.jsp" %>

</head>
<body>
<!-- Wrapper -->
<div id="wrapper">

    <%ManagerInfo  = (ManagerInfo) request.getAttribute("staffInfo");%>
    <%SimpleDateFormat dateFormatShow = new SimpleDateFormat("yyyy-MM-dd HH:mm");%>
    <%List<StaffHistory> staffHistories = staffInfo.getStaffHistories();%>

    <%@ include file="leftCategoriesMenu.jsp" %>

    <!-- Page Content -->
    <section id="page-content-wrapper">

        <!-- Header -->
        <header class="header line">
            <a href="javascript:void(0);" class="btn btn-toggle" id="menu-toggle"><i class="fa fa-bars" aria-hidden="true"></i></a>
            <span class="header-title clearfix"><%out.print(staffInfo.getName() + " :: History");%></span>
        </header>
        <!-- #End Header -->


        <!-- Content section -->
        <section class="container-fluid content">

            <div class="mb20">
                <a href="/membership-mm/" class="btn btn-primary"><i class="fa fa-users pr10"></i>Back to staff list</a>
            </div>

            <div class="row">

                <div class="col-md-5">
                    <h4 class="mb10">Staff information</h4>
                    <section class="estimate-user-info">
                   <%--     <div class="name">Name: <%out.print(staffInfo.getName());%></div>
                        <div class="email">E-mail: <a
                                href="<%out.print(staffInfo.getEmail());%>"><%out.print(staffInfo.getEmail());%></a>
                        </div>
                        <div class="phone">Phone: <a
                                href="<%out.print(staffInfo.getPhone());%>"><%out.print(staffInfo.getPhone());%></a>
                        </div>
                        <div class="name">Birth
                            date: <% out.print(dateFormatShow.format(staffInfo.getBirthDate())); %></div>--%>
                    </section>

                    <br>

                    <input id="rating" name="input" value="<%out.print(staffInfo.getRating());%>"
                           class="rating-loading">
                    <form action="/membership-mm/update-rating" method="post">
                        <div class="form-group">
                            <label class="control-label">Rating (0-5)</label>
                            <select name="rating" class="form-control" id="project">
                                <option value="0">Update rating</option>
                                <option value="1">1</option>
                                <option value="2">2</option>
                                <option value="3">3</option>
                                <option value="4">4</option>
                                <option value="5">5</option>
                            </select>
                        </div>

                        <input type="hidden" name="id" value="<%out.print(staffInfo.getId());%>">

                        <div class="form-group text-right">
                            <button type="submit" name="save" class="btn btn-primary"><i class="fa fa-check pr10"></i>Update
                                rating
                            </button>
                        </div>
                    </form>

                    <form action="/membership-mm/add-review" method="post">
                        <div class="form-group">

                            <label class="control-label">Add review</label>

                            <textarea id="editor" name="description" rows="3"></textarea>

                            <input type="hidden" name="id" value="<%out.print(staffInfo.getId());%>">
                        </div>

                        <div class="form-group text-right">
                            <button type="submit" name="save" class="btn btn-primary"><i class="fa fa-check pr10"></i>
                                Add review
                            </button>
                        </div>
                    </form>
                </div>

                <div class="col-md-7">
                    <section class="cases-messages-section">
                        <br>


                        <%Collections.reverse(staffHistories);%>
                        <%for (StaffHistory staffHistory : staffHistories) {%>

                        <div class="message-right">

                            <div class="clearfix message-header">
                                <div class="title"><%out.print(staffHistory.getManagerName() + " ID - " + staffHistory.getManagerId());%></div>
                                <div class="date"><%out.print(dateFormatShow.format(staffHistory.getDate()));%></div>
                            </div>

                            <% out.print(staffHistory.getText());%>

                        </div>

                        <%}%>
                    </section>
                </div>
            </div>
        </section>
        <!-- #End Page-content -->
</div>
<!-- #End Wrapper -->

<%@ include file="javascript.jsp" %>

<%--
<%
    String isUpdated = request.getParameter("isUpdated");
    if (isUpdated != null) {
        String link = "/membership-mm/history/" + staffInfo.getId();
%>
<script>
    jQuery(document).ready(function ($) {
        swal(
            'Success!',
            'Update',
            'success'
        );
        history.pushState(null, null, '<%out.print(link);%>');
    });
</script>
<%}%>
--%>

</body>
</html>
