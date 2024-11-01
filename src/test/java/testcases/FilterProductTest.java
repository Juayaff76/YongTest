package testcases;

import org.testng.annotations.Test;
import pages.FilterProductPage;
import pages.LoginPage;


public class FilterProductTest extends BaseTest {

    FilterProductPage filterProductPage;
   // ProductPage productPage;

    @Test
    public void validateSuccessFilterOfProduct() {
        loginPage = new LoginPage(driver);
        loginPage.enterUserName("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.pressLoginButton();
        filterProductPage = new FilterProductPage(driver);
        filterProductPage.filterPriceOption();
    }

}
