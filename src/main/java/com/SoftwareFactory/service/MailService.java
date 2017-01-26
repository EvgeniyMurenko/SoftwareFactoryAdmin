package com.SoftwareFactory.service;

import org.springframework.mail.javamail.MimeMessagePreparator;

/**
 * Created by Alex on 1/12/2017.
 */
public interface MailService {

    void sendEmail(String recipientMail , String recipientName);

}
