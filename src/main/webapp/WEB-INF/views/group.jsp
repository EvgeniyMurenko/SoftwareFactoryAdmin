<%@ page import="java.util.List" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="com.SoftwareFactoryAdmin.model.*" %>
<%@ page import="java.util.Set" %>
<%@ page import="com.SoftwareFactoryAdmin.util.FxmPostFile" %>
<%@ page import="com.SoftwareFactoryAdmin.constant.MainPathEnum" %>
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

        <%List<FxmPost> postList = (List<FxmPost>) request.getAttribute("postList");%>
        <%List<FxmPostFile> fxmPostFileList = (List<FxmPostFile>) request.getAttribute("fxmPostFileList");%>
        <%SimpleDateFormat dateFormatShow = new SimpleDateFormat("yyyy-MM-dd HH:mm");%>

        <!-- Header -->
        <header class="header line">
            <a href="javascript:void(0);" class="btn btn-toggle" id="menu-toggle"><i class="fa fa-envelope-o" aria-hidden="true"></i></a>
            <span class="header-title clearfix">Group</span>
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
                                            <div class="col-sm-2">
                                            </div>
                                            <div class="col-sm-9">
                                                <div class="row mb10"><a href=""><%out.print(fxmPostFile.getFxmPost().getUserName());%></a></div>
                                                <div class="row data-color"><%out.print(dateFormatShow.format(fxmPostFile.getFxmPost().getDate()));%></div>
                                            </div>
                                            <%--Translate modal--%>
                                            <div class="col-sm-1">
                                                <a onclick="getPostTextToTranslate(<%out.print(fxmPostFile.getFxmPost().getId());%>)">
                                                    <i class="fa fa-exchange" aria-hidden="true"></i>
                                                </a>
                                            </div>
                                            <%--End Translate--%>
                                        </div>
                                    </div>


                                    <div class="row">
                                        <div class="col-sm-12">
                                            <div class="background-02 text-size">
                                                <div class="tab-content">
                                                    <div class="tabs">
                                                        <ul class="nav nav-tabs">
                                                            <li class="active"><a href="<%out.print("#tab-1-"+fxmPostFile.getFxmPost().getId());%>" data-toggle="tab">Original langue</a></li>
                                                            <%if (fxmPostFile.getFxmPost().getPostTextEn()!= null){%><li><a href="<%out.print("#tab-2-"+fxmPostFile.getFxmPost().getId());%>" data-toggle="tab">English language</a></li><%}%>
                                                            <%if (fxmPostFile.getFxmPost().getPostTextRu()!= null){%><li><a href="<%out.print("#tab-3-"+fxmPostFile.getFxmPost().getId());%>" data-toggle="tab">Russian language</a></li><%}%>
                                                            <%if (fxmPostFile.getFxmPost().getPostTextKo()!= null){%><li><a href="<%out.print("#tab-4-"+fxmPostFile.getFxmPost().getId());%>" data-toggle="tab">Korean language</a></li><%}%>
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
                                                                        <a href="<%out.print(MainPathEnum.mainPath + "/post/"+fileName);%>"><i class="fa fa-paperclip" aria-hidden="true"></i>
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
                                                                    <a href="file/2.jpg" data-fancybox="gallery">
                                                                        <img src="file/2.jpg" class="img-responsive">
                                                                    </a>

                                                                    <span class="gallery-count">+7</span>
                                                                </div>
                                                            </div>
                                                        </div>

                                                        <div style="display: none !important; visibility: hidden !important;">
                                                            <a href="file/6.jpg" data-fancybox="gallery">
                                                                <img src="file/6.jpg" class="img-responsive">
                                                            </a>

                                                            <a href="file/2.jpg" data-fancybox="gallery">
                                                                <img src="file/2.jpg" class="img-responsive">
                                                            </a>

                                                            <a href="file/3.jpg" data-fancybox="gallery">
                                                                <img src="file/3.jpg" class="img-responsive">
                                                            </a>

                                                            <a href="file/4.jpg" data-fancybox="gallery">
                                                                <img src="file/4.jpg" class="img-responsive">
                                                            </a>

                                                            <a href="file/5.jpg" data-fancybox="gallery">
                                                                <img src="file/5.jpg" class="img-responsive">
                                                            </a>
                                                        </div>

                                                    <%}%>


                                                    <div class="row">
                                                        <div class="col-sm-12">
                                                            <video class="image-div" controls>
                                                                <source src="file/test.mp4">
                                                            </video>
                                                        </div>
                                                    </div>


                                                </div>


                                            </div>
                                        </div>
                                    </div>

                                    <span class="line"></span>

                                    <div class="row data-comment" align="centre">
                                        <i class="fa fa-commenting" aria-hidden="true"></i> Comments: 4
                                    </div>

                                    <!-- View comments-->

                                    <div class="row mt10">
                                        <div class="col-sm-12">
                                            <div class="background-02">
                                                <div class="row">
                                                    <div class="col-sm-2">
                                                            <span class="content">
                                                                <a href="">Kass</a>
                                                            </span>
                                                    </div>
                                                    <div class="col-sm-10">
                                                        톨막심도 알고 있습니다.<br>
                                                        빅막심도 알고 있습니다.<br>
                                                        올가도 정확히 들었습니다.<br>
                                                        나는 웹사이트에 올라 오기를 원한다고... <br><br/>

                                                        <a href="#" id="showHideContent">Показать/Скрыть</a>

                                                        <div id="content" style="display:none;">Содержание, которое скрыто
                                                            по-умолчанию. Покажется/скроется при клике на одну и ту же ссылку.
                                                        </div>


                                                        <div class="data-color" align="right">27.06.2017 22:22</div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>

                                    <div class="row mt10">
                                        <div class="col-sm-12">
                                            <div class="background-02">
                                                <div class="row">
                                                    <div class="col-sm-2">
                                                        <span class="content">
                                                            <a href="">Kass</a>
                                                        </span>
                                                    </div>
                                                    <div class="col-sm-9">
                                                        톨막심도 알고 있습니다.<br>
                                                        빅막심도 알고 있습니다.<br>
                                                        올가도 정확히 들었습니다.<br>
                                                        나는 웹사이트에 올라 오기를 원한다고... <br>
                                                    </div>
                                                    <div class="col-sm-1" align="right">
                                                        <i class="fa fa-exchange" aria-hidden="true"></i>
                                                    </div>
                                                </div>
                                                <div class="data-color" align="right">27.06.2017 22:22</div>
                                            </div>
                                        </div>
                                    </div>

                                    <div class="row mt10">
                                        <div class="col-sm-12">
                                            <div class="background-02">
                                                <div class="row">
                                                    <div class="col-sm-2">
                                                            <span class="content">
                                                                <a href="">바다 </a>
                                                            </span>
                                                    </div>
                                                    <div class="col-sm-10">
                                                        У меня есть вопрос ... в пятницу я попросил Ольгу загрузить SFCAFE
                                                        веб-сайт на первую страницу. <br>
                                                        Я хочу знать почему ее там нет. <br>

                                                        <div class="data-color" align="right">27.06.2017 22:22</div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>

                                    <div class="row mt10">
                                        <div class="col-sm-12">
                                            <div class="background-02">
                                                <div class="row">
                                                    <div class="col-sm-2">
                                                                <span class="content">
                                                                    <a href="">바다 </a>
                                                                </span>
                                                    </div>
                                                    <div class="col-sm-10">
                                                        Эта работа должна быть начата на этой неделе.<br>

                                                        <div class="data-color" align="right">27.06.2017 22:22</div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>

                                    <!-- END View comment-->

                                    <!-- Create new commnet-->
                                    <div class="row mt10">
                                        <div class="col-sm-12">
                                            <div class="background-02">
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
                                            </div>
                                        </div>
                                    </div>
                                    <!-- END Create new commnet-->

                                </div>

                            </div>
                            <!-- END View post-->

                        </div>
                    </div>
                    <!-- END View post-->
                <%}%>
            <%}%>

            <div class="add_comment">
                <a data-target="#addPost" data-toggle="modal"><i class="fa fa-plus-circle" aria-hidden="true"></i></a>
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
                        <h4>Show to</h4>
                        <div class="form-group">
                            <div class="col-sm-12">
                                <input class="form-control" type="text" id="inputField">
                            </div>
                        </div>

                        <h4>Write message</h4>

                        <div class="form-group">
                            <div class="col-sm-12">
                                <textarea id="textEdit" name="postText" rows="3"></textarea>
                            </div>
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