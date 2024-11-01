package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import junit.framework.Assert;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FilterProductPage {

    WebDriver driver;

    public FilterProductPage(WebDriver driver) {
        this.driver = driver;
    }

    By filterDropdown = By.xpath("//select[@class='product_sort_container']");
    By priceLowToHighOption = By.xpath("//option[@value='lohi']");


    public void filterPriceOption() {
        driver.findElement(filterDropdown).click();
        driver.findElement(priceLowToHighOption).click();

        // Step 4: Verify that products are sorted by price (low to high)
        List<WebElement> productPrices = driver.findElements(By.xpath("//div[@class='inventory_item_price']"));

        // Extract the prices and store them in a list
        List<Double> actualPrices = new ArrayList<>();
        for (WebElement priceElement : productPrices) {
            String priceText = priceElement.getText().replace("$", ""); // Remove $ symbol
            actualPrices.add(Double.parseDouble(priceText));
        }

        // Create a sorted copy of the actualPrices list to compare with
        List<Double> sortedPrices = new ArrayList<>(actualPrices);
        Collections.sort(sortedPrices);
        System.out.println("Expected Sorted Prices: " + sortedPrices);
        // Assert that the products are sorted in ascending order by price
        Assert.assertEquals("Products are not sorted by price from low to high", sortedPrices, actualPrices);

    }


}
