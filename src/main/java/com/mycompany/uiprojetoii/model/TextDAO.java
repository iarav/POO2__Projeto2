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
   
    public TextDAO(String user, String password){
        setURL("jdbc:mariadb://143.106.243.64:3306/SI400");
        setUser(user);
        setPassword(password);
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
   
    @Override
    public ResultSet getTextFromDB(int id) {
        ResultSet res = getFromDB(""
                    + "SELECT * FROM Fragmentos "
                    + "WHERE groupId = "+ id
                    + " ORDER BY line");
        return res;
    }
   
    public Text retrieve(int id){
        ResultSet res = getTextFromDB(id);
       
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
