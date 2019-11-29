package tanya.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import static tanya.DriveManager.*;


public class BaseTest {
    @BeforeMethod(alwaysRun = true)
    public void setupPage() {
        goTo("http://magento.mainacad.com");
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        killDriver();
    }
}

