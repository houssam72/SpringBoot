package com.houssam.customer;

import com.houssam.serverProperties.ServerProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@Configuration
public class CustomerConfiguration {

    @Value("${app.useFakeCustomerRepo:false}")
    private Boolean useFakeCustomerRepo;

    @Value("${spring.datasource.username}")
    private String dataSourceUserName;

    @Autowired
    private Environment environment;

    @Bean
    CommandLineRunner commandLineRunner(ServerProperties serverProperties){
        return args ->{
            System.out.println("Command line runner hooray");
            System.out.println("DataUserName: "+dataSourceUserName);
            System.out.println("server port: "+environment.getProperty("server.port"));
            System.out.println("SprinfProperties: "+ serverProperties.getPort());
        };
    }


}
