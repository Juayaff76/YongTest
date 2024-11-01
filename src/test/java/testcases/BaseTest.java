package testcases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import pages.LoginPage;
import utility.WebDriverFactory;

public class BaseTest {

    WebDriver driver;
    LoginPage loginPage;

    @BeforeMethod
    public void setup() {
        driver = WebDriverFactory.getInstance().getDriver("Chrome");
        driver.get("https://www.saucedemo.com/v1/index.html");
//        loginPage = new LoginPage(driver);
//        loginPage.enterUserName("standard_user");
//        loginPage.enterPassword("secret_sauce");
//        loginPage.pressLoginButton();
    }

    @AfterSuite
    public void tearDown(){
        if(driver!=null){
            driver.quit();
        }
    }
}