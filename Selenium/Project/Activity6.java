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

public class Activity6 {

	WebDriver driver;
	@BeforeClass
		
		public void start() {
			driver = new FirefoxDriver();
			driver.get("https://alchemy.hguy.co/jobs/");
			System.out.println("The title of the page is : "+driver.getTitle());
			
			
		}
		@Test
		public void searchjob() throws InterruptedException {
			WebElement jobs=driver.findElement(By.linkText("Jobs"));
			jobs.click();
			driver.findElement(By.id("search_keywords")).sendKeys("Banking");
			Actions action=new Actions(driver);
			action.sendKeys(Keys.ENTER);
			Thread.sleep(5000);
			driver.findElement(By.xpath("//*[contains(@class,'post-7 page type-page status-publish ast-article-single')]")).click()
;			Thread.sleep(5000);
//			driver.findElement(By.xpath("//h3[contains(text(),'Banking')]")).click();
			driver.findElement(By.xpath("//h3[contains(text(),'Testjob')]")).click();
			driver.findElement(By.xpath("//*[contains(@class,'application_button button')]")).click();
//			
			String email = driver.findElement(By.linkText("ponty@gmail.com")).getText();
			Assert.assertEquals(email, "ponty@gmail.com");
			
			System.out.println("The email is : "+email);
			
			
		}
		 
		@AfterClass
		public void end() {
			driver.quit();
		}
}

