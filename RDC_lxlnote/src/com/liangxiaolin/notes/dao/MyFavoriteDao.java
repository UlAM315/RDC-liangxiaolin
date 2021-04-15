package com.liangxiaolin.notes.dao;

import com.liangxiaolin.notes.util.ReflectUtils;
import com.liangxiaolin.notes.view.LogInController;
import com.liangxiaolin.notes.entity.MyFavorite;
import com.liangxiaolin.notes.util.DateUtils;
import com.liangxiaolin.notes.util.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MyFavoriteDao {
    public List<MyFavorite> getMyFavoriteMessage(){
        String sql = "SELECT `user_name`,`title`,`like_number`,`issue_time`,`category_name`,`favourite_time`\n" +
                "FROM `note` n,`users` u,`category` c,`favorite` f\n" +
                "WHERE u.`user_id`=n.`user_id`  \n" +
                "AND c.`category_id`=n.`category_id` \n" +
                "AND f.`note_id`=n.`note_id`\n" +
                "AND (\n" +
                "\tSELECT `user_id`\n" +
                "\tFROM `users`\n" +
                "\tWHERE `user_name`=?\n" +
                ")=f.`user_id`;";
        //return ReflectUtils.query(MyFavorite.class,sql,LogInController.username);
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<MyFavorite> list = new ArrayList<>();
        try {
            conn = JDBCUtils.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, LogInController.username);
            rs = ps.executeQuery();
            while (rs.next()){
                MyFavorite myfavorite = new MyFavorite();
                myfavorite.setuser_name(rs.getString("user_name"));
                myfavorite.setTitle(rs.getString("title"));
                myfavorite.setLike_number(rs.getInt("like_number"));
                myfavorite.setIssue_time(DateUtils.getStringBirthdayTime(rs.getDate("issue_time")));
                myfavorite.setCategory_name(rs.getString("category_name"));
                myfavorite.setFavorite_time(DateUtils.getStringIssueTime(rs.getDate("favourite_time")));
                list.add(myfavorite);
            }
            return list;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtils.close(conn,ps,rs);
        }
        System.out.println("111");
        return null;
    }
}
