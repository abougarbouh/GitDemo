package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class forgotpassword {
    public WebDriver driver;

    private By email = By.id("user_email");
    private By sendMeInstructions = By.cssSelector("input[name='commit']");

    public forgotpassword(WebDriver driver) {
        this.driver = driver;
    }


    public WebElement getEmail() {
        return driver.findElement(email);


    }

    public WebElement sendMeInstructions() {
        return driver.findElement(sendMeInstructions);


    }
}