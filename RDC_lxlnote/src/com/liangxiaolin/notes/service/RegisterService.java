package com.liangxiaolin.notes.service;

import com.liangxiaolin.notes.dao.RegisterDao;
import com.liangxiaolin.notes.entity.Users;

import java.util.List;

public class RegisterService {

    RegisterDao rd = new RegisterDao();

    public boolean register(String user_name,String password,String birthday,String sex,String telephone){
        return rd.register(user_name,password,birthday,sex,telephone);
    }

    public boolean ifUserNameExist(String username){
        List<Users> list = rd.userNameList();
        //假如用户名存在，则返回true
        for (int i = 0; i < list.size(); i++) {
            if(username.equals(list.get(i).getUser_name())) return true;
        }
        return false;
    }

    public boolean ifTelephoneExist(String telephone){
        List<Users> list = rd.telephoneList();
        if(list!=null){
            //假如手机号存在，则返回true
            for (int i = 0; i < list.size(); i++) {
                if(telephone.equals(list.get(i).getTelephone())) return true;
            }
        }
        return false;
    }

}
