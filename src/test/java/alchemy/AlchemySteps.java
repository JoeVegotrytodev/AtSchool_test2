package alchemy;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import mod3les10.task1.Fire;
import mod3les10.task1.NatureElement;
import org.junit.jupiter.api.Assertions;

public class AlchemySteps {

    private String elementName;
    private NatureElement element;
    private NatureElement firstElementToConnect, secondElementToConnect, connectedElement;

    @Given("название элемента \"огонь\"")
    public void setFireName() {
        // Write code here that turns the phrase above into concrete actions
        elementName = "Fire";
    }

    @When("найдено название базового элемента огонь")
    public void createFire() {
        element = NatureElement.create(elementName);
    }

    @Then("создается элемент огонь")
    public void isFireCreated() {
        Assertions.assertTrue(element instanceof Fire);
    }

    @Given("название элемента \"вода\"")
    public void setWaterName() {
        // Write code here that turns the phrase above into concrete actions
        elementName = "Fire";
    }

    @When("найдено название базового элемента вода")
    public void createWater() {
        element = NatureElement.create(elementName);
    }

    @Then("создается элемент вода")
    public void isWaterCreated() {
        Assertions.assertTrue(element instanceof Fire);
    }

    @Given("название элемента \"воздух\"")
    public void setAirName() {
        // Write code here that turns the phrase above into concrete actions
        elementName = "Fire";
    }

    @When("найдено название базового элемента воздух")
    public void creatAir() {
        element = NatureElement.create(elementName);
    }

    @Then("создается элемент воздух")
    public void isAirCreated() {
        Assertions.assertTrue(element instanceof Fire);
    }

    @Given("название элемента \"земля\"")
    public void setEarthName() {
        // Write code here that turns the phrase above into concrete actions
        elementName = "Fire";
    }

    @When("найдено название базового элемента земля")
    public void creatEarth() {
        element = NatureElement.create(elementName);
    }

    @Then("создается элемент земля")
    public void isEarthCreated() {
        Assertions.assertTrue(element instanceof Fire);
    }

    @Given("Получаем элементы для создания нового {string} {string}")
    public void getElementsToConnect(String elem1, String elem2) {
        // Write code here that turns the phrase above into concrete actions
        firstElementToConnect = NatureElement.create(elem1);
        secondElementToConnect = NatureElement.create(elem2);
    }

    @When("Соединение элементов")
    public void connectElements() {
        connectedElement = firstElementToConnect.connect(secondElementToConnect);
    }

    @Then("Создан требуемый элемент {string}")
    public void isElementCreated(String expectedElement) {
        Assertions.assertEquals(expectedElement, connectedElement.toString());
    }
}
