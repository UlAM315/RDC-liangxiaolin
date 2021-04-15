package com.liangxiaolin.notes.view;


import com.liangxiaolin.notes.bean.MyFavoriteBean;
import com.liangxiaolin.notes.service.MyFavoriteService;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class MyFavoriteController {

    Main m = new Main();
    MyFavoriteService mfs = new MyFavoriteService();

    @FXML
    private Button refurbish;

    @FXML
    private TableColumn<MyFavoriteBean, String> authorcolumn;

    @FXML
    private Button turnback;

    @FXML
    private TableView<MyFavoriteBean> notetableview;

    @FXML
    private TableColumn<MyFavoriteBean, String> categorycolumn;

    @FXML
    private TableColumn<MyFavoriteBean, String> issuetimecolumn;

    @FXML
    private TableColumn<MyFavoriteBean, String> titlecolumn;

    @FXML
    private TableColumn<MyFavoriteBean, String> favoritetimecolumn;

    @FXML
    private TableColumn<MyFavoriteBean, String> likenumbercolumn;

    @FXML
    private Label title_label;


    @FXML
    void turnBack(ActionEvent event) {
        m.gotomainpage();
    }

    @FXML
    void Refurbish(ActionEvent event) {
        ObservableList<MyFavoriteBean> myfavoritebeanlist = mfs.MyFavoriteMessage();
        if(myfavoritebeanlist!=null){
            mfs.setMyFavoriteView(notetableview,myfavoritebeanlist,authorcolumn,titlecolumn,likenumbercolumn,issuetimecolumn,categorycolumn,favoritetimecolumn);
        }
    }

}

