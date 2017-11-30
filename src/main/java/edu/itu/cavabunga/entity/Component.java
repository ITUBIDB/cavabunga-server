package edu.itu.cavabunga.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public abstract class Component {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String component_type;

    private String owner;

    @ManyToOne(optional = true, cascade = CascadeType.ALL)
    @JoinColumn(name="parent_id")
    @JsonBackReference
    private Component sub_component;

    @OneToMany(mappedBy = "sub_component")
    @JsonManagedReference
    private List<Component> components = new ArrayList<Component>();

    @OneToMany(mappedBy = "parent_component")
    @JsonManagedReference
    private List<Property> properties = new ArrayList<Property>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getComponent_type() {
        return component_type;
    }

    public void setComponent_type(String component_type) {
        this.component_type = component_type;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public Component getSub_component() {
        return sub_component;
    }

    public void setSub_component(Component sub_component) {
        this.sub_component = sub_component;
    }

    public List<Component> getComponents() {
        return components;
    }

    public void setComponents(List<Component> components) {
        this.components = components;
    }

    public void addComponent(Component component){
        component.setSub_component(this);
        components.add(component);
    }

    public List<Property> getProperties() {
        return properties;
    }

    public void setProperties(List<Property> properties) {
        this.properties = properties;
    }

    public void addProperty(Property property){
        property.setParent_component(this);
        properties.add(property);
    }
}
