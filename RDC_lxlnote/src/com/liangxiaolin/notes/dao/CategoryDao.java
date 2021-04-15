package com.liangxiaolin.notes.dao;

import com.liangxiaolin.notes.entity.Category;
import com.liangxiaolin.notes.util.JDBCUtils;
import com.liangxiaolin.notes.util.ReflectUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryDao {
    public List<Category> getCategoryMessage(){
        String sql = "SELECT `category_id`,`category_name` FROM `category`;";
        return ReflectUtils.query(Category.class,sql,null);
    }
}
