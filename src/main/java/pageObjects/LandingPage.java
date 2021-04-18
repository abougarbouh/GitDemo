package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {
    public WebDriver driver;



 private By signin=  By.xpath("//span[normalize-space()='Login']");
 private By title=  By.cssSelector("div[class='text-center'] h2");
 private By navbar=  By.cssSelector("ul[class='nav navbar-nav navbar-right']");
 private By header= By.cssSelector("div[class*=' video-banner'] h3");
 private By popup= By.xpath("//button[normalize-space()='NO THANKS']");




    public LandingPage(WebDriver driver) {
        this.driver=driver;
    }

    public WebElement getLogin(){
      return driver.findElement(signin);

  }
    public WebElement getNavigationBar(){
        return driver.findElement(navbar);

    }
    public WebElement getTitle(){
        return driver.findElement(title);

    }
    public WebElement getHeader(){
        return driver.findElement(header);

    }
    public int getPopUpSize(){
        return driver.findElements(popup).size();

    }
    public WebElement getPopUp(){
        return driver.findElement(popup);

    }
}
