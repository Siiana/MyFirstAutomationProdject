package tanya.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import tanya.pageObject.ElectronicsPage;
import tanya.pageObject.LoginPage;
import tanya.pageObject.MainPage;
import tanya.pageObject.WishList;

import java.util.List;

public class CheckMainPageTest extends BaseTest {
    private MainPage mainPage;

    @BeforeMethod
    public void login() {
        mainPage = new MainPage()
                .setLanguage(MainPage.Language.AUTOMATION)
                .openLoginPage()
                .loginWithUserNamePassword("siianaelfiyka@gmail.com", "123456");
    }


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

    @Test
    public void checkShowSelect() {

        mainPage.clickHomeAndDecorButton()
                .clickOnElectronicsItem()
                .clickShowAsList()
                .clickShowDropDown("5")
                .checkNumbersOfItemsOnEachPage(5);
    }

    @Test
    public void checkSortBy() {

        mainPage.clickHomeAndDecorButton()
                .clickOnElectronicsItem()
                .clickShowAsList()
                .clickShowDropDown("25")
                .setPrice(ElectronicsPage.SortBy.PRICE)
                .checkSortingLogic(ElectronicsPage.SortDirection.ASK);
    }

    @Test
    public void checkPriceFilter() {

        mainPage
                .clickHomeAndDecorButton()
                .clickOnElectronicsItem()
                .clickShowAsList()
                .clickShowDropDown("25")
                .clickFilterPrice()
                .checkFilterPrice();
    }

    @Test
    public void checkAddWishList() {
        String expectedProductName = mainPage
                .clickHomeAndDecorButton()
                .clickOnElectronicsItem()
                .clickShowAsList()
                .clickShowDropDown("25")
                .clickAddToWishList();
        List<String> actualNames = new WishList().getItemNames();
        Assert.assertTrue(actualNames.contains(expectedProductName),String.format("Expected product %s not found in list %s", expectedProductName, actualNames));


    }

    @Test
    public void checkSale() {


    }

    @Test
    public void checkShoppingCart() {

        mainPage
                .clickHomeAndDecorButton()
                .clickOnElectronicsItem()
                // інша кнопка сортування
                .clickShowDropDown("25");

    }


}


