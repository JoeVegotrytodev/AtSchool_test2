package mod11les3.tests;

import io.qameta.allure.Link;
import io.qameta.allure.Owner;
import mod11les3.pages.LoginPage;
import mod11les3.pages.ProductPages;
import mod11les3.properties.TestProperties;
import mod11les3.properties.WebDriverBaseTest;
import org.junit.jupiter.api.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoginTest extends WebDriverBaseTest {
    public static LoginPage loginPage;
    public static ProductPages productPage;
    private Logger logger;

    @BeforeEach
    public void setup() {
        driverInit();
        loginPage = new LoginPage(driver);
        //Инициализируем логгер
        logger = LoggerFactory.getLogger(LoginTest.class);
    }

    @Test  //тестовые методы в Junit помечаются аннотацией Test.
    @Owner("Музафаров Айрат")
    @Link("https://antitreningi.ru/student/lessons/lesson?course_id=257643&lesson_id=6188173")
    @DisplayName("Проверка открытия старницы логина")
    public void loginTest() {
        logger.info("before assertions : ");
        Assertions.assertEquals("Swag Labs", loginPage.getTextFromLogo(), "оказывается у ассертов есть текст для вывода е мае" +
                "удобный инструмент прям !");
    }

    @Test
    @Owner("Музафаров Айрат")
    @Link("https://antitreningi.ru/student/lessons/lesson?course_id=257643&lesson_id=6188173")
    @DisplayName("Проверка логина и возврат на домашнюю страницу")
    public void loginTestTask2(){
        //открыли страницу loginPage = new LoginPage(driver);
        //ввели логин
        loginPage.enterLogin(TestProperties.getProperty("login"));
        //ввели пароль
        loginPage.enterPassword(TestProperties.getProperty("password"));
        //нажать кнопки логин
        loginPage.loginButtonClick();

        productPage = new ProductPages(driver);
//      проверяется, что перешли на страницу ProductPage
//      (перешли на страницу с нужным адресом
//      и есть плашка с текстом Products)
        Assertions.assertEquals("https://www.saucedemo.com/inventory.html", driver.getCurrentUrl());
        Assertions.assertEquals("Products", productPage.getProductPageHeader());
//      проверяется, что отображается "бургер"
        Assertions.assertTrue(productPage.getBurgerButton().isDisplayed());
//      нажать на бургер
        productPage.burgerClick();
//      проверяется, что отображается кнопка "Logout"
        Assertions.assertTrue(productPage.getLogoutButton().isDisplayed());
//      нажимаете на кнопку "Logout"
        productPage.returnToHomePage();
//      проверяется, что перешли на страницу LoginPage
//      (перешли на страницу с нужным адресом
//      и есть лого с текстом "Swag Labs")
        Assertions.assertEquals("https://www.saucedemo.com/", driver.getCurrentUrl());
        Assertions.assertEquals("Swag Labs", loginPage.getTextFromLogo());
    }

//    @AfterEach - убрал сделал в родительском классе
//    public void tearDown() {
//        driverTearDown();
//    }

}
