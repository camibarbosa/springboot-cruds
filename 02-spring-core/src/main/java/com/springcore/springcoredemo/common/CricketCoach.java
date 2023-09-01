package com.springcore.springcoredemo.common;

import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements Coach {

    public CricketCoach(){
        System.out.println("In constructor: " + getClass().getSimpleName());
    }



    @Override
    public String getDailyWorkout() {
        return "Practice dance for 20 minutes!!!";
    }
}
