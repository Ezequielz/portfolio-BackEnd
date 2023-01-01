
package com.devzed.devzed.Dto;

import javax.validation.constraints.NotBlank;


public class dtoExperiencia {
    
    @NotBlank
    private String fecha;
    @NotBlank
    private String title;
    @NotBlank
    private String info;

    public dtoExperiencia() {
    }

    public dtoExperiencia(String fecha, String title, String info) {
        this.fecha = fecha;
        this.title = title;
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

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
    
    
    
}
