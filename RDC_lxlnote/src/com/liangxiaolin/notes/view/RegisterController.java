package com.liangxiaolin.notes.view;

import java.net.URL;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

import com.liangxiaolin.notes.service.RegisterService;
import com.liangxiaolin.notes.util.SimpleUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;

public class RegisterController {

    Main m = new Main();
    SimpleUtils su = new SimpleUtils();
    RegisterService rs = new RegisterService();

    @FXML
    private Button turnback;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private DatePicker birthday;

    @FXML
    private RadioButton woman;

    @FXML
    private TextField user_name;

    @FXML
    private ToggleGroup sex;

    @FXML
    private TextField telephone;

    @FXML
    private ImageView photo_newuser;

    @FXML
    private Label lable_user_name;

    @FXML
    private Label label_sex;

    @FXML
    private PasswordField password;

    @FXML
    private Label label_newuser;

    @FXML
    private Label label_birthday;

    @FXML
    private Label label_password;

    @FXML
    private Button finish;

    @FXML
    private RadioButton man;

    @FXML
    private Label label_telephone;

    @FXML
    void TurnBack(ActionEvent event) {
        m.loginpage();
    }

    @FXML
    void Finish(ActionEvent event) {
        //性别不会为空，因为已经默认选择‘男’
        if (user_name.getText() == "" || password.getText() == "" || birthday.getValue() == null || telephone.getText() == "") {
            //若提示框中选择取消，则返回登录界面
            if (!su.informationDialog("警告", "注册失败，输入框不能为空！")) m.loginpage();
            //若提示框中选择确定，则留在原来的页面且清空输入框
            else {
                user_name.setText("");
                password.setText("");
                birthday.setAccessibleText("");
                password.setText("");
                telephone.setText("");
            }
        } else {//全员非空
            //判断用户名是否存在
            if (rs.ifUserNameExist(user_name.getText())) {
                boolean torf = su.informationDialog("警告", "注册失败，用户名已存在！");
                //若提示框中选择取消，则返回登录界面
                if (!torf) m.loginpage();
                    //若提示框中选择确定，则清空用户名输入框
                else {
                    user_name.setText("");
                }//接着判断手机号是否存在
            } else if (rs.ifTelephoneExist(telephone.getText())) {

                boolean torf = su.informationDialog("警告", "注册失败，手机号已存在！");
                //若提示框中选择取消，则返回登录界面
                if (!torf) m.loginpage();
                    //若提示框中选择确定，则清空手机号输入框
                else {
                    telephone.setText("");
                }
            }
            if (rs.ifUserNameExist(user_name.getText()) && rs.ifTelephoneExist(telephone.getText())) {
                boolean torf = su.informationDialog("提示", "该用户已存在！请直接登录！");
                //若提示框中选择取消，则返回登录界面
                if (!torf) m.loginpage();
                    //若提示框中选择确定，则清空用户名和手机号输入框
                else {
                    user_name.setText("");
                    telephone.setText("");
                }
            }
            //假如用户名和手机号都不存在，则可以注册

            if (!rs.ifUserNameExist(user_name.getText()) && !rs.ifTelephoneExist(telephone.getText()) ) {
                String getsex;
                //判断选择的性别
                if(man.isSelected()) getsex = man.getText();
                else getsex = woman.getText();

                if (rs.register(user_name.getText(), password.getText(), birthday.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")), getsex, telephone.getText()) && telephone.getText().length() == 11) {
                    su.informationDialog("恭喜", "注册成功！");
                } else {
                    su.informationDialog("提示", "注册失败！");
                    if(telephone.getText().length()!= 11){
                        //假如手机号不是11位则注册失败并提醒修改手机号位数
                        su.informationDialog("提示", "请检查手机号是否满足11位数");
                    }
                }
                m.loginpage();
            }
        }
    }

    @FXML
    void initialize() {
        assert birthday != null : "fx:id=\"birthday\" was not injected: check your FXML file 'Register.fxml'.";
        assert woman != null : "fx:id=\"woman\" was not injected: check your FXML file 'Register.fxml'.";
        assert user_name != null : "fx:id=\"user_name\" was not injected: check your FXML file 'Register.fxml'.";
        assert sex != null : "fx:id=\"sex\" was not injected: check your FXML file 'Register.fxml'.";
        assert telephone != null : "fx:id=\"telephone\" was not injected: check your FXML file 'Register.fxml'.";
        assert photo_newuser != null : "fx:id=\"photo_newuser\" was not injected: check your FXML file 'Register.fxml'.";
        assert lable_user_name != null : "fx:id=\"lable_user_name\" was not injected: check your FXML file 'Register.fxml'.";
        assert label_sex != null : "fx:id=\"label_sex\" was not injected: check your FXML file 'Register.fxml'.";
        assert password != null : "fx:id=\"password\" was not injected: check your FXML file 'Register.fxml'.";
        assert label_newuser != null : "fx:id=\"label_newuser\" was not injected: check your FXML file 'Register.fxml'.";
        assert label_birthday != null : "fx:id=\"label_birthday\" was not injected: check your FXML file 'Register.fxml'.";
        assert label_password != null : "fx:id=\"label_password\" was not injected: check your FXML file 'Register.fxml'.";
        assert finish != null : "fx:id=\"finish\" was not injected: check your FXML file 'Register.fxml'.";
        assert man != null : "fx:id=\"man\" was not injected: check your FXML file 'Register.fxml'.";
        assert label_telephone != null : "fx:id=\"label_telephone\" was not injected: check your FXML file 'Register.fxml'.";

    }
}

