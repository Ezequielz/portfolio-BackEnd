
package com.devzed.devzed.Dto;

import javax.validation.constraints.NotBlank;


public class dtoFormacion {
    
    @NotBlank
    private String fecha;
    @NotBlank
    private String title;
    @NotBlank
    private String subtitle;
    @NotBlank
    private String info;

    public dtoFormacion() {
    }

    public dtoFormacion(String fecha, String title, String subtitle, String info) {
        this.fecha = fecha;
        this.title = title;
        this.subtitle = subtitle;
        this.info = info;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
    
    
    
}
