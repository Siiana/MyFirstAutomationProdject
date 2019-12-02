package tanya.tests;

import org.testng.annotations.Test;

public class CheckPriceFilterTest extends BaseTest {


    @Test
    public void checkPriceFilter() {
        mainPage.clickHomeAndDecorButton()
                .clickOnElectronicsItem()
                .clickShowAsList()
                .clickShowDropDown("25")
                .clickFilterPrice()
                .checkFilterPrice();
    }
}
