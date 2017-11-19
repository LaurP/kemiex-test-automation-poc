package kemiex.selenium.automation.poc.helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.util.Random;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public final class TestHelpers {

    public static Integer generateRandomNumberLesserThan(Integer index) {
        return new Random(System.currentTimeMillis()).nextInt(index);
    }

    public static String generateRandomText (Integer length) {
        String allowedCharacters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890 ";
        StringBuilder generatedString = new StringBuilder();
        Random random = new Random();
        while (generatedString.length() < length) {
            int index = (int) (random.nextFloat() * allowedCharacters.length());
            generatedString.append(allowedCharacters.charAt(index));
        }
        return generatedString.toString();
    }

    public static void waitUntilElementIsInvisible(By by, WebDriver driver) {
        new WebDriverWait(driver, 10).until(ExpectedConditions.invisibilityOfElementLocated(by));
    }

    public static boolean isElementPresent(By by, WebDriver driver) {
        try {
            driver.findElement(by);
            return true;
        }
        catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }

}
