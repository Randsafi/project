package com.Online_Recruitment_System.web.controllers;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Optional;

@org.springframework.stereotype.Controller
@RequestMapping("/test")
public class Controller {
    @GetMapping(("/{id}"))
    @ResponseBody
    public String getString(@PathVariable("id") Optional<Integer> id){
        if (id.isPresent()){
            System.out.println(id.get());
        }
        return "<h1>Hello</h1>";
    }
}
