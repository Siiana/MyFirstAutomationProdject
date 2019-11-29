package tanya;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;


public class DriveManager {
    private static ThreadLocal<WebDriver> threadDriver = new ThreadLocal<>();

    private DriveManager() {
    }

    public static WebDriver getDriver() {
        if (threadDriver.get() == null)
            init();
        return threadDriver.get();
    }

    private static void init() {
        String browser = System.getProperty("browser", "chrome");
        if (browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            //ChromeOptions options = new ChromeOptions();
           // options.setHeadless(true);
            threadDriver.set(new ChromeDriver());
            //threadDriver.get().manage().window().fullscreen();
            threadDriver.get().manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
            threadDriver.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        }
        if (browser.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            threadDriver.set(new FirefoxDriver());
        }
        if (browser.equalsIgnoreCase("edge")) {
            WebDriverManager.edgedriver().setup();
            threadDriver.set(new EdgeDriver());
        }


    }


    public static void killDriver() {
        threadDriver.get().quit();
        threadDriver.remove();
    }

    public static void goTo(String url) {
        getDriver().navigate().to(url);
    }
}
