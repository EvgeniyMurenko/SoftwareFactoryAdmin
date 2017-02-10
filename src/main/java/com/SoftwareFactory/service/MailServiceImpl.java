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
    public void sendEmail(String recipientMail , String recipientName) {

        try {
            mailSender.send(new MimeMessagePreparator() {

                public void prepare(MimeMessage mimeMessage) throws Exception {
                    mimeMessage.setFrom("SoftwareFactory@server.com");
                    mimeMessage.setRecipient(Message.RecipientType.TO,
                            new InternetAddress(recipientMail));
                    mimeMessage.setSubject("helloMessage");
                    mimeMessage.setContent("" ,"text/html");
                }
            });
            System.out.println("Message Send...Hurrey");
        } catch (MailException ex) {
            System.err.println(ex.getMessage());
        }
    }

    @Override
    public void sendEmailAfterRegistration(String password, String login) {

    }


    public void sendEmailAfterEstimate(String estimateId, String registrationLink , String recipientMail)  {
        try {
            mailSender.send(new MimeMessagePreparator() {

                public void prepare(MimeMessage mimeMessage) throws Exception {
                    mimeMessage.setFrom("SoftwareFactory@server.com");
                    mimeMessage.setRecipient(Message.RecipientType.TO,
                            new InternetAddress(recipientMail));
                    mimeMessage.setSubject("[자동발송] 소프트웨어팩토리에 문의해 주셔서 감사드립니다. ("+ estimateId + ")" , "utf-8");
                    mimeMessage.setContent(
                            "<p><b>접수번호 : "+estimateId+"</b></p>" +
                            "<p>먼저 소프트웨어팩토리에 문의해 주셔서 감사드립니다.<br>\n" +
                            "문의 하신 내용은 대부분 소프트웨어를 만들기 위한 아이디어나 정해진 작업 내용에 대한 가격 및 업무 방법일 것입니다.</p>\n" +
                            "<p>따라서 고객님의 요청내용은 작업의 종류의 규모를 기준으로 기술적인 견적과 업무 방법 그리고 기초적인 분석 자료를 함께 보내드립니다.</p>\n" +
                            "<p>대부분 업무시간 이내의 경우 3시간 이내에 답변을 드리며 질문이 필요할 경우 질문 메일을 드릴 수 도 있습니다.</p>\n" +
                            "<p>내용 확인 후 지속적인 대화를 원하실 경우 소팩은 CASE라는 개념으로 고객과 소통하는 기능을 제공하고 있습니다.<br>\n" +
                            "따라서 예비 고객등록을 먼저 해 주시면 아이디를 발급해 드리며<br>\n" +
                            "그 아이디를 통하여 지속적인 대화가 가능합니다. (CASE ID 발급 요청 : "+ registrationLink +")<br>\n" +
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
                            "<p><i>(이 메일은 발송 전용 메일 입니다.)</i></p>", "text/html; charset=utf-8" );

                }
            });
            System.out.println("Message Send...Hurrey");
        } catch (MailException ex) {
            System.err.println(ex.getMessage());
        }
    }




}