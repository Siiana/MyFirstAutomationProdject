package tanya.pageObject;

import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import tanya.elements.Button;
import tanya.elements.DropDownList;
import tanya.elements.TextField;

import java.util.List;

import static tanya.DriveManager.getDriver;

public class Electronics extends AbstractPage {

    private By showAsListBtn = By.xpath("//*[@title='List'][1]");
    private By showSelectionLst = By.xpath("//select[@title='Results per page'][1]");
    private By productInList = By.xpath("//div[@class='product-primary']");
    private By nextPgArrowBtn = By.xpath("//a[@title='Next'][1]");
    private By pagesAmount = By.xpath("//p[@class='amount amount--has-pages']");
    private By showPrice = By.cssSelector(".category-products > .toolbar > .sorter > .sort-by > select[title='Sort By']");
    private By item = By.xpath("//*[@id='products-list']/li");

    @Getter
    private Button ShowAsList = new Button(showAsListBtn, "Show as list");

    @Getter
    private Button NextPgSmallArrowBtn = new Button(nextPgArrowBtn, "Next page arrow");

    @Getter
    private DropDownList ShowSelectionList = new DropDownList(showSelectionLst, "SHOW list");

    @Getter
    private TextField PagesAmount = new DropDownList(pagesAmount, "SHOW list");

    @Getter
    private DropDownList ShowPrice = new DropDownList(showPrice, " PRICE in “SORT BY");


    public Electronics clickShowAsList() {
        getShowAsList().click();
        return this;
    }


    public Electronics clickShowDropDown(String value) {
        getShowSelectionList().select(value);
        return this;
    }

    public int getProductsNumber() {
        List<WebElement> welist = getDriver().findElements(productInList);
        return welist.size();
    }


    public Electronics clickNextPgBtn() {
        while (getNextPgSmallArrowBtn().isEnabled(1)) {
            getNextPgSmallArrowBtn().click();
        }
        return this;
    }

    public void checkNumbersOfItemsOnEachPage(int expectedItems) {
        int pageNumber = 1;
        do {
            if(pageNumber!=1)
                getNextPgSmallArrowBtn().click();

            int numberOfItems = getDriver().findElements(item).size();
            if (getNextPgSmallArrowBtn().isExists(1)) {
                Assert.assertEquals(numberOfItems, expectedItems,
                        String.format("Expect %s items, but found %s items on page %s",
                                expectedItems, numberOfItems, pageNumber));
            } else {
                Assert.assertTrue(numberOfItems <= expectedItems,
                        String.format("Expect not more than %s items, but found %s items on page %s",
                                expectedItems, numberOfItems, pageNumber));
            }
            pageNumber++;
        } while (getNextPgSmallArrowBtn().isExists(1));
    }

    public enum SortBy {
        POSITION("Position"),
        NAME("Name"),
        PRICE("Price");

        private String text;

        SortBy(String text) {
            this.text = text;
        }

        @Override
        public String toString() {
            return text;
        }
    }

    public Electronics setPrice(SortBy SortBy) {
        getShowPrice().select(SortBy.toString());
        return this;
    }


}

