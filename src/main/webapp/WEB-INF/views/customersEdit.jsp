<%@ page import="com.SoftwareFactoryAdmin.model.CustomerInfo" %>
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

    <title>Customer edit :: 소프트웨어팩토리</title>

    <%@ include file="headerStyles.jsp" %>

</head>
<body>
<!-- Wrapper -->
<div id="wrapper">

    <%CustomerInfo customerInfo = (CustomerInfo) request.getAttribute("customerInfo");%>
    <%boolean isNew = (boolean) request.getAttribute("isNew");%>
    <%String formAction = "/customer-mm/save-new-customer";
    if(!isNew) formAction = "/customer-mm/update-customer";
    %>

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

            <%
                String headTitle = "Create new customer";
                if (!isNew) headTitle = customerInfo.getName();
            %>

            <h3><i class="fa fa-user"></i><%out.print(headTitle);%></h3>

            <form action="<%out.print(formAction);%>" method="post">
                <div class="row">
                    <div class="col-md-6">

                        <input type="hidden" name="id" value="<%if (!isNew)out.print(customerInfo.getUser().getId());%>">

                        <%if(!isNew){%>
                            <div class="form-group">
                                <label class="control-label">SSO ID</label>
                                <input type="text" class="form-control" placeholder="SSO ID" value="<%out.print(customerInfo.getUser().getSsoId());%>" disabled/>
                            </div>
                        <%}%>

                        <%String name = ""; if (!isNew && !"".equals(customerInfo.getName())) name = customerInfo.getName();%>
                        <div class="form-group">
                            <label class="control-label">Name</label>
                            <input type="text" name="name" class="form-control" placeholder="Name" value="<%out.print(name);%>"/>
                        </div>

                        <%String email = ""; if (!isNew && !"".equals(customerInfo.getEmail())) email = customerInfo.getEmail();%>
                        <div class="form-group">
                            <label class="control-label">E-mail</label>
                            <input type="email" name="email" class="form-control" placeholder="E-mail" value="<%out.print(email);%>"/>
                        </div>

                        <%String phone = ""; if (!isNew && !"".equals(customerInfo.getPhone())) phone = customerInfo.getPhone();%>
                        <div class="form-group">
                            <label class="control-label">Phone</label>
                            <input type="text" name="phone" class="form-control" placeholder="Phone" value="<%out.print(phone);%>"/>
                        </div>

                        <%String company = ""; if (!isNew && !"".equals(customerInfo.getCompany())) company = customerInfo.getCompany();%>
                        <div class="form-group">
                            <label class="control-label">Company</label>
                            <input type="text" name="company" class="form-control" placeholder="Company" value="<%out.print(company);%>"/>
                        </div>

                        <%String webSite = ""; if (!isNew && !"".equals(customerInfo.getWebsite())) webSite = customerInfo.getWebsite();%>
                        <div class="form-group">
                            <label class="control-label">WEB site</label>
                            <input type="text" name="site_link" class="form-control" placeholder="WEB site" value="<%out.print(webSite);%>"/>
                        </div>


                        <div class="form-group">
                            <label for="new_password">New password</label>
                            <input type="password" name="password" id="new_password" class="form-control" placeholder="New password" <%if(isNew)out.print("required");%>/>
                        </div>

                        <div class="form-group">
                            <label for="confirm_password">Confirm new password</label>
                            <input type="password" name="confirm_password" id="confirm_password" class="form-control" placeholder="Confirm new password" <%if(isNew)out.print("required");%>/>
                        </div>

                        <div class="form-group text-right">
                            <button type="submit" name="save" class="btn btn-primary"><i class="fa fa-check pr10"></i>Save</button>
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