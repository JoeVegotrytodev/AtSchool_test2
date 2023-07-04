package mod11les3.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 Создал класс для выноса общих моментов страниц описанных с помощью PageObject
 */
public class Pages {
    public WebDriver driver;
    public Pages(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
}
