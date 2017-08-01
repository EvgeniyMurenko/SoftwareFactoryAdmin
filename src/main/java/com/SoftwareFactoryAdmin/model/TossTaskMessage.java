package com.SoftwareFactoryAdmin.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "s_toss_task_message")
public class TossTaskMessage {

    public TossTaskMessage() {
    }

    public TossTaskMessage(ManagerInfo managerInfo, TossTask tossTask, String text, Date date) {
        this.managerInfo = managerInfo;
        this.tossTask = tossTask;
        this.text = text;
        this.date = date;
    }

    @Id
    @GeneratedValue(generator = "increment2")
    @GenericGenerator(name = "increment2", strategy = "increment")
    @Column(name = "id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_manager_id")
    private ManagerInfo managerInfo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "toss_task_id")
    private TossTask tossTask;

    @Column(name = "text")
    private String text;

    @Column(name = "date")
    private Date date;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ManagerInfo getManagerInfo() {
        return managerInfo;
    }

    public void setManagerInfo(ManagerInfo managerInfo) {
        this.managerInfo = managerInfo;
    }

    public TossTask getTossTask() {
        return tossTask;
    }

    public void setTossTask(TossTask tossTask) {
        this.tossTask = tossTask;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }


}

