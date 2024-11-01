package testcases;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTest extends BaseTest {

    LoginPage loginPage;

    @Test(priority = 1)
    public void testSuccessfulLogin() {
        loginPage = new LoginPage(driver);
        loginPage.enterUserName("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.pressLoginButton();
        loginPage.validateSuccessfulLogIn();
    }

    @Test(priority = 2)
    public void testUnSuccessfulLogin()  {
        loginPage = new LoginPage(driver);
        loginPage.enterUserName("standard_users");
        loginPage.enterPassword("secret_sauces");
        loginPage.pressLoginButton();
        loginPage.validateInvalidLogIn();
    }
}
