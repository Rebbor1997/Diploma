package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartPage extends BasePage {
    private final static String endpoint = "cart/";
    private final static By order = By.xpath("//div[@class = '_29hd _3Qk- _2XP7 _2w-L']");
    private final static By delete = By.xpath("//*[contains(text(), '(EK052)')]/ancestor::div[@class = 'a7m6 a7n2']//span[contains(text(), 'Удалить')]");
    private final static By delete_OK = By.xpath("//div[@qa-id = 'checkcart-confirm-modal-confirm-button']//div[@class = '_29hd']");
    private final static By cart_Check_By = By.xpath("//a[@class= 'e2f e3h9 g5j7' and @data-widget = 'headerIcon']");


    public CartPage(WebDriver driver, boolean openPageByUrl) {
        super(driver, openPageByUrl);
    }

    @Override
    protected void openPage() {
        driver.get(properties.getURL() +endpoint);
    }

    @Override
    public boolean isPageOpened() {
        try {
            return getOrder().isDisplayed();
        } catch (NoSuchElementException ex) {
            return false;
        }
    }

    public WebElement getOrder(){ return driver.findElement(order);}
    public WebElement getDeleteProduct(){ return driver.findElement(delete);}
    public WebElement getDeleteProductAlert(){ return driver.findElement(delete_OK);}


    public void clickOrder(){getOrder().click();}
    public void clickDelete(){getDeleteProduct().click();}
    public void clickDeleteAlert(){getDeleteProductAlert().click();}


    //Методы для проверки корзины на наличие двух товаров
    public WebElement getCartCheck(){ return driver.findElement(cart_Check_By);}
    public String getCartCheckText(){return getCartCheck().getText();}

}
