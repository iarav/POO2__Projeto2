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
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 * Class to create the file with the text
 * @author Brenda
 * @author Yuri
 * @author Heloisie
 */
public class FileTransform {

    /**
     * Creates a .txt file with the text
     *
     * @param text the text to be writed
     * @param filePath path file
     */
    public static void createTxt(String text, String filePath) {
        try ( BufferedWriter writer = new BufferedWriter(
                    new OutputStreamWriter(new FileOutputStream(filePath + ".txt"), StandardCharsets.ISO_8859_1))) {

            writer.write(text);

            writer.close();

            System.out.println("Arquivo '" + filePath + "' criado com sucesso.");
        } catch (IOException e) {
            System.out.println("Erro na criação do arquivo.");
        }
    }
    

    /**
     * Creates a .pdf file with the text
     *
     * @param texts list with the text to be writed
     * @param filePath filepath
     */
    public static void createPdf(List<Text> texts, String filePath) {
        try {
            OutputStream outputStream = new FileOutputStream(new File(filePath+".pdf"));
            Document document = new Document();
            PdfWriter.getInstance(document, outputStream);
            document.open();
            for(int i = 0; i < texts.size(); i++)
                document.add(new Paragraph(texts.get(i).getFile()+ " - " + texts.get(i).getGroupId() +"\n"+texts.get(i).getContent()));
            document.close();
            System.out.println("documento PDF criado com sucesso!");
            JOptionPane.showMessageDialog(null, "Documento PDF criado com sucesso!");
        } catch (DocumentException | FileNotFoundException e) {
            Logger.getLogger(FileTransform.class.getName()).log(Level.SEVERE, null, e);
        }

    }
}
