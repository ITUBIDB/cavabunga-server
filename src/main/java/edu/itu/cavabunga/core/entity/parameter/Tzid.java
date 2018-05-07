package edu.itu.cavabunga.core.entity.parameter;

import edu.itu.cavabunga.core.entity.Parameter;

import javax.persistence.Entity;

@Entity
public class Tzid extends Parameter {
    @Override
    public void validate(){
        //TODO: RFC 5545 must implemented
    }
}
