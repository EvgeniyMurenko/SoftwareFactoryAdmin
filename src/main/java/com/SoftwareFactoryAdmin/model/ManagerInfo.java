package com.SoftwareFactoryAdmin.model;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.persistence.*;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "s_manager_info")
public class ManagerInfo extends HandlerInterceptorAdapter implements Serializable, HttpSessionBindingListener {

    public ManagerInfo() {
    }

    public ManagerInfo(Long id, User user, String name, String phone, String email, Date birthday, Permission managerInfoPermissions, Set<Project> projects) {
        this.id = id;
        this.user = user;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.birthday = birthday;
        this.managerInfoPermissions = managerInfoPermissions;
        this.projects = projects;
    }

    @Id
    @Column(name = "user_id", nullable = false)
    private Long id;


    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;


    @Column(name = "name")
    private String name;


    @Column(name = "phone")
    private String phone;


    @Column(name = "email")
    private String email;


    @Column(name = "birthday")
    private Date birthday;


    @OneToOne(fetch = FetchType.LAZY , mappedBy="managerInfo", cascade = CascadeType.ALL)
    private Permission managerInfoPermissions;


    @OneToMany(mappedBy = "managerInfo", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Project> projects;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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

    public Permission getManagerInfoPermissions() {
        return managerInfoPermissions;
    }

    public void setManagerInfoPermissions(Permission managerInfoPermissions) {
        this.managerInfoPermissions = managerInfoPermissions;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Project> getProjects() {
        return projects;
    }

    public void setProjects(Set<Project> projects) {
        this.projects = projects;
    }

    @Override
    public void valueBound(HttpSessionBindingEvent httpSessionBindingEvent) {
        ManagerInfo managerInfo = (ManagerInfo)httpSessionBindingEvent.getValue();
        System.out.println("=========New user bound in session with name: "+managerInfo.getName());
    }

    @Override
    public void valueUnbound(HttpSessionBindingEvent httpSessionBindingEvent) {
        ManagerInfo managerInfo = (ManagerInfo)httpSessionBindingEvent.getValue();
        System.out.println("=========User with name: " + managerInfo.getName() + " removed from session");
    }

    public static boolean isUserLogged() {
        try {
            return !SecurityContextHolder.getContext().getAuthentication()
                    .getName().equals("anonymousUser");
        } catch (Exception e) {
            return false;
        }
    }
}
