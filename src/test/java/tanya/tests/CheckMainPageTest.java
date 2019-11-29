package tanya.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import tanya.pageObject.ElectronicsPage;
import tanya.pageObject.MainPage;
import tanya.pageObject.ShoppingCartPage;
import tanya.pageObject.WishListPage;
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
    public void checkSortByPrice() {
        mainPage.clickHomeAndDecorButton()
                .clickOnElectronicsItem()
                .clickShowAsList()
                .clickShowDropDown("25")
                .setPrice(ElectronicsPage.SortBy.PRICE)
                .checkSortingPrice(ElectronicsPage.SortDirection.ASK);
    }

    @Test
    public void checkPriceFilter() {
        mainPage.clickHomeAndDecorButton()
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
        List<String> actualNames = new WishListPage().getItemNames();
        Assert.assertTrue(actualNames.contains(expectedProductName), String.format("Expected product %s not found in list %s", expectedProductName, actualNames));


    }

    @Test
    public void checkSale() {
        mainPage.clickOnSale()
                .clickGridView()
                .clickShowDropDown("36")
                .comparePrices();
    }

    @Test
    public void checkShoppingCart() {
        String expectedProductName = mainPage
                .clickHomeAndDecorButton()
                .clickOnElectronicsItem()
                .clickGridViewBtn()
                .clickShowDropDown("36")
                .clickAddToShoppingCart();
        List<String> actualNames = new ShoppingCartPage().getItemNames();
        Assert.assertTrue(actualNames.contains(expectedProductName), String.format("Expected product %s not found in list %s", expectedProductName, actualNames));



    }


}


