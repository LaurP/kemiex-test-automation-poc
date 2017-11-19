package kemiex.selenium.automation.poc.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
    public WebDriver browser;
    public BasePage(WebDriver browser) {
        this.browser = browser;
        PageFactory.initElements(browser, this);
    }
    public WebDriver getDriver() {
        return browser;
    }

}
