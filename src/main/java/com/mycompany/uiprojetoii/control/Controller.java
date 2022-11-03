package com.mycompany.uiprojetoii.control;

import com.mycompany.uiprojetoii.model.FactoryDAO;
import com.mycompany.uiprojetoii.model.FileTransform;
import com.mycompany.uiprojetoii.model.Text;
import com.mycompany.uiprojetoii.model.TextDAO;
import com.mycompany.uiprojetoii.model.LocalConnDAO;
import java.sql.Connection;


/**
 * Controller class - makes connection between Model classes and View
 * @author Iara
 */
public class Controller {
    
    /**
     * This creates a String that is the name of the file, using the groupId and the type of db (Local or Server).
     * @param id
     * @param typeOfDB
     * @return 
     */
    public static String CreateFileName(int id, String typeOfDB){
        return "textoG" + String.valueOf(id) + typeOfDB;
    }
    
    public static Boolean getLocalData(String user, String password, int id){
        LocalConnDAO db = (LocalConnDAO) FactoryDAO.getDAO(true, user, password);
        
        Boolean status = db.getConnection() != null;
        
        FileTransform.createTxt(db.retrieveData(id), CreateFileName(id,"Local"));
        
        db.endConnection();
        
        return status;
    }
    
    public static Boolean getGroupText(String user, String password, int id){
        TextDAO db = (TextDAO) FactoryDAO.getDAO(false, user, password);
        
        Boolean status = db.getConnection() != null;
        
        FileTransform.createTxt(db.retrieve(id).getContent(), CreateFileName(id,"Remote"));
        
        db.endConnection();
        
        return status;
    }
    
    public static Boolean getAllTexts(String user, String password, int groupQty){
        TextDAO db = (TextDAO) FactoryDAO.getDAO(false, user, password);
        
        Boolean status = db.getConnection() != null;
        
        // Vai dar errado, rever
        FileTransform.createTxt(db.retrieveAll(groupQty).toString(), CreateFileName(0,"Remote"));
        
        db.endConnection();
        
        return status;
    }
    
    public static void downloadPdf(String user, String password, int groupQty){
        TextDAO db = (TextDAO) FactoryDAO.getDAO(false, user, password);
        
        FileTransform.createPdf(db.retrieveAll(groupQty));
        
        db.endConnection();
    }
    
}
