/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Brenda
 * @author Yuri
 */
public class TextDAO extends DAO {
    
    public TextDAO(){
        setURL("jdbc:mariadb://localhost:3307/poo");
        user = "root";
        password = "";
        setConnection();
    }
    
    private Text createText(ResultSet res){
        Text text = null;
        
        try {
            if(res.next()){
                text = new Text(res.getInt("groupId"), res.getString("file"));
                text.addContent(res.getInt("line"), res.getString("text"));
            }
            
            while(res.next())
                text.addContent(res.getInt("line"), res.getString("text"));
            
        } catch (SQLException ex) {
            Logger.getLogger(TextDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return text;
    }
    
    public Text retrieve(int id){
        ResultSet res = getTextFromDB(""
                    + "SELECT * FROM textos "
                    + "WHERE groupId = "+ id
                    + " ORDER BY line");
        
        Text text = createText(res);  
        
        return text;
    } 
    
    public List retrieveAll(int groupQty){
        List<Text> texts = new ArrayList();
        
        for(int i = 1; i <= groupQty; i++)
            texts.add(retrieve(i));
        
        return texts;
    }
    
    
}
