package tests;

import baseEntities.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.ProductSelectionPage;
import steps.CartStep;
import steps.FirstStep;
import steps.ProductSelectionStep;

public class SmokeTest extends BaseTest {

    @Test
    public void firstTest() throws InterruptedException {
        FirstStep firstStep = new FirstStep(driver);
        firstStep.Search(properties.getSearch());
        Thread.sleep(3000);

        //Добавление двух товаров в корзину
        ProductSelectionPage productSelectionPage = new ProductSelectionPage(driver, true);
        ProductSelectionStep productSelectionStep = new ProductSelectionStep(driver);
        productSelectionStep.addToCart();
        Thread.sleep(3000);

        //Проверка корзины на наличие двух товаров
        Assert.assertEquals(productSelectionPage.getCartCheckText(), "2", "Products not found");

        //Удаление одного товара
        CartStep cartStep = new CartStep(driver);
        cartStep.deleteProduct();

        //Проверка корзины на наличие одного товара
        CartPage cartPage = new CartPage(driver,false);
        Thread.sleep(3000);
        Assert.assertEquals(cartPage.getCartCheckText(), "1", "Product doesn't deleted");
    }
    @Test
    public void negativeTest() throws InterruptedException {
        FirstStep firstStep = new FirstStep(driver);
        firstStep.Search(properties.getSearch());
        Thread.sleep(3000);

        //Добавление двух товаров в корзину
        ProductSelectionPage productSelectionPage = new ProductSelectionPage(driver, true);
        ProductSelectionStep productSelectionStep = new ProductSelectionStep(driver);
        productSelectionStep.addToCart();
        Thread.sleep(3000);

        //Проверка корзины на наличие двух товаров
        Assert.assertEquals(productSelectionPage.getCartCheckText(), "2", "Products not found");

        //Заказ товара и проверка в степе на неправильный ввод данных номера телефона
        CartStep cartStep = new CartStep(driver);
        cartStep.orderProduct();
    }
}
