<%@ page import="com.SoftwareFactoryAdmin.model.Case" %>
<%@ page import="java.util.List" %>
<%@ page import="com.SoftwareFactoryAdmin.constant.ProjectEnum" %>
<%@ page import="java.text.SimpleDateFormat" %>
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

    <title>Task Message :: 소프트웨어팩토리</title>

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
            <span class="header-title clearfix">Task Message</span>
        </header>
        <!-- #End Header -->

        <section class="content container-fluid">

            <div class="mb10">
                <a href="" class="btn btn-primary"><i class="fa fa-folder-open" aria-hidden="true"></i> Reopen task</a>
                <a href="" class="btn btn-primary"><i class="fa fa-check-square-o" aria-hidden="true"></i> Done task</a>
            </div>


            <div class="col-sm-7 mt10" style="padding-left: 0px; !important;">
                <div class="background-01">
                    <div class="scrollable">

                        <div class="message-left">
                            <div class="clearfix message-header">
                                <div class="title">RAB 1</div>
                                <div class="date">2017-04-21 00:01:00</div>
                            </div>
                            <p>한국인이 가장 좋아하는 음식중의 하나인 삼겹살과 게장을 돌판 위에서 조화롭게 조리 할 수 있도록 연구 개발한 한국인을 위한 새로운 메뉴 입니다.</p>
                        </div>

                        <div class="message-right">
                            <div class="clearfix message-header">
                                <div class="title">BOSS</div>
                                <div class="date">2017-04-21 00:01:00</div>
                            </div>
                            <p>한국인이 가장 좋아하는 음식중의 하나인 삼겹살과 게장을 돌판 위에서 조화롭게 조리 할 수 있도록 연구 개발한 한국인을 위한 새로운 메뉴 입니다.</p>
                            <p>Best regards, Software Factory Team.</p>
                        </div>

                        <div class="message-left">
                            <div class="clearfix message-header">
                                <div class="title">RAB 2</div>
                                <div class="date">2017-04-21 00:01:00</div>
                            </div>
                            <p>한국인이 가장 좋아하는 음식중의 하나인 삼겹살과 게장을 돌판 위에서 조화롭게 조리 할 수 있도록 연구 개발한 한국인을 위한 새로운 메뉴 입니다.</p>
                        </div>

                        <div class="message-left">
                            <div class="clearfix message-header">
                                <div class="title">RAB 3</div>
                                <div class="date">2017-04-21 00:01:00</div>
                            </div>
                            <p>한국인이 가장 좋아하는 음식중의 하나인 삼겹살과 게장을 돌판 위에서 조화롭게 조리 할 수 있도록 연구 개발한 한국인을 위한 새로운 메뉴 입니다.</p>
                        </div>

                        <div class="message-left">
                            <div class="clearfix message-header">
                                <div class="title">RAB 1</div>
                                <div class="date">2017-04-21 00:01:00</div>
                            </div>
                            <p>한국인이 가장 좋아하는 음식중의 하나인 삼겹살과 게장을 돌판 위에서 조화롭게 조리 할 수 있도록 연구 개발한 한국인을 위한 새로운 메뉴 입니다.</p>
                        </div>

                        <div class="message-left">
                            <div class="clearfix message-header">
                                <div class="title">RAB </div>
                                <div class="date">2017-04-21 00:01:00</div>
                            </div>
                            <p>한국인이 가장 좋아하는 음식중의 하나인 삼겹살과 게장을 돌판 위에서 조화롭게 조리 할 수 있도록 연구 개발한 한국인을 위한 새로운 메뉴 입니다.</p>
                        </div>

                    </div>
                </div>
            </div>

            <div class="col-sm-5 mt10" style="padding-left: 0px; !important;">

                <form class="form-horizontal" action="" method="post">
                    <div class="background-01">
                        <h4>Write message</h4>
                        <!-- FULL TASK DESCRIPTION -->
                        <div class="form-group">
                            <div class="col-sm-12">
                                <textarea id="editor" name="description" rows="3"></textarea>
                            </div>
                        </div>
                        <!-- #End FULL TASK DESCRIPTION -->

                        <div class="form-group">
                            <!-- Attach files -->
                            <label class="col-sm-3 control-label">Attach File</label>
                            <div class="col-sm-9">
                                <input id="uploadFile" name="file[]" multiple type="file">
                            </div>
                            <!-- #End Attach files -->
                        </div>

                        <div class="form-group">
                            <div class="col-sm-12" align="right">
                                <button type="submit" name="save" class="btn btn-primary right"><i
                                        class="fa fa-envelope-o" aria-hidden="true"></i> Send
                                </button>
                            </div>
                        </div>


                    </div>
                </form>


            </div>

        </section>


    </div>
    <!-- #End Page Content -->

</div>

<%@ include file="javascript.jsp" %>

</body>
</html>