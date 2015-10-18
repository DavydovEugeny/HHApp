package com.edavydov.HHApp.utils;

import com.edavydov.HHApp.domain.Employee;

import java.util.List;

public class DepEmpDTO {

    private Integer id;
    private String namedep;
    private String bossdep;
    private String region;
    private List<Employee> employees;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    @Override
    public String toString() {
        return "DepEmpDTO{" +
                "id=" + id +
                ", namedep='" + namedep + '\'' +
                ", bossdep='" + bossdep + '\'' +
                ", region='" + region + '\'' +
                ", employees=" + employees +
                '}';
    }
}
