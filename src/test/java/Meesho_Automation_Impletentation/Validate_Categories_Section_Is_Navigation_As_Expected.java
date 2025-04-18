package Meesho_Automation_Impletentation;

import Meesho_Automation_TestComponent.Launch_Application;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Validate_Categories_Section_Is_Navigation_As_Expected {

    public static AndroidDriver driver;


    public static void main(String[] args) {
        //launching Application
        Launch_Application launch = new Launch_Application();
        driver = launch.launhMeeshoAppWithSessonsaved();
        System.out.println("Application Launched ");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement Categories_icon = driver.findElement(By.xpath("//android.widget.TextView[@resource-id='com.meesho.supply:id/smallLabel' and @text='Categories']"));
        WaitTillElement(Categories_icon);
        Categories_icon.click();
        List<WebElement> catgories_Tab = driver.findElements(By.xpath("(//android.widget.TextView[@text='CATEGORIES']/../..//following-sibling::android.widget.FrameLayout)[2]//android.widget.TextView[@resource-id='com.meesho.supply:id/title']"));
        for (WebElement e : catgories_Tab) {
            String iconText = e.getText();
            e.click();
            WebElement titleName = driver.findElement(By.xpath("//android.widget.TextView[@resource-id='com.meesho.supply:id/title_tv']"));
            WaitTillElement(titleName);
            String titletext = titleName.getText();
            if (iconText.equalsIgnoreCase(titletext)) {
                System.out.println("Categories are matching :ie " + iconText + "Matched with " + titletext);
            } else {
                System.out.println("Categories are Not matching :ie " + iconText + "Not Matched with " + titletext);
            }

        }

        driver.quit();

    }

    public static void WaitTillElement(WebElement element) {
        WebDriverWait driverwait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driverwait.until(ExpectedConditions.visibilityOf(element));
    }

}
