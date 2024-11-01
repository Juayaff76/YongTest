package testcases;

import org.testng.annotations.Test;
import pages.AddToCartPage;
import pages.CheckoutPage;
import pages.LoginPage;

public class CheckoutTest extends BaseTest{

   CheckoutPage ckoutPage;
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

        ckoutPage = new CheckoutPage(driver);
        ckoutPage.clickOnCheckOutBtn();
        ckoutPage.enterFirstName("James");
        ckoutPage.enterLastName("Peter");
        ckoutPage.enterZipCode("LE45PH");
        ckoutPage.clickOnContinueBtn();
        ckoutPage.clickOnFinishBtn();
        ckoutPage.validateCheckOutCompletedSuccessfully();

    }

}
