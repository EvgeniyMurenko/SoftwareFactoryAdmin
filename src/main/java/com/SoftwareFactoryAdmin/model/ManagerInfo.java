package com.SoftwareFactoryAdmin.model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "s_manager_info")
public class ManagerInfo {

    public ManagerInfo(){}

    @Id
    @Column(name = "user_id")
    private Long Id;

    @Column(name = "name")
    private String name;


    @Column(name = "phone")
    private String phone;


    @Column(name = "email")
    private String email;


    @Column(name="birthday")
    private Date birthday;

    @NotEmpty
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "s_manager_info_permission",
            joinColumns = { @JoinColumn(name = "manager_info_id") },
            inverseJoinColumns = { @JoinColumn(name = "permission_id") })
    private Set<ManagerInfoPermission> managerInfoPermissions = new HashSet<ManagerInfoPermission>();

    @OneToMany(mappedBy = "managerInfo" ,fetch = FetchType.EAGER)
    private Set<GoogleCloudKey> googleCloudKeys;

    public ManagerInfo(Long id, String name, String phone, String email, Date birthday, Set<ManagerInfoPermission> managerInfoPermissions, Set<GoogleCloudKey> googleCloudKeys) {
        Id = id;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.birthday = birthday;
        this.managerInfoPermissions = managerInfoPermissions;
        this.googleCloudKeys = googleCloudKeys;
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

    public Set<ManagerInfoPermission> getManagerInfoPermissions() {
        return managerInfoPermissions;
    }

    public void setManagerInfoPermissions(Set<ManagerInfoPermission> managerInfoPermissions) {
        this.managerInfoPermissions = managerInfoPermissions;
    }

    public Set<GoogleCloudKey> getGoogleCloudKeys() {
        return googleCloudKeys;
    }

    public void setGoogleCloudKeys(Set<GoogleCloudKey> googleCloudKeys) {
        this.googleCloudKeys = googleCloudKeys;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
