import org.junit.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import java.util.*;  


public class StaticPageTests {
    public WebDriver driver;
    public DashboardPage dashboardPage;

    public String[] URLs = { "https://www.decathlon.hu/hu/aruhaz", "https://www.decathlon.hu/kapcsolat.html"}; //"https://www.decathlon.hu/hu/wishlist
    public String[] ObjectsToCheck = {"//a//span[@class='breadcrumb-label has-children']", "//div//h1[normalize-space()='Segíthetünk?']"}; //"//div//span[@class='whislist-name']"

    
    @Before
    public void setup() {
        
        WebDriverManager.chromedriver().setup();

        System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");

        driver = new ChromeDriver();
        driver.manage().window().maximize();

        MainPage mainPage = new MainPage(this.driver);
        LoginPage loginPage = mainPage.openLogin();
        
        dashboardPage = loginPage.loginToDashboard();
    

    }


    @Test
    public void staticTests() {
        

        for (int i = 0; i < URLs.length; ++i){
            driver.get(URLs[i]);
            dashboardPage.waitAndReturnElement(By.xpath(ObjectsToCheck[i]));
        }          
   
    }

    
    @After
    public void close() {
        if (driver != null) {
            driver.quit();
        }
    }
}
