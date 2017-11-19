package kemiex.selenium.automation.poc.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import java.util.List;

public class SuccessPage extends BasePage {

    public SuccessPage(WebDriver browser) {
        super(browser);
    }

    @FindBy(css = "kemiex-page-success > h1")
    public WebElement thankYouMessage;

    @FindBy(css = "kemiex-page-success > p")
    public WebElement submittedFeedbackAppreciationMessage;

    @FindBy(css = "span.message")
    public WebElement successAlertMessage;

}
