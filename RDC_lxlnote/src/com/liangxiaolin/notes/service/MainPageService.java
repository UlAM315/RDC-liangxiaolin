package com.liangxiaolin.notes.service;

import com.liangxiaolin.notes.bean.NoteBean;
import com.liangxiaolin.notes.bean.UsersBean;
import com.liangxiaolin.notes.dao.MainPageDao;
import com.liangxiaolin.notes.entity.Note;
import com.liangxiaolin.notes.entity.Users;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.util.List;

public class MainPageService {

    MainPageDao mpd = new MainPageDao();

    /**
     * 参数为登录时用户的用户名
     * @param username
     * @return
     */
    public UsersBean getPersonalMessage(String username){
        Users user = mpd.getPersonalMessage(username);
        if(user.getUser_name()!= null && user.getBirthday()!=null && user.getSex()!=null && user.getTelephone()!=null){
            UsersBean userbean = new UsersBean("",user.getUser_name(),"",user.getBirthday(),user.getSex(),user.getTelephone());
            return userbean;
        }
        return null;
    }

    public boolean modifyPersonalMessage(String user_name,String birthday,String sex,String telephone){
        return mpd.modifyPersonalMessage(user_name,birthday,sex,telephone);
    }

    /**
     * 将note的数据封装到bean类上
     * @return bean类的集合
     */
    public ObservableList<NoteBean> getNotesMessage(){
        List<Note> list = mpd.getNotesMessage();
        ObservableList<NoteBean> notebeanlist = FXCollections.observableArrayList();
        if(list!=null){
            for (int i = 0; i < list.size(); i++) {
                Note note = list.get(i);
                NoteBean notebean = new NoteBean(String.valueOf(note.getNote_id()),"","",note.getTitle(),"",note.getIssue_time(),note.getIf_open(),"");
                notebeanlist.add(notebean);
            }
            return notebeanlist;
        }
        return null;
    }

    public void setNotesView(TableView tableView, ObservableList notebeanlist, TableColumn<NoteBean, String> noteidcolumn, TableColumn<NoteBean, String> titlecolumn, TableColumn<NoteBean, String> issuetimecolumn,TableColumn<NoteBean, String> ifopencolumn) {
        // 设置id列的数据
        noteidcolumn.setCellValueFactory(cellData -> cellData.getValue().note_idProperty());
        // 设置标题的数据
        titlecolumn.setCellValueFactory(cellData -> cellData.getValue().titleProperty());
        // 设置发布时间的数据
        issuetimecolumn.setCellValueFactory(cellData -> cellData.getValue().issue_timeProperty());
        // 设置是否公开的数据
        ifopencolumn.setCellValueFactory(cellData -> cellData.getValue().if_openProperty());
        // 将数据添加到表格控件中
        tableView.setItems(notebeanlist);
    }

}
