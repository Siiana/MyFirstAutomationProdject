package tanya.pageObject;

import io.qameta.allure.Step;
import lombok.Getter;
import org.openqa.selenium.By;
import tanya.elements.Button;
import tanya.elements.DropDownList;


public class MainPage extends AbstractPage{
    private By languageDropDown = By.id("select-language");
    private By homeAndDecorMenu = By.xpath("//a[@class='level0 has-children'][contains(text(),'Home & Decor')]");
    private By electronics = By.xpath("//a[contains(text(),'Electronics')]");
    private By saleBtn = By.xpath("//a[contains(text(),'Sale')]");
    private By account = By.cssSelector(".skip-account.skip-link > .label");
    private By login = By.cssSelector("[title='Log In']");

    @Getter
    DropDownList LanguageDropDown = new DropDownList(languageDropDown, "Language dropdown list");

    @Getter
    Button HomeAndDecorButton = new Button(homeAndDecorMenu, "HOME&DECOR");

    @Getter
    Button Electronics = new Button(electronics, "Electronics");

    @Getter
    private Button Sale = new Button(saleBtn, "Main menu SALE");

    @Getter
    private Button Account = new Button(account, "Account");

    @Getter
    private Button Login = new Button (login, "Login");





    public enum Language {
        AUTOMATION("Automation"),
        ENGLISH("English");

        private String text;

        Language(String text) {
            this.text = text;
        }

        @Override
        public String toString() {
            return text;
        }
    }

    @Step
    public MainPage setLanguage(Language language) {
        getLanguageDropDown().select(language.toString());
        return this;
    }

    @Step
    public MainPage clickHomeAndDecorButton() {
        getHomeAndDecorButton().setFocusOn();
        return this;
    }

    @Step
    public ElectronicsPage clickOnElectronicsItem() {
        getElectronics().click();
        return new ElectronicsPage();
    }

    @Step
    public SalePage clickOnSale() {
        getSale().click();
        return new SalePage();
    }

    @Step
    public MainPage openAccountMenu() {
        getAccount().click();
        return this;
    }

    @Step
    public LoginPage openLoginPage() {
        openAccountMenu();
        getLogin().click();
        return new LoginPage();
    }


}
