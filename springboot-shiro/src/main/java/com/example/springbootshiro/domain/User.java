package com.example.springbootshiro.domain;

/**
 * @author Jet
 */
public class User {
    /** 自增Id **/
    private long id;
    /**  账号 **/
    private String username;
    /**  密码  **/
    private String password;
    /**   角色名 **/
    private String rolename;
    /** 是否禁用 **/
    private boolean locked;

    public User(){}

    public User(long id,String username,String password,String rolename,boolean locked){
        this.id = id;
        this.username = username;
        this.password = password;
        this.rolename = rolename;
        this.locked = locked;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }

    public boolean isLocked() {
        return locked;
    }

    public void setLocked(boolean locked) {
        this.locked = locked;
    }
}
