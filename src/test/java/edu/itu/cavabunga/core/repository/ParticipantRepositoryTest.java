package edu.itu.cavabunga.core.repository;

import edu.itu.cavabunga.core.entity.Participant;
import edu.itu.cavabunga.core.factory.ParticipantFactory;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class ParticipantRepositoryTest {


    @Autowired
    ParticipantFactory participantFactory;

    @Autowired
    ParticipantRepository participantRepository;

    @Before
    public void setUp() {
        participantRepository.deleteAll();
        Participant testParticipant = participantFactory.createUser("testuser");
        participantRepository.save(testParticipant);
    }

    @Test
    public void findByUserNameTest() {
        assertEquals("testuser",
                participantRepository.findByUserName("testuser").getUserName()
        );
    }
    @Test
    public void findByUuidTest() {
        Participant testParticipant = participantRepository.findByUserName("testuser");
        assertEquals("testuser",
                participantRepository.findByUuid(testParticipant.getUuid()).getUserName()
        );
    }


}
