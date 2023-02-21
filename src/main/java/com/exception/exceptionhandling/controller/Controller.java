package com.exception.exceptionhandling.controller;

import com.exception.exceptionhandling.Student;
import com.exception.exceptionhandling.exception.ApiException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Controller {

    @GetMapping("/")
    public List<Student> getStudent(){
        throw new ApiException("exeption happend..");
    }
}
