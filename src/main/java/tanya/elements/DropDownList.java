package tanya.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

public class DropDownList extends BaseElement{
    public DropDownList(By locator, String description) {
        super(locator, description);
    }

    public void select (String text){
        getSelectElement().selectByVisibleText(text);
    }

    public void select (int id){
        getSelectElement().deselectByIndex(id);
    }

    private Select getSelectElement (){
        return new Select(get());
    }
}

