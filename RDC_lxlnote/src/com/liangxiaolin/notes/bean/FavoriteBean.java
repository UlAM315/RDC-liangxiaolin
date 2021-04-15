package com.liangxiaolin.notes.bean;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.SimpleStringProperty;

public class FavoriteBean {
    private SimpleStringProperty user_id;
    private SimpleStringProperty note_id;
    private SimpleStringProperty favorite_time;

    public FavoriteBean() {
    }

    public FavoriteBean(String user_id, String note_id, String favorite_time) {
        this.user_id = new SimpleStringProperty(user_id);
        this.note_id = new SimpleStringProperty(note_id);
        this.favorite_time = new SimpleStringProperty(favorite_time);
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

    public String getNote_id() {
        return note_id.get();
    }

    public SimpleStringProperty note_idProperty() {
        return note_id;
    }

    public void setNote_id(String note_id) {
        this.note_id.set(note_id);
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
