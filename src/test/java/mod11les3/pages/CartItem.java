package mod11les3.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.*;

public class CartItem extends Pages{
    public CartItem(WebDriver driver) {
        super(driver);
    }

    private List<WebElement> cartProductsDescription = driver.findElements(By.className("inventory_item_desc"));
    private List<WebElement> cartProductsHeader = driver.findElements(By.className("inventory_item_name"));
    private List<WebElement> cartProdcutsPrice = driver.findElements(By.className("inventory_item_price"));

    //линкед лист взял, потому что опыта его использвования мало, хоть попробую лишний раз.
    // Аналогично и далее
    public LinkedList<String> getCartProductsDescription() {
        LinkedList<String> linkedList = new LinkedList<>();

        cartProductsDescription.stream().forEach((desc) -> linkedList.add(desc.getText()));
        return linkedList;
    }

    public ArrayList<String> getGetCartProductsHeader() {
        ArrayList<String> arrayList = new ArrayList<>();

        cartProductsHeader.stream().forEach((header) -> arrayList.add(header.getText()));
        return arrayList;
    }

    public ArrayDeque<String> getGetCartProdcutsPrice() {
        ArrayDeque<String> arrayDeque = new ArrayDeque<>();

        cartProdcutsPrice.stream().forEach((price) -> arrayDeque.add(price.getText()));
        return arrayDeque;
    }
}
