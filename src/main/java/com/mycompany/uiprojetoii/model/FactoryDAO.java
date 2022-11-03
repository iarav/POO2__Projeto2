/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.mycompany.uiprojetoii.model;

/**
 * @author Brenda
 * @author Yuri
 */
public class FactoryDAO {
    /**
     * @param isLocal
     * @param user
     * @param pass
     * @return
    */
    public DAO getDAO(Boolean isLocal, String user, String pass) {
        if(isLocal)
            return new LocalConnDAO(user, pass);
        else
            return new TextDAO(user, pass);
    }
}
