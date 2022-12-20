
package com.devzed.devzed.Dto;

import javax.validation.constraints.NotBlank;


public class dtoContact {
    @NotBlank
    private String email;
    @NotBlank
    private String tel;
    @NotBlank
    private String linkedin;
    @NotBlank
    private String github;
    @NotBlank
    private String city;
    @NotBlank
    private String cv;

    public dtoContact() {
    }

    public dtoContact(String email, String tel, String linkedin, String github, String city, String cv) {
        this.email = email;
        this.tel = tel;
        this.linkedin = linkedin;
        this.github = github;
        this.city = city;
        this.cv = cv;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getLinkedin() {
        return linkedin;
    }

    public void setLinkedin(String linkedin) {
        this.linkedin = linkedin;
    }

    public String getGithub() {
        return github;
    }

    public void setGithub(String github) {
        this.github = github;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCv() {
        return cv;
    }

    public void setCv(String cv) {
        this.cv = cv;
    }
    
    
}
