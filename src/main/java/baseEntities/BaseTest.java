package baseEntities;

import core.BrowserService;
import core.ReadProperties;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

public class BaseTest {
    protected WebDriver driver;
    protected ReadProperties properties;

    @BeforeTest
    public void setupTest(){

        properties = new ReadProperties();
    }
    @BeforeMethod
    public void setupMethod(){

        driver = new BrowserService().getDriver();
    }
    @AfterMethod
    public void tearDownMethod(){
        driver.quit();
    }
}