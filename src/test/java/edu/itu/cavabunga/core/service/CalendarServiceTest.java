package edu.itu.cavabunga.core.service;

import edu.itu.cavabunga.core.CalendarService;
import edu.itu.cavabunga.core.factory.ComponentFactory;
import edu.itu.cavabunga.core.entity.component.Calendar;
import edu.itu.cavabunga.core.repository.ComponentRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CalendarServiceTest {

    @MockBean
    private ComponentFactory mockComponentFactory;

    @MockBean
    private ComponentRepository mockComponentRepository;

    @Autowired
    private CalendarService calendarService;


    @Test
    public void testSaveCalendar() {
        Calendar mockCalendar = mock(Calendar.class);
        when(mockCalendar.validate()).thenReturn(true);
        calendarService.saveCalendar(mockCalendar);

        //check a minimum 1 call count
        verify(mockCalendar, only()).validate();

        //check a minimum 1 call count
        verify(mockComponentRepository, only()).save(mockCalendar);
    }
}
