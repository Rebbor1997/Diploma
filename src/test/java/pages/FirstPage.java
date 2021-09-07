package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FirstPage extends BasePage {

    private final static By search_By = By.xpath("//input[@placeholder = 'Искать на Ozon']");
    private final static By search_Input_By = By.xpath("//button[@class = 'f9k']");

    public FirstPage(WebDriver driver, boolean openPageByUrl) {
        super(driver, openPageByUrl);
    }



    @Override
    protected void openPage() {
        driver.get(properties.getURL());
    }

    @Override
    public boolean isPageOpened() {
        try {
            return getSearchInput().isDisplayed();
        } catch (NoSuchElementException ex) {
            return false;
        }
    }

    public WebElement getSearchString() { return driver.findElement(search_By); }
    public WebElement getSearchInput() { return driver.findElement(search_Input_By); }

    public void setSearch(String text) {
        getSearchString().sendKeys(text);
    }

    public void clickSearchInput() {
        getSearchInput().click();
    }
}
