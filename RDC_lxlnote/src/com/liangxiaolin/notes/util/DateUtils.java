package com.liangxiaolin.notes.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

    public static final String dateformat1 = "yyyy-MM-dd HH:mm:ss";   //当前时间格式
    public static final String dateformat2 = "yyyy-MM-dd";   //生日日期格式

    /**
     * 获取当前时间（笔记发表时间），打印在页面
     * 返回字符串
     */
    public static String getStringNowTimePage(){
        DateFormat df = new SimpleDateFormat(dateformat1);
        return df.format(new Date());
    }

    /**
     * 获取当前时间（笔记收藏时间），打印在页面
     * 返回字符串
     */
    public static String getStringNowTimeFavorite(){
        DateFormat df = new SimpleDateFormat(dateformat2);
        return df.format(new Date());
    }

    /**
     * 获取当前时间（笔记发表时间），存入数据库
     * 返回java.sql.Date
     */
    public static java.sql.Date getSqlNowTimeSql(){
        DateFormat df = new SimpleDateFormat(dateformat1);
        return java.sql.Date.valueOf(df.format(new Date()));
    }

    public static String getStringIssueTime(java.sql.Timestamp issuetime){
        DateFormat df = new SimpleDateFormat(dateformat1);
        return df.format(issuetime);
    }

    public static String getStringIssueTime(java.sql.Date issuetime){
        DateFormat df = new SimpleDateFormat(dateformat1);
        return df.format(issuetime);
    }

    /**
     * 获取生日日期，存入数据库
     * 返回java.sql.Date
     * 记得按格式输入生日日期
     */
    public static java.sql.Date getSqlBirthdayTime(String birthdaytime){
        DateFormat df = new SimpleDateFormat(dateformat2);
        return java.sql.Date.valueOf(df.format(birthdaytime));
    }

    public static String getStringBirthdayTime(java.sql.Date birthdaytime){
        DateFormat df = new SimpleDateFormat(dateformat2);
        return df.format(birthdaytime);
    }

}
