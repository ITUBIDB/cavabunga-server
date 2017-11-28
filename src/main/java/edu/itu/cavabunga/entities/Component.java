package edu.itu.cavabunga.entities;

import javax.persistence.*;

@Entity
public class Component {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String component_type;

    private Calendar calendar;

    private Integer calendar_id;

    public Integer getCalendar_id() {
        return calendar_id;
    }

    public void setCalendar_id(Integer calendar_id) {
        this.calendar_id = calendar_id;
    }

    @ManyToOne
    @JoinColumn(name = "calendar_id")
    public Calendar getCalendar() {
        return calendar;
    }

    public void setCalendar(Calendar calendar) {
        this.calendar = calendar;
    }

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
