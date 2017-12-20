package edu.itu.cavabunga.core.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class Component {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String componentType;

    @ManyToOne(optional = true, cascade = CascadeType.ALL)
    @JoinColumn(name="owner_uuid")
    @JsonBackReference(value = "participantAndComponent")
    private Participant owner;

    @ManyToOne(optional = true, cascade = CascadeType.ALL)
    @JoinColumn(name="parent_id")
    @JsonBackReference
    private Component componentToComponentMap;

    @OneToMany(mappedBy = "componentToComponentMap")
    @JsonManagedReference
    private List<Component> components = new ArrayList<Component>();

    @OneToMany(mappedBy = "componentToPropertyMap")
    @JsonManagedReference
    private List<Property> properties = new ArrayList<Property>();

    private Date creationDate;

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getComponentType() {
        return componentType;
    }

    public void setComponentType(String componentType) {
        this.componentType = componentType;
    }

    public Participant getOwner() {
        return owner;
    }

    public void setOwner(Participant owner) {
        this.owner = owner;
    }

    public Component getComponentToComponentMap() {
        return componentToComponentMap;
    }

    public void setComponentToComponentMap(Component componentToComponentMap) {
        this.componentToComponentMap = componentToComponentMap;
    }

    public List<Component> getComponents() {
        return components;
    }

    public void setComponents(List<Component> components) {
        this.components = components;
    }

    public void addComponent(Component component){
        component.setComponentToComponentMap(this);
        components.add(component);
    }

    public List<Property> getProperties() {
        return properties;
    }

    public void setProperties(List<Property> properties) {
        this.properties = properties;
    }

    public void addProperty(Property property){
        property.setComponentToPropertyMap(this);
        properties.add(property);
    }

    public boolean validate(){
        return true;
    }
}
