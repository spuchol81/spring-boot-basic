package com.example.springboot.sum;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SumController {

    @GetMapping("/sum")
    public SumResponse getSum(@RequestParam("numbers") int[] numbers) {
        int sum = calculateSum(numbers);
        return new SumResponse(sum);
    }

    private int calculateSum(int[] numbers) {
        int sum = 0;
        for (int num : numbers) {
            sum += num;
        }
        return sum;
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