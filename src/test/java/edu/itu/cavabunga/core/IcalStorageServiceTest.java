package edu.itu.cavabunga.core;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import edu.itu.cavabunga.core.entity.Participant;
import edu.itu.cavabunga.core.entity.component.ComponentType;
import edu.itu.cavabunga.core.exception.IcalStorageException;
import edu.itu.cavabunga.core.factory.ComponentFactory;
import edu.itu.cavabunga.core.entity.component.Calendar;
import edu.itu.cavabunga.core.repository.ComponentRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class IcalStorageServiceTest {

    @MockBean
    private ComponentFactory mockComponentFactory;

    @MockBean
    private ComponentRepository mockComponentRepository;

    @MockBean
    private Calendar mockCalendar;

    @MockBean
    private Participant mockParticipant;

    @Autowired
    private IcalStorageService icalStorageService;


    @Test(expected = IcalStorageException.class)
    public void testCreateComponentFail() {
        when(mockComponentFactory.createComponent(ComponentType.CALENDAR)).thenReturn(null);
        icalStorageService.createComponent(ComponentType.CALENDAR);
    }

    @Test
    public void testCreateComponentSuccess() {
        when(mockComponentFactory.createComponent(ComponentType.CALENDAR)).thenReturn(mockCalendar);
        assertEquals(icalStorageService.createComponent(ComponentType.CALENDAR), mockCalendar);
        verify(mockComponentFactory, only()).createComponent(ComponentType.CALENDAR);
    }

    @Test(expected = IcalStorageException.class)
    public void testCreateComponentForParticipantFail() {
        when(mockComponentFactory.createComponent(ComponentType.CALENDAR)).thenReturn(null);
        icalStorageService.createComponentForParticipant(ComponentType.CALENDAR, mockParticipant);
    }

    @Test
    public void testCreateComponentForParticipantSuccess() {
        when(mockComponentFactory.createComponent(ComponentType.CALENDAR)).thenReturn(mockCalendar);
        assertEquals(
                icalStorageService.createComponentForParticipant(ComponentType.CALENDAR, mockParticipant),
                mockCalendar
        );
        verify(mockCalendar, only()).setOwner(mockParticipant);
        verify(mockComponentFactory, only()).createComponent(ComponentType.CALENDAR);
    }

    @Test
    public void testGetComponentById() {
        when(mockComponentRepository.findOne((long)1)).thenReturn(mockCalendar);
        assertEquals(
                icalStorageService.getComponentById((long)1),
                mockCalendar
        );
    }

    @Test
    public void testSaveComponent() {
        icalStorageService.saveComponent(mockCalendar);

        verify(mockComponentRepository, only()).save(mockCalendar);
    }
}
