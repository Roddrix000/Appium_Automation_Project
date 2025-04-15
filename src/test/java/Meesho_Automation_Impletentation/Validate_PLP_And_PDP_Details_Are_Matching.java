package Meesho_Automation_Impletentation;

import Meesho_Automation_TestComponent.Launch_Application;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class Validate_PLP_And_PDP_Details_Are_Matching {
public static  AndroidDriver driver;
    public static void main(String[] args) {

        //Creating the Object
        Launch_Application launch = new Launch_Application();
        driver = launch.launhMeeshoAppWithSessonsaved();
        driver.findElement(By.xpath("//android.widget.TextView[@resource-id='com.meesho.supply:id/smallLabel' and @text='Categories']"));


    }

}
