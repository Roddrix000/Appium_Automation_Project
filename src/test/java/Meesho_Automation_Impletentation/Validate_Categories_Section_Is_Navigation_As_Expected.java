package Meesho_Automation_Impletentation;

import Meesho_Automation_PageObjects.Categories_Screen;
import Meesho_Automation_TestComponent.BaseClass;
import org.testng.annotations.Test;


public class Validate_Categories_Section_Is_Navigation_As_Expected extends BaseClass {

    @Test
    public void validate_Categories_Navigation_On_tapped() {
        Categories_Screen catScreen = new Categories_Screen(driver);
        catScreen.validateCategoryNavigation();
    }
}
