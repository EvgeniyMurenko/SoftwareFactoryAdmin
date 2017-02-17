<%@ page import="com.SoftwareFactory.model.CustomerInfo" %>
<%@ page import="com.SoftwareFactory.model.Message" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="com.SoftwareFactory.model.Project" %>
<%@ page import="java.util.List" %><%--<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>--%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page session="false" %>
<!DOCTYPE html>
<html lang="kr">
<head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1, user-scalable=no, minimal-ui" />
    <meta name="format-detection" content="telephone=no" />
    <meta name="format-detection" content="address=no" />

    <meta property="og:site_name" content="software factory" />
    <meta property="og:title" content="소팩소개" />
    <meta property="og:image" content="/resources/newIndexPage/images/web-logo.jpg" />
    <meta property="og:url" content="http://www.sofac.kr/" />
    <meta property="og:description" content="" />

    <meta name="description" content="" />
    <meta name="keywords" content="" />

    <title>가격 및 유지보수 정책 :: Software Factory</title>

    <link href="/resources/newIndexPage/css/bootstrap.min.css" rel="stylesheet" />
    <link href="/resources/newIndexPage/css/bootstrap-select.min.css" rel="stylesheet" />
    <link href="/resources/newIndexPage/css/jquery.fancybox.min.css" rel="stylesheet" />
    <link href="/resources/newIndexPage/css/jquery.sweet-alert.min.css" rel="stylesheet" />
    <link href="/resources/newIndexPage/css/font-awesome.min.css" rel="stylesheet" />
    <link href="/resources/newIndexPage/css/awesome-bootstrap-checkbox.min.css" rel="stylesheet" />
    <link href="/resources/newIndexPage/css/fileinput.min.css" rel="stylesheet" />
    <link href="/resources/newIndexPage/css/style.css" rel="stylesheet" />
    <link href="/resources/newIndexPage/css/responsive.css" rel="stylesheet" />

    <link rel="apple-touch-icon" sizes="57x57" href="/resources/newIndexPage/images/apple-icon-57x57.png" />
    <link rel="apple-touch-icon" sizes="60x60" href="/resources/newIndexPage/images/apple-icon-60x60.png" />
    <link rel="apple-touch-icon" sizes="72x72" href="/resources/newIndexPage/images/apple-icon-72x72.png" />
    <link rel="apple-touch-icon" sizes="76x76" href="/resources/newIndexPage/images/apple-icon-76x76.png" />
    <link rel="apple-touch-icon" sizes="114x114" href="/resources/newIndexPage/images/apple-icon-114x114.png" />
    <link rel="apple-touch-icon" sizes="120x120" href="/resources/newIndexPage/images/apple-icon-120x120.png" />
    <link rel="apple-touch-icon" sizes="144x144" href="/resources/newIndexPage/images/apple-icon-144x144.png" />
    <link rel="apple-touch-icon" sizes="152x152" href="/resources/newIndexPage/images/apple-icon-152x152.png" />
    <link rel="apple-touch-icon" sizes="180x180" href="/resources/newIndexPage/images/apple-icon-180x180.png" />
    <link rel="icon" type="image/png" sizes="192x192"  href="/resources/newIndexPage/images/android-icon-192x192.png" />
    <link rel="icon" type="image/png" sizes="32x32" href="/resources/newIndexPage/images/favicon-32x32.png" />
    <link rel="icon" type="image/png" sizes="96x96" href="/resources/newIndexPage/images/favicon-96x96.png" />
    <link rel="icon" type="image/png" sizes="16x16" href="/resources/newIndexPage/images/favicon-16x16.png" />
    <link rel="manifest" href="/resources/newIndexPage/images/manifest.json" />
    <meta name="msapplication-TileColor" content="#ffffff" />
    <meta name="msapplication-TileImage" content="/resources/newIndexPage/images/ms-icon-144x144.png" />
    <meta name="theme-color" content="#ffffff" />

    <!--[if lt IE 9]>
    <script src="/resources/newIndexPage/js/html5shiv.js"></script>
    <script src="/resources/newIndexPage/js/respond.min.js"></script>
    <![endif]-->
</head>
<body>

<!-- Header -->
<header class="container header">
    <div class="row">
        <div class="col-lg-6 col-md-6 col-sm-6 logo">
            <div class="orange-button"><a href="./"><img src="/resources/newIndexPage/images/home-button.png" alt="" class="img-responsive position-center" /></a></div>
            <a href="./">소프트웨어<span>팩토리</span></a>
            <div class="small-logo">SoFAC : <i>Software Factory</i></div>
        </div>
        <div class="col-lg-6 col-md-6 col-sm-6 text-right login"><b>CASE OPEN</b> : <a href="javascript:void(0);" data-toggle="modal" data-target="#authorizationModal">고객 아이디로 로그인하세요</a></div>
    </div>
</header>
<!-- #End Header -->

<!-- Content -->
<section class="container content mb40">
    <div class="row pt40">
        <div class="col-md-8">

            <div style="margin-bottom: 50px;">

                <h3>SoFAC 개발 및 유지보수 비용 정책</h3>

                <table class="document-table2 other-font2">
                    <thead>
                    <tr>
                        <th class="hidden-xs"></th>
                        <th>항 목</th>
                        <th>항목설명</th>
                        <th>운영대응 방법</th>
                        <th>가격정책 (월)</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr style="background-color: #f9f9f9;">
                        <td class="hidden-xs">1</td>
                        <td>DEV</td>
                        <td>개발 작업만 의뢰할 경우</td>
                        <td>소프트웨어 개발만 의뢰 하는 경우 입니다.<br />(본사의 라이브러리 및 기술은 무상 제공 되지만 라이선스 필요한 기타 외부 개발 라이브러드등이 포함될 경우 비용은 별도입니다)</td>
                        <td>개발규모에 따라</td>
                    </tr>
                    <tr style="background-color: #f9f9f9;">
                        <td class="hidden-xs">2</td>
                        <td>ALL</td>
                        <td>개발작업<br />유지보수<br />업데이트<br />서버사용<br /><br />일괄포함</td>
                        <td>개발작업 및 개발 이후<br />- 소팩 IDC 를 통하여 일괄 의뢰<br />- 하드웨어 및 구성등은 소팩에서 책임 구성<br />- 패킷보안, 암호화 적용되어 있음<br />- 모니터링 서버와 연결되는 구조 내장<br />- 정기적 데이터 백업 기능 제공<br />- 접속 통계 자료 제공<br />- 사용자 폭주시를 위한 수축형 대응 체제<br />- 서버가 일시적으로 늘어나야 할 경우 자동<br />으로 증가되는 구조 내장</td>
                        <td>개발규모에 따라<br />개발비 책정<br />유지보수 별도 계약하는 구조<br /><br />기본유지보수0.5M/M<br />(월 일정 데이터 사용량이 초과 할 경우 추가 비용이 발생되며 3개월 이상 지속될 경우 계속 변경 필요함)</td>
                    </tr>
                    <tr style="background-color: #f9f9f9;">
                        <td class="hidden-xs">3</td>
                        <td>MNT</td>
                        <td>(상동)<br /><br />개발비 없이<br />지속 개발 및 유지보수 계약</td>
                        <td>(상동)</td>
                        <td>2번항목의<br />ALL 상품과 동일하나 개발비용은 천만원 이내에서 보증금 형태로 결정되며 지속적인 유지보수를 개념으로 하는 무비용 개발 정책</td>
                    </tr>
                    <tr>
                        <td class="hidden-xs">4</td>
                        <td>CSM</td>
                        <td>기업용 개발 및 유지보수 대행 상품<br />(지점 통해 대면 개발 가능)</td>
                        <td>- 개발은 소팩의 시스템을 활용하지만 인력 파견 및 영업 대응<br />- 기업 서버 사용(관리만 소팩이 수용 가능)<br />- 서버증설 및 사용자 증가에 따른 기술지원<br />- 비상상황 긴급 대응 지원<br />(보안 문제는 회사 내규에 따라 지원 받음)</td>
                        <td>0.2M/M</td>
                    </tr>
                    <tr>
                        <td class="hidden-xs">5</td>
                        <td>NOS</td>
                        <td>서버 장비가 준비되어 있을 경우 유지보수만 의뢰</td>
                        <td>검수 확인 및 작동 상태 확인 후 고객사에서 자에적으로 시스템 운영 (사고 발생시 인건비 별도 청구됨)</td>
                        <td>&nbsp;</td>
                    </tr>
                    <tr>
                        <td class="hidden-xs">6</td>
                        <td>RNT</td>
                        <td>본사의 IDC 장비 추가 임대시</td>
                        <td>- 모니터링 가능 (협의)<br />- 보안 규정 적응 할 수 있음 (협의)</td>
                        <td>(협의결정)</td>
                    </tr>
                    <tr>
                        <td class="hidden-xs">7</td>
                        <td>UPD</td>
                        <td>유지보수 계약을 하지 않은 고객의 업데이트 필요시</td>
                        <td>- 기존 기능의 일정 부분 수정 및 버젼 업데이트<br />(신규개발 제외)</td>
                        <td>0.04 M/M (월)</td>
                    </tr>
                    </tbody>
                </table>

                <h3 class="mt40 mb0" style="font-size: 12pt;">[SoFAC  IDC 제공사항]</h3>
                <table class="document-table2 other-font2">
                    <thead>
                    <tr>
                        <th>서버</th>
                        <th>서버장비 보유상태</th>
                        <th>모니터링</th>
                        <th>과금</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <td width="20%">- 데이터베이스서버<br />- 데몬 작동 서버<br />- 일반 윈도우 서버<br />- 백업 서버<br />- 스트리밍 서버<br />- 보안장비<br />- 앱서비스 서버</td>
                        <td>서버는 국내외 유명 IDC에서 일정 장비를 임대 또는 아마존 서버 사용</td>
                        <td>본사에서 개발한 앱 또는 소프트웨어는 모니터링 시스템과 지속적으로 생존 여부를 판단하는 프로세서가 가동으로 비상사태 대응</td>
                        <td>서비스 사용량 예측에 의한 가격테이블에 따라 과금 되며 독자적으로 운영하는 비용보다 훨씬 저렴하지만 데이터 폭주로 안하여 계약 범위를 넘어갈 경우 계약금액 수정 필요함</td>
                    </tr>
                    <tr>
                        <td colspan="4">- 패킷보안, 데이터암호화, 백업, 폭주시대응 등의 서비스가 제공되고 있으며<br />- 인터넷 회선 또한 사용자가 갑자기 늘어날 경우 일단 자동 확장 대응 후 과금<br />- 본사 운영 IDC는 속도 및 서버를 유동적으로 사용하는 구조이므로 작게 사용하시면서도 가끔 크게 대응<br />할 수 있으며 계약된 금액 이상의 트래픽을 사용하게 될 경우 그 부분에 대한 금액만 과금 됩니다.</td>
                    </tr>
                    </tbody>
                </table>

                <h3 class="mt40 mb0" style="font-size: 12pt;">[본사 IDC 정책]</h3>
                <table class="document-table2 other-font2">
                    <thead>
                    <tr>
                        <th>항목</th>
                        <th>제공 네용</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <td>본사제공IDC</td>
                        <td>본사는 서버 장비 계약 및 서버프로그램 설치등의 불편함을 해결하고<br />보안 문제나 백업 문제 그리고 24시간 모니터링에 관련된 모든 문제를 해결하고자<br />대형 IDC에서 서버를 확보하여 본 서비스에 맞게 가상화 하여 제공하고 있습니다.<br />따라서 비상상황 대응 구조도 갖추고 있으며 단지 업무에만 집중 할 수 있도록 제공해 드리는<br />서비스를 의미 합니다.</td>
                    </tr>
                    <tr>
                        <td>과금</td>
                        <td>일반 IDC 서버보다 매우 저렴하여 부담감을 느끼실 필요가 없는 정도의 수준이 될 것이나<br />단지 폭주 및 지속적인 데이터 발생량이 기준치를 넘어가게 되면 가격 정책 변경 됨</td>
                    </tr>
                    <tr>
                        <td>플랫폼 소프트웨어<br />비용 문제</td>
                        <td>서버에 설치된 각종 소프트웨어도 감사대상입니다.<br />따라서 구입하지 않은 제품으로 사용할 경우 문제가 됩니다.<br />이 문제도 본사의 IDC를 활용하면 모두 해결됩니다.</td>
                    </tr>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</section>
<!-- #End Content -->

<!-- Footer -->
<footer class="container footer mb20">
    <div class="row">
        <div class="col-md-6 col-sm-6 bottom-informer">
            Do you have any questions or suggestions?<br />
            Let us know at <a href="javascript:void(0);">info@sofac.com</a>!
        </div>
        <div class="col-md-6 col-sm-6 text-right bottom-menu"><a href="javascript:void(0);">Contact & Credits</a> | <a href="javascript:void(0);">Terms of Service</a> | <a href="javascript:void(0);">Privacy Policy</a></div>

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
                    <h4><i class="fa fa-user-o" aria-hidden="true"></i> 고객님 CASE 로그인에 오신 것을 환영합니다.</h4>
                    <div class="ml30">발급 받은 고객번호와 패스워드를 입력해 주세요</div>
                </div>

                <!-- Authorization modal content -->
                <div class="modal-body">
                    <div class="row">
                        <div class="col-md-6 mb10 text-center"><img src="/resources/newIndexPage/images/hello-womam.jpg" class="img-responsive position-center" alt=""></div>
                        <div class="col-md-6">
                            <div class="form-group">
                                <div class="col-lg-12 text-left">
                                    <input type="email" name="email" class="form-control form-block" placeholder="고객 ID" required />
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-lg-12 text-left">
                                    <input type="password" name="password" class="form-control form-block" placeholder="패스워드" required />
                                </div>
                            </div>

                            <div class="form-group">
                                <div class="col-lg-12 text-left">
                                    <button type="submit" class="btn btn-primary btn-mobile">로그인</button>
                                </div>
                            </div>

                            <div class="mt10 mb10 forgot-password"><a href="javascript:void(0);">패스워드를 잊어 버리셨나요 ?</a></div>

                            <p class="mt20"><span style="font-size: 9pt;"><i>고객ID는 SoFAC 과 지속적인 대화를 원하실 경우<br />
                                    임시고객ID를 발급하여 드립니다.<br />
                                    발급요청은 초기 화면에서 문의하기를 통해서<br />
                                    접수하실 수 있습니다.<br />
                                    일회성 질문이나 견적문의는 고객ID를 발급하지<br />
                                    않습니다.</i></span>
                            </p>
                        </div>
                    </div>
                </div>

                <!-- Authorization modal footer -->
                <div class="modal-footer">
                    <button type="button" class="btn btn-default btn-mobile" data-dismiss="modal">닫기</button>
                </div>
            </form>
        </div>
    </div>
</div>
<!-- #End Authorization modal window -->

<script src="/resources/newIndexPage/js/jquery.min.js"></script>
<script src="/resources/newIndexPage/js/jquery-ui.min.js"></script>
<script src="/resources/newIndexPage/js/jquery.mousewheel.min.js"></script>
<script src="/resources/newIndexPage/js/jquery.fancybox.min.js"></script>
<script src="/resources/newIndexPage/js/jquery.sweet-alert.min.js"></script>
<script src="/resources/newIndexPage/js/jquery.timeago.js"></script>
<script src="/resources/newIndexPage/js/jquery.timeago.ko.js"></script>
<script src="/resources/newIndexPage/js/bootstrap.min.js"></script>
<script src="/resources/newIndexPage/js/bootstrap-form-helpers.min.js"></script>
<script src="/resources/newIndexPage/js/bootstrap-select.min.js"></script>
<script src="/resources/newIndexPage/js/bootstrap.validator.min.js"></script>
<script src="/resources/newIndexPage/js/fileinput.min.js"></script>
<script src="/resources/newIndexPage/js/sortable.min.js"></script>
<script src="/resources/newIndexPage/js/form-validation.min.js"></script>
<script src="/resources/newIndexPage/js/pagination.min.js"></script>
<script src="/resources/newIndexPage/js/main.js"></script>
</body>
</html>