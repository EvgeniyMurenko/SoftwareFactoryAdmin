<%@ page import="com.SoftwareFactoryAdmin.model.CustomerInfo" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Iterator" %>
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

    <title>Customers list :: 소프트웨어팩토리</title>

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
            <h3><i class="fa fa-user"></i>Customers</h3>


            <div class="mb20">
                <a href="/customer-mm/add-customer" class="btn btn-primary"><i class="fa fa-plus-circle mr10"></i>Add new customer</a>
            </div>


            <table id="dataTable" class="table table-striped table-bordered" width="100%" cellspacing="0">
                <thead>
                    <tr>
                        <th width="20">ID</th>
                        <th>SSO ID</th>
                        <th>Date registration</th>
                        <th>Name</th>
                        <th>Company</th>
                        <th>E-mail</th>
                        <th>Phone</th>
                        <th>Type company</th>
                        <th width="150">Action</th>
                    </tr>
                </thead>
                <tfoot>
                    <tr>
                        <th width="20">ID</th>
                        <th>SSO ID</th>
                        <th>Date registration</th>
                        <th>Name</th>
                        <th>Company</th>
                        <th>E-mail</th>
                        <th>Phone</th>
                        <th>Type company</th>
                        <th width="150">Action</th>
                    </tr>
                </tfoot>


                <!-- Items list -->
                <tbody>

                    <%
                        ArrayList<CustomerInfo> customerInfoArrayList = (ArrayList<CustomerInfo>) request.getAttribute("customersList");

                        Iterator<CustomerInfo> customerInfoIterator = customerInfoArrayList.iterator();

                        while (customerInfoIterator.hasNext()) {

                            CustomerInfo customerInfo = customerInfoIterator.next();
                            if(customerInfo.isFullCreated()){

                                String editCustomerInfoUrl = "/customer-mm/edit-customer/"+customerInfo.getId();
                                String deleteCustomerInfoUrl = "/customer-mm/delete-customer/"+customerInfo.getId();

                    %>
                        <tr>
                            <td align="center"><%out.print(customerInfo.getId());%></td>
                            <td><a href="<%out.print(editCustomerInfoUrl);%>"><%out.print(customerInfo.getUser().getSsoId());%></a></td>
                            <td>Date registration</td>
                            <td><a href="<%out.print(editCustomerInfoUrl);%>"><%out.print(customerInfo.getName());%></a></td>
                            <td><%out.print(customerInfo.getCompany());%></td>
                            <td><a href="mailto:<%out.print(customerInfo.getEmail());%>"><%out.print(customerInfo.getEmail());%></a></td>
                            <td><a href=""><%out.print(customerInfo.getPhone());%></a></td>
                            <td><a href="">Type company</a></td>

                            <td align="center">
                                <a href="<%out.print(editCustomerInfoUrl);%>" data-toggle="tooltip" title="Edit"><i class="fa fa-edit"></i> Edit</a>&nbsp; |&nbsp;
                                <a href="<%out.print(deleteCustomerInfoUrl);%>" data-toggle="tooltip" title="Delete" class="deleteConfirm"><i class="fa fa-trash"></i> Delete</a>
                            </td>
                        </tr>
                        <%}%>
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