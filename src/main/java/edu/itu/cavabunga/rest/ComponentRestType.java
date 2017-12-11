package edu.itu.cavabunga.rest;

public enum ComponentRestType {
    EVENT ("event"),
    TODO ("todo"),
    JOURNAL("journal"),
    FREEBUSY("freebusy"),
    TIMEZONE("timezone"),
    ALARM("alarm"),
    STANDARD("standard"),
    DAYLIGHT("daylight");

    private final String name;

    private ComponentRestType(String s){
        name = s;
    }

    public boolean equalsName(String checkName){
        return name.equals(checkName);
    }

    public String toString(){
        return this.name;
    }

}
