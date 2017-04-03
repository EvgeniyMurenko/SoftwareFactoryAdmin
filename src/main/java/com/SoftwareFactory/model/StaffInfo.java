package com.SoftwareFactory.model;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "s_staff_info")
public class StaffInfo {

    @Id
    @Column(name = "user_id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "phone")
    private String phone;


    @Column(name = "email")
    private String email;


    @Column(name="birthday")
    private Date birthday;

    @OneToMany(mappedBy = "staffInfo", fetch = FetchType.LAZY)
    private Set<GoogleCloudKey> googleCloudKeys;

    @OneToMany(mappedBy = "staffInfo", fetch = FetchType.LAZY)
    private Set<MessageTask> messageTasks;

    public StaffInfo() {
    }

    public StaffInfo(String name, String phone, String email, Date birthday, Set<GoogleCloudKey> googleCloudKeys, Set<MessageTask> messageTasks) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.birthday = birthday;
        this.googleCloudKeys = googleCloudKeys;
        this.messageTasks = messageTasks;
    }

    public Long getUser() {
        return id;
    }

    public void setUser(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Set<GoogleCloudKey> getGoogleCloudKeys() {
        return googleCloudKeys;
    }

    public void setGoogleCloudKeys(Set<GoogleCloudKey> googleCloudKeys) {
        this.googleCloudKeys = googleCloudKeys;
    }

    public Set<MessageTask> getMessageTasks() {
        return messageTasks;
    }

    public void setMessageTasks(Set<MessageTask> messageTasks) {
        this.messageTasks = messageTasks;
    }
}
