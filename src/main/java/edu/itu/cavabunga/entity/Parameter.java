package edu.itu.cavabunga.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
public abstract class Parameter {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String value;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "property_id")
    @JsonBackReference
    private Property parent_property;

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

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Property getParent_property() {
        return parent_property;
    }

    public void setParent_property(Property parent_property) {
        this.parent_property = parent_property;
    }
}
