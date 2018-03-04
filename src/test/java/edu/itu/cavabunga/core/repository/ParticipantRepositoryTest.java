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

    @Test
    public void findOneTest(){
        Participant testUser = participantRepository.findByUserName("testuser");
        assertEquals("testuser",participantRepository.findOne(testUser.getId()).getUserName());

        Participant testGroup = participantRepository.findByUserName("testgroup");
        assertEquals("testgroup", participantRepository.findOne(testGroup.getId()).getUserName());
    }

    @Test
    public void findByTypeTest(){
        assertThat(participantRepository.findByType(ParticipantType.User.toString()), contains(instanceOf(User.class)));

        assertThat(participantRepository.findByType(ParticipantType.Group.toString()), contains(instanceOf(Group.class)));
    }

    @Test
    public void findByUserNameTest(){
        assertEquals("testuser", participantRepository.findByUserName("testuser").getUserName());

        assertEquals("testgroup", participantRepository.findByUserName("testgroup").getUserName());
    }

    @Test
    public void countByParticipantByIdTest(){
        Participant testUser = participantRepository.findByUserName("testuser");
        assertEquals(Long.valueOf("1"), participantRepository.countParticipantById(testUser.getId()));

        Participant testGroup = participantRepository.findByUserName("testgroup");
        assertEquals(Long.valueOf("1"), participantRepository.countParticipantById(testGroup.getId()));
    }

    @Test
    public void countByParticipantByUserNameTest(){
        assertEquals(Long.valueOf("1"), participantRepository.countParticipantByUserName("testuser"));

        assertEquals(Long.valueOf("1"),participantRepository.countParticipantByUserName("testgroup"));
    }

    @Test
    public void deleteByUserNameTest(){
        participantRepository.deleteByUserName("testuser");
        participantRepository.deleteByUserName("testgroup");

        assertEquals(null, participantRepository.findByUserName("testuser"));
        assertEquals(null, participantRepository.findByUserName("testgroup"));
    }


}
