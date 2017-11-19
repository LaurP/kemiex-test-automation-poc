package kemiex.selenium.automation.poc.tests;

import kemiex.selenium.automation.poc.models.EnvironmentData;
import kemiex.selenium.automation.poc.pageobjects.FeedbackPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.util.HashMap;

public class BaseTest {
    public WebDriver driver;
    HashMap<String, String> environmentUrls;

    @Parameters({"browser", "localOS"})

    @BeforeMethod
    public void loadDriver(String browser, String localOS) {
        switch (browser) {
            case ("firefox"):
                if(localOS.equals("windows"))
                    System.setProperty("webdriver.gecko.driver", "./src/bin/geckodriver.exe");
                else System.setProperty("webdriver.gecko.driver", "./src/bin/geckodriver");
                driver = new FirefoxDriver();
                break;
            case ("chrome"):
                if(localOS.equals("windows"))
                    System.setProperty("webdriver.chrome.driver", "./src/bin/chromedriver.exe");
                else System.setProperty("webdriver.chrome.driver", "./src/bin/chromedriver");
                driver = new ChromeDriver();
                break;
            default:
                System.setProperty("webdriver.chrome.driver", "./src/bin/chromedriver");
                driver = new ChromeDriver();
        }
    }

    @BeforeClass
    public void getEnvironmentData() {
        EnvironmentData environmentData = new EnvironmentData();
        this.environmentUrls = environmentData.environmentUrls;
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    public void goToFeedbackPage() { driver.navigate().to(environmentUrls.get("base_url")); }

    public void clickOnSubmitButton () {
        goToFeedbackPage();
        FeedbackPage feedbackPage = new FeedbackPage(driver);
        feedbackPage.submitButton.click();
    }

}


