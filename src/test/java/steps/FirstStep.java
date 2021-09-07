package steps;

import baseEntities.BaseStep;
import org.openqa.selenium.WebDriver;
import pages.FirstPage;

public class FirstStep extends BaseStep {
    public FirstStep(WebDriver driver) {
        super(driver);
    }

        public void Search(String search) {
            FirstPage firstPage = new FirstPage(driver, true);
            firstPage.setSearch(search);
            firstPage.clickSearchInput();
        }
}
