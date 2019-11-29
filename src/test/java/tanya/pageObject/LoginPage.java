package tanya.pageObject;

import io.qameta.allure.Step;
import lombok.Getter;
import org.openqa.selenium.By;
import tanya.elements.Button;
import tanya.elements.InputField;

public class LoginPage extends AbstractPage {

    private By inputEmail = By.cssSelector("input#email");
    private By inputPassword = By.cssSelector("input#pass");
    private By buttonLogin = By.cssSelector("button#send2");

    @Getter
    private InputField Email = new InputField(inputEmail, "Email Field");

    @Getter
    private InputField Password = new InputField(inputPassword, "Password Field");

    @Getter
    private Button Login = new Button(buttonLogin, "Login");


    public MainPage loginWithUserNamePassword(String userName, String password) {
        return inputEmail(userName)
                .inputPassword(password)
                .clickLogin();
    }

    @Step
    public LoginPage inputEmail(String email) {
        Email.setText(email);
        return this;
    }

    @Step
    public LoginPage inputPassword(String password) {
        Password.setText(password);
        return this;
    }

    @Step
    public MainPage clickLogin() {
        Login.click();
        return new MainPage();
    }

}
