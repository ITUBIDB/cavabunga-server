package edu.itu.cavabunga.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
public class Property {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String p_value;

    private String p_key;

    public String getP_key() {
        return p_key;
    }

    public void setP_key(String p_key) {
        this.p_key = p_key;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "component_id")
    @JsonBackReference
    private Component parent_component;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getP_value() {
        return p_value;
    }

    public void setP_value(String p_value) {
        this.p_value = p_value;
    }

    public Component getParent_component() {
        return parent_component;
    }

    public void setParent_component(Component parent_component) {
        this.parent_component = parent_component;
    }
}
