package com.SoftwareFactoryAdmin.dto;


import java.util.Date;
import java.util.List;

public class PostDTO {

    public PostDTO() {
    }

    public PostDTO(Long id, Long serverID, Long userID, String userName, Date date, String postTextOriginal, String postTextRu, String postTextEn, String postTextKo, String linksFile, String linksImage, String linksVideo, String postUserAvatarImage, String groupType) {
        this.id = id;
        this.serverID = serverID;
        this.userID = userID;
        this.userName = userName;
        this.date = date;
        this.postTextOriginal = postTextOriginal;
        this.postTextRu = postTextRu;
        this.postTextEn = postTextEn;
        this.postTextKo = postTextKo;
        this.linksFile = linksFile;
        this.linksImage = linksImage;
        this.linksVideo = linksVideo;
        this.postUserAvatarImage = postUserAvatarImage;
        this.groupType = groupType;
    }

    private Long id;

    private Long serverID;

    private Long userID;

    private String userName;

    private Date date;

    private String postTextOriginal;

    private String postTextRu;

    private String postTextEn;

    private String postTextKo;

    private String linksFile;

    private String linksImage;

    private String linksVideo;

    private String postUserAvatarImage;

    private String groupType;



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

    public String getPostTextOriginal() {
        return postTextOriginal;
    }

    public void setPostTextOriginal(String postTextOriginal) {
        this.postTextOriginal = postTextOriginal;
    }

    public String getPostTextRu() {
        return postTextRu;
    }

    public void setPostTextRu(String postTextRu) {
        this.postTextRu = postTextRu;
    }

    public String getPostTextEn() {
        return postTextEn;
    }

    public void setPostTextEn(String postTextEn) {
        this.postTextEn = postTextEn;
    }

    public String getPostTextKo() {
        return postTextKo;
    }

    public void setPostTextKo(String postTextKo) {
        this.postTextKo = postTextKo;
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

    public String getLinksFile() {
        return linksFile;
    }

    public void setLinksFile(String linksFile) {
        this.linksFile = linksFile;
    }

    public String getLinksImage() {
        return linksImage;
    }

    public void setLinksImage(String linksImage) {
        this.linksImage = linksImage;
    }

    public String getLinksVideo() {
        return linksVideo;
    }

    public void setLinksVideo(String linksVideo) {
        this.linksVideo = linksVideo;
    }

    public String getPostUserAvatarImage() {
        return postUserAvatarImage;
    }

    public void setPostUserAvatarImage(String postUserAvatarImage) {
        this.postUserAvatarImage = postUserAvatarImage;
    }

    public String getGroupType() {
        return groupType;
    }

    public void setGroupType(String groupType) {
        this.groupType = groupType;
    }
}
