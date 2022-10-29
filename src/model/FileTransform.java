/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.List;
import javax.swing.JOptionPane;

/**
 * @author Brenda
 * @author Yuri
 */
public class FileTransform {
    
    public static void createTxt(Text text, String filePath) {
        try (BufferedWriter writer = new BufferedWriter(
                    new OutputStreamWriter(new FileOutputStream(filePath + ".txt"), StandardCharsets.ISO_8859_1))){
                      
            writer.write(text.getContent());
            
            writer.close();
            
            JOptionPane.showMessageDialog(null, "O arquivo: " + filePath + " foi criado, verifique o diretorio definido",
            "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "O programa não foi capaz de criar o arquivo.",
            "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public static void createPdf(List<Text> texts){
        
    }
    
}
