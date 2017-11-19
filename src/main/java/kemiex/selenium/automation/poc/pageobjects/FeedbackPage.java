package kemiex.selenium.automation.poc.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import java.util.List;


public class FeedbackPage extends BasePage {

    public FeedbackPage(WebDriver browser) {
        super(browser);
    }

    @FindBy(css = "form.ng-untouched > h1")
    public WebElement pageTitle;

    @FindBy(id = "form-submit")
    public WebElement submitButton;

    @FindBys({@FindBy(css = "#overall-feedback > div > rating > div.star")})
    public List<WebElement> overallFeedback;

    @FindBy(css = "form.ng-untouched > h1")
    public WebElement overallFeedbackLabel;

    @FindBy(css = "detailed-feedback")
    public WebElement detailedFeedbackForm;

    @FindBys({@FindBy(css = "#merchandise-quality > div > rating > div.star")})
    public List<WebElement> merchandiseFeedback;

    @FindBy(css = "textarea.ng-pristine")
    public WebElement verboseFeedbackTextBox;

    @FindBy(css = "#detailed-feedback > kemiex-form-item[name=\"Verbose feedback\"]")
    public WebElement verboseFeedback;

}
