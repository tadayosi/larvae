package larvae.jpa.domain;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import java.util.List;

import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class PersonTest {

    private Weld weld;
    private WeldContainer container;

    @Before
    public void setUp() {
        weld = new Weld();
        container = weld.initialize();
    }

    @After
    public void tearDown() {
        weld.shutdown();
    }

    @Test
    public void add_findAll() {
        PersonRepository repository = container.instance().select(PersonRepository.class).get();
        repository.add(new Person("John", "Doe", 30));
        List<Person> persons = repository.findAll();
        assertThat(persons, is(not(empty())));
        assertThat(persons.size(), is(1));
    }

}
