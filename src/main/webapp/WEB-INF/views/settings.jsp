<%@ page import="java.text.SimpleDateFormat" %>
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
    <meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1, user-scalable=no, minimal-ui"/>
    <meta name="format-detection" content="telephone=no"/>
    <meta name="format-detection" content="address=no"/>

    <meta name="description" content=""/>
    <meta name="keywords" content=""/>

    <title>Staff List :: 소프트웨어팩토리</title>

    <%@ include file="styles.jsp" %>

</head>
<body>
<!-- Wrapper -->
<div id="wrapper">


    <%SimpleDateFormat dateFormatShow = new SimpleDateFormat("yyyy-MM-dd HH:mm");%>

    <%@ include file="leftCategoriesMenu.jsp" %>

    <!-- Page Content -->
    <div id="page-content-wrapper">

        <!-- Header -->
        <header class="header line">
            <a href="javascript:void(0);" class="btn btn-toggle" id="menu-toggle"><i class="fa fa-cogs" aria-hidden="true"></i></a>
            <span class="header-title clearfix">Settings</span>
        </header>
        <!-- #End Header -->

        <section class="content container-fluid">

            <form class="form-horizontal" action="/settings/saveSettings/" method="post">
                <div class="col-md-8">

                    <div class="form-group">
                        <%String name = "";%>
                        <%if (currentManagerInfo.getName()!= null) name = currentManagerInfo.getName();%>
                        <label class="col-sm-3 control-label">Name</label>
                        <div class="col-sm-9">
                            <input type="text" name="name" class="form-control" value="<%out.print(name);%>" required/>
                        </div>
                    </div>

                    <div class="form-group">
                        <%String phone = "";%>
                        <%if (currentManagerInfo.getPhone()!=null) phone = currentManagerInfo.getPhone();%>
                        <label class="col-sm-3 control-label">Phone</label>
                        <div class="col-sm-9">
                            <input type="text" name="phone" class="form-control" value="<%out.print(phone);%>"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <%String email = "";%>
                        <%if (currentManagerInfo.getEmail()!= null) email = currentManagerInfo.getEmail();%>
                        <label class="col-sm-3 control-label">E-mail</label>
                        <div class="col-sm-9">
                            <input type="email" name="email" class="form-control" value="<%out.print(email);%>" required/>
                        </div>
                    </div>

                    <div class="form-group">
                        <%String birthday = "";%>
                        <%if (currentManagerInfo.getBirthday() != null) birthday = dateFormatShow.format(currentManagerInfo.getBirthday());%>
                        <!-- Appointment time -->
                        <label class="col-sm-3 control-label">Birthday</label>
                        <div class="col-sm-9">
                            <div class='input-group date' id='datetimepicker'>
                                <input type='text' name="birthday" class="form-control" value="<%out.print(birthday);%>"/>
                                <span class="input-group-addon">
                                    <span class="glyphicon glyphicon-calendar"></span>
                                </span>
                            </div>
                        </div>
                        <!-- #End Appointment time -->
                    </div>

                    <div class="form-group">
                        <label class="col-sm-3 control-label">New password</label>
                        <div class="col-sm-9">
                            <input type="password" name="newPassword" class="form-control" placeholder="New password" value=""/>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-3 control-label">Confirm password</label>
                        <div class="col-sm-9">
                            <input type="password" name="confirmNewPassword" class="form-control" placeholder="Confirm new password" value=""/>
                        </div>
                    </div>

                    <div class="form-group">
                        <div class="col-md-4"></div>
                        <div class="col-md-8" align="right">
                            <button type="submit" name="save" class="btn btn-primary"><i class="fa fa-check pr10"></i>Save
                            </button>
                        </div>
                    </div>
                </div>

            </form>

        </section>

    </div>
    <!-- #End Page Content -->

</div>
<!-- #End Wrapper -->

<%@ include file="javascript.jsp" %>

</body>
</html>

