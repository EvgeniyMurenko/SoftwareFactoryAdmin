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

       String textFooterNotFoolCreation = "<tr>\t\t\t\t\t\t \n" +
               "\t\t\t\t\t\t<td style=\"padding: 30px 0px 0px; text-align: left; color: rgb(51, 51, 51); line-height: 18px; font-family: Lucida Grande, Helvetica, Arial, sans-serif; font-size: 14px; -webkit-font-smoothing: antialiased; font-smooth: always;\">\n" +
               "\t\t\t\t\t\t\t이 메일은 문의 코너를 통해서 접수된 내용에 대한 답변 메일 입니다.\n" +
               "\t\t\t\t\t\t</td>\t\t\t\t\t\t \n" +
               "\t\t\t\t\t</tr>\n" +
               "\t\t\t\t\t\n" +
               "\t\t\t\t\t<tr>\t\t\t\t\t\t \n" +
               "\t\t\t\t\t\t<td style=\"padding: 10px 0px 0px; text-align: left; color: rgb(51, 51, 51); line-height: 18px; font-family: Lucida Grande, Helvetica, Arial, sans-serif; font-size: 14px; -webkit-font-smoothing: antialiased; font-smooth: always;\">\n" +
               "\t\t\t\t\t\t\t내용을 확인 하신 후 지속적인 문의가 필요하거나\n" +
               "\t\t\t\t\t\t</td>\t\t\t\t\t\t \n" +
               "\t\t\t\t\t</tr>\n" +
               "\t\t\t\t\t\n" +
               "\t\t\t\t\t<tr>\t\t\t\t\t\t \n" +
               "\t\t\t\t\t\t<td style=\"padding: 10px 0px 0px; text-align: left; color: rgb(51, 51, 51); line-height: 18px; font-family: Lucida Grande, Helvetica, Arial, sans-serif; font-size: 14px; -webkit-font-smoothing: antialiased; font-smooth: always;\">\n" +
               "\t\t\t\t\t\t\t저희 회사와 거래를 원하실 경우 고객등록을 먼저 하셔야 합니다.\n" +
               "\t\t\t\t\t\t</td>\t\t\t\t\t\t \n" +
               "\t\t\t\t\t</tr>\n" +
               "\t\t\t\t\t\n" +
               "\t\t\t\t\t<tr>\t\t\t\t\t\t \n" +
               "\t\t\t\t\t\t<td style=\"padding: 10px 0px 0px; text-align: left; color: rgb(51, 51, 51); line-height: 18px; font-family: Lucida Grande, Helvetica, Arial, sans-serif; font-size: 14px; -webkit-font-smoothing: antialiased; font-smooth: always;\">\n" +
               "\t\t\t\t\t\t\t고객 등록 이후에는 CASE라는 코너를 통해서 지속적인 대화가 가능합니다.\n" +
               "\t\t\t\t\t\t</td>\t\t\t\t\t\t \n" +
               "\t\t\t\t\t</tr>\n" +
               "\t\t\t\t\t\n" +
               "\t\t\t\t\t<tr>\t\t\t\t\t\t \n" +
               "\t\t\t\t\t\t<td style=\"padding: 10px 0px 0px; text-align: left; color: rgb(51, 51, 51); line-height: 18px; font-family: Lucida Grande, Helvetica, Arial, sans-serif; font-size: 14px; -webkit-font-smoothing: antialiased; font-smooth: always;\">\n" +
               "\t\t\t\t\t\t\t고객 등록을 원하시면 아래 URL을 클릭해 주세요\n" +
               "\t\t\t\t\t\t</td>\t\t\t\t\t\t \n" +
               "\t\t\t\t\t</tr>\n" +
               "\t\t\t\t\t\n" +
               "\t\t\t\t\t<tr>\t\t\t\t\t\t \n" +
               "\t\t\t\t\t\t<td style=\"padding: 10px 0px 0px; text-align: left; color: rgb(51, 51, 51); line-height: 18px; font-family: Lucida Grande, Helvetica, Arial, sans-serif; font-size: 14px; -webkit-font-smoothing: antialiased; font-smooth: always;\">\n" +
               "\t\t\t\t\t\t\t(CASE ID 발급 요청 : <a href = \"http://"+registrationLink+"\" style=\"color: #03a9f4 !important; cursor: pointer !important; text-decoration: none !important;\">"+registrationLink+"</a>)\n" +
               "\t\t\t\t\t\t</td>\t\t\t\t\t\t \n" +
               "\t\t\t\t\t</tr>\n" +
               "\t\t\t\t\t<!-- End Footer #2 -->";

       String textFooterFoolCreation = "<tr>\t\t\t\t\t\t \n" +
               "\t\t\t\t\t\t<td style=\"padding: 30px 0px 0px; text-align: left; color: rgb(51, 51, 51); line-height: 18px; font-family: Lucida Grande, Helvetica, Arial, sans-serif; font-size: 14px; -webkit-font-smoothing: antialiased; font-smooth: always;\">\n" +
               "\t\t\t\t\t\t\t이 메일은 문의 코너를 통해서 접수된 내용에 대한 답변 메일 입니다.\n" +
               "\t\t\t\t\t\t</td>\t\t\t\t\t\t \n" +
               "\t\t\t\t\t</tr>\n" +
               "\t\t\t\t\t\n" +
               "\t\t\t\t\t<tr>\t\t\t\t\t\t \n" +
               "\t\t\t\t\t\t<td style=\"padding: 10px 0px 0px; text-align: left; color: rgb(51, 51, 51); line-height: 18px; font-family: Lucida Grande, Helvetica, Arial, sans-serif; font-size: 14px; -webkit-font-smoothing: antialiased; font-smooth: always;\">\n" +
               "\t\t\t\t\t\t\t내용을 확인 하신 후 지속적인 연속된 질문이 필요하실 경우\n" +
               "\t\t\t\t\t\t</td>\t\t\t\t\t\t \n" +
               "\t\t\t\t\t</tr>\n" +
               "\t\t\t\t\t\n" +
               "\t\t\t\t\t<tr>\t\t\t\t\t\t \n" +
               "\t\t\t\t\t\t<td style=\"padding: 10px 0px 0px; text-align: left; color: rgb(51, 51, 51); line-height: 18px; font-family: Lucida Grande, Helvetica, Arial, sans-serif; font-size: 14px; -webkit-font-smoothing: antialiased; font-smooth: always;\">\n" +
               "\t\t\t\t\t\t\t아래를 클릭 하시면 CASE 코너를 통해서 손쉽게 문의하실 수 있습니다.\n" +
               "\t\t\t\t\t\t</td>\t\t\t\t\t\t \n" +
               "\t\t\t\t\t</tr>\n" +
               "\t\t\t\t\t\n" +
               "\t\t\t\t\t<tr>\t\t\t\t\t\t \n" +
               "\t\t\t\t\t\t<td style=\"padding: 40px 0px 0px; text-align: left; color: rgb(51, 51, 51); line-height: 18px; font-family: Lucida Grande, Helvetica, Arial, sans-serif; font-size: 14px; -webkit-font-smoothing: antialiased; font-smooth: always;\">\n" +
               "\t\t\t\t\t\t\t고객님은 이미 아이디를 가지고 계십니다.\n" +
               "\t\t\t\t\t\t</td>\t\t\t\t\t\t \n" +
               "\t\t\t\t\t</tr>\n" +
               "\t\t\t\t\t\n" +
               "\t\t\t\t\t<tr>\t\t\t\t\t\t \n" +
               "\t\t\t\t\t\t<td style=\"padding: 10px 0px 0px; text-align: left; color: rgb(51, 51, 51); line-height: 18px; font-family: Lucida Grande, Helvetica, Arial, sans-serif; font-size: 14px; -webkit-font-smoothing: antialiased; font-smooth: always;\">\n" +
               "\t\t\t\t\t\t\t고객 ID : "+customerUser.getSsoId()+"\n" +
               "\t\t\t\t\t\t</td>\t\t\t\t\t\t \n" +
               "\t\t\t\t\t</tr>\n" +
               "\t\t\t\t\t\n" +
               "\t\t\t\t\t<tr>\t\t\t\t\t\t \n" +
               "\t\t\t\t\t\t<td style=\"padding: 10px 0px 0px; text-align: left; color: rgb(51, 51, 51); line-height: 18px; font-family: Lucida Grande, Helvetica, Arial, sans-serif; font-size: 14px; -webkit-font-smoothing: antialiased; font-smooth: always;\">\n" +
               "\t\t\t\t\t\t\t<a href = \"http://www.sofac.kr/\" style=\"color: #03a9f4 !important; cursor: pointer !important; text-decoration: none !important;\">CASE 로그인을 페이지로 이동 …</a>\n" +
               "\t\t\t\t\t\t</td>\t\t\t\t\t\t \n" +
               "\t\t\t\t\t</tr>";
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
                   mimeMessage.setContent("<table\n" +
                           "       style=\"margin: 0px auto; padding: 0px; border: 0px currentColor; border-image: none; text-align: left;!important; line-height: inherit; font-size: inherit; border-collapse: collapse; border-spacing: 0; -premailer-cellpadding: 0; -premailer-cellspacing: 0;\"\n" +
                           "       cellspacing=\"0\" cellpadding=\"0\" align=\"center\">\n" +
                           "    <tbody>\n" +
                           "    <tr>\n" +
                           "        <td style=\"height: 16px; font-family: Lucida Grande, Helvetica, Arial, sans-serif; -premailer-height: 16;\" height=\"16\"></td>\n" +
                           "    </tr>\n" +
                           "    <tr>\n" +
                           "        <td style=\"width: 745px; !important; -premailer-width: 745;\">\n" +
                           "            <table class=\"iPhone_font\"\n" +
                           "                   style=\"padding: 0px; border: 0px currentColor; border-image: none; line-height: 18px; font-family: Lucida Grande, Helvetica, Arial, sans-serif; font-size: inherit;\">\n" +
                           "                <tbody>\n" +
                           "\t\t\t\t\t<tr>\t\t\t\t\t\t \n" +
                           "\t\t\t\t\t\t<td style=\"width: 745px;\">\n" +
                           "\t\t\t\t\t\t\t<!-- Header -->\n" +
                           "\t\t\t\t\t\t\t<div class=\"clearfix\" style=\"padding: 10px 0 15px 0; margin-bottom: 5px; \">\n" +
                           "\t\t\t\t\t\t\t\t<div style=\"float: left;\">\n" +
                           "\t\t\t\t\t\t\t\t\t<a href=\"http://www.sofac.kr\" target=\"_blank\" style=\"text-decoration: none; font-size: 24pt; color: #333;\">소프트웨어<span\n" +
                           "\t\t\t\t\t\t\t\t\t\t\t\tstyle=\"font-weight: 600; color: #03a9f4;\">팩토리</span></a>\n" +
                           "\t\t\t\t\t\t\t\t\t<div style=\"font-size: 9pt; color: #999;\">SoFAC : <span style=\"font-style: italic;\">Software Factory</span>\n" +
                           "\t\t\t\t\t\t\t\t\t</div>\n" +
                           "\t\t\t\t\t\t\t\t</div>\n" +
                           "\n" +
                           "\t\t\t\t\t\t\t\t<div style=\"float: right; padding-top: 15px;\">\n" +
                           "\t\t\t\t\t\t\t\t\t<a href=\"http://www.sofac.kr/whatIsSofac\" target=\"_blank\">소프트웨어 팩토리 란 무엇입니까?</a>\n" +
                           "\t\t\t\t\t\t\t\t</div>\n" +
                           "\t\t\t\t\t\t\t</div>\n" +
                           "\t\t\t\t\t\t\t<!-- #End Header -->\n" +
                           "\t\t\t\t\t\t</td>\t\t\t\t \n" +
                           "\t\t\t\t\t</tr>\n" +
                           "\t\t\t\t\t\n" +
                           "\t\t\t\t\t<tr>\t\t\t\t\t\t \n" +
                           "\t\t\t\t\t\t<td style=\"text-align: left; color: rgb(51, 51, 51); line-height: 1px; padding-top: 0px; font-family: Lucida Grande, Helvetica, Arial, sans-serif; font-size: 14px; -webkit-font-smoothing: antialiased; font-smooth: always;\">\n" +
                           "\t\t\t\t\t\t\t<div class=\"clearfix\" style=\" margin: 10px 0; border-bottom: 1px solid #eee;\">\n" +
                           "\t\t\t\t\t\t</td>\t\t\t\t\t\t \n" +
                           "\t\t\t\t\t</tr>\n" +
                           "\n" +
                           "\t\t\t\t\t<tr>\t\t\t\t\t\t \n" +
                           "\t\t\t\t\t\t<td style=\"text-align: left; color: rgb(51, 51, 51); line-height: 18px; padding-top: 10px; font-family: Lucida Grande, Helvetica, Arial, sans-serif; font-size: 14px; -webkit-font-smoothing: antialiased; font-smooth: always;\">\n" +
                           "\t\t\t\t\t\t\t안녕하세요\n" +
                           "\t\t\t\t\t\t</td>\t\t\t\t\t\t \n" +
                           "\t\t\t\t\t</tr>\n" +
                           "\n" +
                           "\t\t\t\t\t<tr>\t\t\t\t\t\t \n" +
                           "\t\t\t\t\t\t<td style=\"padding: 10px 0px 0px; text-align: left; color: rgb(51, 51, 51); line-height: 18px; font-family: Lucida Grande, Helvetica, Arial, sans-serif; font-size: 14px; -webkit-font-smoothing: antialiased; font-smooth: always;\">\n" +
                           "\t\t\t\t\t\t\t소프트웨어 팩토리 입니다.\n" +
                           "\t\t\t\t\t\t</td>\t\t\t\t\t\t \n" +
                           "\t\t\t\t\t</tr>\n" +
                           "\t\t\t\t\t\n" +
                           "\t\t\t\t\t<tr>\t\t\t\t\t\t \n" +
                           "\t\t\t\t\t\t<td style=\"padding: 10px 0px 0px; text-align: left; color: rgb(51, 51, 51); line-height: 18px; font-family: Lucida Grande, Helvetica, Arial, sans-serif; font-size: 14px; -webkit-font-smoothing: antialiased; font-smooth: always;\">\n" +
                           "\t\t\t\t\t\t\t"+dateFormat.format(message.getMessageTime())+"\n" +
                           "\t\t\t\t\t\t</td>\t\t\t\t\t\t \n" +
                           "\t\t\t\t\t</tr>\n" +
                           "\t\t\t\t\t\n" +
                           "\t\t\t\t\t<tr>\t\t\t\t\t\t \n" +
                           "\t\t\t\t\t\t<td style=\"padding: 10px 0px 0px; text-align: left; color: rgb(51, 51, 51); line-height: 18px; font-family: Lucida Grande, Helvetica, Arial, sans-serif; font-size: 14px; -webkit-font-smoothing: antialiased; font-smooth: always;\">\n" +
                           "\t\t\t\t\t\t\t문의결과와 첨부 파일을 확인해 주세요\n" +
                           "\t\t\t\t\t\t</td>\t\t\t\t\t\t \n" +
                           "\t\t\t\t\t</tr>\n" +
                           "\t\t\t\t\t\n" +
                           "\t\t\t\t\t<tr>\t\t\t\t\t\t \n" +
                           "\t\t\t\t\t\t<td style=\"padding: 10px 0px 0px; text-align: left; color: rgb(51, 51, 51); line-height: 18px; font-family: Lucida Grande, Helvetica, Arial, sans-serif; font-size: 14px; -webkit-font-smoothing: antialiased; font-smooth: always;\">\n" +
                           "\t\t\t\t\t\t\t클릭하시면 첨부파일을 보실 수 있습니다\n" +
                           "\t\t\t\t\t\t</td>\t\t\t\t\t\t \n" +
                           "\t\t\t\t\t</tr>\n" +
                           "\t\t\t\t\t\n" +
                           "\t\t\t\t\t<tr>\t\t\t\t\t\t \n" +
                           "\t\t\t\t\t\t<td style=\"padding: 30px 0px 0px; text-align: left; color: rgb(51, 51, 51); line-height: 18px; font-family: Lucida Grande, Helvetica, Arial, sans-serif; font-size: 14px; -webkit-font-smoothing: antialiased; font-smooth: always;\">\n" +
                                allLinks+
                           "\t\t\t\t\t\t</td>\t\t\t\t\t\t \n" +
                           "\t\t\t\t\t</tr>\n" +
                           "\t\t\t\t\t<tr>\t\t\t\t\t\t \n" +
                           "\t\t\t\t\t\t<td style=\"padding: 10px 0px 0px; text-align: left; color: rgb(51, 51, 51); line-height: 18px; font-family: Lucida Grande, Helvetica, Arial, sans-serif; font-size: 14px; -webkit-font-smoothing: antialiased; font-smooth: always;\">\n" +
                           "\t\t\t\t\t\t\t<div style=\"margin: 0px 0px !important; background: #ddd !important; padding: 5px 15px !important;\">\n" +
                           "\n" +
                                message.getMessageText()+
                           "\n" +
                           "\t\t\t\t\t\t\t</div>\n" +
                           "\t\t\t\t\t\t</td>\t\t\t\t\t\t \n" +
                           "\t\t\t\t\t</tr>\n" +
                           "\t\t\t\t\t\n" +
                           "\t\t\t\t\t\n" +

                                footerText+

                           "\t\t\t\t\t<tr>\t\t\t\t\t\t \n" +
                           "\t\t\t\t\t\t<td style=\"padding: 10px 0px 0px; text-align: left; color: rgb(51, 51, 51); line-height: 18px; font-family: Lucida Grande, Helvetica, Arial, sans-serif; font-size: 14px; -webkit-font-smoothing: antialiased; font-smooth: always;\">\n" +
                           "\t\t\t\t\t\t\tNo need to reply to this email.\n" +
                           "\t\t\t\t\t\t</td>\t\t\t\t\t\t \n" +
                           "\t\t\t\t\t</tr>\n" +
                           "\n" +
                           "\t\t\t\t\t<tr>\t\t\t\t\t\t \n" +
                           "\t\t\t\t\t\t<td style=\"text-align: left; color: rgb(51, 51, 51); line-height: 18px; padding-top: 0px; font-family: Lucida Grande, Helvetica, Arial, sans-serif; font-size: 14px; -webkit-font-smoothing: antialiased; font-smooth: always;\">\n" +
                           "\t\t\t\t\t\t\t<!-- Footer -->\n" +
                           "\t\t\t\t\t\t\t<div class=\"clearfix\" style=\"margin: 20px 10px 10px 10px; padding-top: 15px; border-top: 1px solid #eee;\">\n" +
                           "\n" +
                           "\t\t\t\t\t\t\t\t<div style=\"color: #999; font-size: 9pt; float: left;\">\n" +
                           "\t\t\t\t\t\t\t\t\tPolicy of SoFAC<br/>\n" +
                           "\t\t\t\t\t\t\t\t\t<a href=\"http://www.sofac.kr/policy\"><span style=\"font-size: 9pt;\">SoFAC 고객 정책</span></a>\n" +
                           "\t\t\t\t\t\t\t\t</div>\n" +
                           "\t\t\t\t\t\t\t\t<div style=\"color: #999; font-size: 9pt; float: right; text-align: right;\">\n" +
                           "\t\t\t\t\t\t\t\t\t220-87-45112<br/>\n" +
                           "\t\t\t\t\t\t\t\t\t서울시 강남구 역삼동 해성빌딩 7층<br/>\n" +
                           "\t\t\t\t\t\t\t\t\t대표자 : 박상만\n" +
                           "\t\t\t\t\t\t\t\t</div>\n" +
                           "\n" +
                           "\t\t\t\t\t\t\t</div>\n" +
                           "\t\t\t\t\t\t\t<div style=\"color: #999; font-size: 9pt; text-align: center; padding: 10px;\">\n" +
                           "\t\t\t\t\t\t\t\tCopyright © 2016. All rights reserved\n" +
                           "\t\t\t\t\t\t\t</div>\n" +
                           "\t\t\t\t\t\t\t<!-- Footer -->\n" +
                           "\t\t\t\t\t\t</td>\t\t\t\t\t\t \n" +
                           "\t\t\t\t\t</tr>\n" +
                           "\t\t\t\t\t\t\n" +
                           "                </tbody>\n" +
                           "            </table>\n" +
                           "        </td>\n" +
                           "    </tr>\n" +
                           "    <tr style=\"height: 17px; -premailer-height: 17;\" height=\"17\">\n" +
                           "        <td style=\"font-family: Geneva, Helvetica, Arial, sans-serif;\"></td>\n" +
                           "    </tr>\n" +
                           "    <tr>\n" +
                           "        <td style=\"background-position: top; padding: 15px 0px 12px; width: 685px; text-align: center; color: rgb(136, 136, 136); line-height: 14px; font-family: Geneva, Helvetica, Arial, sans-serif; font-size: 11px; background-repeat: no-repeat; -webkit-font-smoothing: antialiased; -webkit-text-size-adjust: 100%; font-smooth: always;\"\n" +
                           "            colspan=\"3\" background=\"http://sofac.kr/resources/indexPage/images/footer_gradient_web.png\"\n" +
                           "            align=\"center\">\n" +
                           "               \n" +
                           " \n" +
                           "        </td>\n" +
                           "    </tr>\n" +
                           "    <tr style=\"height: 50px; -premailer-height: 50;\" height=\"50\">\n" +
                           "        <td style=\"font-family: Geneva, Helvetica, Arial, sans-serif;\"></td>\n" +
                           "    </tr>\n" +
                           "    </tbody>\n" +
                           "</table>", "text/html; charset=utf-8");

               }
           });
           System.out.println("Message Send...Hurrey");
       } catch (MailException ex) {
           System.err.println(ex.getMessage());
       }
    }

}