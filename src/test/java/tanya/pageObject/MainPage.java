package tanya.pageObject;

import lombok.Getter;
import org.openqa.selenium.By;
import tanya.elements.Button;
import tanya.elements.DropDownList;


public class MainPage extends AbstractPage{
    private By languageDropDown = By.id("select-language");
    private By homeAndDecorMenu = By.xpath("//a[@class='level0 has-children'][contains(text(),'Home & Decor')]");
    private By electronics = By.xpath("//a[contains(text(),'Electronics')]");

    /*public DropDownList getLanguageDropDown() {
        return new DropDownList(languageDropDown, "Language DropDown list");
    }*/


    @Getter
    DropDownList LanguageDropDown = new DropDownList(languageDropDown, "Language dropdown list");

    @Getter
    Button HomeAndDecorButton = new Button(homeAndDecorMenu, "HOME&DECOR");

    @Getter
    Button Electronics = new Button(electronics, "Electronics");


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

    public Electronics clickOnElectronicsItem() {
        getElectronics().click();
        return new Electronics();
    }


}
