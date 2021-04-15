package com.liangxiaolin.notes.dao;

import com.liangxiaolin.notes.entity.Users;
import com.liangxiaolin.notes.util.JDBCUtils;
import com.liangxiaolin.notes.util.ReflectUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RegisterDao {
    public boolean register(String user_name, String password, String birthday, String sex, String telephone) {
        String sql = "INSERT INTO users(`user_name`,`password`,`birthday`,`sex`,`telephone`) VALUES (?,?,STR_TO_DATE(?,'%Y-%c-%d'),?,?);";
        return ReflectUtils.update(sql, user_name, password, birthday, sex, telephone);
    }

    public List<Users> userNameList() {
        String sql = "SELECT user_name FROM users;";
        return ReflectUtils.query(Users.class, sql, null);
    }

    public List<Users> telephoneList() {
        String sql = "SELECT telephone FROM users;";
        return ReflectUtils.query(Users.class, sql, null);
    }
}
