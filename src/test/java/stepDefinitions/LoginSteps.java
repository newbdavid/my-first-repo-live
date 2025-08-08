package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class LoginSteps {
    WebDriver driver;

    @Before
    public void setup(){
        driver = new ChromeDriver();
    }
    @After
    public void tearDown(){
        if(driver!= null){
            driver.quit();
        }
    }
    @Given("I am on the login page")
    public void iAmOnTheLoginPage(){

        driver.get("https://the-internet.herokuapp.com/login");
    }

    @When("I type username {string} and password {string}")
    public void iTypeUsernameAndPassword(String username, String password){
        driver.findElement(By.id("username")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
    }

    @And("I click on the login button")
    public void iCliCkOnTheLoginButton(){
        driver.findElement(By.cssSelector("button.radius")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(7));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.tagName("h2")));
    }
    @Then("I will see the heading {string}")
    public void iWillSeeTheHeading(String expectedHeading){
        String actualHeader = driver.findElement(By.tagName("h2")).getText();
        Assert.assertEquals(actualHeader,expectedHeading);
    }
    @Then("I should see an error message")
    public void iShouldSeeAnErrorMessage(){

    }

}
