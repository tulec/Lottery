package com.test.lottery.service;

import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;
import java.util.Objects;

public class RandUtils {

    private static final String randQuarry = "https://www.random.org/integers/?num=1&min=1&max=1000&col=3&base=10&format=plain&rnd=new";
    private static final RestTemplate restTemplate = new RestTemplate();

    public static Integer getRandInt(Integer max) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.TEXT_PLAIN);

        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<String> response = restTemplate.exchange(randQuarry.replace("1000", max.toString()), HttpMethod.GET, entity, String.class);

        if (response.getStatusCode() == HttpStatus.OK) {
            String str = response.getBody().replaceAll("\t", "");
            return Objects.requireNonNull(str).isEmpty() ? null : Integer.parseInt(str);
        }
        throw new RuntimeException("Failed to retrieve random integer");
    }
}
