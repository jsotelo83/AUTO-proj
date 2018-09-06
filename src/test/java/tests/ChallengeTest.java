package tests;
import org.testng.annotations.Test;
import pages.ArticlePage;
import pages.HomePage;

public class ChallengeTest extends BaseTest {


    @Test (priority = 0, enabled = true)
    public void navigateToHomeTest () throws InterruptedException {

        HomePage homePage = new HomePage(driver);

        homePage.goToHome();

        homePage.validateCurrentURL(homePage.getBaseURL());

    }

    @Test (priority = 1, enabled = true)
    public void validateSearch () throws InterruptedException {

        HomePage homePage = new HomePage(driver);
        ArticlePage articlePage = new ArticlePage(driver);

        String searchString = "Taylor Swift";

        homePage.goToHome();
        homePage.search(searchString);

        articlePage.validateExpectedArticle(searchString);
    }

    @Test (priority = 2, enabled = true)
    public void validatesStudioAlbums () throws InterruptedException {

        HomePage homePage = new HomePage(driver);
        ArticlePage articlePage = new ArticlePage(driver);

        String[] albums;
        albums = new String[6];

        albums[0] = "Taylor Swift";
        albums[1] = "Fearless";
        albums[2] = "Speak Now";
        albums[3] = "Red";
        albums[4] = "1989";
        albums[5] = "Reputation";

        String searchString = "Taylor Swift";

        homePage.goToHome();
        homePage.search(searchString);

        articlePage.validateExpectedStudioAlbums(albums);

    }

    @Test (priority = 3, enabled = true)
    public void validatesStudioAlbumHoverMessage () throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        ArticlePage articlePage = new ArticlePage(driver);

        String searchString = "Taylor Swift";

        homePage.goToHome();
        homePage.search(searchString);

        articlePage.validateHoverMessageAppears();

    }


}