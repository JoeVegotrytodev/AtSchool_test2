package mod11les3.properties;

import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

/**
 * Настройка дравйера тестов
 */
public class WebDriver {

    public static org.openqa.selenium.WebDriver driver;

    //    @BeforeClass
    public static void driverInit(){
        //определение пути до драйвера
        System.setProperty("webdriver.gecko.driver", TestProperties.getProperty("firefoxdriver"));
        //создание экземпляра драйвера: для запуска браузера необходимо создать объект драйвера
        driver = new FirefoxDriver();
        //окно разворачивается на полный экран, для отображения хода теста
        driver.manage().window().maximize();
        //задержка на выполнение теста = 10 сек.
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        //передача драйверу адреса открываемой страницы из файла настроек
        driver.get(TestProperties.getProperty("homepage"));
    }

    //    @AfterClass
    public static void driverTearDown(){
        //закрытие драйвера
        driver.quit();
    }


}
