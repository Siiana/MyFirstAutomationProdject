package tanya.elements;

import org.openqa.selenium.By;

public class InputField extends BaseElement {

    public InputField(By locator, String description) {
        super(locator, description);
    }

    public void setText(String text){
        get().sendKeys(text);
    }

    public void getText (String text){
        get().sendKeys(text);
    }

    public void clear (){
        get().clear();
    }
}
