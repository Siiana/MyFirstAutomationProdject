package tanya.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
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

    public By getLocator() {
        return locator;
    }

    protected WebElement get() {
        WebElement element = getDriver().findElement(locator);
        highlight(element);
        return element;
    }

    public boolean isExists(long... timeout) {
        long currentTimeout = 5;
        if (timeout.length > 0) {
            currentTimeout = timeout[0];
        }
        WebDriverWait wait = new WebDriverWait(getDriver(), currentTimeout);
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            get();
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

    private void highlight(WebElement element) {
        unhighlight();
        lastElement = element;
        lastBorder = (String) ((JavascriptExecutor) getDriver()).executeScript("arguments[0].setAttribute('style', arguments[1]);", element, "color: yellow; border: 2px solid yellow;");

    }

    private void unhighlight() {
        if (lastElement != null) {
            try {
                ((JavascriptExecutor) getDriver()).executeScript("arguments[0].setAttribute('style', arguments[1]);", lastElement, lastBorder);
            } finally {
                lastElement = null;
            }
        }
    }

}
