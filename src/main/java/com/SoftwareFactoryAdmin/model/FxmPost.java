package com.SoftwareFactoryAdmin.model;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "s_fxm_post")
public class FxmPost implements Serializable {

    public FxmPost() {
    }

    public FxmPost(User user, String userName, Date date, String postTextOriginal, String postTextRu, String postTextEn, String postTextKo, String linksFile, String linksImage, String linksVideo, String groupType, List<FxmComment> fxmComments) {
        this.user = user;
        this.userName = userName;
        this.date = date;
        this.postTextOriginal = postTextOriginal;
        this.postTextRu = postTextRu;
        this.postTextEn = postTextEn;
        this.postTextKo = postTextKo;
        this.linksFile = linksFile;
        this.linksImage = linksImage;
        this.linksVideo = linksVideo;
        this.groupType = groupType;
        this.fxmComments = fxmComments;
    }

    @Id
    @GeneratedValue(generator = "increment2")
    @GenericGenerator(name = "increment2", strategy = "increment")
    @Column(name = "id")
    private Long id;


    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;


    @Column(name = "user_name")
    private String userName;


    @Column(name = "date", columnDefinition = "DATETIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;


    @Column(name = "post_text_original")
    @Type(type = "text")
    private String postTextOriginal;

    @Column(name = "post_text_ru")
    @Type(type = "text")
    private String postTextRu;

    @Column(name = "post_text_en")
    @Type(type = "text")
    private String postTextEn;

    @Column(name = "post_text_ko")
    @Type(type = "text")
    private String postTextKo;

    @Column(name = "links_file")
    @Type(type = "text")
    private String linksFile;

    @Column(name = "links_image")
    @Type(type = "text")
    private String linksImage;

    @Column(name = "links_video")
    @Type(type = "text")
    private String linksVideo;

    @Column(name = "show_to")
    private String groupType;

    @OneToMany(mappedBy = "fxmPost", fetch = FetchType.LAZY)
    private List<FxmComment> fxmComments;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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

    public List<FxmComment> getFxmComments() {
        return fxmComments;
    }

    public void setFxmComments(List<FxmComment> fxmComments) {
        this.fxmComments = fxmComments;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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

    public String getGroupType() {
        return groupType;
    }

    public void setGroupType(String groupType) {
        this.groupType = groupType;
    }
}
