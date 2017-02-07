<%@ page import="java.util.Locale" %>
<%@ page import="org.springframework.web.servlet.support.RequestContextUtils" %><%--<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>--%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page session="false" %>

<html lang="ru">
<head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1, user-scalable=no, minimal-ui" />
    <meta name="format-detection" content="telephone=no" />
    <meta name="format-detection" content="address=no" />

    <meta name="description" content="" />
    <meta name="keywords" content="" />

    <title>소팩소개 :: Software Factory</title>

    <link href="resources/newIndexPage/css/bootstrap.min.css" rel="stylesheet" />
    <link href="resources/newIndexPage/css/bootstrap-select.min.css" rel="stylesheet" />
    <link href="resources/newIndexPage/css/jquery.fancybox.min.css" rel="stylesheet" />
    <link href="resources/newIndexPage/css/jquery.sweet-alert.min.css" rel="stylesheet" />
    <link href="resources/newIndexPage/css/font-awesome.min.css" rel="stylesheet" />
    <link href="resources/newIndexPage/css/awesome-bootstrap-checkbox.min.css" rel="stylesheet" />
    <link href="resources/newIndexPage/css/style.css" rel="stylesheet" />
    <link href="resources/newIndexPage/css/responsive.css" rel="stylesheet" />

    <!--[if lt IE 9]>
    <script src="resources/newIndexPage/js/html5shiv.js"></script>
    <script src="resources/newIndexPage/js/respond.min.js"></script>
    <![endif]-->
</head>
<body>

<!-- Header -->
<header class="container header">
    <div class="row">
        <div class="col-lg-6 col-md-6 col-sm-6 logo">
            <a href="./">소프트웨어<span>팩토리</span></a>
            <div class="small-logo">SoFAC : <i>Software Factory</i></div>
        </div>
        <div class="col-lg-6 col-md-6 col-sm-6 text-right login"><a href="javascript:void(0);" data-toggle="modal" data-target="#authorizationModal">이미 회원입니까? 로그인하십시오!</a></div>
    </div>
</header>
<!-- #End Header -->

<!-- Cover section -->
<div class="container-fluid cover">
    <div class="container">
        <div class="row">
            <div class="col-md-6">

                <!-- Estimation -->
                <section class="estimation mt40 mb20 clearfix">
                    <div class="es-title">처음 오신 고객은 견적, 작업등 모든 문의를 하실 수 있습니다</div>
                    <div class="es-btn"><a href="javascript:void(0);" class="btn btn-primary" data-toggle="modal" data-target="#estimationModal"><i class="fa fa-paper-plane-o"></i>문의하기</a></div>
                </section>
                <!-- #End Estimation -->

                <!-- Estimation list case -->
                <section class="estimation-list">
                    <div class="clearfix estimate">
                        <span class="check-on"></span>
                        <a href="javascript:void(0);"><span class="cb-title">청산유수</span></a> : 견적 문의 드립니다 <span class="cb-time">17.01.25 11:28:00</span>
                    </div>

                    <div class="clearfix estimate">
                        <span class="check-off"></span>
                        <a href="javascript:void(0);"><span class="cb-title">박도혁</span></a> : 작업 방법에 대해서 <span class="cb-time">17.01.27 12:26:04</span>
                    </div>

                    <div class="clearfix estimate">
                        <span class="check-on"></span>
                        <a href="javascript:void(0);"><span class="cb-title">청산유수</span></a> : 견적 문의 드립니다 <span class="cb-time">17.01.25 11:28:00</span>
                    </div>

                    <div class="clearfix estimate">
                        <span class="check-off"></span>
                        <a href="javascript:void(0);"><span class="cb-title">박도혁</span></a> : 작업 방법에 대해서 <span class="cb-time">17.01.27 12:26:04</span>
                    </div>

                    <div class="clearfix estimate">
                        <span class="check-on"></span>
                        <a href="javascript:void(0);"><span class="cb-title">청산유수</span></a> : 견적 문의 드립니다 <span class="cb-time">17.01.25 11:28:00</span>
                    </div>

                    <div class="clearfix estimate">
                        <span class="check-off"></span>
                        <a href="javascript:void(0);"><span class="cb-title">박도혁</span></a> : 작업 방법에 대해서 <span class="cb-time">17.01.27 12:26:04</span>
                    </div>
                </section>
                <!-- #End Estimation list case -->

            </div>
            <div class="col-md-6">

                <!-- Information -->
                <section class="information">
                    <div>
                        <span class="if-title">1000명의 엔지니어와 함께 하는</span>
                        <span class="if-title2">온라인 소프트웨어 개발 서비스</span>
                    </div>
                    <div class="mt20 mb20">
                        SoFAC은 전문적인 소프트웨어 개발 지원이 가능한 규모를 갖춘 소프트웨어 개발, 및 유지 운영을 대행하는 전문 개발 기업 입니다.<br>
                        SoFAC의 모든 작업은 CASE 라는 개념을 통하여 소통과 작업이 이루어지며 지속적이고 정확한 서비스를 제공 받으실 수 있습니다. <br>
                    </div>
                    <div class="text-right">
                        <a href="<c:url value='/whatIsSofac'/>" class="btn btn-primary"><i class="fa fa-link"></i>SoFAC 알아보기</a>
                    </div>
                </section>
                <!-- #End Information -->

                <!-- Video button -->
                <div class="text-center mb20"><a href="javascript:void(0);" class="btn btn-default"><i class="fa fa-video-camera"></i>SoFAC Video</a></div>
                <!-- #End Video button -->

            </div>
        </div>
    </div>
</div>
<div class="clearfix"></div>
<!-- #End Cover section -->

<!-- Advantage -->
<div class="container mt40 mb30 advantage">
    <div class="row">
        <div class="col-md-4 mb20">
            <div class="ad-icon"><i class="fa fa-clock-o"></i></div>
            <div>
                <h3 class="text-center">CASE 란 무엇인가요 ?</h3>
                <div class="text-justify">스마트 시대가 되면 대부분의 개발은 국제 표준에 대한 개념을 지속적으로 적용하여야 합니다 <b>CASE개념은 24시간 지속적인 고객 지원이 가능한 고객과의 소통 방법이며 정확한 시간 약속과 지원에 대한 결과를 확인할 수 있는 체계 입니다.</b></div>
                <div class="mt10 text-justify"> <a href="javascript:void(0);"><i>자세히  알아보기...</i></a></div>
            </div>
        </div>
        <div class="col-md-4 mb20">
            <div class="ad-icon"><i class="fa fa-envira"></i></div>
            <div>
                <h3 class="text-center">SoFAC의 가격 정책</h3>
                <div class="text-justify">현대 사회의 모든 사업은 소프트웨어 지원이 필수적입니다. 따라서 기존의 개발비용 개념과 <b>달리 다양한 방법으로 비용을 절감하거나 고객이 원하는 형태로 비용 지불 방법을 정할 수 있는 유연한 가격 정책과 기술료를 받지 않는 정책을 운영합니다.</b></div>
                <div class="mt10 text-justify"> <a href="javascript:void(0);"><i>자세히  알아보기...</i></a></div>
            </div>
        </div>
        <div class="col-md-4 mb20">
            <div class="ad-icon"><i class="fa fa-laptop"></i></div>
            <div>
                <h3 class="text-center">SoFAC의 다국적 작업 방법</h3>
                <div class="text-justify">SoFAC은 기존의 소규모 개발 회사와 달리 저비용을 실현하면서 개발 및 지속적인 관리가 가능하게 하기 위하여 <b>다국적 개발 및 관리 시스템인 GXM플랫폼을 통하여 공장형 개발 기법을 실현하였습니다.</b></div>
                <div class="mt10 text-justify"> <a href="<c:url value='/guide'/>"><i>자세히  알아보기...</i></a></div>
            </div>
        </div>
    </div>
</div>
<div class="clearfix"></div>
<!-- #End Advantage -->

<!-- Tag line -->
<div class="container-fluid tag-line mt20 mb20">
    <div class="container">
        <img src="resources/newIndexPage/images/old-logo.png" alt="" class="img-responsive" />
        <div class="last-blog clearfix">
            <div class="bl-quote"><i class="fa fa-quote-right"></i></div>
            <div class="bl-article-title">10여년 전부터 소프트웨어 지원은 자금 지원과 함께 이루어져야 한다는 생각을 가진<br>㈜굿앤굿재무법인이  미국적 표준화와 다국적 개발 능력을 확보한 전문 개발 대행 기업 입니다.</div>
        </div>
        <div class="bl-body">소프트웨어팩토리는 수준높은 개발과 저비용을 실현한 최초의 소프트웨어 서비스 기업입니다. <a href="<c:url value='/aboutUs'/>"><i>자세히  알아보기...</i></a></div>
    </div>
</div>
<div class="clearfix"></div>
<!-- #End Tag line -->

<!-- Portfolio -->
<section class="container mt40 mb10">
    <div class="row">
        <div class="col-md-12">
            <div id="portfolio" class="carousel slide">

                <ol class="carousel-indicators">
                    <li data-target="#portfolio" data-slide-to="0" class="active"></li>
                    <li data-target="#portfolio" data-slide-to="1"></li>
                    <li data-target="#portfolio" data-slide-to="2"></li>
                </ol>

                <!-- Carousel items -->
                <div class="carousel-inner">

                    <div class="item active">
                        <div class="row">
                            <!-- <div class="col-md-3"><a href="#" class="thumbnail"><img src="http://placehold.it/250x250" alt="Image" style="max-width:100%;"></a></div> -->
                            <div class="col-md-3"><a data-fancybox="" data-src="<c:url value='/portfolio'/>" data-type="iframe" href="javascript:void(0);" class="thumbnail"><img src="http://placehold.it/250x250" alt=""></a></div>
                            <div class="col-md-3"><a data-fancybox="" data-src="portfolio.html" data-type="iframe" href="javascript:void(0);" class="thumbnail"><img src="http://placehold.it/250x250" alt=""></a></div>
                            <div class="col-md-3"><a data-fancybox="" data-src="portfolio.html" data-type="iframe" href="javascript:void(0);" class="thumbnail"><img src="http://placehold.it/250x250" alt=""></a></div>
                            <div class="col-md-3"><a data-fancybox="" data-src="portfolio.html" data-type="iframe" href="javascript:void(0);" class="thumbnail"><img src="http://placehold.it/250x250" alt=""></a></div>
                        </div><!--.row-->
                    </div><!--.item-->

                    <div class="item">
                        <div class="row">
                            <div class="col-md-3"><a data-fancybox="" data-src="portfolio.html" data-type="iframe" href="javascript:void(0);" class="thumbnail"><img src="http://placehold.it/250x250" alt=""></a></div>
                            <div class="col-md-3"><a data-fancybox="" data-src="portfolio.html" data-type="iframe" href="javascript:void(0);" class="thumbnail"><img src="http://placehold.it/250x250" alt=""></a></div>
                            <div class="col-md-3"><a data-fancybox="" data-src="portfolio.html" data-type="iframe" href="javascript:void(0);" class="thumbnail"><img src="http://placehold.it/250x250" alt=""></a></div>
                            <div class="col-md-3"><a data-fancybox="" data-src="portfolio.html" data-type="iframe" href="javascript:void(0);" class="thumbnail"><img src="http://placehold.it/250x250" alt=""></a></div>
                        </div><!--.row-->
                    </div><!--.item-->

                    <div class="item">
                        <div class="row">
                            <div class="col-md-3"><a data-fancybox="" data-src="portfolio.html" data-type="iframe" href="javascript:void(0);" class="thumbnail"><img src="http://placehold.it/250x250" alt=""></a></div>
                            <div class="col-md-3"><a data-fancybox="" data-src="portfolio.html" data-type="iframe" href="javascript:void(0);" class="thumbnail"><img src="http://placehold.it/250x250" alt=""></a></div>
                            <div class="col-md-3"><a data-fancybox="" data-src="portfolio.html" data-type="iframe" href="javascript:void(0);" class="thumbnail"><img src="http://placehold.it/250x250" alt=""></a></div>
                            <div class="col-md-3"><a data-fancybox="" data-src="portfolio.html" data-type="iframe" href="javascript:void(0);" class="thumbnail"><img src="http://placehold.it/250x250" alt=""></a></div>
                        </div><!--.row-->
                    </div><!--.item-->

                </div><!--.carousel-inner-->
                <a data-slide="prev" href="#portfolio" class="left carousel-control">‹</a>
                <a data-slide="next" href="#portfolio" class="right carousel-control">›</a>
            </div><!--.Carousel-->

        </div>
    </div>
</section>
<div class="clearfix"></div>
<!-- #End Portfolio -->

<!-- Features -->
<div class="container features mt30 mb30">
    <div class="text-center mb20">
        <h3>More awesome features are already in the works</h3>
        <p>The following features are not yet available in now.do but are planned as part of our effort to make now.do the best productivity tool you will ever use.</p>
    </div>

    <!-- Features list -->
    <div class="row">
        <div class="col-md-6">
            <article class="feature clearfix">
                <div class="ft-icon"><i class="fa fa-external-link"></i></div>
                <div class="ft-content">
                    <div class="ft-title">SoFAC의 유지보수 서비스 개념</div>
                    <div class="ft-body">개발 이후 지속적으로 소비자가 편안한 비즈니스를 유지할 수 있도록 서비스 개념이 적용된 종합 유지보수 개념을 적용하고 있습니다. <a href="javascript:void(0);"><i>CASE개념 자세히  알아보기...</i></a></div>
                </div>
            </article>
        </div>
        <div class="col-md-6">
            <article class="feature clearfix">
                <div class="ft-icon"><i class="fa fa-star"></i></div>
                <div class="ft-content">
                    <div class="ft-title">GXM 개발시스템의 특징</div>
                    <div class="ft-body">소프트웨어팩토리는 GAX개발 시스템에 의해서 병렬화 대량화 작업이 가능한 전문 소프트웨어 개발 대행 기업 입니다. <a href="<c:url value='/gxm'/>"><i>CASE개념 자세히  알아보기...</i></a></div>
                </div>
            </article>
        </div>
    </div>

    <div class="row">
        <div class="col-md-6">
            <article class="feature clearfix">
                <div class="ft-icon"><i class="fa fa-file-o"></i></div>
                <div class="ft-content">
                    <div class="ft-title">인증 및 보도자료</div>
                    <div class="ft-body">개발 이후 지속적으로 소비자가 편안한 비즈니스를 유지할 수 있도록 서비스 개념이 적용된 종합 유지보수 개념을 적용하고 있습니다. <a href="javascript:void(0);"><i>CASE개념 자세히  알아보기...</i></a></div>
                </div>
            </article>
        </div>
        <div class="col-md-6">
            <article class="feature clearfix">
                <div class="ft-icon"><i class="fa fa-terminal"></i></div>
                <div class="ft-content">
                    <div class="ft-title">스타트업과 함께 하는 SoFAC</div>
                    <div class="ft-body">개발 이후 지속적으로 소비자가 편안한 비즈니스를 유지할 수 있도록 서비스 개념이 적용된 종합 유지보수 개념을 적용하고 있습니다. <a href="javascript:void(0);"><i>CASE개념 자세히  알아보기...</i></a></div>
                </div>
            </article>
        </div>
    </div>

    <div class="row">
        <div class="col-md-6">
            <article class="feature clearfix">
                <div class="ft-icon"><i class="fa fa-mobile"></i></div>
                <div class="ft-content">
                    <div class="ft-title">지점 및 협력업체</div>
                    <div class="ft-body">개발 이후 지속적으로 소비자가 편안한 비즈니스를 유지할 수 있도록 서비스 개념이 적용된 종합 유지보수 개념을 적용하고 있습니다. <a href="javascript:void(0);"><i>CASE개념 자세히  알아보기...</i></a></div>
                </div>
            </article>
        </div>
        <div class="col-md-6">
            <article class="feature clearfix">
                <div class="ft-icon"><i class="fa fa-flask"></i></div>
                <div class="ft-content">
                    <div class="ft-title">SoFAC 정책</div>
                    <div class="ft-body">개발 이후 지속적으로 소비자가 편안한 비즈니스를 유지할 수 있도록 서비스 개념이 적용된 종합 유지보수 개념을 적용하고 있습니다. <a href="javascript:void(0);"><i>CASE개념 자세히  알아보기...</i></a></div>
                </div>
            </article>
        </div>
    </div>
    <!-- #End Features list -->

</div>
<div class="clearfix"></div>
<!-- #End Features -->

<!-- Footer -->
<footer class="container footer mb20">
    <div class="row">
        <div class="col-md-6 bottom-informer">
            Do you have any questions or suggestions?<br />
            Let us know at <a href="javascript:void(0);">info@sofac.com</a>!
        </div>
        <div class="col-md-6 text-right bottom-menu"><a href="javascript:void(0);">Contact & Credits</a> | <a href="javascript:void(0);">Terms of Service</a> | <a href="javascript:void(0);">Privacy Policy</a></div>
    </div>
    <div class="mt20 text-center">Copyright &copy; 2017. All rights reserved.</div>
</footer>
<!-- #End Footer -->

<!-- Authorization modal window -->
<div id="authorizationModal" class="modal fade">
    <div class="modal-dialog">
        <div class="modal-content">

            <!-- Authorization modal title -->
            <form id="authorizationForm" method="post" class="form-horizontal">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                    <h4><i class="fa fa-user-o" aria-hidden="true"></i> 권한 부여</h4>
                </div>

                <!-- Authorization modal -->
                <div class="modal-body">
                    <div class="form-group">
                        <div class="col-lg-12 text-left">
                            <input type="email" name="email" class="form-control form-block" placeholder="이메일" required />
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-lg-12 text-left">
                            <input type="password" name="password" class="form-control form-block" placeholder="암호" required />
                        </div>
                    </div>
                </div>

                <!-- Authorization modal footer -->
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">닫기</button>
                    <button type="submit" class="btn btn-primary">들어가다</button>
                </div>
            </form>
        </div>
    </div>
</div>
<!-- #End Authorization modal window -->

<!-- Estimate modal window -->
<div id="estimationModal" class="modal fade">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">

            <!-- Estimate modal title -->
            <form id="estimationForm" method="post" class="form-horizontal" role="form" data-toggle="validator">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                    <h4><i class="fa fa-address-card-o" aria-hidden="true"></i> 문의 해 주세요...</h4>
                    <b>견적요청 및 문의사항을 남겨 주시면 1시간 이내에 답변을 메일로 보내드립니다.</b>
                    <div class="mt10"><small><i>이 페이지는 단 한번만 답변을 받으실 수 있습니다.<br /> 지속적인 대화가 필요할 경우 아이디를 발급 받으신 후 CASE를 통해서<br /> 지속적으로 대화를 하실 수 있습니다.</i></small></div>
                </div>

                <!-- Estimate modal -->
                <div class="modal-body">

                    <div class="row">
                        <!-- fields -->
                        <div class="col-md-4">
                            <div class="form-group">
                                <div class="col-lg-12 text-left">
                                    <input type="text" name="name" class="form-control form-block" placeholder="이름" required />
                                </div>
                            </div>

                            <div class="form-group">
                                <div class="col-lg-12 text-left">
                                    <input type="email" name="email" class="form-control form-block" placeholder="이메일" required />
                                </div>
                            </div>

                            <div class="form-group">
                                <div class="col-lg-12 text-left">
                                    <!-- <input type="text" name="phone" class="form-control form-block" pattern="[\+]\d{3}\s[\(]\d{2}[\)]\s\d{3}[\-]\d{4}$" data-format="+380 (dd) ddd-dddd" maxlength="100" placeholder="전화번호" required />-->
                                    <input type="text" name="phone" id="phone" class="form-control bfh-phone" value="" pattern="[\+]\d{2}\s[\(]\d{2}[\)]\s\d{4}[\-]\d{4}$" placeholder="전화번호" data-format="+82 (dd) dddd-dddd" maxlength="100" required />
                                </div>
                            </div>

                            <div class="checkbox">
                                <input id="request" name="request[]" class="styled" type="checkbox">
                                <label for="request">견적문의</label>
                            </div>

                            <div class="checkbox">
                                <input id="question" name="request[]" class="styled" type="checkbox">
                                <label for="question">일반문의</label>
                            </div>

                            <div class="form-group mt20">
                                <div class="col-lg-12 text-left">
                                    <input type="password" name="password" class="form-control form-block" placeholder="임시패스워드 (내용확인용)" required />
                                </div>
                            </div>
                        </div>
                        <!-- message -->
                        <div class="col-md-8">
                            <div class="form-group">
                                <div class="col-lg-12 text-left">
                                    <textarea class="form-control form-block" name="message" rows="12" placeholder="문의사항을 적어 주세요" required></textarea>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

                <!-- Estimate modal footer -->
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">닫기</button>
                    <button type="submit" class="btn btn-primary">보내기</button>
                </div>
            </form>
        </div>
    </div>
</div>
<!-- #End Estimate modal window -->

<script src="resources/newIndexPage/js/jquery.min.js"></script>
<script src="resources/newIndexPage/js/jquery-ui.min.js"></script>
<script src="resources/newIndexPage/js/jquery.mousewheel.min.js"></script>
<script src="resources/newIndexPage/js/jquery.fancybox.min.js"></script>
<script src="resources/newIndexPage/js/jquery.sweet-alert.min.js"></script>
<script src="resources/newIndexPage/js/bootstrap.min.js"></script>
<script src="resources/newIndexPage/js/bootstrap-form-helpers.min.js"></script>
<script src="resources/newIndexPage/js/bootstrap-select.min.js"></script>
<script src="resources/newIndexPage/js/bootstrap.validator.min.js"></script>
<script src="resources/newIndexPage/js/form-validation.min.js"></script>
<script src="resources/newIndexPage/js/main.js"></script>
</body>
</html>