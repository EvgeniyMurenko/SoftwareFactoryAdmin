package com.SoftwareFactory.model;

import javax.persistence.*;


@Entity
@Table(name = "s_file_estimate")
public class FileEstimate {

    public FileEstimate(){}

    @Id
    @Column(name = "estimate_id")
    private Long estimateId;

    @Column(name = "link_to_file")
    private String linkToFile;

    @ManyToOne
    @JoinColumn(name = "estimate_id")
    private Estimate estimate;

    public Long getEstimateId() {
        return estimateId;
    }

    public void setEstimateId(Long estimateId) {
        this.estimateId = estimateId;
    }

    public String getLinkToFile() {
        return linkToFile;
    }

    public void setLinkToFile(String linkToFile) {
        this.linkToFile = linkToFile;
    }

    public Estimate getEstimate() {
        return estimate;
    }

    public void setEstimate(Estimate estimate) {
        this.estimate = estimate;
    }

    public FileEstimate(Long estimateId, String linkToFile, Estimate estimate) {
        this.estimateId = estimateId;
        this.linkToFile = linkToFile;
        this.estimate = estimate;
    }
}
