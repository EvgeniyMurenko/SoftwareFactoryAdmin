package com.SoftwareFactoryAdmin.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "s_toss_task")
public class TossTask {

    public TossTask() {
    }

    public TossTask(ManagerInfo managerInfoOpened, Set<ManagerInfo> managerInfoEngaged, String status, String title, String text, Date date, Date endDate, boolean isNow, Set<TossTaskMessage> tossTaskMessages) {
        this.managerInfoOpened = managerInfoOpened;
        this.managerInfoEngaged = managerInfoEngaged;
        this.status = status;
        this.title = title;
        this.text = text;
        this.date = date;
        this.endDate = endDate;
        this.isNow = isNow;
        this.tossTaskMessages = tossTaskMessages;
    }

    @Id
    @GeneratedValue(generator = "increment2")
    @GenericGenerator(name = "increment2", strategy = "increment")
    @Column(name = "id")
    private Long id;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_manager_id_opened")
    private ManagerInfo managerInfoOpened;


    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "toss_task_manager_info",
            joinColumns = {@JoinColumn(name = "toss_task_id")},
            inverseJoinColumns = {@JoinColumn(name = "manager_info_id")})
    private Set<ManagerInfo> managerInfoEngaged = new HashSet<ManagerInfo>();


    @Column(name = "status")
    private String status;

    @Column(name = "title")
    private String title;

    @Column(name = "text")
    private String text;

    @Column(name = "date")
    private Date date;

    @Column(name = "end_date")
    private Date endDate;

    @Column(name = "is_now")
    private boolean isNow;

    @OneToMany(mappedBy = "tossTask", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<TossTaskMessage> tossTaskMessages;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ManagerInfo getManagerInfoOpened() {
        return managerInfoOpened;
    }

    public void setManagerInfoOpened(ManagerInfo managerInfoOpened) {
        managerInfoOpened = managerInfoOpened;
    }

    public Set<ManagerInfo> getManagerInfoEngaged() {
        return managerInfoEngaged;
    }

    public void setManagerInfoEngaged(Set<ManagerInfo> managerInfoEngaged) {
        this.managerInfoEngaged = managerInfoEngaged;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public boolean isNow() {
        return isNow;
    }

    public void setNow(boolean now) {
        isNow = now;
    }

    public Set<TossTaskMessage> getTossTaskMessages() {
        return tossTaskMessages;
    }

    public void setTossTaskMessages(Set<TossTaskMessage> tossTaskMessages) {
        this.tossTaskMessages = tossTaskMessages;
    }
}
