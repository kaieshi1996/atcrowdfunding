package com.atguigu.crowd.entity;

import java.util.List;
import java.util.Map;

public class Student {
    private Integer stuId;
    private String stuName;
    private Address address;
    private List<Subject> subjectList;
    private Map<String,String> map;

    public Student(Integer stuId, String stuName, Address address, List<Subject> subjectList, Map<String, String> map) {
        this.stuId = stuId;
        this.stuName = stuName;
        this.address = address;
        this.subjectList = subjectList;
        this.map = map;
    }

    public Student() {
    }

    public Integer getStuId() {
        return stuId;
    }

    public String getStuName() {
        return stuName;
    }

    public Address getAddress() {
        return address;
    }

    public List<Subject> getSubjectList() {
        return subjectList;
    }

    public Map<String, String> getMap() {
        return map;
    }

    public void setStuId(Integer stuId) {
        this.stuId = stuId;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void setSubjectList(List<Subject> subjectList) {
        this.subjectList = subjectList;
    }

    public void setMap(Map<String, String> map) {
        this.map = map;
    }

    @Override
    public String toString() {
        return "Student{" +
                "stuId=" + stuId +
                ", stuName='" + stuName + '\'' +
                ", address=" + address +
                ", subjectList=" + subjectList +
                ", map=" + map +
                '}';
    }
}
