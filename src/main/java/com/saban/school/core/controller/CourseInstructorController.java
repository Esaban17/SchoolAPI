package com.saban.school.core.controller;

import com.saban.school.core.bs.dao.CourseInstructorRepository;
import com.saban.school.core.eis.bo.CourseInstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "api/v1/courseInstructor", produces = MediaType.APPLICATION_JSON_VALUE)
@ResponseBody
public class CourseInstructorController {
    @Autowired
    private CourseInstructorRepository courseInstructorRepository;
    @RequestMapping(method = RequestMethod.GET)
    public Iterable<CourseInstructor> getAll() {
        return courseInstructorRepository.findAll();
    }
    @RequestMapping(method = RequestMethod.POST)
    public Object save(@RequestBody(required = true) CourseInstructor courseInstructor) {
        return courseInstructorRepository.save(courseInstructor);
    }
    @RequestMapping(method = RequestMethod.PATCH)
    public Object update(@RequestBody(required = true) CourseInstructor courseInstructor) {
        return courseInstructorRepository.save(courseInstructor);
    }
    @RequestMapping(method = RequestMethod.DELETE)
    public void delete(@RequestBody(required = true) CourseInstructor courseInstructor) {
        courseInstructorRepository.delete(courseInstructor);
    }
}
