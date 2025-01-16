package StepDefinitions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class GoogleSearchSteps {

	WebDriver driver = new FirefoxDriver();
	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
	
	@Given("User is on Google Home Page")
	public void user_on_google_home_page() {
		driver.get("https://www.google.com");
	}

	@When("User types in Cheese and hits ENTER")
	public void user_types_something() {
		driver.findElement(By.xpath("//*[contains(@class,'gLFyf')]")).sendKeys("Cheese and hits");
		Actions act=new Actions(driver);
		act.sendKeys(Keys.ENTER).perform();
	}

	@Then("Show how many search results were shown")
	public void show_search_results() {
		wait.until(ExpectedConditions.elementToBeClickable(By.id("hdtb-tls"))).click();
        String resultStats = driver.findElement(By.id("result-stats")).getText();
        System.out.println("Number of results found: " + resultStats);
	}
	
	@And("Close the browser")
	public void close() {
		driver.quit();
	}
}
