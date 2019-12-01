package tanya.pageObject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import tanya.helpers.StringProcessor;

import java.util.ArrayList;
import java.util.List;

import static tanya.DriveManager.getDriver;

public class ShoppingCartPage extends AbstractPage {

    private By itemName = By.cssSelector(" .product-name");
    private By price = By.cssSelector(".product-cart-price  .price");
    private By subTotalPrice = By.cssSelector("tr:nth-of-type(1) > td:nth-of-type(2) > .price");
    private By taxPrice = By.cssSelector("tr:nth-of-type(2) > td:nth-of-type(2) > .price");
    private By grandTotalPrice = By.cssSelector("tfoot > tr > td:nth-of-type(2)  .price");



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

    public String getSubTotalPrice(WebElement element) {
        String textSubTotalPrice = element.getText();
        WebElement : element.findElements(subTotalPrice);
        return textSubTotalPrice;
    }

    public String getTaxPrice(WebElement element) {
        String textTaxPrice = element.getText();
       WebElement : element.findElements(taxPrice);
        return textTaxPrice;
    }

    public String getGrandTotalPrice(WebElement element){
        String textGrandTotalPrice = element.getText();
        WebElement : element.findElements(grandTotalPrice);
        return textGrandTotalPrice;
    }

}
