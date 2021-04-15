package com.liangxiaolin.notes.view;


import com.liangxiaolin.notes.bean.CategoryBean;
import com.liangxiaolin.notes.service.CategoryService;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;


public class CategoryController {

    Main m = new Main();
    CategoryService cs = new CategoryService();

    @FXML
    private Button turnback;

    @FXML
    private TableView<CategoryBean> categorytableview;

    @FXML
    private TableColumn<CategoryBean, String> notecategorycolumn;

    @FXML
    private TableColumn<CategoryBean, String> categoryidcolumn;

    @FXML
    private Button refurbish;

    @FXML
    private Label label_category;


    @FXML
    void turnBack(ActionEvent event) {
        m.gotomainpage();
    }

    @FXML
    void Refurbish(ActionEvent event) {
        ObservableList<CategoryBean> categorybeanlist = cs.getCategoryMessage();
        cs.setCategoryView(categorytableview,categorybeanlist,categoryidcolumn,notecategorycolumn);
    }

}
