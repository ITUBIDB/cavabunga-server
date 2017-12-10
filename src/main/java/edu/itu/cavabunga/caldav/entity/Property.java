package edu.itu.cavabunga.caldav.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public abstract class Property {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String value;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "component_id")
    @JsonBackReference
    private Component componentToPropertyMap;

    @OneToMany(mappedBy = "propertyToParameterMap")
    @JsonManagedReference
    private List<Parameter> parameters = new ArrayList<Parameter>();

    public List<Parameter> getParameters() {
        return parameters;
    }

    public void setParameters(List<Parameter> parameters) {
        this.parameters = parameters;
    }

    public void addParameter(Parameter parameter){
        parameter.setPropertyToParameterMap(this);
        parameters.add(parameter);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Component getComponentToPropertyMap() {
        return componentToPropertyMap;
    }

    public void setComponentToPropertyMap(Component componentToPropertyMap) {
        this.componentToPropertyMap = componentToPropertyMap;
    }
}
