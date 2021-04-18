package AcadmyTest;
import org.apache.logging.log4j.*;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.LandingPage;
import resources.base;

import java.io.IOException;

public class validateNavigationBar extends base {
    public WebDriver driver;
    private static Logger Log = (Logger) LogManager.getLogger(base.class.getName());

    @BeforeTest
    public void initialize() throws IOException {
        driver =initializeDriver();
        driver.get(prop.getProperty("url"));

    }
    @Test
    public void validateNavigationBar() throws IOException {

        LandingPage landing = new LandingPage(driver);
        // compare text from the browser with the actaul text
        Assert.assertTrue(landing.getNavigationBar().isDisplayed());
        Log.info("navigation bar is displayed");


    }
    @AfterTest
    public void teardown(){
        driver.close();
    }
}
