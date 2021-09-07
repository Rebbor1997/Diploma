package steps;

import baseEntities.BaseStep;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pages.CartPage;

public class CartStep extends BaseStep {
    public CartStep(WebDriver driver) {
        super(driver);
    }

    public void orderProduct() throws InterruptedException {
        CartPage cartPage = new CartPage(driver, true);
        cartPage.clickOrder();
        Thread.sleep(7000);

        driver.switchTo().frame("authFrame");
        WebElement element = driver.findElement(By.xpath("//input[@name='phone']"));
        WebElement element2 = driver.findElement(By.xpath("//div[@class = '_29hd _25gr _2w-L']//div"));

        element.click();
        element.clear();
        element.sendKeys("0");
        Thread.sleep(3000);

        element2.click();
        Thread.sleep(3000);

        WebElement element3 = driver.findElement(By.xpath("//p[@qa-id = 'errorMessage']"));

        Assert.assertEquals(element3.getText(), "Некорректный формат телефона", "Product ordered");
        driver.switchTo().defaultContent();
        Thread.sleep(3000);
    }

    public void deleteProduct() {
        CartPage cartPage = new CartPage(driver, true);
        cartPage.clickDelete();
        cartPage.clickDeleteAlert();
    }
}
