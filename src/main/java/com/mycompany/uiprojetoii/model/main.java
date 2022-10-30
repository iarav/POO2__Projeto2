package com.mycompany.uiprojetoii.model;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Class that inicialize the program 
 * @author bre8j
 */
public class main {

    public static void main(String[] args) {
        localConnectionDAO db = new localConnectionDAO();
        ResultSet text = db.getTextFromDB(1);
        
        try {
            while(text.next()) {
                System.out.println(text.getString("text"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        TextDAO teste = new TextDAO();
        
        FileTransform.createTxt(teste.retrieve(1), "teste");
    }
}