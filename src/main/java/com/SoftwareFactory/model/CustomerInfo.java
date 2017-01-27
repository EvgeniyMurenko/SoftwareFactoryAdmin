package com.SoftwareFactory.model;




import javax.persistence.Column;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;


@Table(name="s_customer_info")
public class CustomerInfo {

    public CustomerInfo(){}

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



}

