package com.example.springboot.sum;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.example.springboot.sum.SumController.SumResponse;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(
    classes = SumApplication.class,
    webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SumControllerTest {


    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testSumNumbers() {
        ResponseEntity<SumResponse> response = restTemplate.getForEntity("/sum?numbers=1&numbers=2&numbers=3&numbers=4&numbers=5", SumController.SumResponse.class);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(15, response.getBody().getResult());
    }

    @Test
    public void testSumNumbersWithEmptyList() {
        ResponseEntity<SumResponse> response = restTemplate.getForEntity("/sum", SumController.SumResponse.class);
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
    }

    @Test
    public void testSumNumbersWithSingleNumber() {
        ResponseEntity<SumResponse> response = restTemplate.getForEntity("/sum?numbers=10", SumController.SumResponse.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(10, response.getBody().getResult());
    }
}