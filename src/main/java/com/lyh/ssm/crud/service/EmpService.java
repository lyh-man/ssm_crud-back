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

    /**
     * 获取某个员工的信息
     *
     * @param id 某个员工的id
     * @return 某个员工的信息
     */
    public Employee getEmpById(Integer id) {
        return employeeMapper.selectByPrimaryKey(id);
    }

    /**
     * 获取所有员工的信息
     *
     * @return 所有员工的信息
     */
    public List<Employee> getAllEmp() {
        return employeeMapper.selectAll();
    }

    /**
     * 插入某个员工的信息
     *
     * @param emp 某员工的信息
     * @return 返回插入影响的行数
     */
    public Integer insertEmp(Employee emp) {
        return employeeMapper.insertSelective(emp);
    }

    /**
     * 删除某个员工的信息
     *
     * @param id 员工的id
     * @return 返回删除影响的行数
     */
    public Integer deleteEmpById(Integer id) {
        return employeeMapper.deleteByPrimaryKey(id);
    }

    /**
     * 更新某个员工的信息
     * @param employee 员工信息
     * @return 返回修改影响的行数
     */
    public Integer updateEmp(Employee employee) {
        return employeeMapper.updateByPrimaryKeySelective(employee);
    }
}
