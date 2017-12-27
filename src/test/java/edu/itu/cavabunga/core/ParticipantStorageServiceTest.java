package edu.itu.cavabunga.core;

import edu.itu.cavabunga.core.entity.Participant;
import edu.itu.cavabunga.core.factory.ParticipantFactory;
import edu.itu.cavabunga.core.repository.ParticipantRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.only;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ParticipantStorageServiceTest {
    @MockBean
    private ParticipantFactory mockParticipantFactory;

    @MockBean
    private ParticipantRepository mockParticipantRepository;

    @MockBean
    private Participant mockParticipant;

    @Autowired
    private ParticipantStorageService participantStorageService;

    @Test
    public void testCreateParticipant(){
        when(mockParticipantFactory.createUser("testUsername")).thenReturn(mockParticipant);
        assertEquals(participantStorageService.createParticipant("testUsername"), mockParticipant);

        verify(mockParticipantFactory, only()).createUser("testUsername");
        verify(mockParticipant, only()).setCreationDate(any());
        verify(mockParticipantRepository, only()).save(mockParticipant);
    }

    @Test
    public void testSaveParticipant(){
        participantStorageService.saveParticipant(mockParticipant);

        verify(mockParticipant, only()).setCreationDate(any());
        verify(mockParticipantRepository, only()).save(mockParticipant);
    }

    @Test
    public void testGetParticipantByUserName(){
        participantStorageService.getParticipantByUserName("testUsername");

        verify(mockParticipantRepository, only()).findByUserName("testUsername");
    }

    @Test
    public void testGetParticipantByUuid(){
        participantStorageService.getParticipantByUuid("testUID");

        verify(mockParticipantRepository, only()).findByUuid("testUID");
    }
}
