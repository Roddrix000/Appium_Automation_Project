package Meesho_Automation_Impletentation;

import Meesho_Automation_TestComponent.Launch_Application;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class Validate_PLP_And_PDP_Details_Are_Matching {
    public static AndroidDriver driver;

    public static void main(String[] args) throws InterruptedException {

        //Creating the Object
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
        String plpPrice = PLP_price.getText();
        PLP_price.click();
        Thread.sleep(10000);
        //Swipping until Element is visible
        WebElement heart_icon = driver.findElement(By.id("com.meesho.supply:id/iv_icon"));
        swipeElementAndroid(heart_icon, Direction.UP);
        WebElement PDP_Price = driver.findElement(By.id("com.meesho.supply:id/price_text"));
        WaitTillElement(PDP_Price);
        String pdpPrice = PDP_Price.getText();

        if (plpPrice.equals(pdpPrice)) {
            System.out.println("Price of the Product is matching PLP: " + plpPrice + "PDP :" + pdpPrice);
        } else {
            System.out.println("Price is not matching PLP: " + plpPrice + "PDP :" + pdpPrice);
        }

    }

    public enum Direction {
        UP, DOWN, LEFT, RIGHT
    }

    public static void swipeElementAndroid(WebElement el, Direction dir) {
        System.out.println("swipeElementAndroid(): dir: '" + dir + "'");

        final int ANIMATION_TIME = 200; // ms
        final int PRESS_TIME = 200; // ms

        int edgeBorder;
        Point pointStart, pointEnd;

        Rectangle rect = el.getRect();
        edgeBorder = 0;

        switch (dir) {
            case DOWN: // from up to down
                pointStart = new Point(rect.x + rect.width / 2, rect.y + edgeBorder);
                pointEnd = new Point(rect.x + rect.width / 2, rect.y + rect.height - edgeBorder);
                break;
            case UP: // from down to up
                pointStart = new Point(rect.x + rect.width / 2, rect.y + rect.height - edgeBorder);
                pointEnd = new Point(rect.x + rect.width / 2, rect.y + edgeBorder);
                break;
            case LEFT: // from right to left
                pointStart = new Point(rect.x + rect.width - edgeBorder, rect.y + rect.height / 2);
                pointEnd = new Point(rect.x + edgeBorder, rect.y + rect.height / 2);
                break;
            case RIGHT: // from left to right
                pointStart = new Point(rect.x + edgeBorder, rect.y + rect.height / 2);
                pointEnd = new Point(rect.x + rect.width - edgeBorder, rect.y + rect.height / 2);
                break;
            default:
                throw new IllegalArgumentException("swipeElementAndroid(): dir: '" + dir + "' NOT supported");
        }

        try {
            new TouchAction<>(driver)
                    .press(PointOption.point(pointStart))
                    .waitAction(WaitOptions.waitOptions(Duration.ofMillis(PRESS_TIME)))
                    .moveTo(PointOption.point(pointEnd))
                    .release().perform();
            Thread.sleep(ANIMATION_TIME);
        } catch (Exception e) {
            System.err.println("swipeElementAndroid(): TouchAction FAILED" + e.getMessage());
        }
    }

    public static void WaitTillElement(WebElement element) {
        WebDriverWait driverwait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driverwait.until(ExpectedConditions.visibilityOf(element));
    }

}





