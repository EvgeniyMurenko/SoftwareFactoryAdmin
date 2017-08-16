<%@ page import="java.util.List" %>
<%@ page import="com.SoftwareFactoryAdmin.model.StaffInfo" %>
<%@ page import="jdk.nashorn.internal.ir.RuntimeNode" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %>
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

    <title>To Do Open Task :: 소프트웨어팩토리</title>

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
            <span class="header-title clearfix">Open TOSS</span>
        </header>
        <!-- #End Header -->


        <%
            List<ManagerInfo> managerInfos = (List<ManagerInfo>) request.getAttribute("managerInfos");
        %>

        <!-- Content section -->
        <section class="container-fluid content">

            <div class="mb20">
                <a href="/toss/" class="btn btn-primary"><i class="fa fa-times-circle pr10"></i>Cancel</a>
            </div>

            <form action="/toss/open" method="post" class="form-horizontal"  enctype="multipart/form-data">
                <div class="col-md-8">

                    <div class="form-group">
                        <label class="col-sm-3 control-label">Title</label>
                        <div class="col-sm-9">
                            <input type="text" name="title" class="form-control" placeholder="Title"
                                   value="" required>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-3 control-label">End Date</label>
                        <div class="col-sm-7">
                            <div class="input-group date" id="datetimepicker">
                                <%
                                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
                                    String date = dateFormat.format(new Date());
                                %>
                                <input type="text" name="end_date" id="end_date" class="form-control"
                                       value="<%out.print(date);%>"/>
                                <span class="input-group-addon">
                                        <span class="glyphicon glyphicon-calendar"></span>
                                </span>
                            </div>
                        </div>

                        <label class="col-sm-2 control-label">
                            Now &emsp; &emsp;
                            <input type="checkbox" id="is_now_checkbox" name="is_now_checkbox" onclick="select_now()">
                        </label>


                    </div>


                    <div class="form-group">
                        <label class="col-sm-3 control-label">Persons</label>
                        <div class="col-sm-9">
                            <select class="js-example-basic-multiple " name="persons" multiple="multiple" required
                                    style="width:100%;">
                                <%for (ManagerInfo managerInfo : managerInfos) {%>
                                <option value="<%out.print(managerInfo.getId());%>"><%
                                    out.print(managerInfo.getName());%></option>
                                <%}%>
                            </select>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-3 control-label">Attach Files</label>
                        <div class="col-sm-9">
                            <input id="chatUpload" name="file[]" multiple type="file">
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-3 control-label">Toss Text</label>
                        <div class="col-sm-9">
                            <textarea class="form-control" name="text" id="editor"></textarea>
                        </div>
                    </div>

                    <div class="form-group text-right ">
                        <button type="submit" class="btn btn-primary btn-submit"><i class="fa fa-paper-plane-o pr10"></i>Send Toss
                        </button>
                    </div>
                </div>
            </form>
        </section>
    </div>
</div>
<!-- #End Page-content -->


<!-- #End Wrapper -->

<%@ include file="javascript.jsp" %>
<script>
    function select_now() {

        var isNowCheckbox = document.querySelector('input[id="is_now_checkbox"]');

        if (isNowCheckbox.checked) {
            $('#end_date').attr('readonly', true);
        } else {
            $('#end_date').attr('readonly', false);
        }
    }
</script>
</body>
</html>
