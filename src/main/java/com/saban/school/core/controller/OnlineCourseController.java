package com.saban.school.core.controller;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.saban.school.core.bs.dao.OnlineCourseRepository;
import com.saban.school.core.eis.bo.OnlineCourse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "api/v1/online-course", produces = MediaType.APPLICATION_JSON_VALUE)
@ResponseBody
public class OnlineCourseController {
    @Autowired
    private OnlineCourseRepository onlineCourseRepository;
    @RequestMapping(method = RequestMethod.GET)
    public Iterable<OnlineCourse> getAll(@RequestParam(value = "pageable", required = false)Boolean pageable) {
        return onlineCourseRepository.findAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    public Object save(@RequestBody(required = true) OnlineCourse onlineCourse) {
        return onlineCourseRepository.save(onlineCourse);
    }
    @RequestMapping(value = "{id}", method = RequestMethod.PATCH)
    public Object update(@PathVariable("id") Long id, @RequestBody(required = true) OnlineCourse onlineCourse) {
        onlineCourse.setCourseId(id);
        return onlineCourseRepository.save(onlineCourse);
    }
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public Object delete(@PathVariable("id") Long id, @RequestBody(required = false) OnlineCourse onlineCourse){
        onlineCourse = (OnlineCourse) this.onlineCourseRepository.findOne(id);
        this.onlineCourseRepository.delete(onlineCourse);
        return onlineCourse;
    }
}
