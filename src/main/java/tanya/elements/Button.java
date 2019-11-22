package tanya.elements;

import org.openqa.selenium.By;

public class Button extends TextField {
    public Button(By locator, String description) {
        super(locator, description);
    }
    public void click(){
         get().click();
    }

}
