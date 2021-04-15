package com.liangxiaolin.notes.view;


import com.liangxiaolin.notes.bean.EditorBean;
import com.liangxiaolin.notes.service.EditorService;
import com.liangxiaolin.notes.util.SimpleUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class PersonalNotesEditController {

    Main m = new Main();
    SimpleUtils su = new SimpleUtils();
    EditorService es = new EditorService();

    @FXML
    private TextField category;
    public static String getcategory;

    @FXML
    private Hyperlink wanttoissue;

    @FXML
    private Button modify;

    @FXML
    private TextField id_text;
    public static int id;
    public static String idString;

    @FXML
    private Button searchid;

    @FXML
    private Button issue;

    @FXML
    private Label label_openorprivate;

    @FXML
    private TextField openopenorprivate;

    @FXML
    private TextField title_text;

    @FXML
    private TextArea textarea;

    @FXML
    private Button returnmainpage;

    @FXML
    private Button savemodify;

    @FXML
    private Button delete;


    @FXML
    void searchidAction(ActionEvent event) {
        //获取noteid
        id = Integer.valueOf(id_text.getText());
        idString = id_text.getText();
        //清空展示区域
        title_text.clear();
        textarea.clear();
        category.clear();
        openopenorprivate.clear();
        //再打印出信息
        EditorBean eb = es.getNoteMessage();
        if(eb!=null){
            title_text.setText(eb.getTitle());
            category.setText(eb.getCategory_name());
            textarea.setText(eb.getNote_content());
            openopenorprivate.setText(eb.getIf_open());
        }
        //不可发布、编辑文本框
        issue.setDisable(true);
        textarea.setEditable(false);
        title_text.setEditable(false);
        category.setEditable(false);
        openopenorprivate.setEditable(false);
        //可以删除、修改
        delete.setDisable(false);
        modify.setDisable(false);
    }

    @FXML
    void saveModifyAction(ActionEvent event) {
        getcategory = category.getText();
        if(su.informationDialog("提示","请问确定保存修改吗？")){
            //输入框不可以为空
            if(title_text.getText()!="" && textarea.getText()!="" && category.getText()!=""){
                //确定就把信息保留到数据库
                if(es.modifyOrAddNote(title_text.getText(),textarea.getText(),openopenorprivate.getText(),"modify")){
                    su.informationDialog("恭喜","修改成功！");
                }else su.informationDialog("提示","修改失败！");
            }else su.informationDialog("提示","输入框不可为空！");
            //取消就不动
        }

        //然后文本框变成不可编辑状态
        title_text.setEditable(false);
        textarea.setEditable(false);
        category.setEditable(false);
        openopenorprivate.setEditable(false);
        // 取消就不动

        //接着保存修改按钮不可操作
        savemodify.setDisable(true);
    }

    @FXML
    void returnMainPageAction(ActionEvent event) {
        if(su.informationDialog("提示","确定要返回主页面吗？")) m.gotomainpage();
    }

    @FXML
    void issueAction(ActionEvent event) {
        getcategory = category.getText();
        if(su.informationDialog("提示","确定发布该笔记吗？")){
            //输入框不可以为空
            if(title_text.getText()!="" && textarea.getText()!="" && category.getText()!=""){
                //确定就把信息保留到数据库,记得加上获取当前时间的函数
                if(es.modifyOrAddNote(title_text.getText(),textarea.getText(),openopenorprivate.getText(),"add")){
                    su.informationDialog("恭喜","发布成功！");
                }else su.informationDialog("提示","发布失败！");
            }else su.informationDialog("提示","输入框不可为空！");
        }

        //取消就不动
    }

    @FXML//文本框一直都是不可编辑的
    void deleteAction(ActionEvent event) {
        if(su.informationDialog("提示","请问确定要删除该笔记吗？")){
            //确认就删除笔记，保存信息到数据库
            if(es.deleteNote()) su.informationDialog("恭喜","删除成功！");
            else su.informationDialog("提示","删除失败！");
        }
        //取消就不动
    }

    @FXML
    void modifyAction(ActionEvent event) {
        //文本框可编辑
        title_text.setEditable(true);
        textarea.setEditable(true);
        category.setEditable(true);
        openopenorprivate.setEditable(true);
        //出现保存修改按钮
        savemodify.setDisable(false);
    }

    @FXML
    void wantToIssue(ActionEvent event) {
        //清空编辑区域
        textarea.clear();
        title_text.clear();
        category.clear();
        openopenorprivate.clear();
        //可以编辑
        textarea.setEditable(true);
        title_text.setEditable(true);
        category.setEditable(true);
        openopenorprivate.setEditable(true);
        //可以发布
        issue.setDisable(false);
        //不可以删除、修改、保存修改
        delete.setDisable(true);
        modify.setDisable(true);
        savemodify.setDisable(true);
    }
}
