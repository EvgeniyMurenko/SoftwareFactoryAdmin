package com.SoftwareFactoryAdmin.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "s_staff_info")
public class StaffInfo implements Serializable {

    public StaffInfo() {}

    public StaffInfo(Long id, User user, String name, String phone, String email, Date birthDate, Date creationDate, Double rating, int android, int iOs, int iot, int java, int php, int javascript, int cSharp, int cPlusPlus, int frontend, int design, List<StaffHistory> staffHistories) {
        this.id = id;
        this.user = user;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.birthDate = birthDate;
        this.creationDate = creationDate;
        this.rating = rating;
        this.android = android;
        this.iOs = iOs;
        this.iot = iot;
        this.java = java;
        this.php = php;
        this.javascript = javascript;
        this.cSharp = cSharp;
        this.cPlusPlus = cPlusPlus;
        this.frontend = frontend;
        this.design = design;
        this.staffHistories = staffHistories;
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


    @Column(name = "birth_date")
    private Date birthDate;

    @Column(name = "creation_date")
    private Date creationDate;

    @Column(name = "rating")
    private Double rating;

    @Column(name = "android")
    private int android;

    @Column(name = "ios")
    private int iOs;

    @Column(name = "iot")
    private int iot;

    @Column(name = "java")
    private int java;

    @Column(name = "php")
    private int php;

    @Column(name = "javascript")
    private int javascript;

    @Column(name = "c_sharp")
    private int cSharp;

    @Column(name = "c_plus_plus")
    private int cPlusPlus;

    @Column(name = "frontend")
    private int frontend;

    @Column(name = "design")
    private int design;


    @OneToMany(mappedBy = "staffInfo", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<StaffHistory> staffHistories;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public int getAndroid() {
        return android;
    }

    public void setAndroid(int android) {
        this.android = android;
    }

    public int getiOs() {
        return iOs;
    }

    public void setiOs(int iOs) {
        this.iOs = iOs;
    }

    public int getIot() {
        return iot;
    }

    public void setIot(int iot) {
        this.iot = iot;
    }

    public int getJava() {
        return java;
    }

    public void setJava(int java) {
        this.java = java;
    }

    public int getPhp() {
        return php;
    }

    public void setPhp(int php) {
        this.php = php;
    }

    public int getJavascript() {
        return javascript;
    }

    public void setJavascript(int javascript) {
        this.javascript = javascript;
    }

    public int getcSharp() {
        return cSharp;
    }

    public void setcSharp(int cSharp) {
        this.cSharp = cSharp;
    }

    public int getcPlusPlus() {
        return cPlusPlus;
    }

    public void setcPlusPlus(int cPlusPlus) {
        this.cPlusPlus = cPlusPlus;
    }

    public int getFrontend() {
        return frontend;
    }

    public void setFrontend(int frontend) {
        this.frontend = frontend;
    }

    public int getDesign() {
        return design;
    }

    public void setDesign(int design) {
        this.design = design;
    }

    public List<StaffHistory> getStaffHistories() {
        return staffHistories;
    }

    public void setStaffHistories(List<StaffHistory> staffHistories) {
        this.staffHistories = staffHistories;
    }
}
