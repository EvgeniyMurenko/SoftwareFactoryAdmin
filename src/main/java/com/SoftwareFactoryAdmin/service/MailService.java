package com.SoftwareFactoryAdmin.service;


import com.SoftwareFactoryAdmin.model.Message;

public interface MailService {

    void sendEmailAfterEstimateRespond(String recipientMail , Message message);

}
