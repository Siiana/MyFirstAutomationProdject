package tanya.tests;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import static tanya.DriveManager.*;


public class BaseTest {
    @BeforeClass
    public void setupPage(){
        goTo("http://magento.mainacad.com");
    }

    @AfterClass
    public void tearDown(){
        killDriver();
    }
}

