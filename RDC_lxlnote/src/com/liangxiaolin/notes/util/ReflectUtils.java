package com.liangxiaolin.notes.util;

import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ReflectUtils {

    public static boolean update(String sql, Object... objs) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = JDBCUtils.getConnection();
            ps = conn.prepareStatement(sql);
            for (int i = 0; i < objs.length; i++) {
                ps.setObject(i + 1, objs[i]);
            }
            int line = ps.executeUpdate();
            if(line==1){
                return true;
            }else return false;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(conn, ps);
        }
        return false;
    }

    //返回对象的集合
    public static <T> List<T> query(Class<T> clazz, String sql, Object... objs) {

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<T> list = null;
        try {
            conn = JDBCUtils.getConnection();
            ps = conn.prepareStatement(sql);
            //赋予参数
            if(objs!=null){
                for (int i = 0; i < objs.length; i++) {
                    ps.setObject(i + 1, objs[i]);
                }
            }
            rs = ps.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            //记录一共有多少列
            int ccount = rsmd.getColumnCount();
            list = new ArrayList<T>();
            while (rs.next()) {
                T t = clazz.newInstance();
                for (int i = 0; i < ccount; i++) {
                    //同一行中
                    //每一列的标题
                    String columnLabel = rsmd.getColumnLabel(i + 1);
                    //每一列的值
                    Object columnValue = rs.getObject(i + 1);
                    //System.out.println(getType(columnValue));
                    if("class java.sql.Timestamp".equals(getType(columnValue))){
                        columnValue = DateUtils.getStringIssueTime((java.sql.Timestamp) columnValue);
                    }
                    //使用反射获取每一列的值
                    Field field = clazz.getDeclaredField(columnLabel);
                    field.setAccessible(true);
                    field.set(t, columnValue);
                }
                list.add(t);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(conn, ps, rs);
        }
        return list;
    }


    public static String getType(Object o){
        return o.getClass().toString();
    }

}
