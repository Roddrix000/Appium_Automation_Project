package Meesho_Automation_PageObjects;

import Meesho_AbstractComponents.AbstractComponents;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PDP_Screen {

    AndroidDriver driver;

    public PDP_Screen(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "com.meesho.supply:id/check_delivery_status")
    WebElement DeliveryCheck;

    @FindBy(id = "com.meesho.supply:id/pin_code_edit_text")
    WebElement EnterPinCode;

    @FindBy(id = "com.meesho.supply:id/text_input_layout_link_button")
    WebElement Check_Btn;

    @FindBy(xpath = "//android.widget.TextView[@resource-id='com.meesho.supply:id/delivery_date']")
    WebElement Expected_Delibery;


    public void validate_Expected_Delivery(String pincode) {
        PLP_Screen plp = new PLP_Screen(driver);
        AbstractComponents abst = new AbstractComponents(driver);
        abst.WaitTillElement_Is_Visible(plp.Categories_icon);
        plp.Categories_icon.click();
        abst.WaitTillElement_Is_Visible(plp.Men_Icon);
        plp.Men_Icon.click();
        abst.WaitTillElement_Is_Visible(plp.jeans);
        plp.jeans.click();
        abst.WaitTillElement_Is_Visible(plp.Plp_Price_txt);
        plp.Plp_Price_txt.click();
        abst.WaitTillElement_Is_Visible(plp.Pdp_Price_txt);
        abst.swipeUntilElementVisible(By.id("com.meesho.supply:id/check_delivery_status"), driver);
        DeliveryCheck.click();
        EnterPinCode.click();
        EnterPinCode.clear();
        EnterPinCode.sendKeys(pincode);
        Check_Btn.click();
        abst.WaitTillElement_Is_Visible(Expected_Delibery);
        System.out.println(Expected_Delibery.getText());
    }

}
