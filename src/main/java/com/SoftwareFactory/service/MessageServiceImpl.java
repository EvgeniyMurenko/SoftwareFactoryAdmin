package com.SoftwareFactory.service;

import com.SoftwareFactory.dao.MessageDaoImpl;
import com.SoftwareFactory.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by adm on 1/27/2017.
 */
@Service("messageService")
public class MessageServiceImpl implements AbstractService<Message> {

    private MessageDaoImpl messageDaoImpl;

    @Autowired(required=true)
    public MessageServiceImpl(MessageDaoImpl messageService) {
        this.messageDaoImpl = messageService;
    }

    @Override
    @Transactional
    public void addNew(Message object) {
        messageDaoImpl.create(object);
    }

    @Override
    @Transactional
    public void update(Message object) {
        messageDaoImpl.update(object);
    }

    @Override
    @Transactional
    public void delete(Message object) {
        messageDaoImpl.delete(object);
    }

    @Override
    @Transactional(readOnly=true)
    public List<Message> getAll() {
        return messageDaoImpl.findAll();
    }
}
