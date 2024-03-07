package com.example.springboot.sum;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SumController {

    @PostMapping("/sum")
    public SumResponse sumNumbers(@RequestBody List<Integer> numbers) {
        int sum = 0;
        for (int num : numbers) {
            sum += num;
        }
        return new SumResponse(sum);
    }

    public static class SumResponse {
        private int result;

        public SumResponse() {
            // Default constructor needed for deserialization
        }

        public SumResponse(int result) {
            this.result = result;
        }

        public int getResult() {
            return result;
        }

        public void setResult(int result) {
            this.result = result;
        }
    }
}