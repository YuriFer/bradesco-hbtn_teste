import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class PersonTest {
    private Person person;

    @BeforeAll
    public void setup() {
        person = new Person();
    }

    @Test
    public void check_user_valid () {
        person.setUsuario("PaulMcCartney2");
        person.setPassword("NeilArms2");
        Assertions.assertTrue(person.checkUser());
        Assertions.assertFalse(person.checkPassword());
    }

    @Test
    public void check_user_not_valid() {
        person.setUsuario("Paul#McCartney");
        person.setPassword("Neil@Arms");
        Assertions.assertFalse(person.checkUser());
        Assertions.assertFalse(person.checkPassword());
    }

    @Test
    public void does_not_have_letters() {
        person.setUsuario("123456789");
        person.setPassword("#$%1234");

        Assertions.assertFalse(person.checkUser());
        Assertions.assertFalse(person.checkPassword());
    }

    @Test
    public void does_not_have_numbers() {
        person.setUsuario("Abcabcdefgh@");
        person.setPassword("#hbtn@%tc");

        Assertions.assertFalse(person.checkUser());
        Assertions.assertFalse(person.checkPassword());
    }

    @Test
    public void does_not_have_eight_chars() {
        person.setUsuario("Abc@123");
        person.setPassword("12$@hbt");

        Assertions.assertFalse(person.checkUser());
        Assertions.assertFalse(person.checkPassword());
    }

    @Test
    public void check_password_valid() {
        person.setUsuario("abC123456$");
        person.setPassword("Hbtn@1234");

        Assertions.assertFalse(person.checkUser());
        Assertions.assertTrue(person.checkPassword());
    }

    @ParameterizedTest
    @CsvSource({
        "abC123456$,Hbtn@1234",
        "Betty@1#2,Hbtn@123"
    })
    public void check_password_valid_parametrized(String usuario, String password) {
        person.setUsuario(usuario);
        person.setPassword(password);

        Assertions.assertFalse(person.checkUser());
        Assertions.assertTrue(person.checkPassword());
    }

}
