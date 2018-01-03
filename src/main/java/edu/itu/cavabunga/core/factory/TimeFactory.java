package edu.itu.cavabunga.core.factory;

import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class TimeFactory implements ITimeFactory{

    @Override
    public Date getTime() {
        return new Date();
    }
}
