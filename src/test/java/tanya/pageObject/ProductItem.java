package tanya.pageObject;


import lombok.Getter;
import org.openqa.selenium.By;
import tanya.elements.Button;
import tanya.elements.TextField;

/*
 *   POM: Product card (details)
 * */
public class ProductItem {

    private By itemPrice = By.xpath("//div[@class='price-box']//span[@class='price']");
    private By itemNameInList = By.cssSelector("#products-list .product-name");
    private By itemNameInGrid = By.xpath("//h2[contains(text(),'')]");
    private By addToWishListBtn = By.cssSelector(" .add-to-links  .link-wishlist");
    //private By addToCartBtn = By.xpath("//button[@title='Add to Cart']");
    private By addToCartBtn = By.xpath("//span[contains(text(),'Add to Cart')]");


    @Getter
    private TextField ItemPrice = new TextField(itemPrice, "Price of a product");

    @Getter
    private TextField NameInListView = new TextField(itemNameInList, "Product name in view as List");

    @Getter
    private TextField NameInGridView = new TextField(itemNameInGrid, "Product name in view as Grid");

    @Getter
    private Button addToWishList = new Button(addToWishListBtn,"Add To Wish list");

    @Getter
    private Button addToCart = new Button(addToCartBtn,"Add To Cart");

}
