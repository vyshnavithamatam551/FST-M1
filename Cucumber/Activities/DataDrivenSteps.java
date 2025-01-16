package StepDefinitions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;

public class DataDrivenSteps {
	
	    WebDriver driver;
	    WebDriverWait wait;
	    
	    @Given("User is on Login page")
	    public void loginPage() {
	        //Setup instances
	        driver = new FirefoxDriver();
	        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        
	        //Open browser
	        driver.get("https://training-support.net/webelements/login-form");
	    }
	    
	    @When("User enters username and password")
	    public void enterCredentials() {
	        //Enter username
	        driver.findElement(By.id("username")).sendKeys("admin");
	        //Enter password
	        driver.findElement(By.id("password")).sendKeys("password");
	        //Click Login
	        driver.findElement(By.xpath("/html/body/div/main/div/div/div/div/div[2]/form/button")).click();
	    }
	    
	    @When("User enters {string} and {string}")
	    public void user_enters_and(String username, String password) throws Throwable {
	        //Enter username from Feature file
	        driver.findElement(By.id("username")).sendKeys(username);
	        //Enter password from Feature file
	        driver.findElement(By.id("password")).sendKeys(password);
	        //Click Login
	        driver.findElement(By.xpath("/html/body/div/main/div/div/div/div/div[2]/form/button")).click();
	    }
	    
	    @Then("Read the page title and confirmation message")
	    public void readTitleAndHeading() {
	    	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[contains(@class,'text-center font-display text-6xl font-bold text-emerald-500')]")));
		    System.out.println("The title of the page is : "+driver.getTitle());
		    System.out.println("The confirmation page text is : "+driver.findElement(By.xpath("/html/body/div/main/div/div/div/div/div/h1")).getText());
		    Assert.assertEquals("Login Success!", driver.findElement(By.xpath("/html/body/div/main/div/div/div/div/div/h1")).getText());

	    }
	    
	    @And("Close the Browser")
	    public void closeBrowser() {
	        //Close browser
	        driver.close();
	    }


}
