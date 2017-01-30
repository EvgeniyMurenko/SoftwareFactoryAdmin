package com.SoftwareFactory.model;

import com.SoftwareFactory.util.LocalDatePersistenceConverter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDate;


@Entity
@Table(name = "s_messages")
public class Message {

    public Message() {
    }

    @Id
    @GeneratedValue(generator = "increment2")
    @GenericGenerator(name = "increment2", strategy = "increment")
    @Column(name = "message_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "case_id")
    private Case aCase;

   /* @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id")
    private User user;*/

    @Column(name = "message_time")
    private Date messageTime;

    @Column(name = "message_text")
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

/*    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }*/

    public Date getMessageTime() {
        return messageTime;
    }

    public void setMessageTime(Date messageTime) {
        this.messageTime = messageTime;
    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

    public Message(Case aCase, /*User user,*/Date messageTime, String messageText) {
        this.aCase = aCase;
      /*  this.user = user;*/
        this.messageTime = messageTime;
        this.messageText = messageText;
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", aCase=" + aCase +
           /*     ", user=" + user +*/
             ", messageTime=" + messageTime +
                ", messageText='" + messageText + '\'' +
                '}';
    }
}
