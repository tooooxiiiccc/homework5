import org.example.CreateUser;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.time.LocalDateTime;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class lifeCycleTests {
    private String data;
    private Stream<CreateUser> testUser() {
        return Stream.of(new CreateUser("Danya","Morozov", "Vladislavovich"));
    }

    @BeforeAll
    static void madeAll() {
        System.out.println("Заполните все нужные поля");
    }

    @BeforeEach
    void madeBeforeEach() {
        data = "Время";
        data = data + LocalDateTime.now();
        CreateUser newUser = new CreateUser("Danil", "Vladislavovich", "Danil");
    }

    @Test
    @DisplayName("Math operation")
    void test() {
        int a = 8;
        int b = 6;
        int result = a + b;
        assertEquals(14, result);
        System.out.println(data);
    }

    @AfterEach
    void madeAfterEach() {
        System.out.println("Выполнить деление после каждого теста");
        int c = 9;
        int d = 9;
        int result = c / d;
        assertEquals(1, result);
    }

    @AfterAll
    static void madeAfterAll() {
        System.out.println("Выполнить один раз после всех тестов");
    }

    @ParameterizedTest
    @MethodSource("testUser")
    void addUser(CreateUser testUser) {
        System.out.println(testUser.getFirstName());
        assertTrue(testUser.getMiddleName().contains("Morozov"));
    }

}

