package edu.itu.cavabunga.service;

import edu.itu.cavabunga.entity.Component;
import edu.itu.cavabunga.entity.Parameter;
import edu.itu.cavabunga.entity.Property;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class FactoryService {

    @Bean
    @Scope(value = "prototype")
    public Component createComponent(){
        return new Component();
    }

    @Bean
    @Scope(value = "prototype")
    public Parameter createParameter(){
        return new Parameter();
    }
    
    @Bean
    @Scope(value = "prototype")
    public Property createProperty(){
        return new Property();
    }
}
