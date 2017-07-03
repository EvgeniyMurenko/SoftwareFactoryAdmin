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
    <meta name="viewport"
          content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1, user-scalable=no, minimal-ui"/>
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

        <!-- Header -->
        <header class="header line">
            <a href="javascript:void(0);" class="btn btn-toggle" id="menu-toggle"><i class="fa fa-envelope-o"
                                                                                     aria-hidden="true"></i></a>
            <span class="header-title clearfix">Group</span>
        </header>
        <!-- #End Header -->

        <section class="content container-fluid">

            <div class="col-sm-2"></div>

            <div class="col-sm-8">

                <!--Create post-->
                <div class="row">
                    <form action="">
                        <div class="message-centre">
                            <div class="background-02">
                                <textarea id="myTextArea" name="message" class="form-control" rows="2"
                                          placeholder="Write post text"></textarea>
                                <span class="content-title mt10"></span>
                                <div class="row " align="right">
                                    <div class="col-lg-9 col-sm-8  col-xs-9">
                                        <input id="uploadFile" name="file[]" multiple type="file">
                                    </div>
                                    <div class="col-lg-3 col-sm-4 col-xs-3">
                                        <button type="submit" name="save" class="btn btn-primary right">
                                            <i class="fa fa-envelope-o" aria-hidden="true"></i> Send
                                        </button>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </form>
                </div>
                <!--END Create post-->

                <!--View post-->
                <div class="row">
                    <div class="message-centre">
                        <div class="background-02">
                            <div class="row">
                                <div class="col-sm-2">
                                </div>
                                <div class="col-sm-9">
                                    <div class="row mb10"><a href="">kass</a></div>
                                    <div class="row data-color">27.06.2017 22:22</div>
                                </div>
                                <div class="col-sm-1">
                                    <a data-target="#translate" data-toggle="modal">
                                        <i class="fa fa-exchange" aria-hidden="true"></i>
                                    </a>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-sm-12">
                                <div class="background-02 text-size">
                                    <div class="tab-content">
                                        <div class="tabs">
                                            <ul class="nav nav-tabs">
                                                <li class="active"><a href="#tab-1" data-toggle="tab">Original
                                                    langue</a></li>
                                                <li><a href="#tab-2" data-toggle="tab">English language</a></li>
                                                <li><a href="#tab-3" data-toggle="tab">Russian language</a></li>
                                                <li><a href="#tab-4" data-toggle="tab">Korean language</a></li>
                                            </ul>
                                            <br>
                                            <div class="tab-content">
                                                <div class="tab-pane fade in active" id="tab-1">
                                                    한국교육원 작업을 시작해야 합니다. <br>
                                                    고객이 방문했을때 약속 했듯이 작업 진행 상황을 항상 볼 수 있도록... koreaedu.gq 에 변화되는 상황을 보여줘야
                                                    합니다.<br>
                                                    <br>
                                                    작업 내용은<br>
                                                    영국의 한국교육원과 같은 메뉴로 만듭니다.<br>
                                                    단지 디자인은 빅막심이 제안한 형태를 사용합니다.<br>
                                                    <br>
                                                    빅막심이 만든 형태에서 큰 그림이 초기 화면에 들어갈 수 있도록 수정해야 합니다.<br>
                                                    <br>
                                                    빅막심이 만든 형태에서 색깔을 잘 어울리게 변화 시켜야 합니다.<br>
                                                    <br>
                                                    <br>
                                                    이 작업은 이번주 부터 시작되어야 합니다.<br>
                                                    먼저 빅막심이 영국교육원 홈페이지와 같은 형태로 만는 작업을 진행해 주기 바랍니다.... 데이터베이스도 만들어야
                                                    합니다.<br>
                                                    <br>
                                                    나머지 내용은 사무실에 가서 회의 합시다.<br>
                                                    <br>
                                                    오늘 오두2시에 인테리어 업자를 만나고 사무실로 갑니다.<br>
                                                </div>
                                                <div class="tab-pane fade" id="tab-2">
                                                    <p>Параграф с текстом 2</p>
                                                </div>
                                                <div class="tab-pane fade" id="tab-3">
                                                    <p>Параграф с текстом 3</p>
                                                </div>
                                                <div class="tab-pane fade" id="tab-4">
                                                    <p>Параграф с текстом 4</p>
                                                </div>
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
                                            나는 웹사이트에 올라 오기를 원한다고... <br>

                                            <div class="linkToHide">
                                                <a onclick="getTranslate(22);">Translate...</a>
                                            </div>


                                            <div id="translateText">

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
            <!-- END View post-->
        </section>
    </div>
    <!-- #End Page Content -->

</div>

<!-- Add project modal -->
<div class="modal fade" id="translate">
    <div class="modal-dialog modal-lg">
        <form class="form-horizontal" action="" method="post" id="projectEditForm">
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
                                <select id="from" name="selectStatus" class="form-control">
                                    <option value="OPEN">English</option>
                                    <option value="START">Korean</option>
                                    <option value="CONSIDERED">Russian</option>
                                </select>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="control-label">Original text</label>
                            <div class="scrollable">
                                <div class="message-centre">
                                    한국교육원 작업을 시작해야 합니다. <br>
                                    고객이 방문했을때 약속 했듯이 작업 진행 상황을 항상 볼 수 있도록... koreaedu.gq 에 변화되는 상황을 보여줘야 합니다.<br>
                                    <br>
                                    작업 내용은<br>
                                    영국의 한국교육원과 같은 메뉴로 만듭니다.<br>
                                    단지 디자인은 빅막심이 제안한 형태를 사용합니다.<br>
                                    <br>
                                    빅막심이 만든 형태에서 큰 그림이 초기 화면에 들어갈 수 있도록 수정해야 합니다.<br>
                                    <br>
                                    빅막심이 만든 형태에서 색깔을 잘 어울리게 변화 시켜야 합니다.<br>
                                    <br>
                                    <br>
                                    이 작업은 이번주 부터 시작되어야 합니다.<br>
                                    먼저 빅막심이 영국교육원 홈페이지와 같은 형태로 만는 작업을 진행해 주기 바랍니다.... 데이터베이스도 만들어야 합니다.<br>
                                    <br>
                                    나머지 내용은 사무실에 가서 회의 합시다.<br>
                                    <br>
                                    오늘 오두2시에 인테리어 업자를 만나고 사무실로 갑니다.<br>
                                </div>
                            </div>
                        </div>


                    </div>
                    <div class="col-sm-7">
                        <div class="form-group">
                            <label class="col-sm-3 control-label">To: </label>
                            <div class="col-sm-9">
                                <select id="to" name="selectStatus" class="form-control">
                                    <option value="OPEN">English</option>
                                    <option value="START">Korean</option>
                                    <option value="CONSIDERED">Russian</option>
                                </select>
                            </div>
                        </div>

                        <div class="form-group">
                            <div class="col-sm-12">
                                <label class=control-label">Translate</label>
                            </div>
                            <div class="col-sm-12">
                                <textarea id="editor" name="description"></textarea>
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
<!-- #End Add project modal -->



</div>


<%@ include file="javascript.jsp" %>

</body>
</html>