package com.saban.school.core.controller;

import com.saban.school.core.bs.dao.DepartmentRepository;
import com.saban.school.core.eis.bo.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/v1/department", produces = MediaType.APPLICATION_JSON_VALUE)
@ResponseBody
public class DepartmentController {
    @Autowired
    private DepartmentRepository departmentRepository;
    @RequestMapping(method = RequestMethod.GET)
    public Iterable<Department> getAll() {
        return departmentRepository.findAll();
    }
    @RequestMapping(method = RequestMethod.POST)
    public Object save(@RequestBody(required = true) Department department) {
        return departmentRepository.save(department);
    }
    @RequestMapping(value = "{id}", method = RequestMethod.PATCH)
    public Object update(@PathVariable("id") Long id, @RequestBody(required = true) Department department) {
        department.setDepartmentId(id);
        return departmentRepository.save(department);
    }
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public Object delete(@PathVariable("id") Long id, @RequestBody(required = false) Department department){
        department = (Department) this.departmentRepository.findOne(id);
        this.departmentRepository.delete(department);
        return department;
    }
}
