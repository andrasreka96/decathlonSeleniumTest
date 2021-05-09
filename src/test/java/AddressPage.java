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


class AddressPage extends PageBase {

    private By addNewAddressBy= By.xpath("/html/body/div[3]/div[6]/div[3]/div[2]/div[1]/div[1]/div/a");

    private By addressBy = By.name("SHIPPING-ADDRESS-title");
    private By streetBy = By.name("SHIPPING-ADDRESS-line1");
    private By houseNrBy = By.name("SHIPPING-ADDRESS-line2");
    private By zipCodeBy = By.name("SHIPPING-ADDRESS-postalcode");
    private By phoneNumberBy = By.name("SHIPPING-ADDRESS-mobile-value");

    private By cityDropDownButtonBy = By.xpath("//div[@class = 'dropdown']");

    public AddressPage(WebDriver driver) {
        super(driver);
        this.driver.get("https://www.decathlon.hu/hu/addressBook?currentMenu=MenuMyAccountWebLinkAddresses");

    } 

    public void addNewAddres() {
        
        this.waitAndReturnElement(addNewAddressBy).click();

    }   
    
    public void fillAddressForm(String address, String street, String HouseNr,
    String zipCode, String city, String phoneNumber) {
        
        this.waitAndReturnElement(addressBy).sendKeys(address);
        this.waitAndReturnElement(streetBy).sendKeys(street);
        this.waitAndReturnElement(houseNrBy).sendKeys(HouseNr);
        this.waitAndReturnElement(zipCodeBy).sendKeys(zipCode);
        this.waitAndReturnElement(phoneNumberBy).sendKeys(phoneNumber);

        WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(cityDropDownButtonBy));

        this.waitAndReturnElement(cityDropDownButtonBy).click();

        this.waitAndReturnElement(By.xpath("//ul//a[@class=" + city + "]")).click();

    }
}
