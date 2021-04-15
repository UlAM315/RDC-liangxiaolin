package com.liangxiaolin.notes.entity;

public class Note {
    private int note_id;
    private int user_id;  //笔记的作者是谁
    private int category_id;  //笔记所属分类
    private String title;  //笔记的标题
    private int like_number;  //笔记的点赞数，默认为0
    private String issue_time;  //笔记的发表时间
    private String if_open;  //是否为公开笔记，默认为公开
    private String note_content;  //笔记内容

    public Note() {
    }

    public Note(int note_id, int user_id, int category_id, String title, int like_number, String issue_time, String if_open, String note_content) {
        this.note_id = note_id;
        this.user_id = user_id;
        this.category_id = category_id;
        this.title = title;
        this.like_number = like_number;
        this.issue_time = issue_time;
        this.if_open = if_open;
        this.note_content = note_content;
    }

    public int getNote_id() {
        return note_id;
    }

    public void setNote_id(int note_id) {
        this.note_id = note_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
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

    public String getIf_open() {
        return if_open;
    }

    public void setIf_open(String if_open) {
        this.if_open = if_open;
    }

    public String getNote_content() {
        return note_content;
    }

    public void setNote_content(String note_content) {
        this.note_content = note_content;
    }

    @Override
    public String toString() {
        return "Note{" +
                "note_id=" + note_id +
                ", user_id=" + user_id +
                ", category_id=" + category_id +
                ", title='" + title + '\'' +
                ", like_number=" + like_number +
                ", issue_time='" + issue_time + '\'' +
                ", if_open='" + if_open + '\'' +
                ", note_content='" + note_content + '\'' +
                '}';
    }
}