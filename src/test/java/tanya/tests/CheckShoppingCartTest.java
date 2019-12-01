package tanya.tests;

import io.qameta.allure.Step;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import tanya.pageObject.CartPage;
import tanya.pageObject.MainPage;


public class CheckShoppingCartTest extends BaseTest{
    private MainPage mainPage;

    @AfterMethod
    @Step
    public void emptyCart(){
        CartPage cartPage = new CartPage();
        if(cartPage.getEmptyCart().isExists()){
            cartPage.getEmptyCart().click();
        }
    }

    @BeforeMethod
    public void login() {
        mainPage = new MainPage()
                .setLanguage(MainPage.Language.AUTOMATION)
                .openLoginPage()
                .loginWithUserNamePassword("siianaelfiyka@gmail.com", "123456");
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
