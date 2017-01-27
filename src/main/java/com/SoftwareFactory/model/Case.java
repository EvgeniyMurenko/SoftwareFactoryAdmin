package com.SoftwareFactory.model;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;


@Table(name="s_cases")
public class Case {

    public Case(){}

    @ManyToOne
    @JoinColumn(name="id", nullable=false)
    private Project project;

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
    private LocalDate creationDate;

    @OneToMany
    @JoinColumn(name="aCase")
    private Set<Message> messages;

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserManagerId() {
        return userManagerId;
    }

    public void setUserManagerId(Long userManagerId) {
        this.userManagerId = userManagerId;
    }

    public String getProjectTitle() {
        return projectTitle;
    }

    public void setProjectTitle(String projectTitle) {
        this.projectTitle = projectTitle;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public Set<Message> getMessages() {
        return messages;
    }

    public void setMessages(Set<Message> messages) {
        this.messages = messages;
    }

    public Case(Project project, Long userManagerId, String projectTitle, Status status, LocalDate creationDate, Set<Message> messages) {
        this.project = project;
        this.userManagerId = userManagerId;
        this.projectTitle = projectTitle;
        this.status = status;
        this.creationDate = creationDate;
        this.messages = messages;
    }

    @Override
    public String toString() {
        return "Case{" +
                "project=" + project +
                ", id=" + id +
                ", userManagerId=" + userManagerId +
                ", projectTitle='" + projectTitle + '\'' +
                ", status=" + status +
                ", creationDate=" + creationDate +
                ", messages=" + messages +
                '}';
    }
}
