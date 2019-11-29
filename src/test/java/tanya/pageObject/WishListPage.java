package tanya.pageObject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

import static tanya.DriveManager.getDriver;

public class WishListPage extends AbstractPage {

    private By itemName = By.cssSelector(" .product-name");

    @Step
    public List<String> getItemNames() {
        List<String> forReturn = new ArrayList<>();
        for (WebElement element: getDriver().findElements(itemName)){
            forReturn.add(element.getText());
        }
        return forReturn;
    }




}
