package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity3 {
	
	WebDriver driver;
	
	@BeforeClass
	public void start() {
		driver = new FirefoxDriver();
		driver.get("https://training-support.net/webelements/login-form/");
	}
	 
	@AfterClass
	public void end() {
		driver.close();
	}
	@Test
	public void test() {
		driver.findElement(By.id("username")).sendKeys("admin");
		driver.findElement(By.id("password")).sendKeys("password");
		driver.findElement(By.xpath("/html/body/div/main/div/div/div/div/div[2]/form/button")).click();
		
		Assert.assertEquals("Welcome Back, Admin!", driver.findElement(By.cssSelector("h2.text-center")).getText());
	}
}
