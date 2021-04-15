package com.liangxiaolin.notes.entity;

public class Editor {
    private int note_id;
    private String title;  //笔记的标题
    private String category_name;  //分类名
    private String note_content;  //笔记内容
    private String if_open;  //是否为公开笔记，默认为公开

    public Editor() {
    }

    public Editor(int note_id, String title, String category_name, String note_content, String if_open) {
        this.note_id = note_id;
        this.title = title;
        this.category_name = category_name;
        this.note_content = note_content;
        this.if_open = if_open;
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

    public String getCategory_name() {
        return category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }

    public String getNote_content() {
        return note_content;
    }

    public void setNote_content(String note_content) {
        this.note_content = note_content;
    }

    public String getIf_open() {
        return if_open;
    }

    public void setIf_open(String if_open) {
        this.if_open = if_open;
    }

    @Override
    public String toString() {
        return "Editor{" +
                "note_id=" + note_id +
                ", title='" + title + '\'' +
                ", category_name='" + category_name + '\'' +
                ", note_content='" + note_content + '\'' +
                ", if_open='" + if_open + '\'' +
                '}';
    }
}
