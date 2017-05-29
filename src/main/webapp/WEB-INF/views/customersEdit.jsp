<%@ page import="com.SoftwareFactoryAdmin.model.CustomerInfo" %>
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

    <title>Customer edit :: 소프트웨어팩토리</title>

    <%@ include file="headerStyles.jsp" %>

</head>
<body>
<!-- Wrapper -->
<div id="wrapper">

    <%CustomerInfo customerInfo = (CustomerInfo) request.getAttribute("customerInfo");%>
    <%boolean isNew = (boolean) request.getAttribute("isNew");%>
    <%String formAction = "/customer-mm/save-new-customer";%>
    <%if(!isNew) formAction = "/customer-mm/update-customer";%>


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
            <%String headTitle = "Create new customer"; %>
            <%if (!isNew) headTitle = customerInfo.getName(); %>

            <h3><i class="fa fa-user"></i><%out.print(headTitle);%></h3>

            <div class="mb20">
                <a href="/customer-mm/" class="btn btn-primary"><i class="fa fa-times-circle pr10"></i>Cancel</a>
            </div>

            <form action="<%out.print(formAction);%>" method="post">
                <div class="row">
                    <div class="col-md-6">

                        <%if(!isNew){%>
                            <div class="form-group">
                                <div class="col-md-4">
                                    <div class="form-group">
                                        <label class="control-label">SSO ID</label>
                                    </div>
                                </div>
                                <div class="col-md-8">
                                    <div class="form-group">
                                        <input type="text" class="form-control" placeholder="SSO ID" value="<%out.print(customerInfo.getUser().getSsoId());%>" disabled/>
                                    </div>
                                </div>
                            </div>
                        <%}%>


                        <div class="form-group">
                            <div class="col-md-4">
                                <div class="form-group">
                                    <label class="control-label">Name Director</label>
                                </div>
                            </div>
                            <div class="col-md-8">
                                <div class="form-group">
                                    <input type="text" name="name_director" class="form-control" placeholder="Name" value=""/>
                                </div>
                            </div>
                        </div>

                        <%String company = ""; if (!isNew && !"".equals(customerInfo.getCompany())) company = customerInfo.getCompany();%>
                        <div class="form-group">
                            <div class="col-md-4">
                                <div class="form-group">
                                    <label class="control-label">Company</label>
                                </div>
                            </div>
                            <div class="col-md-8">
                                <div class="form-group">
                                    <input type="text" name="company" class="form-control" placeholder="Company" value="<%out.print(company);%>"/>
                                </div>
                            </div>
                        </div>

                        <div class="form-group">
                            <div class="col-md-4">
                                <div class="form-group">
                                    <label class="control-label">E-mail Director</label>
                                </div>
                            </div>
                            <div class="col-md-8">
                                <div class="form-group">
                                    <input type="email" name="email_director" class="form-control" placeholder="E-mail" value=""/>
                                </div>
                            </div>
                        </div>

                        <div class="form-group">
                            <div class="col-md-4">
                                <div class="form-group">
                                    <label class="control-label">Phone Director</label>
                                </div>
                            </div>
                            <div class="col-md-8">
                                <div class="form-group">
                                    <input type="text" name="phone_director" class="form-control" placeholder="Phone" value=""/>
                                </div>
                            </div>
                        </div>

                        <div class="form-group">
                            <div class="col-md-4">
                                <div class="form-group">
                                    <label class="control-label">Type company</label>
                                </div>
                            </div>
                            <div class="col-md-8">
                                <div class="form-group">
                                    <input type="text" name="type_company" class="form-control" placeholder="Type company" value=""/>
                                </div>
                            </div>
                        </div>

                        <div class="form-group">
                            <div class="col-md-4">
                                <div class="form-group">
                                    <label class="control-label">Address</label>
                                </div>
                            </div>
                            <div class="col-md-8">
                                <div class="form-group">
                                    <input type="text" name="address" class="form-control" placeholder="Address" value=""/>
                                </div>
                            </div>
                        </div>

                        <%String webSite = ""; if (!isNew && !"".equals(customerInfo.getWebsite())) webSite = customerInfo.getWebsite();%>
                        <div class="form-group">
                            <div class="col-md-4">
                                <div class="form-group">
                                    <label class="control-label">WEB site</label>
                                </div>
                            </div>
                            <div class="col-md-8">
                                <div class="form-group">
                                    <input type="text" name="site_link" class="form-control" placeholder="WEB site" value="<%out.print(webSite);%>"/>
                                </div>
                            </div>
                        </div>

                        <%String name = ""; if (!isNew && !"".equals(customerInfo.getName())) name = customerInfo.getName();%>
                        <div class="form-group">
                            <div class="col-md-4">
                                <div class="form-group">
                                    <label class="control-label">Name</label>
                                </div>
                            </div>
                            <div class="col-md-8">
                                <div class="form-group">
                                    <input type="text" name="name" class="form-control" placeholder="Name" value="<%out.print(name);%>"/>
                                </div>
                            </div>
                        </div>

                        <%String email = ""; if (!isNew && !"".equals(customerInfo.getEmail())) email = customerInfo.getEmail();%>
                        <div class="form-group">
                            <div class="col-md-4">
                                <div class="form-group">
                                    <label class="control-label">E-mail</label>
                                </div>
                            </div>
                            <div class="col-md-8">
                                <div class="form-group">
                                    <input type="email" name="email" class="form-control" placeholder="E-mail" value="<%out.print(email);%>"/>
                                </div>
                            </div>
                        </div>

                        <%String phone = ""; if (!isNew && !"".equals(customerInfo.getPhone())) phone = customerInfo.getPhone();%>
                        <div class="form-group">
                            <div class="col-md-4">
                                <div class="form-group">
                                    <label class="control-label">Phone</label>
                                </div>
                            </div>
                            <div class="col-md-8">
                                <div class="form-group">
                                    <input type="text" name="phone" class="form-control" placeholder="Phone" value="<%out.print(phone);%>"/>
                                </div>
                            </div>
                        </div>

                        <div class="form-group">
                            <div class="col-md-4">
                                <div class="form-group">
                                    <label class="control-label">New password</label>
                                </div>
                            </div>
                            <div class="col-md-8">
                                <div class="form-group">
                                    <input type="password" name="password" id="new_password" class="form-control" placeholder="New password" <%if(isNew)out.print("required");%>/>
                                </div>
                            </div>
                        </div>

                        <div class="form-group">
                            <div class="col-md-4">
                                <div class="form-group">
                                    <label class="control-label">Confirm new password</label>
                                </div>
                            </div>
                            <div class="col-md-8">
                                <div class="form-group">
                                    <input type="password" name="confirm_password" id="confirm_password" class="form-control" placeholder="Confirm new password" <%if(isNew)out.print("required");%>/>
                                </div>
                            </div>
                        </div>

                        <div class="form-group">
                            <div class="col-md-4">
                                <div class="form-group">
                                    <label for="selectApp">Account type</label>
                                </div>
                            </div>
                            <%
                                String type1 = "temporal";
                                String type2 = "standard";
                                if (!isNew && customerInfo.isStandardAccount()){
                                    type1 = "standard";
                                    type2 = "temporal";
                                }
                            %>
                            <div class="col-md-8">
                                <div class="form-group">
                                    <select id="selectApp" name="selectApp" class="form-control">
                                        <option value="<%out.print(type1);%>"><%out.print(type1);%></option>
                                        <option value="<%out.print(type2);%>"><%out.print(type2);%></option>
                                    </select>
                                </div>
                            </div>
                        </div>

                        <div class="form-group">
                            <div class="col-md-4"></div>
                            <div class="col-md-8" align="right">
                                <button type="submit" name="save" class="btn btn-primary"><i class="fa fa-check pr10"></i>Save</button>
                            </div>
                        </div>
                    </div>
                </div>
            </form>
        </section>
        <!-- Content section -->

    </div>
    <!-- #End Page-content -->

</div>
<!-- #End Wrapper -->

<%@ include file="footerJavaScript.jsp" %>
<% String isPasswordError = request.getParameter("isPasswordError");
System.out.print(isPasswordError);%>
<% if (isPasswordError != null && isPasswordError.equals("true")) { %>
<script>
    jQuery(document).ready(function ($) {
        swal(
            'Password error',
            'Password do not match',
            'error'
        );
    });
</script>
<% } %>

<% String isEditCreateSuccess = request.getParameter("isEditCreateSuccess"); %>
<% if (isEditCreateSuccess != null && isEditCreateSuccess.equals("true")) { %>
<script>
    jQuery(document).ready(function ($) {
        swal(
            'Success',
            'Customer edit/create success',
            'success'
        );
    });
</script>
<% } %>

</body>
</html>