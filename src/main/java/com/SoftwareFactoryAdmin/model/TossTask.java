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

    public TossTask(ManagerInfo managerInfoOpened, String managersEngaged, Toss toss, String status, String text, Date date, Set<TossTaskMessage> tossTaskMessages, Set<TossTaskLink> tossTaskLinks) {
        this.managerInfoOpened = managerInfoOpened;
        this.managersEngaged = managersEngaged;
        this.toss = toss;
        this.status = status;
        this.text = text;
        this.date = date;
        this.tossTaskMessages = tossTaskMessages;
        this.tossTaskLinks = tossTaskLinks;
    }

    @Id
    @GeneratedValue(generator = "increment2")
    @GenericGenerator(name = "increment2", strategy = "increment")
    @Column(name = "id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_manager_id_opened")
    private ManagerInfo managerInfoOpened;

    @Column(name = "managers_engaged")
    private String managersEngaged;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "toss_id")
    private Toss toss;

    @Column(name = "status")
    private String status;

    @Column(name = "text")
    private String text;

    @Column(name = "date")
    private Date date;

    @OneToMany(mappedBy = "tossTask", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<TossTaskMessage> tossTaskMessages;

    @OneToMany(mappedBy = "tossTask", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<TossTaskLink> tossTaskLinks;

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
        this.managerInfoOpened = managerInfoOpened;
    }

    public String getManagersEngaged() {
        return managersEngaged;
    }

    public void setManagersEngaged(String managersEngaged) {
        this.managersEngaged = managersEngaged;
    }

    public Toss getToss() {
        return toss;
    }

    public void setToss(Toss toss) {
        this.toss = toss;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public Set<TossTaskMessage> getTossTaskMessages() {
        return tossTaskMessages;
    }

    public void setTossTaskMessages(Set<TossTaskMessage> tossTaskMessages) {
        this.tossTaskMessages = tossTaskMessages;
    }

    public Set<TossTaskLink> getTossTaskLinks() {
        return tossTaskLinks;
    }

    public void setTossTaskLinks(Set<TossTaskLink> tossTaskLinks) {
        this.tossTaskLinks = tossTaskLinks;
    }
}
