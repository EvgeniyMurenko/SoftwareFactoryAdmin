<%@ page import="java.util.List" %>
<%@ page import="com.SoftwareFactoryAdmin.model.StaffInfo" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="com.SoftwareFactoryAdmin.model.StaffHistory" %>
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

    <title>Staff History List :: 소프트웨어팩토리</title>

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
    <section id="page-content-wrapper">

        <%@ include file="topLine.jsp" %>

        <%StaffInfo staffInfo = (StaffInfo) request.getAttribute("staffInfo");%>
        <%SimpleDateFormat dateFormatShow = new SimpleDateFormat("yyyy-MM-dd HH:mm");%>
        <%List<StaffHistory> staffHistories = staffInfo.getStaffHistories();%>
        <!-- Content section -->
        <section class="container-fluid content">
            <h3><i class="fa fa-tasks"></i>
                <%out.print(staffInfo.getName()+" :: History");%>
            </h3>

            <div class="mb20">
                <a href="/membership-mm/" class="btn btn-primary"><i class="fa fa-times-circle pr10"></i>Back to staff list</a>
            </div>

            <div class="row">

                <div class="col-md-4">
                    <h4 class="mb10">Staff information</h4>
                    <section class="estimate-user-info">
                        <div class="name">Name: <%out.print(staffInfo.getName());%></div>
                        <div class="email">E-mail: <a href="<%out.print(staffInfo.getEmail());%>"><%out.print(staffInfo.getEmail());%></a></div>
                        <div class="phone">Phone: <a href="<%out.print(staffInfo.getPhone());%>"><%out.print(staffInfo.getPhone());%></a></div>
                        <div class="name">Birth date: <% out.print(dateFormatShow.format(staffInfo.getBirthDate())); %></div>
                    </section>
                </div>

                <div class="col-md-8">
                    <section class="cases-messages-section">
                        <br>
                        <% for (StaffHistory staffHistory : staffHistories){%>
                            <%-- <div class="manager-message">--%>
                            <div class="manager-message">
                                <div class="clearfix border-bottom pb5 mb10">
                                    <div class="name"><%out.print(staffHistory.getManagerName() + " ID - " +staffHistory.getManagerId());%></div>
                                    <div class="date"><% out.print(dateFormatShow.format(staffHistory.getDate())); %></div>
                                </div>
                                <!-- Message body -->
                                <div class="description">
                                    <%  out.print(staffHistory.getText());%>
                                </div>
                                <!-- #End Message body -->
                            </div>

                        <%}%>
                    </section>
                </div>
            </div>
        </section>
    <!-- #End Page-content -->
    </div>
<!-- #End Wrapper -->

<%@ include file="footerJavaScript.jsp" %>

</body>
</html>

<%--              </section>

                  <div class="border-bottom mb20"></div>
                  <%String formAction = "/staff/addTaskToStaff/"+staffInfo.getUser();%>
                  <form action="<%out.print(formAction);%>?${_csrf.parameterName}=${_csrf.token}" method="post">

                      <h4 class="mb10">Task text</h4>

                      <div class="form-group">
                          <label class="control-label">Title</label>
                          <input type="text" name="title" class="form-control" placeholder="Title" />
                      </div>

                      <div class="form-group">
                          <textarea name="task" class="form-control" placeholder="Text task" rows="3"></textarea>
                      </div>

                      <div class="form-group text-right mt20">
                          <button type="submit" class="btn btn-primary"><i class="fa fa-paper-plane-o pr10"></i>Send
                              task
                          </button>
                      </div>

                  </form>

              </div>

          </div>


      </section>--%>
<!-- Content section -->
