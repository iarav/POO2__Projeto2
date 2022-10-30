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
 *
 * @author iarav
 */
public class Controller {
    
    public static void CriarConexaoLocal(String user, String password){
        localConnectionDAO.setUrl();
        localConnectionDAO.setUsuario(user);
        localConnectionDAO.setSenha(password);
        localConnectionDAO.setConnection();
    }
    
    public static void FinalizarConexaoLocal(){
        localConnectionDAO db = new localConnectionDAO();
        db.endConnection();
    }
    
    public static Text RecuperarTextoLocal(int id){
        TextDAO teste = new TextDAO();
        return teste.retrieve(id);
    }
    
    public static void CriarTxt(int id, String typeOfDB){
        FileTransform.createTxt(RecuperarTextoLocal(id), CreateFileName(id,typeOfDB));
    }
    
    public static String CreateFileName(int id, String typeOfDB){
        return "textoG" + String.valueOf(id) + typeOfDB;
    }
    
    public static boolean verifyStatus(){
        localConnectionDAO db = new localConnectionDAO();
        Connection con = db.getConnection();
        return con != null;
    }
}
