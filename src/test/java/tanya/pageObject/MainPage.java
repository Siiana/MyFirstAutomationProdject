package tanya.pageObject;

import lombok.Getter;
import org.openqa.selenium.By;
import tanya.elements.Button;
import tanya.elements.DropDownList;


public class MainPage extends AbstractPage{
    private By languageDropDown = By.id("select-language");
    private By homeAndDecorMenu = By.xpath("//a[@class='level0 has-children'][contains(text(),'Home & Decor')]");
    private By electronics = By.xpath("//a[contains(text(),'Electronics')]");
    private By account = By.cssSelector(".skip-account.skip-link > .label");
    private By login = By.cssSelector("[title='Log In']");

    @Getter
    DropDownList LanguageDropDown = new DropDownList(languageDropDown, "Language dropdown list");

    @Getter
    Button HomeAndDecorButton = new Button(homeAndDecorMenu, "HOME&DECOR");

    @Getter
    Button Electronics = new Button(electronics, "Electronics");

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

    public MainPage setLanguage(Language language) {
        getLanguageDropDown().select(language.toString());
        return this;
    }

    public MainPage clickHomeAndDecorButton() {
        getHomeAndDecorButton().setFocusOn();
        return this;
    }

    public ElectronicsPage clickOnElectronicsItem() {
        getElectronics().click();
        return new ElectronicsPage();
    }

    public MainPage openAccountMenu() {
        getAccount().click();
        return this;
    }


    public LoginPage openLoginPage() {
        openAccountMenu();
        getLogin().click();
        return new LoginPage();
    }


}
