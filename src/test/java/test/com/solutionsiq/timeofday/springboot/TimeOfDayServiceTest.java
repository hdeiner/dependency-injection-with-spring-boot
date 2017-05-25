package test.com.solutionsiq.timeofday.springboot;

import com.solutionsiq.timeofday.springboot.consumer.TimeOfDayConsumer;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@ComponentScan("com.solutionsiq.timeofday.springboot")
public class TimeOfDayServiceTest {

    private AnnotationConfigApplicationContext context = null;

    @Before
    public void setUp() throws Exception {
        context = new AnnotationConfigApplicationContext(TimeOfDayServiceTest.class);
    }

    @After
    public void tearDown() throws Exception {
        context.close();
    }

    @Test
    public void checkTimeOfDayFormatted101112() {
        TimeOfDayConsumer timeOfDayConsumer = context.getBean(TimeOfDayConsumer.class);
        assertThat(timeOfDayConsumer.getFormattedTimeOfDay(10,11,12),is(("10:11:12")));
    }

    @Test
    public void checkTimeOfDaySpoken101112() {
        TimeOfDayConsumer timeOfDayConsumer = context.getBean(TimeOfDayConsumer.class);
        assertThat(timeOfDayConsumer.getFormattedTimeOfDaySpokenWords(10,11,12),is(("ten after ten o'clock in the morning")));
    }

    @Test
    public void checkTimeOfDaySpoken101435() {
        TimeOfDayConsumer timeOfDayConsumer = context.getBean(TimeOfDayConsumer.class);
        assertThat(timeOfDayConsumer.getFormattedTimeOfDaySpokenWords(10,14,35),is(("a quarter after ten o'clock in the morning")));
    }

    @Test
    public void checkTimeOfDaySpoken224435() {
        TimeOfDayConsumer timeOfDayConsumer = context.getBean(TimeOfDayConsumer.class);
        assertThat(timeOfDayConsumer.getFormattedTimeOfDaySpokenWords(22,44,35),is(("a quarter before eleven o'clock in the evening")));
    }

}
