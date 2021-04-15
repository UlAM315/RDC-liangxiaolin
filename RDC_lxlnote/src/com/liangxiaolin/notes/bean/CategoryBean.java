package com.liangxiaolin.notes.bean;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.SimpleStringProperty;

public class CategoryBean {
    private SimpleStringProperty category_id;
    private SimpleStringProperty category_name;

    public CategoryBean() {
    }

    public CategoryBean(String category_id, String category_name) {
        this.category_id = new SimpleStringProperty(category_id);
        this.category_name = new SimpleStringProperty(category_name);
    }

    public String getCategory_id() {
        return category_id.get();
    }

    public SimpleStringProperty category_idProperty() {
        return category_id;
    }

    public void setCategory_id(String category_id) {
        this.category_id.set(category_id);
    }

    public String getCategory_name() {
        return category_name.get();
    }

    public SimpleStringProperty category_nameProperty() {
        return category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name.set(category_name);
    }
}
