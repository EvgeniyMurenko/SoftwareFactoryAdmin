package com.SoftwareFactoryAdmin.dto;


import java.util.Date;
import java.util.List;

public class ManagerInfoDTO {

    public ManagerInfoDTO(){}

    public ManagerInfoDTO(Long id, String name, String phone, String email, Date birthday, String avatarImage, List<String> permissions) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.birthday = birthday;
        this.avatarImage = avatarImage;
        this.permissions = permissions;
    }

    private Long id;

    private String name;

    private String phone;

    private String email;

    private Date birthday;

    private String avatarImage;

    private List<String> permissions;

    public List<String> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<String> permissions) {
        this.permissions = permissions;
    }

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

    public String getAvatarImage() {
        return avatarImage;
    }

    public void setAvatarImage(String avatarImage) {
        this.avatarImage = avatarImage;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
