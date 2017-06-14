<%@ page import="java.util.List" %>
<%@ page import="com.SoftwareFactoryAdmin.model.StaffInfo" %>
<%@ page import="com.SoftwareFactoryAdmin.model.User" %>
<%@ page import="java.text.SimpleDateFormat" %>
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
            <a href="javascript:void(0);" class="btn btn-toggle" id="menu-toggle"><i class="fa fa-bars" aria-hidden="true"></i></a>
            <span class="header-title clearfix">
                <%if (!isNew) {
                    out.print("Edit - " + staffInfo.getName());
                }else {
                    out.print("Add new staff");
                }%>
            </span>
        </header>
        <!-- #End Header -->

        <!-- Content section -->
        <section class="container-fluid content">

            <div class="mb20">
                <a href="/membership-mm/" class="btn btn-primary"><i class="fa fa-times-circle pr10"></i>Back to staff list</a>
            </div>

            <%String formAction = "/membership-mm/saveStaff" ; if (!isNew) formAction = "/membership-mm/updateStaff" ;%>

            <form class="form-horizontal" action="<%out.print(formAction);%>" method="post">
                <div class="col-md-8">

                    <input type="hidden" name="id" value="<%if (!isNew)out.print(user.getId());%>">

                    <div class="form-group">
                        <label class="col-sm-3 control-label">Name</label>
                        <div class="col-sm-9">
                            <input type="text" name="name" class="form-control" placeholder="Name"
                                   value="<%if (!isNew)out.print(staffInfo.getName());%>" <%if(isNew)out.print("required");%> />
                        </div>
                    </div>


                    <div class="form-group">
                        <label class="col-sm-3 control-label">BIRTH DATE</label>
                        <div class="col-sm-9">
                            <div class="input-group date" id="datetimepicker">
                                <%String date = "";
                                    if (!isNew) {
                                        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
                                        date = dateFormat.format(staffInfo.getBirthDate());
                                    }
                                %>
                                <input type="text" name="birth_date" class="form-control"
                                       value="<%out.print(date);%>"<%if(isNew)out.print("required");%>/>
                                <span class="input-group-addon">
                                        <span class="glyphicon glyphicon-calendar"></span>
                                </span>
                            </div>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-3 control-label">E-mail</label>
                        <div class="col-sm-9">
                            <input type="email" name="email" class="form-control" placeholder="E-mail"
                                   value="<%if (!isNew) out.print(staffInfo.getEmail());%>" <%if(isNew)out.print("required");%>/>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-3 control-label">Phone</label>
                        <div class="col-sm-9">
                            <input type="text" name="phone" class="form-control" placeholder="Phone"
                                   value="<%if (!isNew) out.print(staffInfo.getPhone());%>"<%if(isNew)out.print("required");%>/>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-3 control-label">New password</label>
                        <div class="col-sm-9">
                            <input type="password" name="password" id="new_password" class="form-control"
                                   value="<%if (!isNew) out.print(staffInfo.getUser().getPassword());%>" placeholder="New password"<%if(isNew)out.print("required");%>/>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-3 control-label">Confirm password</label>
                        <div class="col-sm-9">
                            <input type="password" name="confirm_password" id="confirm_password" class="form-control"
                                   value="<%if (!isNew) out.print(staffInfo.getUser().getPassword());%>" placeholder="Confirm password"<%if(isNew)out.print("required");%>/>
                        </div>
                    </div>

                    <%if (!isNew){%>

                        <div class="form-group">
                            <label class="col-sm-3 control-label">Android level (0-10)</label>
                            <div class="col-sm-9">
                                <input type="number" min="0" max="10" name="android" class="form-control"
                                       value="<%out.print(staffInfo.getAndroid());%>"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-3 control-label">iOS level (0-10)</label>
                            <div class="col-sm-9">
                                <input type="number" min="0" max="10" name="ios" class="form-control"
                                       value="<%out.print(staffInfo.getiOs());%>"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-3 control-label">IOT level (0-10)</label>
                            <div class="col-sm-9">
                                <input type="number" min="0" max="10" name="iot" class="form-control"
                                       value="<%out.print(staffInfo.getIot());%>"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-3 control-label">Java level (0-10)</label>
                            <div class="col-sm-9">
                                <input type="number" min="0" max="10" name="java" class="form-control"
                                       value="<%out.print(staffInfo.getJava());%>"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-3 control-label">PHP level (0-10)</label>
                            <div class="col-sm-9">
                                <input type="number" min="0" max="10" name="php" class="form-control"
                                       value="<%out.print(staffInfo.getPhp());%>"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-3 control-label">Javascript level (0-10)</label>
                            <div class="col-sm-9">
                                <input type="number" min="0" max="10" name="javascript" class="form-control"
                                       value="<%out.print(staffInfo.getJavascript());%>"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-3 control-label">C# level (0-10)</label>
                            <div class="col-sm-9">
                                <input type="number" min="0" max="10" name="c_sharp" class="form-control"
                                        value="<%out.print(staffInfo.getcSharp());%>"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-3 control-label">C++ level (0-10)</label>
                            <div class="col-sm-9">
                                <input type="number" min="0" max="10" name="c_plus_plus" class="form-control"
                                       value="<%out.print(staffInfo.getcPlusPlus());%>"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-3 control-label">Frontend(HTML - CSS) level (0-10)</label>
                            <div class="col-sm-9">
                                <input type="number" min="0" max="10" name="frontend" class="form-control"
                                       value="<%out.print(staffInfo.getFrontend());%>"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-3 control-label">Design level (0-10)</label>
                            <div class="col-sm-9">
                                <input type="number" min="0" max="10" name="design" class="form-control"
                                       value="<%out.print(staffInfo.getDesign());%>"/>
                            </div>
                        </div>

                    <%}%>

                    <div class="form-group">
                        <div class="col-md-3"></div>
                        <div class="col-md-9" align="right">
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

<%@ include file="javascript.jsp" %>

<%
    String isCreateUpdateSuccess =  request.getParameter("isCreateUpdateSuccess");
    String isPasswordError =  request.getParameter("isPasswordError");
    System.out.print("eroro?"+isPasswordError);
    if(isPasswordError != null){
        String link = "/membership-mm/create"; if(!isNew) link = "/membership-mm/edit/" + staffInfo.getId();
%>

<script>
    jQuery(document).ready(function ($) {
        swal(
            'Invalid password!',
            '',
            'error'
        );
         history.pushState(null, null, '<%out.print(link);%>');
    });
</script>
<%}
    if (isCreateUpdateSuccess !=null){
        String link = "/membership-mm/edit/" + staffInfo.getId();
%>
<script>
    jQuery(document).ready(function ($) {
        swal(
            'Success!',
            '',
            'success'
        );
        history.pushState(null, null, '<%out.print(link);%>');
    });
</script>
<%}%>

</body>
</html>