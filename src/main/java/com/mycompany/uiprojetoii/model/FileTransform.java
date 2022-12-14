/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.uiprojetoii.model;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.List;

/**
 * @author Brenda
 * @author Yuri
 */
public class FileTransform {
    
    public static void createTxt(Text text, String filePath) {
        try (BufferedWriter writer = new BufferedWriter(
                    new OutputStreamWriter(new FileOutputStream(filePath + ".txt"),"UTF-8"))){
                      
            writer.write(text.getContent());
            
            writer.close();
            
            System.out.println("Arquivo '" + filePath + "' criado com sucesso.");
        } catch (IOException e) {
            System.out.println("Erro na criação do arquivo.");
        }
    }
    
    public static void createPdf(List<Text> texts){
        
    }
    
}
