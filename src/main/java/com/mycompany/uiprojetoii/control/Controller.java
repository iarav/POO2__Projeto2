package com.mycompany.uiprojetoii.control;

import com.mycompany.uiprojetoii.model.DAO;
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
        
        Boolean status = LocalConnDAO.getConnection() != null;
        
        FileTransform.createTxt(db.retrieveData(id), CreateFileName(id,"Local"));
        
        return status;
    }
    
    /**
     * gets the connection status from the DB
     * @return status of connection
     */
    public static Boolean verifyStatus(){
        
        Boolean status = DAO.getConnection() != null;
        
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
        
        return status;
    }
    
    /**
     * Creates a PDF file containing all the texts in the database.
     * @param groupQty amount of groups
     */
    public static void downloadPdf(int groupQty){
        TextDAO db = (TextDAO) FactoryDAO.getDAO(false);
        
        FileTransform.createPdf(db.retrieveAll(groupQty),"Texts");
    }
    
    public static void endCon(){
        DAO.endConnection();
    }
}
