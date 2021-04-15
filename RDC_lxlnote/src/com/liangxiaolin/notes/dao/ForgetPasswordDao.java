package com.liangxiaolin.notes.dao;

import com.liangxiaolin.notes.util.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ForgetPasswordDao {
    /**
     * 重设该用户的密码
     */
    public boolean resetDaoPassword(String user_name,String telephone,String password){
        String sql = "UPDATE users SET PASSWORD = ? WHERE user_name = ? AND telephone = ?;";
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = JDBCUtils.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1,password);
            ps.setString(2,user_name);
            ps.setString(3,telephone);
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
}
