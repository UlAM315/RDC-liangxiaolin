package com.liangxiaolin.notes.view;


import com.liangxiaolin.notes.bean.SearchTableBean;
import com.liangxiaolin.notes.service.SearchService;
import com.liangxiaolin.notes.util.SimpleUtils;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class SearchController {

    Main m = new Main();
    SearchService ss = new SearchService();

    @FXML
    private Label label_tip;

    @FXML
    private Button addtofavorite;

    @FXML
    private Button refurbish_button;

    @FXML
    private Button turnback;

    @FXML
    private TableColumn<SearchTableBean, String> categorycolumn;

    @FXML
    private TableColumn<SearchTableBean, String> issuetimecolumn;

    @FXML
    private TextArea textarea;

    @FXML
    private TextField searchid_text;
    public static int searchid;

    @FXML
    private TableColumn<SearchTableBean, String> noteidcolumn;

    @FXML
    private TableColumn<SearchTableBean, String> likenumbercolumn;

    @FXML
    private TableColumn<SearchTableBean, String> authorcolumn;

    @FXML
    private RadioButton clicktolike;

    @FXML
    private TableView<SearchTableBean> notetableview;

    @FXML
    private Button search_button;

    @FXML
    private TextField title_text;

    @FXML
    private TableColumn<SearchTableBean, String> titlecolumn;

    @FXML
    private Label title_label;

    @FXML
    void search(ActionEvent event) {
        searchid = Integer.valueOf(searchid_text.getText());
        //先显示出标题和文章
        ObservableList<SearchTableBean> searchtablebeanlist = ss.searchTableMessage();
        boolean ifgetid = false;
        for (int i = 0; i < searchtablebeanlist.size(); i++) {
            SearchTableBean searchtablebean = searchtablebeanlist.get(i);
            String id = searchtablebean.getNote_id();
            if(id.equals((searchid_text.getText()).toString())){
                title_text.setText(searchtablebean.getTitle());
                textarea.setText(searchtablebean.getNote_content());
                ifgetid = true;
            }
        }
        if(ifgetid){
            //可以点赞、收藏
            clicktolike.setDisable(false);
            addtofavorite.setDisable(false);
        }else SimpleUtils.informationDialog("提示","搜索失败！");

    }


    @FXML
    void turnBack(ActionEvent event) {
        if(SimpleUtils.informationDialog("提示","确定要返回吗？")) m.gotomainpage();
    }

    @FXML
    void addToFavorite(ActionEvent event) {
        if(ss.addToFavorite()) SimpleUtils.informationDialog("恭喜","已加入收藏夹！");
        else SimpleUtils.informationDialog("提示","添加失败！");
    }

    @FXML
    void refurbish(ActionEvent event) {
        ObservableList<SearchTableBean> searchtablebeanlist = ss.searchTableMessage();
        if(searchtablebeanlist!=null){
            ss.setMyFavoriteView(notetableview,searchtablebeanlist,authorcolumn,noteidcolumn,titlecolumn,likenumbercolumn,issuetimecolumn,categorycolumn);
        }
        //若要点赞
        //该篇文章点赞了，则赞数+1
        if(clicktolike.isSelected()) {
            ss.clickToLike(Integer.valueOf(searchid_text.getText()));
            clicktolike.setDisable(true);
            clicktolike.setSelected(false);
        }
    }
    }

