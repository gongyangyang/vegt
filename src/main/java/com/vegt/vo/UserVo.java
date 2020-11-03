package com.vegt.vo;

import com.vegt.entity.user;

import java.util.Objects;

public class UserVo {

    private Integer id;
    private String username;
    private String password;
    private String phone;
    private String  salt;
    private String uname;

    public UserVo(){ }
    public UserVo(user user, String uname){
        this.id= user.getId();
        this.username=user.getUsername();
        this.password=user.getPassword();
        this.phone=user.getPhone();
        this.salt=user.getSalt();
        this.uname=uname;

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    @Override
    public String toString() {
        return "UserVo{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", phone='" + phone + '\'' +
                ", salt='" + salt + '\'' +
                ", uname='" + uname + '\'' +
                '}';
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserVo)) return false;
        UserVo userVo = (UserVo) o;
        return Objects.equals(id, userVo.id) &&
                Objects.equals(username, userVo.username) &&
                Objects.equals(password, userVo.password) &&
                Objects.equals(phone, userVo.phone) &&
                Objects.equals(salt, userVo.salt) &&
                Objects.equals(uname, userVo.uname);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, username, password, phone, salt, uname);
    }
}
