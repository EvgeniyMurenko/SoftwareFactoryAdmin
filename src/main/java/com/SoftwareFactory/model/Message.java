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



}
