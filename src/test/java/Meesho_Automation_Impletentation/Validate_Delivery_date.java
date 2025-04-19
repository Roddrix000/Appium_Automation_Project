package Meesho_Automation_Impletentation;

import Meesho_Automation_TestComponent.Launch_Application;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class Validate_Delivery_date {
    public static AndroidDriver driver;

    public static void main(String[] args) throws InterruptedException {

        Launch_Application launch = new Launch_Application();
        driver = launch.launhMeeshoAppWithSessonsaved();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement Categories_icon = driver.findElement(By.xpath("//android.widget.TextView[@resource-id='com.meesho.supply:id/smallLabel' and @text='Categories']"));
        WaitTillElement(Categories_icon);
        Categories_icon.click();
        //Check if Catogory page is Displayed
        WebElement Categories_Text = driver.findElement(By.xpath("//android.widget.TextView[@text='CATEGORIES']"));
        WaitTillElement(Categories_Text);
        if (Categories_Text.isDisplayed()) {
            System.out.println("Navigated ti category page");
        }
        //Tap on Men
        driver.findElement(By.xpath("//android.widget.TextView[@text='Men']")).click();
        //Clicking o Jeans
        WebElement jeans = driver.findElement(By.xpath("//android.widget.TextView[@text='Jeans']"));
        WaitTillElement(jeans);
        jeans.click();
        //Getting the price Details
        WebElement PLP_price = driver.findElement(By.id("com.meesho.supply:id/price"));
        WaitTillElement(PLP_price);
        PLP_price.click();
        // WebElement checkDelivery = By.id("com.meesho.supply:id/check_delivery_status");
        swipeUntilElementVisible(By.id("com.meesho.supply:id/check_delivery_status"), driver);
        driver.findElement(By.id("com.meesho.supply:id/check_delivery_status")).click();
        WebElement enterPinCode = driver.findElement(By.id("com.meesho.supply:id/pin_code_edit_text"));
        WaitTillElement(enterPinCode);
        enterPinCode.clear();
        enterPinCode.click();
        Thread.sleep(2000);
        enterPinCode.sendKeys("560015");
        WebElement checkBtn = driver.findElement(By.id("com.meesho.supply:id/text_input_layout_link_button"));
        WaitTillElement(checkBtn);
        checkBtn.click();
        Thread.sleep(2000);
        String deliveryDetails = driver.findElement(By.xpath("//android.widget.TextView[@resource-id='com.meesho.supply:id/delivery_date']")).getText();
        System.out.println("Delivery details :" + deliveryDetails);
        driver.quit();
    }

    public static void WaitTillElement(WebElement element) {
        WebDriverWait driverwait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driverwait.until(ExpectedConditions.visibilityOf(element));

    }

    public enum Direction {
        UP, DOWN, LEFT, RIGHT
    }

    public static void swipeUntilElementVisible(By locator, AndroidDriver driver) {
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
