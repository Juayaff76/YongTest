package pages;

import junit.framework.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddToCartPage {

    WebDriver driver;

    public AddToCartPage(WebDriver driver) {
        this.driver = driver;
    }

    By product = By.xpath("//div[contains(text(),'Sauce Labs Bolt T-Shirt')]");
    By addToCartBtn = By.xpath("//button[contains(text(),'ADD TO CART')]");
    By cartIcon = By.xpath("//span[@class='fa-layers-counter shopping_cart_badge']");


    //Select an item and click the “Add to Cart” button
    public void addProductToCart() {
        driver.findElement(product).click();
        driver.findElement(addToCartBtn).click();

        WebElement cartBadge = driver.findElement(By.xpath("//span[@class='fa-layers-counter shopping_cart_badge']"));
        String cartCountText = cartBadge.getText();
        Assert.assertEquals("Cart count is incorrect", "1", cartCountText);

    }

    public void checkBasket() {
        driver.findElement(cartIcon).click();
    }

    //verify that the cart count increases and displays the correct item count
    public void verifyProductInBasket() {
        WebElement cartItem = driver.findElement(By.xpath("//div[contains(text(),'Sauce Labs Bolt T-Shirt')]"));
        Assert.assertTrue("Added item is not present in the cart", cartItem.isDisplayed());
    }


}
