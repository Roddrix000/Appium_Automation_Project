package Meesho_AbstractComponents;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AbstractComponents {

    AndroidDriver driver;

    public AbstractComponents(AndroidDriver driver) {
        this.driver = driver;
    }


    public void WaitTillElement_Is_Visible(WebElement element) {
        WebDriverWait driverwait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driverwait.until(ExpectedConditions.visibilityOf(element));
    }

    public void swipeUntilElementVisible(By locator, AndroidDriver driver) {
        int maxSwipes = 10;
        Dimension size = driver.manage().window().getSize();

        int startX = size.width / 2;
        int startY = (int) (size.height * 0.8);
        int endY = (int) (size.height * 0.2);

        for (int i = 0; i < maxSwipes; i++) {
            try {
                WebElement element = driver.findElement(locator);
                if (element.isDisplayed()) {
                    System.out.println("Element is visible!");
                    return;
                }
            } catch (StaleElementReferenceException | NoSuchElementException e) {
                // The element might not be present yet or got stale after scroll
            }

            new TouchAction<>(driver)
                    .press(PointOption.point(startX, startY))
                    .waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
                    .moveTo(PointOption.point(startX, endY))
                    .release()
                    .perform();
        }
        throw new NoSuchElementException("Element not visible after " + maxSwipes + " swipes.");
    }

}
