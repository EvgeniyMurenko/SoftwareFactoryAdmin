<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="com.SoftwareFactoryAdmin.model.*" %>
<%@ page import="com.SoftwareFactoryAdmin.util.FxmPostFile" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.util.TimeZone" %>
<%@ page import="java.sql.Time" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page language="java" pageEncoding="UTF-8" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page session="false" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1, user-scalable=no, minimal-ui"/>
    <meta name="format-detection" content="telephone=no"/>
    <meta name="format-detection" content="address=no"/>

    <meta name="description" content=""/>
    <meta name="keywords" content=""/>

    <title>Group :: 소프트웨어팩토리</title>

    <%@ include file="styles.jsp" %>

</head>
<body>

<!-- Wrapper -->
<div id="wrapper">

    <%@ include file="leftCategoriesMenu.jsp" %>

    <!-- Page Content -->
    <div id="page-content-wrapper">

        <%List<FxmPostFile> fxmPostFileList = (List<FxmPostFile>) request.getAttribute("fxmPostFileList");%>
        <%String groupType = (String) request.getAttribute("groupType");%>
        <%SimpleDateFormat dateFormatShow = new SimpleDateFormat("yyyy-MM-dd HH:mm");%>

        <!-- Header -->
        <header class="header line">
            <a href="javascript:void(0);" class="btn btn-toggle" id="menu-toggle"><i class="fa fa-bars" aria-hidden="true"></i></a>
            <span class="header-title clearfix"><%out.print(groupType+" Group");%></span>
        </header>
        <!-- #End Header -->

        <section class="content container-fluid">

            <%if (fxmPostFileList.size() > 0) {%>
                <%for (FxmPostFile fxmPostFile : fxmPostFileList) {%>
                    <!--View post-->
                    <div class="row">

                        <div class="col-sm-2"></div>

                        <div class="col-sm-8">

                            <!--View post-->
                            <div class="row">
                                <div class="message-centre">
                                    <div class="background-02">
                                        <div class="row">
                                            <div class="col-sm-12">
                                                <div class="col-xs-2 col-sm-1">
                                                    <a class="user-thumbnail"><img src="/get-file/avatar/<%out.print(fxmPostFile.getFxmPost().getUser().getAvatarImage());%>" class="img-responsive img-circle"/></a>
                                                </div>
                                                <div class="col-xs-8 col-sm-10">
                                                    <div class="row mb10"><a href=""><%out.print(fxmPostFile.getFxmPost().getUserName());%></a></div>
                                                    <div class="row data-color"><%out.print(dateFormatShow.format(fxmPostFile.getFxmPost().getDate()));%></div>
                                                </div>
                                                <div class="col-xs-2 col-sm-1" align="right">
                                                    <%if(currentPermission.getTranslatePermission() || currentPermission.getSuperAdminPermission() || fxmPostFile.getFxmPost().getUser().getId() == currentManagerInfo.getUser().getId()){%>
                                                        <a data-toggle="dropdown">
                                                            <i class="fa fa-ellipsis-v" aria-hidden="true"></i>
                                                        </a>
                                                        <ul class="dropdown-menu dropdown-menu-right">
                                                            <%if (currentPermission.getTranslatePermission()) {%>
                                                                <li><a onclick="getPostTextToTranslate(<%out.print(fxmPostFile.getFxmPost().getId());%>)">Translate</a></li>
                                                            <%}%>
                                                            <%if (fxmPostFile.getFxmPost().getUser().getId() == currentManagerInfo.getUser().getId() || currentPermission.getSuperAdminPermission()) {%>
                                                                <li><a onclick="getPostEdit(<%out.print(fxmPostFile.getFxmPost().getId());%>)">Edit</a></li>
                                                                <li><a href="/group/delete-post/<%out.print(fxmPostFile.getFxmPost().getId());%>/" data-toggle="tooltip" title="Delete" class="deleteConfirm">Delete</a></li>
                                                            <%}%>
                                                        </ul>
                                                    <%}%>
                                                </div>
                                            </div>
                                        </div>
                                    </div>


                                    <div class="row">
                                        <div class="col-sm-12">
                                            <div class="background-02 text-size">
                                                <div class="tab-content">
                                                    <div class="tabs">
                                                        <ul class="nav nav-tabs">
                                                            <li class="active"><a href="<%out.print("#tab-1-"+fxmPostFile.getFxmPost().getId());%>" data-toggle="tab">Original langue</a></li>
                                                            <%if (fxmPostFile.getFxmPost().getPostTextEn()!= null && !"".equals(fxmPostFile.getFxmPost().getPostTextEn())){%><li><a href="<%out.print("#tab-2-"+fxmPostFile.getFxmPost().getId());%>" data-toggle="tab">English language</a></li><%}%>
                                                            <%if (fxmPostFile.getFxmPost().getPostTextRu()!= null && !"".equals(fxmPostFile.getFxmPost().getPostTextRu())){%><li><a href="<%out.print("#tab-3-"+fxmPostFile.getFxmPost().getId());%>" data-toggle="tab">Russian language</a></li><%}%>
                                                            <%if (fxmPostFile.getFxmPost().getPostTextKo()!= null && !"".equals(fxmPostFile.getFxmPost().getPostTextKo())){%><li><a href="<%out.print("#tab-4-"+fxmPostFile.getFxmPost().getId());%>" data-toggle="tab">Korean language</a></li><%}%>
                                                        </ul>
                                                        <br>
                                                        <div class="tab-content">
                                                            <div class="tab-pane fade in active" id="<%out.print("tab-1-"+fxmPostFile.getFxmPost().getId());%>">
                                                                <%out.print(fxmPostFile.getFxmPost().getPostTextOriginal());%>
                                                            </div>
                                                            <div class="tab-pane fade" id="<%out.print("tab-2-"+fxmPostFile.getFxmPost().getId());%>">
                                                                <%out.print(fxmPostFile.getFxmPost().getPostTextEn());%>
                                                            </div>
                                                            <div class="tab-pane fade" id="<%out.print("tab-3-"+fxmPostFile.getFxmPost().getId());%>">
                                                                <%out.print(fxmPostFile.getFxmPost().getPostTextRu());%>
                                                            </div>
                                                            <div class="tab-pane fade" id="<%out.print("tab-4-"+fxmPostFile.getFxmPost().getId());%>">
                                                                <%out.print(fxmPostFile.getFxmPost().getPostTextKo());%>
                                                            </div>
                                                        </div>
                                                    </div>

                                                    <%if (fxmPostFile.getFileList().size()>0){%>
                                                        <div class="row">
                                                            <div class="col-sm-12 mt10 mb10">
                                                                <%for (String fileName : fxmPostFile.getFileList()){%>
                                                                    <div class="btn-my-link">
                                                                        <a href="<%out.print("/get-file/post/"+fileName);%>" target='_blank'> <i class="fa fa-paperclip" aria-hidden="true"></i>
                                                                            Attach file</a>
                                                                    </div>
                                                                <%}%>
                                                            </div>
                                                        </div>
                                                    <%}%>

                                                    <%if (fxmPostFile.getImageList().size()>0){%>
                                                        <div class="gallery">
                                                            <div class="row">
                                                                <div class="col-md-12 gallery-position">
                                                                    <a href="<%out.print("/get-file/post/"+fxmPostFile.getImageList().get(0));%>" data-fancybox="<%out.print("gallery-"+fxmPostFile.getFxmPost().getId());%>">
                                                                        <img src="<%out.print("/get-file/post/"+fxmPostFile.getImageList().get(0));%>" class="img-responsive">
                                                                    </a>
                                                                    <%if (fxmPostFile.getImageList().size()>1){%>
                                                                        <span class="gallery-count"><%out.print("+"+fxmPostFile.getImageList().size());%></span>
                                                                    <%}%>
                                                                </div>
                                                            </div>
                                                        </div>

                                                        <div style="display: none !important; visibility: hidden !important;">
                                                            <%if (fxmPostFile.getImageList().size()>1){%>
                                                                <%for (int i = 1; i < fxmPostFile.getImageList().size(); i++){%>
                                                                    <a href="<%out.print("/get-file/post/"+fxmPostFile.getImageList().get(i));%>" data-fancybox="<%out.print("gallery-"+fxmPostFile.getFxmPost().getId());%>">
                                                                        <img src="<%out.print("/get-file/post/"+fxmPostFile.getImageList().get(i));%>" class="img-responsive">
                                                                    </a>
                                                                <%}%>
                                                            <%}%>
                                                        </div>
                                                    <%}%>

                                                    <%if (fxmPostFile.getVideoList().size()>0){%>
                                                        <div class="row">
                                                            <%for (String fileName : fxmPostFile.getVideoList()){%>
                                                                <div class="col-sm-12">
                                                                    <video class="image-div" controls>
                                                                        <source src="<%out.print("/get-file/post/"+fileName);%>">
                                                                    </video>
                                                                </div>
                                                            <%}%>
                                                        </div>
                                                    <%}%>

                                                </div>


                                            </div>
                                        </div>
                                    </div>

                                    <span class="line"></span>

                                    <div id="countComments-<%out.print(fxmPostFile.getFxmPost().getId());%>"></div>
                                    <div class="row data-comment" align="centre" id="oldCountComments-<%out.print(fxmPostFile.getFxmPost().getId());%>">
                                        <i class="fa fa-commenting" aria-hidden="true"></i> Comments: <%out.print(fxmPostFile.getFxmPost().getFxmComments().size());%>
                                    </div>

                                    <!-- View comments-->
                                    <%if (fxmPostFile.getFxmPost().getFxmComments().size()>0){%>
                                        <%for (FxmComment comment :fxmPostFile.getFxmPost().getFxmComments()){%>
                                            <div class="row mt10" id="commetn-<%out.print(comment.getId());%>">
                                                <div class="col-sm-12">
                                                    <div class="background-02">

                                                        <div class="row">
                                                            <div class="col-md-6 col-sm-6 col-xs-6">

                                                                <!-- Customer small info -->
                                                                <div class="comment-user-info clearfix">
                                                                    <a class="user-thumbnail"><img src="/get-file/avatar/<%out.print(comment.getUser().getAvatarImage());%>" class="img-responsive img-circle"/></a>
                                                                    <a href="javascript:void(0);" class="user-name"><%out.print(comment.getUserName());%></a>
                                                                </div>
                                                                <!-- #End Customer small info -->

                                                            </div>
                                                            <div class="col-md-6 col-sm-6 col-xs-6 text-right">

                                                                <!-- Commnet menu settings -->
                                                                <%if (comment.getUser().getId() == currentManagerInfo.getUser().getId() || currentPermission.getSuperAdminPermission()){%>
                                                                    <a data-toggle="dropdown" class="comment-menu-settings"><i class="fa fa-ellipsis-v " aria-hidden="true"></i></a>

                                                                    <ul class="dropdown-menu dropdown-menu-right">
                                                                        <%if (comment.getUser().getId() == currentManagerInfo.getUser().getId()){%>
                                                                            <li><a onclick="getTextCommentEdit(<%out.print(comment.getId());%>)">Edit</a></li>
                                                                        <%}%>
                                                                        <%if (comment.getUser().getId() == currentManagerInfo.getUser().getId() || currentPermission.getSuperAdminPermission()){%>
                                                                            <li><a onclick="deleteComment(<%out.print(comment.getId()+", "+fxmPostFile.getFxmPost().getId());%>)">Delete</a></li>
                                                                        <%}%>
                                                                    </ul>
                                                                <%}%>
                                                                <!-- #End Commnet menu settings -->

                                                            </div>
                                                        </div>

                                                        <div class="row">
                                                            <div class="col-md-12">

                                                                <!-- Comment -->
                                                                <div id="<%out.print("commentText"+comment.getId());%>" class="mt10 mb10">
                                                                    <%out.print(comment.getCommentText());%>
                                                                    <div id="<%out.print("commentToTranslate"+comment.getId());%>"></div>
                                                                </div>

                                                                <%TimeZone timeZone = TimeZone.getDefault();
                                                                Long time = comment.getDate().getTime();
                                                                time-= timeZone.getRawOffset();
                                                                Date date = new Date(time);%>
                                                                <div class="data-color" id="<%out.print("translateComment"+comment.getId());%>">
                                                                    <span class="timeago mr10 mt10" title='<%out.print(dateFormatShow.format(date)+"Z");%>'></span>
                                                                    <div id="<%out.print("linkToHide"+comment.getId());%>">
                                                                        <a onclick="getTranslateComment(<%out.print(comment.getId());%>)">Translate</a>
                                                                    </div>
                                                                </div>

                                                                <%--Comment Edit--%>
                                                                <div id="<%out.print("editComment"+comment.getId());%>" class="mt10 mb10" style="display: none;">
                                                                    <div class="comment-edit">
                                                                        <div id="<%out.print("textToEdit"+comment.getId());%>"></div>

                                                                        <a onclick="updateComment(<%out.print(comment.getId());%>)" class="btn btn-primary"><i class="fa fa-check" aria-hidden="true"></i></a>
                                                                        <a onclick="clouseEditComment(<%out.print(comment.getId());%>)" class="btn btn-danger"><i class="fa fa-times" aria-hidden="true"></i></a>
                                                                    </div>
                                                                </div>
                                                                <%--End Comment Edit--%>

                                                            </div>
                                                            <!-- #End Comment -->
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        <%}%>
                                    <%}%>
                                    <!-- END View comment-->

                                    <!-- Create new commnet-->
                                    <div class="row mt10">
                                        <div class="col-sm-12">
                                            <div class="background-02">
                                                <form action="/group/add-new-comment/<%out.print(fxmPostFile.getFxmPost().getId());%>/" method="post">
                                                    <div class="row">
                                                        <div class="col-lg-9 col-md-8 col-sm-8 col-xs-6">
                                                            <input name="comment" class="form-control"/>
                                                        </div>
                                                        <div class="col-lg-3 col-md-4 col-sm-4 col-xs-6" align="right">
                                                            <button type="submit" name="save" class="btn btn-primary">
                                                                <i class="fa fa-commenting" aria-hidden="true"></i> Add
                                                            </button>
                                                        </div>
                                                    </div>
                                                </form>
                                            </div>
                                        </div>
                                    </div>
                                    <!-- END Create new commnet-->
                                </div>
                            </div>
                        </div>
                    </div>
                    <!-- END View post-->
                <%}%>
            <%}%>

            <div class="add-post">
                <a onclick="addNewPost('<%out.print(groupType);%>')"><i class="fa fa-plus-circle" aria-hidden="true"></i></a>
            </div>


        </section>
    </div>


    <!-- #End Page Content -->
</div>

<!-- Add translate modal -->
<div class="modal fade" id="translatePost">
    <div class="modal-dialog modal-lg">
        <form class="form-horizontal" action="/group/save-post-translate/" method="post">

            <div id="postId">

            </div>

            <div class="modal-content">
                <div class="modal-header">
                    <button class="close" type="button" data-dismiss="modal">
                        <i class="fa fa-close"></i>
                    </button>
                    <h4 class="modal-title"><i class="fa fa-pencil" aria-hidden="true"></i> Translate text</h4>
                </div>
                <div class="modal-body">

                    <div class="col-sm-5">
                        <div class="form-group">
                            <label class="col-sm-3 control-label">From: </label>
                            <div class="col-sm-9">
                                <select id="from" name="selectFrom" class="form-control">
                                    <option value="en">English</option>
                                    <option value="ko">Korean</option>
                                    <option value="ru">Russian</option>
                                </select>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="control-label">Original text</label>
                            <div class="message-centre">
                                <div class="scrollable">
                                    <div id="textToTranslate">

                                    </div>
                                </div>
                            </div>
                        </div>

                    </div>

                    <div class="col-sm-7">
                        <div class="form-group">
                            <label class="col-sm-3 control-label">To: </label>
                            <div class="col-sm-9">
                                <select id="to" name="selectTo" class="form-control">
                                    <option value="en">English</option>
                                    <option value="ko">Korean</option>
                                    <option value="ru">Russian</option>
                                </select>
                            </div>
                        </div>

                        <div class="form-group">
                            <div class="col-sm-12">
                                <label class=control-label">Translate</label>
                            </div>
                            <div class="col-sm-12">
                                <textarea id="editor" name="translateText"></textarea>
                            </div>
                        </div>
                    </div>

                </div>

                <div class="modal-footer">
                    <button type="submit" name="save" class="btn btn-primary"><i class="fa fa-floppy-o"
                                                                                 aria-hidden="true"></i> Save
                    </button>
                    <button class="btn btn-default" type="button" data-dismiss="modal"><i
                            class="fa fa-times-circle pr5"></i> Close
                    </button>

                </div>
            </div>
        </form>
    </div>
</div>
<!-- End Add translate modal -->

<!-- Add new post modal -->
<div class="modal fade" id="addPost">
    <div class="modal-dialog modal-lg">

        <form class="form-horizontal" action="/group/save-post/" method="post" enctype="multipart/form-data">

            <div id="postIdToEdit">

            </div>

            <div class="modal-content">
                <div class="modal-header">
                    <button class="close" type="button" data-dismiss="modal">
                        <i class="fa fa-close"></i>
                    </button>
                    <h4 class="modal-title"><i class="fa fa-pencil" aria-hidden="true"></i> Add new post</h4>
                </div>
                <div class="modal-body">

                    <!--Create post-->
                    <div class="background-01">
                       <%-- <h4>Show to</h4>
                        <div class="form-group">
                            <div class="col-sm-12">
                                <select class="form-control" name="groupType" >
                                    <%if (currentPermission.getLeaderGroup())%><option value="leader">Leader</option>
                                    <%if (currentPermission.getStaffGroup())%><option value="staff">Staff</option>
                                    <%if (currentPermission.getMemberGroup())%><option value="member">Member</option>
                                </select>
                            </div>
                        </div>--%>

                        <h4>Write message</h4>

                        <div class="form-group">
                            <div class="col-sm-12">
                                <textarea id="textEdit" name="postText" rows="3"></textarea>
                            </div>
                        </div>

                        <div class="form-group">

                            <div id="fileAttach"></div>

                        </div>

                        <div class="form-group">
                            <!-- Attach files -->
                            <label class="col-sm-3 control-label">Attach File</label>
                            <div class="col-sm-9">
                                <input id="uploadFile" name="file[]" multiple type="file">
                            </div>
                            <!-- #End Attach files -->
                        </div>
                    </div>
                    <!--END Create post-->

                </div>

                <div class="modal-footer">
                    <button type="submit" name="save" class="btn btn-primary">
                        <i class="fa fa-floppy-o" aria-hidden="true"></i> Save
                    </button>
                    <button class="btn btn-default" type="button" data-dismiss="modal">
                        <i class="fa fa-times-circle pr5"></i> Close
                    </button>
                </div>
            </div>
        </form>
    </div>
</div>
<!-- END Add new post modal -->


<%@ include file="javascript.jsp" %>

</body>
</html>