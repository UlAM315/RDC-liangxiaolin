package com.liangxiaolin.notes.service;

import com.liangxiaolin.notes.bean.MyFavoriteBean;
import com.liangxiaolin.notes.bean.NoteBean;
import com.liangxiaolin.notes.bean.SearchTableBean;
import com.liangxiaolin.notes.dao.SearchDao;
import com.liangxiaolin.notes.entity.MyFavorite;
import com.liangxiaolin.notes.entity.SearchTable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.util.List;

public class SearchService {

    SearchDao sd = new SearchDao();

    //封装成bean类
    public ObservableList<SearchTableBean> searchTableMessage(){
        List<SearchTable> list = sd.getSearchTableMessage();
        ObservableList<SearchTableBean> searchtablebeanlist = FXCollections.observableArrayList();
        if(list!=null){
            for (int i = 0; i < list.size(); i++) {
                SearchTable searchtable = list.get(i);
                SearchTableBean searchtablebean = new SearchTableBean(searchtable.getAuthor(),String.valueOf(searchtable.getNote_id()),searchtable.getTitle(),String.valueOf(searchtable.getLike_number()),searchtable.getIssue_time(),searchtable.getCategory_name(),searchtable.getNote_content());
                searchtablebeanlist.add(searchtablebean);
            }
            return searchtablebeanlist;
        }
        return null;
    }

    public void setMyFavoriteView(TableView tableView, ObservableList searchbeanlist, TableColumn<SearchTableBean, String> authorcolumn,TableColumn<SearchTableBean, String> noteidcolumn, TableColumn<SearchTableBean, String> titlecolumn,TableColumn<SearchTableBean, String> likenumbercolumn,TableColumn<SearchTableBean, String> issuetimecolumn,TableColumn<SearchTableBean, String> categorycolumn) {
        // 设置列的数据
        authorcolumn.setCellValueFactory(cellData -> cellData.getValue().authorProperty());
        noteidcolumn.setCellValueFactory(cellData -> cellData.getValue().user_idProperty());
        titlecolumn.setCellValueFactory(cellData -> cellData.getValue().titleProperty());
        likenumbercolumn.setCellValueFactory(cellData -> cellData.getValue().like_numberProperty());
        issuetimecolumn.setCellValueFactory(cellData -> cellData.getValue().issue_timeProperty());
        categorycolumn.setCellValueFactory(cellData -> cellData.getValue().category_nameProperty());
        // 将数据添加到表格控件中
        tableView.setItems(searchbeanlist);
    }

    public boolean clickToLike(int note_id){
        return sd.clickToLike(note_id);
    }

    public boolean addToFavorite(){
        return sd.addToFavorite();
    }
}
