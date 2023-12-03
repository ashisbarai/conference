package com.pluralsight.conference.controller;

import com.pluralsight.conference.mapper.PersonMapper;
import com.pluralsight.conference.model.Person;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

@Controller
public class GreetingController {
    private final PersonMapper personMapper;
    public GreetingController(PersonMapper personMapper){
        this.personMapper = personMapper;
    }
    @GetMapping("greeting")
    public String greeting(Map<String, Object> model){
        Person p = this.personMapper.findById(1);

        model.put("message", "Hello Ashis");
        return "greeting";
    }
}
