package com.liangxiaolin.notes.dao;

import com.liangxiaolin.notes.util.ReflectUtils;
import com.liangxiaolin.notes.view.LogInController;
import com.liangxiaolin.notes.view.PersonalNotesEditController;
import com.liangxiaolin.notes.entity.Editor;
import com.liangxiaolin.notes.util.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class EditorDao {
    public Editor getNoteMessage(){
        String sql = "SELECT `title`,`category_name`,`note_content`,`if_open`\n" +
                "FROM `note` n,`category` c\n" +
                "WHERE `note_id`=? AND n.`category_id`=c.`category_id`;";
        List<Editor> editor = ReflectUtils.query(Editor.class,sql,PersonalNotesEditController.id);
        return editor.get(0);
    }

    public boolean deleteNote(){
        String sql = "DELETE FROM `note` WHERE `note_id`= ?;";
        return ReflectUtils.update(sql,PersonalNotesEditController.id);
    }

    public boolean modifyOrAddNote(String title,String note_content,String if_open,String modifyoradd){
        //sql0、1、2必须执行
        String sql0 = "SELECT `category_name` FROM `category`;";
        String sql1 = "INSERT INTO `category`(`category_name`) VALUES(?);";
        String sql2 = "SELECT `category_id` FROM `category` WHERE `category_name` = ?;";
        //若为modify则执行sql3
        String sql3 = "UPDATE `note` SET `title`=?,`category_id`=?,`note_content`=?,`if_open`=? WHERE `note_id`=?;";
        //若为add则执行sql4、5
        String sql4 = "SELECT `user_id` FROM `users` WHERE `user_name`=?;";
        String sql5 = "INSERT INTO note(`title`,`user_id`,`category_id`,`issue_time`,note_content,if_open) VALUES(?,?,?,NOW(),?,?);";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        boolean categoryexist = false;
        int categoryid = 0;
        int userid = 0;
        try {
            conn = JDBCUtils.getConnection();
            //找出所有分类
            ps = conn.prepareStatement(sql0);
            rs = ps.executeQuery();
            while (rs.next()){
                //假如分类已经存在
                if(rs.getString("category_name" ).equals(PersonalNotesEditController.getcategory)) categoryexist = true;
            }
            //若无此分类，则插入新分类
            if(categoryexist == false){
                ps = conn.prepareStatement(sql1);
                ps.setString(1,PersonalNotesEditController.getcategory);
                ps.executeUpdate();
            }
            //找出此分类的categoryid
            ps = conn.prepareStatement(sql2);
            ps.setString(1,PersonalNotesEditController.getcategory);
            rs = ps.executeQuery();
            if(rs.next()){
                categoryid = rs.getInt("category_id");
            }
            if("modify".equals(modifyoradd)){
                //修改数据
                ps = conn.prepareStatement(sql3);
                ps.setString(1,title);
                ps.setInt(2,categoryid);
                ps.setString(3,note_content);
                ps.setString(4,if_open);
                ps.setInt(5,PersonalNotesEditController.id);
                ps.executeUpdate();
                int line = ps.executeUpdate();
                if(line==1){
                    return true;
                }else{
                    return false;
                }
            }
            if("add".equals(modifyoradd)){
                //添加数据
                ps = conn.prepareStatement(sql4);
                ps.setString(1, LogInController.username);
                rs = ps.executeQuery();
                if (rs.next()){
                    userid = rs.getInt("user_id");
                }
                ps = conn.prepareStatement(sql5);
                ps.setString(1,title);
                ps.setInt(2,userid);
                ps.setInt(3,categoryid);
                ps.setString(4,note_content);
                ps.setString(5,if_open);
                ps.executeUpdate();
                int line = ps.executeUpdate();
                if(line==1){
                    return true;
                }else {
                    return false;
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtils.close(conn,ps,rs);
        }
        return false;
    }
}
