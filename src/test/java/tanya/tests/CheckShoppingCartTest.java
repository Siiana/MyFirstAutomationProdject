package tanya.tests;

import io.qameta.allure.Step;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import tanya.pageObject.CartPage;


public class CheckShoppingCartTest extends BaseTest {


    @AfterMethod
    @Step
    public void emptyCart() {
        CartPage cartPage = new CartPage();
        if (cartPage.getEmptyCart().isExists()) {
            cartPage.getEmptyCart().click();
        }
    }


    @Test
    public void checkShoppingCartItemName() {
        mainPage
                .clickHomeAndDecorButton()
                .clickOnElectronicsItem()
                .clickGridViewBtn()
                .clickShowDropDown("36")
                .clickRandomProduct()
                .clickAddToCart()
                .checkCartPrices();

    }
}
