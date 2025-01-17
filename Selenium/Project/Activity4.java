package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity4 {

	WebDriver driver;
	@BeforeClass
		
		public void start() {
			driver = new FirefoxDriver();
			driver.get("https://alchemy.hguy.co/jobs/");
			System.out.println("The title of the page is : "+driver.getTitle());
			
			
		}
		@Test
		public void getsecondheader() {
			String text=driver.findElement(By.xpath("//h2[contains(text(),'Quia quis non')]")).getText();
			System.out.println("The second header is : "+text);
			Assert.assertEquals(text, "Quia quis non");
		}
		 
		@AfterClass
		public void end() {
			driver.quit();
		}
}
