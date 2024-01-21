package org.metadata.integration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;


@SpringBootApplication
@EntityScan("org.metadata.integration.model")
public class UnifiedMediaApplication
{
    public static void main(String[] args) {
        SpringApplication.run(UnifiedMediaApplication.class, args);
    }
}
