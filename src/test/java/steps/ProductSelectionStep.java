package steps;

import baseEntities.BaseStep;
import org.openqa.selenium.WebDriver;

import pages.ProductSelectionPage;

public class ProductSelectionStep extends BaseStep {
    public ProductSelectionStep(WebDriver driver) {
        super(driver);
    }

    public void addToCart() {
        ProductSelectionPage productSelectionPage = new ProductSelectionPage(driver, false);
        productSelectionPage.clickProduct1();
        productSelectionPage.clickProduct2();
    }
}
