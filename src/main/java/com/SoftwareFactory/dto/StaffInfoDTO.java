package com.SoftwareFactory.dto;


import java.util.Date;
import java.util.List;
import java.util.Set;

public class StaffInfoDTO {

    public StaffInfoDTO(){}

    public StaffInfoDTO(String name, String phone, String email, Date birthday, List<MessageTaskDTO> messageTaskDTOS) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.birthday = birthday;
        this.messageTaskDTOS = messageTaskDTOS;
    }

    private String name;

    private String phone;

    private String email;

    private Date birthday;

    private List<MessageTaskDTO> messageTaskDTOS;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public List<MessageTaskDTO> getMessageTaskDTOS() {
        return messageTaskDTOS;
    }

    public void setMessageTaskDTOS(List<MessageTaskDTO> messageTaskDTOS) {
        this.messageTaskDTOS = messageTaskDTOS;
    }
}
