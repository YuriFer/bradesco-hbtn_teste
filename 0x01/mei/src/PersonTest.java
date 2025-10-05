import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;
import java.util.Date;

public class PersonTest {
    
    private Person person;

    @Before
    public void setup() {
        person = new Person("Paul", "McCartney", new Date(2000, 0, 1), true, true, true);
    }

    @Test
    public void show_full_name() {
        assertEquals("Paul McCartney", person.fullName());
    }

    @Test
    public void test_calculateYearlySalary() {
        person.setSalary(1200.0f);
        assertEquals(14400.0f, person.calculateYearlySalary(), 0.01);
    }

    @Test
    public void person_is_MEI() {
        Person meiPerson = new Person("João", "Silva", new Date(2000, 0, 1), false, false, false);
        meiPerson.setSalary(5000.0f);
        assertTrue(meiPerson.isMEI());
    }

    @Test
    public void person_is_not_MEI() {
        // Altere os dados de person de modo que o teste seja válido - Utilize assertFalse
        Person notMeiPerson = new Person("Maria", "Santos", new Date(2000, 0, 1), true, false, false);
        notMeiPerson.setSalary(15000.0f);
        assertFalse(notMeiPerson.isMEI());
    }
}