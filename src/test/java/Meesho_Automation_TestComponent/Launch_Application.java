package Meesho_Automation_TestComponent;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;

public class Launch_Application {


    public AndroidDriver launhMeeshoApp() {
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("platformName", "Android");
        cap.setCapability("appium:PlatformVersion", "14");
        cap.setCapability("appium:deviceName", "Roddrix000_API_34");
        cap.setCapability("appium:automationName", "UIAutomator2");
        cap.setCapability("appium:appPackage", "com.meesho.supply");
        cap.setCapability("appium:appActivity", "com.meesho.supply.main.MainActivity");
        try {
            URL appiumServerUrl = new URL("http://127.0.0.1:4723/wd/hub");
            return new AndroidDriver(appiumServerUrl, cap);
        } catch (Exception e) {

            e.printStackTrace();
        }
        return null;
    }

    public AndroidDriver launhMeeshoAppWithSessonsaved() {
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("platformName", "Android");
        cap.setCapability("appium:PlatformVersion", "14");
        cap.setCapability("appium:deviceName", "Roddrix000_API_34");
        cap.setCapability("appium:automationName", "UIAutomator2");
        cap.setCapability("appium:appPackage", "com.meesho.supply");
        cap.setCapability("appium:appActivity", "com.meesho.supply.main.MainActivity");
        cap.setCapability("appium:noReset",true);
        try {
            URL appiumServerUrl = new URL("http://127.0.0.1:4723/wd/hub");
            return new AndroidDriver(appiumServerUrl, cap);
        } catch (Exception e) {

            e.printStackTrace();
        }
        return null;
    }


}
