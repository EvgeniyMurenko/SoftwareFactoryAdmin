package com.SoftwareFactoryAdmin.model;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "s_task_message")
public class TaskMessage {

    public TaskMessage(){}

    public TaskMessage(ProjectTask projectTask, User user, String messageText, Date date, String senderName, List<TaskMessageLink> taskMessageLinks) {
        this.projectTask = projectTask;
        this.user = user;
        this.messageText = messageText;
        this.date = date;
        this.senderName = senderName;
        this.taskMessageLinks = taskMessageLinks;
    }

    @Id
    @GeneratedValue(generator = "increment2")
    @GenericGenerator(name = "increment2", strategy = "increment")
    @Column(name = "id")
    private Long id;


    @ManyToOne
    @JoinColumn(name = "project_task_id")
    private ProjectTask projectTask;


    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;


    @Column(name = "message_text")
    private String messageText;


    @Column(name = "date")
    private Date date;


    @Column(name = "sender_name")
    private String senderName;


    @OneToMany(mappedBy = "taskMessage", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<TaskMessageLink> taskMessageLinks;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ProjectTask getProjectTask() {
        return projectTask;
    }

    public void setProjectTask(ProjectTask projectTask) {
        this.projectTask = projectTask;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getSenderName() {
        return senderName;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }

    public List<TaskMessageLink> getTaskMessageLinks() {
        return taskMessageLinks;
    }

    public void setTaskMessageLinks(List<TaskMessageLink> taskMessageLinks) {
        this.taskMessageLinks = taskMessageLinks;
    }
}
