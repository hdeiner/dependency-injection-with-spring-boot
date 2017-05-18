package test.com.solutionsiq.computers.monadic.springboot;

import com.solutionsiq.computers.monadic.springboot.consumer.ComputingApplication;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@ComponentScan("com.solutionsiq.computers.monadic.springboot")
public class InversionOfControlUsingSpringBootTest {

    @Test
    public void checkDoublerService() {
        AnnotationConfigApplicationContext context;
        context = new AnnotationConfigApplicationContext(InversionOfControlUsingSpringBootTest.class);
        ComputingApplication app = context.getBean(ComputingApplication.class);
        assertThat(app.compute(8),is((long)16));
        context.close();
    }

}