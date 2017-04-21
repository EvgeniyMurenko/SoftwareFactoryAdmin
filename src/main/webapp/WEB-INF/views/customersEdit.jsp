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

    <title>Customer edit :: 소프트웨어팩토리</title>

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
    <div id="page-content-wrapper">

        <%@ include file="topLine.jsp" %>

        <!-- Content section -->
        <section class="container-fluid content">
            <h3><i class="fa fa-user"></i>Customer edit</h3>

            <form action="" method="post">
                <div class="row">
                    <div class="col-md-6">

                        <div class="form-group">
                            <label class="control-label">SSO ID</label>
                            <input type="text" class="form-control" placeholder="SSO ID" value="0001" disabled/>
                        </div>

                        <div class="form-group">
                            <label class="control-label">Name</label>
                            <input type="text" name="name" class="form-control" placeholder="Name" value=""/>
                        </div>

                        <div class="form-group">
                            <label class="control-label">E-mail</label>
                            <input type="email" name="email" class="form-control" placeholder="E-mail" value=""/>
                        </div>

                        <div class="form-group">
                            <label class="control-label">Phone</label>
                            <input type="text" name="phone" class="form-control" placeholder="Phone" value=""/>
                        </div>

                        <div class="form-group">
                            <label class="control-label">Company</label>
                            <input type="text" name="company" class="form-control" placeholder="Company" value=""/>
                        </div>

                        <div class="form-group">
                            <label class="control-label">WEB site</label>
                            <input type="text" name="site_link" class="form-control" placeholder="WEB site" value=""/>
                        </div>

                        <div class="form-group">
                            <label for="new_password">New password</label>
                            <input type="password" name="password" id="new_password" class="form-control" placeholder="New password" required/>
                        </div>

                        <div class="form-group">
                            <label for="confirm_password">Confirm new password</label>
                            <input type="password" name="confirm_password" id="confirm_password" class="form-control" placeholder="Confirm new password" required/>
                        </div>

                        <div class="form-group text-right">
                            <button type="submit" name="save" class="btn btn-primary"><i class="fa fa-check pr10"></i>Save</button>
                        </div>
                    </div>
                </div>
            </form>
        </section>
        <!-- Content section -->

    </div>
    <!-- #End Page-content -->

</div>
<!-- #End Wrapper -->

<%@ include file="footerJavaScript.jsp" %>


</body>
</html>