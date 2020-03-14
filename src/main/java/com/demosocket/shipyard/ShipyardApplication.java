package com.demosocket.shipyard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.Configuration;

@Configuration
@SpringBootApplication(exclude = HibernateJpaAutoConfiguration.class)
public class ShipyardApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShipyardApplication.class, args);
    }
}

