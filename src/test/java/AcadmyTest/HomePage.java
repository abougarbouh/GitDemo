package AcadmyTest;
import org.apache.logging.log4j.*;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import pageObjects.forgotpassword;
import resources.base;
import org.testng.annotations.Test;

import java.io.IOException;

public class HomePage extends base {
    public WebDriver driver;
    private static Logger Log = (Logger) LogManager.getLogger(base.class.getName());


    @BeforeTest
    public void initialize() throws IOException {
        driver =initializeDriver();

    }

    @Test(dataProvider ="getData" )
    public void basePageNavigation(String Username, String Password, String text) throws IOException {
        driver.get(prop.getProperty("url"));
        LandingPage landing = new LandingPage(driver);
        landing.getLogin().click();
        LoginPage lp =new LoginPage(driver);
        lp.getEmail().sendKeys(Username);
        lp.getPassword().sendKeys(Password);
        lp.getLogin().click();
        Log.info(text);
        forgotpassword fp=lp.forgotpassword(); ///special method to click on forget password
        fp.getEmail().sendKeys("xxx");
        fp.sendMeInstructions().click();



    }
    @DataProvider
    public Object[][] getData(){
        // Rows stands for how many different dada types test should run
        // coloum stands for how many values per each test
        Object[][] data =new Object[2][3]; // i have 2 arrays and 3 inputs

        //0th row
        data[0][0]="restrecteduser@qw.com";
        data[0][1]="123456";
        data[0][2]="restricted User";

        //first data
        data[1][0]="Nonrestrecteduser@qw.com";
        data[1][1]="123466";
        data[1][2]="Nonrestrected users";

        return data;

    }
    @AfterTest
    public void teardown(){
        driver.close();
    }
}
