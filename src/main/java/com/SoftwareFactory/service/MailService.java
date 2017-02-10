package com.SoftwareFactory.service;


public interface MailService {

    void sendEmail(String recipientMail , String recipientName);

    void sendEmailAfterRegistration(String password , String login);

    void sendEmailAfterEstimate(String estimateId , String registrationLink , String recipientMail);
}
