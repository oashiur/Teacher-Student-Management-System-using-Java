package com.mycompany.tsms.model;

public class Student {
    private int id;
    private String name;
    private String email;
    private String cell;
    private byte[] image;

    public Student() {
    }

    public Student(int id, String name, String email, String cell, byte[] image) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.cell = cell;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCell() {
        return cell;
    }

    public void setCell(String cell) {
        this.cell = cell;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }
    
    
}
