package com.liangxiaolin.notes.bean;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.SimpleStringProperty;

public class UsersBean {
    private SimpleStringProperty user_id;
    private SimpleStringProperty user_name;
    private SimpleStringProperty password;
    private SimpleStringProperty birthday;
    private SimpleStringProperty sex;
    private SimpleStringProperty telephone;

    public UsersBean() {
    }

    public UsersBean(String user_id, String user_name, String password, String birthday, String sex, String telephone) {
        this.user_id = new SimpleStringProperty(user_id);
        this.user_name = new SimpleStringProperty(user_name);
        this.password = new SimpleStringProperty(password);
        this.birthday = new SimpleStringProperty(birthday);
        this.sex = new SimpleStringProperty(sex);
        this.telephone = new SimpleStringProperty(telephone);
    }

    public String getUser_id() {
        return user_id.get();
    }

    public SimpleStringProperty user_idProperty() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id.set(user_id);
    }

    public String getUser_name() {
        return user_name.get();
    }

    public SimpleStringProperty user_nameProperty() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name.set(user_name);
    }

    public String getPassword() {
        return password.get();
    }

    public SimpleStringProperty passwordProperty() {
        return password;
    }

    public void setPassword(String password) {
        this.password.set(password);
    }

    public String getBirthday() {
        return birthday.get();
    }

    public SimpleStringProperty birthdayProperty() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday.set(birthday);
    }

    public String getSex() {
        return sex.get();
    }

    public SimpleStringProperty sexProperty() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex.set(sex);
    }

    public String getTelephone() {
        return telephone.get();
    }

    public SimpleStringProperty telephoneProperty() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone.set(telephone);
    }
}
