package com.saban.school.core.controller;

import com.saban.school.core.bs.dao.OfficeAssignmentRepository;
import com.saban.school.core.eis.bo.OfficeAssignment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "api/v1/officeAssignment", produces = MediaType.APPLICATION_JSON_VALUE)
@ResponseBody
public class OfficeAssignmentController {
    @Autowired
    private OfficeAssignmentRepository officeAssignmentRepository;
    @RequestMapping(method = RequestMethod.GET)
    public Iterable<OfficeAssignment> getAll() {
        return officeAssignmentRepository.findAll();
    }
    @RequestMapping(method = RequestMethod.POST)
    public Object save(@RequestBody(required = true) OfficeAssignment officeAssignment) {
        return officeAssignmentRepository.save(officeAssignment);
    }
    @RequestMapping(value = "{id}", method = RequestMethod.PATCH)
    public Object update(@PathVariable("id") Long id, @RequestBody(required = true) OfficeAssignment officeAssignment) {
        officeAssignment.setInstructorId(id);
        return officeAssignmentRepository.save(officeAssignment);
    }
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public Object delete(@PathVariable("id") Long id, @RequestBody(required = false) OfficeAssignment officeAssignment){
        officeAssignment = (OfficeAssignment) this.officeAssignmentRepository.findOne(id);
        this.officeAssignmentRepository.delete(officeAssignment);
        return officeAssignment;
    }
}
