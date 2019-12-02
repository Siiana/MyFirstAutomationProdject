package tanya.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import tanya.pageObject.WishListPage;

import java.util.List;

public class CheckAddWishListTest extends BaseTest {


    @Test
    public void checkAddWishList() {
        String expectedProductName = mainPage
                .clickHomeAndDecorButton()
                .clickOnElectronicsItem()
                .clickShowAsList()
                .clickShowDropDown("25")
                .clickAddToWishList();
        List<String> actualNames = new WishListPage().getItemNames();
        Assert.assertTrue(actualNames.contains(expectedProductName), String.format("Expected product %s not found in list %s", expectedProductName, actualNames));
    }
}
