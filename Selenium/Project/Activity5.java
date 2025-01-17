package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity5 {

	WebDriver driver;
	@BeforeClass
		
		public void start() {
			driver = new FirefoxDriver();
			driver.get("https://alchemy.hguy.co/jobs/");
			System.out.println("The title of the page is : "+driver.getTitle());
			
			
		}
		@Test
		public void openjobs() {
			WebElement jobs=driver.findElement(By.linkText("Jobs"));
			jobs.click();
			System.out.println("The Jobs page title is : "+driver.getTitle());
			
			Assert.assertEquals(driver.getTitle(),"Jobs – Alchemy Jobs");
		
		}
		 
		@AfterClass
		public void end() {
			driver.quit();
		}
}
