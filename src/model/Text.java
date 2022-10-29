/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author Yuri
 */
public class Text {
    private int groupId;
    private String file;
    private ArrayList<String> content;

    public Text(int groupId, String file) {
        this.groupId = groupId;
        this.file = file;
        content = new ArrayList();
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }
    
    public String getContent(){
        String content = "";
        
        for(int i=0; i < this.content.size(); i++) {
                content += this.content.get(i);
            }
        
        return content;
    }
    
    public void addContent(String text){
        this.content.add(text);
    }
    
    @Override
    public String toString() {
        return "Text{" + "groupId=" + groupId + ", file=" + file + ", content=" + content + '}';
    }

}
