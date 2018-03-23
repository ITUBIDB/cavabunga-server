package edu.itu.cavabunga.core.repository;

import edu.itu.cavabunga.core.entity.Component;
import edu.itu.cavabunga.core.entity.Parameter;
import edu.itu.cavabunga.core.entity.Participant;
import edu.itu.cavabunga.core.entity.Property;
import edu.itu.cavabunga.core.entity.component.ComponentType;
import edu.itu.cavabunga.core.entity.parameter.Encoding;
import edu.itu.cavabunga.core.entity.parameter.Language;
import edu.itu.cavabunga.core.entity.parameter.ParameterType;
import edu.itu.cavabunga.core.entity.participant.ParticipantType;
import edu.itu.cavabunga.core.entity.property.PropertyType;
import edu.itu.cavabunga.core.factory.ComponentFactory;
import edu.itu.cavabunga.core.factory.ParameterFactory;
import edu.itu.cavabunga.core.factory.ParticipantFactory;
import edu.itu.cavabunga.core.factory.PropertyFactory;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.instanceOf;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class ParameterRepositoryTest {
    @Autowired
    ParticipantRepository participantRepository;

    @Autowired
    ComponentRepository componentRepository;

    @Autowired
    ParticipantFactory participantFactory;

    @Autowired
    ComponentFactory componentFactory;

    @Autowired
    PropertyRepository propertyRepository;

    @Autowired
    PropertyFactory propertyFactory;

    @Autowired
    ParameterRepository parameterRepository;

    @Autowired
    ParameterFactory parameterFactory;

    private Property testParentProperty;

    @Before
    public void setUp(){
    }
}
