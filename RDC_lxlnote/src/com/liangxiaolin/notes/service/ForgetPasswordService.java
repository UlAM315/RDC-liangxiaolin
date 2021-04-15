package com.liangxiaolin.notes.service;

import com.liangxiaolin.notes.dao.ForgetPasswordDao;

public class ForgetPasswordService {

    ForgetPasswordDao fpd = new ForgetPasswordDao();

    public boolean resetDaoPassword(String user_name,String telephone,String password){
        return fpd.resetDaoPassword(user_name,telephone,password);
    }
}
