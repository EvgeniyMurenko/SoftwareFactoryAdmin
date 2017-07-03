package com.SoftwareFactoryAdmin.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "s_task_message_link")
public class TaskMessageLink  implements Serializable {

    public TaskMessageLink(){}

    public TaskMessageLink(TaskMessage taskMessage, String fileLink, String fileName, String fileUuidName) {
        this.taskMessage = taskMessage;
        this.fileLink = fileLink;
        this.fileName = fileName;
        this.fileUuidName = fileUuidName;
    }

    @Id
    @GeneratedValue(generator = "increment2")
    @GenericGenerator(name = "increment2", strategy = "increment")
    @Column(name = "id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "task_message_id")
    private TaskMessage taskMessage;

    @Column(name = "file_link")
    private String fileLink;

    @Column(name = "file_name")
    private String fileName;

    @Column(name = "file_uuid_name")
    private String fileUuidName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TaskMessage getTaskMessage() {
        return taskMessage;
    }

    public void setTaskMessage(TaskMessage taskMessage) {
        this.taskMessage = taskMessage;
    }

    public String getFileLink() {
        return fileLink;
    }

    public void setFileLink(String fileLink) {
        this.fileLink = fileLink;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileUuidName() {
        return fileUuidName;
    }

    public void setFileUuidName(String fileUuidName) {
        this.fileUuidName = fileUuidName;
    }
}
