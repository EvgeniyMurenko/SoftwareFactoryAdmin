package com.SoftwareFactory.model;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * Created by Oleksandr on 1/26/2017.
 */


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


}
