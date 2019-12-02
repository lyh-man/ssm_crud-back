package com.lyh.ssm.crud.bean;

public class Employee {
    private Integer id;

    private String name;

    private Double salary;

    private Integer age;

    private String email;

    private Integer deptid;

    public Employee() {
    }

    public Employee(Integer id, String name, Double salary, Integer age, String email, Integer deptid) {

        this.id = id;
        this.name = name;
        this.salary = salary;
        this.age = age;
        this.email = email;
        this.deptid = deptid;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
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
        this.email = email == null ? null : email.trim();
    }

    public Integer getDeptid() {
        return deptid;
    }

    public void setDeptid(Integer deptid) {
        this.deptid = deptid;
    }
}