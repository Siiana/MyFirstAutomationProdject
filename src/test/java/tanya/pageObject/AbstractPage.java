package tanya.pageObject;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.asserts.Assertion;

import static tanya.DriveManager.getDriver;

public class AbstractPage {

    protected Assertion softAssert = new Assertion();

        public AbstractPage(){

            //close banner
            ((JavascriptExecutor)getDriver()).executeScript("document.getElementById('close-fixedban').click()");
        }

}
