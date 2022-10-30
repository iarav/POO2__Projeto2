/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.uiprojetoii.model;

import java.util.ArrayList;

/**
 * Class to abstract the data from text fragments
 * @author Yuri
 * @version 1.0
 */
public class Text {
    private int groupId;
    private String file;
    private final ArrayList<String> content;

    /**
     * Default constructor of Text.
     * @param groupId the group id to be set
     * @param file the file name to be set
     */
    public Text(int groupId, String file) {
        this.groupId = groupId;
        this.file = file;
        content = new ArrayList();
    }

    /**
     * Gets the group id.
     * @return groupId the group id to be returned
     */
    public int getGroupId() {
        return groupId;
    }

    /**
     * Sets the group id.
     * @param groupId the group id to be set
     */
    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    /**
     * Gets the file name.
     * @return file the file name to be returned
     */
    public String getFile() {
        return file;
    }

    /**
     * Sets the file name.
     * @param file the file name to be set
     */
    public void setFile(String file) {
        this.file = file;
    }
    
    /**
     * Gets the contet of the Text.
     * @return content the content to be returned (String)
     */
    public String getContent(){
        String contentLine = "";
        
        for(int i=0; i < this.content.size(); i++) {
                contentLine += this.content.get(i) + "\n";
            }
        
        return contentLine;
    }
    
    /**
     * Adds a new line of text in the Text ArrayList (content).
     * @param text 
     */
    public void addContent(String text){
        this.content.add(text);
    }
    
    @Override
    public String toString() {
        return "Text{" + "groupId=" + groupId + ", file=" + file + ", content=" + content + '}';
    }

}
