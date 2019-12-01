package tanya.pageObject;

import io.qameta.allure.Step;
import lombok.Getter;
import org.openqa.selenium.By;
import org.testng.Assert;
import tanya.elements.Button;
import tanya.elements.TextField;
import tanya.helpers.StringProcessor;


public class CartPage extends AbstractPage {

    private By pageTitle = By.xpath("//h1[contains(text(),'Shopping Cart')]");
    private By productName = By.xpath("//h2[@class='product-name']");
    private By productPrice = By.xpath("//td[@class='product-cart-price']/span");
    private By emptyCartBtn = By.xpath("//button[@value='empty_cart']");
    private By grandTotal = By.xpath("//strong//span[@class='price']");
    private By subTotal = By.xpath("//td[@class='product-cart-total']//span[@class='price']");

    @Getter
    private TextField PageTitle = new TextField(pageTitle, "SHOPPING CART title");

    @Getter
    private TextField ProductName = new TextField(productName, "PRODUCT NAME");

    @Getter
    private TextField ProductPrice = new TextField(productPrice, "PRODUCT PRICE");

    @Getter
    private Button EmptyCart = new Button(emptyCartBtn, "Empty Cart");

    @Getter
    private TextField GrandTotal = new TextField(grandTotal, "Grand Total price");

    @Getter
    private TextField SubTotal = new TextField(subTotal, "SubTotal price");


    //Constructors
    public CartPage(String prodName, String prodPrice) {
        isCartPageOpened();
        checkProductName(prodName);
        checkProductPrice(prodPrice);
    }

    public CartPage() {
    }

    @Step
    private void isCartPageOpened() {
        //Assert.assertTrue(PageTitle.isExists(),"Expected: Cart Page is opened");
        PageTitle.verify();
    }

    //check is product name the same as was added
    @Step
    private void checkProductName(String expectProdName) {
        String actualName = getProductName().getText();
        Assert.assertEquals(expectProdName, actualName,
                String.format("Expected name: %s but found: %s", expectProdName, actualName));
    }

    @Step
    private void checkProductPrice(String expectProdPrice) {
        String actualPrice = getProductPrice().getText();
        //soft assertion due to some products hasn't price
        softAssert.assertEquals(expectProdPrice, actualPrice,
                String.format("Expected name: %s but found: %s", expectProdPrice, actualPrice));
    }

    public void checkCartPrices() {
        double grandTotal = StringProcessor.stringToDouble(GrandTotal.getText());
        double subTotal = StringProcessor.stringToDouble(SubTotal.getText());
        Assert.assertEquals(grandTotal, subTotal,
                String.format("Expected: 'Grand total' value %s  = Subtotal value %s", grandTotal, subTotal));
    }
}
