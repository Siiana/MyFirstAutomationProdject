package tanya.pageObject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

import static tanya.DriveManager.getDriver;

public class ShoppingCartPage extends AbstractPage {

    private By itemName = By.cssSelector(" .product-name");
    private By price = By.cssSelector(".product-cart-price  .price");

    @Step
    public List<String> getItemNames() {
        List<String> forReturn = new ArrayList<>();
        for (WebElement element: getDriver().findElements(itemName)){
            forReturn.add(element.getText());
        }
        return forReturn;
    }

    @Step
    public List<String> getPrice() {
        List<String> forReturn = new ArrayList<>();
        for (WebElement element: getDriver().findElements(price)){
            forReturn.add(element.getText());
        }
        return forReturn;

    }
}
