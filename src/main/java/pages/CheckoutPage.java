package pages;

import junit.framework.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.awt.*;

public class CheckoutPage {

    WebDriver driver;

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
    }

    By checkoutBtn = By.xpath("//a[contains(text(),'CHECKOUT')]");
    By firstName = By.xpath("//input[@id='first-name']");
    By lastName = By.xpath("//input[@id='last-name']");
    By zipCode = By.xpath("//input[@id='postal-code']");
    By continueBtn = By.xpath("//input[@value='CONTINUE']");
    By finishBtn = By.xpath("//a[contains(text(),'FINISH')]");
    By confirmationMessage = By.xpath("//h2[contains(text(),'THANK YOU FOR YOUR ORDER')]");


    public void clickOnCheckOutBtn() {
        driver.findElement(checkoutBtn).click();
    }

    public void enterFirstName(String fname) {
        driver.findElement(firstName).sendKeys(fname);
    }

    public void enterLastName(String lname) {
        driver.findElement(lastName).sendKeys(lname);
    }

    public void enterZipCode(String code) {
        driver.findElement(zipCode).sendKeys(code);
    }

    public void clickOnContinueBtn() {
        driver.findElement(continueBtn).click();
    }

    public void clickOnFinishBtn() {
        driver.findElement(finishBtn).click();
    }

    public void validateCheckOutCompletedSuccessfully() {
        WebElement confirmationMessage = driver.findElement(By.xpath("//h2[contains(text(),'THANK YOU FOR YOUR ORDER')]"));
        Assert.assertTrue("Order confirmation page is Not displayed", confirmationMessage.isDisplayed());
    }

}
