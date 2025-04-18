package Meesho_Automation_Impletentation;

import Meesho_Automation_TestComponent.Launch_Application;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class validating_Search_txtField {
    public static AndroidDriver driver;
    public static String productName = "jeans";
    public static List<String> productnames = Arrays.asList("jeans", "shoes", "tops", "puma");

    public static void main(String[] args) throws InterruptedException {
        Launch_Application launch = new Launch_Application();
        driver = launch.launhMeeshoAppWithSessonsaved();
        System.out.println("launched Application");
        for (String product : productnames) {
            //System.out.println("Entering " + product);
            Thread.sleep(5000);
            WebElement search_txtFeild = driver.findElement(By.id("com.meesho.supply:id/query_edit_text"));
            WaitTillElement(search_txtFeild);
            search_txtFeild.click();
            Thread.sleep(2000);
            WebElement search_txtFld = driver.findElement(By.id("com.meesho.supply:id/query_edit_text"));
           // Thread.sleep(2000);
            WaitTillElement(search_txtFld);
            search_txtFld.sendKeys(product);
            int count = 0;
            Thread.sleep(3000);
            List<WebElement> suggestion = driver.findElements(By.id("com.meesho.supply:id/list_item_title"));
            for (WebElement e : suggestion) {
                if (e.getText().contains(product)) {
                    count++;
                }
            }
            if (count > 0) {
                System.out.println("Searched text Field has validated successfully " + product);
                count = 0;
            }
            //search_txtFld.clear();
            driver.findElement(By.id("com.meesho.supply:id/query_edit_text")).clear();

        }
        driver.quit();
    }

    public static void WaitTillElement(WebElement element) {
        WebDriverWait driverwait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driverwait.until(ExpectedConditions.visibilityOf(element));

    }
}
