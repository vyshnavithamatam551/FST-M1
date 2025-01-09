package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity1 {

	WebDriver driver;
	
	@BeforeClass
	public void start() {
		driver = new FirefoxDriver();
		driver.get("https://training-support.net");
	}
	 
	@AfterClass
	public void end() {
		driver.close();
	}
	
	@Test(priority = 0)
	public void trainingsupport() throws InterruptedException {
		System.out.println("The title of the page is : "+driver.getTitle());
		Assert.assertEquals(driver.getTitle(), "Training Support");
		driver.findElement(By.xpath("//a[contains(text(),'About Us')]")).click();
		Thread.sleep(2000);
		System.out.println("The title of new page is : "+driver.getTitle());
		Assert.assertEquals(driver.getTitle(), "About Training Support");
	}
	
	@Test(priority = 1,enabled = false)
	public void aboutus() {
		driver.findElement(By.xpath("//a[contains(text(),'About Us')]")).click();
		System.out.println("The title of new page is : "+driver.getTitle());
		Assert.assertEquals(driver.getTitle(), "About Training Support");
	}
	
	
}
