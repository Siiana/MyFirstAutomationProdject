package tanya.tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import tanya.elements.BaseElement;


public class BaseTest {
    @Test
    public static void test(){
        tanya.DriveManager.goTo("https://www.toolsqa.com/automation-practice-form/");
        BaseElement info = new BaseElement(By.cssSelector("p:nth-child(3) em"), "info");
        BaseElement info1 = new BaseElement(By.cssSelector("legend strong"), "info");
        BaseElement info2 = new BaseElement(By.cssSelector("input[name='firstname']"), "info");
        BaseElement info3 = new BaseElement(By.linkText("Partial Link Test"), "info");

        info.isExists();
        info1.isExists();
        info2.isExists();
        info3.isExists();
    }
}

