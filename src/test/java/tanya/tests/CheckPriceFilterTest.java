package tanya.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import tanya.pageObject.MainPage;

public class CheckPriceFilterTest extends BaseTest {
    private MainPage mainPage;

    @BeforeMethod
    public void login() {
        mainPage = new MainPage()
                .setLanguage(MainPage.Language.AUTOMATION)
                .openLoginPage()
                .loginWithUserNamePassword("siianaelfiyka@gmail.com", "123456");
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
}
