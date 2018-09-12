package com.saban.school.core.controller;

import com.saban.school.core.bs.dao.PersonRepository;
import com.saban.school.core.bs.dao.StudentGradeRepository;
import com.saban.school.core.eis.bo.Person;
import com.saban.school.core.eis.bo.StudentGrade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "api/v1/studentGrade", produces = MediaType.APPLICATION_JSON_VALUE)
@ResponseBody
public class StudentGradeController {
    @Autowired
    private StudentGradeRepository studentGradeRepository;
    @Autowired
    private PersonRepository personRepository;
    @RequestMapping(method = RequestMethod.GET)
    public Iterable<StudentGrade> getAll() {
        return studentGradeRepository.findAll();
    }
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> save(@RequestBody(required = true) StudentGrade studentGrade) {
        Person personExists = personRepository.findOne(studentGrade.getPerson().getPersonId());
        if (personExists == null) {
            studentGrade.setPerson(personRepository.save(studentGrade.getPerson()));
            studentGradeRepository.save(studentGrade);
        } else {
            StudentGrade newStudentGrade = studentGradeRepository.save(studentGrade);
            newStudentGrade.setPerson(studentGrade.getPerson());
            studentGradeRepository.save(newStudentGrade);
        }
        return new ResponseEntity<String>("{\"message\":\"StudentGrade insertado correctamente!\"}", HttpStatus.OK);
    }
    @RequestMapping(value = "{id}", method = RequestMethod.PATCH)
    public Object update(@PathVariable("id") Long id, @RequestBody(required = true) StudentGrade studentGrade) {
        studentGrade.setEnrollmentId(id);
        return studentGradeRepository.save(studentGrade);
    }
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public Object delete(@PathVariable("id") Long id, @RequestBody(required = false) StudentGrade studentGrade){
        studentGrade = (StudentGrade) this.studentGradeRepository.findOne(id);
        this.studentGradeRepository.delete(studentGrade);
        return studentGrade;
    }
}
