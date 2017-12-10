package edu.itu.cavabunga.caldav.rest;

import java.util.ArrayList;
import java.util.List;

public class CalendarRest {
    private String calendarName;
    private ParticipantRest participant;
    private List<PropertyRest> properties = new ArrayList<PropertyRest>();
    private List<EventRest> event = new ArrayList<EventRest>();
    private List<TodoRest> todo  = new ArrayList<TodoRest>();
    private List<JournalRest> journal = new ArrayList<JournalRest>();
    private List<FreebusyRest> freebusy = new ArrayList<FreebusyRest>();
    private List<TimezoneRest> timezone = new ArrayList<TimezoneRest>();
    private List<AlarmRest> alarm = new ArrayList<AlarmRest>();
    private List<StandardRest> standard = new ArrayList<StandardRest>();
    private List<DaylightRest> daylight = new ArrayList<DaylightRest>();

    public List<PropertyRest> getProperties() {
        return properties;
    }

    public void setProperties(List<PropertyRest> properties) {
        this.properties = properties;
    }

    public void addProperty(PropertyRest property){
        this.properties.add(property);
    }

    public List<EventRest> getEvent() {
        return event;
    }

    public void setEvent(List<EventRest> event) {
        this.event = event;
    }

    public void addEvent(EventRest event){
        this.event.add(event);
    }

    public List<TodoRest> getTodo() {
        return todo;
    }

    public void setTodo(List<TodoRest> todo) {
        this.todo = todo;
    }

    public void addTodo(TodoRest todo){
        this.todo.add(todo);
    }

    public List<JournalRest> getJournal() {
        return journal;
    }

    public void setJournal(List<JournalRest> journal) {
        this.journal = journal;
    }

    public void addJournal(JournalRest journal){
        this.journal.add(journal);
    }

    public List<FreebusyRest> getFreebusy() {
        return freebusy;
    }

    public void setFreebusy(List<FreebusyRest> freebusy) {
        this.freebusy = freebusy;
    }

    public void addFreebusy(FreebusyRest freebusy){
        this.freebusy.add(freebusy);
    }

    public List<TimezoneRest> getTimezone() {
        return timezone;
    }

    public void setTimezone(List<TimezoneRest> timezone) {
        this.timezone = timezone;
    }

    public void addTimezone(TimezoneRest timezone){
        this.timezone.add(timezone);
    }

    public List<AlarmRest> getAlarm() {
        return alarm;
    }

    public void setAlarm(List<AlarmRest> alarm) {
        this.alarm = alarm;
    }

    public void addAlarm(AlarmRest alarm){
        this.alarm.add(alarm);
    }

    public List<StandardRest> getStandard() {
        return standard;
    }

    public void setStandard(List<StandardRest> standard) {
        this.standard = standard;
    }

    public void addStandard(StandardRest standard){
        this.standard.add(standard);
    }

    public List<DaylightRest> getDaylight() {
        return daylight;
    }

    public void setDaylight(List<DaylightRest> daylight) {
        this.daylight = daylight;
    }

    public void addDaylight(DaylightRest daylight){
        this.daylight.add(daylight);
    }

    public String getCalendarName() {
        return calendarName;
    }

    public void setCalendarName(String calendarName) {
        this.calendarName = calendarName;
    }

    public ParticipantRest getParticipant() {
        return participant;
    }

    public void setParticipant(ParticipantRest participant) {
        this.participant = participant;
    }
}
