package kemiex.selenium.automation.poc.tests;

import org.testng.annotations.Test;

import static kemiex.selenium.automation.poc.flows.Flows.assertInitialElementsPresent;
import static kemiex.selenium.automation.poc.flows.Flows.verifyFeedbackItemsCannotBeRevealedIllegally;
import static kemiex.selenium.automation.poc.flows.Flows.verifyFeedbackItemsCanBeRevealedLegally;

public class  FeedbackInitialStateTests extends BaseTest {

    @Test
    public void testFeedbackPageInitialState() {

        goToFeedbackPage();

        assertInitialElementsPresent(driver);

    }


    @Test
    public void testRevealFeedbackItems() throws InterruptedException {

        goToFeedbackPage();

        verifyFeedbackItemsCannotBeRevealedIllegally(driver);

        verifyFeedbackItemsCanBeRevealedLegally(driver);

    }

}