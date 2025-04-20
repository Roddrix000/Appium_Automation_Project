package Meesho_Automation_Impletentation;
import Meesho_Automation_PageObjects.PLP_Screen;
import Meesho_Automation_TestComponent.BaseClass;
import org.testng.annotations.Test;
public class Validate_PLP_And_PDP_Details_Are_Matching extends BaseClass {
    @Test
    public void validatePrice() {
        PLP_Screen plp = new PLP_Screen(driver);
        plp.validate_Plp_And_Pdp_Price();
    }

}





