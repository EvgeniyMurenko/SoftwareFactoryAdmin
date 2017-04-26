package com.SoftwareFactoryAdmin.service;


import com.SoftwareFactoryAdmin.model.Message;

import java.util.List;

public interface MessageService {

    void addNewMessage(Message message);

    void updateMessage(Message message);

    void deleteMessage(Message message);

    List<Message> getAllMessages();

    Message getMessageById(Long id);

}
