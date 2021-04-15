package com.liangxiaolin.notes.service;

import com.liangxiaolin.notes.bean.EditorBean;
import com.liangxiaolin.notes.view.PersonalNotesEditController;
import com.liangxiaolin.notes.dao.EditorDao;
import com.liangxiaolin.notes.entity.Editor;

public class EditorService {

    EditorDao ed = new EditorDao();

    public EditorBean getNoteMessage(){
        Editor editor = ed.getNoteMessage();
        if(editor!=null){
            EditorBean editorbean = new EditorBean(PersonalNotesEditController.idString,editor.getTitle(),editor.getCategory_name(),editor.getNote_content(),editor.getIf_open());
            return editorbean;
        }
        return null;
    }

    public boolean deleteNote(){
        return ed.deleteNote();
    }

    public boolean modifyOrAddNote(String title,String note_content,String if_open,String modifyoradd){
        return ed.modifyOrAddNote(title,note_content,if_open,modifyoradd);
    }
}
