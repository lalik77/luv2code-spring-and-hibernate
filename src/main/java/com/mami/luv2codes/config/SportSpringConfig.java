package com.mami.luv2codes.config;

import com.mami.luv2codes.FortuneService;
import com.mami.luv2codes.SadFortuneService;
import com.mami.luv2codes.SwimCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration

public class SportSpringConfig {

    @Bean
    public FortuneService sadFortineServie() {

        return new SadFortuneService();
    }


    @Bean
    public SwimCoach swimCoach(){

        return new SwimCoach(sadFortineServie());
    }



}
