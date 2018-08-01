package com.example.springbootswagger2demo.domain;

public class User {
    private String userId;
    private String userName;
    private String password;
    public User(){}
    public User(String userId,String userName,String password){
        this.userId = userId;
        this.userName = userName;
        this.password = password;
    }
    @Override
    public boolean equals(Object o){
        if(this == o) {
            return true;
        }
        if(o == null || getClass() != o.getClass()){
            return false;
        }
        User user = (User) o;
        return userId != null ? userId.equals(user.userId) : user.userId == null;
        //如果userId不为空就两个id进行比较，如果为空就判断传入对象的id是否为空
    }
    @Override
    public int hashCode(){
        int result = userId != null ? userId.hashCode() : 0;
        result = 31 * result + (userName != null ? userName.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        return result;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
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
