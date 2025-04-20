package Meesho_Automation_PageObjects;

import Meesho_AbstractComponents.AbstractComponents;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class Categories_Screen {

    AndroidDriver driver;

    public Categories_Screen(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath = "//android.widget.TextView[@resource-id='com.meesho.supply:id/smallLabel' and @text='Categories']")
    WebElement Categories_Icon;

    @FindBy(xpath = "(//android.widget.TextView[@text='CATEGORIES']/../..//following-sibling::android.widget.FrameLayout)[2]//android.widget.TextView[@resource-id='com.meesho.supply:id/title']")
    List<WebElement> Categories_Tabs;

    @FindBy(xpath = "//android.widget.TextView[@resource-id='com.meesho.supply:id/title_tv']")
    WebElement Category_Title;

    public void validateCategoryNavigation() {
        AbstractComponents abst = new AbstractComponents(driver);
        abst.WaitTillElement_Is_Visible(Categories_Icon);
        Categories_Icon.click();
        List<WebElement> catList = Categories_Tabs;
        for (WebElement e : catList) {
            String iconText = e.getText();
            e.click();
            abst.WaitTillElement_Is_Visible(Category_Title);
            String titletext = Category_Title.getText();
            if (iconText.equalsIgnoreCase(titletext)) {
                System.out.println("Categories are matching :ie " + iconText + " Matched with " + titletext);
            } else {
                System.out.println("Categories are Not matching :ie " + iconText + " Not Matched with " + titletext);
            }
        }
    }

}
