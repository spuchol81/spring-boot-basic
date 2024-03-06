package com.example.springboot.hello;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@ConfigurationProperties(prefix = "app.hello")
record HelloProperties(
        String greetings
) {
}
