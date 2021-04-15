package com.liangxiaolin.notes.service;

import com.liangxiaolin.notes.bean.CategoryBean;
import com.liangxiaolin.notes.bean.MyFavoriteBean;
import com.liangxiaolin.notes.dao.MyFavoriteDao;
import com.liangxiaolin.notes.entity.Category;
import com.liangxiaolin.notes.entity.MyFavorite;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.util.List;

public class MyFavoriteService {

    MyFavoriteDao mfd = new MyFavoriteDao();
    //封装成bean类
    public ObservableList<MyFavoriteBean> MyFavoriteMessage(){
        List<MyFavorite> list = mfd.getMyFavoriteMessage();
        ObservableList<MyFavoriteBean> myfavoritebeanlist = FXCollections.observableArrayList();
        if(list!=null){
            for (int i = 0; i < list.size(); i++) {
                MyFavorite myfavorite = list.get(i);
                MyFavoriteBean myfavoritebean = new MyFavoriteBean(myfavorite.getAuthor(),myfavorite.getTitle(),String.valueOf(myfavorite.getLike_number()),myfavorite.getIssue_time(),myfavorite.getCategory_name(),myfavorite.getFavorite_time());
                myfavoritebeanlist.add(myfavoritebean);
            }
            return myfavoritebeanlist;
        }
        return null;
    }

    public void setMyFavoriteView(TableView tableView, ObservableList myfavoritebeanlist, TableColumn<MyFavoriteBean, String> authorcolumn, TableColumn<MyFavoriteBean, String> titlecolumn,TableColumn<MyFavoriteBean, String> likenumbercolumn,TableColumn<MyFavoriteBean, String> issuetimecolumn,TableColumn<MyFavoriteBean, String> categorycolumn,TableColumn<MyFavoriteBean, String> favoritetimecolumn) {
        // 设置列的数据
        authorcolumn.setCellValueFactory(cellData -> cellData.getValue().authorProperty());
        titlecolumn.setCellValueFactory(cellData -> cellData.getValue().titleProperty());
        likenumbercolumn.setCellValueFactory(cellData -> cellData.getValue().like_numberProperty());
        issuetimecolumn.setCellValueFactory(cellData -> cellData.getValue().issue_timeProperty());
        categorycolumn.setCellValueFactory(cellData -> cellData.getValue().category_nameProperty());
        favoritetimecolumn.setCellValueFactory(cellData -> cellData.getValue().favorite_timeProperty());
        // 将数据添加到表格控件中
        tableView.setItems(myfavoritebeanlist);
    }
}
