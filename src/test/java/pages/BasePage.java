package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    public WebDriver driver;
    public WebDriverWait wait;

    public BasePage (WebDriver driver, WebDriverWait wait){
        this.driver = driver;
        this.wait = wait;
    }

    String baseURL = "https://www.wikipedia.org/";

    public void goTo (String URL){
        driver.get(URL);
    }

    public void click (By element) {
        driver.findElement(element).click();
    }

    public void writeText (By element, String text) {
        driver.findElement(element).sendKeys(text);
    }

    public String readText (By element) {
        return driver.findElement(element).getText();
    }
}