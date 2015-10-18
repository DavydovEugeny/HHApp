package com.edavydov.HHApp.domain;


public class Department {

    Integer iddep;
    String namedep;
    String bossdep;
    String region;

    public Integer getIddep() {
        return iddep;
    }

    public void setIddep(Integer iddep) {
        this.iddep = iddep;
    }

    public String getNamedep() {
        return namedep;
    }

    public void setNamedep(String namedep) {
        this.namedep = namedep;
    }

    public String getBossdep() {
        return bossdep;
    }

    public void setBossdep(String bossdep) {
        this.bossdep = bossdep;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

}
