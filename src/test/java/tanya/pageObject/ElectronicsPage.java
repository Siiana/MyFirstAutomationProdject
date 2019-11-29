package tanya.pageObject;

import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import tanya.elements.Button;
import tanya.elements.DropDownList;
import tanya.elements.TextField;
import tanya.helpers.StringProcessor;

import javax.imageio.metadata.IIOMetadataNode;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;

import static tanya.DriveManager.getDriver;

public class ElectronicsPage extends AbstractPage {

    private By showAsListBtn = By.xpath("//*[@title='List'][1]");
    private By showSelectionLst = By.xpath("//select[@title='Results per page'][1]");
    private By productInList = By.xpath("//div[@class='product-primary']");
    private By nextPgArrowBtn = By.xpath("//a[@title='Next'][1]");
    private By pagesAmount = By.xpath("//p[@class='amount amount--has-pages']");
    private By showPrice = By.cssSelector(".category-products > .toolbar > .sorter > .sort-by > select[title='Sort By']");
    private By productItem = By.xpath("//*[@id='products-list']/li");
    private By productItemPrice = By.xpath("//*[@class!='price-to']/*[@class='price']");
    private By productItemOldPrice = By.cssSelector(".product-shop .price-box span.old-price .price");
    private By filterPrice = By.xpath("(//a/span[@class='price']//..)[1]");
    private By addToWishList = By.cssSelector(" .add-to-links  .link-wishlist");
    private By itemName = By.cssSelector("#products-list .product-name");

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

    @Getter
    private Button FilterPrice = new Button(filterPrice, " $0.00 - $99.99 filter in PRICE");




    public ElectronicsPage clickShowAsList() {
        getShowAsList().click();
        return this;
    }

    public ElectronicsPage clickShowDropDown(String value) {
        getShowSelectionList().select(value);
        return this;
    }

    public int getProductsNumber() {
        List<WebElement> welist = getDriver().findElements(productInList);
        return welist.size();
    }

    public ElectronicsPage clickNextPgBtn() {
        while (getNextPgSmallArrowBtn().isEnabled(1)) {
            getNextPgSmallArrowBtn().click();
        }
        return this;
    }

    public void checkNumbersOfItemsOnEachPage(int expectedItems) {
        int pageNumber = 1;
        do {
            if (pageNumber != 1)
                getNextPgSmallArrowBtn().click();

            int numberOfItems = getDriver().findElements(productItem).size();
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

    public enum SortDirection {
        ASK(-1), DESC(1);

        public final int value;

        SortDirection(int value) {
            this.value = value;
        }
    }

    public ElectronicsPage setPrice(SortBy SortBy) {
        getShowPrice().select(SortBy.toString());
        return this;
    }

    private double parcePrice(String value) {
        return Double.parseDouble(value.substring(1).replace(",", ""));
    }

    public ElectronicsPage checkSortingLogic(SortDirection direction) {
        List<WebElement> items = getDriver().findElements(productItem);
        LinkedList<Double> itemsPriceList = new LinkedList<Double>();

        for ( WebElement item : items) {
            try {
                WebElement element = item.findElement(productItemPrice);
                String value = element.getAttribute("innerHTML");

                if (value.length() > 0) {
                    itemsPriceList.add(parcePrice(value));
                } else {
                    throw new NumberFormatException();
                }
            } catch (NoSuchElementException e) {
                items = item.findElements(productItemOldPrice);
                item.getAttribute("innerHTML");
                if(items.size() == 0) {
                    e.printStackTrace();
                    throw new NoSuchElementException("Product price box not rendered");
                }
            } catch (NumberFormatException e) {
                e.printStackTrace();
                throw new NumberFormatException("Product price have invalid format");
            }
        }

        for ( int index = 1; index < itemsPriceList.size(); index++) {
            Double priceA = itemsPriceList.get(index - 1);
            Double priceB = itemsPriceList.get(index);

            int compValue = priceA.compareTo(priceB);
            boolean result = compValue == direction.value || compValue == 0;

            Assert.assertTrue(result, String.format("Items are not sordted {%s} properly {%f <> %f}", direction.toString(), priceA, priceB)); // a > b
        }
        return this;
    }

    public ElectronicsPage clickFilterPrice() {
        getFilterPrice().click();
        return this;
    }

    public void checkFilterPrice() {
        List<WebElement> eltList = getDriver().findElements(filterPrice);
        for (WebElement e : eltList) {
            double price = StringProcessor.stringToDouble(e.getText());
            Assert.assertTrue(price < 100.00, String.format("Price %s less than 100", price));
        }
    }

    public String clickAddToWishList() {
        String toReturn;
        List<WebElement> items = getDriver().findElements(productItem);
        WebElement randomItem = items.get(new Random().nextInt(items.size() - 1));
        toReturn=randomItem.findElement(itemName).getText();
        WebElement wishBtn = randomItem.findElement(addToWishList);
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", wishBtn);
                wishBtn.click();
        return toReturn;
    }
}

