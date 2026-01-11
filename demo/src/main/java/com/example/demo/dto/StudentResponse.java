package com.example.demo.dto;

public class StudentResponse {
    private Long id;
    private String name;
    private String email;
    private Integer age;
    private String course;

    public StudentResponse(){}

    public StudentResponse(Long id,String name,Integer age,String email, String course){
        this.id=id;
        this.name=name;
        this.age=age;
        this.email=email;
        this.course=course;
    }

    public StudentResponse(Long id, String name, String email, Integer age, String course) {
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }
}
