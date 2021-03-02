package com.mami.luv2codes;

public class TrackCoach implements Coach{

    private FortuneService fortuneService;

    public TrackCoach() {
    }

    public TrackCoach(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }

    public String getDailyWorkout() {
        return "Run a hard 5k";

    }

    public String getDailyFortune() {
        return "Just do it " + fortuneService.getFortune();
    }

    // init method

    public void myInit () {

        System.out.println("My init is called");
    }

    //destroy method

    public void myDestroy () {

        System.out.println("My destroy is called");
    }


}
