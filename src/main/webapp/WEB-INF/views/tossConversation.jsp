<%@ page import="java.util.List" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Collections" %>
<%@ page import="com.SoftwareFactoryAdmin.model.*" %>
<%@ page import="java.util.Set" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.SoftwareFactoryAdmin.comparator.TossTaskMessagesByDateComparator" %>
<%@ page import="com.SoftwareFactoryAdmin.constant.StatusEnum" %>
<%@ page import="com.sun.xml.internal.ws.api.message.Packet" %>
<%@ page import="com.SoftwareFactoryAdmin.comparator.TossTaskByDateComparator" %>
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

    <title>Toss conversation :: 소프트웨어팩토리</title>

    <%@ include file="styles.jsp" %>

</head>
<body>
<!-- Wrapper -->
<div id="wrapper">

    <%
        Toss toss  = (Toss) request.getAttribute("toss");
        List<ManagerInfo> managerInfos = (List<ManagerInfo>) request.getAttribute("managers");

        SimpleDateFormat dateFormatShow = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        List <TossTask> tossTasks = new ArrayList<>(toss.getTossTasks());

        TossTaskMessagesByDateComparator tossTaskMessagesByDateComparator = new TossTaskMessagesByDateComparator();
        TossTaskByDateComparator tossTaskByDateComparator = new TossTaskByDateComparator();

        tossTasks.sort(tossTaskByDateComparator);

        List <ManagerInfo> managersEngaged = new ArrayList<>(toss.getManagerInfoEngaged());
    %>

    <%@ include file="leftCategoriesMenu.jsp" %>

    <!-- Page Content -->
    <section id="page-content-wrapper">

        <!-- Header -->
        <header class="header line">
            <a href="javascript:void(0);" class="btn btn-toggle" id="menu-toggle"><i class="fa fa-bars" aria-hidden="true"></i></a>
            <span class="header-title clearfix"><%out.print(toss.getTitle());%></span>
        </header>
        <!-- #End Header -->

        <!-- Content section -->
        <section class="container-fluid content">

            <div class="mb20">
                <a href="/toss/" class="btn btn-primary"><i class="fa fa-rocket pr10"></i>Back to toss list</a>
            </div>

            <div class="row">

                <div class="col-md-5">
                    <h4 class="mb10">Toss Information : </h4>
                    <section class="estimate-user-info">
                        <div class="name">Manager opened : <%out.print(toss.getManagerOpenedName());%></div>
                        <div class="persons">Persons :
                            <%
                                for (int i = 0; i < managersEngaged.size(); i++){
                                    out.print(managersEngaged.get(i).getName());
                                    if(i != managersEngaged.size()-1) out.print(" , ");
                                }
                            %>
                        </div>
                        <%
                            String endDate = "Now!";
                            if (!toss.isNow()) endDate = dateFormatShow.format(toss.getEndDate());
                        %>
                        <div class="end_date">END DATE : <%out.print(endDate);%></div>
                    </section>

                    <br>


                    <form action="/toss/send-another-toss" method="post" enctype="multipart/form-data">

                        <input type="hidden" name="id" value="<%out.print(toss.getId());%>">

                        <div class="form-group">
                            <label class="control-label">Status </label>
                            <select name="status" class="form-control" id="status">
                                <option value="PROCESSING"> Processing </option>
                                <option value="PAUSE"> Pause </option>
                                <option value="FINISH"> Finish </option>
                            </select>
                        </div>

                        <div class="form-group">
                            <label class="control-label">Persons </label>
                                <select class="js-example-basic-multiple " name="persons" multiple="multiple" required
                                        style="width:100%;">
                                    <%for (ManagerInfo managerInfo : managerInfos) {%>
                                    <option value="<%out.print(managerInfo.getId());%>"><%
                                        out.print(managerInfo.getName());%></option>
                                    <%}%>
                                </select>
                        </div>

                        <div class="form-group">
                            <label class="control-label">Attach Files </label>
                            <input id="chatUpload" name="file[]" multiple type="file">
                        </div>

                        <div class="form-group">

                            <label class="control-label">Answer </label>
                            <textarea id="editor" name="answer" rows="3"  ></textarea>

                        </div>


                        <div class="form-group text-right">
                            <button type="submit" name="save" class="btn btn-primary"><i class="fa fa-check pr10"></i>
                                Send Toss Answer
                            </button>
                        </div>
                    </form>
                </div>

                <div class="col-md-7">
                    <section class="cases-messages-section">
                        <br>


                        <%

                            for (TossTask tossTask : tossTasks) {

                                ArrayList<TossTaskMessage> tossTaskMessages = new ArrayList<>(tossTask.getTossTaskMessages());

                                ArrayList<TossTaskLink> tossTaskLinks = new ArrayList<>(tossTask.getTossTaskLinks());

                                tossTaskMessages.sort(tossTaskMessagesByDateComparator);

                                String status = "message-right-grey";  //status FINISH

                                if(tossTask.getStatus().equals(StatusEnum.PROCESSING.toString())){
                                    status = "message-right-green";
                                } else if (tossTask.getStatus().equals(StatusEnum.PAUSE.toString())) {
                                    status = "message-right-orange";
                                }
                        %>

                        <div class="message-right message-right-toss <%out.print(status);%>">

                            <div class="clearfix message-header">
                                <div class="title"><%out.print(tossTask.getManagerInfoOpened().getName() + " ID - " + tossTask.getManagerInfoOpened().getId());%></div>
                                <div class="date"> <span class="timeago mr10 mt10" title='<%out.print(dateFormatShow.format(tossTask.getDate())+"Z");%>'></span></div>
                            </div>

                            <% out.print(tossTask.getText() + "<br>");%>

                            <%
                                if (!tossTaskLinks.isEmpty()) {
                                    for (TossTaskLink tossTaskLink :tossTaskLinks){
                                        out.print("<a href="+ tossTaskLink.getFileLink() +" target='_blank'>"+tossTaskLink.getFileName()+"</a><br>");
                                    }
                                }
                            %>


                            <div style="text-align: right"><a data-toggle="modal" data-target="#modalComment"  onclick="setTossTaskId(<%out.print(tossTask.getId());%>)">Leave comment</a></div>
                        </div>



                        <%for(TossTaskMessage tossTaskMessage : tossTaskMessages){%>
                            <%--comment--%>
                            <div class="message-right message-right-comment <%out.print(status);%>">

                                <div class="clearfix message-header message-header-comment">
                                    <div class="title"><%out.print(tossTaskMessage.getManagerInfo().getName() + " ID - " + tossTaskMessage.getManagerInfo().getId());%></div>
                                    <div class="date">
                                        <span class="timeago mr10 mt10" title='<%out.print(dateFormatShow.format(tossTaskMessage.getDate())+"Z");%>'></span>
                                    </div>
                                </div>

                                <% out.print(tossTaskMessage.getText());%>

                            </div>
                            <%--comment--%>
                            <%}%>
                        <%}%>

                    </section>
                </div>
            </div>
        </section>
        <!-- #End Page-content -->

        <!-- leave comment task modal -->
        <div class="modal fade" id="modalComment">
            <div class="modal-dialog modal-lg">

                <form class="form-horizontal" action="/toss/comment" method="post" >

                    <input type="hidden" id="toss_task_id" name="toss_task_id" value="">
                    <input type="hidden" name="toss_id" value="<%out.print(toss.getId());%>">

                    <div class="modal-content">

                        <div class="modal-header">
                            <button class="close" type="button" data-dismiss="modal">
                                <i class="fa fa-close"></i>
                            </button>
                            <h4 class="modal-title">Leave comment</h4>
                        </div>

                        <div class="modal-body">

                            <!-- comment -->
                            <div class="form-group">
                                <label class="col-sm-3 control-label">Comment </label>
                                <div class="col-sm-9">
                                    <textarea id="textEdit" name="comment" rows="3"></textarea>
                                </div>
                            </div>
                            <!-- comment -->


                        </div>
                        <div class="modal-footer">
                            <button type="submit" name="save" class="btn btn-primary"><i class="fa fa-check pr5"></i> Leave Comment</button>
                            <button class="btn btn-default" type="button" data-dismiss="modal"><i class="fa fa-times-circle pr5"></i> Close</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
        <!-- #End Add project task modal -->



</div>
<!-- #End Wrapper -->

<%@ include file="javascript.jsp" %>
<script>
<%
    String isNewTask = request.getParameter("isNewAnswer");
    if (isNewTask != null) {
        String link = "/toss/toss-conversation/" + toss.getId();
%>

    jQuery(document).ready(function ($) {
        swal(
            'Success!',
            'Toss',
            'success'
        );
        history.pushState(null, null, '<%out.print(link);%>');
    });

<%}%>

function setTossTaskId(tossId) {
    document.getElementById("toss_task_id").value = tossId;
}

</script>

</body>
</html>
