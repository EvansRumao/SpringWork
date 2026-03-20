package com.SpringApp.webApp;

public class Employee {
    private int aid;
    private String name;

    public int getAid() {
        return aid;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "aid=" + aid +
                ", name='" + name + '\'' +
                '}';
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
