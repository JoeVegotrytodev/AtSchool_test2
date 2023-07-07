package mod11les3.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ProductPages extends Pages{

    public ProductPages(WebDriver driver) {
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

    @FindBy(xpath = "//button[contains(@class,'btn_inventory')]")
    private WebElement productsListElement;

    @FindBy(css = ".shopping_cart_link")
    private WebElement cartButton;

    @FindBy(xpath = "//span[@class='shopping_cart_badge']")
    private WebElement cartButtonLogo;

    public List<WebElement> getProductsButtons() {
        return driver.findElements(By.xpath("//button[contains(@class,'btn_inventory')]"));
    }
    public WebElement getCartButtonLogo(){
        if(cartButtonLogo!= null){
            return cartButtonLogo;
        }else{
            return null;
        }
    }

    public int getCartButtonLogoNumber(){
        return new Integer(cartButtonLogo.getText());
    }

    public WebElement getCartButton() {
        return cartButton;
    }
}
