package com.liangxiaolin.notes.dao;

import com.liangxiaolin.notes.util.ReflectUtils;
import com.liangxiaolin.notes.view.LogInController;
import com.liangxiaolin.notes.entity.Note;
import com.liangxiaolin.notes.entity.Users;
import com.liangxiaolin.notes.util.DateUtils;
import com.liangxiaolin.notes.util.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MainPageDao {
    /**
     * 获取登录用户的个人信息
     * 返回一个entity对象
     */
    public Users getPersonalMessage(String username){
        String sql = "SELECT user_name,birthday,sex,telephone FROM users WHERE user_name = ?;";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Users user = new Users();
        try {
            conn = JDBCUtils.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1,username);
            rs = ps.executeQuery();
            if (rs.next()){
                user.setUser_name(rs.getString("user_name"));
                user.setBirthday(DateUtils.getStringBirthdayTime(rs.getDate("birthday")));
                user.setSex(rs.getString("sex"));
                user.setTelephone(rs.getString("telephone"));
            }
            return user;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtils.close(conn,ps,rs);
        }
        return null;
    }

    /**
     *
     * @param newuser_name
     * @param birthday
     * @param sex
     * @param telephone
     * @return
     */
    public boolean modifyPersonalMessage(String newuser_name,String birthday,String sex,String telephone){
        String sql = "UPDATE users SET `user_name`=?,`birthday`=STR_TO_DATE(?,'%Y-%c-%d'),`sex`=?,`telephone`=? WHERE `user_name`=?;";
        return ReflectUtils.update(sql,newuser_name,birthday,sex,telephone,LogInController.username);
    }

    public List<Note> getNotesMessage(){
        String sql = "SELECT `note_id`,`title`,`issue_time`,`if_open` FROM `note` n,`users` u WHERE n.`user_id`=u.`user_id` AND `user_name`=?;";
        return ReflectUtils.query(Note.class,sql,LogInController.username);
    }
    }

