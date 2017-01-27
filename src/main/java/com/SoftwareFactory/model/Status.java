package com.SoftwareFactory.model;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;


/**
 * Created by Oleksandr on 1/26/2017.
 */

@Entity
@Table(name="s_status")
public class Status {

    public Status(){}

    @Id
    @GeneratedValue(generator = "increment2")
    @GenericGenerator(name = "increment2", strategy = "increment")
    @Column(name="id")
    private Long id;

    @Column(name="type")
    private String statusType;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStatusType() {
        return statusType;
    }

    public void setStatusType(String statusType) {
        this.statusType = statusType;
    }

    public Status(String statusType) {
        this.statusType = statusType;
    }

    @Override
    public String toString() {
        return "Status{" +
                "id=" + id +
                ", statusType='" + statusType + '\'' +
                '}';
    }
}
