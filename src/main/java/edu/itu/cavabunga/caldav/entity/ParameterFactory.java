package edu.itu.cavabunga.caldav.entity;

import edu.itu.cavabunga.caldav.entity.parameter.ParameterType;
import org.springframework.stereotype.Component;

@Component
public class ParameterFactory {

    public Parameter createParameter(ParameterType parameterType) {
        return parameterType.create();
    }
}