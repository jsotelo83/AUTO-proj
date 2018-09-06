package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    public WebDriver driver;

    @BeforeClass
    public void setup() {
        //Create a Chrome driver. All test and page classes use this driver.
        driver = new ChromeDriver();

        //Create a wait. All test and page classes use this wait.
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        //Maximize Window
        driver.manage().window().maximize();
    }

    @AfterClass
    public void teardown() {
       // driver.quit();
    }
}

