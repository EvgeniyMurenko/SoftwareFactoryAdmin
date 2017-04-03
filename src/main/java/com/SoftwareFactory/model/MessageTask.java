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
    @Column(name = "message_task_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "staff_info_id")
    private StaffInfo staffInfo;

    @Column(name = "title")
    private String title;

    @Column(name = "message_text")
    private String messageText;

    @Column(name="date")
    private Date date;

    @Column(name = "app_user_id")
    private Long userId;

    @Column(name = "is_approve")
    private boolean isApprove;

    public MessageTask() {
    }

    public MessageTask(StaffInfo staffInfo, String title, String messageText, Date date, Long userId, boolean isApprove) {
        this.staffInfo = staffInfo;
        this.title = title;
        this.messageText = messageText;
        this.date = date;
        this.userId = userId;
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

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public boolean getApprove() {
        return isApprove;
    }

    public void setApprove(boolean isApprove) {
        isApprove = isApprove;
    }
}
