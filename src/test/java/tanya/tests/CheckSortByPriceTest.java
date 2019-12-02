package tanya.tests;

import org.testng.annotations.Test;
import tanya.pageObject.ElectronicsPage;

public class CheckSortByPriceTest extends BaseTest {

    @Test
    public void checkSortByPrice() {
        mainPage.clickHomeAndDecorButton()
                .clickOnElectronicsItem()
                .clickShowAsList()
                .clickShowDropDown("25")
                .setPrice(ElectronicsPage.SortBy.PRICE)
                .checkSortingPrice(ElectronicsPage.SortDirection.ASK);
    }
}
