package Meesho_Automation_Impletentation;
import Meesho_Automation_PageObjects.PDP_Screen;
import Meesho_Automation_TestComponent.BaseClass;
import org.testng.annotations.Test;

public class Validate_Delivery_date extends BaseClass {

    @Test
    public void validate_Expected_Delivery() {
        PDP_Screen pdp = new PDP_Screen(driver);
        pdp.validate_Expected_Delivery("560015");
    }

}
