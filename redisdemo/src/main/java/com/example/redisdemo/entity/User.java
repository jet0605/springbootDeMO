package com.example.redisdemo.entity;


import java.io.Serializable;

public class User implements Serializable{
    private static final long serialVersionUID = 3461231655485106308L;
    private Long id;
    private String userName;
    private String password;
    public User(){}
    public User(Long id,String userName,String password){
        this.id = id;
        this.userName = userName;
        this.password = password;
    }
    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
