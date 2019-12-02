package tanya.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckItemsCounterTest extends BaseTest {


    @Test
    public void checkItemsCounter() {
        int num = mainPage
                .clickHomeAndDecorButton()
                .clickOnElectronicsItem()
                .clickShowAsList()
                .clickShowDropDown("25")
                .getProductsNumber();
        Assert.assertEquals(num, 12, "Number of products in list = 12");
    }

}


