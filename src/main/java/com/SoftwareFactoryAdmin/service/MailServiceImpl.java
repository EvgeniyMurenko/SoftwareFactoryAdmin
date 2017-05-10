package com.SoftwareFactoryAdmin.service;

import com.SoftwareFactoryAdmin.model.MessageLink;
import com.SoftwareFactoryAdmin.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;

import javax.mail.Message;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.text.SimpleDateFormat;
import java.util.Set;


@Service("mailService")
public class MailServiceImpl implements MailService {

    @Autowired
    JavaMailSender mailSender;

    String serverEmail = "sofac.team@gmail.com";

    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy년MM월dd일HH시mm분에 고객님께서 문의하신 내용에 대해서 답변드립니다.");


   public void sendEmailAfterEstimateRespond(String recipientMail , com.SoftwareFactoryAdmin.model.Message message, User customerUser, String registrationLink){

       String textFooterNotFoolCreation = "<!-- Content Footer -->\n" +
               "\t<div style=\"margin: 20px 10px !important; content: '' !important; clear: both !important;padding: 5px 15px !important;\">\n" +
               "\t\t<p>이 메일은 문의 코너를 통해서 접수된 내용에 대한 답변 메일 입니다.</p>\n" +
               "\t\t<p>내용을 확인 하신 후 지속적인 문의가 필요하거나</p>\n" +
               "\t\t<p>저희 회사와 거래를 원하실 경우 고객등록을 먼저 하셔야 합니다.</p>\n" +
               "\t\t<p>고객 등록 이후에는 CASE라는 코너를 통해서 지속적인 대화가 가능합니다.</p>\n" +
               "\t\t<p>고객 등록을 원하시면 아래 URL을 클릭해 주세요</p>\n" +
               "\t\t<p>(CASE ID 발급 요청 : <a href = \""+registrationLink+"\" style=\"color: #03a9f4 !important; cursor: pointer !important; text-decoration: none !important;\">"+registrationLink+"</a>)</p>\n" +
               "\t\t<br><p>소프트웨어팩토리 바로가기 <a href = \"www.sofac.kr\" style=\"color: #03a9f4 !important; cursor: pointer !important; text-decoration: none !important;\">www.sofac.kr</a></p>\n" +
               "\t</div>\n" +
               "\t<!-- #End Content Footer -->";

       String textFooterFoolCreation = "<!-- Content Footer2 -->\n" +
               "\t<div style=\"margin: 20px 10px !important; content: '' !important; clear: both !important;padding: 5px 15px !important;\">\n" +
               "\t\t<p>이 메일은 문의 코너를 통해서 접수된 내용에 대한 답변 메일 입니다.</p>\n" +
               "\t\t<p>내용을 확인 하신 후 지속적인 연속된 질문이 필요하실 경우</p>\n" +
               "\t\t<p>아래를 클릭 하시면 CASE 코너를 통해서 손쉽게 문의하실 수 있습니다.</p>\n" +
               "\n" +
               "\t\t<br><p>고객님은 이미 아이디를 가지고 계십니다.</p>\n" +
               "\t\t<p>고객 ID : "+customerUser.getSsoId()+"</p>\n" +
               "\t\t<p><a href = \""+registrationLink+"\" style=\"color: #03a9f4 !important; cursor: pointer !important; text-decoration: none !important;\">CASE 로그인을 페이지로 이동 …</a></p>\n" +
               "\n" +
               "\t</div>\n" +
               "\t<!-- #End Content Footer2 -->";
       String footerText;
       if(message.getaCase().getProject().getCustomerInfo().isFullCreated()){
           footerText = textFooterFoolCreation;
       }else {
           footerText = textFooterNotFoolCreation;
       }

       try {
           mailSender.send(new MimeMessagePreparator() {


               public void prepare(MimeMessage mimeMessage) throws Exception {

                   StringBuilder allLinks = new StringBuilder();

                   Set<MessageLink> messageLinks = message.getMessageLinks();

                   for (MessageLink messageLink : messageLinks){
                       allLinks.append("<p><a href="+messageLink.getFileLink()+" target=\\\"_blank\\\" style=\"color: #03a9f4 !important; cursor: pointer !important; text-decoration: none !important;\">"+messageLink.getFileName()+"</a></p>");
                   }


                   mimeMessage.setFrom(new InternetAddress(serverEmail, "SoFAC"));
                   mimeMessage.setRecipient(Message.RecipientType.TO,
                           new InternetAddress(recipientMail));
                   mimeMessage.setSubject("[SoFAC] 소프트웨어팩토리에서 보내드립니다.", "utf-8");
                   mimeMessage.setContent("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\"\n" +
                           "        \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\n" +
                           "<html xmlns=\"http://www.w3.org/1999/xhtml\">\n" +
                           "<head>\n" +
                           "    <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\"/>\n" +
                           "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\"/>\n" +
                           "    <meta name=\"viewport\"\n" +
                           "          content=\"width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1, user-scalable=no, minimal-ui\"/>\n" +
                           "    <meta name=\"format-detection\" content=\"telephone=no\"/>\n" +
                           "    <meta name=\"format-detection\" content=\"address=no\"/>\n" +
                           "\n" +
                           "    <title>소프트웨어팩토리</title>\n" +
                           "\n" +
                           "    <style type=\"text/css\">\n" +
                           "        @import url(http://fonts.googleapis.com/earlyaccess/nanumgothic.css) !important;\n" +
                           "\n" +
                           "        html, body {\n" +
                           "            font-family: 'Nanum Gothic', Arial, Tahoma, Verdana, sans-serif !important;\n" +
                           "            font-size: 11pt !important;\n" +
                           "            width: 100% !important;\n" +
                           "        }\n" +
                           "    </style>\n" +
                           "\n" +
                           "</head>\n" +
                           "<body style=\"margin: 0 !important; padding: 0 !important; -webkit-font-smoothing: antialiased !important;\n" +
                           "            mso-margin-top-alt: 0 !important; mso-margin-bottom-alt: 0 !important; mso-padding-alt: 0 !important; background: #E7E7E7 !important;\">\n" +
                           "<div style=\"width: 850px !important; height: 100% !important;\n" +
                           "            background: #ffffff !important; overflow: hidden !important; margin: 20px auto 40px auto !important; box-shadow: 0 0 7px #cdcccc !important;\n" +
                           "            -webkit-box-shadow: 0 0 7px #cdcccc !important; -moz-box-shadow: 0 0 7px #cdcccc !important; -o-box-shadow: 0 0 7px #cdcccc !important;\">\n" +
                           "\n" +
                           "    <!-- Header -->\n" +
                           "    <div style=\"padding: 10px 0 15px 0 !important; margin: 10px !important; border-bottom: 1px solid #eee !important; height: 55px !important;\">\n" +
                           "        <div style=\"float: left !important;\">\n" +
                           "            <a href=\"http://www.sofac.kr\" target=\"_blank\" style=\"text-decoration: none !important; font-size: 24pt !important; color: #333 !important;\">\n" +
                           "                소프트웨어<span style=\"font-weight: 600 !important; color: #03a9f4 !important;\">팩토리</span></a>\n" +
                           "            <div style=\"font-size: 9pt !important; color: #999 !important;\">SoFAC : <span style=\"font-style: italic !important;\">Software Factory</span>\n" +
                           "            </div>\n" +
                           "        </div>\n" +
                           "\n" +
                           "        <div style=\"float: right !important; padding-top: 15px !important;\">\n" +
                           "            <a href=\"http://www.sofac.kr/whatIsSofac\" target=\"_blank\" style=\"color: #03a9f4 !important; cursor: pointer !important; text-decoration: none !important;\">소프트웨어 팩토리 란 무엇입니까?</a>\n" +
                           "        </div>\n" +
                           "    </div>\n" +
                           "    <!-- #End Header -->\n" +
                           "\t\n" +
                           "\t<!-- Content Header -->\n" +
                           "\t<div style=\"margin: 20px 10px !important; content: '' !important; clear: both !important;padding: 5px 15px !important;\">\n" +
                           "\t\t<p>안녕하세요 </p>\n" +
                           "\t\t<p>소프트웨어 팩토리 입니다.</p>\n" +
                           "\t\t<p>"+dateFormat.format(message.getMessageTime())+"</p>\n" +
                           "\t\t<p>문의결과와 첨부 파일을 확인해 주세요</p>\n" +
                           "\n" +
                           "\t\t<p>클릭하시면 첨부파일을 보실 수 있습니다  </p>\n" +
                           "\t\t<div style=\"float: left; padding-top: 0px; padding-left:10px; color: #03a9f4 !important\">\n" +
                                allLinks+
                           "\t\t</div>\n" +
                           "\t</div>\n" +
                           "\t<!-- End Content Header -->\n" +
                           "\n" +
                           "    <!-- Content -->\n" +
                           "    <div style=\"margin: 20px 10px !important; content: '' !important; clear: both !important; background: #ddd !important; padding: 5px 15px !important;\">\n" +
                           "\n" +
                                   message.getMessageText()+
                           "\n" +
                           "    </div>\n" +
                           "    <!-- #End Content -->\n" +
                           "\t\n" +
                           footerText+
                           "\n" +
                           "    <!-- Footer -->\n" +
                           "    <div style=\"height: 50px !important; margin: 20px 10px 10px 10px !important; padding-top: 15px !important; border-top: 1px solid #eee !important;\">\n" +
                           "\n" +
                           "        <div style=\"color: #999 !important; font-size: 9pt !important; float: left !important;\">\n" +
                           "            Policy of SoFAC<br/>\n" +
                           "            <a href=\"http://www.sofac.kr/policy\" style=\"color: #03a9f4 !important; cursor: pointer !important; text-decoration: none !important;\"><span style=\"font-size: 9pt !important;\">SoFAC 고객 정책</span></a>\n" +
                           "        </div>\n" +
                           "        <div style=\"color: #999 !important; font-size: 9pt !important; float: right !important; text-align: right !important;\">\n" +
                           "            220-87-45112<br/>\n" +
                           "            서울시 강남구 역삼동 해성빌딩 7층<br/>\n" +
                           "            대표자 : 박상만\n" +
                           "        </div>\n" +
                           "\n" +
                           "    </div>\n" +
                           "    <div style=\"color: #999 !important; font-size: 9pt !important; text-align: center !important; padding: 10px !important;\">\n" +
                           "        Copyright © 2017. All rights reserved\n" +
                           "    </div>\n" +
                           "    <!-- Footer -->\n" +
                           "\n" +
                           "</div>\n" +
                           "</body>\n" +
                           "</html>", "text/html; charset=utf-8");

               }
           });
           System.out.println("Message Send...Hurrey");
       } catch (MailException ex) {
           System.err.println(ex.getMessage());
       }
    }

}