package tanya.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import tanya.pageObject.MainPage;

import static tanya.DriveManager.*;


public class BaseTest {
    protected MainPage mainPage;

    @BeforeMethod(alwaysRun = true)
    public void _setupPage() {
        goTo("http://magento.mainacad.com");
    }

    @BeforeMethod(alwaysRun = true)
    public void login() {
        mainPage = new MainPage()
                .setLanguage(MainPage.Language.valueOf(System.getProperty("languageName").toUpperCase()))
                .openLoginPage()
                .loginWithUserNamePassword("siianaelfiyka@gmail.com", "123456");
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        killDriver();
    }
}

