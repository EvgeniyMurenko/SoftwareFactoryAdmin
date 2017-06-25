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

    public FxmComment(User user, String userName, Date date, String commentText, FxmPost fxmPost) {
        this.user = user;
        this.userName = userName;
        this.date = date;
        this.commentText = commentText;
        this.fxmPost = fxmPost;
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


    @Column(name = "comment_text")
    @Type(type = "text")
    private String commentText;


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

    public String getCommentText() {
        return commentText;
    }

    public void setCommentText(String commentText) {
        this.commentText = commentText;
    }

    public FxmPost getFxmPost() {
        return fxmPost;
    }

    public void setFxmPost(FxmPost fxmPost) {
        this.fxmPost = fxmPost;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
