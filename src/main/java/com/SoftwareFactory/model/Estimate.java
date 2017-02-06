package com.SoftwareFactory.model;


import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;

@Entity
@Table(name="s_estimates")
public class Estimate {

    @Id
    @GeneratedValue(generator = "increment2")
    @GenericGenerator(name = "increment2", strategy = "increment")
    private Long id;


    @Column(name="name", nullable=false)
    private String name;


    @Column(name="email", nullable=false)
    private String email;

    @Column(name="estimate_request", nullable=false)
    private String estimateRequest;


    @Column(name="status" , nullable=false)
    private String status;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEstimateRequest() {
        return estimateRequest;
    }

    public void setEstimateRequest(String estimateRequest) {
        this.estimateRequest = estimateRequest;
    }

    public String getState() {
        return status;
    }

    public void setState(String state) {
        this.status = state;
    }

    public  Estimate(){}

    public Estimate(String name, String email, String estimateRequest, String status) {
        this.name = name;
        this.email = email;
        this.estimateRequest = estimateRequest;
        this.status = status;
    }

    @Override
    public String toString() {
        return "Estimate{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", estimateRequest='" + estimateRequest + '\'' +
                ", state=" + status +
                '}';
    }
}
