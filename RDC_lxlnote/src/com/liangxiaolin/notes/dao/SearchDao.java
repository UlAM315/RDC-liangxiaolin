package com.liangxiaolin.notes.dao;

import com.liangxiaolin.notes.view.LogInController;
import com.liangxiaolin.notes.view.MainPageController;
import com.liangxiaolin.notes.view.SearchController;
import com.liangxiaolin.notes.entity.SearchTable;
import com.liangxiaolin.notes.util.DateUtils;
import com.liangxiaolin.notes.util.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SearchDao {
    public List<SearchTable> getSearchTableMessage(){
        String sql = "SELECT `user_name`,`note_id`,`title`,`like_number`,`issue_time`,`if_open`,`category_name`,note_content\n" +
                "FROM `note` n,`users` u,`category` c\n" +
                "WHERE u.`user_id`=n.`user_id`  \n" +
                "AND c.`category_id`=n.`category_id` \n" +
                "AND (`user_name` LIKE \"%\"?\"%\" OR `title` LIKE \"%\"?\"%\");";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<SearchTable> list = new ArrayList<>();
        try {
            conn = JDBCUtils.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, MainPageController.searchkeywork);
            ps.setString(2, MainPageController.searchkeywork);
            rs = ps.executeQuery();
            while (rs.next()){
                //假如该文章是公开的，才能展示出来
                if(("公开").equals(rs.getString("if_open"))){
                    SearchTable searchtable = new SearchTable();
                    searchtable.setAuthor(rs.getString("user_name"));
                    searchtable.setNote_id(rs.getInt("note_id"));
                    searchtable.setTitle(rs.getString("title"));
                    searchtable.setLike_number(rs.getInt("like_number"));
                    searchtable.setIssue_time(DateUtils.getStringBirthdayTime(rs.getDate("issue_time")));
                    searchtable.setCategory_name(rs.getString("category_name"));
                    searchtable.setNote_content(rs.getString("note_content"));
                    list.add(searchtable);
                }
            }
            return list;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtils.close(conn,ps,rs);
        }
        return null;
    }

    public boolean clickToLike(int note_id){
        String sql = "UPDATE `note` SET `like_number`=`like_number`+1 WHERE `note_id`= ?;";
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = JDBCUtils.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1,note_id);
            int line = ps.executeUpdate();
            if(line==1){
                return true;
            }else return false;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtils.close(conn,ps);
        }
        return false;
    }

    public boolean addToFavorite(){
        String sql1 = "SELECT `user_id` FROM `users` WHERE `user_name`=?;";
        String sql2 = "INSERT INTO `favorite`(`user_id`,`note_id`,`favourite_time`) VALUES (?,?,STR_TO_DATE(?,'%Y-%c-%d'));";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int userid = 0;
        try {
            conn = JDBCUtils.getConnection();
            ps = conn.prepareStatement(sql1);
            ps.setString(1,LogInController.username);
            rs = ps.executeQuery();
            if (rs.next()){
                userid = rs.getInt("user_id");
            }
            if(userid!=0){
                ps = conn.prepareStatement(sql2);
                ps.setInt(1,userid);
                ps.setInt(2, SearchController.searchid);
                ps.setString(3,DateUtils.getStringNowTimeFavorite());
                int line = ps.executeUpdate();
                if(line==1){
                    return true;
                }else return false;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtils.close(conn,ps,rs);
        }
        return false;
    }
}