package tanya.pageObject;

import org.openqa.selenium.JavascriptExecutor;

import static tanya.DriveManager.getDriver;

public class AbstractPage {

        public AbstractPage(){

            //close banner
            ((JavascriptExecutor)getDriver()).executeScript("document.getElementById('close-fixedban').click()");
        }

}
