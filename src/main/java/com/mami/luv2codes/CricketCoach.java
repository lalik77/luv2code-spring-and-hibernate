package com.mami.luv2codes;

public class CricketCoach implements Coach {

    private FortuneService fortuneService;

    private String email;
    private String team;


    public CricketCoach() {

        System.out.println("Inside no arg constructor CricketCoach.class");
    }

    public void setFortuneService(FortuneService fortuneService) {

        System.out.println("Inside setter method CricketCoach.class");

        this.fortuneService = fortuneService;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public String getDailyWorkout() {
        return "Practice fast bowling for 15 minutes";
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
