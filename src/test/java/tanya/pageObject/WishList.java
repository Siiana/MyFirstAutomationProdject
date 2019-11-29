package tanya.pageObject;

import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import tanya.elements.Button;
import tanya.elements.InputField;

import java.util.ArrayList;
import java.util.List;

import static tanya.DriveManager.getDriver;

public class WishList extends AbstractPage {
    private By itemName = By.cssSelector(" .product-name");

    public List<String> getItemNames() {
        List<String> forReturn = new ArrayList<>();
        for (WebElement element: getDriver().findElements(itemName)){
            forReturn.add(element.getText());
        }
        return forReturn;
    }




}
