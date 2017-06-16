<%@ page import="com.SoftwareFactoryAdmin.model.CustomerInfo" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page language="java" pageEncoding="UTF-8" %>
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

    <title>Customers Management :: 소프트웨어팩토리</title>

    <%@ include file="styles.jsp" %>

</head>
<body>

<!-- Wrapper -->
<div id="wrapper">

    <% ArrayList<CustomerInfo> customerInfoArrayList = (ArrayList<CustomerInfo>) request.getAttribute("customersList");%>
    <%SimpleDateFormat dateFormatShow = new SimpleDateFormat("yyyy-MM-dd HH:mm");%>

    <%@ include file="leftCategoriesMenu.jsp" %>

    <!-- Page Content -->
    <div id="page-content-wrapper">

        <!-- Header -->
        <header class="header line">
            <a href="javascript:void(0);" class="btn btn-toggle" id="menu-toggle"><i class="fa fa-bars" aria-hidden="true"></i></a>
            <span class="header-title clearfix">Customers Management</span>
        </header>
        <!-- #End Header -->

        <section class="content container-fluid">
            <div class="background-01">

                <div class="mb20">
                    <a href="/customer-mm/add-customer" class="btn btn-primary"><i class="fa fa-plus-circle mr10"></i>Add new customer</a>
                </div>

                <table id="dataTable" class="table" width="100%" cellspacing="0">
                    <thead>
                    <tr>
                        <th>ID</th>
                        <th>SSO ID</th>
                        <th>Date registration</th>
                        <th>Name director</th>
                        <th>Company</th>
                        <th>E-mail director</th>
                        <th>Phone director</th>
                        <th>Type company</th>
                        <th width="150">Action</th>
                    </tr>
                    </thead>
                    <tfoot>
                    <tr>
                        <th>ID</th>
                        <th>SSO ID</th>
                        <th>Date registration</th>
                        <th>Name director</th>
                        <th>Company</th>
                        <th>E-mail director</th>
                        <th>Phone director</th>
                        <th>Type company</th>
                        <th>Action</th>
                    </tr>
                    </tfoot>

                    <tbody>

                    <%for (CustomerInfo customerInfo: customerInfoArrayList){%>
                        <%if (customerInfo.isFullCreated() && !customerInfo.getUser().isDelete()) {%>
                            <%String editCustomerInfoUrl = "/customer-mm/edit-customer/" + customerInfo.getId();%>
                            <%String customerInfoHistory = "/customer-mm/history/" + customerInfo.getId();%>
                            <!-- Items list -->
                            <tr>
                                <td align="center"><%out.print(customerInfo.getId());%></td>
                                <td align="center"><a href="<%out.print(editCustomerInfoUrl);%>"><%out.print(customerInfo.getUser().getSsoId());%></a></td>
                                <td align="center"><%out.print(dateFormatShow.format(customerInfo.getRegistrationDate()));%></td>
                                <td align="center"><a href="<%out.print(customerInfoHistory);%>">
                                    <%if (!"".equals(customerInfo.getDirectorsName())) {
                                        out.print(customerInfo.getDirectorsName());
                                    } else {
                                        out.print("-");
                                    }%>
                                </a></td>
                                <td align="center"><%out.print(customerInfo.getCompany());%></td>

                                <td align="center"><a onclick="getCustomerProject(<%out.print(customerInfo.getId());%>)">
                                    <%if (!"".equals(customerInfo.getDirectorsEmail())) {
                                        out.print(customerInfo.getDirectorsEmail());
                                    } else {
                                        out.print("-");
                                    }%>
                                </a></td>

                                <td align="center">
                                    <%if (!"".equals(customerInfo.getDirectorsPhone())) {
                                        out.print(customerInfo.getDirectorsPhone());
                                    } else {
                                        out.print("-");
                                    }%>
                                </td>
                                <td align="center">
                                    <%if (!"".equals(customerInfo.getCompanyType())) {
                                        out.print(customerInfo.getCompanyType());
                                    } else {
                                        out.print("-");
                                    }%>
                                </td>

                                <td align="center">
                                    <a href="/customer-mm/edit-customer/<%out.print(customerInfo.getId());%>" data-toggle="tooltip" title="Edit"><i
                                            class="fa fa-edit"></i> Edit</a>&nbsp; |&nbsp;
                                    <a href="/customer-mm/delete-customer/<%out.print(customerInfo.getId());%>" data-toggle="tooltip" title="Delete"
                                       class="deleteConfirm"><i class="fa fa-trash"></i> Delete</a>
                                </td>
                            </tr>
                        <%}%>
                    <%}%>
                </table>
            </div>
        </section>



    </div>
    <!-- #End Page Content -->

</div>


<div class="modal fade" id="showInfo1">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header">
                <button class="close" type="button" data-dismiss="modal">
                    <i class="fa fa-close"></i>
                </button>
                <h4 class="modal-title" id="customerSoid_json"></h4>
            </div>
            <div class="modal-body">
                <table class="table" width="100%" cellspacing="0">
                    <thead>
                    <tr>
                        <th>Project name</th>
                        <th>Start Date</th>
                        <th>End Date</th>
                        <th>PM name</th>
                        <th>PM E-mail</th>
                        <th>PM Phone</th>
                    </tr>
                    </thead>

                    <!-- Items list -->
                    <tbody id="modalTable">

                    </tbody>
                    <!-- #End Items list -->

                </table>

            </div>
            <div class="modal-footer">
                <button data-toggle="modal" data-target="#showInfo2" data-dismiss="modal" class="btn btn-primary"><i class="fa fa-plus-circle pr5"></i> Add project</button>
                <button class="btn btn-default" type="button" data-dismiss="modal"><i class="fa fa-times-circle pr5"></i> Close</button>
            </div>
        </div>
    </div>
</div>

<!-- Add project modal -->
<div class="modal fade" id="showInfo2">
    <div class="modal-dialog modal-lg">
        <form class="form-horizontal" action="/project-mm/save-new-project/?${_csrf.parameterName}=${_csrf.token}" method="post" id="projectEditForm">
            <div class="modal-content">
                <div class="modal-header">
                    <button class="close" type="button" data-dismiss="modal">
                        <i class="fa fa-close"></i>
                    </button>
                    <h4 class="modal-title">Add project</h4>
                </div>
                <div class="modal-body">

                    <div id="customerSoid"></div>

                    <div class="form-group">
                        <label class="col-sm-3 control-label">Project name</label>
                        <div class="col-sm-9">
                            <input type="text" name="projectName" class="form-control" placeholder="Project name" value=""/>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-3 control-label">PM name</label>
                        <div class="col-sm-9">
                            <input type="text" name="pmName" class="form-control" placeholder="Write PM name" value=""/>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-3 control-label">PM E-mail</label>
                        <div class="col-sm-9">
                            <input type="text" name="pmEmail" class="form-control" placeholder="Write PM e-mail" value=""/>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-3 control-label">PM phone</label>
                        <div class="col-sm-9">
                            <input type="text" name="pmPhone" class="form-control" placeholder="Write PM phone" value=""/>
                        </div>
                    </div>


                    <div class="form-group">
                        <label class="col-sm-3 control-label">Select status</label>
                        <div class="col-sm-9">
                            <select id="selectStatus" name="selectStatus" class="form-control">
                                <option value="OPEN">OPEN</option>
                                <option value="START">START</option>
                                <option value="CONSIDERED">CONSIDERED</option>
                                <option value="END">END</option>
                                <option value="CLOSE">CLOSE</option>
                            </select>
                        </div>
                    </div>

                    <div class="form-group">
                        <!-- Appointment time -->
                        <label class="col-sm-3 control-label">Srart date</label>
                        <div class="col-sm-9">
                            <div class='input-group date' id='datetimepicker'>
                                <input type='text' name="dateStart" class="form-control" value=""/>
                                <span class="input-group-addon">
                                    <span class="glyphicon glyphicon-calendar"></span>
                                </span>
                            </div>
                        </div>
                        <!-- #End Appointment time -->
                    </div>

                    <div class="form-group">
                        <!-- Appointment time -->
                        <label class="col-sm-3 control-label">End date</label>
                        <div class="col-sm-9">
                            <div class='input-group date' id='datetimepicker1'>
                                <input type='text' name="dateEnd" class="form-control" value=""/>
                                <span class="input-group-addon">
                                    <span class="glyphicon glyphicon-calendar"></span>
                                </span>
                            </div>
                        </div>
                        <!-- #End Appointment time -->
                    </div>

                    <!-- Case message -->
                    <div class="form-group">
                        <label class="col-sm-3 control-label">Project description</label>
                        <div class="col-sm-9">
                            <textarea id="editor" name="description" rows="3"></textarea>
                        </div>
                    </div>
                    <!-- #End Case message -->
                </div>
                <div class="modal-footer">
                    <button type="submit" name="save" class="btn btn-primary"><i class="fa fa-check pr5"></i> Add</button>
                    <button class="btn btn-default" type="button" data-dismiss="modal"><i class="fa fa-times-circle pr5"></i> Close</button>
                </div>
            </div>
        </form>
    </div>
</div>
<!-- #End Add project modal -->

<%@ include file="javascript.jsp" %>

</body>
</html>