package tanya.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import tanya.pageObject.MainPage;

public class CheckSaleTest extends BaseTest {

    private MainPage mainPage;

    @BeforeMethod
    public void login() {
        mainPage = new MainPage()
                .setLanguage(MainPage.Language.AUTOMATION)
                .openLoginPage()
                .loginWithUserNamePassword("siianaelfiyka@gmail.com", "123456");
    }

    @Test
    public void checkSale() {
        mainPage.clickOnSale()
                .clickGridView()
                .clickShowDropDown("36")
                .comparePrices();
    }

}
