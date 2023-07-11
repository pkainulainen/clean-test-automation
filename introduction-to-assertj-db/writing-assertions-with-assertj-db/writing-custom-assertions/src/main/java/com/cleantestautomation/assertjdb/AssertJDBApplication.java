package com.cleantestautomation.assertjdb;

import com.cleantestautomation.assertjdb.common.ConstantDateTimeService;
import com.cleantestautomation.assertjdb.common.DateTimeService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

@SpringBootApplication
public class AssertJDBApplication {

    public static void main(String[] args) {
        SpringApplication.run(AssertJDBApplication.class, args);
    }

    @Profile("integrationTest")
    @Bean
    public DateTimeService dateTimeService() {
        return new ConstantDateTimeService();
    }
}
