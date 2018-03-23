package edu.itu.cavabunga.core.http;

import edu.itu.cavabunga.core.entity.ParticipantProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ParticipantPropertyResponse extends Response{
    private List<ParticipantProperty> data;

    public ParticipantPropertyResponse(Integer code, String message, List<ParticipantProperty> data) {
        super(code, message);
        this.data = data;
    }
}
