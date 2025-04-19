package Meesho_Automation_Impletentation;

import Meesho_Automation_TestComponent.Launch_Application;
import com.google.common.collect.Ordering;
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
import java.util.ArrayList;
import java.util.List;


public class Validate_Sort_Functionality {

    public static AndroidDriver driver;

    public static void main(String[] args) throws InterruptedException {

        Launch_Application launch = new Launch_Application();
        driver = launch.launhMeeshoAppWithSessonsaved();
        System.out.println("Application Launched");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement Home_Catg = driver.findElement(By.xpath("(//android.widget.TextView[@text='Home'])[1]"));
        WaitTillElement(Home_Catg);
        Home_Catg.click();
        WebElement home_Decor = driver.findElement(By.xpath("//android.widget.TextView[@text='HOME DECOR & FURNISHINGS']"));
        WaitTillElement(home_Decor);
        if (home_Decor.isDisplayed()) {
            System.out.println("HOME DECOR & FURNISHINGS");
        }
        WebElement artifical_Plants = driver.findElement(By.xpath("//android.widget.TextView[@resource-id='com.meesho.supply:id/tv_label' and @text='Artificial Plant And Flower']"));
        artifical_Plants.click();
        WebElement sort_filter = driver.findElement(By.xpath("(//android.widget.TextView[@text='Sort'])[2]"));
        WaitTillElement(sort_filter);
        sort_filter.click();
        WebElement high_low = driver.findElement(By.xpath("//android.widget.RadioButton[@resource-id='com.meesho.supply:id/sort_option2' and @text='Price (High to Low)']"));
        high_low.click();
        List<WebElement> priceList = driver.findElements(By.id("com.meesho.supply:id/price"));
        List<String> price1 = new ArrayList<>();
        for (WebElement e : priceList) {
            Thread.sleep(1000);
            price1.add(e.getText());
        }
        System.out.println(price1);
        //Checking if Its High to Low
        if (!Ordering.natural().isOrdered(price1)) {
            System.out.println("Sorted Hight to Low");
        }
        sort_filter.click();
        WebElement low_high = driver.findElement(By.xpath("//android.widget.RadioButton[@resource-id='com.meesho.supply:id/sort_option2' and @text='Price (Low to High)']"));
        WaitTillElement(low_high);
        low_high.click();
        List<WebElement> priceListlowToHigh = driver.findElements(By.id("com.meesho.supply:id/price"));
        List<String> price2 = new ArrayList<>();
        for (WebElement e : priceListlowToHigh) {
            Thread.sleep(1000);
            price2.add(e.getText());
        }
        System.out.println(price2);
        //Checking if the list is Descending
        if (Ordering.natural().isOrdered(price2)) {
            System.out.println("Sorted Low to high");
        }
        System.out.println("Closing the Application");
        driver.quit();
    }
    public static void WaitTillElement(WebElement element) {
        WebDriverWait driverwait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driverwait.until(ExpectedConditions.visibilityOf(element));
    }
}
