import org.junit.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import java.util.*;  


public class DecathlonTest {
    public WebDriver driver;
    
    @Before
    public void setup() {
        

        WebDriverManager.chromedriver().setup();
        System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");
      
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    
    @Test 
    public void testMainPageIContentLoaded(){
        MainPage mainPage = new MainPage(this.driver);
        mainPage.getMainPageIContent();
        Assert.assertTrue(mainPage.getMainPageIContent().getText().contains("Használt sportszer adásvétel!"));
    }

    @Test 
    public void testPageTitle(){
        MainPage mainPage = new MainPage(this.driver);

        System.out.println("Page title is : " + driver.getTitle());
        Assert.assertEquals(driver.getTitle(), "Decathlon Webáruház");
    }    
    
    
    @Test
    public void testLogIn() {
        
        MainPage mainPage = new MainPage(this.driver);
        LoginPage loginPage = mainPage.openLogin();
        
        DashboardPage dashboardPage = loginPage.loginToDashboard();

        //wait for page load
        //WebDriverWait wait = new WebDriverWait(driver, 15);
        //wait.until(ExpectedConditions.elementToBeClickable(dashboardPage.getNameCardBy()));
        
        dashboardPage.waitAndReturnElement(dashboardPage.getNameCardBy());
    
        System.out.println("Redirected to: " + driver.getCurrentUrl());
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.decathlon.hu/hu/viewprofile");
        
    }
    


    
    @After
    public void close() {
        if (driver != null) {
            driver.quit();
        }
    }
}
