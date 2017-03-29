package com.SoftwareFactory.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "s_message_task")
public class MessageTask {

    @Id
    @GeneratedValue(generator = "increment2")
    @GenericGenerator(name = "increment2", strategy = "increment")
    @Column(name = "google_cloud_keys_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "staff_info_id", insertable=false, updatable=false)
    private StaffInfo staffInfo;

    @Column(name = "title")
    private String title;

    @Column(name = "message_text")
    private String messageText;

    @Column(name="date")
    private Date date;

    @ManyToOne
    @JoinColumn(name = "app_user_id", insertable = false, updatable = false)
    private User user;

    @Column(name = "is_approve")
    private Boolean isApprove;

    public MessageTask() {
    }

    public MessageTask(StaffInfo staffInfo, String title, String messageText, Date date, User user, Boolean isApprove) {
        this.staffInfo = staffInfo;
        this.title = title;
        this.messageText = messageText;
        this.date = date;
        this.user = user;
        this.isApprove = isApprove;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public StaffInfo getStaffInfo() {
        return staffInfo;
    }

    public void setStaffInfo(StaffInfo staffInfo) {
        this.staffInfo = staffInfo;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Boolean getApprove() {
        return isApprove;
    }

    public void setApprove(Boolean isApprove) {
        isApprove = isApprove;
    }
}
