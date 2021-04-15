package com.liangxiaolin.notes.bean;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.SimpleStringProperty;

public class NoteBean {
    private SimpleStringProperty note_id;
    private SimpleStringProperty user_id;
    private SimpleStringProperty category_id;
    private SimpleStringProperty title;
    private SimpleStringProperty like_number;
    private SimpleStringProperty issue_time;
    private SimpleStringProperty if_open;
    private SimpleStringProperty note_content;

    public NoteBean() {
    }

    public NoteBean(String note_id, String user_id, String category_id, String title, String like_number, String issue_time, String if_open, String note_content) {
        this.note_id = new SimpleStringProperty(note_id);
        this.user_id = new SimpleStringProperty(user_id);
        this.category_id = new SimpleStringProperty(category_id);
        this.title = new SimpleStringProperty(title);
        this.like_number = new SimpleStringProperty(like_number);
        this.issue_time = new SimpleStringProperty(issue_time);
        this.if_open = new SimpleStringProperty(if_open);
        this.note_content = new SimpleStringProperty(note_content);
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

    public String getUser_id() {
        return user_id.get();
    }

    public SimpleStringProperty user_idProperty() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id.set(user_id);
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

    public String getTitle() {
        return title.get();
    }

    public SimpleStringProperty titleProperty() {
        return title;
    }

    public void setTitle(String title) {
        this.title.set(title);
    }

    public String getLike_number() {
        return like_number.get();
    }

    public SimpleStringProperty like_numberProperty() {
        return like_number;
    }

    public void setLike_number(String like_number) {
        this.like_number.set(like_number);
    }

    public String getIssue_time() {
        return issue_time.get();
    }

    public SimpleStringProperty issue_timeProperty() {
        return issue_time;
    }

    public void setIssue_time(String issue_time) {
        this.issue_time.set(issue_time);
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

    public String getNote_content() {
        return note_content.get();
    }

    public SimpleStringProperty note_contentProperty() {
        return note_content;
    }

    public void setNote_content(String note_content) {
        this.note_content.set(note_content);
    }
}
