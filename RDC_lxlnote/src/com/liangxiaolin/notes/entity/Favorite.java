package com.liangxiaolin.notes.entity;

public class Favorite {
    private int user_id;  //谁的收藏夹
    private int note_id;  //被收藏的笔记
    private String favorite_time;  //收藏日期

    public Favorite() {
    }

    public Favorite(int user_id, int note_id, String favorite_time) {
        this.user_id = user_id;
        this.note_id = note_id;
        this.favorite_time = favorite_time;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getNote_id() {
        return note_id;
    }

    public void setNote_id(int note_id) {
        this.note_id = note_id;
    }

    public String getFavorite_time() {
        return favorite_time;
    }

    public void setFavorite_time(String favorite_time) {
        this.favorite_time = favorite_time;
    }
}
