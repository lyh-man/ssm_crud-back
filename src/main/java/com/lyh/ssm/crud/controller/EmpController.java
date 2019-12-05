package com.lyh.ssm.crud.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lyh.ssm.crud.bean.Employee;
import com.lyh.ssm.crud.model.BaseModel;
import com.lyh.ssm.crud.model.EmpModel;
import com.lyh.ssm.crud.model.EmpPageModel;
import com.lyh.ssm.crud.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmpController {
    @Autowired
    private EmpService empService;

    /**
     * 获取分页的数据
     * @param pn 获取第几页的数据
     * @return 返回数据
     */
    @GetMapping("/emps/{pn}")
    public EmpPageModel getAllEmp(@PathVariable Integer pn) {
        // step1:引入分页插件(PageHelper)
        // step2:每次查询前，设置查询的页面以及查询的条数，每次获取5条数据
        PageHelper.startPage(pn, 5);
        // step3:执行分页查询
        List<Employee> employeeList = empService.getAllEmp();
        // step4:包装查询后的数据
        PageInfo pageInfo = new PageInfo(employeeList);
        EmpPageModel empPageModel = new EmpPageModel();
        if (employeeList.size() <= 0) {
            empPageModel.addMessage("获取分页数据失败");
            empPageModel.setSuccess(false);
            empPageModel.setLevel(BaseModel.Level.error);
            return empPageModel;
        }
        empPageModel.addMessage("获取分页数据成功");
        empPageModel.setSuccess(true);
        empPageModel.setLevel(BaseModel.Level.info);
        empPageModel.setPageInfo(pageInfo);
        return empPageModel;
    }

    /**
     * 获取某个员工的信息
     * REST -- GET
     * @param id 员工的id
     * @return 返回数据
     */
    @GetMapping("/emp/{id}")
    public EmpModel getEmpById(@PathVariable Integer id) {
        EmpModel empModel = new EmpModel();
        if (empService.getEmpById(id) == null) {
            empModel.addMessage("获取员工信息失败");
            empModel.setSuccess(false);
            empModel.setLevel(BaseModel.Level.error);
            return empModel;
        }
        empModel.addMessage("获取员工信息成功");
        empModel.setSuccess(true);
        empModel.setLevel(BaseModel.Level.info);
        empModel.addEmployee(empService.getEmpById(id));
        return empModel;
    }

    /**
     * 删除某个员工的信息
     * REST -- DELETE
     * @param id 员工的id
     * @return 返回数据
     */
    @RequestMapping(value = "/emp/{id}", method = RequestMethod.DELETE)
    public BaseModel deleteEmpById(@PathVariable Integer id) {
        BaseModel baseModel = new BaseModel();
        if (empService.deleteEmpById(id) != 0) {
            baseModel.addMessage("删除员工信息成功");
            baseModel.setSuccess(true);
            baseModel.setLevel(BaseModel.Level.info);
            return baseModel;
        }
        baseModel.addMessage("删除员工信息失败");
        baseModel.setSuccess(false);
        baseModel.setLevel(BaseModel.Level.error);
        return baseModel;
    }

    /**
     * 向员工表中插入员工信息
     * REST -- POST
     * 使用 @RequestBody 需注意，前台传递的参数名要与 Employee 里的参数名对应，否则接收不到值
     * @param employee 员工信息
     * @return 返回数据
     */
    @PostMapping("/emp")
    public BaseModel insertEmp(@RequestBody Employee employee) {
        BaseModel baseModel = new BaseModel();
        if (empService.insertEmp(employee) != 0) {
            baseModel.addMessage("插入员工信息成功");
            baseModel.setSuccess(true);
            baseModel.setLevel(BaseModel.Level.info);
            return baseModel;
        }
        baseModel.addMessage("插入员工信息失败");
        baseModel.setSuccess(false);
        baseModel.setLevel(BaseModel.Level.error);
        return baseModel;
    }

    /**
     * 更新员工信息
     * REST -- PUT
     * @param employee 员工信息
     * @return 返回数据
     */
    @RequestMapping(value = "/emp/{id}", method = RequestMethod.PUT)
    public BaseModel updateEmp(@RequestBody Employee employee) {
        BaseModel baseModel = new BaseModel();
        if (empService.updateEmp(employee) != 0) {
            baseModel.addMessage("更新员工信息成功");
            baseModel.setSuccess(true);
            baseModel.setLevel(BaseModel.Level.info);
            return baseModel;
        }
        baseModel.addMessage("更新员工信息失败");
        baseModel.setSuccess(false);
        baseModel.setLevel(BaseModel.Level.error);
        return baseModel;
    }
}
