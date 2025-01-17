package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity9 {

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
			driver.findElement(By.xpath("//div[contains(@class,'wp-menu-name') and contains(text(),'Job Listings ')]")).click();						
			driver.findElement(By.xpath("//a[contains(@class,'page-title-action')]")).click();
			driver.findElement(By.id("post-title-0")).sendKeys("API Tester");
			driver.findElement(By.xpath("//*[contains(@class,'components-button editor-post-publish-panel__toggle editor-post-publish-button__button is-primary')]")).click();
			driver.findElement(By.xpath("//*[contains(@class,'components-button editor-post-publish-button editor-post-publish-button__button is-primary')]")).click();
			driver.findElement(By.xpath("//*[contains(@class,'components-button edit-post-fullscreen-mode-close has-icon')]")).click();
			Assert.assertEquals(driver.findElement(By.xpath("//a[contains(text(),'API Tester')][1]")).getText(), "API Tester");
		}
		 
		
		@AfterClass
		public void end() {
			driver.quit();
		}
}
