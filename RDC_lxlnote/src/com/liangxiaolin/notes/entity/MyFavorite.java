package com.liangxiaolin.notes.entity;

public class MyFavorite {
    private String user_name;  //笔记作者
    private String title;  //笔记的标题
    private int like_number;  //笔记的点赞数，默认为0
    private String issue_time;  //笔记的发表时间
    private String category_name;  //分类名
    private String favorite_time;  //收藏日期

    public MyFavorite() {
    }

    public MyFavorite(String user_name, String title, int like_number, String issue_time, String category_name, String favorite_time) {
        this.user_name = user_name;
        this.title = title;
        this.like_number = like_number;
        this.issue_time = issue_time;
        this.category_name = category_name;
        this.favorite_time = favorite_time;
    }

    public String getuser_name() {
        return user_name;
    }

    public void setuser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getLike_number() {
        return like_number;
    }

    public void setLike_number(int like_number) {
        this.like_number = like_number;
    }

    public String getIssue_time() {
        return issue_time;
    }

    public void setIssue_time(String issue_time) {
        this.issue_time = issue_time;
    }

    public String getCategory_name() {
        return category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }

    public String getFavorite_time() {
        return favorite_time;
    }

    public void setFavorite_time(String favorite_time) {
        this.favorite_time = favorite_time;
    }

    @Override
    public String toString() {
        return "MyFavorite{" +
                "user_name='" + user_name + '\'' +
                ", title='" + title + '\'' +
                ", like_number=" + like_number +
                ", issue_time='" + issue_time + '\'' +
                ", category_name='" + category_name + '\'' +
                ", favorite_time='" + favorite_time + '\'' +
                '}';
    }
}