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
 * Class to create the file with the text
 * @author Brenda
 * @author Yuri
 */
public class FileTransform {
    
    /**
    * Creates a .txt file with the text
    * @param text the text to be writed
    * @param filePath path file
    */
    public static void createTxt(String text, String filePath) {
        try (BufferedWriter writer = new BufferedWriter(
                    new OutputStreamWriter(new FileOutputStream(filePath + ".txt"),"UTF-8"))){
                      
            writer.write(text);
            
            writer.close();
            
            System.out.println("Arquivo '" + filePath + "' criado com sucesso.");
        } catch (IOException e) {
            System.out.println("Erro na criação do arquivo.");
        }
    }
    
    /**
    * Creates a .pdf file with the text
    * @param texts list with the text to be writed
    */
    public static void createPdf(List<Text> texts){
        
    }
    
}
