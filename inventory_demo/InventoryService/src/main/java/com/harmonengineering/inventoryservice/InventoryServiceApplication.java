package com.harmonengineering.inventoryservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages = "com.harmonengineering.entity")
@EntityScan("com.harmonengineering.entity")
@SpringBootApplication(scanBasePackages =
        { "com.harmonengineering","com.harmonengineering.entity",

                "com.harmonengineering.controller",

        },
        exclude = { SecurityAutoConfiguration.class })

public class InventoryServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(InventoryServiceApplication.class, args);
    }

}
