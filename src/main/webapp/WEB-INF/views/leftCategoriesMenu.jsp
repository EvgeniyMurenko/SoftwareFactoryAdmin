<%@ page import="com.SoftwareFactoryAdmin.model.ManagerInfo" %>
<%@ page import="com.SoftwareFactoryAdmin.model.Permission" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page session="false" %>

<!-- Sidebar -->
<div id="sidebar-wrapper">


    <%ManagerInfo currentManagerInfo =  (ManagerInfo)request.getSession().getAttribute("managerInfo");%>

    <%Permission currentPermission =  (Permission) request.getSession().getAttribute("managerPermission");%>

    <aside class="sidebar-nav">

        <!-- Logo -->

        <div class="logo"><a href="/dashboard/">소프트웨어<span>팩토리</span></a></div>
        <!-- #End Logo -->

        <!-- Customer -->
        <div class="customer">

            <div class="cust-thumbnail">
                <a href="javascript:void(0);">
                    <img src="<%out.print("/get-file/avatar/"+currentManagerInfo.getUser().getAvatarImage());%>" class="img-circle" alt="">
                </a>
            </div>
            <div class="information">
                <a href="javascript:void(0);">
                    <%if (currentManagerInfo != null){
                        out.print(currentManagerInfo.getName());
                    }else {
                        response.sendRedirect("/list");
                    }%>
                </a>
            </div>
            <div class="settings">
                <a href="/settings/"><i class="fa fa-cogs"></i> Settings</a>
                <a href="<c:url value="/logout" />"><i class="fa fa-sign-out"></i> Log Out</a>
            </div>

        </div>
        <!-- #End Customer -->


        <%HttpSession session = request.getSession();%>
        <%if (session != null){ %>
        <!-- Left categories -->
            <ul>
                <%if(currentPermission.getEstimatePermission()) {%>
                    <li><a href="/estimate/"><i class="fa fa-file-text" aria-hidden="true"></i> Estimates</a></li>
                <%} if (currentPermission.getCasePermission()) {%>
                    <li><a href="/cases/"><i class="fa fa-pie-chart" aria-hidden="true"></i> Cases</a></li>
                <%} if (currentPermission.getCustomerPermission()) {%>
                    <li><a href="/customer-mm/"><i class="fa fa-user" aria-hidden="true"></i> Customers</a></li>
                <%} if (currentPermission.getProjectsPermission()) {%>
                    <li><a href="/project-mm/"><i class="fa fa-archive" aria-hidden="true"></i> Projects Management</a></li>
                <%} if (currentPermission.getStaffPermission()) {%>
                    <li><a href="/membership-mm/"><i class="fa fa-users" aria-hidden="true"></i> Staff</a></li>
                <%} if (currentPermission.getNoticePermission()) {%>
                    <li><a href="/notice/"><i class="fa fa-list" aria-hidden="true"></i> Notices</a></li>
                <%} if (currentPermission.getSuperAdminPermission()) {%>
                    <li><a data-toggle="collapse" data-parent="#accordion" href="#collapse"><i class="fa fa-cog" aria-hidden="true"></i> Settings</a>
                        <div id="collapse" class="panel-collapse collapse">
                            <div class="background-02">
                                <ul class="dropdown ml15">
                                    <li><a href="/permission/"><i class="fa fa-lock" aria-hidden="true"></i> Manager Permission</a></li>
                                    <li><a href="/app-version/"><i class="fa fa-mobile" aria-hidden="true"></i></i>Aplication Permission</a></li>
                                </ul>
                            </div>
                        </div>
                <%}%>
                <%if (currentPermission.getLeaderGroup())%><li><a href="/group/leader/"><i class="fa fa-star" aria-hidden="true"></i></i> Leader Group</a></li>
                <%if (currentPermission.getMemberGroup())%><li><a href="/group/member/"><i class="fa fa-envelope-o" aria-hidden="true"></i></i> Member Group</a></li>
                <%if (currentPermission.getStaffGroup())%><li><a href="/group/staff/"><i class="fa fa-child" aria-hidden="true"></i></i> Staff Group</a></li>

                <li><a href="/toss/"><i class="fa fa-rocket" aria-hidden="true"></i> Toss</a></li>
            </ul>
            <!-- #End Left categories -->
        <%}else{
            response.sendRedirect("/list");
        }%>

        <div class="copyright">2017 &copy; Software Factory</div>
    </aside>

</div>
<!-- #End Sidebar -->

