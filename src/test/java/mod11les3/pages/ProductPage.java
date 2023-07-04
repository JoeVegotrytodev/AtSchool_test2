package mod11les3.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductPage extends Pages{

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    //специально пробую разными способами находить элемент и разными локаторами то искпаф то цсс
    private WebElement productPageHeader = driver.findElement(By.xpath("//span[@class='title']"));
    private WebElement burgerButton = driver.findElement(By.cssSelector(".bm-burger-button"));
    private WebElement logoutButton = driver.findElement(By.cssSelector("#logout_sidebar_link"));

    public String getProductPageHeader(){
        return productPageHeader.getText();
    }

    public WebElement getBurgerButton(){
        return burgerButton;
    }
    public void burgerClick(){
        burgerButton.click();
    }
    public WebElement getLogoutButton(){
        return logoutButton;
    }
    public void returnToHomePage(){
        logoutButton.click();
    }
}
