<%@ page import="java.util.List" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Collections" %>
<%@ page import="com.SoftwareFactoryAdmin.model.CustomerInfo" %>
<%@ page import="com.SoftwareFactoryAdmin.model.CustomerHistory" %>
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

    <title>Customer History List :: 소프트웨어팩토리</title>

    <%@ include file="styles.jsp" %>

</head>
<body>
<!-- Wrapper -->
<div id="wrapper">

    <!-- Sidebar -->
    <div id="sidebar-wrapper">
        <%CustomerInfo customerInfo = (CustomerInfo) request.getAttribute("customerInfo");%>
        <%SimpleDateFormat dateFormatShow = new SimpleDateFormat("yyyy-MM-dd HH:mm");%>
        <%List<CustomerHistory> customerHistories = customerInfo.getCustomerHistories();%>

        <%@ include file="leftCategoriesMenu.jsp" %>

    </div>
    <!-- #End Sidebar -->

    <!-- Page Content -->
    <section id="page-content-wrapper">

        <!-- Content section -->
        <section class="container-fluid content">
            <h3><i class="fa fa-tasks"></i>
                <%out.print(customerInfo.getName() + " :: History");%>
            </h3>

            <div class="mb20">
                <a href="/customer-mm/" class="btn btn-primary"><i class="fa fa-times-circle pr10"></i>Back to customers
                    list</a>
            </div>

            <div class="row">

                <div class="col-md-4">
                    <h4 class="mb10">Customer information</h4>
                    <section class="estimate-user-info">
                        <div class="name">Name: <%out.print(customerInfo.getName());%></div>
                        <div class="email">E-mail: <a
                                href="<%out.print(customerInfo.getEmail());%>"><%out.print(customerInfo.getEmail());%></a>
                        </div>
                        <div class="phone">Phone: <a
                                href="<%out.print(customerInfo.getPhone());%>"><%out.print(customerInfo.getPhone());%></a>
                        </div>
                    </section>

                    <br>


                    <form action="/customer-mm/add-review" method="post">
                        <div class="form-group">

                            <label class="control-label">Add review</label>

                            <textarea id="editor" name="description" rows="3"></textarea>

                            <input type="hidden" name="id" value="<%out.print(customerInfo.getId());%>">
                        </div>

                        <div class="form-group text-right">
                            <button type="submit" name="save" class="btn btn-primary"><i class="fa fa-check pr10"></i>
                                Add review
                            </button>
                        </div>
                    </form>
                </div>

                <div class="col-md-8">
                    <section class="cases-messages-section">
                        <br>

                        <% Collections.reverse(customerHistories);%>
                        <%for (CustomerHistory customerHistory : customerHistories) {%>
                            <div class="message-right">
                                <div class="clearfix message-header">
                                    <div class="title"><%out.print(customerHistory.getManagerName() + " ID - " + customerHistory.getManagerId());%></div>
                                    <div class="date"><%out.print(dateFormatShow.format(customerHistory.getDate()));%></div>
                                </div>
                                <% out.print(customerHistory.getText());%>
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

<%
    String isUpdated = request.getParameter("isUpdated");
    if (isUpdated != null) {
        String link = "/customer-mm/history/" + customerInfo.getId();
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

</body>
</html>
