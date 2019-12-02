package com.lyh.ssm.crud.bean;

public class Department {
    public Department() {
    }

    public Department(Integer deptid, String deptname) {

        this.deptid = deptid;
        this.deptname = deptname;
    }

    private Integer deptid;

    private String deptname;

    public Integer getDeptid() {
        return deptid;
    }

    public void setDeptid(Integer deptid) {
        this.deptid = deptid;
    }

    public String getDeptname() {
        return deptname;
    }

    public void setDeptname(String deptname) {
        this.deptname = deptname == null ? null : deptname.trim();
    }
}