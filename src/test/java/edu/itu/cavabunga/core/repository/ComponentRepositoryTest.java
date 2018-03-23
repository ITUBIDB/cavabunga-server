package edu.itu.cavabunga.core.repository;

import edu.itu.cavabunga.core.entity.Component;
import edu.itu.cavabunga.core.entity.Participant;
import edu.itu.cavabunga.core.entity.component.*;
import edu.itu.cavabunga.core.entity.participant.ParticipantType;
import edu.itu.cavabunga.core.factory.ComponentFactory;
import edu.itu.cavabunga.core.factory.ParticipantFactory;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static edu.itu.cavabunga.core.entity.component.ComponentType.Calendar;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional

public class ComponentRepositoryTest {
    @Autowired
    ParticipantFactory participantFactory;

    @Autowired
    ComponentFactory componentFactory;

    @Autowired
    ParticipantRepository participantRepository;

    @Autowired
    ComponentRepository componentRepository;

    @Before
    public void setUp(){
        Participant testUser = participantFactory.createParticipant(ParticipantType.User);
        testUser.setUserName("testuser");

        Component calendar = componentFactory.createComponent(Calendar);
            calendar.setOwner(testUser);
            calendar.setParent(null);
            componentRepository.save(calendar);

        Component event = componentFactory.createComponent(ComponentType.Event);
            event.setOwner(testUser);
            event.setParent(calendar);
            componentRepository.save(event);

        Component journal = componentFactory.createComponent(ComponentType.Journal);
            journal.setOwner(testUser);
            journal.setParent(calendar);
            componentRepository.save(journal);


        Component timezone = componentFactory.createComponent(ComponentType.Timezone);
            timezone.setOwner(testUser);
            timezone.setParent(event);
            componentRepository.save(timezone);

        Component todo = componentFactory.createComponent(ComponentType.Todo);
            todo.setOwner(testUser);
            todo.setParent(calendar);
            componentRepository.save(todo);

        Component alarm = componentFactory.createComponent(ComponentType.Alarm);
            alarm.setOwner(testUser);
            alarm.setParent(todo);
            componentRepository.save(alarm);

        Component daylight = componentFactory.createComponent(ComponentType.Daylight);
            daylight.setOwner(testUser);
            daylight.setParent(calendar);
            componentRepository.save(daylight);

        Component freebusy = componentFactory.createComponent(ComponentType.Freebusy);
            freebusy.setOwner(testUser);
            freebusy.setParent(calendar);
            componentRepository.save(freebusy);

        Component standard = componentFactory.createComponent(ComponentType.Standard);
            standard.setOwner(testUser);
            standard.setParent(calendar);
            componentRepository.save(standard);

    }

}
