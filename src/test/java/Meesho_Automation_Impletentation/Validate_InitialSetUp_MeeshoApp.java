package Meesho_Automation_Impletentation;

import Meesho_Automation_TestComponent.Launch_Application;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Validate_InitialSetUp_MeeshoApp {
    public static AndroidDriver driver;

    public static void main(String[] args) throws InterruptedException {

        Launch_Application launch = new Launch_Application();
        System.out.println("Meesho Launch Initiated");
        driver = launch.launhMeeshoApp();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        System.out.println("Successfully Meesho Launched");
        WebElement allow_btn = driver.findElement(By.id("com.android.permissioncontroller:id/permission_allow_button"));
        WaitTillElement(allow_btn);
        allow_btn.click();
        WebElement chooseYourLanguage_Txt = driver.findElement(By.xpath("//android.widget.TextView[contains(@text, 'Choose language')]"));
        WaitTillElement(chooseYourLanguage_Txt);
        if (chooseYourLanguage_Txt.isDisplayed()) {
            System.out.println("Clicked Allow");
        }
        WebElement english_Button = driver.findElement(By.xpath("(//android.widget.ImageView)[3]"));
        WaitTillElement(english_Button);
        english_Button.click();
        WebElement select_Your_gender_Txt = driver.findElement(By.id("com.meesho.supply:id/title"));
        WaitTillElement(select_Your_gender_Txt);
        if (select_Your_gender_Txt.isDisplayed()) {
            System.out.println("Clicked on English Language");
        }
        WebElement male_Button = driver.findElement(By.id("com.meesho.supply:id/tvMale"));
        WaitTillElement(male_Button);
        male_Button.click();
        WebElement search_By_keyWord_txtBox = driver.findElement(By.id("com.meesho.supply:id/query_edit_text"));
        WaitTillElement(search_By_keyWord_txtBox);
        if (search_By_keyWord_txtBox.isDisplayed()) {
            System.out.println("Successfully Landed in Homepage");
            System.out.println("Successfully handelied the App SetUp");
            driver.quit();
        }
    }


    public static void WaitTillElement(WebElement element) {
        WebDriverWait driverwait = new WebDriverWait(driver, Duration.ofSeconds(20));
        driverwait.until(ExpectedConditions.visibilityOf(element));
    }

}
