package com.saban.school.core.controller;

import com.saban.school.core.bs.dao.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {
    @Autowired
    private PersonRepository personRepository;
    @RequestMapping("/")
    @ResponseBody
    public String index() {
        String response = "Bienvenido al sistema EDU";
        return response;
    }
}
