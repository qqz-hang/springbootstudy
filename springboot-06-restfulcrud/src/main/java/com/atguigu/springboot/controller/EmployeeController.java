package com.atguigu.springboot.controller;

import com.atguigu.springboot.dao.DepartmentDao;
import com.atguigu.springboot.dao.EmployeeDao;
import com.atguigu.springboot.entities.Department;
import com.atguigu.springboot.entities.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Collection;

@Controller
public class EmployeeController {
    @Resource
    private EmployeeDao employeeDao;
    @Resource
    private DepartmentDao departmentDao;

    @GetMapping("/emps")
    public String getEmployees(Model model) {
        Collection<Employee> employeeDaoAll = employeeDao.getAll();
        model.addAttribute("emps", employeeDaoAll);
        return "emp/list";
    }

    @GetMapping("/emp")
    public String toAddPage(Model model) {
        // 去到添加页面之前 取出所有的部门
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("departs", departments);
        return "emp/add";
    }

    @PostMapping("/emp")
    public String addEmploy(Employee employee) {
        employeeDao.save(employee);
        return "redirect:/emps";
    }

    @GetMapping("/emp/{id}")
    public String toEditPage(@PathVariable("id") Integer id,
                             Model model) {
        Employee employee = employeeDao.get(id);
        model.addAttribute("emp", employee);
        // 去到添加页面之前 取出所有的部门
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("departs", departments);
        return "emp/add";
    }

    @PutMapping("/emp")
    public String updateEmployee(Employee employee) {
        employeeDao.save(employee);
        return "redirect:/emps";
    }

    @DeleteMapping("/emp/{id}")
    public String deleteEmployee(@PathVariable("id") Integer id) {
        employeeDao.delete(id);
        return "redirect:/emps";
    }
}
