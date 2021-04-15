package com.liangxiaolin.notes.entity;

public class SearchTable {
    private String user_name;  //笔记作者
    private int note_id;
    private String title;  //笔记的标题
    private int like_number;  //笔记的点赞数，默认为0
    private String issue_time;  //笔记的发表时间
    private String category_name;  //分类名
    private String note_content;

    public SearchTable() {
    }

    @Override
    public String toString() {
        return "SearchTable{" +
                "user_name='" + user_name + '\'' +
                ", note_id=" + note_id +
                ", title='" + title + '\'' +
                ", like_number=" + like_number +
                ", issue_time='" + issue_time + '\'' +
                ", category_name='" + category_name + '\'' +
                ", note_content='" + note_content + '\'' +
                '}';
    }

    public String getNote_content() {
        return note_content;
    }

    public void setNote_content(String note_content) {
        this.note_content = note_content;
    }

    public SearchTable(String user_name, int note_id, String title, int like_number, String issue_time, String category_name, String note_content) {
        this.user_name = user_name;
        this.note_id = note_id;
        this.title = title;
        this.like_number = like_number;
        this.issue_time = issue_time;
        this.category_name = category_name;
        this.note_content = note_content;
    }

    public String getuser_name() {
        return user_name;
    }

    public void setuser_name(String user_name) {
        this.user_name = user_name;
    }

    public int getNote_id() {
        return note_id;
    }

    public void setNote_id(int note_id) {
        this.note_id = note_id;
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
}
