package tanya.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import tanya.pageObject.Electronics;
import tanya.pageObject.MainPage;

public class CheckMainPage extends BaseTest {

    @Test
    public void checkItemsCounter() {
        MainPage mainPage = new MainPage();

        int num = mainPage.setLanguage(MainPage.Language.ENGLISH)
                .clickHomeAndDecorButton()
                .clickOnElectronicsItem()
                .clickShowAsList()
                .clickShowDropDown("25").getProductsNumber();
        Assert.assertEquals(num, 12, "Number of products in list = 12");
    }

    @Test
    public void checkShowSelect() {
        MainPage mainPage = new MainPage();

        mainPage.setLanguage(MainPage.Language.ENGLISH)
                .clickHomeAndDecorButton()
                .clickOnElectronicsItem()
                .clickShowAsList()
                .clickShowDropDown("5")
                .checkNumbersOfItemsOnEachPage(5);
    }

    @Test
    public void checkSortBy() {
        MainPage mainPage = new MainPage();
        mainPage.setLanguage(MainPage.Language.ENGLISH)
                .clickHomeAndDecorButton()
                .clickOnElectronicsItem()
                .clickShowAsList()
                .setPrice(Electronics.SortBy.PRICE);
    }


}


