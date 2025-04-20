package Meesho_Automation_PageObjects;
import Meesho_AbstractComponents.AbstractComponents;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class PLP_Screen {

    AndroidDriver driver;

    public PLP_Screen(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath = "//android.widget.TextView[@resource-id='com.meesho.supply:id/smallLabel' and @text='Categories']")
    WebElement Categories_icon;

    @FindBy(xpath = "//android.widget.TextView[@text='Men']")
    WebElement Men_Icon;

    @FindBy(xpath = "//android.widget.TextView[@text='Jeans']")
    WebElement jeans;

    @FindBy(id = "com.meesho.supply:id/price")
    WebElement Plp_Price_txt;

    @FindBy(id = "com.meesho.supply:id/price_text")
    WebElement Pdp_Price_txt;


    public void validate_Plp_And_Pdp_Price() {
        AbstractComponents abst = new AbstractComponents(driver);
        abst.WaitTillElement_Is_Visible(Categories_icon);
        Categories_icon.click();
        abst.WaitTillElement_Is_Visible(Men_Icon);
        Men_Icon.click();
        abst.WaitTillElement_Is_Visible(jeans);
        jeans.click();
        abst.WaitTillElement_Is_Visible(Plp_Price_txt);
        String plp = Plp_Price_txt.getText();
        Plp_Price_txt.click();
        abst.WaitTillElement_Is_Visible(Pdp_Price_txt);
        String pdp = Pdp_Price_txt.getText();
        if (plp.equals(pdp)) {
            System.out.println("Price of the Product is matching PLP: " + plp + "PDP :" + pdp);
        } else {
            System.out.println("Price is not matching PLP: " + plp + "PDP :" + pdp);
        }
    }
}
