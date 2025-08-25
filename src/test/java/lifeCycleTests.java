import org.example.CreateUser;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.*;

public class lifeCycleTests {
    private String data;

    private static Stream<CreateUser> testUser() {
        return Stream.of(
            new CreateUser("Danya", "Morozov", "Vladislavovich"),
            new CreateUser("Vlad", "Molodec", "Koksovich")
        );


    }

    @BeforeAll
    static void madeAll() {
        System.out.println("Заполните все нужные поля");
    }

    @BeforeEach
    void madeBeforeEach() {
        data = "Время";
        data = data + LocalDateTime.now();
        System.out.println(data);
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
        assertNotNull(testUser.getFirstName());
        assertNotNull(testUser.getLastName());
        assertNotNull(testUser.getMiddleName());
        assertDoesNotThrow(() -> testUser.getMiddleName());
    }

    @Test
    void parallelTestExample() {
        System.out.println("Log starts" + Thread.currentThread().getName() +
            " | Time " + LocalDateTime.now());
        assertEquals(1, 1);
    }
}
