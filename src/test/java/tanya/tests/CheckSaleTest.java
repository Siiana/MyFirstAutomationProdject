package tanya.tests;

import org.testng.annotations.Test;

public class CheckSaleTest extends BaseTest {


    @Test
    public void checkSale() {
        mainPage.clickOnSale()
                .clickGridView()
                .clickShowDropDown("36")
                .comparePrices();
    }

}
