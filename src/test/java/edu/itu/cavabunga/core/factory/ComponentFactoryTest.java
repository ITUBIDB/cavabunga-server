package edu.itu.cavabunga.core.factory;

import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import edu.itu.cavabunga.core.entity.component.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.instanceOf;

@RunWith(DataProviderRunner.class)
@SpringBootTest
public class ComponentFactoryTest {

    public ComponentFactory componentFactory;

    @Before
    public void setup() {
        componentFactory = new ComponentFactory();
    }

    @DataProvider
    public static Object[][] dataProviderComponentType() {
        return new Object[][] {
                { ComponentType.ALARM, Alarm.class},
                { ComponentType.CALENDAR, Calendar.class},
                { ComponentType.DAYLIGHT, Daylight.class},
                { ComponentType.EVENT, Event.class},
                { ComponentType.FREEBUSY, Freebusy.class},
                { ComponentType.JOURNAL, Journal.class},
                { ComponentType.STANDARD, Standard.class},
                { ComponentType.TIMEZONE, Timezone.class},
                { ComponentType.TODO, Todo.class},
        };
    }

    @Test
    @UseDataProvider("dataProviderComponentType")
    public void testCreateComponent(ComponentType componentType, Class type) {
        assertThat(componentFactory.createComponent(componentType), instanceOf(type));
    }

}
