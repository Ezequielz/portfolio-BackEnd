
package com.devzed.devzed.Dto;

import javax.validation.constraints.NotBlank;


public class dtoProject {
    @NotBlank
    private String title;
    @NotBlank
    private String descripcion;
    @NotBlank
    private String img;

    private String giturl;
    private String weburl;
    
    //Const

    public dtoProject() {
    }

    public dtoProject(String title, String descripcion, String img, String giturl, String weburl) {
        this.title = title;
        this.descripcion = descripcion;
        this.img = img;
        this.giturl = giturl;
        this.weburl = weburl;
    }
    
    // G & S

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
