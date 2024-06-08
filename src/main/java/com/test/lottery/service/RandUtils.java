package com.test.lottery.service;

import org.springframework.web.client.RestTemplate;

import java.util.Objects;

public class RandUtils {

    private static final String randQuarry = "https://www.random.org/integers/?num=1&min=1&max=1000&col=3&base=10&format=plain&rnd=new";

    public static Integer getRandInt(Integer max){
        String randQuarryMod = randQuarry.replace("1000", max.toString());
        RestTemplate restTemplate = new RestTemplate();
        String str = (restTemplate.getForObject(randQuarryMod, String.class));
        str = str.replaceAll("\t","");
        return Integer.parseInt(Objects.requireNonNull(str));
    }




}
