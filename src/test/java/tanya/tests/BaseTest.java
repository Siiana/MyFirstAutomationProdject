package tanya.tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import tanya.pageObject.LoginPage;

import static tanya.DriveManager.*;


public class BaseTest {
    @BeforeMethod(alwaysRun = true)
    public void setupPage() {
        goTo("http://magento.mainacad.com");
    }

    /*@BeforeClass
    public void loginPage() {
        LoginPage loginPage = new LoginPage();
        loginPage.clickLoginInMyWishList()
                .inputEmail("siianaelfiyka@gmail.com")
                .inputPassword("123456")
                .clickLogin();
    }*/

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        killDriver();
    }
}

