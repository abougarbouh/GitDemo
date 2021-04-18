package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import pageObjects.portalHomePage;
import resources.base;


public class stepDefination extends base {
    @Given("Initialize the browser with chrome")
    public void initialize_the_browser_with_chrome() throws Throwable {
        driver =initializeDriver();
    }
    @Given("Navigate to {string} Site")
    public void navigate_to_site(String url) {
        driver.get(url);
        LandingPage l = new LandingPage(driver);
        if (l.getPopUpSize()>0){
            l.getPopUp().click();
        }

    }
    @Given("Click on Login link in home page to land on secure sign in Page")
    public void click_on_login_link_in_home_page_to_land_on_secure_sign_in_page() {
        LandingPage landing = new LandingPage(driver);
        landing.getLogin().click();
    }

    @When("^User enters (.+) and (.+) and logs in$")
    public void user_enters_and_and_logs_in(String username, String password)  {
        LoginPage lp =new LoginPage(driver);
        lp.getEmail().sendKeys(username);
        lp.getPassword().sendKeys(password);
        lp.getLogin().click();

    }
    @And("^close browser$")
    public void close_browser()  {
        driver.quit();
        driver.close();
    }
    @Then("Verify that user is successfully logged in")
    public void verify_that_user_is_successfully_logged_in() {
        portalHomePage p = new portalHomePage(driver);
       Assert.assertTrue(p.getSearchBox().isDisplayed());
       //i want to see it in gethub
        // pushing code form GitDeom
    }



}
