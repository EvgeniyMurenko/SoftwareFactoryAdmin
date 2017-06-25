package com.SoftwareFactoryAdmin.model;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "s_fxm_post")
public class FxmPost {

    public FxmPost() {
    }

    public FxmPost(User user, String userName, Date date, String postText, List<FxmComment> fxmComments) {
        this.user = user;
        this.userName = userName;
        this.date = date;
        this.postText = postText;
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


    @Column(name = "post_text")
    @Type(type = "text")
    private String postText;


    @OneToMany(mappedBy = "fxmPost", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
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

    public String getPostText() {
        return postText;
    }

    public void setPostText(String postText) {
        this.postText = postText;
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
}
