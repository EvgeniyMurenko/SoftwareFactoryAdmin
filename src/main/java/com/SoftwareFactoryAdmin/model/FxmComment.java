package com.SoftwareFactoryAdmin.model;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "s_fxm_comment")
public class FxmComment {

    public FxmComment() {
    }

    public FxmComment(Long userID, Date date, String postText, FxmPost fxmPost) {
        this.userID = userID;
        this.date = date;
        this.postText = postText;
        this.fxmPost = fxmPost;
    }

    @Id
    @GeneratedValue(generator = "increment2")
    @GenericGenerator(name = "increment2", strategy = "increment")
    @Column(name = "id")
    private Long id;


    @Id
    @Column(name = "user_id", nullable = false)
    private Long userID;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;


    @Column(name = "date", columnDefinition = "DATETIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;


    @Column(name = "comment_text")
    @Type(type = "text")
    private String postText;


    @ManyToOne
    @JoinColumn(name = "post_id")
    private FxmPost fxmPost;



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

    public String getPostText() {
        return postText;
    }

    public void setPostText(String postText) {
        this.postText = postText;
    }

    public FxmPost getFxmPost() {
        return fxmPost;
    }

    public void setFxmPost(FxmPost fxmPost) {
        this.fxmPost = fxmPost;
    }

    public Long getUserID() {
        return userID;
    }

    public void setUserID(Long userID) {
        this.userID = userID;
    }
}
