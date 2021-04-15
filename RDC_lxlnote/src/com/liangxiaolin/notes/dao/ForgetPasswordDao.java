package com.liangxiaolin.notes.dao;

import com.liangxiaolin.notes.util.JDBCUtils;
import com.liangxiaolin.notes.util.ReflectUtils;

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
        return ReflectUtils.update(sql,password,user_name,telephone);
    }
}
