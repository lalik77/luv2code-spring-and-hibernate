package com.mami.luv2codes;

import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach {

    @Override
    public String getDailyWorkout() {
        return " Practice backhand volley";
    }

    @Override
    public String getDailyFortune() {
        return null;
    }
}
