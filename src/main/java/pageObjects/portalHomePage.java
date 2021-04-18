package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class portalHomePage {
    public WebDriver driver;


    private By searchBox = By.id("//input[@id='search-courses']");



    public portalHomePage(WebDriver driver) {
        this.driver = driver;
    }


    public WebElement getSearchBox() {
        return driver.findElement(searchBox);
    }

}
