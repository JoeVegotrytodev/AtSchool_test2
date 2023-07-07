package mod11les3.tests;

import io.qameta.allure.Link;
import io.qameta.allure.Owner;
import mod11les3.pages.*;
import mod11les3.properties.Product;
import mod11les3.properties.TestProperties;
import mod11les3.properties.WebDriver;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebElement;

import java.math.BigDecimal;
import java.util.*;

public class AddToCartTest extends WebDriver {
    public static LoginPage loginPage;
    public static ProductPages productPage;
    public static  CartPage cartPage;
    int counterOfItemsToBuy;
    Product[] products;
    Product[] cardProducts;

    @BeforeEach
    public void setup() {
        driverInit();
        loginPage = new LoginPage(driver);
    }

    @Test
    @Owner("Музафаров Айрат")
    @Link("https://antitreningi.ru/student/lessons/lesson?course_id=257643&lesson_id=6188173")
    @DisplayName("Проверка доавбление товаров в корзину")
    public void addToCartTest() {
        //открыли страницу         loginPage = new LoginPage(driver);
        //ввели логин
        loginPage.enterLogin(TestProperties.getProperty("login"));
        //ввели пароль
        loginPage.enterPassword(TestProperties.getProperty("password"));
        //нажать кнопки логин
        loginPage.loginButtonClick();

        productPage = new ProductPages(driver);

//      проверяется, что перешли на страницу ProductPage и в корзине нет выбранных вещей
        Assertions.assertNotNull(productPage.getCartButtonLogo());

        //определяемся с продуктами, которые хотим взять
        ProductItem productItem = new ProductItem(driver);
        List<WebElement> listOfItemsToBuy = pickSomeProducts(
                productPage.getProductsButtons(),
                productItem.getProductsDescription(),
                productItem.getProductsHeader(),
                productItem.getProductsPrice()
                );

        //для каждой вещи нажимаем добавить в корзину
        listOfItemsToBuy.stream().forEach((item)-> item.click());

        //проверка значка корзины на добавление вещей
        Assertions.assertEquals(counterOfItemsToBuy, productPage.getCartButtonLogoNumber());

        //нажимаем на кнопку корзины
        productPage.getCartButton().click();

        //проверяем открытие корзины
        Assertions.assertEquals("https://www.saucedemo.com/cart.html", driver.getCurrentUrl());
        CartPage cartPage = new CartPage(driver);
        Assertions.assertEquals("Your Cart", cartPage.getCartHeaderText());

        //получаем продукты страницы Корзины магазина
        CartItem cartItem = new CartItem(driver);
        getProductsFromCart(cartItem.getCartProductsDescription(),
                cartItem.getGetCartProductsHeader(),
                cartItem.getGetCartProdcutsPrice());

        //проверка вещей в корзине
        Assertions.assertTrue(isProductAddedToCartCorrectly(products,cardProducts));


    }

    /**
     * определяет кол-во выбираемых вещей рандомно
     * @return кол-во выбираемых вещей рандомно
     */
    private int getRandomIndex(){
        Random random = new Random();
        return random.nextInt(6);
    }

    /**
     * выбирает рандомно вещи из магазина
     * @param productsButtons список всех вещей
     * @return список выбарнных вещей
     */
    private List<WebElement> pickSomeProducts(List<WebElement> productsButtons,
                                              List<WebElement> productsDescs,
                                              List<WebElement> productsHeaders,
                                              List<WebElement> productsPrices){
        List<WebElement> outputListOfProducts = new ArrayList<WebElement>();

        counterOfItemsToBuy = getRandomIndex();
        products = new Product[counterOfItemsToBuy];

        for(int i = 0; i < counterOfItemsToBuy; i++){
            outputListOfProducts.add(productsButtons.get(i));

            products[i] = new Product(convertStringToBigDecimal(productsPrices.get(i).getText()),
                    productsHeaders.get(i).getText(),
                    productsDescs.get(i).getText());
        }

        return outputListOfProducts;
    }

    /**
     * конвертируем текст строки получаемый от драйвера в число
     * @param textNumber число в виде строки которое преобразуем
     * @return конвертированное число
     */
    private BigDecimal convertStringToBigDecimal(String textNumber){
        StringBuilder tempString = new StringBuilder(textNumber);
        //вырезаем знак валюты
        String strToConvertToPrice = tempString.substring(1, tempString.length());

        return new BigDecimal(strToConvertToPrice);
    }


    /**
     * сравнивает два массива вещей корзины и доавбленных вещей
     * @param expectedListOfProduct лоавбленные вещи
     * @param currentCartProducts вещи корзины
     * @return совпадают ли вещи
     */
    private boolean isProductAddedToCartCorrectly(Product[] expectedListOfProduct,
                                                  Product[] currentCartProducts){
        boolean isProductExistInCart = false;

        for (Product expectedProduct : expectedListOfProduct){
            for (Product cartProduct : currentCartProducts) {
                if (expectedProduct.getHeader().equals(cartProduct.getHeader())) {
                    isProductExistInCart = true;
                    break;
                }
            }
        }

        return isProductExistInCart;
    }

    /**
     * мой метод костыль - раз различные коллекции использовать захотел,
     * то сделал такой метод где их привожу к общему классу
     */
    private void getProductsFromCart(LinkedList<String> descriptionList,
                                ArrayList<String> headerArrayList,
                                ArrayDeque<String> priceArrayDeque){
        cardProducts = new Product[products.length];

        for(int i = 0; i < products.length; i++){
            cardProducts[i] = new Product(convertStringToBigDecimal(priceArrayDeque.getFirst()),
                    headerArrayList.get(i),
                    descriptionList.get(i));
            priceArrayDeque.removeFirstOccurrence(priceArrayDeque.getFirst());
        }

    }

    @AfterEach
    public void tearDown() {
        //мог бы вызвать и внутри теста, но хотелось структуру создать...
        driverTearDown();
    }

}
