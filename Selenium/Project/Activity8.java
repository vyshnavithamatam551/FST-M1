package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity8 {

	WebDriver driver;
	@BeforeClass
		
		public void start() {
			driver = new FirefoxDriver();
			driver.get("https://alchemy.hguy.co/jobs/wp-admin");
			System.out.println("The title of the page is : "+driver.getTitle());
			
			
		}
		@Test
		public void login() throws InterruptedException {
			driver.findElement(By.xpath("//input[contains(@id,'user_login')]")).sendKeys("root");
			driver.findElement(By.xpath("//input[contains(@id,'user_pass')]")).sendKeys("pa$$w0rd");
			driver.findElement(By.xpath("//input[contains(@id,'wp-submit')]")).click();
			Thread.sleep(2000);
			System.out.println("The title of page after login is "+driver.getTitle());
						
		}
		 
		@AfterClass
		public void end() {
			driver.quit();
		}
}
