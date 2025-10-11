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

    @ParameterizedTest
    @CsvSource({
        "PaulMcCartney2",
        "NeilArms2"
    })
    public void check_user_valid(String usuario) {
        person.setUsuario(usuario);
        Assertions.assertTrue(person.checkUser());
    }

    @ParameterizedTest
    @CsvSource({
        "Paul#McCartney",
        "Neil@Arms"
    })
    public void check_user_not_valid(String usuario) {
        person.setUsuario(usuario);
        Assertions.assertFalse(person.checkUser());
    }

    @ParameterizedTest
    @CsvSource({
        "123456789",
        "#$%1234"
    })
    public void does_not_have_letters(String password) {
        person.setPassword(password);
        Assertions.assertFalse(person.checkPassword());
    }

    @ParameterizedTest
    @CsvSource({
        "Abcabcdefgh@",
        "#hbtn@%tc"
    })
    public void does_not_have_numbers(String password) {
        person.setPassword(password);
        Assertions.assertFalse(person.checkPassword());
    }

    @ParameterizedTest
    @CsvSource({
        "Abc@123",
        "12$@hbt"
    })
    public void does_not_have_eight_chars(String password) {
        person.setPassword(password);
        Assertions.assertFalse(person.checkPassword());
    }

    @ParameterizedTest
    @CsvSource({
        "abC123456$,Hbtn@1234",
        "Betty@1#2,Hbtn@123"
    })
    public void check_password_valid(String password) {
        person.setPassword(password);
        Assertions.assertTrue(person.checkPassword());
    }

}
