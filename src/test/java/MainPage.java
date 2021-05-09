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


class MainPage extends PageBase {

    private By loginMenuButtonBy = By.id("header-compte-menu-link");
    private By iContentBy = By.xpath("//div[@class = 'i-content']");


    public MainPage(WebDriver driver) {
        super(driver);
        this.driver.get("https://www.decathlon.hu/");

    }    

    public WebElement getMainPageIContent(){
        return this.waitAndReturnElement(iContentBy);
    }
    
    public LoginPage openLogin() {
        
        this.acceptCookieTerms();
        this.waitAndReturnElement(loginMenuButtonBy).click();
        return new LoginPage(this.driver);
    }

    public By getIContentBy(){
        return iContentBy;
    }
}
