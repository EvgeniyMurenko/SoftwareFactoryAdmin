<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page session="false" %>

<aside class="sidebar-nav">
    <!-- Logo -->
    <div class="left-top-line logo"><a href="/">소프트웨어<span>팩토리</span></a></div>
    <!-- #End Logo -->

    <!-- Left categories -->
    <ul>
        <li><a href="/estimate/"><i class="fa fa-file-text-o" aria-hidden="true"></i> Estimate</a></li>
        <li><a href="/cases/"><i class="fa fa-pie-chart" aria-hidden="true"></i> Cases</a></li>

        <%HttpSession session = request.getSession();
        if (session != null && "ADMIN".equals(session.getAttribute("UserRole"))) {%>
            <li><a href="/staff/"><i class="fa fa-users" aria-hidden="true"></i> Staff</a></li>
        <%}%>
    </ul>
    <!-- #End Left categories -->

    <div class="copyright">2017 &copy; SoFAC</div>
</aside>

