package com.SoftwareFactoryAdmin.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "s_toss_task_link")
public class TossTaskLink {

    public TossTaskLink(){}

    public TossTaskLink(TossTask tossTask, String fileLink, String fileName, String fileUuidName) {
        this.tossTask = tossTask;
        this.fileLink = fileLink;
        this.fileName = fileName;
        this.fileUuidName = fileUuidName;
    }

    @Id
    @GeneratedValue(generator = "increment2")
    @GenericGenerator(name = "increment2", strategy = "increment")
    @Column(name = "id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "toss_task_id")
    private TossTask tossTask;

    @Column(name = "file_link")
    private String fileLink;

    @Column(name = "file_name")
    private String fileName;

    @Column(name = "file_uuid_name")
    private String fileUuidName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TossTask getTossTask() {
        return tossTask;
    }

    public void setTossTask(TossTask tossTask) {
        this.tossTask = tossTask;
    }

    public String getFileLink() {
        return fileLink;
    }

    public void setFileLink(String fileLink) {
        this.fileLink = fileLink;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileUuidName() {
        return fileUuidName;
    }

    public void setFileUuidName(String fileUuidName) {
        this.fileUuidName = fileUuidName;
    }
}
