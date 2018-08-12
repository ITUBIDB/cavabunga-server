package tr.edu.itu.cavabunga.server.controller;

import tr.edu.itu.cavabunga.server.business.CalendarManagerService;
import tr.edu.itu.cavabunga.lib.entity.Component;
import tr.edu.itu.cavabunga.lib.entity.Parameter;
import tr.edu.itu.cavabunga.lib.entity.Property;
import tr.edu.itu.cavabunga.lib.entity.component.ComponentType;
import tr.edu.itu.cavabunga.lib.entity.parameter.ParameterType;
import tr.edu.itu.cavabunga.lib.entity.participant.ParticipantType;
import tr.edu.itu.cavabunga.lib.entity.property.PropertyType;
import tr.edu.itu.cavabunga.server.service.ElementService;
import tr.edu.itu.cavabunga.server.service.ParticipantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/seeddb")
public class SeederController {
    @Autowired
    private CalendarManagerService calendarManagerService;

    @Autowired
    private ParticipantService participantService;

    @Autowired
    private ElementService elementService;

    @GetMapping
    @Transactional
    public String seedDataBase(){
        participantService.saveParticipant(participantService.createParticipant("testuser", ParticipantType.User));
        participantService.saveParticipant(participantService.createParticipant("testgroup", ParticipantType.Group));


        Component calendar = elementService.createComponent(ComponentType.Calendar);
            Property prodid = elementService.createProperty(PropertyType.Prodid);
                prodid.setValue("-//Test Inc//Cavabunga Calendar//");
            //Property version = elementService.createProperty(PropertyType.Version);
              //  version.setValue("2.0");
            Property calscale = elementService.createProperty(PropertyType.Calscale);
                calscale.setValue("GREGORIAN");
            Property method = elementService.createProperty(PropertyType.Method);
                method.setValue("PUBLISH");
        calendar.addProperty(prodid);
        //calendar.addProperty(version); //TODO: THERE IS A BUG IN PROPERTY ABST. CLASS, VERSION MUST NOT BE JAVA.PERSISTENT CLASS
        calendar.addProperty(calscale);
        calendar.addProperty(method);

        calendar.setOwner(calendarManagerService.getParticipantByUserName("testuser"));


        Component timezone = elementService.createComponent(ComponentType.Timezone);
            Property tzid = elementService.createProperty(PropertyType.Tzid);
                tzid.setValue("Europe/Istanbul");
            timezone.addProperty(tzid);
                Component standard = elementService.createComponent(ComponentType.Standard);
                    Property tzoffsetfrom = elementService.createProperty(PropertyType.Tzoffsetfrom);
                        tzoffsetfrom.setValue("+0300");
                    Property tzoffsetto = elementService.createProperty(PropertyType.Tzoffsetto);
                        tzoffsetto.setValue("+0300");
                    Property tzname = elementService.createProperty(PropertyType.Tzname);
                        tzname.setValue("+03");
                    standard.addProperty(tzoffsetfrom);
                    standard.addProperty(tzoffsetto);
                    standard.addProperty(tzname);
            timezone.addComponent(standard);
        calendar.addComponent(timezone);

        Component event = elementService.createComponent(ComponentType.Event);
            Property dtstart = elementService.createProperty(PropertyType.Dtstart);
                dtstart.setValue("20160423T170000Z");
            Property dtend = elementService.createProperty(PropertyType.Dtend);
                dtend.setValue("20160423T180000Z");
            Property dtstamp = elementService.createProperty(PropertyType.Dtstamp);
                dtstamp.setValue("20180520T181535Z");
            Property organizer = elementService.createProperty(PropertyType.Organizer);
                organizer.setValue("mailto:unknownorganizer@calendar.cavabunga.com");
                    Parameter cn = elementService.createParameter(ParameterType.Cn);
                        cn.setValue("unknownorganizer@calendar.google.com");
                organizer.addParameter(cn);
            Property uid = elementService.createProperty(PropertyType.Uid);
                uid.setValue("7kukuqrfedlm2f9t0vr42q2qc8cm9l3o7vn9g00q3j3s5mhdo2ovuahsd9hf54qk3j60");
            Property attendee = elementService.createProperty(PropertyType.Acknowledged); //TODO: ATTENDEE CLASS MUST ADD AS A JSON SUBTYPE IN SUPER CLASS
                attendee.setValue("mailto:dgkncelik@gmail.com");
                Parameter cutype = elementService.createParameter(ParameterType.Cutype);
                    cutype.setValue("INDIVIDUAL");
                Parameter role = elementService.createParameter(ParameterType.Role);
                    role.setValue("REQ-PARTICIPANT");
                Parameter partstat = elementService.createParameter(ParameterType.Partstat);
                    partstat.setValue("ACCEPTED");
                attendee.addParameter(cutype);
                attendee.addParameter(role);
                attendee.addParameter(partstat);
            Property classs = elementService.createProperty(PropertyType.Class);
                classs.setValue("PRIVATE");
            Property created = elementService.createProperty(PropertyType.Created);
                created.setValue("20160111T065955Z");
            Property description = elementService.createProperty(PropertyType.Description);
                description.setValue("---description_here---");
            Property lastmod = elementService.createProperty(PropertyType.Lastmod);
                lastmod.setValue("20160112T053844Z");
            Property seq = elementService.createProperty(PropertyType.Seq);
                seq.setValue("0");
            event.addProperty(dtstart);
            event.addProperty(dtend);
            event.addProperty(dtstamp);
            event.addProperty(organizer);
            event.addProperty(uid);
            event.addProperty(attendee);
            event.addProperty(classs);
            event.addProperty(created);
            event.addProperty(description);
            event.addProperty(lastmod);
            event.addProperty(seq);
            calendar.addComponent(event);

            elementService.saveComponent(calendar);

            return "ok";
    }
}
