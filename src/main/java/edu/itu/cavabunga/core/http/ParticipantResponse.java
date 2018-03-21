package edu.itu.cavabunga.core.http;

import edu.itu.cavabunga.core.entity.Participant;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class ParticipantResponse extends Response {

    private List<Participant> data = new ArrayList <>();

    public ParticipantResponse(Integer code, String message, List<Participant> data) {
        super(code, message);
        this.data = data;
    }

    public ParticipantResponse(Integer code, String message, Participant data) {
        super(code, message);
        this.data.add(data);
    }
}
