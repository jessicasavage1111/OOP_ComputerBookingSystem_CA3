package com.dkit.sd2a.jessicasavage;

import java.util.HashMap;
import java.util.Map;

public class Student {
    private String name;
    private String studentID;
    private String email;
    private String phone;
    private String assetTag;
    private Map<String,Computer> computersOnLoan;

    public Student(String name, String studentID, String email, String phone, String assetTag) {
        this.name = name;
        this.studentID = studentID;
        this.email = email;
        this.phone = phone;
        this.assetTag = assetTag;
        computersOnLoan = new HashMap<>();
    }

    public String getName() {
        return name;
    }

    public String getStudentID() {
        return studentID;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public void addComputer(Computer onLoan){
        computersOnLoan.put(onLoan.getAssetTag(),onLoan);
    }

    public Map getComputers(){
        return computersOnLoan;
    }

    public Computer getStudentByAssetTag(String studentID){
        return computersOnLoan.get(assetTag);
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", studentID='" + studentID + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", computer='" + getComputers() + '\'' +
                '}';
    }
}
