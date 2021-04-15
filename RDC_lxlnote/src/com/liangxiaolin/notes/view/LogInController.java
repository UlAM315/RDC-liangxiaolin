package com.liangxiaolin.notes.view;

import java.net.URL;
import java.util.ResourceBundle;

import com.liangxiaolin.notes.service.LogInService;
import com.liangxiaolin.notes.util.SimpleUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

    public class LogInController {

        Main m = new Main();
        SimpleUtils su = new SimpleUtils();
        LogInService lis = new LogInService();

        @FXML
        private Button manager;

        @FXML
        private ResourceBundle resources;

        @FXML
        private URL location;

        @FXML
        private ImageView rdcphoto;

        @FXML
        private PasswordField password;

        @FXML
        private Button recover;

        @FXML
        private ImageView photo1;

        @FXML
        private Label label_title;

        @FXML
        private TextField user_name;
        public static String username;

        @FXML
        private Label label_password;

        @FXML
        private Hyperlink forgetpassword;

        @FXML
        private Button login;

        @FXML
        private ImageView photo2;

        @FXML
        private Label label_username;

        @FXML
        private Hyperlink register;

        @FXML
        void Login(ActionEvent event) {

            if(lis.ifLogIn(this.user_name.getText(), this.password.getText(),"users")){
                username = this.user_name.getText();
                su.informationDialog("恭喜","登录成功！");
                m.gotomainpage();
            }else{
                su.informationDialog("警告","登录失败，请检查用户名和密码！");
            }
        }

        @FXML
        void Recover(ActionEvent event) {
            user_name.setText("");
            password.setText("");
            user_name.setText("");
        }

        @FXML
        void Forgetpassword(ActionEvent event) {
            m.gotoforgetpassword();
        }

        @FXML
        void Register(ActionEvent event) {
            m.gotoregister();
        }

        @FXML
        void managerLogIn(ActionEvent event) {
            if(lis.ifLogIn(this.user_name.getText(), this.password.getText(),"manager")){
                username = this.user_name.getText();
                su.informationDialog("恭喜","登录成功！");
                m.gotoManagerLogIn();
            }else{
                su.informationDialog("警告","登录失败，请检查用户名和密码！");
            }
        }

        @FXML
        void initialize() {
            assert rdcphoto != null : "fx:id=\"rdcphoto\" was not injected: check your FXML file 'LogIn.fxml'.";
            assert password != null : "fx:id=\"password\" was not injected: check your FXML file 'LogIn.fxml'.";
            assert recover != null : "fx:id=\"recover\" was not injected: check your FXML file 'LogIn.fxml'.";
            assert photo1 != null : "fx:id=\"photo1\" was not injected: check your FXML file 'LogIn.fxml'.";
            assert label_title != null : "fx:id=\"label_title\" was not injected: check your FXML file 'LogIn.fxml'.";
            assert user_name != null : "fx:id=\"user_name\" was not injected: check your FXML file 'LogIn.fxml'.";
            assert label_password != null : "fx:id=\"label_password\" was not injected: check your FXML file 'LogIn.fxml'.";
            assert forgetpassword != null : "fx:id=\"forgetpassword\" was not injected: check your FXML file 'LogIn.fxml'.";
            assert login != null : "fx:id=\"login\" was not injected: check your FXML file 'LogIn.fxml'.";
            assert photo2 != null : "fx:id=\"photo2\" was not injected: check your FXML file 'LogIn.fxml'.";
            assert label_username != null : "fx:id=\"label_username\" was not injected: check your FXML file 'LogIn.fxml'.";
            assert register != null : "fx:id=\"register\" was not injected: check your FXML file 'LogIn.fxml'.";

        }
    }
