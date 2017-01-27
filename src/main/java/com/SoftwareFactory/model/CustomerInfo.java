package com.SoftwareFactory.model;




import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="s_customer_info")
public class CustomerInfo {

    public CustomerInfo(){}

    @Id
    @Column(name="user_id")
    private Long userId;

    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    @Column(name="company")
    private String company;

    @Column(name = "avatar")
    private String avatar;

    @OneToMany
    @Column(name = "customerInfo")
    private Set<Project> projects;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Set<Project> getProjects() {
        return projects;
    }

    public void setProjects(Set<Project> projects) {
        this.projects = projects;
    }

    public CustomerInfo(Long userId, String firstName, String lastName, String company, String avatar ,Set<Project> projects) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.company = company;
        this.avatar = avatar;
        this.projects = projects;
    }

    @Override
    public String toString() {
        return "CustomerInfo{" +
                "userId=" + userId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", company='" + company + '\'' +
                ", avatar='" + avatar + '\'' +
                ", projects=" + projects +
                '}';
    }
}

