package com.SoftwareFactory.model;

import javax.persistence.*;

@Entity
@Table(name = "s_file_message")
public class FileMessage {

    public FileMessage(){}

    @Id
    @Column(name = "message_id")
    private Long messageId;

    @Column(name = "link_to_file")
    private String linkToFile;

    @ManyToOne
    @JoinColumn(name = "message_id")
    private Message message;


    public Long getMessageId() {
        return messageId;
    }

    public void setMessageId(Long messageId) {
        this.messageId = messageId;
    }

    public String getLinkToFile() {
        return linkToFile;
    }

    public void setLinkToFile(String linkToFile) {
        this.linkToFile = linkToFile;
    }

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }

    public FileMessage(Long messageId, String linkToFile, Message message) {
        this.messageId = messageId;
        this.linkToFile = linkToFile;
        this.message = message;
    }
}
