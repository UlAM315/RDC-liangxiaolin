package com.liangxiaolin.notes.entity;

public class Manager {
    private int manager_id;
    private String manager_name;  //管理员名称
    private String password;  //管理员登陆密码

    public Manager() {
    }

    public Manager(int manager_id, String manager_name, String password) {
        this.manager_id = manager_id;
        this.manager_name = manager_name;
        this.password = password;
    }

    public int getManager_id() {
        return manager_id;
    }

    public void setManager_id(int manager_id) {
        this.manager_id = manager_id;
    }

    public String getManager_name() {
        return manager_name;
    }

    public void setManager_name(String manager_name) {
        this.manager_name = manager_name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
