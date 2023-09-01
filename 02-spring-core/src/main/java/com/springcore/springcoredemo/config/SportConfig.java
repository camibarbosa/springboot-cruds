package com.springcore.springcoredemo.config;

import com.springcore.springcoredemo.common.Coach;
import com.springcore.springcoredemo.common.SwimCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SportConfig {

    @Bean("aquatic") //custom id
    public Coach swimCoach(){
        return new SwimCoach();
    }
}
