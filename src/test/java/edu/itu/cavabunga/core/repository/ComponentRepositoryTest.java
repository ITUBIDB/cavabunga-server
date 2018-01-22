package edu.itu.cavabunga.core.repository;

import edu.itu.cavabunga.core.entity.Component;
import edu.itu.cavabunga.core.entity.Participant;
import edu.itu.cavabunga.core.entity.component.ComponentType;
import edu.itu.cavabunga.core.factory.ComponentFactory;
import edu.itu.cavabunga.core.factory.ParticipantFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;


import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class ComponentRepositoryTest {

    @Autowired
    ComponentFactory componentFactory;

    @Autowired
    ParticipantFactory participantFactory;

    @Autowired
    ComponentRepository componentRepository;

    @Autowired
    ParticipantRepository participantRepository;

    @Before
    public void setUp() {
        participantRepository.deleteAll();
        componentRepository.deleteAll();
        Participant testParticipant = participantFactory.createUser("testuser");
        participantRepository.save(testParticipant);
    }

    @Test
    public void saveTest() {
        Component testComponent = componentFactory.createComponent(ComponentType.CALENDAR);
        Participant testParticipant = participantRepository.findByUserName("testuser");
        testComponent.setOwner(testParticipant);
        assertEquals(0, componentRepository.findByOwner(testParticipant).size());
        componentRepository.save(testComponent);
        assertEquals(1, componentRepository.findByOwner(testParticipant).size());
        assertEquals(
                componentRepository.findByOwner(testParticipant).get(0),
                componentRepository.findById(componentRepository.findByOwner(testParticipant).get(0).getId())
        );
    }

}
