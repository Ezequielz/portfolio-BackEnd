
package com.devzed.devzed.Dto;

import javax.validation.constraints.NotBlank;

public class dtoAbout {
    
    @NotBlank
    private String title;
    @NotBlank
    private String info;

    public dtoAbout() {
    }

    public dtoAbout(String title, String info) {
        this.title = title;
        this.info = info;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
    
    
}
