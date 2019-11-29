package tanya.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import static tanya.DriveManager.getDriver;


public class BaseElement {
    private By locator;
    private String description;
    private static WebElement lastElement;
    private static String lastBorder;

    public BaseElement(By locator, String description) {
        this.locator = locator;
        this.description = description;
    }

    public void scrollToMe(){
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", get());
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public By getLocator() {
        return locator;
    }

    protected WebElement get() {
        isExists(1);
        return getDriver().findElement(locator);
    }

    public boolean isExists(long... timeout) {
        long currentTimeout = 5;
        if (timeout.length > 0) {
            currentTimeout = timeout[0];
        }
        WebDriverWait wait = new WebDriverWait(getDriver(), currentTimeout);
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            highlight(locator);
            return true;
        } catch (Exception e) {
            return false;
        }
    }


    public boolean isEnabled(long... timeout) {
        if (isExists(timeout)) {
            return get().isEnabled();
        }
        return false;
    }

    public void verify() {
        Assert.assertTrue(isExists());
    }

    public void setFocusOn() {
        Actions moveTo = new Actions(getDriver()).moveToElement(get());
        moveTo.build().perform();
    }


    private void highlight(By elementLocator) {
        unhighlight();
        try {
            lastElement = getDriver().findElement(elementLocator);
            lastBorder = (String) ((JavascriptExecutor) getDriver()).executeScript("arguments[0].setAttribute('style', arguments[1]);", lastElement, "color: yellow; border: 2px solid yellow;");
        } catch (Exception e) {
        }

    }

    private void unhighlight() {
        if (lastElement != null) {
            try {
                ((JavascriptExecutor) getDriver()).executeScript("arguments[0].setAttribute('style', arguments[1]);", lastElement, lastBorder);
            } catch (Exception e)
            {}
            finally {
                lastElement = null;
            }
        }
    }

}
