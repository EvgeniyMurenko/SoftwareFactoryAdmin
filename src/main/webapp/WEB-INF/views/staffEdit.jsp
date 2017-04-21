<%@ page import="java.util.List" %>
<%@ page import="com.SoftwareFactoryAdmin.model.StaffInfo" %>
<%@ page import="com.SoftwareFactoryAdmin.model.User" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page language="java" pageEncoding="UTF-8" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page session="false" %>

<!DOCTYPE html>
<html lang="kr">

<%StaffInfo staffInfo = (StaffInfo) request.getAttribute("staffInfo");%>
<%User user = (User) request.getAttribute("user");%>
<%boolean isNew = (boolean) request.getAttribute("isNew");%>

<head>
    <meta charset="utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta name="viewport"
          content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1, user-scalable=no, minimal-ui"/>
    <meta name="format-detection" content="telephone=no"/>
    <meta name="format-detection" content="address=no"/>

    <meta name="description" content=""/>
    <meta name="keywords" content=""/>

    <title>
        <%if (!isNew) {
            out.print(staffInfo.getName()+" :: Edit");
        }else {
            out.print("Add new staff");
        }%>

    </title>

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
            <h3><i class="fa fa-user"></i>
                <%if (!isNew) {
                    out.print(staffInfo.getName());
                }else {
                    out.print("Add new staff");
                }%>
            </h3>

            <div class="mb20">
                <a href="<c:out value="/staff/"/>" class="btn btn-primary"><i class="fa fa-times-circle pr10"></i>Back</a>
            </div>

            <form action="/staff/saveStaff?${_csrf.parameterName}=${_csrf.token}" method="post">
                <div class="row">
                    <div class="col-md-6">
                        <input type="hidden" name="id" value="<%if (!isNew)out.print(user.getId());%>">
                        <%if (!isNew){%>
                            <input type="hidden" name="name" value="<%if (!isNew)out.print(staffInfo.getName());%>" />
                        <%} else {%>
                            <div class="form-group">
                                <label class="control-label">Name</label>
                                <input type="text" name="name" class="form-control" placeholder="Name" />
                            </div>
                        <%}%>

                        <div class="form-group">
                            <label class="control-label">Login</label>
                            <input type="text" name="login" class="form-control" placeholder="Login" value="<%if (!isNew) out.print(user.getSsoId());%>"/>
                        </div>

                        <div class="form-group">
                            <label class="control-label">E-mail</label>
                            <input type="email" name="email" class="form-control" placeholder="E-mail"
                                   value="<%if (!isNew) out.print(staffInfo.getEmail());%>"/>
                        </div>

                        <div class="form-group">
                            <label class="control-label">Phone</label>
                            <input type="text" name="phone" class="form-control" placeholder="Phone"
                                   value="<%if (!isNew) out.print(staffInfo.getPhone());%>"/>
                        </div>

                        <div class="form-group delimiter mt10">
                            <label for="new_password">New password</label>
                            <input type="password" name="password" id="new_password" class="form-control" placeholder="New password"/>
                        </div>

                        <div class="form-group">
                            <label for="confirm_password">Confirm password</label>
                            <input type="password" name="confirm_password" id="confirm_password" class="form-control" placeholder="Confirm password"/>
                        </div>

                        <div class="form-group text-right">
                            <button type="submit" name="save" class="btn btn-primary"><i class="fa fa-check pr10"></i>Save
                            </button>
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

</body>
</html>