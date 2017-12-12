package edu.itu.cavabunga.core.factory;

import edu.itu.cavabunga.core.entity.Parameter;
import edu.itu.cavabunga.core.entity.parameter.ParameterType;
import org.springframework.stereotype.Component;

@Component
public class ParameterFactory {

    public Parameter createParameter(ParameterType parameterType) {
        return parameterType.create();
    }
}