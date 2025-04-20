package Meesho_Automation_Impletentation;
import Meesho_Automation_PageObjects.HomeScreen;
import Meesho_Automation_TestComponent.BaseClass;
import org.testng.annotations.Test;
import java.util.Arrays;
import java.util.List;

public class validating_Search_txtField extends BaseClass {

    public static String productName = "jeans";
    public static List<String> productnames = Arrays.asList("jeans", "shoes", "tops", "puma");

    @Test
    public void validate_SearchTextField_Valid() {
        HomeScreen home = new HomeScreen(driver);
        home.search_product(productnames);
    }
}
