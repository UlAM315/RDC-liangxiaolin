package com.liangxiaolin.notes.service;

import com.liangxiaolin.notes.bean.UsersBean;
import com.liangxiaolin.notes.dao.LogInDao;
import com.liangxiaolin.notes.entity.Users;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.util.List;

public class LogInService {
    Users users = new Users();
    LogInDao lid = new LogInDao();

    public boolean ifLogIn(String logincontrolleruser_name,String logincontrollerpassword ,String table){
        String daopassword = lid.getDaoPassword(logincontrolleruser_name,table);
        if(daopassword==null) return false;
        if(daopassword.equals(logincontrollerpassword)) return true;
        else return false;
    }

    public ObservableList<UsersBean> getUsersMessage(){
        List<Users> userlist = lid.getUsersMessage();
        //封装成bean类
        ObservableList<UsersBean> usersbeanlist = FXCollections.observableArrayList();
        if(userlist!=null)
        for (int i = 0; i < userlist.size(); i++) {
            Users users = userlist.get(i);
            UsersBean usersbean = new UsersBean(String.valueOf(users.getUser_id()),users.getUser_name(),users.getPassword(),users.getBirthday(),users.getSex(),users.getTelephone());
            usersbeanlist.add(usersbean);
        }
        return usersbeanlist;
    }

    public void setUsersMessageView(TableView tableView, ObservableList usersbeanlist, TableColumn<UsersBean, String> userid,TableColumn<UsersBean, String> username,TableColumn<UsersBean, String> password,TableColumn<UsersBean, String> birthday,TableColumn<UsersBean, String> sex,TableColumn<UsersBean, String> telephone){
        // 设置列的数据
        userid.setCellValueFactory(cellData -> cellData.getValue().user_idProperty());
        username.setCellValueFactory(cellData -> cellData.getValue().user_nameProperty());
        password.setCellValueFactory(cellData -> cellData.getValue().passwordProperty());
        birthday.setCellValueFactory(cellData -> cellData.getValue().birthdayProperty());
        sex.setCellValueFactory(cellData -> cellData.getValue().sexProperty());
        telephone.setCellValueFactory(cellData -> cellData.getValue().telephoneProperty());
        // 将数据添加到表格控件中
        tableView.setItems(usersbeanlist);
    }
}
