package tanya.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import tanya.pageObject.ElectronicsPage;
import tanya.pageObject.MainPage;

public class CheckSortByPriceTest extends BaseTest {
    private MainPage mainPage;

    @BeforeMethod
    public void login() {
        mainPage = new MainPage()
                .setLanguage(MainPage.Language.AUTOMATION)
                .openLoginPage()
                .loginWithUserNamePassword("siianaelfiyka@gmail.com", "123456");
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
}
