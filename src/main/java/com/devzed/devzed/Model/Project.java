
package com.devzed.devzed.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Project {
    
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private int id;
    
    private String title;
    private String descripcion;
    private String img;
    private String giturl;
    private String weburl;
    
    //Const 

    public Project() {
    }

    public Project(String title, String descripcion, String img, String giturl, String weburl) {
        this.title = title;
        this.descripcion = descripcion;
        this.img = img;
        this.giturl = giturl;
        this.weburl = weburl;
    }
    
    //Get & Set

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getGiturl() {
        return giturl;
    }

    public void setGiturl(String giturl) {
        this.giturl = giturl;
    }

    public String getWeburl() {
        return weburl;
    }

    public void setWeburl(String weburl) {
        this.weburl = weburl;
    }


    
   
}
