/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author Yuri
 */
public class Text {
    private int groupId;
    private String file;
    private TreeMap<Integer, String> content;

    public Text(int groupId, String file) {
        this.groupId = groupId;
        this.file = file;
        content = new TreeMap();
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
        
        for(Map.Entry<Integer, String> entry : this.content.entrySet()) {
                content += entry.getValue();
            }
        
        return content;
    }
    
    public void addContent(int line, String text){
        this.content.put(line, text);
    }
    
    @Override
    public String toString() {
        return "Text{" + "groupId=" + groupId + ", file=" + file + ", content=" + content + '}';
    }

}
