package com.lyh.ssm.crud.model;

import com.lyh.ssm.crud.bean.Department;

import java.util.List;

public class DeptModel extends BaseModel {
    private List<Department> departments;

    public List<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(List<Department> departments) {
        this.departments = departments;
    }
}
