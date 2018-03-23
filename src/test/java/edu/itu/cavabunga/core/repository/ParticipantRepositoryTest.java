package edu.itu.cavabunga.core.repository;

import edu.itu.cavabunga.core.entity.Participant;
import edu.itu.cavabunga.core.entity.participant.Group;
import edu.itu.cavabunga.core.entity.participant.ParticipantType;
import edu.itu.cavabunga.core.entity.participant.User;
import edu.itu.cavabunga.core.factory.ParticipantFactory;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;
@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class ParticipantRepositoryTest {

    @Autowired
    ParticipantFactory participantFactory;

    @Autowired
    ParticipantRepository participantRepository;

    @Before
    public void setUp(){
        participantRepository.deleteAll();
        Participant testUser = participantFactory.createParticipant(ParticipantType.User);
        testUser.setUserName("testuser");

        Participant testGroup = participantFactory.createParticipant(ParticipantType.Group);
        testGroup.setUserName("testgroup");

        participantRepository.save(testUser);
        participantRepository.save(testGroup);
    }


}
