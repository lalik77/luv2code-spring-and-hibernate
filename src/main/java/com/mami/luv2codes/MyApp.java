package com.mami.luv2codes;

public class MyApp {

    public static void main(String[] args) {

        BaseballCoach baseballCoach = new BaseballCoach();

        TrackCoach trackCoach = new TrackCoach() ;

        System.out.println(baseballCoach.getDailyWorkout());

        System.out.println(trackCoach.getDailyWorkout());
    }
}
