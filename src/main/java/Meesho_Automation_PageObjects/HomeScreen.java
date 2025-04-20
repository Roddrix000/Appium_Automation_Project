package Meesho_Automation_PageObjects;

import Meesho_AbstractComponents.AbstractComponents;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomeScreen {
    AndroidDriver driver;

    public HomeScreen(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "com.meesho.supply:id/query_edit_text")
    WebElement search_txtFeild;

    @FindBy(id = "com.meesho.supply:id/list_item_title")
    List<WebElement> searchSuggestion;


    public void search_product(List<String> pnames) {
        AbstractComponents abst = new AbstractComponents(driver);
        for (String product : pnames) {
            abst.WaitTillElement_Is_Visible(search_txtFeild);
            search_txtFeild.click();
            try {
                Thread.sleep(2000);
            } catch (Exception e) {
                e.printStackTrace();
            }
            search_txtFeild.sendKeys(product);
            int count = 0;
            List<WebElement> list = searchSuggestion;
            for (WebElement e : list) {
                if (e.getText().contains(product)) {
                    count++;
                }
            }
            if (count > 0) {
                System.out.println("Searched text Field has validated successfully " + product);
                count = 0;
            }
            search_txtFeild.clear();
        }
    }

}
