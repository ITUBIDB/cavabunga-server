package edu.itu.cavabunga.controller.wrapper;

import edu.itu.cavabunga.core.entity.Participant;

import java.util.ArrayList;
import java.util.List;

public class ParticipantResponse {
    private Integer status;
    private String message;
    private List<Participant> data = new ArrayList<Participant>();

    public ParticipantResponse(Integer status, String message, List<Participant> data) {
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

    public List<Participant> getData() {
        return data;
    }

    public void setData(List<Participant> data) {
        this.data = data;
    }
}
