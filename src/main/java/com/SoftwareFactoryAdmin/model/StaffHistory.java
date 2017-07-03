package com.SoftwareFactoryAdmin.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "s_staff_history")
public class StaffHistory implements Serializable {

    public StaffHistory() {
    }

    public StaffHistory(String text, Date date, StaffInfo staffInfo, String managerName, Long managerId) {
        this.text = text;
        this.date = date;
        this.staffInfo = staffInfo;
        this.managerName = managerName;
        this.managerId = managerId;
    }

    @Id
    @GeneratedValue(generator = "increment2")
    @GenericGenerator(name = "increment2", strategy = "increment")
    @Column(name = "id")
    private Long id;


    @Column(name = "text")
    private String text;


    @Column(name = "date")
    private Date date;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "staff_info_id")
    private StaffInfo staffInfo;


    @Column(name = "manager_name")
    private String managerName;


    @Column(name = "manager_id")
    private Long managerId;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public StaffInfo getStaffInfo() {
        return staffInfo;
    }

    public void setStaffInfo(StaffInfo staffInfo) {
        this.staffInfo = staffInfo;
    }

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    public Long getManagerId() {
        return managerId;
    }

    public void setManagerId(Long managerId) {
        this.managerId = managerId;
    }
}
