package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;



public class Activity2 {
	
		WebDriver driver;
		
		@BeforeClass
		public void start() {
			driver = new FirefoxDriver();
			driver.get("https://training-support.net/webelements/target-practice/");
		}
		 
		@AfterClass
		public void end() {
			driver.close();
		}
		@Test
		public void test1() {
			Assert.assertEquals(driver.getTitle(), "Selenium: Target Practice");
		}
		@Test
		public void test2() {
			WebElement blackButton = driver.findElement(By.cssSelector("button.black"));
	        Assert.assertTrue(blackButton.isDisplayed());
	        Assert.assertEquals(blackButton.getText(), "black");
		}
		@Test(enabled = false)
		public void test3() {
			System.out.println("This will be skiipped and not shown in console");
		}
		@Test
		public void test4() {
			throw new SkipException("This test will be skipped and shown in console");
		}
}
