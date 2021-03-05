package com.mami.luv2codes;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class RandomFortuneService implements FortuneService {



    String [] fortunes = {"My chance 1", "My chance 2", "My chance 3"};

    Random random = new Random();



    @Override
    public String getFortune() {

        int index = random.nextInt(fortunes.length);

        String string = fortunes[index];

        return string;
    }
}
