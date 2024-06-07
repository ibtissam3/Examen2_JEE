package com.example.sprinng__crud.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@ComponentScan(basePackages = {"com.example.sprinng__crud"})
public class RootConfig {
    // Autres configurations de Spring
}
