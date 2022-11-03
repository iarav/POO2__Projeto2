package com.mycompany.uiprojetoii.control;

import com.mycompany.uiprojetoii.model.FactoryDAO;
import com.mycompany.uiprojetoii.model.FileTransform;
import com.mycompany.uiprojetoii.model.TextDAO;
import com.mycompany.uiprojetoii.model.LocalConnDAO;


/**
 * Controller class - makes connection between Model classes and View
 * @author Iara
 * @author Yuri
 */
public class Controller {
    
    /**
     * Creates a String that is the name of the file, using the groupId and the type of db (Local or Server).
     * @param id
     * @param typeOfDB
     * @return file name
     */
    public static String CreateFileName(int id, String typeOfDB){
        return "textoG" + String.valueOf(id) + typeOfDB;
    }
    
    /**
     * Gets the data form the test local database.
     * @param user localhost username
     * @param password localhost password
     * @param id group id
     * @return status of connection
     */
    public static Boolean getLocalData(String user, String password, int id){
        LocalConnDAO db = (LocalConnDAO) FactoryDAO.getDAO(true, user, password);
        
        Boolean status = db.getConnection() != null;
        
        FileTransform.createTxt(db.retrieveData(id), CreateFileName(id,"Local"));
        
        db.endConnection();
        
        return status;
    }
    
    /**
     * Gets the text from a specific group id.
     * @param user
     * @param password
     * @param id group id
     * @return status of connection
     */
    public static Boolean getGroupText(String user, String password, int id){
        TextDAO db = (TextDAO) FactoryDAO.getDAO(false, user, password);
        
        Boolean status = db.getConnection() != null;
        
        FileTransform.createTxt(db.retrieve(id).getContent(), CreateFileName(id,"Server"));
        
        db.endConnection();
        
        return status;
    }
    
    /**
     * Creates a PDF file containing all the texts in the database.
     * @param user
     * @param password
     * @param groupQty amount of groups
     */
    public static void downloadPdf(String user, String password, int groupQty){
        TextDAO db = (TextDAO) FactoryDAO.getDAO(false, user, password);
        
        FileTransform.createPdf(db.retrieveAll(groupQty));
        
        db.endConnection();
    }
    
}
