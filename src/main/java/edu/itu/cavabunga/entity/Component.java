package edu.itu.cavabunga.entity;

import javax.persistence.*;

@Entity
public class Component {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String component_type;

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
}
