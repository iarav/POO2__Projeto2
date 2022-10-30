package com.mycompany.uiprojetoii.control;

import com.mycompany.uiprojetoii.model.FileTransform;
import com.mycompany.uiprojetoii.model.Text;
import com.mycompany.uiprojetoii.model.TextDAO;
import com.mycompany.uiprojetoii.model.localConnectionDAO;
import com.mycompany.uiprojetoii.view.MainFrame;
import java.io.IOException;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author iarav
 */
public class Controller {
    
    public static void CriarConexaoLocal(){
        localConnectionDAO db = new localConnectionDAO();
        db.setConnection();
    }
    
    public static Text RecuperarTextoLocal(int id){
        TextDAO teste = new TextDAO();
        return teste.retrieve(id);
    }
    
    public static void CriarTxt(Text text, String filePath){
        FileTransform.createTxt(text, filePath);
    }
    
}
