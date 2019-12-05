package com.lyh.ssm.crud.service;

import com.lyh.ssm.crud.bean.Department;
import com.lyh.ssm.crud.dao.DepartmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeptService {
    @Autowired
    private DepartmentMapper departmentMapper;

    public List<Department> getAllDept() {
        return departmentMapper.selectAll();
    }
}
