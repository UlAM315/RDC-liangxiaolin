package com.liangxiaolin.notes.view;

import com.liangxiaolin.notes.service.ForgetPasswordService;
import com.liangxiaolin.notes.util.SimpleUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

public class ForgetPasswordController {

    Main m = new Main();
    SimpleUtils su = new SimpleUtils();
    ForgetPasswordService fps = new ForgetPasswordService();

    @FXML
    private Button turnback;

    @FXML
    private Button finish;

    @FXML
    private Label label_password;

    @FXML
    private TextField telephone;

    @FXML
    private ImageView photo_forgetpassword;

    @FXML
    private PasswordField newpassword;

    @FXML
    private Label label_telephone;

    @FXML
    private Label label_username;

    @FXML
    private Label label_forgetpassword;

    @FXML
    private TextField username;

    @FXML
    void TurnBackAction(ActionEvent event) {
        m.loginpage();
    }

    @FXML
    void Finish(ActionEvent event) {
        /**
         * 判断用户名和手机号是否匹配
         * 若匹配则返回登录界面，否则清空所有信息不返回
         * 记得改变数据库的密码再跳转
         */
        if(username.getText()=="" || telephone.getText()=="" || newpassword.getText()==""){
            if(!su.informationDialog("警告","重置密码失败,输入框不能为空！")) m.loginpage();
        }else{
            if(fps.resetDaoPassword(username.getText(), telephone.getText(),newpassword.getText())){
                su.informationDialog("恭喜","重置密码成功！");
                m.loginpage();
            }else {
                if(su.informationDialog("警告","重置密码失败,请检查用户名和手机号是否匹配")){
                    username.setText("");
                    telephone.setText("");
                    newpassword.setText("");
                }else m.loginpage();
            }
        }
    }

}
