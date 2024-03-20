package com.example.springboot;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;

@RestController
class KillController {
    private final Logger logger = LoggerFactory.getLogger(KillController.class);

    @GetMapping(value = "/kill", produces = MediaType.TEXT_PLAIN_VALUE)
    String killMe() {
        CompletableFuture.runAsync(this::sayonara);
        return "Goodbye!";
    }

    private void sayonara() {
        logger.info("About to shutdown the app");
        System.exit(0);
    }
}
