package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class HomePage extends BasePage {

    public HomePage (WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    By searchInput = By.id("searchInput");
    By searchButton = By.xpath("//*[@id=\"search-form\"]/fieldset/button");

    public String getBaseURL(){
        return baseURL;
    }

    public void goToHome (){
        goTo(baseURL);
    }

    public void search(String searchString){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement element = wait.until(
                ExpectedConditions.visibilityOfElementLocated(searchInput));
        element.sendKeys(searchString);
        click(searchButton);
    }

    public void validateCurrentURL (String URL){
        Assert.assertEquals(driver.getCurrentUrl(), URL);
    }

}
