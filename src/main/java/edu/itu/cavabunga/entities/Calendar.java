package edu.itu.cavabunga.entities;

import javax.persistence.*;
import java.util.List;

@Entity
public class Calendar {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String calscale;

    private String method;

    private String prodid;

    private Float version;

    private String x_prop;

    private String user_name;

    private String calendar_name;

    private List<Component> component_list;

    @OneToMany(mappedBy = "calendar", cascade = CascadeType.ALL)
    public void setComponent_list(List<Component> component_list) {
        this.component_list = component_list;
    }

    public List<Component> getComponent_list() {
        return component_list;
    }

    public String getCalendar_name() {
        return calendar_name;
    }

    public void setCalendar_name(String calendar_name) {
        this.calendar_name = calendar_name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCalscale() {
        return calscale;
    }

    public void setCalscale(String calscale) {
        this.calscale = calscale;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getProdid() {
        return prodid;
    }

    public void setProdid(String prodid) {
        this.prodid = prodid;
    }

    public Float getVersion() {
        return version;
    }

    public void setVersion(Float version) {
        this.version = version;
    }

    public String getX_prop() {
        return x_prop;
    }

    public void setX_prop(String x_prop) {
        this.x_prop = x_prop;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

}
