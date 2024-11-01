package utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class WebDriverFactory {

    private static WebDriverFactory webDriverFactoryInstance = null;
    private static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<WebDriver>();

    private WebDriverFactory() {

    }

    public static WebDriverFactory getInstance() {
        if (webDriverFactoryInstance == null) {
            webDriverFactoryInstance = new WebDriverFactory();
        }
        return webDriverFactoryInstance;
    }

    private void initDriver(String driverName) {
        switch (driverName) {
            case "Chrome":
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--start-maximized");
                WebDriver driver = new ChromeDriver(options);
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
                tlDriver.set(driver);
                break;
            default:
                System.out.println("Unsupported Browser");
        }
    }

    public WebDriver getDriver(String browserName) {
        if (tlDriver.get() == null) {
            initDriver(browserName);
        }
        return tlDriver.get();
    }

}
