package com.liangxiaolin.notes.bean;

import javafx.beans.property.SimpleStringProperty;

public class SearchTableBean {
    private SimpleStringProperty author;
    private SimpleStringProperty note_id;
    private SimpleStringProperty title;
    private SimpleStringProperty like_number;
    private SimpleStringProperty issue_time;
    private SimpleStringProperty category_name;
    private SimpleStringProperty note_content;

    public SearchTableBean() {
    }

    public SearchTableBean(String author, String note_id, String title, String like_number, String issue_time, String category_name, String note_content) {
        this.author = new SimpleStringProperty(author);
        this.note_id = new SimpleStringProperty(note_id);
        this.title = new SimpleStringProperty(title);
        this.like_number = new SimpleStringProperty(like_number);
        this.issue_time = new SimpleStringProperty(issue_time);
        this.category_name = new SimpleStringProperty(category_name);
        this.note_content = new SimpleStringProperty(note_content);
    }

    public String getAuthor() {
        return author.get();
    }

    public SimpleStringProperty authorProperty() {
        return author;
    }

    public void setAuthor(String author) {
        this.author.set(author);
    }

    public String getNote_id() {
        return note_id.get();
    }

    public SimpleStringProperty user_idProperty() {
        return note_id;
    }

    public void setNote_id(String user_id) {
        this.note_id.set(user_id);
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
}
