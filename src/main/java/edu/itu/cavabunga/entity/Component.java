package edu.itu.cavabunga.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Component {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String component_type;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "calendar_id")
    private Calendar calendar;

    public Calendar getCalendar() {
        return calendar;
    }

    public void setCalendar(Calendar calendar) {
        this.calendar = calendar;
    }

    public Long getId() {
        return id;
    }

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "component")
    private List<Property> properties = new ArrayList<Property>();

    public List<Property> getProperties() {
        return properties;
    }

    public void setProperties(List<Property> properties) {
        this.properties = properties;
    }

    public void addProperty(Property property){
        properties.add(property);
        property.setComponent(this);
    }

    public void removeProperyu(Property property){
        properties.remove(property);
        property.setComponent(null);
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
}
