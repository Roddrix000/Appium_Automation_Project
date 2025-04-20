package Meesho_Automation_PageObjects;
import Meesho_AbstractComponents.AbstractComponents;
import com.google.common.collect.Ordering;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.ArrayList;
import java.util.List;

public class Home_Decor_Screen {

    AndroidDriver driver;

    public Home_Decor_Screen(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "(//android.widget.TextView[@text='Home'])[1]")
    WebElement Home_Catg;

    @FindBy(xpath = "//android.widget.TextView[@text='HOME DECOR & FURNISHINGS']")
    WebElement Home_Decor_Txt;

    @FindBy(xpath = "//android.widget.TextView[@resource-id='com.meesho.supply:id/tv_label' and @text='Artificial Plant And Flower']")
    WebElement artifical_Plants_Icon;

    @FindBy(xpath = "(//android.widget.TextView[@text='Sort'])[2]")
    WebElement sort_Filter;

    @FindBy(xpath = "//android.widget.RadioButton[@resource-id='com.meesho.supply:id/sort_option2' and @text='Price (High to Low)']")
    WebElement high_low;

    @FindBy(id = "com.meesho.supply:id/price")
    List<WebElement> priceList;

    @FindBy(xpath = "//android.widget.RadioButton[@resource-id='com.meesho.supply:id/sort_option2' and @text='Price (Low to High)']")
    WebElement low_high;

    @FindBy(xpath = "//android.widget.ImageButton[@content-desc='Navigate up']")
    WebElement Back_icon;

    public void checkList_HighToLow() {
        AbstractComponents abst = new AbstractComponents(driver);
        abst.WaitTillElement_Is_Visible(Home_Catg);
        Home_Catg.click();
        abst.WaitTillElement_Is_Visible(artifical_Plants_Icon);
        artifical_Plants_Icon.click();
        abst.WaitTillElement_Is_Visible(sort_Filter);
        sort_Filter.click();
        high_low.click();
        List<String> price = new ArrayList<>();
        List<WebElement> list = priceList;
        for (WebElement e : priceList) {
            abst.WaitTillElement_Is_Visible(e);
            price.add(e.getText());
        }
        if (!Ordering.natural().isOrdered(price)) {
            System.out.println("Sorted Hight to Low");
        }
        Back_icon.click();
    }

    public void checkList_LowToHigh() {
        AbstractComponents abst = new AbstractComponents(driver);
        abst.WaitTillElement_Is_Visible(Home_Catg);
        Home_Catg.click();
        abst.WaitTillElement_Is_Visible(artifical_Plants_Icon);
        artifical_Plants_Icon.click();
        abst.WaitTillElement_Is_Visible(sort_Filter);
        sort_Filter.click();
        low_high.click();
        List<String> price = new ArrayList<>();
        List<WebElement> list = priceList;
        for (WebElement e : priceList) {
            abst.WaitTillElement_Is_Visible(e);
            price.add(e.getText());
        }
        if (Ordering.natural().isOrdered(price)) {
            System.out.println("Sorted Low to high");
        }
        Back_icon.click();

    }

}
