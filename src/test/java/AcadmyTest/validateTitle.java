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

public class validateTitle extends base {
    public WebDriver driver;
    private static Logger Log = (Logger) LogManager.getLogger(base.class.getName());
    LandingPage landing;

    @BeforeTest
    public void initialize() throws IOException {
        driver = initializeDriver();
        Log.info("Driver is initialized");
        driver.get(prop.getProperty("url"));
        Log.info("navigated to Home page");
    }
    @Test
    public void ValidateWebTitle() throws IOException {

         landing = new LandingPage(driver);
        // compare text from the browser with the actaul text
        Assert.assertEquals(landing.getTitle().getText(), "FEATURED COURSES");
        Log.info("Successfully validated Text message");

    }
    @Test
    public void ValidateHeader() throws IOException {
        landing = new LandingPage(driver);

        // compare text from the browser with the actaul text
        Assert.assertEquals(landing.getHeader().getText(), "AN ACADEMY TO LEARN EVERYTHING ABOUT TESTING");

    }
    @AfterTest
    public void teardown(){
        driver.close();
    }
}
