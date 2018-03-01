package edu.itu.cavabunga.core.repository;

import edu.itu.cavabunga.core.factory.ComponentFactory;
import edu.itu.cavabunga.core.factory.ParticipantFactory;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

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


    }

}
