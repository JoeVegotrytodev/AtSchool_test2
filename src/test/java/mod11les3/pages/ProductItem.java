package mod11les3.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.math.BigDecimal;
import java.util.List;

//не совсем понял идею класса - его цель
//не понял как по локатору одного элемента - получить стоимость не только того элемента
//поэтому определил по своему способу
//и новый класс элементов - то есть вещей купленных)
public class ProductItem extends Pages {
    public ProductItem(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@class='inventory_details_name large_size']")
    private WebElement productHeader;

    @FindBy(xpath = "//div[@class='inventory_details_desc large_size']")
    private WebElement productDescription;

    @FindBy(css = ".inventory_details_price")
    private WebElement productPrice;

    @FindBy(xpath = "//button[.='Add to cart']")
    private WebElement productAddToCartButton;

    public BigDecimal getProductPrice(){
        return new BigDecimal(productPrice.getText());
    }

    public List<WebElement> getProductsDescription(){
        return driver.findElements(By.xpath("//div[@class='inventory_item_label']"));
    }

    public List<WebElement> getProductsPrice(){
        return driver.findElements(By.xpath("//div[@class='inventory_item_price']"));
    }

    public List<WebElement> getProductsHeader(){
        return driver.findElements(By.xpath("//div[@class='inventory_item_name']"));
    }

}
