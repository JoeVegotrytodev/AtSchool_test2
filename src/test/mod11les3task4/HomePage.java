package mod11les3task4;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class HomePage {
    private final String url = "https://the-internet.herokuapp.com/dynamic_loading/1";

    @Test
    public void dynamicElementTest() {
        System.setProperty("webdriver.gecko.driver", "src\\test\\resources\\drivers\\geckodriver.exe");
        // Настройка WebDriverManager для автоматической загрузки и установки GeckoDriver
        WebDriverManager.firefoxdriver().setup();
        // Настройка Selenide для использования GeckoDriver
        Configuration.browser = "firefox";

        open(url);
        $(byText("Start")).click();
        $("div[id='finish'] h4").shouldBe(Condition.not(Condition.visible), Duration.ofSeconds(120));

        closeWebDriver();
    }

}
