<%@ page import="com.SoftwareFactoryAdmin.model.ManagerInfo" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page session="false" %>

<!-- Sidebar -->
<div id="sidebar-wrapper">

    <%ManagerInfo managerInfo =  (ManagerInfo)request.getSession().getAttribute("managerInfo");%>

    <aside class="sidebar-nav">

        <!-- Logo -->
        <div class="logo"><a href="/">소프트웨어<span>팩토리</span></a></div>
        <!-- #End Logo -->

        <!-- Customer -->
        <div class="customer">

            <div class="cust-thumbnail"><a href="javascript:void(0);"><img src="http://placehold.it/150x150" class="img-circle" alt=""></a></div>
            <div class="information">
                <a href="javascript:void(0);"><%out.print(managerInfo.getName());%></a>
            </div>
            <div class="settings">
                <a href="javascript:void(0);"><i class="fa fa-cogs"></i> Settings</a>
                <a href="<c:url value="/logout" />"><i class="fa fa-sign-out"></i> Log Out</a>
            </div>

        </div>
        <!-- #End Customer -->


        <%HttpSession session = request.getSession();%>
        <%if (session != null){ %>
        <!-- Left categories -->
            <ul>
                <li><a href="/estimate/"><i class="fa fa-file-text" aria-hidden="true"></i> Estimates</a></li>
                <li><a href="/cases/"><i class="fa fa-pie-chart" aria-hidden="true"></i> Cases</a></li>
                <li><a href="/customer-mm/"><i class="fa fa-user" aria-hidden="true"></i> Customers</a></li>
                <li><a href="/project-mm/"><i class="fa fa-archive" aria-hidden="true"></i> Projects Management</a></li>
                <li><a href="/membership-mm/"><i class="fa fa-users" aria-hidden="true"></i> Staff</a></li>
                <%if (managerInfo!= null && managerInfo.getId()==4) {%>
                    <li><a href="/notice/"><i class="fa fa-list" aria-hidden="true"></i> Notices</a></li>
                <%}%>
                <%--<li><a href=""><i class="fa fa-lock" aria-hidden="true"></i> Permissions</a></li>--%>
            </ul>
            <!-- #End Left categories -->
        <%}else{
            response.sendRedirect("/list");
        }%>

        <div class="copyright">2017 &copy; Software Factory</div>
    </aside>

</div>
<!-- #End Sidebar -->

