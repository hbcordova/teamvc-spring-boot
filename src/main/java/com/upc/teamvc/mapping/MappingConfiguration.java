package com.upc.teamvc.mapping;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.Serializable;

@Configuration("teamvcMappingConfiguration")
public class MappingConfiguration implements Serializable {
    @Bean
    public UserMapper productMapper() {
        return new UserMapper();
    }
}
