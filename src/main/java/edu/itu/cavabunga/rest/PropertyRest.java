package edu.itu.cavabunga.rest;

import java.util.List;

public class PropertyRest {
    private Integer id;
    private String name;
    private String value;
    private List<ParameterRest> parameters;

    public List<ParameterRest> getParameters() {
        return parameters;
    }

    public void setParameters(List<ParameterRest> parameters) {
        this.parameters = parameters;
    }

    public void addParameter(ParameterRest parameter){
        this.parameters.add(parameter);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
