package com.SoftwareFactoryAdmin.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "s_toss")
public class Toss {

    public Toss(){}

    public Toss(String managerOpenedName, Set<ManagerInfo> managerInfoEngaged, Set<TossTask> tossTasks, String status, String title, Date date, Date endDate, boolean isNow) {
        this.managerOpenedName = managerOpenedName;
        this.managerInfoEngaged = managerInfoEngaged;
        this.tossTasks = tossTasks;
        this.status = status;
        this.title = title;
        this.date = date;
        this.endDate = endDate;
        this.isNow = isNow;
    }

    @Id
    @GeneratedValue(generator = "increment2")
    @GenericGenerator(name = "increment2", strategy = "increment")
    @Column(name = "id")
    private Long id;

    @Column(name = "manager_opened_name")
    private String managerOpenedName;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "s_toss_manager_info",
            joinColumns = {@JoinColumn(name = "toss_id")},
            inverseJoinColumns = {@JoinColumn(name = "manager_info_id")})
    private Set<ManagerInfo> managerInfoEngaged = new HashSet<ManagerInfo>();

    @OneToMany(mappedBy = "toss", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<TossTask> tossTasks;

    @Column(name = "status")
    private String status;

    @Column(name = "title")
    private String title;

    @Column(name = "date")
    private Date date;

    @Column(name = "end_date")
    private Date endDate;

    @Column(name = "is_now")
    private boolean isNow;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getManagerOpenedName() {
        return managerOpenedName;
    }

    public void setManagerOpenedName(String managerOpenedName) {
        this.managerOpenedName = managerOpenedName;
    }

    public Set<ManagerInfo> getManagerInfoEngaged() {
        return managerInfoEngaged;
    }

    public void setManagerInfoEngaged(Set<ManagerInfo> managerInfoEngaged) {
        this.managerInfoEngaged = managerInfoEngaged;
    }

    public Set<TossTask> getTossTasks() {
        return tossTasks;
    }

    public void setTossTasks(Set<TossTask> tossTasks) {
        this.tossTasks = tossTasks;
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
}
