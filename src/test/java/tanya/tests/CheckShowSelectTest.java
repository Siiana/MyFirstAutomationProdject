package tanya.tests;

import org.testng.annotations.Test;

public class CheckShowSelectTest extends BaseTest {

    @Test
    public void checkShowSelect() {
        mainPage.clickHomeAndDecorButton()
                .clickOnElectronicsItem()
                .clickShowAsList()
                .clickShowDropDown("5")
                .checkNumbersOfItemsOnEachPage(5);
    }
}
