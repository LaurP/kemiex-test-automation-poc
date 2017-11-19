package kemiex.selenium.automation.poc.flows;

import kemiex.selenium.automation.poc.helpers.TestHelpers;
import kemiex.selenium.automation.poc.pageobjects.FeedbackPage;
import kemiex.selenium.automation.poc.pageobjects.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;


public class Flows {
    
    public static void selectOverallFeedbackRating(WebDriver driver, Integer rating) {
        FeedbackPage feedbackPage = new FeedbackPage(driver);
        feedbackPage.overallFeedback.get(rating).click();
    }
    
    public static void selectMerchandiseFeedbackRating(WebDriver driver, Integer rating) {
        FeedbackPage feedbackPage = new FeedbackPage(driver);
        feedbackPage.merchandiseFeedback.get(rating).click();
    }
    
    public static void provideVerboseFeedback(WebDriver driver, Integer length) {
        FeedbackPage feedbackPage = new FeedbackPage(driver);
        feedbackPage.verboseFeedbackTextBox.sendKeys(TestHelpers.generateRandomText(length));
    }
    
    public static void verifyFeedbackItemsCannotBeRevealedIllegally(WebDriver driver) throws InterruptedException {
        FeedbackPage feedbackPage = new FeedbackPage(driver);
        feedbackPage.pageTitle.click();
        Assert.assertTrue(feedbackPage.merchandiseFeedback.isEmpty());
        Assert.assertFalse(TestHelpers.isElementPresent(By.cssSelector("textarea.ng-pristine"), driver));
        driver.navigate().refresh();
        TestHelpers.waitUntilElementIsVisible(By.cssSelector("form.ng-untouched > h1"), driver);
        selectOverallFeedbackRating(driver, 4);
        Assert.assertTrue(feedbackPage.merchandiseFeedback.isEmpty());
        Assert.assertFalse(TestHelpers.isElementPresent(By.cssSelector("textarea.ng-pristine"), driver));
        driver.navigate().refresh();
        TestHelpers.waitUntilElementIsVisible(By.cssSelector("form.ng-untouched > h1"), driver);
        feedbackPage.overallFeedbackLabel.click();
        Assert.assertTrue(feedbackPage.merchandiseFeedback.isEmpty());
        Assert.assertFalse(TestHelpers.isElementPresent(By.cssSelector("textarea.ng-pristine"), driver));
    }
    
    public static void verifyFeedbackItemsCanBeRevealedLegally(WebDriver driver) {
        FeedbackPage feedbackPage = new FeedbackPage(driver);
        selectOverallFeedbackRating(driver, 3);
        Assert.assertFalse(feedbackPage.merchandiseFeedback.isEmpty());
        Assert.assertTrue(feedbackPage.verboseFeedback.isDisplayed());
        selectOverallFeedbackRating(driver, 4);
        TestHelpers.waitUntilElementIsInvisible(By.cssSelector("detailed-feedback"), driver);
        selectOverallFeedbackRating(driver, 2);
        Assert.assertFalse(feedbackPage.merchandiseFeedback.isEmpty());
        Assert.assertTrue(feedbackPage.verboseFeedback.isDisplayed());
        selectOverallFeedbackRating(driver, 4);
        TestHelpers.waitUntilElementIsInvisible(By.cssSelector("detailed-feedback"), driver);
        selectOverallFeedbackRating(driver, 1);
        Assert.assertFalse(feedbackPage.merchandiseFeedback.isEmpty());
        Assert.assertTrue(feedbackPage.verboseFeedback.isDisplayed());
        selectOverallFeedbackRating(driver, 4);
        TestHelpers.waitUntilElementIsInvisible(By.cssSelector("detailed-feedback"), driver);
        selectOverallFeedbackRating(driver, 0);
        Assert.assertFalse(feedbackPage.merchandiseFeedback.isEmpty());
        Assert.assertTrue(feedbackPage.verboseFeedback.isDisplayed());
        
    }
    
    public static void assertInitialElementsPresent(WebDriver driver) {
        FeedbackPage feedbackPage = new FeedbackPage(driver);
        Assert.assertTrue(feedbackPage.pageTitle.isDisplayed());
        Assert.assertTrue(feedbackPage.submitButton.isDisplayed());
        Assert.assertTrue(feedbackPage.overallFeedbackLabel.isDisplayed());
        Assert.assertFalse(feedbackPage.overallFeedback.isEmpty());
        Assert.assertTrue(feedbackPage.overallFeedback.get(4).isEnabled());
        Assert.assertTrue(feedbackPage.merchandiseFeedback.isEmpty());
        Assert.assertFalse(TestHelpers.isElementPresent(By.cssSelector("textarea.ng-pristine"), driver));
    }
    
    public static void assertSubmittedFeedbackSuccess(WebDriver driver) {
        SuccessPage successPage = new SuccessPage(driver);
        Assert.assertTrue(successPage.thankYouMessage.isDisplayed());
        Assert.assertTrue(successPage.submittedFeedbackAppreciationMessage.isDisplayed());
        Assert.assertTrue(successPage.successAlertMessage.isDisplayed());
    }
    
    public static void assertSubmittedFeedbackFailure(WebDriver driver) {
        SuccessPage successPage = new SuccessPage(driver);
        Assert.assertFalse(successPage.thankYouMessage.isDisplayed());
        Assert.assertFalse(successPage.submittedFeedbackAppreciationMessage.isDisplayed());
        Assert.assertFalse(successPage.successAlertMessage.isDisplayed());
    }
    
    public static void submitFiveStarOverallRating(WebDriver driver) {
        FeedbackPage feedbackPage = new FeedbackPage(driver);
        selectOverallFeedbackRating(driver, 4);
        feedbackPage.submitButton.click();
    }
    
    public static void submitUnderFiveStarOverallRating(WebDriver driver) {
        FeedbackPage feedbackPage = new FeedbackPage(driver);
        selectOverallFeedbackRating(driver, TestHelpers.generateRandomNumberLesserThan(3));
        selectMerchandiseFeedbackRating(driver, TestHelpers.generateRandomNumberLesserThan(4));
        provideVerboseFeedback(driver, TestHelpers.generateRandomNumberLesserThan(100));
        feedbackPage.submitButton.click();
    }
    
    public static void submitUnderFiveStarOverallRatingWithoutDetailedFeedback(WebDriver driver) {
        FeedbackPage feedbackPage = new FeedbackPage(driver);
        selectOverallFeedbackRating(driver, TestHelpers.generateRandomNumberLesserThan(3));
        feedbackPage.submitButton.click();
    }
    
}


