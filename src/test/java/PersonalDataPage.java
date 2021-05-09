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

class PersonalDataPage extends PageBase {

    private By fnameInputBoxBy = By.id("IDENTITY-firstname");
    private By lnameInputBoxBy = By.id("IDENTITY-lastname");

    private By fnameInputBoxReadBy = By.id("readonly-IDENTITY-firstname");
    private By lnameInputBoxReadBy = By.id("/html/body/div[4]/div[6]/div[3]/div[2]/div[1]/div[1]/div/div[3]/div[2]/div");

    private By sendDataButtonBy = By.xpath("//button[@type='submit' and @class='cta right small sport-user-readonly-btn-submit']");
    private By navigateToSendDataButtonBy = By.xpath("//button[@type='button' and @class='cta right small sport-user-readonly-btn-edit']");
    private By alertWrapperBy = By.id("alert-wrapper");

    public PersonalDataPage(WebDriver driver) {
        super(driver);
        this.driver.get("https://www.decathlon.hu/hu/updateCustomer?currentMenu=MenuMyAccountWebLinkInfosPerso");
    }    

    public void goToChangePersonalDataForm(){
        this.waitAndReturnElement(navigateToSendDataButtonBy).click();

    }
    
    public void changePersonalData(String lname, String fname){
        
        WebElement lname_web = this.waitAndReturnElement(lnameInputBoxBy);
        WebElement fname_web = this.waitAndReturnElement(fnameInputBoxBy);

        lname_web.clear();
        fname_web.clear();
        lname_web.sendKeys(lname);
        fname_web.sendKeys(fname);

        this.waitAndReturnElement(sendDataButtonBy).click();
    }

    public String getLastName(){
        return this.waitAndReturnElement(lnameInputBoxReadBy).getText();
    }

    public String getFirstName(){
        return this.waitAndReturnElement(fnameInputBoxReadBy).getText();
    }

    public String getAlertWrapper(){
        return this.waitAndReturnElement(alertWrapperBy).getText();
    }
    
}