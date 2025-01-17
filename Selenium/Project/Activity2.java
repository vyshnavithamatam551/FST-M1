package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity2 {

	WebDriver driver;
@BeforeClass
	
	public void start() {
		driver = new FirefoxDriver();
		driver.get("https://alchemy.hguy.co/jobs/");
		System.out.println("The title of the page is : "+driver.getTitle());
		
		
	}
	@Test
	public void headline() {
		String headline=driver.findElement(By.xpath("//*[contains(@class,'entry-title')]")).getText();
		Assert.assertEquals(headline, "Welcome to Alchemy Jobs");
	}
	 
	@AfterClass
	public void end() {
		driver.quit();
	}
}
