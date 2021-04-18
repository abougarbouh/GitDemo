package resources;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class base {
        public WebDriver driver;
        public Properties prop;
    public WebDriver initializeDriver() throws IOException {
         prop = new Properties();
        FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\data.properties");

        prop.load(fis);

        //mvn test -Dbrowser=chrome
      //String browserName= System.getProperty("browser"); // to run browser from mvn command
        String browserName =prop.getProperty("browser"); // this will run browser from properties file

        System.out.println(browserName);

        if (browserName.contains("chrome")){ //execute in chrome
            System.setProperty("webdriver.chrome.driver", "src/main/java/resources/chromedriver.exe");
            ChromeOptions options= new ChromeOptions(); //this will open browser without opening the browser
            if (browserName.contains("headless")) {

               options.addArguments("headless");

            }
            driver = new ChromeDriver(options);

        }else if (browserName.equals("firefox")){
            System.setProperty("webdriver.gecko.driver","src/main/java/resources/geckodriver.exe"); // execute in firfox
             driver = new FirefoxDriver();

        }else if (browserName.equals("IE")){
            System.setProperty("webdriver.ie.driver", "src/main/java/resources/IEDriverServer.exe");
             driver=new InternetExplorerDriver();
        }
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); // don't fail scripts withing 10 second

        return driver;


    }

    public String getScreenShotPath(String testCaseName, WebDriver driver) throws IOException {
       TakesScreenshot ts = (TakesScreenshot) driver;
       File source = ts.getScreenshotAs(OutputType.FILE);
       String path = System.getProperty("user.dir")+"\\reports\\"+testCaseName+".png";
        FileUtils.copyFile(source, new File(path));
        return path;
    }


    }




