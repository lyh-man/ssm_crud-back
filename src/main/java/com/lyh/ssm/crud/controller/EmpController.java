package com.lyh.ssm.crud.controller;

import com.lyh.ssm.crud.model.BaseModel;
import com.lyh.ssm.crud.model.EmpModel;
import com.lyh.ssm.crud.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "emp")
public class EmpController {
    @Autowired
    private EmpService empService;

    @GetMapping("/getSingleEmp/{id}")
    public EmpModel getSingleEmp(@PathVariable Integer id) {
        EmpModel empModel = new EmpModel();
        if (empService.getSingleEmp(id) == null) {
            empModel.addMessage("error");
            empModel.setSuccess(false);
            empModel.setLevel(BaseModel.Level.error);
            return empModel;
        }
        empModel.addMessage("success");
        empModel.setSuccess(true);
        empModel.setLevel(BaseModel.Level.info);
        empModel.addEmployee(empService.getSingleEmp(id));
        return empModel;
    }

    @GetMapping("/getAllEmp")
    public EmpModel getAllEmp() {
        EmpModel empModel = new EmpModel();
        if (empService.getAllEmp().size() <= 0) {
            empModel.addMessage("error");
            empModel.setSuccess(false);
            empModel.setLevel(BaseModel.Level.error);
            return empModel;
        }
        empModel.addMessage("success");
        empModel.setSuccess(true);
        empModel.setLevel(BaseModel.Level.info);
        empModel.setEmployeeList(empService.getAllEmp());
        return empModel;
    }
}
