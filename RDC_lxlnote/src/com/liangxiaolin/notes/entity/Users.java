package com.liangxiaolin.notes.entity;

public class Users {
    private int user_id;
    private String user_name;  //用户名
    private String password;  //登录密码
    private String birthday;  //生日
    private String sex;  //性别
    private String telephone;  //手机号

    public Users() {
    }

    public Users(int user_id, String user_name, String password, String birthday, String sex, String telephone) {
        this.user_id = user_id;
        this.user_name = user_name;
        this.password = password;
        this.birthday = birthday;
        this.sex = sex;
        this.telephone = telephone;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }


}
