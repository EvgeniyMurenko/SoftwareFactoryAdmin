package com.SoftwareFactory.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;

import javax.mail.Message;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


@Service("mailService")
public class MailServiceImpl implements MailService {

    @Autowired
    JavaMailSender mailSender;


    @Override
    public void sendEmailAfterRegistration(String password, String login , String recipientMail , String recipientName) {
        try {
            mailSender.send(new MimeMessagePreparator() {

                public void prepare(MimeMessage mimeMessage) throws Exception {
                    mimeMessage.setFrom(new InternetAddress("sorcus100500@gmail.com", "SoFAC"));
                    mimeMessage.setRecipient(Message.RecipientType.TO,
                            new InternetAddress(recipientMail));
                    mimeMessage.setSubject("소프트웨어팩토리에 가입 하신 것을 축하드립니다." , "utf-8");
                    mimeMessage.setContent(
                            "안녕하세요 "+ recipientName + " 고객님" +
                                    "<br>" +
                                    "먼저 소프트웨어팩토리에 회원이 되신 것을 감사드립니다." +
                                    "<br><br>" +
                                    "정상적으로 가입 처리가 완료 되었습니다." +
                                    "<br><br>" +
                                    "고객님의 아이디는 : " + login +"  입니다." +
                                    "<br>" +
                                    "패스워드는 : " + password +" 입니다.  " +
                                    "<br><br>" +
                                    "<p>최초 패스워드는 고객님의 패스워드 입니다.<br>" +
                                    "로그인 후 수정하시기 바랍니다.</p>\n" +
                                    "\n" +
                                    "고객님은 소프트웨어팩토리 웹사이트(www.sofac.kr) 에서 위의 계정을 로그인 하신 후 다양한 형태의 대화를 나눌 수 있습니다.<br>\n" +
                                    "견적, 작업내용정리, 작업과정참여, 테스트, 업그레이드요청 등 모든 종류의 대화는 CASE를 통해서 가능합니다." +
                                    "<br><br>" +
                                    "<p>CASE는 정확한 약속을 드립니다." +
                                    "<br>"+
                                    "언제까지 어떤 결과에 대한 답변을 드릴 것을 약속하는 시스템입니다.<br>\n" +
                                    "그러므로 고객님은 편안한 느낌으로 지속적인 대화와 업무 진행 과정을 함께 하실 수 있습니다.<br>\n" +
                                    "CASE에 잘 적응하셔서 편안하고 안전한 소프트웨어 개발 지원 받으시기 바랍니다.</p>\n" +
                                    "\n" +
                                    "<p><i>참고로<br>\n" +
                                    "소프트웨어는 스마트폰이 지배하는 SNS 시대에 사업이나 각종 업무에 필수적인 요소 입니다.<br>\n" +
                                    "제 4산업으로 일컫는 새로운 시대는 소프트웨어 세상을 지배하는 시대를 말합니다.<br>\n" +
                                    "고객님이 무슨 일을 하던 소프트웨어 지원 없이는 비즈니스가 불가능한 것이 현대 사회의 <br>\n" +
                                    "특징입니다.<br>\n" +
                                    "소프트웨어팩토리는 고객님이 필요로 하는 다양한 종류의 소프트웨어 개발 대행 및 유지보수 대행을 전문적으로 하는 다국적 기업입니다.</p>\n" +
                                    "\n" +
                                    "<br>\n" +
                                    "<p>(이 메일은 발송 전용 메일 입니다.)</i></p>", "text/html; charset=utf-8" );

                }
            });
            System.out.println("Message Send...Hurrey");
        } catch (MailException ex) {
            System.err.println(ex.getMessage());
        }
    }



    public void sendEmailAfterEstimate(String estimateId, String registrationLink, String recipientMail) {
        try {
            mailSender.send(new MimeMessagePreparator() {

                public void prepare(MimeMessage mimeMessage) throws Exception {
                    mimeMessage.setFrom(new InternetAddress("sorcus100500@gmail.com", "SoFAC"));
                    mimeMessage.setRecipient(Message.RecipientType.TO,
                            new InternetAddress(recipientMail));
                    mimeMessage.setSubject("[자동발송] 소프트웨어팩토리에 문의해 주셔서 감사드립니다. (" + estimateId + ")", "utf-8");
                    mimeMessage.setContent(
                            "<p><b>접수번호 : " + estimateId + "</b></p>" +
                                    "<p>먼저 소프트웨어팩토리에 문의해 주셔서 감사드립니다.<br>\n" +
                                    "문의 하신 내용은 대부분 소프트웨어를 만들기 위한 아이디어나 정해진 작업 내용에 대한 가격 및 업무 방법일 것입니다.</p>\n" +
                                    "<p>따라서 고객님의 요청내용은 작업의 종류의 규모를 기준으로 기술적인 견적과 업무 방법 그리고 기초적인 분석 자료를 함께 보내드립니다.</p>\n" +
                                    "<p>대부분 업무시간 이내의 경우 3시간 이내에 답변을 드리며 질문이 필요할 경우 질문 메일을 드릴 수 도 있습니다.</p>\n" +
                                    "<p>내용 확인 후 지속적인 대화를 원하실 경우 소팩은 CASE라는 개념으로 고객과 소통하는 기능을 제공하고 있습니다.<br>\n" +
                                    "따라서 예비 고객등록을 먼저 해 주시면 아이디를 발급해 드리며<br>\n" +
                                    "그 아이디를 통하여 지속적인 대화가 가능합니다. (CASE ID 발급 요청 : <a href=\"http://"+registrationLink+"\">" + registrationLink + "</a>)<br>\n" +
                                    "질문과 답변 형식으로 대화가 진행되며 대화는 견적, 작업방법등 모든 종류의 대화 진행이 가능합니다. <br>\n" +
                                    "소팩은 소프트웨어(앱, 웹, IOT 등) 개발 및 유지보수 서비스를 대행하는 기업 입니다.<br>\n" +
                                    "<br>" +
                                    "전세계의 개발 인프라들을 FXM이라는 공장형 작업 관리시스템에 의해서 대량 작업 및<br>\n" +
                                    "원가절감 퀄리티 높은 완성도를 유지하고 있습니다.</p>\n" +
                                    "<p>소팩은 소프트웨어 개발 대행 업계에서 유일하게 세계적 인프라를 갖추어<br>\n" +
                                    "저 비용 고효율, 지속성 유지를 가능하게 하고 있습니다.</p>\n" +
                                    "\n" +
                                    "<p>자세한 내용은 홈페이지를 참고 하시기 바랍니다.<br>\n" +
                                    "www.sofac.kr</p>\n" +
                                    "\n" +
                                    "<p>감사합니다.</p>\n" +
                                    "\n" +
                                    "<p><i>(이 메일은 발송 전용 메일 입니다.)</i></p>", "text/html; charset=utf-8");

                }
            });
            System.out.println("Message Send...Hurrey");
        } catch (MailException ex) {
            System.err.println(ex.getMessage());
        }
    }
}