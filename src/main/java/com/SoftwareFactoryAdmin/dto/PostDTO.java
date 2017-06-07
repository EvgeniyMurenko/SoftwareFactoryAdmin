package com.SoftwareFactoryAdmin.dto;


import java.util.Date;
import java.util.List;

public class PostDTO {

    private Long id;

    private Long userID;

    private Date date;

    private String postText;

    private List<CommentDTO> fxmComments;

}
