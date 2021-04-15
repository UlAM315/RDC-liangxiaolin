package com.liangxiaolin.notes.dao;

import com.liangxiaolin.notes.entity.Users;
import com.liangxiaolin.notes.util.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RegisterDao {
    public boolean register(String user_name,String password,String birthday,String sex,String telephone){
        String sql = "INSERT INTO users(`user_name`,`password`,`birthday`,`sex`,`telephone`) VALUES (?,?,STR_TO_DATE(?,'%Y-%c-%d'),?,?);";
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = JDBCUtils.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1,user_name);
            ps.setString(2,password);
            ps.setString(3,birthday);
            ps.setString(4,sex);
            ps.setString(5,telephone);
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

    public List<Users> userNameList(){
        String sql = "SELECT user_name FROM users;";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Users> list = new ArrayList<>();
        try {
            conn = JDBCUtils.getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                Users users = new Users();
                users.setUser_name(rs.getString("user_name"));
                list.add(users);
            }
            return list;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtils.close(conn,ps,rs);
        }
        return null;
    }

    public List<Users> telephoneList(){
        String sql = "SELECT telephone FROM users;";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Users> list = new ArrayList<>();
        try {
            conn = JDBCUtils.getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                Users users = new Users();
                users.setTelephone(rs.getString("telephone"));
                list.add(users);
            }
            return list;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtils.close(conn,ps,rs);
        }
        return null;
    }
}
