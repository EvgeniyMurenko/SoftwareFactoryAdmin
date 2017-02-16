
package com.SoftwareFactory.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "s_file_message")
public class FileMessage {

    public FileMessage() {
    }

    @Id
    @GeneratedValue(generator = "increment2")
    @GenericGenerator(name = "increment2", strategy = "increment")
    @Column(name = "file_message_id")
    private long fileMessageId;

    @Column(name = "link_to_file")
    private String linkToFile;

    @ManyToOne
    @JoinColumn(name = "message_id")
    private Message message;




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

    public long getFileMessageId() {
        return fileMessageId;
    }

    public void setFileMessageId(long fileMessageId) {
        this.fileMessageId = fileMessageId;
    }
}
