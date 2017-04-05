package com.SoftwareFactory.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "s_google_cloud_keys")
public class GoogleCloudKey {

    @Id
    @GeneratedValue(generator = "increment2")
    @GenericGenerator(name = "increment2", strategy = "increment")
    @Column(name = "google_cloud_keys_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "staff_info_id")
    private StaffInfo staffInfo;

    @Column(name = "cloud_key")
    private String key;


    public GoogleCloudKey() {
    }

    public GoogleCloudKey(StaffInfo staffInfo, String key) {
        this.staffInfo = staffInfo;
        this.key = key;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public StaffInfo getStaffInfo() {
        return staffInfo;
    }

    public void setStaffInfo(StaffInfo staffInfo) {
        this.staffInfo = staffInfo;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
