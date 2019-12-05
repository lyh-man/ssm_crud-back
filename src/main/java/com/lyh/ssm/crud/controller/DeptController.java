package com.lyh.ssm.crud.controller;

import com.lyh.ssm.crud.model.BaseModel;
import com.lyh.ssm.crud.model.DeptModel;
import com.lyh.ssm.crud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeptController {
    @Autowired
    private DeptService deptService;

    @GetMapping("/depts")
    public DeptModel getAllDept() {
        DeptModel deptModel = new DeptModel();
        if (deptService.getAllDept().size() <= 0) {
            deptModel.addMessage("获取部门信息失败");
            deptModel.setSuccess(false);
            deptModel.setLevel(BaseModel.Level.error);
            return deptModel;
        }
        deptModel.addMessage("获取部门信息成功");
        deptModel.setSuccess(true);
        deptModel.setLevel(BaseModel.Level.info);
        deptModel.setDepartments(deptService.getAllDept());
        return deptModel;
    }
}
