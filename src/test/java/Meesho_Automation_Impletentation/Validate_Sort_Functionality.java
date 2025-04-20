package Meesho_Automation_Impletentation;
import Meesho_Automation_PageObjects.Home_Decor_Screen;
import Meesho_Automation_TestComponent.BaseClass;
import org.testng.annotations.Test;

public class Validate_Sort_Functionality extends BaseClass {

    @Test
    public void validate_LowToHigh() {
        Home_Decor_Screen home = new Home_Decor_Screen(driver);
        home.checkList_HighToLow();
    }
    @Test
    public void validate_HighToLow() {
        Home_Decor_Screen home = new Home_Decor_Screen(driver);
        home.checkList_LowToHigh();
    }

}
