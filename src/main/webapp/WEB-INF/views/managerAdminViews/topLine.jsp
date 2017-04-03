<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page session="false" %>

<!-- Top line -->
<header class="container-fluid top-line">
    <div class="text-left top-switcher pull-left">
        <a href="javascript:void(0);" class="btn btn-toggle" id="menu-toggle"><i class="fa fa-bars" aria-hidden="true"></i></a>
    </div>
    <div class="text-right">
        <ul class="nav navbar-nav navbar-right">
            <li class="dropdown">
                <a href="javascript:void(0);" class="dropdown-toggle avatar" data-toggle="dropdown"><i class="fa fa-user-o"></i></a>
                <ul class="dropdown-menu">
                    <li class="dropdown-menu-header text-center"><%out.print((String)request.getAttribute("managerAdminName"));%></li>
                    <li><a href="javascript:void(0);"><i class="fa fa-cog"></i> Settings</a></li>
                    <li><a href="<c:url value="/logout" />"><i class="fa fa-sign-out"></i> Logout</a></li>
                </ul>
            </li>
        </ul>
    </div>
</header>
<!-- #End Top line -->
