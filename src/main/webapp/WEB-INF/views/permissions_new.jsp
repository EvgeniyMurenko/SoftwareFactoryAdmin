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

    <title>Permissions :: 소프트웨어팩토리</title>

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
            <a href="javascript:void(0);" class="btn btn-toggle" id="menu-toggle"><i class="fa fa-lock" aria-hidden="true"></i></a>
            <span class="header-title clearfix">Permissions</span>
        </header>
        <!-- #End Header -->

        <section class="content container-fluid">
            <div class="background-01">

                <table id="dataTable" class="table" width="100%" cellspacing="0">
                    <thead>
                    <tr>
                        <th>Manager name</th>
                        <th>Estimate</th>
                        <th>Case</th>
                        <th>Customer</th>
                        <th>Project</th>
                        <th>Staff</th>
                        <th>Notice</th>
                        <th>Permission</th>
                        <th>Translate</th>
                        <th width="150">Action</th>
                    </tr>
                    </thead>
                    <tfoot>
                    <tr>
                        <th>Manager name</th>
                        <th>Estimate</th>
                        <th>Case</th>
                        <th>Customer</th>
                        <th>Project</th>
                        <th>Staff</th>
                        <th>Notice</th>
                        <th>Permission</th>
                        <th>Translate</th>
                        <th width="150">Action</th>
                    </tr>
                    </tfoot>

                    <tbody>

                    <!-- Items list -->
                    <tr>
                        <td align="center">admin</td>
                        <td align="center"><input type="checkbox" checked></td>
                        <td align="center"><input type="checkbox" checked></td>
                        <td align="center"><input type="checkbox" checked></td>
                        <td align="center"><input type="checkbox" checked></td>
                        <td align="center"><input type="checkbox" checked></td>
                        <td align="center"><input type="checkbox" checked></td>
                        <td align="center"><input type="checkbox" checked></td>
                        <td align="center"><input type="checkbox" checked></td>
                        <td align="center">
                            <a href="1" data-toggle="tooltip" title="Save"><i class="fa fa-floppy-o" aria-hidden="true"></i> Save</a>

                        </td>
                    </tr>

                    <tr>
                        <td align="center">test manager</td>
                        <td align="center"><input type="checkbox" checked></td>
                        <td align="center"><input type="checkbox" checked></td>
                        <td align="center"><input type="checkbox" checked></td>
                        <td align="center"><input type="checkbox" checked></td>
                        <td align="center"><input type="checkbox" checked></td>
                        <td align="center"><input type="checkbox" checked></td>
                        <td align="center"><input type="checkbox" checked></td>
                        <td align="center"><input type="checkbox" checked></td>
                        <td align="center">
                            <a href="1" data-toggle="tooltip" title="Save"><i class="fa fa-floppy-o" aria-hidden="true"></i> Save</a>

                        </td>
                    </tr>

                    <tr>
                        <td align="center">kass</td>
                        <td align="center"><input type="checkbox" checked></td>
                        <td align="center"><input type="checkbox" checked></td>
                        <td align="center"><input type="checkbox" checked></td>
                        <td align="center"><input type="checkbox" checked></td>
                        <td align="center"><input type="checkbox" checked></td>
                        <td align="center"><input type="checkbox" checked></td>
                        <td align="center"><input type="checkbox" checked></td>
                        <td align="center"><input type="checkbox" checked></td>
                        <td align="center">
                            <a href="1" data-toggle="tooltip" title="Save"><i class="fa fa-floppy-o" aria-hidden="true"></i> Save</a>

                        </td>
                    </tr>

                    <tr>
                        <td align="center">maxxx</td>
                        <td align="center"><input type="checkbox" checked></td>
                        <td align="center"><input type="checkbox" checked></td>
                        <td align="center"><input type="checkbox" checked></td>
                        <td align="center"><input type="checkbox" checked></td>
                        <td align="center"><input type="checkbox" checked></td>
                        <td align="center"><input type="checkbox" checked></td>
                        <td align="center"><input type="checkbox" checked></td>
                        <td align="center"><input type="checkbox" checked></td>
                        <td align="center">
                            <a href="1" data-toggle="tooltip" title="Save"><i class="fa fa-floppy-o" aria-hidden="true"></i> Save</a>

                        </td>
                    </tr>

                </table>
            </div>
        </section>



    </div>
    <!-- #End Page Content -->

</div>

<%@ include file="javascript.jsp" %>

</body>
</html>