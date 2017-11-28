package edu.itu.cavabunga.entity;

import edu.itu.cavabunga.repository.CalendarRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CalendarTest {

    @Autowired
    private CalendarRepository calendarRepository;

    @Test
    public void testCalendar()
    {
        Calendar c = new Calendar();
        c.setCalendar_name("test_calendar");
        c.setUser_name("test_user");

        calendarRepository.save(c);

        Calendar temp = calendarRepository.findOne(c.getId());
        Assert.assertTrue(temp.getCalendar_name().equals(c.getCalendar_name()));
    }
}
