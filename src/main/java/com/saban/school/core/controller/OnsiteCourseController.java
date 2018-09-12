package com.saban.school.core.controller;

import com.saban.school.core.bs.dao.OnsiteCourseRepository;
import com.saban.school.core.eis.bo.OnsiteCourse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "api/v1/onsiteCourse", produces = MediaType.APPLICATION_JSON_VALUE)
@ResponseBody
public class OnsiteCourseController {
    @Autowired
    private OnsiteCourseRepository onsiteCourseRepository;
    @RequestMapping(method = RequestMethod.GET)
    public Iterable<OnsiteCourse> getAll() {
        return onsiteCourseRepository.findAll();
    }
    @RequestMapping(method = RequestMethod.POST)
    public Object save(@RequestBody(required = true) OnsiteCourse onsiteCourse) {
        return onsiteCourseRepository.save(onsiteCourse);
    }
    @RequestMapping(value = "{id}", method = RequestMethod.PATCH)
    public Object update(@PathVariable("id") Long id, @RequestBody(required = true) OnsiteCourse onsiteCourse) {
        onsiteCourse.setCourseId(id);
        return onsiteCourseRepository.save(onsiteCourse);
    }
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public Object delete(@PathVariable("id") Long id, @RequestBody(required = false) OnsiteCourse department){
        department = (OnsiteCourse) this.onsiteCourseRepository.findOne(id);
        this.onsiteCourseRepository.delete(department);
        return department;
    }
}
