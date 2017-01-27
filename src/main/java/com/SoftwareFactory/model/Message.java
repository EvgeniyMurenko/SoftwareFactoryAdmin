package com.SoftwareFactory.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;


/**
 * Created by Oleksandr on 1/26/2017.
 */

@Table(name="s_messages")
public class Message {

    public Message(){}

    @Id
    @GeneratedValue(generator = "increment2")
    @GenericGenerator(name = "increment2", strategy = "increment")
    @Column(name="id")
    private Long id;


    @ManyToOne
    @JoinColumn(name="id", nullable=false)
    private Case aCase;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id")
    private User user;

    @Column(name="message_time")
    private LocalDate messageTime;

    @Column(name="message_text")
    private String messageText;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Case getaCase() {
        return aCase;
    }

    public void setaCase(Case aCase) {
        this.aCase = aCase;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LocalDate getMessageTime() {
        return messageTime;
    }

    public void setMessageTime(LocalDate messageTime) {
        this.messageTime = messageTime;
    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

    public Message(Case aCase, User user, LocalDate messageTime, String messageText) {
        this.aCase = aCase;
        this.user = user;
        this.messageTime = messageTime;
        this.messageText = messageText;
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", aCase=" + aCase +
                ", user=" + user +
                ", messageTime=" + messageTime +
                ", messageText='" + messageText + '\'' +
                '}';
    }
}
