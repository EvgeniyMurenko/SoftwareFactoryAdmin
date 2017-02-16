package com.SoftwareFactory.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;


@Entity
@Table(name = "s_file_estimate")
public class FileEstimate {

    public FileEstimate(){}

    @Id
    @GeneratedValue(generator = "increment2")
    @GenericGenerator(name = "increment2", strategy = "increment")
    @Column(name = "file_estimate_id")
    private long fileEstimateId;

    @Column(name = "link_to_file")
    private String linkToFile;

    @ManyToOne
    @JoinColumn(name = "estimate_id")
    private Estimate estimate;


    public String getLinkToFile() {
        return linkToFile;
    }

    public void setLinkToFile(String linkToFile) {
        this.linkToFile = linkToFile;
    }

    public long getFileEstimateId() {
        return fileEstimateId;
    }

    public void setFileEstimateId(long fileEstimateId) {
        this.fileEstimateId = fileEstimateId;
    }

    public Estimate getEstimate() {
        return estimate;
    }


    public void setEstimate(Estimate estimate) {
        this.estimate = estimate;
    }

    public FileEstimate(Long estimateId, String linkToFile, Estimate estimate) {

        this.linkToFile = linkToFile;
        this.estimate = estimate;
    }
}
