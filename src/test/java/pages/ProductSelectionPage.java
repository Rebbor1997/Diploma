package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductSelectionPage extends BasePage {

    private final static String endpoint = "category/noutbuki-15692/?from_global=true&text=asus+vivobook/";
    private final static By product_1 = By.xpath("//*[contains(text(), 'Ноутбук ASUS X415MA VivoBook (EB215)')]/ancestor::div[@class = 'e3s1 e3s3']//div[@class = '_29hd _2JpD']");
    private final static By product_2 = By.xpath("//*[contains(text(), 'Ноутбук ASUS X415MA VivoBook (EK052)')]/ancestor::div[@class = 'e3s1 e3s3']//div[@class = '_29hd _2JpD']");
    private final static By cart_Check_By = By.xpath("//a[@class= 'e2f e3h9 g5j7' and @data-widget = 'headerIcon']");



    public ProductSelectionPage(WebDriver driver, boolean openPageByUrl) {
        super(driver, openPageByUrl);
    }

    @Override
    protected void openPage() {
        driver.get(properties.getURL() + endpoint);

    }

    @Override
    public boolean isPageOpened() {
        try {
            return getProduct1().isDisplayed();
        } catch (NoSuchElementException ex) {
            return false;
        }
    }

    public WebElement getProduct1(){ return driver.findElement(product_1);}
    public WebElement getProduct2(){ return driver.findElement(product_2);}

    public void clickProduct1(){
        getProduct1().click();
    }
    public void clickProduct2(){
        getProduct2().click();
    }


    //Методы для проверки корзины на наличие двух товаров
    public WebElement getCartCheck(){ return driver.findElement(cart_Check_By);}
    public String getCartCheckText(){return getCartCheck().getText();}

    //Переход в корзину
    public void clickCart(){getCartCheck().click();}
}
