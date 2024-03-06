package com.example.springboot.hello;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@EnableConfigurationProperties(HelloProperties.class)
@Configuration(proxyBeanMethods = false)
class HelloConfig {
}
