package edu.itu.cavabunga.core.controller.wrapper;

import edu.itu.cavabunga.core.entity.Component;

import java.util.ArrayList;
import java.util.List;

public class CalendarResponse {
    private Integer status;
    private String message;
    private List<Component> data = new ArrayList<Component>();

    public CalendarResponse(Integer status, String message, List<Component> data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<Component> getData() {
        return data;
    }

    public void setData(List<Component> data) {
        this.data = data;
    }
}
