package com.liangxiaolin.notes.bean;

import javafx.beans.property.SimpleStringProperty;

public class MyFavoriteBean {
    private SimpleStringProperty author;
    private SimpleStringProperty title;
    private SimpleStringProperty like_number;
    private SimpleStringProperty issue_time;
    private SimpleStringProperty category_name;
    private SimpleStringProperty favorite_time;

    public MyFavoriteBean() {
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

    public MyFavoriteBean(String author, String title, String like_number, String issue_time, String category_name, String favorite_time) {
        this.author = new SimpleStringProperty(author);
        this.title = new SimpleStringProperty(title);
        this.like_number = new SimpleStringProperty(like_number);
        this.issue_time = new SimpleStringProperty(issue_time);
        this.category_name = new SimpleStringProperty(category_name);
        this.favorite_time = new SimpleStringProperty(favorite_time);
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

    public String getFavorite_time() {
        return favorite_time.get();
    }

    public SimpleStringProperty favorite_timeProperty() {
        return favorite_time;
    }

    public void setFavorite_time(String favorite_time) {
        this.favorite_time.set(favorite_time);
    }
}
