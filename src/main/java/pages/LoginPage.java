package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.junit.Assert;
import java.awt.*;

public class LoginPage {

    WebDriver driver;


    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    By userName = By.xpath("//input[@id='user-name']");
    By passWord = By.xpath("//input[@id='password']");
    By signInButton = By.xpath("//input[@id='login-button']");


    public void enterUserName(String username) {
        driver.findElement(userName).sendKeys(username);
    }

    public void enterPassword(String password) {
        driver.findElement(passWord).sendKeys(password);
    }

    public void pressLoginButton() {
        driver.findElement(signInButton).click();
    }

    //verify user is logged in successfully
    public void validateSuccessfulLogIn() {
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue("User is not on the products page", currentUrl.contains("inventory.html"));
    }

    // Verify that an error message appears with the expected text
    public void validateInvalidLogIn() {
        WebElement errorMessage = driver.findElement(By.xpath("//h3[@data-test='error']"));
        Assert.assertTrue("Error message is not displayed", errorMessage.isDisplayed());

    }

}
