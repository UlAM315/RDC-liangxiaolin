package com.liangxiaolin.notes.view;


import com.liangxiaolin.notes.bean.NoteBean;
import com.liangxiaolin.notes.bean.UsersBean;
import com.liangxiaolin.notes.service.MainPageService;
import com.liangxiaolin.notes.util.SimpleUtils;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class MainPageController {

    SimpleUtils su = new SimpleUtils();
    Main m = new Main();
    MainPageService mps = new MainPageService();

    @FXML
    private Tooltip tip;

    @FXML
    private Button save;

    @FXML
    private TextField birthday;

    @FXML
    private Button button_search;

    @FXML
    private TableColumn<NoteBean, String> issuetimecolumn;

    @FXML
    private TableColumn<NoteBean, String> notesidcolumn;

    @FXML
    private Label label_sex;

    @FXML
    private Menu view;

    @FXML
    private TextField search;
    public static String searchkeywork;


    @FXML
    private MenuItem resetpassword;

    @FXML
    private Label label_welcome;

    @FXML
    private MenuItem personal_notes;

    @FXML
    private Menu set;

    @FXML
    private TextField sex;

    @FXML
    private TextField telephone;

    @FXML
    private Button refurbish;

    @FXML
    private MenuItem modify;

    @FXML
    private MenuItem exit;

    @FXML
    private TableView<NoteBean> notetableview;

    @FXML
    private Label label_birthday;

    @FXML
    private TableColumn<NoteBean, String> ifopencolumn;

    @FXML
    private TableColumn<NoteBean, String> titlecolumn;

    @FXML
    private MenuItem category;

    @FXML
    private MenuItem favorite;

    @FXML
    private Label label_username;

    @FXML
    private Label label_telephone;

    @FXML
    private TextField username;

    @FXML
    void favoriteAction(ActionEvent event) {
        m.gotoFavoritePage();
    }

    @FXML
    void categoryAction(ActionEvent event) {
        m.gotoCategoryPage();
    }

    @FXML
    void personalNotesAction(ActionEvent event) {
        m.gotoPersonalNotesEditPage();
    }

    @FXML
    void modifyAction(ActionEvent event) {
        //可以编辑各个输入框
        username.setEditable(true);
        birthday.setEditable(true);
        sex.setEditable(true);
        telephone.setEditable(true);
        //可以点击保存信息按钮
        save.setDisable(false);
        //弹出提示窗口：再此页面只可更改一次用户名
        SimpleUtils.informationDialog("提示","在此页面只可更改一次用户名，若要再更改则需重新登录！");
    }

    @FXML
    void resetPasswordAction(ActionEvent event) {
        m.gotoforgetpassword();
    }

    @FXML
    void exitAction(ActionEvent event) {
        if(su.informationDialog("提示","确定要退出登录吗")) m.loginpage();
    }

    @FXML
    void SearchAction(ActionEvent event) {
        searchkeywork = search.getText();
        m.gotoSearchPage();
    }

    @FXML
    void refurbishAction(ActionEvent event) {
        //显示个人信息
        UsersBean userbean = mps.getPersonalMessage(LogInController.username);
        if(userbean!=null){
            username.setText(userbean.getUser_name());
            birthday.setText(userbean.getBirthday());
            sex.setText(userbean.getSex());
            telephone.setText(userbean.getTelephone());
        }else SimpleUtils.informationDialog("提示","无法刷新！");

        //显示个人笔记信息
        ObservableList<NoteBean> notebeanlist = mps.getNotesMessage();
        if(notebeanlist!=null){
            mps.setNotesView(notetableview,notebeanlist,notesidcolumn,titlecolumn,issuetimecolumn,ifopencolumn);
        }
    }

    @FXML
    void saveAction(ActionEvent event) {

        //先保存数据
        if(SimpleUtils.informationDialog("提示","确定要修改资料吗？")){
            if(mps.modifyPersonalMessage(username.getText(),birthday.getText(),sex.getText(),telephone.getText())){
                SimpleUtils.informationDialog("恭喜","修改成功！");
            }else {
                SimpleUtils.informationDialog("提示","修改失败！");
            }
        }
        //设置各个文本框不可编辑
        username.setEditable(false);
        birthday.setEditable(false);
        sex.setEditable(false);
        telephone.setEditable(false);
        //设置不可以点击保存信息按钮
        save.setDisable(true);
    }

}

