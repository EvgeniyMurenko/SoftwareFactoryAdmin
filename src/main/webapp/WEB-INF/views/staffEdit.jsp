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
                    out.print("Edit - " + staffInfo.getName());
                }else {
                    out.print("Add new staff");
                }%>
            </h3>

            <div class="mb20">
                <a href="<c:out value="/membership-mm/"/>" class="btn btn-primary"><i class="fa fa-times-circle pr10"></i>Back to staff list</a>
            </div>

            <%String formAction = "/membership-mm/saveStaff" ; if (!isNew) formAction = "/membership-mm/updateStaff" ;%>

            <form action="<%out.print(formAction);%>" method="post">
                <div class="row">
                    <div class="col-md-6">
                        <input type="hidden" name="id" value="<%if (!isNew)out.print(user.getId());%>">

                        <div class="form-group">
                            <label class="control-label">Name</label>
                            <input type="text" name="name" class="form-control" placeholder="Name" value="<%if (!isNew)out.print(staffInfo.getName());%>" />
                        </div>

                        <!-- Appointment time -->
                        <h4 class="mb10">Birth Date</h4>
                        <div class="form-group">
                            <div class="input-group date" id="datetimepicker">
                                <input type="text" name="birth_date" class="form-control" value="<%if (!isNew) out.print(staffInfo.getBirthDate());%>"/>
                                <span class="input-group-addon">
                                        <span class="glyphicon glyphicon-calendar"></span>
                                    </span>
                            </div>
                        </div>
                        <!-- #End Appointment time -->


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
                            <input type="password" name="password" id="new_password" class="form-control" value="<%if (!isNew) out.print(staffInfo.getUser().getPassword());%>" placeholder="New password"/>
                        </div>

                        <div class="form-group">
                            <label for="confirm_password">Confirm password</label>
                            <input type="password" name="confirm_password" id="confirm_password" class="form-control" value="<%if (!isNew) out.print(staffInfo.getUser().getPassword());%>" placeholder="Confirm password"/>
                        </div>

                        <%if (!isNew){%>


                        <div class="form-group">
                            <label class="control-label">Rating (0-5)</label>
                            <select name="rating" class="form-control" id="project">
                                <option value="0">Select Score</option>
                                <option value="1">1</option>
                                <option value="2">2</option>
                                <option value="3">3</option>
                                <option value="4">4</option>
                                <option value="5">5</option>
                            </select>
                        </div>
                            <div class="form-group">
                                <label class="control-label">Android level (0-10)</label>
                                <input type="number" min="0" max="10" name="android" class="form-control"
                                       value="<%out.print(staffInfo.getAndroid());%>"/>
                            </div>

                            <div class="form-group">
                                <label class="control-label">iOS level (0-10)</label>
                                <input type="number" min="0" max="10" name="ios" class="form-control"
                                       value="<%out.print(staffInfo.getiOs());%>"/>
                            </div>

                            <div class="form-group">
                                <label class="control-label">Java level (0-10)</label>
                                <input type="number" min="0" max="10" name="java" class="form-control"
                                       value="<%out.print(staffInfo.getJava());%>"/>
                            </div>

                            <div class="form-group">
                                <label class="control-label">PHP level (0-10)</label>
                                <input type="number" min="0" max="10" name="php" class="form-control"
                                       value="<%out.print(staffInfo.getPhp());%>"/>
                            </div>

                            <div class="form-group">
                                <label class="control-label">Javascript level (0-10)</label>
                                <input type="number" min="0" max="10" name="javascript" class="form-control"
                                       value="<%out.print(staffInfo.getJavascript());%>"/>
                            </div>

                            <div class="form-group">
                                <label class="control-label">C# level (0-10)</label>
                                <input type="number" min="0" max="10" name="c_sharp" class="form-control"
                                       value="<%out.print(staffInfo.getcSharp());%>"/>
                            </div>

                            <div class="form-group">
                                <label class="control-label">C++ level (0-10)</label>
                                <input type="number" min="0" max="10" name="c_plus_plus" class="form-control"
                                       value="<%out.print(staffInfo.getcPlusPlus());%>"/>
                            </div>

                            <div class="form-group">
                                <label class="control-label">Frontend(HTML - CSS) level (0-10)</label>
                                <input type="number" min="0" max="10" name="frontend" class="form-control"
                                       value="<%out.print(staffInfo.getFrontend());%>"/>
                            </div>

                            <div class="form-group">
                                <label class="control-label">Design level (0-10)</label>
                                <input type="number" min="0" max="10" name="design" class="form-control"
                                       value="<%out.print(staffInfo.getDesign());%>"/>
                            </div>

                        <%}%>
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