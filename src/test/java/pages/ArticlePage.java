package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class ArticlePage extends BasePage {

    public ArticlePage (WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    By articleTitle = By.id("firstHeading");
    By studioAlbumsRow = By.xpath("//*[contains(text(), \"Studio albums\")]/../td");
    By reputationStudioAlbumLink = By.xpath("//*[contains(text(), \"Studio albums\")]/../td//*[contains(text(), \"Reputation\")]");
    By popUp = By.className("mwe-popups");

    public String getPageTitle(){
        return driver.getTitle();
    }

    public String getArticleTitle(){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement element = wait.until(
                ExpectedConditions.visibilityOfElementLocated(articleTitle));
        return element.getText();
    }

    public void validateExpectedArticle(String articleName){
        String actualPageTitle = this.getPageTitle();
        String actualArticleTitle = this.getArticleTitle();

        Assert.assertTrue(actualPageTitle.contains(articleName), "The page title is different than expected");
        Assert.assertTrue(actualArticleTitle.contains(articleName), "The article title is different than expected");
    }

    public void validateExpectedStudioAlbums(String[] albums){
        String albumsString = readText(studioAlbumsRow);
        System.out.print(albumsString);
        Boolean flag = true;
        for (String album : albums) {
            if (albumsString.contains(album) == false){
                flag = false;
            }

        }

        Assert.assertTrue(flag, "The albums don't match");
    }

    public void validateHoverMessageAppears(){
        WebElement link = driver.findElement(reputationStudioAlbumLink);

        click(studioAlbumsRow);

        String javaScript = "var evObj = document.createEvent('MouseEvents');" +
                "evObj.initMouseEvent(\"mouseover\",true, false, window, 0, 0, 0, 0, 0, false, false, false, false, 0, null);" +
                "arguments[0].dispatchEvent(evObj);";


        ((JavascriptExecutor)driver).executeScript(javaScript, link);

        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement element = wait.until(
                ExpectedConditions.visibilityOfElementLocated(popUp));

        Assert.assertTrue(element.isDisplayed());

    }
}
