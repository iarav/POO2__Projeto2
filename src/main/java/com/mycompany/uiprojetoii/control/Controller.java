package com.mycompany.uiprojetoii.control;

import com.mycompany.uiprojetoii.model.FileTransform;
import com.mycompany.uiprojetoii.model.Text;
import com.mycompany.uiprojetoii.model.TextDAO;
import com.mycompany.uiprojetoii.model.localConnectionDAO;
import java.sql.Connection;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 * Controller class - makes connection between Model classes and View
 * @author Iara
 */
public class Controller {
    
    /**
     * Creates the local database connection
     * @param user
     * @param password
     */
    public static void CreateLocalConnection(String user, String password){
        localConnectionDAO.setUrl();
        localConnectionDAO.setUsername(user);
        localConnectionDAO.setPasswordDB(password);
        localConnectionDAO.setConnection();
    }
    
    /**
     * Ends the local database connection
     */
    public static void FinalizeLocalConnection(){
        localConnectionDAO db = new localConnectionDAO();
        db.endConnection();
    }
    
    /**
     * This retrieves a text from a specific group by id
     * @param id
     * @return 
     */
    public static Text RetrieveLocalText(int id){
        TextDAO teste = new TextDAO();
        return teste.retrieve(id);
    }
    
    /**
     * This creates a txt file using the groupId and the type of db (Local or Server)
     * @param id
     * @param typeOfDB
     */
    public static void CreateTxtFile(int id, String typeOfDB){
        FileTransform.createTxt(RetrieveLocalText(id), CreateFileName(id,typeOfDB));
    }
    
    /**
     * This creates a String that is the name of the file, using the groupId and the type of db (Local or Server).
     * @param id
     * @param typeOfDB
     * @return 
     */
    public static String CreateFileName(int id, String typeOfDB){
        return "textoG" + String.valueOf(id) + typeOfDB;
    }
    
    /**
     * This verify the status of the database connection
     * @return 
     */
    public static boolean verifyStatus(){
        localConnectionDAO db = new localConnectionDAO();
        Connection con = db.getConnection();
        return con != null;
    }
}
