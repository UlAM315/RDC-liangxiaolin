package com.liangxiaolin.notes.view;

import com.liangxiaolin.notes.bean.UsersBean;
import com.liangxiaolin.notes.service.LogInService;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class ManagerLogInController {

    Main m = new Main();
    LogInService lis = new LogInService();

    @FXML
    private TableColumn<UsersBean, String> birthday;

    @FXML
    private Button turnback;

    @FXML
    private TableColumn<UsersBean, String> password;

    @FXML
    private TableColumn<UsersBean, String> sex;

    @FXML
    private TableColumn<UsersBean, String> telephone;

    @FXML
    private TableView<UsersBean> tableview;

    @FXML
    private TableColumn<UsersBean, String> id;

    @FXML
    private Label label;

    @FXML
    private Button refurbish;

    @FXML
    private TableColumn<UsersBean, String> username;


    @FXML
    void Turnback(ActionEvent event) {
        m.loginpage();
    }

    @FXML
    void Refurbish(ActionEvent event) {
        ObservableList<UsersBean> usersbeanlist = lis.getUsersMessage();
        if(usersbeanlist!=null){
            lis.setUsersMessageView(tableview,usersbeanlist,id,username,password,birthday,sex,telephone);
        }
    }

}

