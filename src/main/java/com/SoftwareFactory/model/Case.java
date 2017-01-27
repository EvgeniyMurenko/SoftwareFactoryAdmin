package com.SoftwareFactory.model;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;


@Table(name="s_cases")
public class Case {


    @Column(name="project_id")
    private Long projectId;


    @Id
    @GeneratedValue(generator = "increment2")
    @GenericGenerator(name = "increment2", strategy = "increment")
    @Column(name="id")
    private Long id;


    @Column(name="user_manager_id")
    private Long userManagerId;

    @Column(name = "title")
    private String projectTitle;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="status_id")
    private Status status;

    @Column(name="date_create")
    private Date creationDate;




}
