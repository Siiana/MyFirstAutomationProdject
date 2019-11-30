package tanya.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import tanya.pageObject.MainPage;
import tanya.pageObject.ShoppingCartPage;

import java.util.List;

public class CheckShoppingCartTest extends BaseTest{
    private MainPage mainPage;

    @BeforeMethod
    public void login() {
        mainPage = new MainPage()
                .setLanguage(MainPage.Language.AUTOMATION)
                .openLoginPage()
                .loginWithUserNamePassword("siianaelfiyka@gmail.com", "123456");
    }


    @Test
    public void checkShoppingCartItemName() {
        String expectedProductName = mainPage
                .clickHomeAndDecorButton()
                .clickOnElectronicsItem()
                .clickGridViewBtn()
                .clickShowDropDown("36")
                .checkShoppingCartItemName();
        List<String> actualNames = new ShoppingCartPage().getItemNames();
        Assert.assertTrue(actualNames.contains(expectedProductName), String.format("Expected product %s not found in list %s", expectedProductName, actualNames));
    }

    @Test
    public void checkShoppingCartPrice() {
        String expectedPrice = mainPage
                .clickHomeAndDecorButton()
                .clickOnElectronicsItem()
                .clickGridViewBtn()
                .clickShowDropDown("36")
                .checkShoppingCartPrice();
        List<String> actualPrice = new ShoppingCartPage().getPrice();
        Assert.assertTrue(actualPrice.contains(expectedPrice), String.format("Expected price %s not found in list %s", expectedPrice, actualPrice));
    }

    @Test
    public void checkShoppingCartGrandTotal() {
        mainPage
                .clickHomeAndDecorButton()
                .clickOnElectronicsItem()
                .clickGridViewBtn()
                .clickShowDropDown("36")
                .addItemInkShoppingCart();
    }
}
