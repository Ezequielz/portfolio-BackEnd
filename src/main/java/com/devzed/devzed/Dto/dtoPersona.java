package com.devzed.devzed.Dto;

import javax.validation.constraints.NotBlank;

public class dtoPersona {

    @NotBlank
    private String nombre;
    @NotBlank
    private String apellido;
    @NotBlank
    private String img;
    @NotBlank
    private String nacionalidad;
    @NotBlank
    private String domicilio;
    @NotBlank
    private String nacimiento;

    public dtoPersona() {
    }

    public dtoPersona(String nombre, String apellido, String img, String nacionalidad, String domicilio, String nacimiento) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.img = img;
        this.nacionalidad = nacionalidad;
        this.domicilio = domicilio;
        this.nacimiento = nacimiento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getNacimiento() {
        return nacimiento;
    }

    public void setNacimiento(String nacimiento) {
        this.nacimiento = nacimiento;
    }


    

    

}
