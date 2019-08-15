package com.crc.test;

/**
 * @Author: kunrong
 * @Date: 2019/8/5 15:41
 * @Description:
 **/
public class User {
    private  Integer type;
    private String email;

    public String getEmail() {
        return email;
    }

    public User(Integer type, String email) {
        this.type = type;
        this.email = email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "User{" +
                "type=" + type +
                '}';
    }
}
