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
import org.junit.Assert;
import org.openqa.selenium.Alert;

import java.util.concurrent.TimeUnit;


public class DecathlonTestOnLogin {
    public WebDriver driver;

    
    @Before
    public void setup() {
        
        WebDriverManager.chromedriver().setup();


        System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");

        driver = new ChromeDriver();
        driver.manage().window().maximize();

    }


    
    @Test
    public void testAddAddress() {
        
        // AddressPage addressPage = new AddressPage(this.driver);
        // addressPage.login();
        // try{               
        // Thread.sleep(2000);   
        // }
        // catch(InterruptedException e){

        // }         
        // addressPage.addNewAddres();

        // addressPage.fillAddressForm(
        //     "Test Address",
        //     "Test Street",
        //     "Test Number",
        //     "1133",
        //     "Budapest",
        //     "702345772"
        // );
           
    }
    

    @Test
    public void testChangePersonalDataForm() {
        
        String lname = "Test";
        String fname = "Name";

        PersonalDataPage personalDataPage = new PersonalDataPage(this.driver);
        personalDataPage.login();
        personalDataPage.acceptCookieTerms();
        personalDataPage.goToChangePersonalDataForm();
        personalDataPage.changePersonalData(lname, fname);
        
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        Assert.assertEquals(personalDataPage.getAlertWrapper(), "A változásokat sikeresen elmentettük.");
    }

    


    @Test
    public void testLogOut() {
        
        MainPage mainPage = new MainPage(this.driver);
        LoginPage loginPage = mainPage.openLogin();

        DashboardPage dashboardPage = loginPage.loginToDashboard();
        dashboardPage.logOut();

        dashboardPage.waitAndReturnElement(mainPage.getIContentBy());
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.decathlon.hu/home.html");

           
    }


    
    @After
    public void close() {
        if (driver != null) {
            driver.quit();
        }
    }
}
