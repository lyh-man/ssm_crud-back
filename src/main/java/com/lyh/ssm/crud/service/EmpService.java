package com.lyh.ssm.crud.service;

import com.lyh.ssm.crud.bean.Employee;
import com.lyh.ssm.crud.dao.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpService {
    @Autowired
    private EmployeeMapper employeeMapper;

    public Employee getSingleEmp(Integer id) {
        return employeeMapper.selectByPrimaryKey(id);
    }

    public List<Employee> getAllEmp() {
        return employeeMapper.selectAll();
    }
}
