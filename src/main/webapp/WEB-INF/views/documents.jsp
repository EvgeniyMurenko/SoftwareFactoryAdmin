<%@ page import="java.util.Locale" %>
<%@ page import="org.springframework.web.servlet.support.RequestContextUtils" %><%--<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>--%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page session="false" %>

<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1, user-scalable=no, minimal-ui" />
    <meta name="format-detection" content="telephone=no" />
    <meta name="format-detection" content="address=no" />

    <meta name="description" content="" />
    <meta name="keywords" content="" />

    <title>Certification &amp; News :: Software Factory</title>

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
            <div class="orange-button"><a href="./"><img src="resources/newIndexPage/images/home-button.png" alt="" class="img-responsive position-center" /></a></div>
            <a href="./">소프트웨어<span>팩토리</span></a>
            <div class="small-logo">SoFAC : <i>Software Factory</i></div>
        </div>
        <div class="col-lg-6 col-md-6 col-sm-6 text-right login"><a href="javascript:void(0);">이미 회원입니까? 로그인하십시오!</a></div>
    </div>
</header>
<!-- #End Header -->

<!-- Content -->
<section class="container content mb40">
    <div class="row pt40">
        <div class="col-md-8">

            <div class="row mb30">
                <div class="col-md-10"><a data-fancybox="gallery" href="resources/newIndexPage/images/image004.png"><img src="resources/newIndexPage/images/image004.png" alt="" class="img-responsive" /></a></div>
            </div>

            <div style="margin-bottom: 50px;">

                <h3 style="font-size: 13pt;">소프트웨어팩토리 연혁</h3>

                <table class="document-table">
                    <tr>
                        <td>2004</td>
                        <td>굿앤굿 재무설계법인 설립</td>
                    </tr>
                    <tr>
                        <td>2007</td>
                        <td>기업지원을 위한 소프트웨어 연구 개발 자회사 설립</td>
                    </tr>
                    <tr>
                        <td>2008</td>
                        <td>일본CSK증권서비스 주식시세 배송 엔진 공급 일본 아이자와 증권 주식거래 시스템 개발 공급</td>
                    </tr>
                    <tr>
                        <td>2009</td>
                        <td>차세대 메세징 엔진 엔진 gTS 개발 완료</td>
                    </tr>
                    <tr>
                        <td>2010</td>
                        <td>패키지형 메세징 플랫폼 UC-STATION 개발 완료 스마트폰 시대를 대비한 “SPRIM” 기술 개발 시작 (모바일에서 원활한 소켓통신을 지원하기 위한 기술) 생활밀착형 앱 서비스 1472(일사천리) 서비스 시작 (www.1472.net)</td>
                    </tr>
                    <tr>
                        <td>2011</td>
                        <td>스마트폰 사업을 위한 기반 기술 “SPRIM”프로젝트 완성 1472서비스 1탄 (1472뷰티톡 서비스 오픈) 1472서비스 2탄 (1472워키톡 오픈) 1472서비스 3탄 (대학가자 어플 오픈)</td>
                    </tr>
                    <tr>
                        <td>2012</td>
                        <td>FXM 개발시스템 완성 (시나리오방식 소프트웨어 개발방법)</td>
                    </tr>
                    <tr>
                        <td>2013</td>
                        <td>FXM 공장화 개발 시스템 구축</td>
                    </tr>
                    <tr>
                        <td>2014</td>
                        <td>FXM 멤버쉽 제도 및 해외 인력 교육 및 멤법쉽화 사업</td>
                    </tr>
                    <tr>
                        <td>2015</td>
                        <td>베트남 IT대학제휴 및 개발 인력 교육</td>
                    </tr>
                    <tr>
                        <td>2016</td>
                        <td>우크라이나 소프트웨어 팩토리  엔지니어 코어 센터 구축</td>
                    </tr>
                    <tr>
                        <td></td>
                        <td>- 마이챗 미스리메신저, 삼성증권FN메신저등 개발<br />
                            - 정부 국책 지원기술 선정<br />
                            - 정통부장관상 수상<br />
                            - 정보통신부 Nep 신제품 인증<br />
                            - 국내 기업용 메시징 솔루션 1위 업체
                        </td>
                    </tr>
                </table>
            </div>

            <h3 style="font-size: 13pt;">인증자료</h3>

            <div class="row">
                <div class="col-md-6">
                    <div class="certificate">
                        <div class="cf-title">
                            <span class="mb10 text-center">SoFAC 개발 제품 일본에 상표등록</span>
                        </div>
                        <div class="text-center"><img src="resources/newIndexPage/images/serf4.jpg" alt="" class="img-responsive position-center"></div>
                    </div>
                </div>
                <div class="col-md-6">
                    <div class="certificate">
                        <div class="cf-title">
                            <span class="mb10 text-center">특허 제 10-2014-0034487호</span>
                        </div>
                        <div class="text-center"><img src="resources/newIndexPage/images/serf3.jpg" alt="" class="img-responsive position-center"></div>
                    </div>
                </div>
            </div>
            <div class="row mt20">
                <div class="col-md-6">
                    <div class="certificate">
                        <div class="cf-title">
                            <span class="mb10 text-center">일본에서 인정한 통신 기술 라이센스</span>
                        </div>
                        <div class="text-center"><img src="resources/newIndexPage/images/serf5.jpg" alt="" class="img-responsive position-center"></div>
                    </div>
                </div>
                <div class="col-md-6">
                    <div class="certificate">
                        <div class="cf-title">
                            <span class="mb10 text-center">ISO9001 인증</span>
                        </div>
                        <div class="text-center"><img src="resources/newIndexPage/images/serf1.jpg" alt="" class="img-responsive position-center"></div>
                    </div>
                </div>
            </div>
            <div class="row mt20">
                <div class="col-md-6">
                    <div class="certificate">
                        <div class="cf-title">
                            <span class="mb10 text-center">스마트폰에서 실시간 통신 특허 획득</span>
                        </div>
                        <div class="text-center"><img src="resources/newIndexPage/images/serf6.jpg" alt="" class="img-responsive position-center"></div>
                    </div>
                </div>
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

<script src="resources/newIndexPage/js/jquery.min.js"></script>
<script src="resources/newIndexPage/js/jquery-ui.min.js"></script>
<script src="resources/newIndexPage/js/jquery.mousewheel.min.js"></script>
<script src="resources/newIndexPage/js/jquery.fancybox.min.js"></script>
<script src="resources/newIndexPage/js/jquery.sweet-alert.min.js"></script>
<script src="resources/newIndexPage/js/bootstrap.min.js"></script>
<script src="resources/newIndexPage/js/bootstrap-select.min.js"></script>
<script src="resources/newIndexPage/js/bootstrap.validator.min.js"></script>
<script src="resources/newIndexPage/js/main.js"></script>
</body>
</html>