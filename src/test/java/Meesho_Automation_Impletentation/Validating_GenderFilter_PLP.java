package Meesho_Automation_Impletentation;
import Meesho_Automation_TestComponent.BaseClass;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import java.time.Duration;

public class Validating_GenderFilter_PLP {
    public static AndroidDriver driver;
    public static String productName = "jeans";





    public static void main(String[] args) throws InterruptedException {


        BaseClass launch = new BaseClass();
        driver = launch.launhMeeshoAppWithSessonsaved();
        System.out.println("launched Application");
        Thread.sleep(15000);
        WebElement search_txtFeild = driver.findElement(By.id("com.meesho.supply:id/query_edit_text"));
        WaitTillElement(search_txtFeild);
        search_txtFeild.click();
        WebElement search_txtFld = driver.findElement(By.id("com.meesho.supply:id/query_edit_text"));
        Thread.sleep(2000);
        int count = 0;
        search_txtFld.sendKeys(productName);
    }

    public static void WaitTillElement(WebElement element) {
        WebDriverWait driverwait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driverwait.until(ExpectedConditions.visibilityOf(element));

    }
}
