package com.restcrudapi.restapidemo.rest;

import com.restcrudapi.restapidemo.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    private List<Student> theStudents;

    // define @PostConstructor to load the student data only once

    @PostConstruct
    public void loadData(){
        theStudents = new ArrayList<>();

        theStudents.add(new Student("Jennie", "Kim"));
        theStudents.add(new Student("Jisoo", "Kim"));
        theStudents.add(new Student("Lana", "Del Rey"));
    }


    // define endpoint for "/students" - return a list of students
    @GetMapping("/students")
    public List<Student> getStudents(){
        return theStudents;
    }

    // define endpoint dor "students/{studentId}" - return student at index
    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId){
        //check the studentId again list size
        if (studentId >= theStudents.size() || (studentId < 0)){
            throw new StudentNotFoundException("Student id not found - " + studentId);
        }

        // just index into the list
        return theStudents.get(studentId);
    }

}
