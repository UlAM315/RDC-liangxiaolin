package com.liangxiaolin.notes.bean;

import javafx.beans.property.SimpleStringProperty;

public class EditorBean {
    private SimpleStringProperty note_id;
    private SimpleStringProperty title;
    private SimpleStringProperty category_name;
    private SimpleStringProperty note_content;
    private SimpleStringProperty if_open;

    public EditorBean() {
    }

    public EditorBean(String note_id, String title, String category_name, String note_content, String if_open) {
        this.note_id = new SimpleStringProperty(note_id);
        this.title = new SimpleStringProperty(title);
        this.category_name = new SimpleStringProperty(category_name);
        this.note_content = new SimpleStringProperty(note_content);
        this.if_open = new SimpleStringProperty(if_open);
    }

    public String getNote_id() {
        return note_id.get();
    }

    public SimpleStringProperty note_idProperty() {
        return note_id;
    }

    public void setNote_id(String note_id) {
        this.note_id.set(note_id);
    }

    public String getTitle() {
        return title.get();
    }

    public SimpleStringProperty titleProperty() {
        return title;
    }

    public void setTitle(String title) {
        this.title.set(title);
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

    public String getNote_content() {
        return note_content.get();
    }

    public SimpleStringProperty note_contentProperty() {
        return note_content;
    }

    public void setNote_content(String note_content) {
        this.note_content.set(note_content);
    }

    public String getIf_open() {
        return if_open.get();
    }

    public SimpleStringProperty if_openProperty() {
        return if_open;
    }

    public void setIf_open(String if_open) {
        this.if_open.set(if_open);
    }
}
