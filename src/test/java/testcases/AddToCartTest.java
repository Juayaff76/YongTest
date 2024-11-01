package testcases;
import org.testng.annotations.Test;
import pages.AddToCartPage;
import pages.LoginPage;


public class AddToCartTest extends BaseTest{


    AddToCartPage addToCartPage;

    @Test
    public void ValidateProductIsAddedToCart(){
        loginPage = new LoginPage(driver);
        loginPage.enterUserName("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.pressLoginButton();
        addToCartPage = new AddToCartPage(driver);
        addToCartPage.addProductToCart();
        addToCartPage.checkBasket();
        addToCartPage.verifyProductInBasket();
    }




}
