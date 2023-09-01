package com.course.springboot.mycoolapp.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {

    //inject properties for: coach name and team
    @Value("${coach.name}")
    private String coachName;

    @Value("${team.name}")
    private String teamName;

    //expose new endpoint for teaminfo
    @GetMapping("/teaminfo")
    public String getTeamInfo(){
        return "Coach name: " + coachName + ", Team name: " + teamName;
    }

    //expose "/" that return "Hello World"

    @GetMapping("/")
    public String hello(){
        return "Hello World!";
    }

    @GetMapping("/workout")
    public String getDailyWorkout(){
        return "Work hard!!";
    }

    @GetMapping("/fortune")
    public String getDailyFortune(){
        return "Good luck";
    }
}
