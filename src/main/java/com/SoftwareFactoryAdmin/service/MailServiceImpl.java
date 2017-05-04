package com.SoftwareFactoryAdmin.service;

import com.SoftwareFactoryAdmin.model.MessageLink;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;

import javax.mail.Message;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Set;


@Service("mailService")
public class MailServiceImpl implements MailService {

    @Autowired
    JavaMailSender mailSender;

    String serverEmail = "sofac.team@gmail.com";


   public void sendEmailAfterEstimateRespond(String recipientMail , com.SoftwareFactoryAdmin.model.Message message){
       try {
           mailSender.send(new MimeMessagePreparator() {

               public void prepare(MimeMessage mimeMessage) throws Exception {

                   StringBuilder allLinks = new StringBuilder();

                   Set<MessageLink> messageLinks = message.getMessageLinks();

                   for (MessageLink messageLink : messageLinks){
                       allLinks.append("<p><a href="+messageLink.getFileLink()+">"+messageLink.getFileName()+"</a></p>");
                   }


                   mimeMessage.setFrom(new InternetAddress(serverEmail, "SoFAC"));
                   mimeMessage.setRecipient(Message.RecipientType.TO,
                           new InternetAddress(recipientMail));
                   mimeMessage.setSubject("You have a new message in sofac.kr", "utf-8");
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
                           "        @import url(http://fonts.googleapis.com/earlyaccess/nanumgothic.css);\n" +
                           "\n" +
                           "        html, body {\n" +
                           "            font-family: 'Nanum Gothic', Arial, Tahoma, Verdana, sans-serif;\n" +
                           "            font-size: 11pt;\n" +
                           "            width: 100%;\n" +
                           "        }\n" +
                           "    </style>\n" +
                           "\n" +
                           "</head>\n" +
                           "<body style=\"margin: 0; padding: 0; -webkit-font-smoothing: antialiased;\n" +
                           "            mso-margin-top-alt: 0; mso-margin-bottom-alt: 0; mso-padding-alt: 0; background: #E7E7E7;\">\n" +
                           "<div style=\"width: 850px; height: 100%;\n" +
                           "            background: #ffffff; overflow: hidden; margin: 20px auto 40px auto; box-shadow: 0 0 7px #cdcccc;\n" +
                           "            -webkit-box-shadow: 0 0 7px #cdcccc; -moz-box-shadow: 0 0 7px #cdcccc; -o-box-shadow: 0 0 7px #cdcccc;\">\n" +
                           "\n" +
                           "    <!-- Header -->\n" +
                           "    <div style=\"padding: 10px 0 15px 0; margin: 10px; border-bottom: 1px solid #eee; height: 55px;\">\n" +
                           "        <div style=\"float: left;\">\n" +
                           "            <a href=\"http://www.sofac.kr\" target=\"_blank\" style=\"text-decoration: none; font-size: 24pt; color: #333;\">소프트웨어<span\n" +
                           "                        style=\"font-weight: 600; color: #03a9f4;\">팩토리</span></a>\n" +
                           "            <div style=\"font-size: 9pt; color: #999;\">SoFAC : <span style=\"font-style: italic;\">Software Factory</span>\n" +
                           "            </div>\n" +
                           "        </div>\n" +
                           "\n" +
                           "        <div style=\"float: right; padding-top: 15px;\">\n" +
                           "            <a href=\"http://www.sofac.kr/whatIsSofac\" target=\"_blank\" style=\"color: #03a9f4; cursor: pointer !important; text-decoration: none;\">소프트웨어 팩토리 란 무엇입니까?</a>\n" +
                           "        </div>\n" +
                           "    </div>\n" +
                           "    <!-- #End Header -->\n" +
                           "\n" +
                           "    <!-- Content -->\n" +
                           "    <div style=\"margin: 20px 10px; content: ''; clear: both;\">\n" +
                           "\n" +

                           "        <p>"+message.getMessageText()+"</p>\n" +

                                    allLinks.toString() +

                           "        <p>No need to reply to this email.</p>\n" +
                           "\n" +
                           "    </div>\n" +
                           "    <!-- #End Content -->\n" +
                           "\n" +
                           "    <!-- Footer -->\n" +
                           "    <div style=\"height: 50px; margin: 20px 10px 10px 10px; padding-top: 15px; border-top: 1px solid #eee;\">\n" +
                           "\n" +
                           "        <div style=\"color: #999; font-size: 9pt; float: left;\">\n" +
                           "            Policy of SoFAC<br/>\n" +
                           "            <a href=\"http://www.sofac.kr/policy\" style=\"color: #03a9f4; cursor: pointer !important; text-decoration: none;\"><span style=\"font-size: 9pt;\">SoFAC 고객 정책</span></a>\n" +
                           "        </div>\n" +
                           "        <div style=\"color: #999; font-size: 9pt; float: right; text-align: right;\">\n" +
                           "            220-87-45112<br/>\n" +
                           "            서울시 강남구 역삼동 해성빌딩 7층<br/>\n" +
                           "            대표자 : 박상만\n" +
                           "        </div>\n" +
                           "\n" +
                           "    </div>\n" +
                           "    <div style=\"color: #999; font-size: 9pt; text-align: center; padding: 10px;\">\n" +
                           "        Copyright © 2016. All rights reserved\n" +
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