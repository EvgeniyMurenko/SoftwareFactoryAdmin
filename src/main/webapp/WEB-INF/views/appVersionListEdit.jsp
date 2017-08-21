<%@ page import="com.SoftwareFactoryAdmin.model.Case" %>
<%@ page import="java.util.List" %>
<%@ page import="com.SoftwareFactoryAdmin.constant.ProjectEnum" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="com.SoftwareFactoryAdmin.model.AppVersion" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page session="false" %>

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

    <title>Aplication managment :: 소프트웨어팩토리</title>

    <%@ include file="styles.jsp" %>

</head>
<body>

<!-- Wrapper -->
<div id="wrapper">

    <%AppVersion appVersion = (AppVersion) request.getAttribute("appVersion");%>
    <%boolean isNew = (boolean) request.getAttribute("isNew");%>
    <%String formAction = "/app-version/save-new-version";%>
    <%if(!isNew) formAction = "/app-version/update-version/"+appVersion.getId();%>

    <%@ include file="leftCategoriesMenu.jsp" %>

    <!-- Page Content -->
    <div id="page-content-wrapper">

        <!-- Header -->
        <header class="header line">
            <%String headTitle = "Create new version"; %>
            <%if (!isNew) headTitle = "V."+appVersion.getVersionName(); %>
            <a href="javascript:void(0);" class="btn btn-toggle" id="menu-toggle"><i class="fa fa-bars" aria-hidden="true"></i></a>
            <span class="header-title clearfix"><%out.print(headTitle+" update");%></span>
        </header>
        <!-- #End Header -->

        <!-- Content section -->
        <section class="container-fluid content">

            <div class="mb20">
                <a href="/app-version/" class="btn btn-primary"><i class="fa fa-times-circle pr10"></i>Cancel</a>
            </div>

            <form class="form-horizontal" action="<%out.print(formAction);%>" method="post" id="projectEditForm">
                <div class="col-md-8">

                    <%String versionName = ""; if (!isNew && !"".equals(appVersion.getVersionName())) versionName = appVersion.getVersionName();%>
                    <div class="form-group">
                        <label class="col-sm-3 control-label">Version name</label>
                        <div class="col-sm-9">
                            <input type="text" name="versionName" class="form-control" placeholder="Version name" value="<%out.print(versionName);%>" required/>
                        </div>
                    </div>

                    <%String versionCode = ""; if (!isNew && !"".equals(appVersion.getVersionName())) versionCode = appVersion.getVersionName();%>
                    <div class="form-group">
                        <label class="col-sm-3 control-label">Version code</label>
                        <div class="col-sm-9">
                            <input type="number" pattern="[0-9]" name="versionCode" class="form-control" placeholder="Version code" value="<%out.print(versionCode);%>" required/>
                        </div>
                    </div>

                    <%String title = ""; if (!isNew && !"".equals(appVersion.getTitle())) title = appVersion.getTitle();%>
                    <div class="form-group">
                        <label class="col-sm-3 control-label">Title</label>
                        <div class="col-sm-9">
                            <input type="text" name="title" class="form-control" placeholder="Title" value="<%out.print(title);%>" required/>
                        </div>
                    </div>

                    <%Boolean isImportant = false; if (!isNew && !"".equals(appVersion.getTitle())) isImportant = appVersion.getImportant();%>
                    <div class="form-group">
                        <label class="col-sm-3 control-label">Important</label>
                        <div class="col-sm-9">
                            <input type="checkbox" name="isImportant" <%if (isImportant) out.print("checked");%>/>
                        </div>
                    </div>

                    <%String description = ""; if (!isNew && !"".equals(appVersion.getDescription())) description = appVersion.getDescription();%>
                    <div class="form-group">
                        <label class="col-sm-3 control-label">Description</label>
                        <div class="col-sm-9">
                            <textarea id="editor" name="description" required><%out.print(description);%></textarea>
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
        <!-- Content section -->

    </div>
    <!-- #End Page-content -->

</div>

<%@ include file="javascript.jsp" %>

<% String isEditCreateSuccess = request.getParameter("isEditCreateSuccess"); %>
<% if (isEditCreateSuccess != null && isEditCreateSuccess.equals("true")) { %>
<script>
    jQuery(document).ready(function ($) {
        swal(
            'Success',
            'Version edit/create success',
            'success'
        );
    });
</script>
<% } %>

</body>
</html>