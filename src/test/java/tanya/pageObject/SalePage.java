package tanya.pageObject;


import io.qameta.allure.Step;
import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import tanya.elements.Button;
import tanya.elements.DropDownList;
import tanya.helpers.StringProcessor;

import java.util.List;

import static tanya.DriveManager.getDriver;


public class SalePage extends AbstractPage {

    private By gridViewBtn = By.xpath("//strong[@title='Grid']");
    private By showSelectionLst = By.xpath("(//select[@title='Results per page'])[1]");
    private By itemAllPrices = By.xpath("//div[@class='price-box']");
    private By itemOldPrice = By.xpath("//div[@class='price-box']/p[@class='old-price']");
    private By itemSalePrice = By.xpath("//div[@class='price-box']/p[@class='special-price']");

    @Getter
    private Button GridView = new Button(gridViewBtn, "Grid view icon");

    @Getter
    private DropDownList ShowSelectionList = new DropDownList(showSelectionLst, "SHOW list");


    @Step
    public SalePage clickGridView() {
        GridView.click();
        return this;
    }

    @Step
    public SalePage clickShowDropDown(String value) {
        ShowSelectionList.select(value);
        return this;
    }

    //Generates list of pairs (Old and Sale prices) for each element. For each pair compares Old and Sale values
    public void comparePrices() {
        List<WebElement> weList = getDriver().findElements(itemAllPrices);
        for (WebElement we : weList) {
            double oldPrice = StringProcessor.stringToDouble(we.findElement(itemOldPrice).getText());
            double salePrice = StringProcessor.stringToDouble(we.findElement(itemSalePrice).getText());
            Assert.assertTrue(oldPrice > salePrice, String.format("Expected old price %s > than sale price %s", oldPrice, salePrice));
        }


    }
}
