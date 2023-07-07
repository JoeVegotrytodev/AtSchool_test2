package mod11les3.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartPage extends Pages{
    public CartPage(WebDriver driver) {
        super(driver);
    }

    private WebElement cartHeader = driver.findElement(By.xpath("//span[.='Your Cart']"));

    public String getCartHeaderText(){
        return cartHeader.getText();
    }
}
