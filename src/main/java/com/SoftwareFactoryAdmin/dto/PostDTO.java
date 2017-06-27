package com.SoftwareFactoryAdmin.dto;


import java.util.Date;
import java.util.List;

public class PostDTO {

    public PostDTO(Long id, Long serverID, Long userID, String userName, Date date, String postText) {
        this.id = id;
        this.serverID = serverID;
        this.userID = userID;
        this.userName = userName;
        this.date = date;
        this.postText = postText;
    }

    private Long id;

    private Long serverID;

    private Long userID;

    private String userName;

    private Date date;

    private String postText;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserID() {
        return userID;
    }

    public void setUserID(Long userID) {
        this.userID = userID;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getPostText() {
        return postText;
    }

    public void setPostText(String postText) {
        this.postText = postText;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Long getServerID() {
        return serverID;
    }

    public void setServerID(Long serverID) {
        this.serverID = serverID;
    }
}
