package edu.itu.cavabunga.entity;

import edu.itu.cavabunga.entity.parameter.ParameterType;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ParameterFactory {

    public Parameter createParameter(ParameterType parameterType) {
        return parameterType.create();
    }
}