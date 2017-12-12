package edu.itu.cavabunga.core.factory;

import edu.itu.cavabunga.core.entity.Participant;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ParticipantFactory {
    public Participant createUser(String user_name){
        return new Participant(user_name);
    }

    public Participant createUser(){
        return new Participant();
    }
}
