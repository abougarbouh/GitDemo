package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    public WebDriver driver;


    private By email = By.id("user_email");
    private By password = By.id("user_password");
    private By getLogin = By.cssSelector("input[value='Log In']");
    private By forgotPassword=By.cssSelector("a[href*='password/new']");




    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }


    public WebElement getEmail() {
        return driver.findElement(email);
    }

    public WebElement getPassword() {
        return driver.findElement(password);
    }
    public WebElement getLogin() {
        return driver.findElement(getLogin);
    }

    public forgotpassword forgotpassword(){     //this will creat a methothd wich will element having to creat new bag object.
         driver.findElement(forgotPassword).click();
        return new forgotpassword(driver);
    }
}
