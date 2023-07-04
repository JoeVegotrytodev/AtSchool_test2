package mod11les3.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * При использовании Page Object элементы страниц,
 * а также методы непосредственного взаимодействия с ними, выносятся в отдельный класс.
 * Следовательно, ниже класс страницы логина
 */
public class LoginPage extends Pages {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@class='login_logo']")
    private WebElement loginPageLogotype;

    @FindBy(xpath = "//input[@id='user-name']")
    private WebElement userNameField;

    @FindBy(css = "#password")
    private WebElement passwordField;

    @FindBy(css = "#login-button")
    private WebElement LoginButton;


    public String getTextFromLogo(){
        return loginPageLogotype.getText();
    }
}
