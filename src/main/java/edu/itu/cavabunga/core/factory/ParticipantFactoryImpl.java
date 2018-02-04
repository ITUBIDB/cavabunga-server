package edu.itu.cavabunga.core.factory;

import edu.itu.cavabunga.core.entity.Participant;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ParticipantFactoryImpl implements ParticipantFactory {
    @Override
    public Participant createUser(){
        return new Participant();
    }
}
