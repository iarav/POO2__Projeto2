/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.mycompany.uiprojetoii.model;

/**
 * Factory DAO
 * @author Brenda
 * @author Yuri
 */
public class FactoryDAO {
    /**
     * Returns a DAO object.
     * @param isLocal boolean that indicates if is a local connection
     * @param user string with the user 
     * @param pass string with the password
     * @return DAO object.
    */
    public static DAO getDAO(Boolean isLocal, String user, String pass) {
        if(isLocal)
            return new LocalConnDAO(user, pass);
        else
            return new TextDAO(user, pass);
    }
    
    /**
     * Gets the DAO
     * @param isLocal boolean that determines if the database is local or from the server
     * @return DAD
     */
    public static DAO getDAO(Boolean isLocal) {
        if(isLocal)
            return new LocalConnDAO();
        else
            return new TextDAO();
    }
}
