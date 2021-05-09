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


class PageBase {
    protected WebDriver driver;
    protected WebDriverWait wait;
    
    protected By bodyBy = By.tagName("body");

    private By nameInputBoxBy = By.id("input-email");
    private By passwordInputBoxBy = By.id("input-password");
    private By sendDataButtonBy = By.id("lookup-btn-container");
    private By acceptButtonBy = By.id("didomi-notice-agree-button");

    //change these to existing user password pair in order to pass the tests
    private String username = "testuser";
    private String password = "testpass";
    
    public PageBase(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
    }
    
    protected WebElement waitAndReturnElement(By locator) {
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        return this.driver.findElement(locator);
    } 
    
    public String getBodyText() {
        WebElement bodyElement = this.waitAndReturnElement(bodyBy);
        return bodyElement.getText();
    }

    public void setusername(String u){
        this.username = u;
    }

    public void setpassword(String p){
        this.password = p;
    }

    public void acceptCookieTerms(){
        this.waitAndReturnElement(acceptButtonBy).click();

    }

    public void login(){
        WebElement sendButton = this.waitAndReturnElement(sendDataButtonBy);

        this.waitAndReturnElement(nameInputBoxBy).sendKeys(username);
        sendButton.click();

        this.waitAndReturnElement(passwordInputBoxBy).sendKeys(password+"\n");
        sendButton.click();

    }


   
}
