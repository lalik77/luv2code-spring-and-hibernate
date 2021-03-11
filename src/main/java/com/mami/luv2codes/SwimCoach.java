package com.mami.luv2codes;

import org.springframework.beans.factory.annotation.Value;

public class SwimCoach {

    @Value("${foo.email}")
    private String email;

    @Value("${foo.team}")
    private String team;


  FortuneService fortuneService;

    public SwimCoach() {
    }

    public SwimCoach(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }

    public String getDailyWorkout() {

        return "Swim 1000 meters as warm up";

    }

    public String getDailyFortune() {

        return fortuneService.getFortune();

    }

    public String getEmail() {
        return email;
    }

    public String getTeam() {
        return team;
    }
}
