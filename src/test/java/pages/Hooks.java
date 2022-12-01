package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Hooks {

    static WebDriver driver;

    public static void beforeScope() {
        System.setProperty("webdriver.chrome.driver", "/Users/Rajeshwaran_Sarangarajan/Downloads/chromedriver"); //Located in C:
        driver = new ChromeDriver();
    }

    public static void afterScope() {
        driver.quit();
    }
}
