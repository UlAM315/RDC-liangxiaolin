package com.liangxiaolin.notes.dao;

import com.liangxiaolin.notes.entity.Users;
import com.liangxiaolin.notes.util.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LogInDao {

    /**
     * 返回该用户的密码
     */
    public String getDaoPassword(String user_name,String table){
        String sql1 = "SELECT PASSWORD FROM users WHERE user_name = ?;";
        String sql2 = "SELECT `PASSWORD` FROM `manager` WHERE `manager_name` = ?;";
        String daopassword = null;
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = JDBCUtils.getConnection();
            if("users".equals(table)){
                ps = conn.prepareStatement(sql1);
                ps.setString(1,user_name);
                rs = ps.executeQuery();
                if(rs.next()){
                    daopassword = rs.getString("PASSWORD");
                }
                return daopassword;
            }
            if("manager".equals(table)){
                ps = conn.prepareStatement(sql2);
                ps.setString(1,user_name);
                rs = ps.executeQuery();
                if(rs.next()){
                    daopassword = rs.getString("PASSWORD");
                }
                return daopassword;
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtils.close(conn,ps,rs);
        }
        return null;
    }

    public List<Users> getUsersMessage(){
        String sql = "SELECT * FROM users;";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Users> list = new ArrayList<>();
        try {
            conn = JDBCUtils.getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                Users user = new Users();
                user.setUser_id(rs.getInt(1));
                user.setUser_name(rs.getString(2));
                user.setPassword(rs.getString(3));
                user.setBirthday(rs.getString(4));
                user.setSex(rs.getString(5));
                user.setTelephone(rs.getString(6));
                list.add(user);
                }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(conn,ps,rs);
        }
        return null;
    }
}
