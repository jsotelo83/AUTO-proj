package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BasePage {
    public static WebDriver driver;

    public BasePage (WebDriver driver){
        this.driver = driver;
    }

    static String baseURL = "https://www.wikipedia.org/";

    public static void goTo (String URL){
        driver.get(URL);
    }

    public static void click (By element) {
        driver.findElement(element).click();
    }

    public static void writeText (By element, String text) {
        driver.findElement(element).sendKeys(text);
    }

    public static String readText (By element) {
        return driver.findElement(element).getText();
    }
}