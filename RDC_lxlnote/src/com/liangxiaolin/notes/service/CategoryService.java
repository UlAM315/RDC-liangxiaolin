package com.liangxiaolin.notes.service;

import com.liangxiaolin.notes.bean.CategoryBean;
import com.liangxiaolin.notes.bean.NoteBean;
import com.liangxiaolin.notes.dao.CategoryDao;
import com.liangxiaolin.notes.entity.Category;
import com.liangxiaolin.notes.entity.Note;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.util.List;

public class CategoryService {

    CategoryDao cd = new CategoryDao();

    public ObservableList<CategoryBean> getCategoryMessage(){
        List<Category> list = cd.getCategoryMessage();
        ObservableList<CategoryBean> categorybeanlist = FXCollections.observableArrayList();
        for (int i = 0; i < list.size(); i++) {
            Category category = list.get(i);
            CategoryBean categoryBean = new CategoryBean(String.valueOf(category.getCategory_id()),category.getCategory_name());
            categorybeanlist.add(categoryBean);
        }
        return categorybeanlist;
    }

    public void setCategoryView(TableView tableView, ObservableList categorybeanlist, TableColumn<CategoryBean, String> categoryidcolumn, TableColumn<CategoryBean, String> notecategorycolumn) {
        // 设置id列的数据
        categoryidcolumn.setCellValueFactory(cellData -> cellData.getValue().category_idProperty());
        // 设置分类名称的数据
        notecategorycolumn.setCellValueFactory(cellData -> cellData.getValue().category_nameProperty());
        // 将数据添加到表格控件中
        tableView.setItems(categorybeanlist);
    }
}
