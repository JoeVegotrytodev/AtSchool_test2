package mod11les3.tests;

import io.qameta.allure.Link;
import io.qameta.allure.Owner;
import mod11les3.pages.LoginPage;
import mod11les3.properties.WebDriver;
import org.junit.jupiter.api.*;

public class LoginTest extends WebDriver {
    public static LoginPage loginPage;

    @BeforeEach
    public void setup() {
        driverInit();
        loginPage = new LoginPage(driver);
    }

    @Test  //тестовые методы в Junit помечаются аннотацией Test.
    @Owner("Музафаров Айрат")
    @Link("https://antitreningi.ru/student/lessons/lesson?course_id=257643&lesson_id=6188173")
    @DisplayName("Проверка открытия старницы логина")
    public void loginTest() {
//        driverInit();
        loginPage = new LoginPage(driver);
        //проверяем, что доступа кнопка внтури кабинета сотрудника банка
        Assertions.assertEquals("Swag Labs", loginPage.getTextFromLogo());
//        driverTearDown();
    }

    @AfterEach
    public void tearDown() {
        //мог бы вызвать и внутри теста, но хотелось структуру создать...
        driverTearDown();
    }

}
