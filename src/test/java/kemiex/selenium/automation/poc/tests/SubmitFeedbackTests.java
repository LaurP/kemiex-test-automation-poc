package kemiex.selenium.automation.poc.tests;

import org.testng.annotations.Test;

import static kemiex.selenium.automation.poc.flows.Flows.assertSubmittedFeedbackSuccess;
import static kemiex.selenium.automation.poc.flows.Flows.assertSubmittedFeedbackFailure;
import static kemiex.selenium.automation.poc.flows.Flows.submitFiveStarOverallRating;
import static kemiex.selenium.automation.poc.flows.Flows.submitUnderFiveStarOverallRating;
import static kemiex.selenium.automation.poc.flows.Flows.submitUnderFiveStarOverallRatingWithoutDetailedFeedback;

public class SubmitFeedbackTests extends BaseTest {

    @Test
    public void successfullySubmitFiveStarFeedback() {

        goToFeedbackPage();

        submitFiveStarOverallRating(driver);

        assertSubmittedFeedbackSuccess(driver);

    }

    @Test
    public void successfullySubmitUnderFiveStarRating() {

        goToFeedbackPage();

        submitUnderFiveStarOverallRating(driver);

        assertSubmittedFeedbackSuccess(driver);

    }

    @Test
    public void tryToSubmitUnderFiveStarRatingWithoutDetailedFeedback() {

        goToFeedbackPage();

        submitUnderFiveStarOverallRatingWithoutDetailedFeedback(driver);

        assertSubmittedFeedbackFailure(driver);

    }
}
