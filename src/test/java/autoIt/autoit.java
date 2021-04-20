package autoIt;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import resources.base;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
//this is for file upload and download
public class autoit  {
    String downloadPath = System.getProperty("user.dir");
    HashMap<String, Object> chromePrefs = new HashMap<String, Object>();

    @Test
    public void uploadfile() throws InterruptedException, IOException {


        chromePrefs.put("profile.default_content_settings.popups", 0);

        chromePrefs.put("download.default_directory", downloadPath);

        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", chromePrefs);
        System.setProperty("webdriver.chrome.driver", "C://chromedriver.exe");
        WebDriver driver= new ChromeDriver(options);
        driver.get("https://www.investintech.com/pdftojpg");
        driver.findElement(By.id("dzupload")).click();
        Thread.sleep(3000);
        Runtime.getRuntime().exec("C:\\Users\\ahmed\\Desktop\\uber.exe");
        WebDriverWait wait = new WebDriverWait(driver, 100);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("dl-file")));

        driver.findElement(By.id("dl-file")).click();


        Thread.sleep(5000);

        File f = new File(downloadPath + "/1099k2019.jpg");

        if (f.exists()) {

            Assert.assertTrue(f.exists());

            if (f.delete())

                System.out.println("file deleted");

        }

    }
}