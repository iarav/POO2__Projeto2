/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.uiprojetoii.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Brenda
 * @author Yuri
 * @version 1.0
 */
public class TextDAO extends DAO {
    
    public TextDAO(){
        setURL("jdbc:mariadb://localhost:3307/poo");
        user = "root";
        password = "";
        setConnection();
    }
    
    /**
     * Creates a Text instance through the result set of a query to a table of 
     * text fragments.
     * @see com.mycompany.model.Text Text
     * @param res - Result Set
     * @return Text object
     */
    private Text createText(ResultSet res){
        Text text = null;
        
        try {
            if(res.next())
                text = new Text(res.getInt("groupId"), res.getString("file"));
            
            do
                text.addContent(res.getString("text"));
            while(res.next());
            
        } catch (SQLException ex) {
            Logger.getLogger(TextDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return text;
    }
    
    /**
     * Retrieves a Text instance of a query based on the group id.
     * @see com.mycompany.model.TextDAO#createText
     * @param id - Group ID
     * @return Text object
     */
    public Text retrieve(int id){
        ResultSet res = getTextFromDB(""
                    + "SELECT * FROM textos "
                    + "WHERE groupId = "+ id
                    + " ORDER BY line");
        
        Text text = createText(res);  
        
        return text;
    } 
    
    /**
     * Retrieves an ArrayList of all instances of Text in the text fragments 
     * table.
     * @see com.mycompany.model.TextDAO#retrieve
     * @param groupQty - Amount of groups
     * @return ArrayList of Text instances
     */
    public List retrieveAll(int groupQty){
        List<Text> texts = new ArrayList();
        
        for(int i = 1; i <= groupQty; i++)
            texts.add(retrieve(i));
        
        return texts;
    }
    
    
}
