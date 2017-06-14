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

    <title>Managers permissions :: 소프트웨어팩토리</title>

    <%@ include file="styles.jsp" %>

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

        <!-- Content section -->
        <section class="container-fluid content">
            <h3><i class="fa fa-user"></i>Permissions</h3>

            <table id="dataTable" class="table table-striped table-bordered" width="100%" cellspacing="0">
                <thead>
                    <tr>
                        <th width="20">ID</th>
                        <th width="200">Manager</th>
                        <th>Permissions</th>
                        <th width="150">Action</th>
                    </tr>
                </thead>
                <tfoot>
                    <tr>
                        <th>ID</th>
                        <th>Manager</th>
                        <th>Permissions</th>
                        <th>Action</th>
                    </tr>
                </tfoot>

                <!-- Items list -->
                <tbody>
                    <tr>

                        <td align="center">1</td>
                        <td><a href="customersEdit.php">Tiger Nixon</a></td>

                        <!-- Permissions list -->
                        <td>
                            <form action="" method="post">
                                <div class="checkbox checkbox-inline pl5">
                                    <input id="permission_1" type="checkbox" checked/>
                                    <label for="permission_1">Estimate</label>
                                </div>

                                <div class="checkbox checkbox-inline pl5">
                                    <input id="permission_2" type="checkbox"/>
                                    <label for="permission_2">Cases</label>
                                </div>

                                <div class="checkbox checkbox-inline pl5">
                                    <input id="permission_3" type="checkbox" checked/>
                                    <label for="permission_3">Customers</label>
                                </div>

                                <div class="checkbox checkbox-inline pl5">
                                    <input id="permission_4" type="checkbox"/>
                                    <label for="permission_4">Staff</label>
                                </div>

                                <div class="pull-right clearfix"><button type="submit" class="btn btn-primary btn-sm"><i class="fa fa-check pr10"></i>Save</button></div>
                            </form>
                        </td>
                        <!-- #End Permissions list -->

                        <td align="center">
                            <a href="customersEdit.php" data-toggle="tooltip" title="Edit"><i class="fa fa-edit"></i> Edit</a>&nbsp; |&nbsp;
                            <a href="javascript:void(0);" data-toggle="tooltip" title="Delete" class="deleteConfirm"><i class="fa fa-trash"></i> Delete</a>
                        </td>
                    </tr>
                    <tr>
                        <td align="center">2</td>
                        <td><a href="customersEdit.php">Susan Smith</a></td>

                        <!-- Permissions list -->
                        <td>
                            <form action="" method="post">
                                <div class="checkbox checkbox-inline pl5">
                                    <input id="permission_1" type="checkbox" checked/>
                                    <label for="permission_1">Estimate</label>
                                </div>

                                <div class="checkbox checkbox-inline pl5">
                                    <input id="permission_2" type="checkbox" checked/>
                                    <label for="permission_2">Cases</label>
                                </div>

                                <div class="checkbox checkbox-inline pl5">
                                    <input id="permission_3" type="checkbox"/>
                                    <label for="permission_3">Customers</label>
                                </div>

                                <div class="checkbox checkbox-inline pl5">
                                    <input id="permission_4" type="checkbox" checked/>
                                    <label for="permission_4">Staff</label>
                                </div>

                                <div class="pull-right clearfix"><button type="submit" class="btn btn-primary btn-sm"><i class="fa fa-check pr10"></i>Save</button></div>
                            </form>
                        </td>
                        <!-- #End Permissions list -->

                        <td align="center">
                            <a href="customersEdit.php" data-toggle="tooltip" title="Edit"><i class="fa fa-edit"></i> Edit</a>&nbsp; |&nbsp;
                            <a href="javascript:void(0);" data-toggle="tooltip" title="Delete" class="deleteConfirm"><i class="fa fa-trash"></i> Delete</a>
                        </td>
                    </tr>
                </tbody>
                <!-- #End Items list -->

            </table>

        </section>
        <!-- Content section -->

    </div>
    <!-- #End Page-content -->

</div>
<!-- #End Wrapper -->

<%@ include file="javascript.jsp" %>

</body>
</html>