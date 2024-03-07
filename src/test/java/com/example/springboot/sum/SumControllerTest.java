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
        int[] numbers = {1, 2, 3, 4, 5};
        ResponseEntity<SumResponse> response = restTemplate.postForEntity("/sum", numbers, SumResponse.class);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(15, response.getBody().getResult());
    }

    @Test
    public void testSumNumbersWithEmptyList() {
        int[] numbers = {};
        ResponseEntity<SumResponse> response = restTemplate.postForEntity("/sum", numbers, SumResponse.class);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(0, response.getBody().getResult());
    }

    @Test
    public void testSumNumbersWithSingleNumber() {
        int[] numbers = {10};
        ResponseEntity<SumResponse> response = restTemplate.postForEntity("/sum", numbers, SumResponse.class);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(10, response.getBody().getResult());
    }
}