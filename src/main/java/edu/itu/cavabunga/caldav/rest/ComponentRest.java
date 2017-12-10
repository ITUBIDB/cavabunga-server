package edu.itu.cavabunga.caldav.rest;

import java.util.ArrayList;
import java.util.List;

public abstract class ComponentRest {
    private String type;
    private Integer id;
    private List<PropertyRest> properties = new ArrayList<PropertyRest>();

    public List<PropertyRest> getProperties() {
        return properties;
    }

    public void setProperties(List<PropertyRest> properties) {
        this.properties = properties;
    }

    public void addProperty(PropertyRest property){
        this.properties.add(property);
    }

    public ComponentRest(){

    }

    public ComponentRest(String type){
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
