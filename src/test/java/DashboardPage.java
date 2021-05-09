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


class DashboardPage extends PageBase {

    private By nameCardBy = By.xpath("//div[@class='name']");
    private By logOutBy = By.xpath("//a[@id = 'menu-my-account-disconnect']");


    public DashboardPage(WebDriver driver) {
        super(driver);
    }    

    public String getNameCard(){
        return this.waitAndReturnElement(nameCardBy).getText();
    }

    public void logOut(){
        this.waitAndReturnElement(logOutBy).click();

    }

    public By getNameCardBy(){
        return nameCardBy;
    }
}
