package edu.itu.cavabunga.core.controller;

import edu.itu.cavabunga.core.entity.Component;

import java.util.ArrayList;
import java.util.List;

public class TestResult {
    private String status;
    private String message;
    private List<Component> data = new ArrayList<Component>();

    public TestResult(String status, String message, List<Component> data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
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
