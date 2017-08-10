package com.SoftwareFactoryAdmin.service;


import com.SoftwareFactoryAdmin.model.Message;
import com.SoftwareFactoryAdmin.model.User;

public interface MailService {

    void sendEmailAfterEstimateRespond(String recipientMail , Message message, User customerUser, String registrationLink, Boolean isFullCreated);

}
